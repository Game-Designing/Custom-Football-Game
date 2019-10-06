package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcyv implements zzdti<Executor> {

    /* renamed from: a */
    private static final zzcyv f27662a = new zzcyv();

    /* renamed from: a */
    public static zzcyv m29016a() {
        return f27662a;
    }

    public final /* synthetic */ Object get() {
        Executor executor = zzbbm.f25064a;
        zzdto.m30114a(executor, "Cannot return null from a non-@Nullable @Provides method");
        return executor;
    }
}
