package com.mopub.mraid;

import android.view.View;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mraid.MraidController.MraidListener;

/* renamed from: com.mopub.mraid.a */
/* compiled from: MraidBanner */
class C11484a implements MraidListener {

    /* renamed from: a */
    final /* synthetic */ MraidBanner f35560a;

    C11484a(MraidBanner this$0) {
        this.f35560a = this$0;
    }

    public void onLoaded(View view) {
        AdViewController.setShouldHonorServerDimensions(view);
        MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, MraidBanner.ADAPTER_NAME);
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, MraidBanner.ADAPTER_NAME);
        this.f35560a.f35478c.onBannerLoaded(view);
    }

    public void onFailedToLoad() {
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, MraidBanner.ADAPTER_NAME, Integer.valueOf(MoPubErrorCode.MRAID_LOAD_ERROR.getIntCode()), MoPubErrorCode.MRAID_LOAD_ERROR);
        this.f35560a.f35478c.onBannerFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
    }

    public void onRenderProcessGone(MoPubErrorCode errorCode) {
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, MraidBanner.ADAPTER_NAME, Integer.valueOf(errorCode.getIntCode()), errorCode);
        this.f35560a.f35478c.onBannerFailed(errorCode);
    }

    public void onExpand() {
        this.f35560a.f35478c.onBannerExpanded();
        this.f35560a.f35478c.onBannerClicked();
    }

    public void onResize(boolean toOriginalSize) {
        if (toOriginalSize) {
            this.f35560a.f35478c.onResumeAutoRefresh();
        } else {
            this.f35560a.f35478c.onPauseAutoRefresh();
        }
    }

    public void onOpen() {
        MoPubLog.log(AdapterLogEvent.CLICKED, MraidBanner.ADAPTER_NAME);
        this.f35560a.f35478c.onBannerClicked();
    }

    public void onClose() {
        this.f35560a.f35478c.onBannerCollapsed();
    }
}
