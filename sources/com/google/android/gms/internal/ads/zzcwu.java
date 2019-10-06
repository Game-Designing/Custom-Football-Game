package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcwu implements zzcva<zzcwt> {

    /* renamed from: a */
    private zzaqm f27516a;

    /* renamed from: b */
    private ScheduledExecutorService f27517b;

    /* renamed from: c */
    private Context f27518c;

    public zzcwu(zzaqm zzaqm, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.f27516a = zzaqm;
        this.f27517b = scheduledExecutorService;
        this.f27518c = context;
    }

    /* renamed from: a */
    public final zzbbh<zzcwt> mo28586a() {
        return zzbar.m26380a(zzbar.m26378a(this.f27516a.mo30004a(this.f27518c), ((Long) zzyt.m31536e().mo29599a(zzacu.f24122kd)).longValue(), TimeUnit.MILLISECONDS, this.f27517b), C9453gm.f22381a, (Executor) zzaxg.f24958a);
    }
}
