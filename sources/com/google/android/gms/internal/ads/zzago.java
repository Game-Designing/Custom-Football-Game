package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;

@zzard
public final class zzago extends zzafp {

    /* renamed from: b */
    private final OnCustomClickListener f24314b;

    public zzago(OnCustomClickListener onCustomClickListener) {
        this.f24314b = onCustomClickListener;
    }

    /* renamed from: a */
    public final void mo29699a(zzafe zzafe, String str) {
        this.f24314b.onCustomClick(zzafh.m24940a(zzafe), str);
    }
}
