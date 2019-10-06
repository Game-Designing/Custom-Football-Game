package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcbv implements zzdti<zzcbi> {

    /* renamed from: a */
    private final zzdtu<Context> f26323a;

    /* renamed from: b */
    private final zzdtu<zzcxv> f26324b;

    /* renamed from: c */
    private final zzdtu<Executor> f26325c;

    /* renamed from: d */
    private final zzdtu<zzcdn> f26326d;

    public zzcbv(zzdtu<Context> zzdtu, zzdtu<zzcxv> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<zzcdn> zzdtu4) {
        this.f26323a = zzdtu;
        this.f26324b = zzdtu2;
        this.f26325c = zzdtu3;
        this.f26326d = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return new zzcbi((Context) this.f26323a.get(), (zzcxv) this.f26324b.get(), (Executor) this.f26325c.get(), (zzcdn) this.f26326d.get());
    }
}
