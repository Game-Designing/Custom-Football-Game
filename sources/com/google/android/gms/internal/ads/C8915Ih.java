package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;

/* renamed from: com.google.android.gms.internal.ads.Ih */
final /* synthetic */ class C8915Ih implements zzbam {

    /* renamed from: a */
    private final String f21252a;

    /* renamed from: b */
    private final double f21253b;

    /* renamed from: c */
    private final int f21254c;

    /* renamed from: d */
    private final int f21255d;

    C8915Ih(String str, double d, int i, int i2) {
        this.f21252a = str;
        this.f21253b = d;
        this.f21254c = i;
        this.f21255d = i2;
    }

    public final Object apply(Object obj) {
        String str = this.f21252a;
        zzadw zzadw = new zzadw(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.f21253b, this.f21254c, this.f21255d);
        return zzadw;
    }
}
