package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqg implements zzdti<zzbuz<zzbvg>> {

    /* renamed from: a */
    private final zzdtu<zzbvh> f25787a;

    /* renamed from: b */
    private final zzdtu<Executor> f25788b;

    private zzbqg(zzdtu<zzbvh> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f25787a = zzdtu;
        this.f25788b = zzdtu2;
    }

    /* renamed from: a */
    public static zzbqg m27684a(zzdtu<zzbvh> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzbqg(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbvh) this.f25787a.get(), (Executor) this.f25788b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
