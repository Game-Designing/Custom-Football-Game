package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl.zza.zzb;

public final class zzcel implements zzdti<zzcez> {

    /* renamed from: a */
    private static final zzcel f26486a = new zzcel();

    /* renamed from: a */
    public static zzcel m28333a() {
        return f26486a;
    }

    public final /* synthetic */ Object get() {
        zzcez zzcez = new zzcez(zzb.REQUEST_WILL_UPDATE_SIGNALS, zzb.REQUEST_DID_UPDATE_SIGNALS, zzb.REQUEST_FAILED_TO_UPDATE_SIGNALS);
        zzdto.m30114a(zzcez, "Cannot return null from a non-@Nullable @Provides method");
        return zzcez;
    }
}
