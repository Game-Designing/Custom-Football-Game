package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

public final class zzczh {

    /* renamed from: a */
    private final E f27676a;

    /* renamed from: b */
    private final List<zzbbh<?>> f27677b;

    /* renamed from: c */
    private final /* synthetic */ zzczf f27678c;

    private zzczh(zzczf zzczf, E e, List<zzbbh<?>> list) {
        this.f27678c = zzczf;
        this.f27676a = e;
        this.f27677b = list;
    }

    /* renamed from: a */
    public final <O> zzczl<O> mo31321a(Callable<O> callable) {
        zzbbc b = zzbar.m26388b(this.f27677b);
        zzbbh a = b.mo30334a(C9735tm.f23028a, zzbbm.f25065b);
        zzczf zzczf = this.f27678c;
        zzczl zzczl = new zzczl(zzczf, this.f27676a, null, a, this.f27677b, b.mo30334a(callable, zzczf.f27673b), null);
        return zzczl;
    }
}
