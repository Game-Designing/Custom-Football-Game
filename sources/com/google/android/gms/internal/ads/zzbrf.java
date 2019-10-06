package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqy.zza;

public final class zzbrf implements zzdti<zza> {

    /* renamed from: a */
    private final zzbqy f25833a;

    private zzbrf(zzbqy zzbqy) {
        this.f25833a = zzbqy;
    }

    /* renamed from: a */
    public static zzbrf m27723a(zzbqy zzbqy) {
        return new zzbrf(zzbqy);
    }

    public final /* synthetic */ Object get() {
        zza a = this.f25833a.mo30867a();
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
