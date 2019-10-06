package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

public final class zzczj {

    /* renamed from: a */
    private final E f27679a;

    /* renamed from: b */
    private final /* synthetic */ zzczf f27680b;

    private zzczj(zzczf zzczf, E e) {
        this.f27680b = zzczf;
        this.f27679a = e;
    }

    /* renamed from: a */
    public final <O> zzczl<O> mo31322a(zzbbh<O> zzbbh) {
        zzczl zzczl = new zzczl(this.f27680b, this.f27679a, null, zzczf.f27672a, Collections.emptyList(), zzbbh, null);
        return zzczl;
    }

    /* renamed from: a */
    public final <O> zzczl<O> mo31324a(Callable<O> callable) {
        return m29035a(callable, this.f27680b.f27673b);
    }

    /* renamed from: a */
    private final <O> zzczl<O> m29035a(Callable<O> callable, zzbbl zzbbl) {
        zzczl zzczl = new zzczl(this.f27680b, this.f27679a, null, zzczf.f27672a, Collections.emptyList(), zzbbl.mo30326a(callable), null);
        return zzczl;
    }

    /* renamed from: a */
    public final zzczl<?> mo31323a(zzczd zzczd, zzbbl zzbbl) {
        return m29035a((Callable<O>) new C9756um<O>(zzczd), zzbbl);
    }
}
