package com.vungle.warren.p267ui;

import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.gson.C10188s;
import com.google.gson.C10191u;
import com.mopub.common.AdType;
import com.unity3d.ads.metadata.MediationMetaData;
import com.vungle.warren.DirectDownloadAdapter;
import com.vungle.warren.SDKDownloadClient.InstallStatusCheck;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import java.util.Locale;

/* renamed from: com.vungle.warren.ui.VungleWebClient */
public class VungleWebClient extends WebViewClient {
    private MRAIDDelegate MRAIDDelegate;
    private Advertisement advertisement;
    private boolean collectConsent;
    private DirectDownloadAdapter directDownloadAdapter;
    private String gdprAccept;
    private String gdprBody;
    private String gdprDeny;
    private String gdprTitle;
    private Boolean isViewable;
    private WebView loadedWebView;
    private Placement placement;
    private boolean ready = false;

    /* renamed from: com.vungle.warren.ui.VungleWebClient$MRAIDDelegate */
    public interface MRAIDDelegate {
        boolean processCommand(String str, C10191u uVar);
    }

    public VungleWebClient(Advertisement advertisement2, Placement placement2, DirectDownloadAdapter directDownloadAdapter2) {
        this.advertisement = advertisement2;
        this.placement = placement2;
        this.directDownloadAdapter = directDownloadAdapter2;
    }

    public VungleWebClient(Advertisement advertisement2, Placement placement2) {
        this.advertisement = advertisement2;
        this.placement = placement2;
    }

    public void setConsentStatus(boolean collectedConsent, String title, String message, String accept, String deny) {
        this.collectConsent = collectedConsent;
        this.gdprTitle = title;
        this.gdprBody = message;
        this.gdprAccept = accept;
        this.gdprDeny = deny;
    }

    public void setMRAIDDelegate(MRAIDDelegate MRAIDDelegate2) {
        this.MRAIDDelegate = MRAIDDelegate2;
    }

    public boolean shouldOverrideUrlLoading(final WebView view, String url) {
        StringBuilder sb = new StringBuilder();
        sb.append("MRAID Command ");
        sb.append(url);
        Log.d("Vungle", sb.toString());
        Uri uri = Uri.parse(url);
        if (!uri.getScheme().equals(AdType.MRAID)) {
            return false;
        }
        String command = uri.getHost();
        if (command.equals("propertiesChangeCompleted") && !this.ready) {
            final C10191u mraidArgs = this.advertisement.getMRAIDArgs();
            DirectDownloadAdapter directDownloadAdapter2 = this.directDownloadAdapter;
            if (directDownloadAdapter2 != null) {
                directDownloadAdapter2.getSdkDownloadClient().setInstallStatusCheck(new InstallStatusCheck() {
                    public void isAppInstalled(boolean isInstalled, boolean isInAppPurchase) {
                        mraidArgs.mo33468a("isDirectDownload", Boolean.valueOf(true));
                        mraidArgs.mo33468a("isDisplayIAP", Boolean.valueOf(isInAppPurchase));
                        mraidArgs.mo33468a("isInstalled", Boolean.valueOf(isInstalled));
                        mraidArgs.mo33470a("locale", Locale.getDefault().toString());
                        mraidArgs.mo33470a("language", Locale.getDefault().getLanguage());
                        WebView webView = view;
                        StringBuilder sb = new StringBuilder();
                        sb.append("javascript:window.vungle.mraidBridge.notifyReadyEvent(");
                        sb.append(mraidArgs);
                        sb.append(")");
                        webView.loadUrl(sb.toString());
                    }
                });
                this.directDownloadAdapter.getSdkDownloadClient().installStatusRequest();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("javascript:window.vungle.mraidBridge.notifyReadyEvent(");
                sb2.append(mraidArgs);
                sb2.append(")");
                view.loadUrl(sb2.toString());
            }
            this.ready = true;
        } else if (this.MRAIDDelegate != null) {
            C10191u args = new C10191u();
            for (String param : uri.getQueryParameterNames()) {
                args.mo33470a(param, uri.getQueryParameter(param));
            }
            if (this.MRAIDDelegate.processCommand(command, args)) {
                view.loadUrl("javascript:window.vungle.mraidBridge.notifyCommandComplete()");
            }
        }
        return true;
    }

    public void onPageFinished(WebView webView, String url) {
        super.onPageFinished(webView, url);
        int adType = this.advertisement.getAdType();
        if (adType == 0) {
            webView.loadUrl("javascript:vungleInit({\"privacyPolicyEnabled\": \"true\"})");
            webView.loadUrl("javascript:function actionClicked(action){Android.performAction(action);};");
        } else if (adType == 1) {
            this.loadedWebView = webView;
            this.loadedWebView.setVisibility(0);
            notifyPropertiesChange(true);
        } else {
            throw new IllegalArgumentException("Unknown Client Type!");
        }
    }

    public void setReady(boolean ready2) {
        this.ready = ready2;
    }

    public void notifyPropertiesChange(boolean skipCmdQueue) {
        if (this.loadedWebView != null) {
            C10191u screenJson = new C10191u();
            C10191u size = new C10191u();
            String str = "width";
            size.mo33469a(str, (Number) Integer.valueOf(this.loadedWebView.getWidth()));
            String str2 = "height";
            size.mo33469a(str2, (Number) Integer.valueOf(this.loadedWebView.getHeight()));
            C10191u position = new C10191u();
            position.mo33469a("x", (Number) Integer.valueOf(0));
            position.mo33469a("y", (Number) Integer.valueOf(0));
            position.mo33469a(str, (Number) Integer.valueOf(this.loadedWebView.getWidth()));
            position.mo33469a(str2, (Number) Integer.valueOf(this.loadedWebView.getHeight()));
            C10191u supports = new C10191u();
            supports.mo33468a("sms", Boolean.valueOf(false));
            supports.mo33468a("tel", Boolean.valueOf(false));
            supports.mo33468a("calendar", Boolean.valueOf(false));
            supports.mo33468a("storePicture", Boolean.valueOf(false));
            supports.mo33468a("inlineVideo", Boolean.valueOf(false));
            screenJson.mo33467a("maxSize", (C10188s) size);
            screenJson.mo33467a("screenSize", (C10188s) size);
            screenJson.mo33467a("defaultPosition", (C10188s) position);
            screenJson.mo33467a("currentPosition", (C10188s) position);
            screenJson.mo33467a("supports", (C10188s) supports);
            screenJson.mo33470a("placementType", this.advertisement.getTemplateType());
            Boolean bool = this.isViewable;
            if (bool != null) {
                screenJson.mo33468a("isViewable", bool);
            }
            screenJson.mo33470a("os", "android");
            screenJson.mo33470a("osVersion", Integer.toString(VERSION.SDK_INT));
            screenJson.mo33468a("incentivized", Boolean.valueOf(this.placement.isIncentivized()));
            screenJson.mo33468a("enableBackImmediately", Boolean.valueOf(this.advertisement.getShowCloseDelay(this.placement.isIncentivized()) == 0));
            screenJson.mo33470a(MediationMetaData.KEY_VERSION, "1.0");
            String str3 = "consentRequired";
            if (this.collectConsent) {
                screenJson.mo33468a(str3, Boolean.valueOf(true));
                screenJson.mo33470a("consentTitleText", this.gdprTitle);
                screenJson.mo33470a("consentBodyText", this.gdprBody);
                screenJson.mo33470a("consentAcceptButtonText", this.gdprAccept);
                screenJson.mo33470a("consentDenyButtonText", this.gdprDeny);
            } else {
                screenJson.mo33468a(str3, Boolean.valueOf(false));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("loadJsjavascript:window.vungle.mraidBridge.notifyPropertiesChange(");
            sb.append(screenJson);
            String str4 = ",";
            sb.append(str4);
            sb.append(skipCmdQueue);
            String str5 = ")";
            sb.append(str5);
            Log.d("VungleWebClient", sb.toString());
            WebView webView = this.loadedWebView;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("javascript:window.vungle.mraidBridge.notifyPropertiesChange(");
            sb2.append(screenJson);
            sb2.append(str4);
            sb2.append(skipCmdQueue);
            sb2.append(str5);
            webView.loadUrl(sb2.toString());
        }
    }

    public void setAdVisibility(boolean isViewable2) {
        if (this.loadedWebView != null) {
            this.isViewable = Boolean.valueOf(isViewable2);
            notifyPropertiesChange(false);
        }
    }
}
