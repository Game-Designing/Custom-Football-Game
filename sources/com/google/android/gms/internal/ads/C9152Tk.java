package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Tk */
final class C9152Tk implements zzban<zzbvx> {

    /* renamed from: a */
    private final /* synthetic */ zzbws f21776a;

    /* renamed from: b */
    private final /* synthetic */ zzcqd f21777b;

    C9152Tk(zzcqd zzcqd, zzbws zzbws) {
        this.f21777b = zzcqd;
        this.f21776a = zzbws;
    }

    /* renamed from: a */
    public final void mo27999a(Throwable th) {
        synchronized (this.f21777b) {
            this.f21777b.f27224k = null;
            this.f21776a.mo28121a().onAdFailedToLoad(zzcgm.m28419a(th));
            zzcya.m28997a(th, "InterstitialAdManagerShim.onFailure");
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27998a(Object obj) {
        zzbvx zzbvx = (zzbvx) obj;
        synchronized (this.f21777b) {
            this.f21777b.f27224k = null;
            this.f21777b.f27223j = zzbvx;
            zzbvx.mo28633c();
        }
    }
}
