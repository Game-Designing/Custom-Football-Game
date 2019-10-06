package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl.zza.zzb;

public final class zzceu implements zzdti<zzcez> {

    /* renamed from: a */
    private static final zzceu f26497a = new zzceu();

    /* renamed from: a */
    public static zzceu m28342a() {
        return f26497a;
    }

    public final /* synthetic */ Object get() {
        zzcez zzcez = new zzcez(zzb.REQUEST_WILL_MAKE_NETWORK_REQUEST, zzb.REQUEST_DID_RECEIVE_NETWORK_RESPONSE, zzb.REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST);
        zzdto.m30114a(zzcez, "Cannot return null from a non-@Nullable @Provides method");
        return zzcez;
    }
}
