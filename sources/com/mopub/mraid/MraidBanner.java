package com.mopub.mraid;

import android.app.Activity;
import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.InternalCustomEventBannerListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.factories.MraidControllerFactory;
import java.util.Map;

class MraidBanner extends CustomEventBanner {
    public static final String ADAPTER_NAME = MraidBanner.class.getSimpleName();

    /* renamed from: b */
    private MraidController f35477b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public InternalCustomEventBannerListener f35478c;

    /* renamed from: d */
    private MraidWebViewDebugListener f35479d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ExternalViewabilitySessionManager f35480e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f35481f = false;

    MraidBanner() {
    }

    /* access modifiers changed from: protected */
    public void loadBanner(Context context, CustomEventBannerListener customEventBannerListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        try {
            this.f35478c = (InternalCustomEventBannerListener) customEventBannerListener;
            MoPubLog.log(AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
            if (m37946a(serverExtras)) {
                String htmlData = (String) serverExtras.get(DataKeys.HTML_RESPONSE_BODY_KEY);
                Object bannerImpressionPixelCountEnabledObject = localExtras.get(DataKeys.BANNER_IMPRESSION_PIXEL_COUNT_ENABLED);
                if (bannerImpressionPixelCountEnabledObject instanceof Boolean) {
                    this.f35481f = ((Boolean) bannerImpressionPixelCountEnabledObject).booleanValue();
                }
                try {
                    this.f35477b = MraidControllerFactory.create(context, (AdReport) localExtras.get(DataKeys.AD_REPORT_KEY), PlacementType.INLINE);
                    this.f35477b.setDebugListener(this.f35479d);
                    this.f35477b.setMraidListener(new C11484a(this));
                    this.f35477b.fillContent(htmlData, new C11485b(this, context));
                } catch (ClassCastException e) {
                    MoPubLog.log(AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(MoPubErrorCode.MRAID_LOAD_ERROR.getIntCode()), MoPubErrorCode.MRAID_LOAD_ERROR);
                    this.f35478c.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
                }
            } else {
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(MoPubErrorCode.MRAID_LOAD_ERROR.getIntCode()), MoPubErrorCode.MRAID_LOAD_ERROR);
                this.f35478c.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
            }
        } catch (ClassCastException e2) {
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(MoPubErrorCode.MRAID_LOAD_ERROR.getIntCode()), MoPubErrorCode.MRAID_LOAD_ERROR);
            customEventBannerListener.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        ExternalViewabilitySessionManager externalViewabilitySessionManager = this.f35480e;
        if (externalViewabilitySessionManager != null) {
            externalViewabilitySessionManager.endDisplaySession();
            this.f35480e = null;
        }
        MraidController mraidController = this.f35477b;
        if (mraidController != null) {
            mraidController.setMraidListener(null);
            this.f35477b.destroy();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36958b() {
        MraidController mraidController = this.f35477b;
        if (mraidController != null) {
            mraidController.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getJavascript());
            if (this.f35481f && this.f35480e != null) {
                Activity activity = (Activity) this.f35477b.mo37648b().get();
                if (activity != null) {
                    this.f35480e.startDeferredDisplaySession(activity);
                } else {
                    MoPubLog.log(AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Lost the activity for deferred Viewability tracking. Dropping session.");
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m37946a(Map<String, String> serverExtras) {
        return serverExtras.containsKey(DataKeys.HTML_RESPONSE_BODY_KEY);
    }

    @VisibleForTesting
    public void setDebugListener(MraidWebViewDebugListener debugListener) {
        this.f35479d = debugListener;
        MraidController mraidController = this.f35477b;
        if (mraidController != null) {
            mraidController.setDebugListener(debugListener);
        }
    }
}
