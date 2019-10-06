package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Wd */
final class C9208Wd implements zzgh {

    /* renamed from: a */
    private final /* synthetic */ zzbdq f21889a;

    C9208Wd(zzbdq zzbdq) {
        this.f21889a = zzbdq;
    }

    /* renamed from: a */
    public final void mo28309a(boolean z, int i) {
        if (this.f21889a.f25208r != i) {
            this.f21889a.f25208r = i;
            if (i == 4) {
                this.f21889a.m26581p();
            } else if (i == 5) {
                this.f21889a.m26577l();
            }
        }
    }

    /* renamed from: a */
    public final void mo28306a() {
    }

    /* renamed from: a */
    public final void mo28307a(zzgd zzgd) {
        this.f21889a.m26571b("PlayerError", zzgd.getMessage());
    }
}
