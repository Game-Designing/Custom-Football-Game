package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

public final class zzcfm implements zzdti<zzcfk> {

    /* renamed from: a */
    private final zzdtu<zzcfi> f26532a;

    /* renamed from: b */
    private final zzdtu<Set<C8769Bi>> f26533b;

    /* renamed from: c */
    private final zzdtu<Clock> f26534c;

    private zzcfm(zzdtu<zzcfi> zzdtu, zzdtu<Set<C8769Bi>> zzdtu2, zzdtu<Clock> zzdtu3) {
        this.f26532a = zzdtu;
        this.f26533b = zzdtu2;
        this.f26534c = zzdtu3;
    }

    /* renamed from: a */
    public static zzcfm m28369a(zzdtu<zzcfi> zzdtu, zzdtu<Set<C8769Bi>> zzdtu2, zzdtu<Clock> zzdtu3) {
        return new zzcfm(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzcfk((zzcfi) this.f26532a.get(), (Set) this.f26533b.get(), (Clock) this.f26534c.get());
    }
}
