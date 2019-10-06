package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.common.internal.Preconditions;

@zzard
public final class zzauo implements MediationRewardedAdCallback {

    /* renamed from: a */
    private final zzamv f24829a;

    public zzauo(zzamv zzamv) {
        this.f24829a = zzamv;
    }

    public final void onAdOpened() {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdOpened.");
        try {
            this.f24829a.onAdOpened();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed() {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdClosed.");
        try {
            this.f24829a.onAdClosed();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onUserEarnedReward.");
        try {
            this.f24829a.mo29872a((zzatq) new zzaup(rewardItem));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdClicked() {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called reportAdClicked.");
        try {
            this.f24829a.onAdClicked();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdImpression() {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called reportAdImpression.");
        try {
            this.f24829a.onAdImpression();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(String str) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdFailedToShow.");
        String valueOf = String.valueOf(str);
        String str2 = "Mediation ad failed to show: ";
        zzbad.m26359d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        try {
            this.f24829a.mo29873d(0);
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoStart() {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onVideoStart.");
        try {
            this.f24829a.mo29868N();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoComplete() {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onVideoComplete.");
        try {
            this.f24829a.mo29885wa();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }
}
