package com.google.android.gms.internal.ads;

public final class zzbnr implements zzdti<zzbnf> {

    /* renamed from: a */
    private final zzbnk f25624a;

    /* renamed from: b */
    private final zzdtu<C9168Uf> f25625b;

    public zzbnr(zzbnk zzbnk, zzdtu<C9168Uf> zzdtu) {
        this.f25624a = zzbnk;
        this.f25625b = zzdtu;
    }

    /* renamed from: a */
    public static zzbnf m27304a(zzbnk zzbnk, Object obj) {
        C9168Uf uf = (C9168Uf) obj;
        zzdto.m30114a(uf, "Cannot return null from a non-@Nullable @Provides method");
        return uf;
    }

    public final /* synthetic */ Object get() {
        return m27304a(this.f25624a, this.f25625b.get());
    }
}
