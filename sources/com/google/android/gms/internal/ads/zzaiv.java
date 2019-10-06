package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public final class zzaiv extends zzfm implements zzait {
    zzaiv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    /* renamed from: b */
    public final void mo29756b(List<zzaio> list) throws RemoteException {
        Parcel a = mo31749a();
        a.writeTypedList(list);
        mo31752b(1, a);
    }
}
