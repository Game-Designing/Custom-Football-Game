package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public final class zzcyb<T> {

    /* renamed from: a */
    private final Deque<zzbbh<T>> f27628a = new LinkedBlockingDeque();

    /* renamed from: b */
    private final Callable<T> f27629b;

    /* renamed from: c */
    private final zzbbl f27630c;

    public zzcyb(Callable<T> callable, zzbbl zzbbl) {
        this.f27629b = callable;
        this.f27630c = zzbbl;
    }

    /* renamed from: a */
    public final synchronized void mo31305a(int i) {
        int size = i - this.f27628a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f27628a.add(this.f27630c.mo30326a(this.f27629b));
        }
    }

    /* renamed from: a */
    public final synchronized zzbbh<T> mo31304a() {
        mo31305a(1);
        return (zzbbh) this.f27628a.poll();
    }

    /* renamed from: a */
    public final synchronized void mo31306a(zzbbh<T> zzbbh) {
        this.f27628a.addFirst(zzbbh);
    }
}
