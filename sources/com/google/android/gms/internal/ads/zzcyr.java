package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcyr implements zzdti<Context> {

    /* renamed from: a */
    private final zzcyo f27656a;

    /* renamed from: b */
    private final zzdtu<zzcym> f27657b;

    private zzcyr(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        this.f27656a = zzcyo;
        this.f27657b = zzdtu;
    }

    /* renamed from: a */
    public static zzcyr m29013a(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        return new zzcyr(zzcyo, zzdtu);
    }

    public final /* synthetic */ Object get() {
        Context context = ((zzcym) this.f27657b.get()).f27644a;
        zzdto.m30114a(context, "Cannot return null from a non-@Nullable @Provides method");
        return context;
    }
}
