package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.eh */
final /* synthetic */ class C9404eh implements zzbsr {

    /* renamed from: a */
    private final Context f22214a;

    /* renamed from: b */
    private final zzbai f22215b;

    /* renamed from: c */
    private final zzcxm f22216c;

    /* renamed from: d */
    private final zzcxv f22217d;

    C9404eh(Context context, zzbai zzbai, zzcxm zzcxm, zzcxv zzcxv) {
        this.f22214a = context;
        this.f22215b = zzbai;
        this.f22216c = zzcxm;
        this.f22217d = zzcxv;
    }

    public final void onAdLoaded() {
        zzk.zzlq().mo30282b(this.f22214a, this.f22215b.f25057a, this.f22216c.f27575z.toString(), this.f22217d.f27602f);
    }
}
