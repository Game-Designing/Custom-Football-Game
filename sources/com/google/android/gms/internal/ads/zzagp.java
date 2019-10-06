package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;

@zzard
public final class zzagp extends zzafs {

    /* renamed from: b */
    private final OnCustomTemplateAdLoadedListener f24315b;

    public zzagp(OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.f24315b = onCustomTemplateAdLoadedListener;
    }

    /* renamed from: a */
    public final void mo29700a(zzafe zzafe) {
        this.f24315b.onCustomTemplateAdLoaded(zzafh.m24940a(zzafe));
    }
}
