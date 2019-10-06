package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcku implements zzdti<zzckr> {

    /* renamed from: a */
    private final zzdtu<Context> f26758a;

    /* renamed from: b */
    private final zzdtu<Executor> f26759b;

    /* renamed from: c */
    private final zzdtu<zzbws> f26760c;

    /* renamed from: d */
    private final zzdtu<zzcxk> f26761d;

    public zzcku(zzdtu<Context> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<zzbws> zzdtu3, zzdtu<zzcxk> zzdtu4) {
        this.f26758a = zzdtu;
        this.f26759b = zzdtu2;
        this.f26760c = zzdtu3;
        this.f26761d = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        return new zzckr((Context) this.f26758a.get(), (Executor) this.f26759b.get(), (zzbws) this.f26760c.get(), (zzcxk) this.f26761d.get());
    }
}
