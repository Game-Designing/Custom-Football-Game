package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl.zza.zzb;

public final class zzcet implements zzdti<zzcez> {

    /* renamed from: a */
    private static final zzcet f26496a = new zzcet();

    /* renamed from: a */
    public static zzcet m28341a() {
        return f26496a;
    }

    public final /* synthetic */ Object get() {
        zzcez zzcez = new zzcez(zzb.REQUEST_WILL_UPDATE_GMS_SIGNALS, zzb.REQUEST_DID_UPDATE_GMS_SIGNALS, zzb.REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS);
        zzdto.m30114a(zzcez, "Cannot return null from a non-@Nullable @Provides method");
        return zzcez;
    }
}
