package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbqs implements zzdti<zzbqr> {

    /* renamed from: a */
    private final zzdtu<Context> f25807a;

    /* renamed from: b */
    private final zzdtu<zzcxv> f25808b;

    /* renamed from: c */
    private final zzdtu<zzbai> f25809c;

    /* renamed from: d */
    private final zzdtu<zzaxb> f25810d;

    /* renamed from: e */
    private final zzdtu<zzcgb> f25811e;

    private zzbqs(zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<zzbai> zzdtu3, zzdtu<zzaxb> zzdtu4, zzdtu<zzcgb> zzdtu5) {
        this.f25807a = zzdtu;
        this.f25808b = zzdtu2;
        this.f25809c = zzdtu3;
        this.f25810d = zzdtu4;
        this.f25811e = zzdtu5;
    }

    /* renamed from: a */
    public static zzbqs m27700a(zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<zzbai> zzdtu3, zzdtu<zzaxb> zzdtu4, zzdtu<zzcgb> zzdtu5) {
        zzbqs zzbqs = new zzbqs(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
        return zzbqs;
    }

    public final /* synthetic */ Object get() {
        zzbqr zzbqr = new zzbqr((Context) this.f25807a.get(), (zzcxv) this.f25808b.get(), (zzbai) this.f25809c.get(), (zzaxb) this.f25810d.get(), (zzcgb) this.f25811e.get());
        return zzbqr;
    }
}
