package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbwe implements zzdti<Set<zzbuz<zzbrl>>> {

    /* renamed from: a */
    private final zzbvz f25938a;

    /* renamed from: b */
    private final zzdtu<zzbxc> f25939b;

    private zzbwe(zzbvz zzbvz, zzdtu<zzbxc> zzdtu) {
        this.f25938a = zzbvz;
        this.f25939b = zzdtu;
    }

    /* renamed from: a */
    public static zzbwe m27866a(zzbvz zzbvz, zzdtu<zzbxc> zzdtu) {
        return new zzbwe(zzbvz, zzdtu);
    }

    public final /* synthetic */ Object get() {
        Set a = this.f25938a.mo28380a((zzbxc) this.f25939b.get());
        zzdto.m30114a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
