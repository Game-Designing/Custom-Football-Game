package com.google.android.gms.internal.ads;

public final class zzcdm implements zzdti<zzcjv<zzcdb>> {

    /* renamed from: a */
    private final zzdtu<zzczt> f26422a;

    /* renamed from: b */
    private final zzdtu<zzbbl> f26423b;

    /* renamed from: c */
    private final zzdtu<zzcnd> f26424c;

    /* renamed from: d */
    private final zzdtu<zzcoc> f26425d;

    public zzcdm(zzdtu<zzczt> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<zzcnd> zzdtu3, zzdtu<zzcoc> zzdtu4) {
        this.f26422a = zzdtu;
        this.f26423b = zzdtu2;
        this.f26424c = zzdtu3;
        this.f26425d = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        zzcoe zzcoe = new zzcoe((zzczt) this.f26422a.get(), (zzbbl) this.f26423b.get(), (zzcoc) this.f26425d.get(), (zzcnd) this.f26424c.get());
        zzdto.m30114a(zzcoe, "Cannot return null from a non-@Nullable @Provides method");
        return zzcoe;
    }
}
