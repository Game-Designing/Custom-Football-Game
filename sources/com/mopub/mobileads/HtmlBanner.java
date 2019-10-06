package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.factories.HtmlBannerWebViewFactory;
import java.lang.ref.WeakReference;
import java.util.Map;

public class HtmlBanner extends CustomEventBanner {
    public static final String ADAPTER_NAME = HtmlBanner.class.getSimpleName();

    /* renamed from: b */
    private HtmlBannerWebView f34783b;

    /* renamed from: c */
    private ExternalViewabilitySessionManager f34784c;

    /* renamed from: d */
    private boolean f34785d = false;

    /* renamed from: e */
    private WeakReference<Activity> f34786e;

    /* access modifiers changed from: protected */
    public void loadBanner(Context context, CustomEventBannerListener customEventBannerListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        MoPubLog.log(AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
        Object bannerImpressionPixelCountEnabledObject = localExtras.get(DataKeys.BANNER_IMPRESSION_PIXEL_COUNT_ENABLED);
        if (bannerImpressionPixelCountEnabledObject instanceof Boolean) {
            this.f34785d = ((Boolean) bannerImpressionPixelCountEnabledObject).booleanValue();
        }
        if (m37402a(serverExtras)) {
            String htmlData = (String) serverExtras.get(DataKeys.HTML_RESPONSE_BODY_KEY);
            try {
                this.f34783b = HtmlBannerWebViewFactory.create(context, (AdReport) localExtras.get(DataKeys.AD_REPORT_KEY), customEventBannerListener, (String) serverExtras.get(DataKeys.CLICKTHROUGH_URL_KEY));
                AdViewController.setShouldHonorServerDimensions(this.f34783b);
                MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, ADAPTER_NAME);
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    this.f34786e = new WeakReference<>(activity);
                    this.f34784c = new ExternalViewabilitySessionManager(activity);
                    this.f34784c.createDisplaySession(activity, this.f34783b, this.f34785d);
                } else {
                    MoPubLog.log(AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Unable to start viewability session for HTML banner: Context provided was not an Activity.");
                }
                this.f34783b.mo36915a(htmlData);
                MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, ADAPTER_NAME);
            } catch (ClassCastException e) {
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode()), MoPubErrorCode.INTERNAL_ERROR);
                customEventBannerListener.onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
            }
        } else {
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(MoPubErrorCode.NETWORK_INVALID_STATE.getIntCode()), MoPubErrorCode.NETWORK_INVALID_STATE);
            customEventBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
        }
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        ExternalViewabilitySessionManager externalViewabilitySessionManager = this.f34784c;
        if (externalViewabilitySessionManager != null) {
            externalViewabilitySessionManager.endDisplaySession();
            this.f34784c = null;
        }
        HtmlBannerWebView htmlBannerWebView = this.f34783b;
        if (htmlBannerWebView != null) {
            htmlBannerWebView.destroy();
            this.f34783b = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36958b() {
        HtmlBannerWebView htmlBannerWebView = this.f34783b;
        if (htmlBannerWebView != null) {
            htmlBannerWebView.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
            if (this.f34785d && this.f34784c != null) {
                WeakReference<Activity> weakReference = this.f34786e;
                if (weakReference != null) {
                    Activity activity = (Activity) weakReference.get();
                    if (activity != null) {
                        this.f34784c.startDeferredDisplaySession(activity);
                    } else {
                        MoPubLog.log(AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Lost the activity for deferred Viewability tracking. Dropping session.");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m37402a(Map<String, String> serverExtras) {
        return serverExtras.containsKey(DataKeys.HTML_RESPONSE_BODY_KEY);
    }
}
