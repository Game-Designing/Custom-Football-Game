package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcpj implements zzdti<zzcpf> {

    /* renamed from: a */
    private final zzdtu<zzclc> f27160a;

    /* renamed from: b */
    private final zzdtu<Executor> f27161b;

    /* renamed from: c */
    private final zzdtu<Context> f27162c;

    public zzcpj(zzdtu<zzclc> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<Context> zzdtu3) {
        this.f27160a = zzdtu;
        this.f27161b = zzdtu2;
        this.f27162c = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzcpf((zzclc) this.f27160a.get(), (Executor) this.f27161b.get(), (Context) this.f27162c.get());
    }
}
