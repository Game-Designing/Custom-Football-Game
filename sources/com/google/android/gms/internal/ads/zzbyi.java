package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

public final class zzbyi implements zzdti<zzbva> {

    /* renamed from: a */
    private final zzdtu<Context> f26074a;

    /* renamed from: b */
    private final zzdtu<zzcxm> f26075b;

    public zzbyi(zzdtu<Context> zzdtu, zzdtu<zzcxm> zzdtu2) {
        this.f26074a = zzdtu;
        this.f26075b = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        zzbva zzbva = new zzbva((Context) this.f26074a.get(), new HashSet(), (zzcxm) this.f26075b.get());
        zzdto.m30114a(zzbva, "Cannot return null from a non-@Nullable @Provides method");
        return zzbva;
    }
}
