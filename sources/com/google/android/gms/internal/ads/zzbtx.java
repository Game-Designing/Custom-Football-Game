package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbtx implements zzdti<zzbrm> {

    /* renamed from: a */
    private final zzbtv f25877a;

    /* renamed from: b */
    private final zzdtu<Set<zzbuz<zzbro>>> f25878b;

    private zzbtx(zzbtv zzbtv, zzdtu<Set<zzbuz<zzbro>>> zzdtu) {
        this.f25877a = zzbtv;
        this.f25878b = zzdtu;
    }

    /* renamed from: a */
    public static zzbtx m27800a(zzbtv zzbtv, zzdtu<Set<zzbuz<zzbro>>> zzdtu) {
        return new zzbtx(zzbtv, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbrm a = this.f25877a.mo30898a((Set) this.f25878b.get());
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
