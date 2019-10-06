package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbwn implements zzdti<zzbuz<zzbto>> {

    /* renamed from: a */
    private final zzbvz f25953a;

    /* renamed from: b */
    private final zzdtu<Executor> f25954b;

    private zzbwn(zzbvz zzbvz, zzdtu<Executor> zzdtu) {
        this.f25953a = zzbvz;
        this.f25954b = zzdtu;
    }

    /* renamed from: a */
    public static zzbwn m27874a(zzbvz zzbvz, zzdtu<Executor> zzdtu) {
        return new zzbwn(zzbvz, zzdtu);
    }

    public final /* synthetic */ Object get() {
        Executor executor = (Executor) this.f25954b.get();
        zzbuz zzbuz = new zzbuz(new C9426fh(this.f25953a), executor);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
