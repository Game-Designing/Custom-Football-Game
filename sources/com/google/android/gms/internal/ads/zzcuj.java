package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcuj implements zzdti<zzcuh> {

    /* renamed from: a */
    private final zzdtu<Context> f27395a;

    /* renamed from: b */
    private final zzdtu<String> f27396b;

    private zzcuj(zzdtu<Context> zzdtu, zzdtu<String> zzdtu2) {
        this.f27395a = zzdtu;
        this.f27396b = zzdtu2;
    }

    /* renamed from: a */
    public static zzcuj m28884a(zzdtu<Context> zzdtu, zzdtu<String> zzdtu2) {
        return new zzcuj(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcuh((Context) this.f27395a.get(), (String) this.f27396b.get());
    }
}
