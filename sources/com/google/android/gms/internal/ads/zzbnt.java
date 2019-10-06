package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbnt implements zzdti<Set<zzbuz<zzbsr>>> {

    /* renamed from: a */
    private final zzbnk f25631a;

    /* renamed from: b */
    private final zzdtu<zzbov> f25632b;

    public zzbnt(zzbnk zzbnk, zzdtu<zzbov> zzdtu) {
        this.f25631a = zzbnk;
        this.f25632b = zzdtu;
    }

    /* renamed from: a */
    public static Set<zzbuz<zzbsr>> m27306a(zzbnk zzbnk, zzbov zzbov) {
        Set<zzbuz<zzbsr>> singleton = Collections.singleton(new zzbuz(zzbov, zzbbm.f25065b));
        zzdto.m30114a(singleton, "Cannot return null from a non-@Nullable @Provides method");
        return singleton;
    }

    public final /* synthetic */ Object get() {
        return m27306a(this.f25631a, (zzbov) this.f25632b.get());
    }
}
