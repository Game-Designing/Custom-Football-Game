package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl.zza.zzb;

public final class zzces implements zzdti<zzcez> {

    /* renamed from: a */
    private static final zzces f26495a = new zzces();

    /* renamed from: a */
    public static zzces m28340a() {
        return f26495a;
    }

    public final /* synthetic */ Object get() {
        zzcez zzcez = new zzcez(zzb.REQUEST_WILL_BUILD_URL, zzb.REQUEST_DID_BUILD_URL, zzb.REQUEST_FAILED_TO_BUILD_URL);
        zzdto.m30114a(zzcez, "Cannot return null from a non-@Nullable @Provides method");
        return zzcez;
    }
}
