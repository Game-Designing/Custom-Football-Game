package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

public final class zzcgz implements zzdti<zzbbh<zzcxu>> {

    /* renamed from: a */
    private final zzdtu<zzczt> f26603a;

    /* renamed from: b */
    private final zzdtu<zzchl> f26604b;

    /* renamed from: c */
    private final zzdtu<zzchq> f26605c;

    /* renamed from: d */
    private final zzdtu<zzbbh<zzarx>> f26606d;

    /* renamed from: e */
    private final zzdtu<zzcxv> f26607e;

    private zzcgz(zzdtu<zzczt> zzdtu, zzdtu<zzchl> zzdtu2, zzdtu<zzchq> zzdtu3, zzdtu<zzbbh<zzarx>> zzdtu4, zzdtu<zzcxv> zzdtu5) {
        this.f26603a = zzdtu;
        this.f26604b = zzdtu2;
        this.f26605c = zzdtu3;
        this.f26606d = zzdtu4;
        this.f26607e = zzdtu5;
    }

    /* renamed from: a */
    public static zzcgz m28427a(zzdtu<zzczt> zzdtu, zzdtu<zzchl> zzdtu2, zzdtu<zzchq> zzdtu3, zzdtu<zzbbh<zzarx>> zzdtu4, zzdtu<zzcxv> zzdtu5) {
        zzcgz zzcgz = new zzcgz(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
        return zzcgz;
    }

    public final /* synthetic */ Object get() {
        zzcze zzcze;
        zzczt zzczt = (zzczt) this.f26603a.get();
        zzchl zzchl = (zzchl) this.f26604b.get();
        zzchq zzchq = (zzchq) this.f26605c.get();
        zzbbh zzbbh = (zzbbh) this.f26606d.get();
        zzcxv zzcxv = (zzcxv) this.f26607e.get();
        zzk.zzlm().mo32315a();
        if (zzcxv.f27600d.f29741s != null) {
            zzcze = zzczt.mo31319a(zzczs.SERVER_TRANSACTION, zzbbh).mo31328a(zzchq.mo31164a()).mo31325a();
        } else {
            zzcze = zzczt.mo31319a(zzczs.SERVER_TRANSACTION, zzbbh).mo31327a((zzbal<O, O2>) zzchl).mo31325a();
        }
        zzdto.m30114a(zzcze, "Cannot return null from a non-@Nullable @Provides method");
        return zzcze;
    }
}
