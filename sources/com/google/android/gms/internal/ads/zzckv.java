package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzckv implements zzcjv<zzbnf> {

    /* renamed from: a */
    private final zzboc f26762a;

    /* renamed from: b */
    private final zzckb f26763b;

    /* renamed from: c */
    private final zzbbl f26764c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzbrm f26765d;

    /* renamed from: e */
    private final ScheduledExecutorService f26766e;

    public zzckv(zzboc zzboc, zzckb zzckb, zzbrm zzbrm, ScheduledExecutorService scheduledExecutorService, zzbbl zzbbl) {
        this.f26762a = zzboc;
        this.f26763b = zzckb;
        this.f26765d = zzbrm;
        this.f26766e = scheduledExecutorService;
        this.f26764c = zzbbl;
    }

    /* renamed from: b */
    public final boolean mo31186b(zzcxu zzcxu, zzcxm zzcxm) {
        return zzcxu.f27595a.f27589a.mo31285a() != null && this.f26763b.mo31186b(zzcxu, zzcxm);
    }

    /* renamed from: a */
    public final zzbbh<zzbnf> mo31185a(zzcxu zzcxu, zzcxm zzcxm) {
        return this.f26764c.mo30326a((Callable<T>) new C8938Jj<T>(this, zzcxu, zzcxm));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final /* synthetic */ zzbnf mo31195c(zzcxu zzcxu, zzcxm zzcxm) throws Exception {
        return this.f26762a.mo29320a(new zzbpr(zzcxu, zzcxm, null), new zzbop(zzcxu.f27595a.f27589a.mo31285a(), new C8959Kj(this, zzcxu, zzcxm))).mo28061a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final /* synthetic */ void mo31196d(zzcxu zzcxu, zzcxm zzcxm) {
        zzbar.m26383a(zzbar.m26378a(this.f26763b.mo31185a(zzcxu, zzcxm), (long) zzcxm.f27543I, TimeUnit.SECONDS, this.f26766e), (zzban<? super V>) new C8980Lj<Object>(this), (Executor) this.f26764c);
    }
}
