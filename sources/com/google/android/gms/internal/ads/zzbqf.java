package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbqf implements zzdti<zzbqe> {

    /* renamed from: a */
    private final zzdtu<Clock> f25785a;

    /* renamed from: b */
    private final zzdtu<zzawj> f25786b;

    private zzbqf(zzdtu<Clock> zzdtu, zzdtu<zzawj> zzdtu2) {
        this.f25785a = zzdtu;
        this.f25786b = zzdtu2;
    }

    /* renamed from: a */
    public static zzbqf m27683a(zzdtu<Clock> zzdtu, zzdtu<zzawj> zzdtu2) {
        return new zzbqf(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzbqe((Clock) this.f25785a.get(), (zzawj) this.f25786b.get());
    }
}
