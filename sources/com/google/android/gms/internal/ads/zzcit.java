package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcit implements zzdti<zzcig> {

    /* renamed from: a */
    private final zzdtu<Context> f26668a;

    /* renamed from: b */
    private final zzdtu<Executor> f26669b;

    /* renamed from: c */
    private final zzdtu<zzasm> f26670c;

    /* renamed from: d */
    private final zzdtu<zzblp> f26671d;

    /* renamed from: e */
    private final zzdtu<zzasl> f26672e;

    private zzcit(zzdtu<Context> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<zzasm> zzdtu3, zzdtu<zzblp> zzdtu4, zzdtu<zzasl> zzdtu5) {
        this.f26668a = zzdtu;
        this.f26669b = zzdtu2;
        this.f26670c = zzdtu3;
        this.f26671d = zzdtu4;
        this.f26672e = zzdtu5;
    }

    /* renamed from: a */
    public static zzcit m28463a(zzdtu<Context> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<zzasm> zzdtu3, zzdtu<zzblp> zzdtu4, zzdtu<zzasl> zzdtu5) {
        zzcit zzcit = new zzcit(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
        return zzcit;
    }

    public final /* synthetic */ Object get() {
        zzcig zzcig = new zzcig((Context) this.f26668a.get(), (Executor) this.f26669b.get(), (zzasm) this.f26670c.get(), (zzblp) this.f26671d.get(), (zzasl) this.f26672e.get());
        return zzcig;
    }
}
