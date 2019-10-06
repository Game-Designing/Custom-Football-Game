package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzbpq implements zzdti<zzbpk> {

    /* renamed from: a */
    private final zzdtu<Executor> f25758a;

    /* renamed from: b */
    private final zzdtu<ScheduledExecutorService> f25759b;

    /* renamed from: c */
    private final zzdtu<zzbbh<zzbph>> f25760c;

    public zzbpq(zzdtu<Executor> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2, zzdtu<zzbbh<zzbph>> zzdtu3) {
        this.f25758a = zzdtu;
        this.f25759b = zzdtu2;
        this.f25760c = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzbpk((Executor) this.f25758a.get(), (ScheduledExecutorService) this.f25759b.get(), (zzbbh) this.f25760c.get());
    }
}
