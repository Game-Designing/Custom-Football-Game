package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzcqa implements zzbrl, zzbrs {

    /* renamed from: a */
    private zzatw f27210a;

    /* renamed from: b */
    private zzaue f27211b;

    /* renamed from: a */
    public final synchronized void mo31236a(zzatw zzatw) {
        this.f27210a = zzatw;
    }

    /* renamed from: a */
    public final synchronized void mo31237a(zzaue zzaue) {
        this.f27211b = zzaue;
    }

    public final synchronized void onAdOpened() {
        if (this.f27210a != null) {
            try {
                this.f27210a.mo30083T();
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }

    public final synchronized void onAdClosed() {
        if (this.f27210a != null) {
            try {
                this.f27210a.mo30082Q();
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: a */
    public final synchronized void mo30729a(zzasr zzasr, String str, String str2) {
        if (this.f27210a != null) {
            try {
                this.f27210a.mo30084a(new zzaup(zzasr.getType(), zzasr.getAmount()));
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
        if (this.f27211b != null) {
            try {
                this.f27211b.mo30089a(new zzaup(zzasr.getType(), zzasr.getAmount()), str, str2);
            } catch (RemoteException e2) {
                zzbad.m26360d("#007 Could not call remote method.", e2);
            }
        }
    }

    /* renamed from: d */
    public final synchronized void mo30876d(int i) {
        if (this.f27210a != null) {
            try {
                this.f27210a.mo30085q(i);
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }

    public final synchronized void onAdLeftApplication() {
    }

    public final synchronized void onRewardedVideoStarted() {
    }

    public final synchronized void onRewardedVideoCompleted() {
    }
}
