package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaaw extends zzfm implements zzaau {
    zzaaw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final void onVideoStart() throws RemoteException {
        mo31752b(1, mo31749a());
    }

    public final void onVideoPlay() throws RemoteException {
        mo31752b(2, mo31749a());
    }

    public final void onVideoPause() throws RemoteException {
        mo31752b(3, mo31749a());
    }

    /* renamed from: M */
    public final void mo29375M() throws RemoteException {
        mo31752b(4, mo31749a());
    }

    /* renamed from: k */
    public final void mo29376k(boolean z) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30223a(a, z);
        mo31752b(5, a);
    }
}
