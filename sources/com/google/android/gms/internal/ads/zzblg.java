package com.google.android.gms.internal.ads;

public final class zzblg implements zzdti<zzbah> {

    /* renamed from: a */
    private final zzdtu<String> f25497a;

    private zzblg(zzdtu<String> zzdtu) {
        this.f25497a = zzdtu;
    }

    /* renamed from: a */
    public static zzblg m27213a(zzdtu<String> zzdtu) {
        return new zzblg(zzdtu);
    }

    public final /* synthetic */ Object get() {
        zzbah zzbah = new zzbah((String) this.f25497a.get());
        zzdto.m30114a(zzbah, "Cannot return null from a non-@Nullable @Provides method");
        return zzbah;
    }
}
