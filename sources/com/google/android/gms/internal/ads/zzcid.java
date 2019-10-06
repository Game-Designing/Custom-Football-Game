package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcid implements zzdti<C9362cj> {

    /* renamed from: a */
    private final zzdtu<Context> f26657a;

    /* renamed from: b */
    private final zzdtu<zzavg> f26658b;

    private zzcid(zzdtu<Context> zzdtu, zzdtu<zzavg> zzdtu2) {
        this.f26657a = zzdtu;
        this.f26658b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcid m28455a(zzdtu<Context> zzdtu, zzdtu<zzavg> zzdtu2) {
        return new zzcid(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new C9362cj((Context) this.f26657a.get(), (zzavg) this.f26658b.get());
    }
}
