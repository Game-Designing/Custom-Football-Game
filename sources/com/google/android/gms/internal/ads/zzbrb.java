package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbrb implements zzdti<Context> {

    /* renamed from: a */
    private final zzbqy f25827a;

    /* renamed from: b */
    private final zzdtu<Context> f25828b;

    private zzbrb(zzbqy zzbqy, zzdtu<Context> zzdtu) {
        this.f25827a = zzbqy;
        this.f25828b = zzdtu;
    }

    /* renamed from: a */
    public static zzbrb m27718a(zzbqy zzbqy, zzdtu<Context> zzdtu) {
        return new zzbrb(zzbqy, zzdtu);
    }

    public final /* synthetic */ Object get() {
        Context a = this.f25827a.mo30866a((Context) this.f25828b.get());
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
