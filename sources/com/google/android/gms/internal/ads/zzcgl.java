package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcgl implements zzdti<zzcgb> {

    /* renamed from: a */
    private final zzdtu<Executor> f26579a;

    /* renamed from: b */
    private final zzdtu<Context> f26580b;

    /* renamed from: c */
    private final zzdtu<Executor> f26581c;

    /* renamed from: d */
    private final zzdtu<zzclc> f26582d;

    /* renamed from: e */
    private final zzdtu<ScheduledExecutorService> f26583e;

    public zzcgl(zzdtu<Executor> zzdtu, zzdtu<Context> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<zzclc> zzdtu4, zzdtu<ScheduledExecutorService> zzdtu5) {
        this.f26579a = zzdtu;
        this.f26580b = zzdtu2;
        this.f26581c = zzdtu3;
        this.f26582d = zzdtu4;
        this.f26583e = zzdtu5;
    }

    public final /* synthetic */ Object get() {
        zzcgb zzcgb = new zzcgb((Executor) this.f26579a.get(), (Context) this.f26580b.get(), (Executor) this.f26581c.get(), (zzclc) this.f26582d.get(), (ScheduledExecutorService) this.f26583e.get());
        return zzcgb;
    }
}
