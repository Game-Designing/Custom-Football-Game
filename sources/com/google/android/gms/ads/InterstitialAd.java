package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzabd;
import com.google.android.gms.internal.ads.zzxr;

public final class InterstitialAd {

    /* renamed from: a */
    private final zzabd f19021a;

    public InterstitialAd(Context context) {
        this.f19021a = new zzabd(context);
        Preconditions.m21858a(context, (Object) "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.f19021a.mo29453a();
    }

    public final String getAdUnitId() {
        return this.f19021a.mo29466c();
    }

    public final boolean isLoaded() {
        return this.f19021a.mo29470g();
    }

    public final boolean isLoading() {
        return this.f19021a.mo29471h();
    }

    public final void loadAd(AdRequest adRequest) {
        this.f19021a.mo29460a(adRequest.zzde());
    }

    public final void setAdListener(AdListener adListener) {
        this.f19021a.mo29454a(adListener);
        if (adListener == null || !(adListener instanceof zzxr)) {
            if (adListener == null) {
                this.f19021a.mo29461a((zzxr) null);
            }
            return;
        }
        this.f19021a.mo29461a((zzxr) adListener);
    }

    public final void setAdUnitId(String str) {
        this.f19021a.mo29462a(str);
    }

    public final String getMediationAdapterClassName() {
        return this.f19021a.mo29468e();
    }

    public final void show() {
        this.f19021a.mo29472i();
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f19021a.mo29459a(rewardedVideoAdListener);
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        this.f19021a.mo29458a(adMetadataListener);
    }

    public final Bundle getAdMetadata() {
        return this.f19021a.mo29464b();
    }

    public final void zzc(boolean z) {
        this.f19021a.mo29465b(true);
    }

    public final void setImmersiveMode(boolean z) {
        this.f19021a.mo29463a(z);
    }
}
