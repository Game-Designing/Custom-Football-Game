package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

@zzard
public final class zzxv extends zzza {

    /* renamed from: b */
    private final AdListener f29721b;

    public zzxv(AdListener adListener) {
        this.f29721b = adListener;
    }

    public final void onAdClosed() {
        this.f29721b.onAdClosed();
    }

    public final void onAdFailedToLoad(int i) {
        this.f29721b.onAdFailedToLoad(i);
    }

    public final void onAdLeftApplication() {
        this.f29721b.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.f29721b.onAdLoaded();
    }

    public final void onAdOpened() {
        this.f29721b.onAdOpened();
    }

    public final void onAdClicked() {
        this.f29721b.onAdClicked();
    }

    public final void onAdImpression() {
        this.f29721b.onAdImpression();
    }

    /* renamed from: ib */
    public final AdListener mo32364ib() {
        return this.f29721b;
    }
}
