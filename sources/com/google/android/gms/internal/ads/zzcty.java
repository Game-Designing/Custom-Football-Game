package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

public final class zzcty implements zzdti<zzctw> {

    /* renamed from: a */
    private final zzdtu<zzbbl> f27378a;

    /* renamed from: b */
    private final zzdtu<Context> f27379b;

    /* renamed from: c */
    private final zzdtu<Set<String>> f27380c;

    private zzcty(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2, zzdtu<Set<String>> zzdtu3) {
        this.f27378a = zzdtu;
        this.f27379b = zzdtu2;
        this.f27380c = zzdtu3;
    }

    /* renamed from: a */
    public static zzcty m28873a(zzdtu<zzbbl> zzdtu, zzdtu<Context> zzdtu2, zzdtu<Set<String>> zzdtu3) {
        return new zzcty(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzctw((zzbbl) this.f27378a.get(), (Context) this.f27379b.get(), (Set) this.f27380c.get());
    }
}
