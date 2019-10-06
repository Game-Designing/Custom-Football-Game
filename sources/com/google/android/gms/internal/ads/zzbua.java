package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Collections;
import java.util.Set;

public final class zzbua implements zzdti<Set<zzbuz<zzo>>> {

    /* renamed from: a */
    private final zzbtv f25881a;

    private zzbua(zzbtv zzbtv) {
        this.f25881a = zzbtv;
    }

    /* renamed from: a */
    public static zzbua m27804a(zzbtv zzbtv) {
        return new zzbua(zzbtv);
    }

    public final /* synthetic */ Object get() {
        Set emptySet = Collections.emptySet();
        zzdto.m30114a(emptySet, "Cannot return null from a non-@Nullable @Provides method");
        return emptySet;
    }
}
