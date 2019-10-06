package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;

@zzard
public final class zzagm extends zzafj {

    /* renamed from: b */
    private final OnAppInstallAdLoadedListener f24312b;

    public zzagm(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.f24312b = onAppInstallAdLoadedListener;
    }

    /* renamed from: a */
    public final void mo29697a(zzaew zzaew) {
        this.f24312b.onAppInstallAdLoaded(new zzaez(zzaew));
    }
}
