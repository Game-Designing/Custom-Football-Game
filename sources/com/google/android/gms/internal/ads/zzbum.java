package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbum implements zzdti<Set<zzbuz<zzbvg>>> {

    /* renamed from: a */
    private final zzbtv f25893a;

    private zzbum(zzbtv zzbtv) {
        this.f25893a = zzbtv;
    }

    /* renamed from: a */
    public static zzbum m27816a(zzbtv zzbtv) {
        return new zzbum(zzbtv);
    }

    public final /* synthetic */ Object get() {
        Set emptySet = Collections.emptySet();
        zzdto.m30114a(emptySet, "Cannot return null from a non-@Nullable @Provides method");
        return emptySet;
    }
}
