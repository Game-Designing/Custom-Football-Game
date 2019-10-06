package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.google.android.gms.internal.ads.mc */
final /* synthetic */ class C9575mc implements OnClickListener {

    /* renamed from: a */
    private final zzayb f22753a;

    /* renamed from: b */
    private final int f22754b;

    /* renamed from: c */
    private final int f22755c;

    /* renamed from: d */
    private final int f22756d;

    C9575mc(zzayb zzayb, int i, int i2, int i3) {
        this.f22753a = zzayb;
        this.f22754b = i;
        this.f22755c = i2;
        this.f22756d = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f22753a.mo30267a(this.f22754b, this.f22755c, this.f22756d, dialogInterface, i);
    }
}
