package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Uk */
final class C9173Uk implements zzban<zzcdb> {

    /* renamed from: a */
    private final /* synthetic */ zzcdf f21818a;

    /* renamed from: b */
    private final /* synthetic */ zzcqf f21819b;

    C9173Uk(zzcqf zzcqf, zzcdf zzcdf) {
        this.f21819b = zzcqf;
        this.f21818a = zzcdf;
    }

    /* renamed from: a */
    public final void mo27999a(Throwable th) {
        synchronized (this.f21819b) {
            this.f21819b.f27226b = null;
            this.f21818a.mo28258a().onAdFailedToLoad(zzcgm.m28419a(th));
            zzcya.m28997a(th, "NonagonRewardedAdImpl.onFailure");
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27998a(Object obj) {
        zzcdb zzcdb = (zzcdb) obj;
        synchronized (this.f21819b) {
            this.f21819b.f27226b = null;
            this.f21819b.f27227c = zzcdb;
            zzcdb.mo28633c();
        }
    }
}
