package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbuf implements zzdti<Set<zzbuz<zzbrw>>> {

    /* renamed from: a */
    private final zzbtv f25886a;

    private zzbuf(zzbtv zzbtv) {
        this.f25886a = zzbtv;
    }

    /* renamed from: a */
    public static zzbuf m27808a(zzbtv zzbtv) {
        return new zzbuf(zzbtv);
    }

    public final /* synthetic */ Object get() {
        Set h = this.f25886a.mo30907h();
        zzdto.m30114a(h, "Cannot return null from a non-@Nullable @Provides method");
        return h;
    }
}
