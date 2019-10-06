package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

public final class zzbqp implements zzdti<zzbuz<zzo>> {

    /* renamed from: a */
    private final zzbqo f25800a;

    /* renamed from: b */
    private final zzdtu<zzbpv> f25801b;

    private zzbqp(zzbqo zzbqo, zzdtu<zzbpv> zzdtu) {
        this.f25800a = zzbqo;
        this.f25801b = zzdtu;
    }

    /* renamed from: a */
    public static zzbqp m27696a(zzbqo zzbqo, zzdtu<zzbpv> zzdtu) {
        return new zzbqp(zzbqo, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzbpv) this.f25801b.get(), zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
