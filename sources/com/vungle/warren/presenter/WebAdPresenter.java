package com.vungle.warren.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebViewClient;
import android.widget.VideoView;
import com.vungle.warren.DirectDownloadAdapter;
import com.vungle.warren.Storage;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Advertisement.Checkpoint;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.Report;
import com.vungle.warren.network.VungleApiClient;
import com.vungle.warren.p267ui.AdView;
import com.vungle.warren.p267ui.VungleWebClient;
import com.vungle.warren.p267ui.VungleWebClient.MRAIDDelegate;
import com.vungle.warren.presenter.AdvertisementPresenter.EventListener;
import com.vungle.warren.utility.UnzipUtility;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicBoolean;

public class WebAdPresenter implements AdvertisementPresenter, MRAIDDelegate {
    private static String EXTRA_CONTENT_PREPARED = "content_prepared";
    private static final String EXTRA_INCENTIVIZED_SENT = "incentivized_sent";
    private static String EXTRA_REPORT = "saved_report";
    private static final String EXTRA_WEB_READY = "web_ready";
    protected static final double NINE_BY_SIXTEEN_ASPECT_RATIO = 0.5625d;
    /* access modifiers changed from: private */
    public static final String TAG = WebAdPresenter.class.getCanonicalName();
    private AdView adView;
    private Advertisement advertisement;
    private File assetDir;
    /* access modifiers changed from: private */
    public boolean backEnabled;
    private EventListener bus;
    private DirectDownloadAdapter directDownloadAdapter;
    private boolean directDownloadApkEnabled;
    private float duration;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean hasSend80Percent = false;
    private boolean hasSendStart = false;
    private AtomicBoolean isDestroying = new AtomicBoolean(false);
    private boolean muted;
    private Placement placement;
    private boolean prepared = false;
    /* access modifiers changed from: private */
    public Report report;
    private AtomicBoolean sendReportIncentivized = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public Storage storage;
    private String userID;
    private VungleWebClient webClient;

    private WebAdPresenter() throws IllegalAccessException {
        throw new IllegalAccessException("Use the parametrized constructor for creating a WebAdPresenter!");
    }

    public WebAdPresenter(Advertisement advertisement2, Placement placement2, Storage storage2, File assetDir2, String userId) {
        this.advertisement = advertisement2;
        this.storage = storage2;
        this.assetDir = assetDir2;
        this.placement = placement2;
        this.userID = userId;
    }

    public void setEventListener(EventListener listener) {
        this.bus = listener;
    }

    public void setDirectDownloadAdapter(DirectDownloadAdapter directDownloadAdapter2) {
        this.directDownloadAdapter = directDownloadAdapter2;
    }

    public void reportError(String error) {
        this.report.recordError(error);
    }

    public void reportAction(String action, String value) {
        this.report.recordAction(action, value, System.currentTimeMillis());
        this.storage.save(this.report);
    }

    public WebViewClient getWebViewClient() {
        return this.webClient;
    }

    public void notifyPropertiesChanged() {
        this.adView.updateWindow(this.advertisement.getTemplateType().equals("flexview"));
        this.webClient.notifyPropertiesChange(true);
    }

    public void initializeViewabilityTracker(int videoDuration, VideoView videoView) {
    }

    public void stopViewabilityTracker() {
    }

    public void attach(AdView adView2) {
        boolean z = false;
        this.isDestroying.set(false);
        this.adView = adView2;
        int settings = this.advertisement.getAdConfig().getSettings();
        if (settings > 0) {
            this.muted = (settings & 1) == 1;
            this.backEnabled = (settings & 2) == 2;
            if ((settings & 32) == 32) {
                z = true;
            }
            this.directDownloadApkEnabled = z;
        }
        int requestedOrientation = -1;
        if ((this.advertisement.getAdConfig().getSettings() & 16) != 16) {
            int orientation = this.advertisement.getOrientation();
            if (orientation == 0) {
                requestedOrientation = 1;
            } else if (orientation == 1) {
                requestedOrientation = 0;
            } else if (orientation == 2) {
                requestedOrientation = 4;
            }
        } else {
            requestedOrientation = 4;
        }
        adView2.setOrientation(requestedOrientation);
    }

    public void prepare(Bundle savedState) {
        Bundle bundle = savedState;
        EventListener eventListener = this.bus;
        String str = null;
        if (eventListener != null) {
            eventListener.onNext("start", null);
        }
        boolean collectConsent = false;
        if (bundle != null) {
            this.prepared = bundle.getBoolean(EXTRA_CONTENT_PREPARED, false);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.assetDir.getPath());
        sb.append(File.separator);
        sb.append(Advertisement.KEY_TEMPLATE);
        loadMraid(new File(sb.toString()));
        Cookie incentivizedCookie = (Cookie) this.storage.load(Cookie.INCENTIVIZED_TEXT_COOKIE, Cookie.class);
        String str2 = "flexview";
        if (str2.equals(this.advertisement.getTemplateType()) && this.advertisement.getAdConfig().getFlexViewCloseTime() > 0) {
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    long closeTime = System.currentTimeMillis();
                    String str = "";
                    WebAdPresenter.this.report.recordAction("mraidCloseByTimer", str, closeTime);
                    WebAdPresenter.this.report.recordAction("mraidClose", str, closeTime);
                    WebAdPresenter.this.storage.save(WebAdPresenter.this.report);
                    WebAdPresenter.this.closeView();
                }
            }, (long) (this.advertisement.getAdConfig().getFlexViewCloseTime() * 1000));
        }
        if (incentivizedCookie != null) {
            str = incentivizedCookie.getString("userID");
        }
        Report report2 = new Report(this.advertisement, this.placement, System.currentTimeMillis(), str);
        this.report = report2;
        this.webClient = new VungleWebClient(this.advertisement, this.placement, this.directDownloadAdapter);
        this.webClient.setMRAIDDelegate(this);
        Cookie gdprConsent = (Cookie) this.storage.load(Cookie.CONSENT_COOKIE, Cookie.class);
        if (gdprConsent != null) {
            String str3 = "consent_status";
            if (gdprConsent.getBoolean("is_country_data_protected").booleanValue()) {
                if ("unknown".equals(gdprConsent.getString(str3))) {
                    collectConsent = true;
                }
            }
            this.webClient.setConsentStatus(collectConsent, gdprConsent.getString("consent_title"), gdprConsent.getString("consent_message"), gdprConsent.getString("button_accept"), gdprConsent.getString("button_deny"));
            if (collectConsent) {
                gdprConsent.putValue(str3, "opted_out_by_timeout");
                this.storage.save(gdprConsent);
            }
        }
        int delay = this.advertisement.getShowCloseDelay(this.placement.isIncentivized());
        if (delay > 0) {
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    WebAdPresenter.this.backEnabled = true;
                }
            }, (long) delay);
        } else {
            this.backEnabled = true;
        }
        this.adView.updateWindow(this.advertisement.getTemplateType().equals(str2));
    }

    private void loadMraid(File template) {
        StringBuilder sb = new StringBuilder();
        sb.append(template.getParent());
        sb.append(File.separator);
        sb.append("templateUnzip");
        File dest = new File(sb.toString());
        if (!this.prepared) {
            try {
                UnzipUtility.unzip(template.getPath(), dest.getPath());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(dest.getPath());
                sb2.append(File.separator);
                sb2.append("mraid.js");
                File mraidJS = new File(sb2.toString());
                if (!mraidJS.exists()) {
                    EventListener eventListener = this.bus;
                    if (eventListener != null) {
                        eventListener.onError(new VungleException(10));
                    }
                    closeView();
                    return;
                }
                String str = "!function(e){\"use strict\";var t,r=e.vungle=e.vungle||{};r.error||(t=r.error=r.error||{},t.bridgeError={BRG000:\"Missing command in mraidBridge.executeSDKCommand method call!\",BRG001:\"Vungle SDK is not ready to process MRAID command!\"},t.bridgeExtError={BRX000:\"Cannot retrieve #dynamic container in Ad Unit!\"},t.mraidError={MRD000:\"Cannot add listener for unknown MRAID event!\",MRD001:\"Missing argument(s)! Both event and/or listener are required for method call!\",MRD002:\"Unable to find listener registered for event!\",MRD003:\"Missing MRAID event! Cannot remove event listener!\",MRD004:\"Missing object! An expand properties object is required for method call!\",MRD005:\"Missing object! An orientation properties object is required for method call!\",MRD006:\"Missing object! An resize properties object is required for method call!\",MRD007:\"Missing URL! A URL is required for method call!\",MRD008:\"Ad unit is hidden and cannot be closed!\",MRD009:\"Missing URL! A video/caption URL is required for method call!\",MRD010:\"Ad Unit is not viewable! Please make sure isViewAble is set to true!\",MRD011:\"Ad unit can only be expanded from the default or resized state!\",MRD012:\"Ad unit can only be resized from the default or resized state!\",MRD013:\"Missing URI! A valid URI is required for method call!\",MRD015:\"Invalid data/type detected when updating MRAID properties!\",MRD016:\"Missing app store id! An app store id is required for method call!\"},t.mraidClientError={MRC000:\"MRAID SDK error detected!\",MRC001:\"Missing MRAID object in window!\",MRC002:\"Missing video URL!  mraidClient.playVideo cannot retrieve video URL from arguments!\"},t.adTemplateError={ADT000:\"Missing page template JavaScript!\",ADT001:\"Error encountered loading template configuration!\"},t.gestureTrackingError={GET000:\"Cannot serialize user interaction tracking event object!\"})}(window),function(e){\"use strict\";var t=e.vungle=e.vungle||{},r=t.mraidCore=t.mraidCore||{},n=t.debugLog=t.debugLog||[];n&&n.push(\"vungle.mraidCore loaded.\"),r.consts={versions:{V1:\"1.0\",V2:\"2.0\"},states:{LOADING:\"loading\",DEFAULT:\"default\",RESIZED:\"resized\",EXPANDED:\"expanded\",HIDDEN:\"hidden\"},events:{INFO:\"info\",READY:\"ready\",ERROR:\"error\",STATE_CHANGE:\"stateChange\",ORIENTATION_CHANGE:\"orientationChange\",VIEWABLE_CHANGE:\"viewableChange\",SIZE_CHANGE:\"sizeChange\"},placements:{UNKNOWN:\"unknown\",INLINE:\"inline\",INTERSTITIAL:\"interstitial\"},orientations:{PORTRAIT:\"portrait\",LANDSCAPE:\"landscape\",NONE:\"none\"},closePositions:{CENTER:\"center\",TOP_LEFT:\"top-left\",TOP_CENTER:\"top-center\",TOP_RIGHT:\"top-right\",BOTTOM_LEFT:\"bottom-left\",BOTTOM_CENTER:\"bottom-center\",BOTTOM_RIGHT:\"bottom-right\"}},r.PropertiesValueObject=function(e){var t=function(e){var t;return e&&\"object\"==typeof e?(t={},Object.keys(e).forEach(function(r){t[r]=e[r]})):t=e,t};this.value=t(e),this.clone=function(){return t(this.value)},this.update=function(e){if(e&&\"object\"==typeof e){var t=this;Object.keys(e).forEach(function(r){t.value[r]=e[r]})}else this.value=e}},r.EventListeners=function(e){var t={};this.event=e,this.listenerCount=0,this.add=function(e){var r=String(e);return!t[r]&&(t[r]=e,this.listenerCount++,!0)},this.remove=function(e){var r=String(e);return!(!t.hasOwnProperty(r)||!t[r])&&(t[r]=null,delete t[r],this.listenerCount--,!0)},this.removeAll=function(){var e=this;Object.keys(t).forEach(function(r){e.remove(t[r])})},this.broadcast=function(e){var r=this;Object.keys(t).forEach(function(n){t[n].apply(r.mraid,e)})}};var o=new r.PropertiesValueObject(r.consts.versions.V1),i=new r.PropertiesValueObject({width:0,height:0}),a=new r.PropertiesValueObject({width:0,height:0}),s=new r.PropertiesValueObject({x:0,y:0,width:0,height:0}),d=new r.PropertiesValueObject({x:0,y:0,width:0,height:0}),c=new r.PropertiesValueObject({width:0,height:0,useCustomClose:!1,isModal:!0}),u=new r.PropertiesValueObject({width:0,height:0,offsetX:0,offsetY:0,customClosePosition:r.consts.closePositions.TOP_RIGHT,allowOffscreen:!0}),l=new r.PropertiesValueObject({allowOrientationChange:!0,forceOrientation:r.consts.orientations.NONE}),p=new r.PropertiesValueObject({sms:!1,tel:!1,calendar:!1,storePicture:!1,inlineVideo:!1}),m=new r.PropertiesValueObject(r.consts.states.LOADING),g=new r.PropertiesValueObject(r.consts.placements.UNKNOWN),f=new r.PropertiesValueObject((!1)),E=new r.PropertiesValueObject((!1)),v=new r.PropertiesValueObject((!1)),R=new r.PropertiesValueObject((!1)),y=new r.PropertiesValueObject((!1)),h=new r.PropertiesValueObject((!1)),C=new r.PropertiesValueObject((!1)),D=new r.PropertiesValueObject((!1)),B=new r.PropertiesValueObject((!1)),x=new r.PropertiesValueObject((!1)),P={},O=new r.PropertiesValueObject(\"\"),S=new r.PropertiesValueObject(\"\");r.eventListeners=P,r.propertiesHandlers={os:{update:function(e){O.update(e)},clone:function(){return O.clone()}},osVersion:{update:function(e){S.update(e)},clone:function(){return S.clone()}},incentivized:{update:function(e){E.update(e)},clone:function(){return E.clone()}},consentRequired:{update:function(e){v.update(e)},clone:function(){return v.clone()}},consentTitleText:{update:function(e){R.update(e)},clone:function(){return R.clone()}},consentBodyText:{update:function(e){y.update(e)},clone:function(){return y.clone()}},consentAcceptButtonText:{update:function(e){h.update(e)},clone:function(){return h.clone()}},consentDenyButtonText:{update:function(e){C.update(e)},clone:function(){return C.clone()}},version:{update:function(e){o.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting MRAID version to: \"+String(e))},clone:function(){return o.clone()}},maxSize:{update:function(e){i.update(e),c.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting maxSize to: \"+String(e))},clone:function(){return i.clone()}},screenSize:{update:function(e){var t;a.update(e),t=a.clone(),r.broadcastEvent(r.consts.events.INFO,\"Setting screenSize to: \"+String(e)),r.broadcastEvent(r.consts.events.SIZE_CHANGE,t.width,t.height)},clone:function(){return a.clone()}},defaultPosition:{update:function(e){s.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting defaultPosition to: \"+String(e))},clone:function(){return s.clone()}},currentPosition:{update:function(e){d.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting currentPosition to: \"+String(e))},clone:function(){return d.clone()}},expandProperties:{update:function(e){c.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting expandProperties to: \"+String(e))},clone:function(){return c.clone()}},resizeProperties:{update:function(e){u.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting resizeProperties to: \"+String(e))},clone:function(){return u.clone()}},orientationProperties:{update:function(e){l.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting orientationProperties to: \"+String(e))},clone:function(){return l.clone()}},supports:{update:function(e){p.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting supports to: \"+String(e))},clone:function(){return p.clone()}},state:{update:function(e){m.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting state to: \"+String(e)),r.broadcastEvent(r.consts.events.STATE_CHANGE,m.clone()),m.clone()===r.consts.states.DEFAULT&&r.broadcastEvent(r.consts.events.READY)},clone:function(){return m.clone()}},placementType:{update:function(e){g.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting placementType to: \"+String(e))},clone:function(){return g.clone()}},isViewable:{update:function(e){f.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting isViewable to: \"+String(e)),r.broadcastEvent(r.consts.events.VIEWABLE_CHANGE,f.clone())},clone:function(){return f.clone()}},customClose:{update:function(e){D.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting useCustomClose to: \"+String(e))},clone:function(){return D.clone()}},customPrivacy:{update:function(e){B.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting useCustomPrivacy to: \"+String(e))},clone:function(){return B.clone()}},enableBackImmediately:{update:function(e){x.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting enableBackImmediately to: \"+String(e))},clone:function(){return x.clone()}}},r.propertiesValidator=function(e,r,n){var o=!0;return typeof e!=typeof r&&\"useCustomClose\"!==n?(o=!1,t.mraidBridgeExt&&t.mraidBridgeExt.notifyError([\"MRD015\",n,e].join(\":\"))):\"object\"==typeof e&&Object.keys(e).forEach(function(e){e in r||(o=!1,t.mraidBridgeExt&&t.mraidBridgeExt.notifyError([\"MRD015\",n,e].join(\":\")))}),o},r.broadcastEvent=function(){var e=Array.prototype.slice.call(arguments),t=e.shift(),r=P[t];r&&r.broadcast(e)},r.isValidMARIDEvent=function(e){for(var t in r.consts.events)if(r.consts.events[t]===e)return!0;return!1}}(window),function(e){\"use strict\";var t=e.vungle=e.vungle||{},r=t.mraidBridge=t.mraidBridge||{};r.notifyContainer=function(t){e.location=t}}(window),function(e){\"use strict\";var t,r=e.vungle=e.vungle||{},n=r.mraidBridge=r.mraidBridge||{},o=r.mraidBridgeExt=r.mraidBridgeExt||{},i=r.debugLog=r.debugLog||[],a=!1,s=!1,d=[],c=!1,u=!1,l=!1,p=!1,m=r.mraidCore.broadcastEvent,g=r.mraidCore.consts.states,f=r.mraidCore.consts.events;i&&i.push(\"vungle.mraidBridge loaded.\"),o.getReplacementTokens=function(){return t},o.getIsVungleAd=function(){return c},o.getIsDirectDownload=function(){return u},o.getIsDisplayIAP=function(){return l},o.getIsInstalled=function(){return p},o.getEnableBackButtonImmediately=function(){return r.mraidCore.propertiesHandlers.enableBackImmediately.clone()},n.notifyPropertiesChange=function(e,t){i&&i.push(\"mraidBridge.notifyPropertiesChange:\"+JSON.stringify(e)),Object.keys(e).forEach(function(t){r.mraidCore.propertiesHandlers[t]?r.mraidCore.propertiesHandlers[t].update(e[t]):n.notifyErrorEvent(\"notifyPropertiesChange\",\"MRD015: Unhandled Property received - \"+t+\" - \"+e[t])}),\"undefined\"!=typeof t&&t===!0&&r.mraidBridge.notifyContainer(\"mraid://propertiesChangeCompleted\")},n.notifyCommandComplete=function(){i&&i.push(\"mraidBridge.notifyCommandComplete\");var e=\"\";d.length?(e=d.shift(),r.mraidBridge.notifyContainer(e)):s=!1},n.notifyReadyEvent=function(e){i&&i.push(\"mraidBridge.notifyReadyEvent\");var n=r.mraidCore.propertiesHandlers.state.clone();a=!0,\"undefined\"!=typeof e?(c=!0,p=e.isInstalled,l=e.isDisplayIAP,u=e.isDirectDownload,t=e):r.mraidBridgeExt.notifySuccessfulViewAd(),n!==g.DEFAULT?r.mraidCore.propertiesHandlers.state.update(g.DEFAULT):m(f.READY)},n.notifyErrorEvent=function(e,t){i&&i.push(\"mraidBridge.notifyErrorEvent:\"+e+\":\"+t),m(f.ERROR,e,t)},n.executeSDKCommand=function(){var e,t,o,c=\"\";if(!a)throw n.notifyErrorEvent(c,r.error.bridgeError.BRG001),{name:\"VungleMRAIDBridgeException\",message:\"BRG001\"};if(!arguments)throw n.notifyErrorEvent(c,r.error.bridgeError.BRG000),{name:\"VungleMRAIDBridgeException\",message:\"BRG000\"};for(c+=\"mraid://\"+arguments[0],o=1;o<arguments.length;o+=2)e=arguments[o],t=arguments[o+1],c+=(1===o?\"?\":\"&\")+encodeURIComponent(e),\"undefined\"!=typeof t&&(c+=\"=\"+encodeURIComponent(t));s?d.push(c):(s=!0,r.mraidBridge.notifyContainer(c)),i&&i.push(\"mraidBridge.executeSDKCommand: \"+c)},o.fireVideoCompleteEvent=function(){i&&i.push(\"mraidBridgeExt.fireVideoCompleteEvent\");var t=e.document.querySelector(\"#dynamic\"),r=new e.Event(\"vungle.events.video.ended\");t?t.dispatchEvent(r):o.notifyError(e.vungle.error.bridgeExtError.BRX000)},o.notifyPrepareStoreViewSuccess=function(){i&&i.push(\"mraidBridgeExt.notifyPrepareStoreViewSuccess\");var t=e.document.querySelector(\"#dynamic\"),r=new e.Event(\"vungle.events.preparestore.success\");t?t.dispatchEvent(r):o.notifyError(e.vungle.error.bridgeExtError.BRX000)},o.notifyError=function(t){i&&i.push(\"mraidBridgeExt.notifyError:\"+t);try{r.mraidBridge.executeSDKCommand(\"error\",\"code\",t)}catch(n){\"VungleMRAIDBridgeException\"===n.name?i&&i.push(\"%cVungleMRAIDBridgeException caught in mraidBridgeExt.notifyError! Message: %s\",\"color: red; font-size: x-large\",e.vungle.error.bridgeError[n.message]):i&&i.push(\"%cUnknown Exception caught in mraidBridgeExt.notifyError! Message: %s\",\"color: red; font-size: x-large\",n.message)}},o.notifyTPAT=function(e){i&&i.push(\"mraidBridgeExt.notifyTPATEvent:\"+e);try{r.mraidBridge.executeSDKCommand(\"tpat\",\"event\",e)}catch(t){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.notifyTPAT\",t.message)}},o.consentAction=function(e){i&&i.push(\"mraidBridgeExt.consentActionEvent:\"+e);try{r.mraidBridge.executeSDKCommand(\"consentAction\",\"event\",e)}catch(t){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.consentActionEvent\",t.message)}},o.notifyUserInteraction=function(e,t){i&&i.push(\"mraidBridgeExt.notifyUserInteraction\");try{r.mraidBridge.executeSDKCommand(\"action\",e,t)}catch(n){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.notifyUserInteraction\",n.message)}},o.notifyEventValuePairEvent=function(e,t){i&&i.push(\"mraidBridgeExt.notifyEventValuePairEvent\");var n=e||\"null\",o=t||\"null\";try{r.mraidBridge.executeSDKCommand(\"actionWithValue\",\"event\",n,\"value\",o)}catch(n){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.notifyEventValuePairEvent\",n.message)}},o.playHTML5Video=function(e){i&&i.push(\"mraidBridgeExt.playHTML5Video\");try{r.mraidBridge.executeSDKCommand(\"playHTML5Video\",\"selector\",e)}catch(t){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.playHTML5Video\",t.message)}},o.openPrivacy=function(e){i&&i.push(\"mraidBridgeExt.openPrivacy\");try{r.mraidBridge.executeSDKCommand(\"openPrivacy\",\"url\",e)}catch(t){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.openPrivacy\",t.message)}},o.requestMRAIDClose=function(){i&&i.push(\"mraidBridgeExt.requestMRAIDClose\");try{var e,t=\"windows\"===r.mraidExt.getOS()&&(0===r.mraidExt.getOSVersion().indexOf(\"WinPhone81\")||0===r.mraidExt.getOSVersion().indexOf(\"Win81\")),n=\"android\"===r.mraidExt.getOS()&&parseInt(r.mraidExt.getOSVersion(),10)<=17;t||n?(e=document.createEvent(\"Event\"),e.initEvent(\"vungle.events.request.close\",!0,!0)):e=new Event(\"vungle.events.request.close\"),c?document.querySelector(\"#dynamic\").dispatchEvent(e):r.mraidBridge.executeSDKCommand(\"close\")}catch(o){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.requestMRAIDClose\",o.message)}},o.notifySuccessfulViewAd=function(){i&&i.push(\"mraidBridgeExt.notifySuccessfulViewAd\");try{r.mraidBridge.executeSDKCommand(\"successfulView\")}catch(e){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.notifySuccessfulViewAd\",e.message)}},o.openAppInDevice=function(){i&&i.push(\"mraidBridgeExt.openAppInDevice\");try{r.mraidBridge.executeSDKCommand(\"openAppInDevice\")}catch(e){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.openAppInDevice\",e.message)}},o.openStorePage=function(){i&&i.push(\"mraidBridgeExt.openStorePage\");try{r.mraidBridge.executeSDKCommand(\"openStorePage\")}catch(e){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.openStorePage\",e.message)}},o.cancelDownload=function(){i&&i.push(\"mraidBridgeExt.cancelDownload\");try{r.mraidBridge.executeSDKCommand(\"cancelDownload\")}catch(e){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.cancelDownload\",e.message)}},o.getInstallationStatus=function(t){i&&i.push(\"mraidBridgeExt.getInstallationStatus\");var r=e.document.querySelector(\"#dynamic\"),n=new e.CustomEvent(\"vungle.events.installationStatus.updated\",{detail:t});r?r.dispatchEvent(n):o.notifyError(e.vungle.error.bridgeExtError.BRX000)},o.startDownloadAppOnDevice=function(){i&&i.push(\"mraidBridgeExt.startDownloadAppOnDevice\");try{r.mraidBridge.executeSDKCommand(\"startDownloadAppOnDevice\")}catch(e){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.startDownloadAppOnDevice\",e.message)}}}(window),function(e){\"use strict\";var t=e.vungle=e.vungle||{},r=e.mraid=t.mraid=t.mraid||{},n=t.mraidExt=t.mraidExt||{},o=t.debugLog=t.debugLog||[],i=t.mraidBridge.executeSDKCommand,a=t.mraidCore.broadcastEvent,s=t.mraidCore.propertiesHandlers,d=t.mraidCore.propertiesValidator,c=t.mraidCore.consts.states,u=t.mraidCore.consts.events,l=t.mraidCore.consts.placements;o&&o.push(\"vungle.mraid loaded.\"),r.addEventListener=function(e,r){e&&r?t.mraidCore.isValidMARIDEvent(e)?(t.mraidCore.eventListeners[e]||(t.mraidCore.eventListeners[e]=new t.mraidCore.EventListeners(e)),t.mraidCore.eventListeners[e].add(r)):a(u.ERROR,\"mraid.addEventListener\",t.error.mraidError.MRD000+\":\"+e):a(u.ERROR,\"mraid.addEventListener\",t.error.mraidError.MRD001)},r.removeEventListener=function(e,r){var n,o=!1;e?(n=t.mraidCore.eventListeners[e],r?(n&&(o=n.remove(r)),o||a(u.ERROR,\"mraid.removeEventListener\",t.error.mraidError.MRD002+\":\"+e)):n&&t.mraidCore.eventListeners.removeAll(),n&&0===n.count&&(t.mraidCore.eventListeners[e]=null,delete t.mraidCore.eventListeners[e])):a(u.ERROR,\"mraid.removeEventListener\",t.error.mraidError.MRD003)},n.prepareStoreView=function(e){e?i(\"prepareStoreView\",\"appStoreId\",e):a(u.ERROR,\"mraid.prepareStoreView\",t.error.mraidError.MRD016)},n.presentStoreView=function(e){e?i(\"presentStoreView\",\"appStoreId\",e):a(u.ERROR,\"mraid.presentStoreView\",t.error.mraidError.MRD016)},n.getOS=function(){return s.os.clone()},n.getOSVersion=function(){return s.osVersion.clone()},n.getIncentivized=function(){return s.incentivized.clone()},r.getVersion=function(){return s.version.clone()},r.getMaxSize=function(){return s.maxSize.clone()},r.getScreenSize=function(){return s.screenSize.clone()},r.getDefaultPosition=function(){return s.defaultPosition.clone()},r.getCurrentPosition=function(){return s.currentPosition.clone()},r.getExpandProperties=function(){return s.expandProperties.clone()},r.getResizeProperties=function(){return s.resizeProperties.clone()},r.getOrientationProperties=function(){return s.orientationProperties.clone()},r.supports=function(e){return s.supports.clone()[e]},r.getState=function(){return s.state.clone()},r.getPlacementType=function(){return s.placementType.clone()},r.getConsentRequired=function(){return s.consentRequired.clone()},r.getConsentTitleText=function(){return s.consentTitleText.clone()},r.getConsentBodyText=function(){return s.consentBodyText.clone()},r.getConsentAcceptButtonText=function(){return s.consentAcceptButtonText.clone()},r.getConsentDenyButtonText=function(){return s.consentDenyButtonText.clone()},r.isViewable=function(){return s.isViewable.clone()},r.getViewable=r.isViewable,r.setExpandProperties=function(e){var r={};\"object\"==typeof e?(Object.keys(e).forEach(function(t){\"isModal\"!==t&&(r[t]=e[t])}),d(r,s.expandProperties.clone(),\"expandProperties\")&&s.expandProperties.update(r)):(a(u.ERROR,\"mraid.setExpandProperties\",t.error.mraidError.MRD004),t.mraidBridgeExt&&t.mraidBridgeExt.notifyError(\"MRD004\"))},r.setOrientationProperties=function(e){var r;\"object\"==typeof e?(r=[\"setOrientationProperties\",\"allowOrientationChange\",e.allowOrientationChange,\"forceOrientation\",e.forceOrientation],d(e,s.orientationProperties.clone(),\"orientationProperties\")&&(s.orientationProperties.update(e),i.apply(null,r))):(a(u.ERROR,\"mraid.setOrientationProperties\",t.error.mraidError.MRD005),t.mraidBridgeExt&&t.mraidBridgeExt.notifyError(\"MRD005\"))},r.setResizeProperties=function(e){\"object\"==typeof e?d(e,s.resizeProperties.clone(),\"resizeProperties\")&&s.resizeProperties.update(e):(a(u.ERROR,\"mraid.setResizeProperties\",t.error.mraidError.MRD006),t.mraidBridgeExt&&t.mraidBridgeExt.notifyError(\"MRD006\"))},r.useCustomClose=function(e){var t;d(e,s.customClose.clone(),\"useCustomClose\")&&d({useCustomClose:e},s.expandProperties.clone(),\"expandProperties\")&&(s.customClose.update(e),s.expandProperties.update({useCustomClose:e}),t=e===!0?\"invisible\":e===!1?\"visible\":void 0===e?\"gone\":\"\",i(\"useCustomClose\",\"sdkCloseButton\",t))},n.useCustomPrivacy=function(e){d(e,s.customPrivacy.clone(),\"useCustomPrivacy\")&&(s.customPrivacy.update(e),i(\"useCustomPrivacy\",\"useCustomPrivacy\",e))},r.open=function(e){e?i(\"open\",\"url\",encodeURI(e)):a(u.ERROR,\"mraid.open\",t.error.mraidError.MRD007)},r.close=function(){r.getState()!==c.HIDDEN?i(\"close\"):a(u.ERROR,\"mraid.close\",t.error.mraidError.MRD008)},r.playVideo=function(){var e=arguments&&arguments[0]?arguments[0]:\"\",n=arguments&&arguments[1]?arguments[1]:\"\";r.isViewable()?e.length>0?i(\"playVideo\",\"uri\",e,\"captionUrl\",n):a(u.ERROR,\"mraid.playVideo\",t.error.mraidError.MRD009):a(u.ERROR,\"mraid.playVideo\",t.error.mraidError.MRD010)},r.expand=function(e){var r=s.customClose.clone(),n=s.placementType.clone(),o=s.state.clone(),d=[\"expand\",\"useCustomClose\",r];n!==l.INLINE||o!==c.DEFAULT&&o!==c.RESIZED?a(u.ERROR,\"mraid.expand\",t.error.mraidError.MRD011):(e&&(arguments.push(\"url\"),arguments.push(encodeURI(e))),i.apply(null,d))},r.resize=function(){var e=s.resize.clone(),n=[\"resize\"],o=r.getState();o!==c.DEFAULT&&o!==c.RESIZED?(n.push(\"width\"),n.push(e.width),n.push(\"height\"),n.push(e.height),n.push(\"offsetX\"),n.push(e.offsetX),n.push(\"offsetY\"),n.push(e.offsetY),n.push(\"customClosePosition\"),n.push(e.customClosePosition),n.push(\"allowOffscreen\"),n.push(e.allowOffscreen),i.apply(null,n)):a(u.ERROR,\"mraid.resize\",t.error.mraidError.MRD012)},r.createCalendarEvent=function(){},r.storePicture=function(e){r.isViewable()?e?a(u.ERROR,\"mraid.storePicture\",t.error.mraidError.MRD013):i(\"storePicture\",\"uri\",e):a(u.ERROR,\"mraid.storePicture\",t.error.mraidError.MRD010)}}(window);";
                try {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(mraidJS, true)));
                    out.println("!function(e){\"use strict\";var t,r=e.vungle=e.vungle||{};r.error||(t=r.error=r.error||{},t.bridgeError={BRG000:\"Missing command in mraidBridge.executeSDKCommand method call!\",BRG001:\"Vungle SDK is not ready to process MRAID command!\"},t.bridgeExtError={BRX000:\"Cannot retrieve #dynamic container in Ad Unit!\"},t.mraidError={MRD000:\"Cannot add listener for unknown MRAID event!\",MRD001:\"Missing argument(s)! Both event and/or listener are required for method call!\",MRD002:\"Unable to find listener registered for event!\",MRD003:\"Missing MRAID event! Cannot remove event listener!\",MRD004:\"Missing object! An expand properties object is required for method call!\",MRD005:\"Missing object! An orientation properties object is required for method call!\",MRD006:\"Missing object! An resize properties object is required for method call!\",MRD007:\"Missing URL! A URL is required for method call!\",MRD008:\"Ad unit is hidden and cannot be closed!\",MRD009:\"Missing URL! A video/caption URL is required for method call!\",MRD010:\"Ad Unit is not viewable! Please make sure isViewAble is set to true!\",MRD011:\"Ad unit can only be expanded from the default or resized state!\",MRD012:\"Ad unit can only be resized from the default or resized state!\",MRD013:\"Missing URI! A valid URI is required for method call!\",MRD015:\"Invalid data/type detected when updating MRAID properties!\",MRD016:\"Missing app store id! An app store id is required for method call!\"},t.mraidClientError={MRC000:\"MRAID SDK error detected!\",MRC001:\"Missing MRAID object in window!\",MRC002:\"Missing video URL!  mraidClient.playVideo cannot retrieve video URL from arguments!\"},t.adTemplateError={ADT000:\"Missing page template JavaScript!\",ADT001:\"Error encountered loading template configuration!\"},t.gestureTrackingError={GET000:\"Cannot serialize user interaction tracking event object!\"})}(window),function(e){\"use strict\";var t=e.vungle=e.vungle||{},r=t.mraidCore=t.mraidCore||{},n=t.debugLog=t.debugLog||[];n&&n.push(\"vungle.mraidCore loaded.\"),r.consts={versions:{V1:\"1.0\",V2:\"2.0\"},states:{LOADING:\"loading\",DEFAULT:\"default\",RESIZED:\"resized\",EXPANDED:\"expanded\",HIDDEN:\"hidden\"},events:{INFO:\"info\",READY:\"ready\",ERROR:\"error\",STATE_CHANGE:\"stateChange\",ORIENTATION_CHANGE:\"orientationChange\",VIEWABLE_CHANGE:\"viewableChange\",SIZE_CHANGE:\"sizeChange\"},placements:{UNKNOWN:\"unknown\",INLINE:\"inline\",INTERSTITIAL:\"interstitial\"},orientations:{PORTRAIT:\"portrait\",LANDSCAPE:\"landscape\",NONE:\"none\"},closePositions:{CENTER:\"center\",TOP_LEFT:\"top-left\",TOP_CENTER:\"top-center\",TOP_RIGHT:\"top-right\",BOTTOM_LEFT:\"bottom-left\",BOTTOM_CENTER:\"bottom-center\",BOTTOM_RIGHT:\"bottom-right\"}},r.PropertiesValueObject=function(e){var t=function(e){var t;return e&&\"object\"==typeof e?(t={},Object.keys(e).forEach(function(r){t[r]=e[r]})):t=e,t};this.value=t(e),this.clone=function(){return t(this.value)},this.update=function(e){if(e&&\"object\"==typeof e){var t=this;Object.keys(e).forEach(function(r){t.value[r]=e[r]})}else this.value=e}},r.EventListeners=function(e){var t={};this.event=e,this.listenerCount=0,this.add=function(e){var r=String(e);return!t[r]&&(t[r]=e,this.listenerCount++,!0)},this.remove=function(e){var r=String(e);return!(!t.hasOwnProperty(r)||!t[r])&&(t[r]=null,delete t[r],this.listenerCount--,!0)},this.removeAll=function(){var e=this;Object.keys(t).forEach(function(r){e.remove(t[r])})},this.broadcast=function(e){var r=this;Object.keys(t).forEach(function(n){t[n].apply(r.mraid,e)})}};var o=new r.PropertiesValueObject(r.consts.versions.V1),i=new r.PropertiesValueObject({width:0,height:0}),a=new r.PropertiesValueObject({width:0,height:0}),s=new r.PropertiesValueObject({x:0,y:0,width:0,height:0}),d=new r.PropertiesValueObject({x:0,y:0,width:0,height:0}),c=new r.PropertiesValueObject({width:0,height:0,useCustomClose:!1,isModal:!0}),u=new r.PropertiesValueObject({width:0,height:0,offsetX:0,offsetY:0,customClosePosition:r.consts.closePositions.TOP_RIGHT,allowOffscreen:!0}),l=new r.PropertiesValueObject({allowOrientationChange:!0,forceOrientation:r.consts.orientations.NONE}),p=new r.PropertiesValueObject({sms:!1,tel:!1,calendar:!1,storePicture:!1,inlineVideo:!1}),m=new r.PropertiesValueObject(r.consts.states.LOADING),g=new r.PropertiesValueObject(r.consts.placements.UNKNOWN),f=new r.PropertiesValueObject((!1)),E=new r.PropertiesValueObject((!1)),v=new r.PropertiesValueObject((!1)),R=new r.PropertiesValueObject((!1)),y=new r.PropertiesValueObject((!1)),h=new r.PropertiesValueObject((!1)),C=new r.PropertiesValueObject((!1)),D=new r.PropertiesValueObject((!1)),B=new r.PropertiesValueObject((!1)),x=new r.PropertiesValueObject((!1)),P={},O=new r.PropertiesValueObject(\"\"),S=new r.PropertiesValueObject(\"\");r.eventListeners=P,r.propertiesHandlers={os:{update:function(e){O.update(e)},clone:function(){return O.clone()}},osVersion:{update:function(e){S.update(e)},clone:function(){return S.clone()}},incentivized:{update:function(e){E.update(e)},clone:function(){return E.clone()}},consentRequired:{update:function(e){v.update(e)},clone:function(){return v.clone()}},consentTitleText:{update:function(e){R.update(e)},clone:function(){return R.clone()}},consentBodyText:{update:function(e){y.update(e)},clone:function(){return y.clone()}},consentAcceptButtonText:{update:function(e){h.update(e)},clone:function(){return h.clone()}},consentDenyButtonText:{update:function(e){C.update(e)},clone:function(){return C.clone()}},version:{update:function(e){o.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting MRAID version to: \"+String(e))},clone:function(){return o.clone()}},maxSize:{update:function(e){i.update(e),c.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting maxSize to: \"+String(e))},clone:function(){return i.clone()}},screenSize:{update:function(e){var t;a.update(e),t=a.clone(),r.broadcastEvent(r.consts.events.INFO,\"Setting screenSize to: \"+String(e)),r.broadcastEvent(r.consts.events.SIZE_CHANGE,t.width,t.height)},clone:function(){return a.clone()}},defaultPosition:{update:function(e){s.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting defaultPosition to: \"+String(e))},clone:function(){return s.clone()}},currentPosition:{update:function(e){d.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting currentPosition to: \"+String(e))},clone:function(){return d.clone()}},expandProperties:{update:function(e){c.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting expandProperties to: \"+String(e))},clone:function(){return c.clone()}},resizeProperties:{update:function(e){u.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting resizeProperties to: \"+String(e))},clone:function(){return u.clone()}},orientationProperties:{update:function(e){l.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting orientationProperties to: \"+String(e))},clone:function(){return l.clone()}},supports:{update:function(e){p.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting supports to: \"+String(e))},clone:function(){return p.clone()}},state:{update:function(e){m.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting state to: \"+String(e)),r.broadcastEvent(r.consts.events.STATE_CHANGE,m.clone()),m.clone()===r.consts.states.DEFAULT&&r.broadcastEvent(r.consts.events.READY)},clone:function(){return m.clone()}},placementType:{update:function(e){g.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting placementType to: \"+String(e))},clone:function(){return g.clone()}},isViewable:{update:function(e){f.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting isViewable to: \"+String(e)),r.broadcastEvent(r.consts.events.VIEWABLE_CHANGE,f.clone())},clone:function(){return f.clone()}},customClose:{update:function(e){D.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting useCustomClose to: \"+String(e))},clone:function(){return D.clone()}},customPrivacy:{update:function(e){B.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting useCustomPrivacy to: \"+String(e))},clone:function(){return B.clone()}},enableBackImmediately:{update:function(e){x.update(e),r.broadcastEvent(r.consts.events.INFO,\"Setting enableBackImmediately to: \"+String(e))},clone:function(){return x.clone()}}},r.propertiesValidator=function(e,r,n){var o=!0;return typeof e!=typeof r&&\"useCustomClose\"!==n?(o=!1,t.mraidBridgeExt&&t.mraidBridgeExt.notifyError([\"MRD015\",n,e].join(\":\"))):\"object\"==typeof e&&Object.keys(e).forEach(function(e){e in r||(o=!1,t.mraidBridgeExt&&t.mraidBridgeExt.notifyError([\"MRD015\",n,e].join(\":\")))}),o},r.broadcastEvent=function(){var e=Array.prototype.slice.call(arguments),t=e.shift(),r=P[t];r&&r.broadcast(e)},r.isValidMARIDEvent=function(e){for(var t in r.consts.events)if(r.consts.events[t]===e)return!0;return!1}}(window),function(e){\"use strict\";var t=e.vungle=e.vungle||{},r=t.mraidBridge=t.mraidBridge||{};r.notifyContainer=function(t){e.location=t}}(window),function(e){\"use strict\";var t,r=e.vungle=e.vungle||{},n=r.mraidBridge=r.mraidBridge||{},o=r.mraidBridgeExt=r.mraidBridgeExt||{},i=r.debugLog=r.debugLog||[],a=!1,s=!1,d=[],c=!1,u=!1,l=!1,p=!1,m=r.mraidCore.broadcastEvent,g=r.mraidCore.consts.states,f=r.mraidCore.consts.events;i&&i.push(\"vungle.mraidBridge loaded.\"),o.getReplacementTokens=function(){return t},o.getIsVungleAd=function(){return c},o.getIsDirectDownload=function(){return u},o.getIsDisplayIAP=function(){return l},o.getIsInstalled=function(){return p},o.getEnableBackButtonImmediately=function(){return r.mraidCore.propertiesHandlers.enableBackImmediately.clone()},n.notifyPropertiesChange=function(e,t){i&&i.push(\"mraidBridge.notifyPropertiesChange:\"+JSON.stringify(e)),Object.keys(e).forEach(function(t){r.mraidCore.propertiesHandlers[t]?r.mraidCore.propertiesHandlers[t].update(e[t]):n.notifyErrorEvent(\"notifyPropertiesChange\",\"MRD015: Unhandled Property received - \"+t+\" - \"+e[t])}),\"undefined\"!=typeof t&&t===!0&&r.mraidBridge.notifyContainer(\"mraid://propertiesChangeCompleted\")},n.notifyCommandComplete=function(){i&&i.push(\"mraidBridge.notifyCommandComplete\");var e=\"\";d.length?(e=d.shift(),r.mraidBridge.notifyContainer(e)):s=!1},n.notifyReadyEvent=function(e){i&&i.push(\"mraidBridge.notifyReadyEvent\");var n=r.mraidCore.propertiesHandlers.state.clone();a=!0,\"undefined\"!=typeof e?(c=!0,p=e.isInstalled,l=e.isDisplayIAP,u=e.isDirectDownload,t=e):r.mraidBridgeExt.notifySuccessfulViewAd(),n!==g.DEFAULT?r.mraidCore.propertiesHandlers.state.update(g.DEFAULT):m(f.READY)},n.notifyErrorEvent=function(e,t){i&&i.push(\"mraidBridge.notifyErrorEvent:\"+e+\":\"+t),m(f.ERROR,e,t)},n.executeSDKCommand=function(){var e,t,o,c=\"\";if(!a)throw n.notifyErrorEvent(c,r.error.bridgeError.BRG001),{name:\"VungleMRAIDBridgeException\",message:\"BRG001\"};if(!arguments)throw n.notifyErrorEvent(c,r.error.bridgeError.BRG000),{name:\"VungleMRAIDBridgeException\",message:\"BRG000\"};for(c+=\"mraid://\"+arguments[0],o=1;o<arguments.length;o+=2)e=arguments[o],t=arguments[o+1],c+=(1===o?\"?\":\"&\")+encodeURIComponent(e),\"undefined\"!=typeof t&&(c+=\"=\"+encodeURIComponent(t));s?d.push(c):(s=!0,r.mraidBridge.notifyContainer(c)),i&&i.push(\"mraidBridge.executeSDKCommand: \"+c)},o.fireVideoCompleteEvent=function(){i&&i.push(\"mraidBridgeExt.fireVideoCompleteEvent\");var t=e.document.querySelector(\"#dynamic\"),r=new e.Event(\"vungle.events.video.ended\");t?t.dispatchEvent(r):o.notifyError(e.vungle.error.bridgeExtError.BRX000)},o.notifyPrepareStoreViewSuccess=function(){i&&i.push(\"mraidBridgeExt.notifyPrepareStoreViewSuccess\");var t=e.document.querySelector(\"#dynamic\"),r=new e.Event(\"vungle.events.preparestore.success\");t?t.dispatchEvent(r):o.notifyError(e.vungle.error.bridgeExtError.BRX000)},o.notifyError=function(t){i&&i.push(\"mraidBridgeExt.notifyError:\"+t);try{r.mraidBridge.executeSDKCommand(\"error\",\"code\",t)}catch(n){\"VungleMRAIDBridgeException\"===n.name?i&&i.push(\"%cVungleMRAIDBridgeException caught in mraidBridgeExt.notifyError! Message: %s\",\"color: red; font-size: x-large\",e.vungle.error.bridgeError[n.message]):i&&i.push(\"%cUnknown Exception caught in mraidBridgeExt.notifyError! Message: %s\",\"color: red; font-size: x-large\",n.message)}},o.notifyTPAT=function(e){i&&i.push(\"mraidBridgeExt.notifyTPATEvent:\"+e);try{r.mraidBridge.executeSDKCommand(\"tpat\",\"event\",e)}catch(t){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.notifyTPAT\",t.message)}},o.consentAction=function(e){i&&i.push(\"mraidBridgeExt.consentActionEvent:\"+e);try{r.mraidBridge.executeSDKCommand(\"consentAction\",\"event\",e)}catch(t){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.consentActionEvent\",t.message)}},o.notifyUserInteraction=function(e,t){i&&i.push(\"mraidBridgeExt.notifyUserInteraction\");try{r.mraidBridge.executeSDKCommand(\"action\",e,t)}catch(n){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.notifyUserInteraction\",n.message)}},o.notifyEventValuePairEvent=function(e,t){i&&i.push(\"mraidBridgeExt.notifyEventValuePairEvent\");var n=e||\"null\",o=t||\"null\";try{r.mraidBridge.executeSDKCommand(\"actionWithValue\",\"event\",n,\"value\",o)}catch(n){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.notifyEventValuePairEvent\",n.message)}},o.playHTML5Video=function(e){i&&i.push(\"mraidBridgeExt.playHTML5Video\");try{r.mraidBridge.executeSDKCommand(\"playHTML5Video\",\"selector\",e)}catch(t){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.playHTML5Video\",t.message)}},o.openPrivacy=function(e){i&&i.push(\"mraidBridgeExt.openPrivacy\");try{r.mraidBridge.executeSDKCommand(\"openPrivacy\",\"url\",e)}catch(t){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.openPrivacy\",t.message)}},o.requestMRAIDClose=function(){i&&i.push(\"mraidBridgeExt.requestMRAIDClose\");try{var e,t=\"windows\"===r.mraidExt.getOS()&&(0===r.mraidExt.getOSVersion().indexOf(\"WinPhone81\")||0===r.mraidExt.getOSVersion().indexOf(\"Win81\")),n=\"android\"===r.mraidExt.getOS()&&parseInt(r.mraidExt.getOSVersion(),10)<=17;t||n?(e=document.createEvent(\"Event\"),e.initEvent(\"vungle.events.request.close\",!0,!0)):e=new Event(\"vungle.events.request.close\"),c?document.querySelector(\"#dynamic\").dispatchEvent(e):r.mraidBridge.executeSDKCommand(\"close\")}catch(o){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.requestMRAIDClose\",o.message)}},o.notifySuccessfulViewAd=function(){i&&i.push(\"mraidBridgeExt.notifySuccessfulViewAd\");try{r.mraidBridge.executeSDKCommand(\"successfulView\")}catch(e){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.notifySuccessfulViewAd\",e.message)}},o.openAppInDevice=function(){i&&i.push(\"mraidBridgeExt.openAppInDevice\");try{r.mraidBridge.executeSDKCommand(\"openAppInDevice\")}catch(e){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.openAppInDevice\",e.message)}},o.openStorePage=function(){i&&i.push(\"mraidBridgeExt.openStorePage\");try{r.mraidBridge.executeSDKCommand(\"openStorePage\")}catch(e){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.openStorePage\",e.message)}},o.cancelDownload=function(){i&&i.push(\"mraidBridgeExt.cancelDownload\");try{r.mraidBridge.executeSDKCommand(\"cancelDownload\")}catch(e){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.cancelDownload\",e.message)}},o.getInstallationStatus=function(t){i&&i.push(\"mraidBridgeExt.getInstallationStatus\");var r=e.document.querySelector(\"#dynamic\"),n=new e.CustomEvent(\"vungle.events.installationStatus.updated\",{detail:t});r?r.dispatchEvent(n):o.notifyError(e.vungle.error.bridgeExtError.BRX000)},o.startDownloadAppOnDevice=function(){i&&i.push(\"mraidBridgeExt.startDownloadAppOnDevice\");try{r.mraidBridge.executeSDKCommand(\"startDownloadAppOnDevice\")}catch(e){r.mraidBridge.notifyErrorEvent(\"mraidBridgeExt.startDownloadAppOnDevice\",e.message)}}}(window),function(e){\"use strict\";var t=e.vungle=e.vungle||{},r=e.mraid=t.mraid=t.mraid||{},n=t.mraidExt=t.mraidExt||{},o=t.debugLog=t.debugLog||[],i=t.mraidBridge.executeSDKCommand,a=t.mraidCore.broadcastEvent,s=t.mraidCore.propertiesHandlers,d=t.mraidCore.propertiesValidator,c=t.mraidCore.consts.states,u=t.mraidCore.consts.events,l=t.mraidCore.consts.placements;o&&o.push(\"vungle.mraid loaded.\"),r.addEventListener=function(e,r){e&&r?t.mraidCore.isValidMARIDEvent(e)?(t.mraidCore.eventListeners[e]||(t.mraidCore.eventListeners[e]=new t.mraidCore.EventListeners(e)),t.mraidCore.eventListeners[e].add(r)):a(u.ERROR,\"mraid.addEventListener\",t.error.mraidError.MRD000+\":\"+e):a(u.ERROR,\"mraid.addEventListener\",t.error.mraidError.MRD001)},r.removeEventListener=function(e,r){var n,o=!1;e?(n=t.mraidCore.eventListeners[e],r?(n&&(o=n.remove(r)),o||a(u.ERROR,\"mraid.removeEventListener\",t.error.mraidError.MRD002+\":\"+e)):n&&t.mraidCore.eventListeners.removeAll(),n&&0===n.count&&(t.mraidCore.eventListeners[e]=null,delete t.mraidCore.eventListeners[e])):a(u.ERROR,\"mraid.removeEventListener\",t.error.mraidError.MRD003)},n.prepareStoreView=function(e){e?i(\"prepareStoreView\",\"appStoreId\",e):a(u.ERROR,\"mraid.prepareStoreView\",t.error.mraidError.MRD016)},n.presentStoreView=function(e){e?i(\"presentStoreView\",\"appStoreId\",e):a(u.ERROR,\"mraid.presentStoreView\",t.error.mraidError.MRD016)},n.getOS=function(){return s.os.clone()},n.getOSVersion=function(){return s.osVersion.clone()},n.getIncentivized=function(){return s.incentivized.clone()},r.getVersion=function(){return s.version.clone()},r.getMaxSize=function(){return s.maxSize.clone()},r.getScreenSize=function(){return s.screenSize.clone()},r.getDefaultPosition=function(){return s.defaultPosition.clone()},r.getCurrentPosition=function(){return s.currentPosition.clone()},r.getExpandProperties=function(){return s.expandProperties.clone()},r.getResizeProperties=function(){return s.resizeProperties.clone()},r.getOrientationProperties=function(){return s.orientationProperties.clone()},r.supports=function(e){return s.supports.clone()[e]},r.getState=function(){return s.state.clone()},r.getPlacementType=function(){return s.placementType.clone()},r.getConsentRequired=function(){return s.consentRequired.clone()},r.getConsentTitleText=function(){return s.consentTitleText.clone()},r.getConsentBodyText=function(){return s.consentBodyText.clone()},r.getConsentAcceptButtonText=function(){return s.consentAcceptButtonText.clone()},r.getConsentDenyButtonText=function(){return s.consentDenyButtonText.clone()},r.isViewable=function(){return s.isViewable.clone()},r.getViewable=r.isViewable,r.setExpandProperties=function(e){var r={};\"object\"==typeof e?(Object.keys(e).forEach(function(t){\"isModal\"!==t&&(r[t]=e[t])}),d(r,s.expandProperties.clone(),\"expandProperties\")&&s.expandProperties.update(r)):(a(u.ERROR,\"mraid.setExpandProperties\",t.error.mraidError.MRD004),t.mraidBridgeExt&&t.mraidBridgeExt.notifyError(\"MRD004\"))},r.setOrientationProperties=function(e){var r;\"object\"==typeof e?(r=[\"setOrientationProperties\",\"allowOrientationChange\",e.allowOrientationChange,\"forceOrientation\",e.forceOrientation],d(e,s.orientationProperties.clone(),\"orientationProperties\")&&(s.orientationProperties.update(e),i.apply(null,r))):(a(u.ERROR,\"mraid.setOrientationProperties\",t.error.mraidError.MRD005),t.mraidBridgeExt&&t.mraidBridgeExt.notifyError(\"MRD005\"))},r.setResizeProperties=function(e){\"object\"==typeof e?d(e,s.resizeProperties.clone(),\"resizeProperties\")&&s.resizeProperties.update(e):(a(u.ERROR,\"mraid.setResizeProperties\",t.error.mraidError.MRD006),t.mraidBridgeExt&&t.mraidBridgeExt.notifyError(\"MRD006\"))},r.useCustomClose=function(e){var t;d(e,s.customClose.clone(),\"useCustomClose\")&&d({useCustomClose:e},s.expandProperties.clone(),\"expandProperties\")&&(s.customClose.update(e),s.expandProperties.update({useCustomClose:e}),t=e===!0?\"invisible\":e===!1?\"visible\":void 0===e?\"gone\":\"\",i(\"useCustomClose\",\"sdkCloseButton\",t))},n.useCustomPrivacy=function(e){d(e,s.customPrivacy.clone(),\"useCustomPrivacy\")&&(s.customPrivacy.update(e),i(\"useCustomPrivacy\",\"useCustomPrivacy\",e))},r.open=function(e){e?i(\"open\",\"url\",encodeURI(e)):a(u.ERROR,\"mraid.open\",t.error.mraidError.MRD007)},r.close=function(){r.getState()!==c.HIDDEN?i(\"close\"):a(u.ERROR,\"mraid.close\",t.error.mraidError.MRD008)},r.playVideo=function(){var e=arguments&&arguments[0]?arguments[0]:\"\",n=arguments&&arguments[1]?arguments[1]:\"\";r.isViewable()?e.length>0?i(\"playVideo\",\"uri\",e,\"captionUrl\",n):a(u.ERROR,\"mraid.playVideo\",t.error.mraidError.MRD009):a(u.ERROR,\"mraid.playVideo\",t.error.mraidError.MRD010)},r.expand=function(e){var r=s.customClose.clone(),n=s.placementType.clone(),o=s.state.clone(),d=[\"expand\",\"useCustomClose\",r];n!==l.INLINE||o!==c.DEFAULT&&o!==c.RESIZED?a(u.ERROR,\"mraid.expand\",t.error.mraidError.MRD011):(e&&(arguments.push(\"url\"),arguments.push(encodeURI(e))),i.apply(null,d))},r.resize=function(){var e=s.resize.clone(),n=[\"resize\"],o=r.getState();o!==c.DEFAULT&&o!==c.RESIZED?(n.push(\"width\"),n.push(e.width),n.push(\"height\"),n.push(e.height),n.push(\"offsetX\"),n.push(e.offsetX),n.push(\"offsetY\"),n.push(e.offsetY),n.push(\"customClosePosition\"),n.push(e.customClosePosition),n.push(\"allowOffscreen\"),n.push(e.allowOffscreen),i.apply(null,n)):a(u.ERROR,\"mraid.resize\",t.error.mraidError.MRD012)},r.createCalendarEvent=function(){},r.storePicture=function(e){r.isViewable()?e?a(u.ERROR,\"mraid.storePicture\",t.error.mraidError.MRD013):i(\"storePicture\",\"uri\",e):a(u.ERROR,\"mraid.storePicture\",t.error.mraidError.MRD010)}}(window);");
                    out.close();
                    this.prepared = true;
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                closeView();
                return;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(dest.getPath());
        sb3.append(File.separator);
        sb3.append("index.html");
        File indexHtml = new File(sb3.toString());
        if (!indexHtml.exists()) {
            EventListener eventListener2 = this.bus;
            if (eventListener2 != null) {
                eventListener2.onError(new VungleException(10));
            }
            this.adView.close();
            return;
        }
        AdView adView2 = this.adView;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("file://");
        sb4.append(indexHtml.getPath());
        adView2.showWebsite(sb4.toString());
    }

    public void play() {
        setAdVisibility(true);
    }

    public void stop(boolean isChangingConfigurations, boolean isFinishing) {
        setAdVisibility(false);
        if (!isChangingConfigurations && isFinishing && !this.isDestroying.getAndSet(true)) {
            VungleWebClient vungleWebClient = this.webClient;
            String str = null;
            if (vungleWebClient != null) {
                vungleWebClient.setMRAIDDelegate(null);
            }
            EventListener eventListener = this.bus;
            if (eventListener != null) {
                if (this.report.isCTAClicked()) {
                    str = "isCTAClicked";
                }
                eventListener.onNext("end", str);
            }
            DirectDownloadAdapter directDownloadAdapter2 = this.directDownloadAdapter;
            if (directDownloadAdapter2 != null) {
                directDownloadAdapter2.getSdkDownloadClient().cleanUp();
            }
        }
    }

    public void setAdVisibility(boolean isViewable) {
        this.webClient.setAdVisibility(isViewable);
    }

    public void generateSaveState(Bundle savedState) {
        if (savedState != null) {
            this.storage.save(this.report);
            savedState.putString(EXTRA_REPORT, this.report.getId());
            savedState.putBoolean(EXTRA_INCENTIVIZED_SENT, this.sendReportIncentivized.get());
            savedState.putBoolean(EXTRA_CONTENT_PREPARED, true);
        }
    }

    public void restoreFromSave(Bundle savedState) {
        if (savedState != null) {
            String reportId = savedState.getString(EXTRA_REPORT);
            this.report = TextUtils.isEmpty(reportId) ? null : (Report) this.storage.load(reportId, Report.class);
            boolean incentivizedShown = savedState.getBoolean(EXTRA_INCENTIVIZED_SENT, false);
            if (incentivizedShown) {
                this.sendReportIncentivized.set(incentivizedShown);
            }
            if (this.report == null) {
                this.adView.close();
            }
        }
    }

    public void onProgressUpdate(int progress) {
        if (progress == 100) {
            Checkpoint checkpoint = (Checkpoint) this.advertisement.getCheckpoints().get(this.advertisement.getCheckpoints().size() - 1);
            if (checkpoint.getPercentage() == 100) {
                for (String url : checkpoint.getUrls()) {
                    VungleApiClient.pingTPAT(url);
                }
            }
        }
    }

    public boolean handleExit(String flexViewCloseApiPlacementID) {
        String str = "javascript:window.vungle.mraidBridgeExt.requestMRAIDClose()";
        if (flexViewCloseApiPlacementID != null) {
            if (this.advertisement != null) {
                Placement placement2 = this.placement;
                if (placement2 != null) {
                    if (!placement2.getId().equals(flexViewCloseApiPlacementID)) {
                        Log.e(TAG, "Cannot close FlexView Ad with invalid placement reference id");
                        return false;
                    }
                    if (!"flexview".equals(this.advertisement.getTemplateType())) {
                        Log.e(TAG, "Cannot close a Non FlexView ad");
                        return false;
                    }
                    this.adView.showWebsite(str);
                    reportAction("mraidCloseByApi", null);
                    return true;
                }
            }
            Log.e(TAG, "Unable to close advertisement");
            return false;
        }
        if (this.backEnabled) {
            this.adView.showWebsite(str);
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01f6, code lost:
        if (r0.equals(r11) != false) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01a8, code lost:
        if (r0.equals(r11) != false) goto L_0x01ac;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0206 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ae A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processCommand(java.lang.String r17, com.google.gson.C10191u r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r18
            int r0 = r17.hashCode()
            java.lang.String r4 = "useCustomPrivacy"
            java.lang.String r5 = "successfulView"
            r8 = 0
            r9 = 1
            switch(r0) {
                case -1912374177: goto L_0x0092;
                case -1891064718: goto L_0x0087;
                case -1422950858: goto L_0x007d;
                case -1382780692: goto L_0x0072;
                case -735200587: goto L_0x0068;
                case -660787472: goto L_0x005e;
                case -511324706: goto L_0x0053;
                case -503430878: goto L_0x0048;
                case -348095344: goto L_0x0040;
                case 3417674: goto L_0x0036;
                case 3566511: goto L_0x002b;
                case 94756344: goto L_0x0020;
                case 1614272768: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x009b
        L_0x0015:
            java.lang.String r0 = "useCustomClose"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 6
            goto L_0x009c
        L_0x0020:
            java.lang.String r0 = "close"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 0
            goto L_0x009c
        L_0x002b:
            java.lang.String r0 = "tpat"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 3
            goto L_0x009c
        L_0x0036:
            java.lang.String r0 = "open"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 5
            goto L_0x009c
        L_0x0040:
            boolean r0 = r2.equals(r4)
            if (r0 == 0) goto L_0x0013
            r0 = 7
            goto L_0x009c
        L_0x0048:
            java.lang.String r0 = "cancelDownload"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 11
            goto L_0x009c
        L_0x0053:
            java.lang.String r0 = "openPrivacy"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 8
            goto L_0x009c
        L_0x005e:
            java.lang.String r0 = "consentAction"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x009c
        L_0x0068:
            java.lang.String r0 = "actionWithValue"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 2
            goto L_0x009c
        L_0x0072:
            java.lang.String r0 = "startDownloadAppOnDevice"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 10
            goto L_0x009c
        L_0x007d:
            java.lang.String r0 = "action"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 4
            goto L_0x009c
        L_0x0087:
            java.lang.String r0 = "openAppInDevice"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0013
            r0 = 12
            goto L_0x009c
        L_0x0092:
            boolean r0 = r2.equals(r5)
            if (r0 == 0) goto L_0x0013
            r0 = 9
            goto L_0x009c
        L_0x009b:
            r0 = -1
        L_0x009c:
            java.lang.String r10 = "configSettings"
            java.lang.String r11 = "gone"
            java.lang.String r12 = "android.intent.action.VIEW"
            r13 = 3178655(0x30809f, float:4.454244E-39)
            java.lang.String r14 = "url"
            java.lang.String r15 = "mraidClose"
            java.lang.String r6 = "event"
            r7 = 0
            switch(r0) {
                case 0: goto L_0x03ea;
                case 1: goto L_0x03ac;
                case 2: goto L_0x0289;
                case 3: goto L_0x026f;
                case 4: goto L_0x026e;
                case 5: goto L_0x0225;
                case 6: goto L_0x01cd;
                case 7: goto L_0x0177;
                case 8: goto L_0x0159;
                case 9: goto L_0x00d4;
                case 10: goto L_0x00c8;
                case 11: goto L_0x00bc;
                case 12: goto L_0x00b0;
                default: goto L_0x00af;
            }
        L_0x00af:
            return r8
        L_0x00b0:
            com.vungle.warren.DirectDownloadAdapter r0 = r1.directDownloadAdapter
            if (r0 == 0) goto L_0x00bb
            com.vungle.warren.SDKDownloadClient r0 = r0.getSdkDownloadClient()
            r0.sendOpenPackageRequest()
        L_0x00bb:
            return r9
        L_0x00bc:
            com.vungle.warren.DirectDownloadAdapter r0 = r1.directDownloadAdapter
            if (r0 == 0) goto L_0x00c7
            com.vungle.warren.SDKDownloadClient r0 = r0.getSdkDownloadClient()
            r0.cancelDownloadRequest()
        L_0x00c7:
            return r9
        L_0x00c8:
            com.vungle.warren.DirectDownloadAdapter r0 = r1.directDownloadAdapter
            if (r0 == 0) goto L_0x00d3
            com.vungle.warren.SDKDownloadClient r0 = r0.getSdkDownloadClient()
            r0.sendDownloadRequest()
        L_0x00d3:
            return r9
        L_0x00d4:
            com.vungle.warren.presenter.AdvertisementPresenter$EventListener r0 = r1.bus
            if (r0 == 0) goto L_0x00db
            r0.onNext(r5, r7)
        L_0x00db:
            com.vungle.warren.Storage r0 = r1.storage
            java.lang.Class<com.vungle.warren.model.Cookie> r4 = com.vungle.warren.model.Cookie.class
            com.vungle.warren.persistence.Memorable r0 = r0.load(r10, r4)
            com.vungle.warren.model.Cookie r0 = (com.vungle.warren.model.Cookie) r0
            com.vungle.warren.model.Placement r4 = r1.placement
            boolean r4 = r4.isIncentivized()
            if (r4 == 0) goto L_0x0158
            if (r0 == 0) goto L_0x0158
            java.lang.String r4 = "isReportIncentivizedEnabled"
            java.lang.Boolean r4 = r0.getBoolean(r4)
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0158
            java.util.concurrent.atomic.AtomicBoolean r4 = r1.sendReportIncentivized
            boolean r4 = r4.getAndSet(r9)
            if (r4 != 0) goto L_0x0158
            com.google.gson.u r4 = new com.google.gson.u
            r4.<init>()
            com.google.gson.v r5 = new com.google.gson.v
            com.vungle.warren.model.Placement r6 = r1.placement
            java.lang.String r6 = r6.getId()
            r5.<init>(r6)
            java.lang.String r6 = "placement_reference_id"
            r4.mo33467a(r6, r5)
            com.google.gson.v r5 = new com.google.gson.v
            com.vungle.warren.model.Advertisement r6 = r1.advertisement
            java.lang.String r6 = r6.getAppID()
            r5.<init>(r6)
            java.lang.String r6 = "app_id"
            r4.mo33467a(r6, r5)
            com.google.gson.v r5 = new com.google.gson.v
            com.vungle.warren.model.Report r6 = r1.report
            long r6 = r6.getAdStartTime()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r5.<init>(r6)
            java.lang.String r6 = "adStartTime"
            r4.mo33467a(r6, r5)
            com.google.gson.v r5 = new com.google.gson.v
            com.vungle.warren.model.Report r6 = r1.report
            java.lang.String r6 = r6.getUserID()
            r5.<init>(r6)
            java.lang.String r6 = "user"
            r4.mo33467a(r6, r5)
            retrofit2.Call r5 = com.vungle.warren.network.VungleApiClient.m41060ri(r4)
            com.vungle.warren.presenter.WebAdPresenter$4 r6 = new com.vungle.warren.presenter.WebAdPresenter$4
            r6.<init>()
            r5.enqueue(r6)
        L_0x0158:
            return r9
        L_0x0159:
            com.google.gson.s r0 = r3.mo33466a(r14)
            java.lang.String r0 = r0.mo33439h()
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r12)
            android.net.Uri r5 = android.net.Uri.parse(r0)
            r4.setData(r5)
            com.vungle.warren.ui.AdView r5 = r1.adView
            java.lang.String r6 = r4.toUri(r8)
            r5.open(r6)
            return r9
        L_0x0177:
            com.google.gson.s r0 = r3.mo33466a(r4)
            java.lang.String r0 = r0.mo33439h()
            int r4 = r0.hashCode()
            if (r4 == r13) goto L_0x01a4
            r5 = 3569038(0x36758e, float:5.001287E-39)
            if (r4 == r5) goto L_0x019a
            r5 = 97196323(0x5cb1923, float:1.9099262E-35)
            if (r4 == r5) goto L_0x0190
        L_0x018f:
            goto L_0x01ab
        L_0x0190:
            java.lang.String r4 = "false"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x018f
            r8 = 2
            goto L_0x01ac
        L_0x019a:
            java.lang.String r4 = "true"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x018f
            r8 = 1
            goto L_0x01ac
        L_0x01a4:
            boolean r4 = r0.equals(r11)
            if (r4 == 0) goto L_0x018f
            goto L_0x01ac
        L_0x01ab:
            r8 = -1
        L_0x01ac:
            if (r8 == 0) goto L_0x01cb
            if (r8 == r9) goto L_0x01cb
            r4 = 2
            if (r8 != r4) goto L_0x01b4
            goto L_0x01cb
        L_0x01b4:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Unknown value "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x01cb:
            return r9
        L_0x01cd:
            java.lang.String r0 = "sdkCloseButton"
            com.google.gson.s r0 = r3.mo33466a(r0)
            java.lang.String r0 = r0.mo33439h()
            int r4 = r0.hashCode()
            r5 = -1901805651(0xffffffff8ea4bfad, float:-4.06137E-30)
            if (r4 == r5) goto L_0x01f9
            if (r4 == r13) goto L_0x01f2
            r5 = 466743410(0x1bd1f072, float:3.4731534E-22)
            if (r4 == r5) goto L_0x01e8
        L_0x01e7:
            goto L_0x0203
        L_0x01e8:
            java.lang.String r4 = "visible"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x01e7
            r8 = 2
            goto L_0x0204
        L_0x01f2:
            boolean r4 = r0.equals(r11)
            if (r4 == 0) goto L_0x01e7
            goto L_0x0204
        L_0x01f9:
            java.lang.String r4 = "invisible"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x01e7
            r8 = 1
            goto L_0x0204
        L_0x0203:
            r8 = -1
        L_0x0204:
            if (r8 == 0) goto L_0x0223
            if (r8 == r9) goto L_0x0223
            r4 = 2
            if (r8 != r4) goto L_0x020c
            goto L_0x0223
        L_0x020c:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Unknown value "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x0223:
            return r9
        L_0x0225:
            java.lang.String r0 = "download"
            r1.reportAction(r0, r7)
            java.lang.String r0 = "mraidOpen"
            r1.reportAction(r0, r7)
            r1.reportAction(r15, r7)
            r16.closeView()
            com.google.gson.s r0 = r3.mo33466a(r14)
            java.lang.String r0 = r0.mo33439h()
            com.vungle.warren.model.Advertisement r4 = r1.advertisement
            java.lang.String r4 = r4.getCTAURL(r9)
            com.vungle.warren.network.VungleApiClient.pingTPAT(r4)
            boolean r4 = r1.directDownloadApkEnabled
            com.vungle.warren.model.Advertisement r5 = r1.advertisement
            boolean r5 = r5.isRequiresNonMarketInstall()
            boolean r4 = com.vungle.warren.download.APKDirectDownloadManager.isDirectDownloadEnabled(r4, r5)
            if (r4 == 0) goto L_0x0258
            com.vungle.warren.download.APKDirectDownloadManager.download(r0)
            goto L_0x026d
        L_0x0258:
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r12)
            android.net.Uri r5 = android.net.Uri.parse(r0)
            r4.setData(r5)
            com.vungle.warren.ui.AdView r5 = r1.adView
            java.lang.String r6 = r4.toUri(r8)
            r5.open(r6)
        L_0x026d:
            return r9
        L_0x026e:
            return r9
        L_0x026f:
            com.google.gson.s r0 = r3.mo33466a(r6)
            java.lang.String r0 = r0.mo33439h()
            com.vungle.warren.model.Advertisement r4 = r1.advertisement
            java.lang.String[] r4 = r4.getTpatUrls(r0)
            int r5 = r4.length
        L_0x027e:
            if (r8 >= r5) goto L_0x0288
            r6 = r4[r8]
            com.vungle.warren.network.VungleApiClient.pingTPAT(r6)
            int r8 = r8 + 1
            goto L_0x027e
        L_0x0288:
            return r9
        L_0x0289:
            com.google.gson.s r0 = r3.mo33466a(r6)
            java.lang.String r4 = r0.mo33439h()
            java.lang.String r0 = "value"
            com.google.gson.s r0 = r3.mo33466a(r0)
            java.lang.String r5 = r0.mo33439h()
            com.vungle.warren.model.Report r0 = r1.report
            long r11 = java.lang.System.currentTimeMillis()
            r0.recordAction(r4, r5, r11)
            com.vungle.warren.Storage r0 = r1.storage
            com.vungle.warren.model.Report r6 = r1.report
            r0.save(r6)
            java.lang.String r0 = "videoViewed"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0398
            float r0 = r1.duration
            r6 = 0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0398
            r6 = 0
            float r0 = java.lang.Float.parseFloat(r5)     // Catch:{ NumberFormatException -> 0x02c9 }
            float r11 = r1.duration     // Catch:{ NumberFormatException -> 0x02c9 }
            float r11 = r0 / r11
            r12 = 1120403456(0x42c80000, float:100.0)
            float r11 = r11 * r12
            int r6 = (int) r11
            goto L_0x02d1
        L_0x02c9:
            r0 = move-exception
            java.lang.String r11 = TAG
            java.lang.String r12 = "value for videoViewed is null !"
            android.util.Log.e(r11, r12)
        L_0x02d1:
            if (r6 <= 0) goto L_0x0398
            com.vungle.warren.presenter.AdvertisementPresenter$EventListener r0 = r1.bus
            if (r0 == 0) goto L_0x02eb
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "percentViewed:"
            r11.append(r12)
            r11.append(r6)
            java.lang.String r11 = r11.toString()
            r0.onNext(r11, r7)
        L_0x02eb:
            boolean r0 = r1.hasSendStart
            if (r0 != 0) goto L_0x0300
            if (r6 <= r9) goto L_0x0300
            r1.hasSendStart = r9
            com.vungle.warren.DirectDownloadAdapter r0 = r1.directDownloadAdapter
            if (r0 == 0) goto L_0x0300
            com.vungle.warren.SDKDownloadClient r0 = r0.getSdkDownloadClient()
            com.vungle.warren.DirectDownloadAdapter$CONTRACT_TYPE r7 = com.vungle.warren.DirectDownloadAdapter.CONTRACT_TYPE.CPI
            r0.sendADDisplayingNotify(r8, r7)
        L_0x0300:
            boolean r0 = r1.hasSend80Percent
            if (r0 != 0) goto L_0x0317
            r0 = 80
            if (r6 <= r0) goto L_0x0317
            r1.hasSend80Percent = r9
            com.vungle.warren.DirectDownloadAdapter r0 = r1.directDownloadAdapter
            if (r0 == 0) goto L_0x0317
            com.vungle.warren.SDKDownloadClient r0 = r0.getSdkDownloadClient()
            com.vungle.warren.DirectDownloadAdapter$CONTRACT_TYPE r7 = com.vungle.warren.DirectDownloadAdapter.CONTRACT_TYPE.CPI
            r0.sendADDisplayingNotify(r9, r7)
        L_0x0317:
            com.vungle.warren.Storage r0 = r1.storage
            java.lang.Class<com.vungle.warren.model.Cookie> r7 = com.vungle.warren.model.Cookie.class
            com.vungle.warren.persistence.Memorable r0 = r0.load(r10, r7)
            com.vungle.warren.model.Cookie r0 = (com.vungle.warren.model.Cookie) r0
            com.vungle.warren.model.Placement r7 = r1.placement
            boolean r7 = r7.isIncentivized()
            if (r7 == 0) goto L_0x0398
            r7 = 75
            if (r6 <= r7) goto L_0x0398
            if (r0 == 0) goto L_0x0398
            java.lang.String r7 = "isReportIncentivizedEnabled"
            java.lang.Boolean r7 = r0.getBoolean(r7)
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0398
            java.util.concurrent.atomic.AtomicBoolean r7 = r1.sendReportIncentivized
            boolean r7 = r7.getAndSet(r9)
            if (r7 != 0) goto L_0x0398
            com.google.gson.u r7 = new com.google.gson.u
            r7.<init>()
            com.google.gson.v r8 = new com.google.gson.v
            com.vungle.warren.model.Placement r10 = r1.placement
            java.lang.String r10 = r10.getId()
            r8.<init>(r10)
            java.lang.String r10 = "placement_reference_id"
            r7.mo33467a(r10, r8)
            com.google.gson.v r8 = new com.google.gson.v
            com.vungle.warren.model.Advertisement r10 = r1.advertisement
            java.lang.String r10 = r10.getAppID()
            r8.<init>(r10)
            java.lang.String r10 = "app_id"
            r7.mo33467a(r10, r8)
            com.google.gson.v r8 = new com.google.gson.v
            com.vungle.warren.model.Report r10 = r1.report
            long r10 = r10.getAdStartTime()
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            r8.<init>(r10)
            java.lang.String r10 = "adStartTime"
            r7.mo33467a(r10, r8)
            com.google.gson.v r8 = new com.google.gson.v
            com.vungle.warren.model.Report r10 = r1.report
            java.lang.String r10 = r10.getUserID()
            r8.<init>(r10)
            java.lang.String r10 = "user"
            r7.mo33467a(r10, r8)
            retrofit2.Call r8 = com.vungle.warren.network.VungleApiClient.m41060ri(r7)
            com.vungle.warren.presenter.WebAdPresenter$3 r10 = new com.vungle.warren.presenter.WebAdPresenter$3
            r10.<init>()
            r8.enqueue(r10)
        L_0x0398:
            java.lang.String r0 = "videoLength"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x03a6
            float r0 = java.lang.Float.parseFloat(r5)
            r1.duration = r0
        L_0x03a6:
            com.vungle.warren.ui.AdView r0 = r1.adView
            r0.setVisibility(r9)
            return r9
        L_0x03ac:
            com.vungle.warren.Storage r0 = r1.storage
            java.lang.Class<com.vungle.warren.model.Cookie> r4 = com.vungle.warren.model.Cookie.class
            java.lang.String r5 = "consentIsImportantToVungle"
            com.vungle.warren.persistence.Memorable r0 = r0.load(r5, r4)
            com.vungle.warren.model.Cookie r0 = (com.vungle.warren.model.Cookie) r0
            if (r0 != 0) goto L_0x03c0
            com.vungle.warren.model.Cookie r4 = new com.vungle.warren.model.Cookie
            r4.<init>(r5)
            r0 = r4
        L_0x03c0:
            com.google.gson.s r4 = r3.mo33466a(r6)
            java.lang.String r4 = r4.mo33439h()
            java.lang.String r5 = "consent_status"
            r0.putValue(r5, r4)
            java.lang.String r5 = "consent_source"
            java.lang.String r6 = "vungle_modal"
            r0.putValue(r5, r6)
            long r5 = java.lang.System.currentTimeMillis()
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            java.lang.String r6 = "timestamp"
            r0.putValue(r6, r5)
            com.vungle.warren.Storage r5 = r1.storage
            r5.save(r0)
            return r9
        L_0x03ea:
            r1.reportAction(r15, r7)
            r16.closeView()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.presenter.WebAdPresenter.processCommand(java.lang.String, com.google.gson.u):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleAction(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -314498168(0xffffffffed412388, float:-3.7358476E27)
            r2 = 2
            r3 = 0
            r4 = 1
            if (r0 == r1) goto L_0x002b
            r1 = 94756344(0x5a5ddf8, float:1.5598064E-35)
            if (r0 == r1) goto L_0x0021
            r1 = 1427818632(0x551ac888, float:1.06366291E13)
            if (r0 == r1) goto L_0x0017
        L_0x0016:
            goto L_0x0035
        L_0x0017:
            java.lang.String r0 = "download"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0016
            r0 = 1
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "close"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0016
            r0 = 0
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "privacy"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0016
            r0 = 2
            goto L_0x0036
        L_0x0035:
            r0 = -1
        L_0x0036:
            if (r0 == 0) goto L_0x0083
            if (r0 == r4) goto L_0x0054
            if (r0 != r2) goto L_0x003d
            goto L_0x0087
        L_0x003d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown action "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0054:
            com.vungle.warren.model.Advertisement r0 = r5.advertisement     // Catch:{ ActivityNotFoundException -> 0x007e }
            java.lang.String r0 = r0.getCTAURL(r4)     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.network.VungleApiClient.pingTPAT(r0)     // Catch:{ ActivityNotFoundException -> 0x007e }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x007e }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.model.Advertisement r1 = r5.advertisement     // Catch:{ ActivityNotFoundException -> 0x007e }
            java.lang.String r1 = r1.getCTAURL(r3)     // Catch:{ ActivityNotFoundException -> 0x007e }
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ ActivityNotFoundException -> 0x007e }
            r0.setData(r1)     // Catch:{ ActivityNotFoundException -> 0x007e }
            com.vungle.warren.ui.AdView r1 = r5.adView     // Catch:{ ActivityNotFoundException -> 0x007e }
            java.lang.String r2 = r0.toUri(r3)     // Catch:{ ActivityNotFoundException -> 0x007e }
            r1.open(r2)     // Catch:{ ActivityNotFoundException -> 0x007e }
            r5.closeView()     // Catch:{ ActivityNotFoundException -> 0x007e }
            goto L_0x0087
        L_0x007e:
            r0 = move-exception
            r5.closeView()
            goto L_0x0087
        L_0x0083:
            r5.closeView()
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.presenter.WebAdPresenter.handleAction(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void closeView() {
        this.adView.close();
        this.handler.removeCallbacksAndMessages(null);
    }
}
