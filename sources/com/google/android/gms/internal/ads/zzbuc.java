package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbuc implements zzdti<Set<zzbuz<zzxr>>> {

    /* renamed from: a */
    private final zzbtv f25883a;

    private zzbuc(zzbtv zzbtv) {
        this.f25883a = zzbtv;
    }

    /* renamed from: a */
    public static zzbuc m27806a(zzbtv zzbtv) {
        return new zzbuc(zzbtv);
    }

    public final /* synthetic */ Object get() {
        Set g = this.f25883a.mo30906g();
        zzdto.m30114a(g, "Cannot return null from a non-@Nullable @Provides method");
        return g;
    }
}
