package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcbu implements zzdti<zzcbp> {

    /* renamed from: a */
    private final zzdtu<Executor> f26320a;

    /* renamed from: b */
    private final zzdtu<zzbmy> f26321b;

    /* renamed from: c */
    private final zzdtu<zzbva> f26322c;

    public zzcbu(zzdtu<Executor> zzdtu, zzdtu<zzbmy> zzdtu2, zzdtu<zzbva> zzdtu3) {
        this.f26320a = zzdtu;
        this.f26321b = zzdtu2;
        this.f26322c = zzdtu3;
    }

    public final /* synthetic */ Object get() {
        return new zzcbp((Executor) this.f26320a.get(), (zzbmy) this.f26321b.get(), (zzbva) this.f26322c.get());
    }
}
