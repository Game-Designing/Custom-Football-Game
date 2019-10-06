package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl.zza.zzb;

public final class zzcev implements zzdti<zzcez> {

    /* renamed from: a */
    private static final zzcev f26498a = new zzcev();

    /* renamed from: a */
    public static zzcev m28343a() {
        return f26498a;
    }

    public final /* synthetic */ Object get() {
        zzcez zzcez = new zzcez(zzb.REQUEST_WILL_PROCESS_RESPONSE, zzb.REQUEST_DID_PROCESS_RESPONSE, zzb.REQUEST_FAILED_TO_PROCESS_RESPONSE);
        zzdto.m30114a(zzcez, "Cannot return null from a non-@Nullable @Provides method");
        return zzcez;
    }
}
