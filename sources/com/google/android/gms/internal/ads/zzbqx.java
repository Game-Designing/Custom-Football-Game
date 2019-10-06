package com.google.android.gms.internal.ads;

public final class zzbqx implements zzdti<zzbtb> {

    /* renamed from: a */
    private final zzdtu<zzbtb> f25817a;

    private zzbqx(zzdtu<zzbtb> zzdtu) {
        this.f25817a = zzdtu;
    }

    /* renamed from: a */
    public static zzbqx m27702a(zzdtu<zzbtb> zzdtu) {
        return new zzbqx(zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbtb zzbtb = (zzbtb) this.f25817a.get();
        zzdto.m30114a(zzbtb, "Cannot return null from a non-@Nullable @Provides method");
        return zzbtb;
    }
}
