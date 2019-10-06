package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbwm implements zzdti<Set<zzbuz<zzbuu>>> {

    /* renamed from: a */
    private final zzdtu<zzbxe> f25952a;

    private zzbwm(zzdtu<zzbxe> zzdtu) {
        this.f25952a = zzdtu;
    }

    /* renamed from: a */
    public static zzbwm m27873a(zzdtu<zzbxe> zzdtu) {
        return new zzbwm(zzdtu);
    }

    public final /* synthetic */ Object get() {
        Set singleton = Collections.singleton(zzbuz.m27828a((zzbxe) this.f25952a.get(), zzbbm.f25065b));
        zzdto.m30114a(singleton, "Cannot return null from a non-@Nullable @Provides method");
        return singleton;
    }
}
