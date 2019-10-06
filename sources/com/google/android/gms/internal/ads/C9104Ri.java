package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.Ri */
final /* synthetic */ class C9104Ri implements Callable {

    /* renamed from: a */
    private final zzdh f21662a;

    /* renamed from: b */
    private final Context f21663b;

    C9104Ri(zzdh zzdh, Context context) {
        this.f21662a = zzdh;
        this.f21663b = context;
    }

    public final Object call() {
        zzdh zzdh = this.f21662a;
        return zzdh.mo31483a().zza(this.f21663b);
    }
}
