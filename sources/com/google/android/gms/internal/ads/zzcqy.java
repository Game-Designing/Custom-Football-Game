package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

public final class zzcqy implements zzdti<zzbbh<zzcrc>> {

    /* renamed from: a */
    private final zzdtu<zzczt> f27255a;

    /* renamed from: b */
    private final zzdtu<zzcqz> f27256b;

    /* renamed from: c */
    private final zzdtu<zzbbh<zzarx>> f27257c;

    public zzcqy(zzdtu<zzczt> zzdtu, zzdtu<zzcqz> zzdtu2, zzdtu<zzbbh<zzarx>> zzdtu3) {
        this.f27255a = zzdtu;
        this.f27256b = zzdtu2;
        this.f27257c = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        zzcqz zzcqz = (zzcqz) this.f27256b.get();
        zzcze a = ((zzczt) this.f27255a.get()).mo31319a(zzczs.GENERATE_SIGNALS, (zzbbh) this.f27257c.get()).mo31327a((zzbal<O, O2>) zzcqz).mo31326a((long) ((Integer) zzyt.m31536e().mo29599a(zzacu.f24159qe)).intValue(), TimeUnit.SECONDS).mo31325a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
