package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzatn implements MediationRewardedVideoAdListener {

    /* renamed from: a */
    private final zzatk f24819a;

    public zzatn(zzatk zzatk) {
        this.f24819a = zzatk;
    }

    public final void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onInitializationSucceeded.");
        try {
            this.f24819a.mo29307w(ObjectWrapper.m22188a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onInitializationFailed.");
        try {
            this.f24819a.mo29303b(ObjectWrapper.m22188a(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdLoaded.");
        try {
            this.f24819a.mo29308y(ObjectWrapper.m22188a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdOpened.");
        try {
            this.f24819a.mo29305s(ObjectWrapper.m22188a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onVideoStarted.");
        try {
            this.f24819a.mo29306t(ObjectWrapper.m22188a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdClosed.");
        try {
            this.f24819a.mo29300E(ObjectWrapper.m22188a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onRewarded.");
        if (rewardItem != null) {
            try {
                this.f24819a.mo29302a(ObjectWrapper.m22188a(mediationRewardedVideoAdAdapter), new zzato(rewardItem));
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        } else {
            this.f24819a.mo29302a(ObjectWrapper.m22188a(mediationRewardedVideoAdAdapter), new zzato("", 1));
        }
    }

    public final void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdClicked.");
        try {
            this.f24819a.mo29301F(ObjectWrapper.m22188a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdFailedToLoad.");
        try {
            this.f24819a.mo29304c(ObjectWrapper.m22188a(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdLeftApplication.");
        try {
            this.f24819a.mo29309z(ObjectWrapper.m22188a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoCompleted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onVideoCompleted.");
        try {
            this.f24819a.mo29299B(ObjectWrapper.m22188a(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void zzb(Bundle bundle) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdMetadataChanged.");
        try {
            this.f24819a.zzb(bundle);
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }
}
