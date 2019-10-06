package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

public final class zzbvc implements zzdti<zzbva> {

    /* renamed from: a */
    private final zzdtu<Context> f25905a;

    /* renamed from: b */
    private final zzdtu<Set<zzbuz<zzue>>> f25906b;

    /* renamed from: c */
    private final zzdtu<zzcxm> f25907c;

    private zzbvc(zzdtu<Context> zzdtu, zzdtu<Set<zzbuz<zzue>>> zzdtu2, zzdtu<zzcxm> zzdtu3) {
        this.f25905a = zzdtu;
        this.f25906b = zzdtu2;
        this.f25907c = zzdtu3;
    }

    /* renamed from: a */
    public static zzbvc m27832a(zzdtu<Context> zzdtu, zzdtu<Set<zzbuz<zzue>>> zzdtu2, zzdtu<zzcxm> zzdtu3) {
        return new zzbvc(zzdtu, zzdtu2, zzdtu3);
    }

    public final /* synthetic */ Object get() {
        return new zzbva((Context) this.f25905a.get(), (Set) this.f25906b.get(), (zzcxm) this.f25907c.get());
    }
}
