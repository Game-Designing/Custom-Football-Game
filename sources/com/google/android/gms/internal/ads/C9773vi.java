package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.vi */
final /* synthetic */ class C9773vi implements zzbij {

    /* renamed from: a */
    private final zzbbr f23331a;

    C9773vi(zzbbr zzbbr) {
        this.f23331a = zzbbr;
    }

    /* renamed from: a */
    public final void mo26660a(boolean z) {
        zzbbr zzbbr = this.f23331a;
        if (z) {
            zzbbr.mo30338b(null);
        } else {
            zzbbr.mo30337a(new Exception("Ad Web View failed to load."));
        }
    }
}
