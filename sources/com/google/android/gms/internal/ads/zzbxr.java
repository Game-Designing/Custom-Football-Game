package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbxr implements zzdti<Set<String>> {

    /* renamed from: a */
    private final zzdtu<zzbzc> f26009a;

    public zzbxr(zzdtu<zzbzc> zzdtu) {
        this.f26009a = zzdtu;
    }

    public final /* synthetic */ Object get() {
        Set set;
        if (((zzbzc) this.f26009a.get()).mo31038d() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        zzdto.m30114a(set, "Cannot return null from a non-@Nullable @Provides method");
        return set;
    }
}
