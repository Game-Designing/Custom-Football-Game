package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Yk */
final class C9257Yk implements zzban<zzcdb> {

    /* renamed from: a */
    private final /* synthetic */ zzcdf f21995a;

    /* renamed from: b */
    private final /* synthetic */ zzcqj f21996b;

    C9257Yk(zzcqj zzcqj, zzcdf zzcdf) {
        this.f21996b = zzcqj;
        this.f21995a = zzcdf;
    }

    /* renamed from: a */
    public final void mo27999a(Throwable th) {
        synchronized (this.f21996b) {
            this.f21996b.f27237b = null;
            this.f21995a.mo28258a().onAdFailedToLoad(zzcgm.m28419a(th));
            zzcya.m28997a(th, "NonagonRewardedVideoAdImpl.onFailure");
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27998a(Object obj) {
        zzcdb zzcdb = (zzcdb) obj;
        synchronized (this.f21996b) {
            this.f21996b.f27237b = null;
            this.f21996b.f27238c = zzcdb;
            zzcdb.mo28633c();
        }
    }
}
