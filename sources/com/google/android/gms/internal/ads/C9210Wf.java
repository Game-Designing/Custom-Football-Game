package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.Wf */
final /* synthetic */ class C9210Wf implements zzbsr {

    /* renamed from: a */
    private final Context f21891a;

    /* renamed from: b */
    private final zzbai f21892b;

    /* renamed from: c */
    private final zzcxm f21893c;

    /* renamed from: d */
    private final zzcxv f21894d;

    C9210Wf(Context context, zzbai zzbai, zzcxm zzcxm, zzcxv zzcxv) {
        this.f21891a = context;
        this.f21892b = zzbai;
        this.f21893c = zzcxm;
        this.f21894d = zzcxv;
    }

    public final void onAdLoaded() {
        zzk.zzlq().mo30282b(this.f21891a, this.f21892b.f25057a, this.f21893c.f27575z.toString(), this.f21894d.f27602f);
    }
}
