package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaud extends zzfm implements zzaub {
    zzaud(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    /* renamed from: Ba */
    public final void mo30087Ba() throws RemoteException {
        mo31752b(1, mo31749a());
    }

    /* renamed from: p */
    public final void mo30088p(int i) throws RemoteException {
        Parcel a = mo31749a();
        a.writeInt(i);
        mo31752b(2, a);
    }
}
