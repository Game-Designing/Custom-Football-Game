package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;

public final class zzacc extends zzaav {

    /* renamed from: b */
    private final VideoLifecycleCallbacks f23877b;

    public zzacc(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.f23877b = videoLifecycleCallbacks;
    }

    public final void onVideoStart() {
        this.f23877b.onVideoStart();
    }

    public final void onVideoPlay() {
        this.f23877b.onVideoPlay();
    }

    public final void onVideoPause() {
        this.f23877b.onVideoPause();
    }

    /* renamed from: M */
    public final void mo29375M() {
        this.f23877b.onVideoEnd();
    }

    /* renamed from: k */
    public final void mo29376k(boolean z) {
        this.f23877b.onVideoMute(z);
    }
}
