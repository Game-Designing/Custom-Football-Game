package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbug implements zzdti<Set<zzbuz<zzbrl>>> {

    /* renamed from: a */
    private final zzbtv f25887a;

    private zzbug(zzbtv zzbtv) {
        this.f25887a = zzbtv;
    }

    /* renamed from: a */
    public static zzbug m27809a(zzbtv zzbtv) {
        return new zzbug(zzbtv);
    }

    public final /* synthetic */ Object get() {
        Set a = this.f25887a.mo30900a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
