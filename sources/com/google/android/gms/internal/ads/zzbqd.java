package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbqd implements zzdti<zzawj> {

    /* renamed from: a */
    private final zzdtu<Clock> f25780a;

    /* renamed from: b */
    private final zzdtu<zzawu> f25781b;

    /* renamed from: c */
    private final zzdtu<zzcxv> f25782c;

    private zzbqd(zzdtu<Clock> zzdtu, zzdtu<zzawu> zzdtu2, zzdtu<zzcxv> zzdtu3) {
        this.f25780a = zzdtu;
        this.f25781b = zzdtu2;
        this.f25782c = zzdtu3;
    }

    /* renamed from: a */
    public static zzbqd m27677a(zzdtu<Clock> zzdtu, zzdtu<zzawu> zzdtu2, zzdtu<zzcxv> zzdtu3) {
        return new zzbqd(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        zzawj a = ((zzawu) this.f25781b.get()).mo30189a((Clock) this.f25780a.get(), ((zzcxv) this.f25782c.get()).f27602f);
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
