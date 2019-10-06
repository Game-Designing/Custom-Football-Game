package com.google.android.gms.internal.ads;

public final class zzbnv implements zzdti<zzbuz<zzbsr>> {

    /* renamed from: a */
    private final zzbnk f25635a;

    /* renamed from: b */
    private final zzdtu<zzbot> f25636b;

    public zzbnv(zzbnk zzbnk, zzdtu<zzbot> zzdtu) {
        this.f25635a = zzbnk;
        this.f25636b = zzdtu;
    }

    /* renamed from: a */
    public static zzbuz<zzbsr> m27307a(zzbnk zzbnk, zzbot zzbot) {
        zzbuz<zzbsr> zzbuz = new zzbuz<>(zzbot, zzbbm.f25065b);
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }

    public final /* synthetic */ Object get() {
        return m27307a(this.f25635a, (zzbot) this.f25636b.get());
    }
}
