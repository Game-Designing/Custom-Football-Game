package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcrb implements zzdti<zzcqz> {

    /* renamed from: a */
    private final zzdtu<Executor> f27260a;

    /* renamed from: b */
    private final zzdtu<zzchz> f27261b;

    public zzcrb(zzdtu<Executor> zzdtu, zzdtu<zzchz> zzdtu2) {
        this.f27260a = zzdtu;
        this.f27261b = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        return new zzcqz((Executor) this.f27260a.get(), (zzchz) this.f27261b.get());
    }
}
