package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

public final class zzbwh implements zzdti<zzbuz<zzo>> {

    /* renamed from: a */
    private final zzbvz f25942a;

    /* renamed from: b */
    private final zzdtu<zzbxa> f25943b;

    private zzbwh(zzbvz zzbvz, zzdtu<zzbxa> zzdtu) {
        this.f25942a = zzbvz;
        this.f25943b = zzdtu;
    }

    /* renamed from: a */
    public static zzbwh m27869a(zzbvz zzbvz, zzdtu<zzbxa> zzdtu) {
        return new zzbwh(zzbvz, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbxa) this.f25943b.get(), zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
