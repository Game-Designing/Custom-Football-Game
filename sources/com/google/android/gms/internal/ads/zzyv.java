package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

@zzard
public class zzyv extends AdListener {

    /* renamed from: a */
    private final Object f29802a = new Object();

    /* renamed from: b */
    private AdListener f29803b;

    /* renamed from: a */
    public final void mo32393a(AdListener adListener) {
        synchronized (this.f29802a) {
            this.f29803b = adListener;
        }
    }

    public void onAdClosed() {
        synchronized (this.f29802a) {
            if (this.f29803b != null) {
                this.f29803b.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.f29802a) {
            if (this.f29803b != null) {
                this.f29803b.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.f29802a) {
            if (this.f29803b != null) {
                this.f29803b.onAdLeftApplication();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.f29802a) {
            if (this.f29803b != null) {
                this.f29803b.onAdOpened();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.f29802a) {
            if (this.f29803b != null) {
                this.f29803b.onAdLoaded();
            }
        }
    }
}
