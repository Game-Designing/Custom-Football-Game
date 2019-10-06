package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public interface zzamv extends IInterface {
    /* renamed from: M */
    void mo29867M() throws RemoteException;

    /* renamed from: N */
    void mo29868N() throws RemoteException;

    /* renamed from: a */
    void mo29869a(zzafe zzafe, String str) throws RemoteException;

    /* renamed from: a */
    void mo29870a(zzamy zzamy) throws RemoteException;

    /* renamed from: a */
    void mo29871a(zzato zzato) throws RemoteException;

    /* renamed from: a */
    void mo29872a(zzatq zzatq) throws RemoteException;

    /* renamed from: d */
    void mo29873d(int i) throws RemoteException;

    void onAdClicked() throws RemoteException;

    void onAdClosed() throws RemoteException;

    void onAdFailedToLoad(int i) throws RemoteException;

    void onAdImpression() throws RemoteException;

    void onAdLeftApplication() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdOpened() throws RemoteException;

    void onAppEvent(String str, String str2) throws RemoteException;

    void onVideoPause() throws RemoteException;

    void onVideoPlay() throws RemoteException;

    /* renamed from: r */
    void mo29884r(String str) throws RemoteException;

    /* renamed from: wa */
    void mo29885wa() throws RemoteException;

    void zzb(Bundle bundle) throws RemoteException;
}
