package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

/* renamed from: com.google.android.gms.internal.ads.eb */
final class C9398eb implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationNativeAdCallback, MediationRewardedAdCallback {

    /* renamed from: a */
    private zzamv f22205a;

    C9398eb(zzamv zzamv) {
        this.f22205a = zzamv;
    }

    public final void reportAdClicked() {
        try {
            this.f22205a.onAdClicked();
        } catch (RemoteException e) {
        }
    }

    public final void reportAdImpression() {
    }

    public final void onAdOpened() {
        try {
            this.f22205a.onAdOpened();
        } catch (RemoteException e) {
        }
    }

    public final void onAdClosed() {
        try {
            this.f22205a.onAdClosed();
        } catch (RemoteException e) {
        }
    }

    public final void onAdLeftApplication() {
        try {
            this.f22205a.onAdLeftApplication();
        } catch (RemoteException e) {
        }
    }

    public final void onVideoPause() {
    }

    public final void onVideoPlay() {
        try {
            this.f22205a.onVideoPlay();
        } catch (RemoteException e) {
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        try {
            this.f22205a.mo29872a((zzatq) new zzaup(rewardItem));
        } catch (RemoteException e) {
        }
    }

    public final void onVideoStart() {
        try {
            this.f22205a.mo29868N();
        } catch (RemoteException e) {
        }
    }

    public final void onVideoComplete() {
        try {
            this.f22205a.mo29867M();
        } catch (RemoteException e) {
        }
    }

    public final void onAdFailedToShow(String str) {
        String str2 = "Mediated ad failed to show: ";
        try {
            String valueOf = String.valueOf(str);
            zzbad.m26359d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            this.f22205a.mo29873d(0);
        } catch (RemoteException e) {
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoUnmute() {
    }
}
