package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcwq implements zzcva<zzcwp> {

    /* renamed from: a */
    private zzamg f27507a;

    /* renamed from: b */
    private ScheduledExecutorService f27508b;

    /* renamed from: c */
    private boolean f27509c;

    /* renamed from: d */
    private ApplicationInfo f27510d;

    public zzcwq(zzamg zzamg, ScheduledExecutorService scheduledExecutorService, boolean z, ApplicationInfo applicationInfo) {
        this.f27507a = zzamg;
        this.f27508b = scheduledExecutorService;
        this.f27509c = z;
        this.f27510d = applicationInfo;
    }

    /* renamed from: a */
    public final zzbbh<zzcwp> mo28586a() {
        if (!this.f27509c) {
            return zzbar.m26375a((Throwable) new Exception("Auto Collect Location is false."));
        }
        return zzbar.m26380a(zzbar.m26378a(this.f27507a.mo29814a(this.f27510d), ((Long) zzyt.m31536e().mo29599a(zzacu.f24025Vc)).longValue(), TimeUnit.MILLISECONDS, this.f27508b), C9431fm.f22300a, (Executor) zzaxg.f24958a);
    }
}
