package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbue implements zzdti<Set<zzbuz<zzbrs>>> {

    /* renamed from: a */
    private final zzbtv f25885a;

    public zzbue(zzbtv zzbtv) {
        this.f25885a = zzbtv;
    }

    public final /* synthetic */ Object get() {
        Set d = this.f25885a.mo30903d();
        zzdto.m30114a(d, "Cannot return null from a non-@Nullable @Provides method");
        return d;
    }
}
