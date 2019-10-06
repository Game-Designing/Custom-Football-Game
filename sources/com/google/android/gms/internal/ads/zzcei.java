package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcei implements zzdti<zzbuz<zzbrw>> {

    /* renamed from: a */
    private final zzdtu<zzcep> f26480a;

    /* renamed from: b */
    private final zzdtu<Executor> f26481b;

    private zzcei(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26480a = zzdtu;
        this.f26481b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcei m28330a(zzdtu<zzcep> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcei(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcep) this.f26480a.get(), (Executor) this.f26481b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
