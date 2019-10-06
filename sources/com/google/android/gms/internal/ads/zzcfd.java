package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcfd implements zzdti<zzbuz<zzbtk>> {

    /* renamed from: a */
    private final zzdtu<zzcfb> f26516a;

    /* renamed from: b */
    private final zzdtu<Executor> f26517b;

    private zzcfd(zzdtu<zzcfb> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26516a = zzdtu;
        this.f26517b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfd m28355a(zzdtu<zzcfb> zzdtu, zzdtu<Executor> zzdtu2) {
        return new zzcfd(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzcfb) this.f26516a.get(), (Executor) this.f26517b.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
