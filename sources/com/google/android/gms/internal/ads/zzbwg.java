package com.google.android.gms.internal.ads;

public final class zzbwg implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a */
    private final zzbvz f25940a;

    /* renamed from: b */
    private final zzdtu<zzbxa> f25941b;

    private zzbwg(zzbvz zzbvz, zzdtu<zzbxa> zzdtu) {
        this.f25940a = zzbvz;
        this.f25941b = zzdtu;
    }

    /* renamed from: a */
    public static zzbwg m27868a(zzbvz zzbvz, zzdtu<zzbxa> zzdtu) {
        return new zzbwg(zzbvz, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbxa) this.f25941b.get(), zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
