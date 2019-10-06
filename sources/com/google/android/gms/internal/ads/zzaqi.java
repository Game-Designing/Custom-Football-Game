package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaqi extends zzfm implements zzaqg {
    zzaqi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) bundle);
        mo31752b(1, a);
    }

    public final void onRestart() throws RemoteException {
        mo31752b(2, mo31749a());
    }

    public final void onStart() throws RemoteException {
        mo31752b(3, mo31749a());
    }

    public final void onResume() throws RemoteException {
        mo31752b(4, mo31749a());
    }

    public final void onPause() throws RemoteException {
        mo31752b(5, mo31749a());
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) bundle);
        Parcel a2 = mo31750a(6, a);
        if (a2.readInt() != 0) {
            bundle.readFromParcel(a2);
        }
        a2.recycle();
    }

    public final void onStop() throws RemoteException {
        mo31752b(7, mo31749a());
    }

    public final void onDestroy() throws RemoteException {
        mo31752b(8, mo31749a());
    }

    public final void zzdd() throws RemoteException {
        mo31752b(9, mo31749a());
    }

    public final boolean zztg() throws RemoteException {
        Parcel a = mo31750a(11, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
        Parcel a = mo31749a();
        a.writeInt(i);
        a.writeInt(i2);
        zzfo.m30222a(a, (Parcelable) intent);
        mo31752b(12, a);
    }

    public final void zzac(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(13, a);
    }
}
