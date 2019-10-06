package com.google.android.gms.internal.ads;

public final class zzbyg implements zzdti<zzbzb> {

    /* renamed from: a */
    private final zzbyc f26071a;

    /* renamed from: b */
    private final zzdtu<zzbxx> f26072b;

    public zzbyg(zzbyc zzbyc, zzdtu<zzbxx> zzdtu) {
        this.f26071a = zzbyc;
        this.f26072b = zzdtu;
    }

    public final /* synthetic */ Object get() {
        zzbxx zzbxx = (zzbxx) this.f26072b.get();
        zzdto.m30114a(zzbxx, "Cannot return null from a non-@Nullable @Provides method");
        return zzbxx;
    }
}
