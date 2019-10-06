package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

@zzard
public final class zzxy extends zzzq {

    /* renamed from: b */
    private final AdMetadataListener f29722b;

    public zzxy(AdMetadataListener adMetadataListener) {
        this.f29722b = adMetadataListener;
    }

    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.f29722b;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
