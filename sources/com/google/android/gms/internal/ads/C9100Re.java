package com.google.android.gms.internal.ads;

import android.view.View;

/* renamed from: com.google.android.gms.internal.ads.Re */
final class C9100Re implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ View f21653a;

    /* renamed from: b */
    private final /* synthetic */ zzavb f21654b;

    /* renamed from: c */
    private final /* synthetic */ int f21655c;

    /* renamed from: d */
    private final /* synthetic */ zzbha f21656d;

    C9100Re(zzbha zzbha, View view, zzavb zzavb, int i) {
        this.f21656d = zzbha;
        this.f21653a = view;
        this.f21654b = zzavb;
        this.f21655c = i;
    }

    public final void run() {
        this.f21656d.m26840a(this.f21653a, this.f21654b, this.f21655c - 1);
    }
}
