package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzchu implements zzdti<zzchq> {

    /* renamed from: a */
    private final zzdtu<Context> f26645a;

    /* renamed from: b */
    private final zzdtu<zzbai> f26646b;

    /* renamed from: c */
    private final zzdtu<zzcxv> f26647c;

    /* renamed from: d */
    private final zzdtu<Executor> f26648d;

    private zzchu(zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxv> zzdtu3, zzdtu<Executor> zzdtu4) {
        this.f26645a = zzdtu;
        this.f26646b = zzdtu2;
        this.f26647c = zzdtu3;
        this.f26648d = zzdtu4;
    }

    /* renamed from: a */
    public static zzchu m28449a(zzdtu<Context> zzdtu, zzdtu<zzbai> zzdtu2, zzdtu<zzcxv> zzdtu3, zzdtu<Executor> zzdtu4) {
        return new zzchu(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        return new zzchq((Context) this.f26645a.get(), (zzbai) this.f26646b.get(), (zzcxv) this.f26647c.get(), (Executor) this.f26648d.get());
    }
}
