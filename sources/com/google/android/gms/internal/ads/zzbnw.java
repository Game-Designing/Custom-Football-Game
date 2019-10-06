package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbnw implements zzdti<Set<zzbuz<zzue>>> {

    /* renamed from: a */
    private final zzbnk f25637a;

    /* renamed from: b */
    private final zzdtu<zzbov> f25638b;

    public zzbnw(zzbnk zzbnk, zzdtu<zzbov> zzdtu) {
        this.f25637a = zzbnk;
        this.f25638b = zzdtu;
    }

    public final /* synthetic */ Object get() {
        Set singleton = Collections.singleton(new zzbuz((zzbov) this.f25638b.get(), zzbbm.f25065b));
        zzdto.m30114a(singleton, "Cannot return null from a non-@Nullable @Provides method");
        return singleton;
    }
}
