package com.google.android.gms.internal.ads;

import android.view.View;

/* renamed from: com.google.android.gms.internal.ads.gf */
final class C9446gf implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ View f22371a;

    /* renamed from: b */
    private final /* synthetic */ zzavb f22372b;

    /* renamed from: c */
    private final /* synthetic */ int f22373c;

    /* renamed from: d */
    private final /* synthetic */ zzbio f22374d;

    C9446gf(zzbio zzbio, View view, zzavb zzavb, int i) {
        this.f22374d = zzbio;
        this.f22371a = view;
        this.f22372b = zzavb;
        this.f22373c = i;
    }

    public final void run() {
        this.f22374d.m27023a(this.f22371a, this.f22372b, this.f22373c - 1);
    }
}
