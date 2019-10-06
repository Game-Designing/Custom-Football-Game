package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.DataKeys;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.IntentActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.WebViewCacheService.Config;
import com.mopub.mobileads.factories.HtmlInterstitialWebViewFactory;
import java.io.Serializable;

public class MoPubActivity extends C11459v {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HtmlInterstitialWebView f34829d;

    /* renamed from: e */
    private ExternalViewabilitySessionManager f34830e;

    /* renamed from: com.mopub.mobileads.MoPubActivity$a */
    class C11330a implements CustomEventInterstitialListener {
        C11330a() {
        }

        public void onInterstitialLoaded() {
            MoPubLog.log(AdLogEvent.LOAD_SUCCESS, new Object[0]);
            if (MoPubActivity.this.f34829d != null) {
                MoPubActivity.this.f34829d.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
            }
        }

        public void onInterstitialFailed(MoPubErrorCode errorCode) {
            MoPubLog.log(AdLogEvent.LOAD_FAILED, Integer.valueOf(MoPubErrorCode.VIDEO_CACHE_ERROR.getIntCode()), MoPubErrorCode.VIDEO_CACHE_ERROR);
            MoPubActivity moPubActivity = MoPubActivity.this;
            BaseBroadcastReceiver.broadcastAction(moPubActivity, moPubActivity.mo37562a().longValue(), IntentActions.ACTION_INTERSTITIAL_FAIL);
            MoPubActivity.this.finish();
        }

        public void onInterstitialShown() {
            MoPubLog.log(AdLogEvent.SHOW_SUCCESS, new Object[0]);
        }

        public void onInterstitialClicked() {
            MoPubLog.log(AdLogEvent.CLICKED, new Object[0]);
            MoPubActivity moPubActivity = MoPubActivity.this;
            BaseBroadcastReceiver.broadcastAction(moPubActivity, moPubActivity.mo37562a().longValue(), IntentActions.ACTION_INTERSTITIAL_CLICK);
        }

        public void onInterstitialImpression() {
        }

        public void onLeaveApplication() {
            MoPubLog.log(AdLogEvent.WILL_LEAVE_APPLICATION, new Object[0]);
        }

        public void onInterstitialDismissed() {
            MoPubLog.log(AdLogEvent.DID_DISAPPEAR, new Object[0]);
        }
    }

    public static void start(Context context, AdReport adReport, String clickthroughUrl, CreativeOrientation creativeOrientation, long broadcastIdentifier) {
        MoPubLog.log(AdLogEvent.SHOW_ATTEMPTED, new Object[0]);
        try {
            context.startActivity(m37420a(context, adReport, clickthroughUrl, creativeOrientation, broadcastIdentifier));
        } catch (ActivityNotFoundException e) {
            Log.d("MoPubActivity", "MoPubActivity not found - did you declare it in AndroidManifest.xml?");
        }
    }

    /* renamed from: a */
    static Intent m37420a(Context context, AdReport adReport, String clickthroughUrl, CreativeOrientation orientation, long broadcastIdentifier) {
        Intent intent = new Intent(context, MoPubActivity.class);
        intent.putExtra(DataKeys.CLICKTHROUGH_URL_KEY, clickthroughUrl);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, broadcastIdentifier);
        intent.putExtra(DataKeys.AD_REPORT_KEY, adReport);
        intent.putExtra(DataKeys.CREATIVE_ORIENTATION_KEY, orientation);
        intent.addFlags(268435456);
        return intent;
    }

    /* renamed from: a */
    static void m37422a(Interstitial baseInterstitial, Context context, AdReport adReport, CustomEventInterstitialListener customEventInterstitialListener, String clickthroughUrl, long broadcastIdentifier) {
        MoPubLog.log(AdLogEvent.LOAD_ATTEMPTED, new Object[0]);
        HtmlInterstitialWebView htmlInterstitialWebView = HtmlInterstitialWebViewFactory.create(context.getApplicationContext(), adReport, customEventInterstitialListener, clickthroughUrl);
        htmlInterstitialWebView.enablePlugins(false);
        htmlInterstitialWebView.mo36943a();
        htmlInterstitialWebView.setWebViewClient(new C11337O(customEventInterstitialListener));
        ExternalViewabilitySessionManager externalViewabilitySessionManager = new ExternalViewabilitySessionManager(context);
        externalViewabilitySessionManager.createDisplaySession(context, htmlInterstitialWebView, true);
        htmlInterstitialWebView.mo36915a(C11459v.m37903a(adReport));
        WebViewCacheService.storeWebViewConfig(Long.valueOf(broadcastIdentifier), baseInterstitial, htmlInterstitialWebView, externalViewabilitySessionManager, null);
    }

    public View getAdView() {
        String clickthroughUrl = getIntent().getStringExtra(DataKeys.CLICKTHROUGH_URL_KEY);
        String htmlData = mo37564c();
        Long broadcastIdentifier = mo37562a();
        if (broadcastIdentifier != null) {
            Config config = WebViewCacheService.popWebViewConfig(broadcastIdentifier);
            if (config != null && (config.getWebView() instanceof HtmlInterstitialWebView)) {
                this.f34829d = (HtmlInterstitialWebView) config.getWebView();
                HtmlInterstitialWebView htmlInterstitialWebView = this.f34829d;
                C11330a aVar = new C11330a();
                AdReport adReport = this.f35423a;
                htmlInterstitialWebView.init(aVar, clickthroughUrl, adReport != null ? adReport.getDspCreativeId() : null);
                this.f34829d.enablePlugins(true);
                this.f34829d.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
                this.f34830e = config.getViewabilityManager();
                return this.f34829d;
            }
        }
        MoPubLog.log(AdLogEvent.CUSTOM, "WebView cache miss. Recreating the WebView.");
        this.f34829d = HtmlInterstitialWebViewFactory.create(getApplicationContext(), this.f35423a, new C11330a(), clickthroughUrl);
        this.f34830e = new ExternalViewabilitySessionManager(this);
        this.f34830e.createDisplaySession(this, this.f34829d, true);
        this.f34829d.mo36915a(htmlData);
        return this.f34829d;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        CreativeOrientation requestedOrientation;
        super.onCreate(savedInstanceState);
        Serializable orientationExtra = getIntent().getSerializableExtra(DataKeys.CREATIVE_ORIENTATION_KEY);
        if (orientationExtra == null || !(orientationExtra instanceof CreativeOrientation)) {
            requestedOrientation = CreativeOrientation.DEVICE;
        } else {
            requestedOrientation = (CreativeOrientation) orientationExtra;
        }
        DeviceUtils.lockOrientation(this, requestedOrientation);
        ExternalViewabilitySessionManager externalViewabilitySessionManager = this.f34830e;
        if (externalViewabilitySessionManager != null) {
            externalViewabilitySessionManager.startDeferredDisplaySession(this);
        }
        BaseBroadcastReceiver.broadcastAction(this, mo37562a().longValue(), IntentActions.ACTION_INTERSTITIAL_SHOW);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ExternalViewabilitySessionManager externalViewabilitySessionManager = this.f34830e;
        if (externalViewabilitySessionManager != null) {
            externalViewabilitySessionManager.endDisplaySession();
            this.f34830e = null;
        }
        HtmlInterstitialWebView htmlInterstitialWebView = this.f34829d;
        if (htmlInterstitialWebView != null) {
            htmlInterstitialWebView.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getUrl());
            this.f34829d.destroy();
        }
        BaseBroadcastReceiver.broadcastAction(this, mo37562a().longValue(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
        super.onDestroy();
    }
}
