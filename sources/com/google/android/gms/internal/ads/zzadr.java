package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

@zzard
public final class zzadr extends zzadp {

    /* renamed from: b */
    private final OnCustomRenderedAdLoadedListener f24244b;

    public zzadr(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f24244b = onCustomRenderedAdLoadedListener;
    }

    /* renamed from: a */
    public final void mo29628a(zzadl zzadl) {
        this.f24244b.onCustomRenderedAdLoaded(new zzadk(zzadl));
    }
}
