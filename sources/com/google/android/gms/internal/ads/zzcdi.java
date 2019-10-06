package com.google.android.gms.internal.ads;

public final class zzcdi implements zzdti<zzbbh<zzcdb>> {

    /* renamed from: a */
    private final zzdtu<zzczt> f26415a;

    /* renamed from: b */
    private final zzdtu<zzbbh<zzcxu>> f26416b;

    /* renamed from: c */
    private final zzdtu<zzblq> f26417c;

    /* renamed from: d */
    private final zzdtu<zzcmx<zzcdb>> f26418d;

    public zzcdi(zzdtu<zzczt> zzdtu, zzdtu<zzbbh<zzcxu>> zzdtu2, zzdtu<zzblq> zzdtu3, zzdtu<zzcmx<zzcdb>> zzdtu4) {
        this.f26415a = zzdtu;
        this.f26416b = zzdtu2;
        this.f26417c = zzdtu3;
        this.f26418d = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        zzbbh a = zzbqq.m27697a((zzczt) this.f26415a.get(), (zzbbh) this.f26416b.get(), (zzblq) this.f26417c.get(), (zzcmx) this.f26418d.get());
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
