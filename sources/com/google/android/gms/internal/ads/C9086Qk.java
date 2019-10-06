package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Qk */
final class C9086Qk implements zzban<zzbpc> {

    /* renamed from: a */
    private final /* synthetic */ zzbxo f21617a;

    /* renamed from: b */
    private final /* synthetic */ zzcpp f21618b;

    C9086Qk(zzcpp zzcpp, zzbxo zzbxo) {
        this.f21618b = zzcpp;
        this.f21617a = zzbxo;
    }

    /* renamed from: a */
    public final void mo27999a(Throwable th) {
        this.f21617a.mo29203c().onAdFailedToLoad(zzcgm.m28419a(th));
        zzcya.m28997a(th, "AdLoaderShim.onFailure");
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27998a(Object obj) {
        zzbpc zzbpc = (zzbpc) obj;
        synchronized (this.f21618b) {
            this.f21618b.f27192i = zzbpc.mo30854b();
            this.f21618b.f27193j = zzbpc.mo30856e();
            zzbpc.mo28633c();
        }
    }
}
