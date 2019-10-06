package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl.zza.zzb;

public final class zzcem implements zzdti<zzcez> {

    /* renamed from: a */
    private static final zzcem f26487a = new zzcem();

    /* renamed from: a */
    public static zzcem m28334a() {
        return f26487a;
    }

    public final /* synthetic */ Object get() {
        zzcez zzcez = new zzcez(zzb.REQUEST_WILL_RENDER, zzb.REQUEST_DID_RENDER, zzb.REQUEST_FAILED_TO_RENDER);
        zzdto.m30114a(zzcez, "Cannot return null from a non-@Nullable @Provides method");
        return zzcez;
    }
}
