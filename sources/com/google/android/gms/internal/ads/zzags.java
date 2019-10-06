package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;

@zzard
public final class zzags extends zzafy {

    /* renamed from: b */
    private final OnUnifiedNativeAdLoadedListener f24317b;

    public zzags(OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.f24317b = onUnifiedNativeAdLoadedListener;
    }

    /* renamed from: a */
    public final void mo29702a(zzagg zzagg) {
        this.f24317b.onUnifiedNativeAdLoaded(new zzagj(zzagg));
    }
}
