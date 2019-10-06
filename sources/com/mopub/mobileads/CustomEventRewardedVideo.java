package com.mopub.mobileads;

public abstract class CustomEventRewardedVideo extends CustomEventRewardedAd {

    @Deprecated
    protected interface CustomEventRewardedVideoListener {
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract boolean hasVideoAvailable();

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract void showVideo();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo36993a() {
        return hasVideoAvailable();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo36994c() {
        showVideo();
    }
}
