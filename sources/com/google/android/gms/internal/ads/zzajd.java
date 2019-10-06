package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzajd extends zzfm implements zzajc {
    zzajd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    /* renamed from: fb */
    public final void mo29767fb() throws RemoteException {
        mo31752b(1, mo31749a());
    }

    /* renamed from: m */
    public final void mo29768m(int i) throws RemoteException {
        Parcel a = mo31749a();
        a.writeInt(i);
        mo31752b(2, a);
    }
}
