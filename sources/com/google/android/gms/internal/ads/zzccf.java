package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzccf implements zzdti<zzccd> {

    /* renamed from: a */
    private final zzdtu<Context> f26357a;

    /* renamed from: b */
    private final zzdtu<zzbyt> f26358b;

    /* renamed from: c */
    private final zzdtu<zzbzl> f26359c;

    /* renamed from: d */
    private final zzdtu<zzbyn> f26360d;

    private zzccf(zzdtu<Context> zzdtu, zzdtu<zzbyt> zzdtu2, zzdtu<zzbzl> zzdtu3, zzdtu<zzbyn> zzdtu4) {
        this.f26357a = zzdtu;
        this.f26358b = zzdtu2;
        this.f26359c = zzdtu3;
        this.f26360d = zzdtu4;
    }

    /* renamed from: a */
    public static zzccf m28245a(zzdtu<Context> zzdtu, zzdtu<zzbyt> zzdtu2, zzdtu<zzbzl> zzdtu3, zzdtu<zzbyn> zzdtu4) {
        return new zzccf(zzdtu, zzdtu2, zzdtu3, zzdtu4);
    }

    public final /* synthetic */ Object get() {
        return new zzccd((Context) this.f26357a.get(), (zzbyt) this.f26358b.get(), (zzbzl) this.f26359c.get(), (zzbyn) this.f26360d.get());
    }
}
