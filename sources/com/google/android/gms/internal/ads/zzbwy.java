package com.google.android.gms.internal.ads;

public final class zzbwy implements zzdti<zzcjv<zzbvx>> {

    /* renamed from: a */
    private final zzdtu<zzczt> f25967a;

    /* renamed from: b */
    private final zzdtu<zzbbl> f25968b;

    /* renamed from: c */
    private final zzdtu<zzclq> f25969c;

    /* renamed from: d */
    private final zzdtu<zzcoc> f25970d;

    public zzbwy(zzdtu<zzczt> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<zzclq> zzdtu3, zzdtu<zzcoc> zzdtu4) {
        this.f25967a = zzdtu;
        this.f25968b = zzdtu2;
        this.f25969c = zzdtu3;
        this.f25970d = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        zzcoe zzcoe = new zzcoe((zzczt) this.f25967a.get(), (zzbbl) this.f25968b.get(), (zzcoc) this.f25970d.get(), (zzclq) this.f25969c.get());
        zzdto.m30114a(zzcoe, "Cannot return null from a non-@Nullable @Provides method");
        return zzcoe;
    }
}
