package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;

@zzard
public final class zzagn extends zzafm {

    /* renamed from: b */
    private final OnContentAdLoadedListener f24313b;

    public zzagn(OnContentAdLoadedListener onContentAdLoadedListener) {
        this.f24313b = onContentAdLoadedListener;
    }

    /* renamed from: a */
    public final void mo29698a(zzafa zzafa) {
        this.f24313b.onContentAdLoaded(new zzafd(zzafa));
    }
}
