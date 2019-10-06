package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbnn implements zzdti<zzbso> {

    /* renamed from: a */
    private final zzbnk f25619a;

    /* renamed from: b */
    private final zzdtu<Set<zzbuz<zzbsr>>> f25620b;

    public zzbnn(zzbnk zzbnk, zzdtu<Set<zzbuz<zzbsr>>> zzdtu) {
        this.f25619a = zzbnk;
        this.f25620b = zzdtu;
    }

    /* renamed from: a */
    public static zzbso m27300a(zzbnk zzbnk, Set<zzbuz<zzbsr>> set) {
        zzbso a = zzbnk.mo28186a(set);
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }

    public final /* synthetic */ Object get() {
        return m27300a(this.f25619a, (Set) this.f25620b.get());
    }
}
