package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzanp extends zzamw {

    /* renamed from: b */
    private final Adapter f24498b;

    /* renamed from: c */
    private final zzatk f24499c;

    zzanp(Adapter adapter, zzatk zzatk) {
        this.f24498b = adapter;
        this.f24499c = zzatk;
    }

    public final void onAdLoaded() throws RemoteException {
        zzatk zzatk = this.f24499c;
        if (zzatk != null) {
            zzatk.mo29308y(ObjectWrapper.m22188a(this.f24498b));
        }
    }

    public final void onAdOpened() throws RemoteException {
        zzatk zzatk = this.f24499c;
        if (zzatk != null) {
            zzatk.mo29305s(ObjectWrapper.m22188a(this.f24498b));
        }
    }

    public final void onAdClosed() throws RemoteException {
        zzatk zzatk = this.f24499c;
        if (zzatk != null) {
            zzatk.mo29300E(ObjectWrapper.m22188a(this.f24498b));
        }
    }

    /* renamed from: a */
    public final void mo29872a(zzatq zzatq) throws RemoteException {
        zzatk zzatk = this.f24499c;
        if (zzatk != null) {
            zzatk.mo29302a(ObjectWrapper.m22188a(this.f24498b), new zzato(zzatq.getType(), zzatq.getAmount()));
        }
    }

    /* renamed from: N */
    public final void mo29868N() throws RemoteException {
        zzatk zzatk = this.f24499c;
        if (zzatk != null) {
            zzatk.mo29306t(ObjectWrapper.m22188a(this.f24498b));
        }
    }

    /* renamed from: wa */
    public final void mo29885wa() throws RemoteException {
        zzatk zzatk = this.f24499c;
        if (zzatk != null) {
            zzatk.mo29299B(ObjectWrapper.m22188a(this.f24498b));
        }
    }

    public final void onAdClicked() throws RemoteException {
        zzatk zzatk = this.f24499c;
        if (zzatk != null) {
            zzatk.mo29301F(ObjectWrapper.m22188a(this.f24498b));
        }
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        zzatk zzatk = this.f24499c;
        if (zzatk != null) {
            zzatk.mo29304c(ObjectWrapper.m22188a(this.f24498b), i);
        }
    }

    /* renamed from: d */
    public final void mo29873d(int i) throws RemoteException {
    }

    public final void zzb(Bundle bundle) throws RemoteException {
    }

    /* renamed from: r */
    public final void mo29884r(String str) throws RemoteException {
    }

    public final void onAdLeftApplication() throws RemoteException {
    }

    /* renamed from: M */
    public final void mo29867M() throws RemoteException {
    }

    public final void onVideoPause() throws RemoteException {
    }

    public final void onVideoPlay() throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29871a(zzato zzato) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29870a(zzamy zzamy) throws RemoteException {
    }

    public final void onAdImpression() throws RemoteException {
    }

    public final void onAppEvent(String str, String str2) throws RemoteException {
    }

    /* renamed from: a */
    public final void mo29869a(zzafe zzafe, String str) throws RemoteException {
    }
}
