package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

public final class zzcla extends zzamw implements zzbsm {

    /* renamed from: b */
    private zzamv f26968b;

    /* renamed from: c */
    private zzbsn f26969c;

    /* renamed from: a */
    public final synchronized void mo31197a(zzamv zzamv) {
        this.f26968b = zzamv;
    }

    /* renamed from: a */
    public final synchronized void mo30888a(zzbsn zzbsn) {
        this.f26969c = zzbsn;
    }

    public final synchronized void onAdClicked() throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.onAdClicked();
        }
    }

    public final synchronized void onAdClosed() throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.onAdClosed();
        }
    }

    public final synchronized void onAdFailedToLoad(int i) throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.onAdFailedToLoad(i);
        }
        if (this.f26969c != null) {
            this.f26969c.onAdFailedToLoad(i);
        }
    }

    public final synchronized void onAdLeftApplication() throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.onAdLeftApplication();
        }
    }

    public final synchronized void onAdOpened() throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.onAdOpened();
        }
    }

    public final synchronized void onAdLoaded() throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.onAdLoaded();
        }
        if (this.f26969c != null) {
            this.f26969c.onAdLoaded();
        }
    }

    /* renamed from: a */
    public final synchronized void mo29870a(zzamy zzamy) throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.mo29870a(zzamy);
        }
    }

    public final synchronized void onAdImpression() throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.onAdImpression();
        }
    }

    public final synchronized void onAppEvent(String str, String str2) throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.onAppEvent(str, str2);
        }
    }

    /* renamed from: a */
    public final synchronized void mo29869a(zzafe zzafe, String str) throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.mo29869a(zzafe, str);
        }
    }

    /* renamed from: M */
    public final synchronized void mo29867M() throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.mo29867M();
        }
    }

    /* renamed from: r */
    public final synchronized void mo29884r(String str) throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.mo29884r(str);
        }
    }

    /* renamed from: N */
    public final synchronized void mo29868N() throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.mo29868N();
        }
    }

    public final synchronized void onVideoPlay() throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.onVideoPlay();
        }
    }

    /* renamed from: a */
    public final synchronized void mo29871a(zzato zzato) throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.mo29871a(zzato);
        }
    }

    public final synchronized void onVideoPause() throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.onVideoPause();
        }
    }

    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.zzb(bundle);
        }
    }

    /* renamed from: wa */
    public final synchronized void mo29885wa() throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.mo29885wa();
        }
    }

    /* renamed from: d */
    public final synchronized void mo29873d(int i) throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.mo29873d(i);
        }
    }

    /* renamed from: a */
    public final synchronized void mo29872a(zzatq zzatq) throws RemoteException {
        if (this.f26968b != null) {
            this.f26968b.mo29872a(zzatq);
        }
    }
}
