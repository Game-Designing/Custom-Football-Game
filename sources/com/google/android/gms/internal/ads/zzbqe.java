package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbqe implements zzbrl, zzbrw, zzbsr, zzbtk, zzxr {

    /* renamed from: a */
    private final Clock f25783a;

    /* renamed from: b */
    private final zzawj f25784b;

    public zzbqe(Clock clock, zzawj zzawj) {
        this.f25783a = clock;
        this.f25784b = zzawj;
    }

    public final void onAdClicked() {
        this.f25784b.mo30156c();
    }

    public final void onAdLoaded() {
        this.f25784b.mo30154a(true);
    }

    public final void onAdImpression() {
        this.f25784b.mo30155b();
    }

    /* renamed from: a */
    public final void mo30865a(zzxz zzxz) {
        this.f25784b.mo30153a(zzxz);
    }

    /* renamed from: a */
    public final void mo28900a(zzarx zzarx) {
    }

    /* renamed from: a */
    public final void mo28901a(zzcxu zzcxu) {
        this.f25784b.mo30152a(this.f25783a.mo27934a());
    }

    public final void onAdClosed() {
        this.f25784b.mo30157d();
    }

    public final void onAdOpened() {
    }

    public final void onAdLeftApplication() {
    }

    public final void onRewardedVideoStarted() {
    }

    /* renamed from: a */
    public final void mo30729a(zzasr zzasr, String str, String str2) {
    }

    public final void onRewardedVideoCompleted() {
    }

    /* renamed from: a */
    public final String mo30864a() {
        return this.f25784b.mo30158e();
    }
}
