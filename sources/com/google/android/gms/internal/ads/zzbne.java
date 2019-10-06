package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

public final class zzbne implements zzdti<zzbtb> {

    /* renamed from: a */
    private final zzdtu<ScheduledExecutorService> f25599a;

    /* renamed from: b */
    private final zzdtu<Clock> f25600b;

    public zzbne(zzdtu<ScheduledExecutorService> zzdtu, zzdtu<Clock> zzdtu2) {
        this.f25599a = zzdtu;
        this.f25600b = zzdtu2;
    }

    /* renamed from: a */
    public static zzbtb m27283a(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        zzbtb zzbtb = new zzbtb(scheduledExecutorService, clock);
        zzdto.m30114a(zzbtb, "Cannot return null from a non-@Nullable @Provides method");
        return zzbtb;
    }

    public final /* synthetic */ Object get() {
        return m27283a((ScheduledExecutorService) this.f25599a.get(), (Clock) this.f25600b.get());
    }
}
