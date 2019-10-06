package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbtz implements zzdti<Set<zzbuz<zzbsr>>> {

    /* renamed from: a */
    private final zzbtv f25880a;

    private zzbtz(zzbtv zzbtv) {
        this.f25880a = zzbtv;
    }

    /* renamed from: a */
    public static zzbtz m27802a(zzbtv zzbtv) {
        return new zzbtz(zzbtv);
    }

    /* renamed from: b */
    public static Set<zzbuz<zzbsr>> m27803b(zzbtv zzbtv) {
        Set<zzbuz<zzbsr>> emptySet = Collections.emptySet();
        zzdto.m30114a(emptySet, "Cannot return null from a non-@Nullable @Provides method");
        return emptySet;
    }

    public final /* synthetic */ Object get() {
        return m27803b(this.f25880a);
    }
}
