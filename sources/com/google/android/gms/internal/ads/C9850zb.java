package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.ByteArrayOutputStream;

/* renamed from: com.google.android.gms.internal.ads.zb */
final class C9850zb implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Bitmap f23556a;

    /* renamed from: b */
    private final /* synthetic */ zzauq f23557b;

    C9850zb(zzauq zzauq, Bitmap bitmap) {
        this.f23557b = zzauq;
        this.f23556a = bitmap;
    }

    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f23556a.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
        synchronized (this.f23557b.f24843l) {
            this.f23557b.f24834c.f28220k = new zzdso();
            this.f23557b.f24834c.f28220k.f28241e = byteArrayOutputStream.toByteArray();
            this.f23557b.f24834c.f28220k.f28240d = "image/png";
            this.f23557b.f24834c.f28220k.f28239c = Integer.valueOf(1);
        }
    }
}
