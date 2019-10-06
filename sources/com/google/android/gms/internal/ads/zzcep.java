package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl.zza.zzb;

public final class zzcep implements zzbro, zzbrw, zzbsr, zzbtk, zzxr {

    /* renamed from: a */
    private final zzwj f26491a;

    /* renamed from: b */
    private boolean f26492b = false;

    /* renamed from: c */
    private boolean f26493c = false;

    public zzcep(zzwj zzwj) {
        this.f26491a = zzwj;
        zzwj.mo32330a(zzb.AD_REQUEST);
    }

    /* renamed from: a */
    public final void mo28900a(zzarx zzarx) {
    }

    /* renamed from: a */
    public final void mo28901a(zzcxu zzcxu) {
        this.f26491a.mo32329a((zzwk) new C9857zi(zzcxu));
    }

    public final void onAdLoaded() {
        this.f26491a.mo32330a(zzb.AD_LOADED);
    }

    public final void onAdFailedToLoad(int i) {
        switch (i) {
            case 1:
                this.f26491a.mo32330a(zzb.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.f26491a.mo32330a(zzb.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.f26491a.mo32330a(zzb.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.f26491a.mo32330a(zzb.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.f26491a.mo32330a(zzb.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.f26491a.mo32330a(zzb.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.f26491a.mo32330a(zzb.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.f26491a.mo32330a(zzb.AD_FAILED_TO_LOAD);
                return;
        }
    }

    public final synchronized void onAdImpression() {
        this.f26491a.mo32330a(zzb.AD_IMPRESSION);
    }

    public final synchronized void onAdClicked() {
        if (!this.f26493c) {
            this.f26491a.mo32330a(zzb.AD_FIRST_CLICK);
            this.f26493c = true;
            return;
        }
        this.f26491a.mo32330a(zzb.AD_SUBSEQUENT_CLICK);
    }
}
