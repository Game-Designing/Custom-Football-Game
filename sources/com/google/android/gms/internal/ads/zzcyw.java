package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;

public final class zzcyw implements zzdti<zzbbl> {

    /* renamed from: a */
    private static final zzcyw f27663a = new zzcyw();

    /* renamed from: a */
    public static zzcyw m29017a() {
        return f27663a;
    }

    public final /* synthetic */ Object get() {
        zzbbl a = zzbbm.m26395a(Executors.newSingleThreadExecutor());
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
