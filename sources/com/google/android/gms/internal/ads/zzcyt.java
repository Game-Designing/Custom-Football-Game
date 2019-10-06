package com.google.android.gms.internal.ads;

public final class zzcyt implements zzdti<zzawu> {

    /* renamed from: a */
    private final zzcyo f27660a;

    /* renamed from: b */
    private final zzdtu<zzcym> f27661b;

    private zzcyt(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        this.f27660a = zzcyo;
        this.f27661b = zzdtu;
    }

    /* renamed from: a */
    public static zzcyt m29015a(zzcyo zzcyo, zzdtu<zzcym> zzdtu) {
        return new zzcyt(zzcyo, zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzawu zzawu = ((zzcym) this.f27661b.get()).f27646c;
        zzdto.m30114a(zzawu, "Cannot return null from a non-@Nullable @Provides method");
        return zzawu;
    }
}
