package com.mopub.mobileads;

import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;

public interface InternalCustomEventBannerListener extends CustomEventBannerListener {
    void onPauseAutoRefresh();

    void onResumeAutoRefresh();
}
