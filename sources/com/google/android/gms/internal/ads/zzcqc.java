package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzcqc implements zzbrl, zzbro, zzbsr {

    /* renamed from: a */
    private zzatb f27213a;

    /* renamed from: b */
    private zzasu f27214b;

    /* renamed from: a */
    public final synchronized void mo31240a(zzatb zzatb) {
        this.f27213a = zzatb;
    }

    /* renamed from: a */
    public final synchronized void mo31239a(zzasu zzasu) {
        this.f27214b = zzasu;
    }

    public final synchronized void onAdClosed() {
        if (this.f27213a != null) {
            try {
                this.f27213a.onRewardedVideoAdClosed();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdClosed.", e);
            }
        }
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (this.f27213a != null) {
            try {
                this.f27213a.onRewardedVideoAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdFailedToLoad.", e);
            }
        }
    }

    public final synchronized void onAdLeftApplication() {
        if (this.f27213a != null) {
            try {
                this.f27213a.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdLeftApplication.", e);
            }
        }
    }

    public final synchronized void onAdLoaded() {
        if (this.f27213a != null) {
            try {
                this.f27213a.onRewardedVideoAdLoaded();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdLoaded.", e);
            }
        }
    }

    public final synchronized void onAdOpened() {
        if (this.f27213a != null) {
            try {
                this.f27213a.onRewardedVideoAdOpened();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdOpened.", e);
            }
        }
    }

    public final synchronized void onRewardedVideoStarted() {
        if (this.f27213a != null) {
            try {
                this.f27213a.onRewardedVideoStarted();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onRewardedVideoStarted.", e);
            }
        }
    }

    /* renamed from: a */
    public final synchronized void mo30729a(zzasr zzasr, String str, String str2) {
        if (this.f27213a != null) {
            try {
                this.f27213a.mo30061a(zzasr);
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onRewarded.", e);
            }
        }
        if (this.f27214b != null) {
            try {
                this.f27214b.mo30059a(zzasr, str, str2);
            } catch (RemoteException e2) {
                zzbad.m26360d("#007 Could not call remote method.", e2);
            }
        }
    }

    public final synchronized void onRewardedVideoCompleted() {
        if (this.f27213a != null) {
            try {
                this.f27213a.onRewardedVideoCompleted();
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }
}
