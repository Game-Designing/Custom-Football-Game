package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcbh implements zzdti<zzcbd> {

    /* renamed from: a */
    private final zzdtu<Executor> f26311a;

    /* renamed from: b */
    private final zzdtu<zzcau> f26312b;

    public zzcbh(zzdtu<Executor> zzdtu, zzdtu<zzcau> zzdtu2) {
        this.f26311a = zzdtu;
        this.f26312b = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return new zzcbd((Executor) this.f26311a.get(), (zzcau) this.f26312b.get());
    }
}
