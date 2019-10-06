package com.mopub.nativeads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

interface PositioningSource {

    public interface PositioningListener {
        void onFailed();

        void onLoad(MoPubClientPositioning moPubClientPositioning);
    }

    void loadPositions(String str, PositioningListener positioningListener);
}
