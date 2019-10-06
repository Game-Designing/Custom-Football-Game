package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbul implements zzdti<Set<zzbuz<zzue>>> {

    /* renamed from: a */
    private final zzbtv f25892a;

    private zzbul(zzbtv zzbtv) {
        this.f25892a = zzbtv;
    }

    /* renamed from: a */
    public static zzbul m27815a(zzbtv zzbtv) {
        return new zzbul(zzbtv);
    }

    public final /* synthetic */ Object get() {
        Set emptySet = Collections.emptySet();
        zzdto.m30114a(emptySet, "Cannot return null from a non-@Nullable @Provides method");
        return emptySet;
    }
}
