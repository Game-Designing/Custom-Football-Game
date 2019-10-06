package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzavz extends zzfm implements zzavy {
    zzavz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    /* renamed from: b */
    public final void mo30137b(String str, String str2) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        a.writeString(str2);
        mo31752b(1, a);
    }

    public final void onError(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(2, a);
    }
}
