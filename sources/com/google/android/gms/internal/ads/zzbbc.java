package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbbc<V> {

    /* renamed from: a */
    private final zzbbr<Void> f25063a = new zzbbr<>();

    zzbbc(Iterable<? extends zzbbh<? extends V>> iterable) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzbbh zzbbh : iterable) {
            atomicInteger.incrementAndGet();
            zzbar.m26389b(this.f25063a, zzbbh);
        }
        if (atomicInteger.get() == 0) {
            this.f25063a.mo30338b(null);
            return;
        }
        for (zzbbh a : iterable) {
            a.mo28811a(new C9228Xc(this, atomicInteger), zzbbm.f25065b);
        }
    }

    /* renamed from: a */
    public final <C> zzbbh<C> mo30334a(Callable<C> callable, Executor executor) {
        return zzbar.m26379a((zzbbh<A>) this.f25063a, (zzbal<? super A, ? extends B>) new C9249Yc<Object,Object>(callable), executor);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30335a(AtomicInteger atomicInteger) {
        if (atomicInteger.decrementAndGet() == 0) {
            this.f25063a.mo30338b(null);
        }
    }
}
