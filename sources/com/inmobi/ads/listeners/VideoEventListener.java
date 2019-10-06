package com.inmobi.ads.listeners;

import com.inmobi.ads.InMobiNative;

public abstract class VideoEventListener {
    public void onVideoCompleted(InMobiNative inMobiNative) {
    }

    public void onVideoSkipped(InMobiNative inMobiNative) {
    }

    public void onAudioStateChanged(InMobiNative inMobiNative, boolean z) {
    }
}
