package com.google.android.gms.internal.ads;

public final class zzcdh implements zzdti<zzcjv<zzcdb>> {

    /* renamed from: a */
    private final zzdtu<zzcoe<zzcdb, zzams, zzclb>> f26412a;

    /* renamed from: b */
    private final zzdtu<zzcoe<zzcdb, zzams, zzcla>> f26413b;

    /* renamed from: c */
    private final zzdtu<zzcxv> f26414c;

    public zzcdh(zzdtu<zzcoe<zzcdb, zzams, zzclb>> zzdtu, zzdtu<zzcoe<zzcdb, zzams, zzcla>> zzdtu2, zzdtu<zzcxv> zzdtu3) {
        this.f26412a = zzdtu;
        this.f26413b = zzdtu2;
        this.f26414c = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        zzcjv zzcjv;
        zzdtu<zzcoe<zzcdb, zzams, zzclb>> zzdtu = this.f26412a;
        zzdtu<zzcoe<zzcdb, zzams, zzcla>> zzdtu2 = this.f26413b;
        if (((zzcxv) this.f26414c.get()).f27611o.contains("new_rewarded")) {
            zzcjv = (zzcjv) zzdtu2.get();
        } else {
            zzcjv = (zzcjv) zzdtu.get();
        }
        zzdto.m30114a(zzcjv, "Cannot return null from a non-@Nullable @Provides method");
        return zzcjv;
    }
}
