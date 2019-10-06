package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbwd implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a */
    private final zzbvz f25933a;

    /* renamed from: b */
    private final zzdtu<Context> f25934b;

    /* renamed from: c */
    private final zzdtu<zzbai> f25935c;

    /* renamed from: d */
    private final zzdtu<zzcxm> f25936d;

    /* renamed from: e */
    private final zzdtu<zzcxv> f25937e;

    private zzbwd(zzbvz zzbvz, zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzcxv> zzdtu4) {
        this.f25933a = zzbvz;
        this.f25934b = zzdtu;
        this.f25935c = zzdtu2;
        this.f25936d = zzdtu3;
        this.f25937e = zzdtu4;
    }

    /* renamed from: a */
    public static zzbwd m27865a(zzbvz zzbvz, zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxm> zzdtu3, zzdtu<zzcxv> zzdtu4) {
        zzbwd zzbwd = new zzbwd(zzbvz, zzdtu, zzdtu2, zzdtu3, zzdtu4);
        return zzbwd;
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz(new C9404eh((Context) this.f25934b.get(), (zzbai) this.f25935c.get(), (zzcxm) this.f25936d.get(), (zzcxv) this.f25937e.get()), zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
