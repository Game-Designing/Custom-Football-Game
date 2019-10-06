package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaug;

public final class RewardedAd {

    /* renamed from: a */
    private final zzaug f19237a;

    public RewardedAd(Context context, String str) {
        Preconditions.m21858a(context, (Object) "context cannot be null");
        Preconditions.m21858a(str, (Object) "adUnitID cannot be null");
        this.f19237a = new zzaug(context, str);
    }

    public final void loadAd(AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.f19237a.mo30095a(adRequest.zzde(), rewardedAdLoadCallback);
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.f19237a.mo30095a(publisherAdRequest.zzde(), rewardedAdLoadCallback);
    }

    public final String getMediationAdapterClassName() {
        return this.f19237a.mo30096b();
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f19237a.mo30094a(serverSideVerificationOptions);
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.f19237a.mo30093a(onAdMetadataChangedListener);
    }

    public final Bundle getAdMetadata() {
        return this.f19237a.mo30090a();
    }

    public final boolean isLoaded() {
        return this.f19237a.mo30098d();
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        this.f19237a.mo30091a(activity, rewardedAdCallback);
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        this.f19237a.mo30092a(activity, rewardedAdCallback, z);
    }

    public final RewardItem getRewardItem() {
        return this.f19237a.mo30097c();
    }
}
