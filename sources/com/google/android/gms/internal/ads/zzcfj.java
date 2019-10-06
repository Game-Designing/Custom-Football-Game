package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcfj implements zzdti<zzcfi> {

    /* renamed from: a */
    private final zzdtu<Context> f26526a;

    /* renamed from: b */
    private final zzdtu<String> f26527b;

    private zzcfj(zzdtu<Context> zzdtu, zzdtu<String> zzdtu2) {
        this.f26526a = zzdtu;
        this.f26527b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcfj m28363a(zzdtu<Context> zzdtu, zzdtu<String> zzdtu2) {
        return new zzcfj(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcfi((Context) this.f26526a.get(), (String) this.f26527b.get());
    }
}
