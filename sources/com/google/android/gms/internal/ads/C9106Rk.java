package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Rk */
final class C9106Rk implements zzban<zzbnf> {

    /* renamed from: a */
    private final /* synthetic */ zzboc f21665a;

    /* renamed from: b */
    private final /* synthetic */ zzcpt f21666b;

    C9106Rk(zzcpt zzcpt, zzboc zzboc) {
        this.f21666b = zzcpt;
        this.f21665a = zzboc;
    }

    /* renamed from: a */
    public final void mo27999a(Throwable th) {
        synchronized (this.f21666b) {
            this.f21666b.f27204l = null;
            this.f21665a.mo29321a().onAdFailedToLoad(zzcgm.m28419a(th));
            this.f21666b.f27200h.mo30891b(60);
            zzcya.m28997a(th, "BannerAdManagerShim.onFailure");
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27998a(Object obj) {
        zzbnf zzbnf = (zzbnf) obj;
        synchronized (this.f21666b) {
            this.f21666b.f27204l = null;
            if (this.f21666b.f27203k != null) {
                this.f21666b.f27203k.mo30853a();
            }
            this.f21666b.f27203k = zzbnf;
            this.f21666b.f27196d.removeAllViews();
            this.f21666b.f27196d.addView(zzbnf.mo28635g());
            zzbnf.mo28633c();
            this.f21666b.f27200h.mo30891b(zzbnf.mo28637i());
        }
    }
}
