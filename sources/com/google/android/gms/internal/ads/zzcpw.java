package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzcpw implements zzbrl, zzbro, zzbrw, zzbsr, zzxr {

    /* renamed from: a */
    private zzyz f27206a;

    /* renamed from: a */
    public final synchronized void mo31231a(zzyz zzyz) {
        this.f27206a = zzyz;
    }

    /* renamed from: a */
    public final synchronized zzyz mo31230a() {
        return this.f27206a;
    }

    public final synchronized void onAdClosed() {
        if (this.f27206a != null) {
            try {
                this.f27206a.onAdClosed();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdClosed.", e);
            }
        }
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (this.f27206a != null) {
            try {
                this.f27206a.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdFailedToLoad.", e);
            }
        }
    }

    public final synchronized void onAdLeftApplication() {
        if (this.f27206a != null) {
            try {
                this.f27206a.onAdLeftApplication();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdLeftApplication.", e);
            }
        }
    }

    public final void onRewardedVideoStarted() {
    }

    /* renamed from: a */
    public final void mo30729a(zzasr zzasr, String str, String str2) {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final synchronized void onAdLoaded() {
        if (this.f27206a != null) {
            try {
                this.f27206a.onAdLoaded();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdLoaded.", e);
            }
        }
    }

    public final synchronized void onAdOpened() {
        if (this.f27206a != null) {
            try {
                this.f27206a.onAdOpened();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdOpened.", e);
            }
        }
    }

    public final synchronized void onAdClicked() {
        if (this.f27206a != null) {
            try {
                this.f27206a.onAdClicked();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void onAdImpression() {
        if (this.f27206a != null) {
            try {
                this.f27206a.onAdImpression();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdImpression.", e);
            }
        }
    }
}
