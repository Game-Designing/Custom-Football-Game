package com.google.android.gms.internal.ads;

public final class zzboj implements zzdti<zzcjv<zzbnf>> {

    /* renamed from: a */
    private final zzdtu<zzczt> f25662a;

    /* renamed from: b */
    private final zzdtu<zzbbl> f25663b;

    /* renamed from: c */
    private final zzdtu<zzckm> f25664c;

    /* renamed from: d */
    private final zzdtu<zzcoc> f25665d;

    public zzboj(zzdtu<zzczt> zzdtu, zzdtu<zzbbl> zzdtu2, zzdtu<zzckm> zzdtu3, zzdtu<zzcoc> zzdtu4) {
        this.f25662a = zzdtu;
        this.f25663b = zzdtu2;
        this.f25664c = zzdtu3;
        this.f25665d = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        zzcoe zzcoe = new zzcoe((zzczt) this.f25662a.get(), (zzbbl) this.f25663b.get(), (zzcoc) this.f25665d.get(), (zzckm) this.f25664c.get());
        zzdto.m30114a(zzcoe, "Cannot return null from a non-@Nullable @Provides method");
        return zzcoe;
    }
}
