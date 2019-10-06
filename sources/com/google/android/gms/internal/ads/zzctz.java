package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcuz;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzctz<S extends zzcuz> implements zzcva<S> {

    /* renamed from: a */
    private final zzcva<S> f27381a;

    /* renamed from: b */
    private final long f27382b;

    /* renamed from: c */
    private final ScheduledExecutorService f27383c;

    public zzctz(zzcva<S> zzcva, long j, ScheduledExecutorService scheduledExecutorService) {
        this.f27381a = zzcva;
        this.f27382b = j;
        this.f27383c = scheduledExecutorService;
    }

    /* renamed from: a */
    public final zzbbh<S> mo28586a() {
        zzbbh a = this.f27381a.mo28586a();
        long j = this.f27382b;
        if (j > 0) {
            a = zzbar.m26378a(a, j, TimeUnit.MILLISECONDS, this.f27383c);
        }
        return zzbar.m26381a(a, Throwable.class, C8877Gl.f21070a, zzbbm.f25065b);
    }
}
