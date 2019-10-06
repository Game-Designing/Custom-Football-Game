package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbty implements zzdti<Set<zzbuz<zzbrx>>> {

    /* renamed from: a */
    private final zzbtv f25879a;

    private zzbty(zzbtv zzbtv) {
        this.f25879a = zzbtv;
    }

    /* renamed from: a */
    public static zzbty m27801a(zzbtv zzbtv) {
        return new zzbty(zzbtv);
    }

    public final /* synthetic */ Object get() {
        Set emptySet = Collections.emptySet();
        zzdto.m30114a(emptySet, "Cannot return null from a non-@Nullable @Provides method");
        return emptySet;
    }
}
