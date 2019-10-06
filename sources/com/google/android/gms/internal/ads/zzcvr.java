package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcvr implements zzdti<zzcvo> {

    /* renamed from: a */
    private final zzdtu<zzawi> f27468a;

    /* renamed from: b */
    private final zzdtu<Context> f27469b;

    /* renamed from: c */
    private final zzdtu<ScheduledExecutorService> f27470c;

    /* renamed from: d */
    private final zzdtu<Executor> f27471d;

    public zzcvr(zzdtu<zzawi> zzdtu, zzdtu<Context> zzdtu2, zzdtu<ScheduledExecutorService> zzdtu3, zzdtu<Executor> zzdtu4) {
        this.f27468a = zzdtu;
        this.f27469b = zzdtu2;
        this.f27470c = zzdtu3;
        this.f27471d = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return new zzcvo((zzawi) this.f27468a.get(), (Context) this.f27469b.get(), (ScheduledExecutorService) this.f27470c.get(), (Executor) this.f27471d.get());
    }
}
