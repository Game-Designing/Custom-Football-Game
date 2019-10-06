package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbuh implements zzdti<Set<zzbuz<zzbsr>>> {

    /* renamed from: a */
    private final zzbtv f25888a;

    private zzbuh(zzbtv zzbtv) {
        this.f25888a = zzbtv;
    }

    /* renamed from: a */
    public static zzbuh m27810a(zzbtv zzbtv) {
        return new zzbuh(zzbtv);
    }

    /* renamed from: b */
    public static Set<zzbuz<zzbsr>> m27811b(zzbtv zzbtv) {
        Set<zzbuz<zzbsr>> b = zzbtv.mo30901b();
        zzdto.m30114a(b, "Cannot return null from a non-@Nullable @Provides method");
        return b;
    }

    public final /* synthetic */ Object get() {
        return m27811b(this.f25888a);
    }
}
