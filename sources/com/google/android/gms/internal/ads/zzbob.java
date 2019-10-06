package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzbob implements zzdti<zzcva<zzcrd>> {

    /* renamed from: a */
    private final zzdtu<zzcre> f25648a;

    /* renamed from: b */
    private final zzdtu<ScheduledExecutorService> f25649b;

    public zzbob(zzdtu<zzcre> zzdtu, zzdtu<ScheduledExecutorService> zzdtu2) {
        this.f25648a = zzdtu;
        this.f25649b = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        zzctz zzctz = new zzctz((zzcre) this.f25648a.get(), 0, (ScheduledExecutorService) this.f25649b.get());
        zzdto.m30114a(zzctz, "Cannot return null from a non-@Nullable @Provides method");
        return zzctz;
    }
}
