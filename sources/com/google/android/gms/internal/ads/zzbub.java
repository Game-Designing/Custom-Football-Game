package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbub implements zzdti<Set<zzbuz<zzbto>>> {

    /* renamed from: a */
    private final zzbtv f25882a;

    private zzbub(zzbtv zzbtv) {
        this.f25882a = zzbtv;
    }

    /* renamed from: a */
    public static zzbub m27805a(zzbtv zzbtv) {
        return new zzbub(zzbtv);
    }

    public final /* synthetic */ Object get() {
        Set emptySet = Collections.emptySet();
        zzdto.m30114a(emptySet, "Cannot return null from a non-@Nullable @Provides method");
        return emptySet;
    }
}
