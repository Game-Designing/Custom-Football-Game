package com.google.android.gms.internal.ads;

public final class zzcah implements zzdti<zzbzb> {

    /* renamed from: a */
    private final zzcag f26264a;

    /* renamed from: b */
    private final zzdtu<zzcae> f26265b;

    public zzcah(zzcag zzcag, zzdtu<zzcae> zzdtu) {
        this.f26264a = zzcag;
        this.f26265b = zzdtu;
    }

    public final /* synthetic */ Object get() {
        zzcae zzcae = (zzcae) this.f26265b.get();
        zzdto.m30114a(zzcae, "Cannot return null from a non-@Nullable @Provides method");
        return zzcae;
    }
}
