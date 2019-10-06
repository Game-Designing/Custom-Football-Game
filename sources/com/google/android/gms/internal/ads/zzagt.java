package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd.UnconfirmedClickListener;

public final class zzagt extends zzage {

    /* renamed from: b */
    private final UnconfirmedClickListener f24318b;

    public zzagt(UnconfirmedClickListener unconfirmedClickListener) {
        this.f24318b = unconfirmedClickListener;
    }

    public final void onUnconfirmedClickReceived(String str) {
        this.f24318b.onUnconfirmedClickReceived(str);
    }

    public final void onUnconfirmedClickCancelled() {
        this.f24318b.onUnconfirmedClickCancelled();
    }
}
