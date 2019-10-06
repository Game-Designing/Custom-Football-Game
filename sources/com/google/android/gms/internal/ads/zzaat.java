package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaat extends zzfm implements zzaar {
    zzaat(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public final void play() throws RemoteException {
        mo31752b(1, mo31749a());
    }

    public final void pause() throws RemoteException {
        mo31752b(2, mo31749a());
    }

    /* renamed from: h */
    public final void mo29368h(boolean z) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30223a(a, z);
        mo31752b(3, a);
    }

    /* renamed from: Da */
    public final boolean mo29363Da() throws RemoteException {
        Parcel a = mo31750a(4, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: i */
    public final int mo29369i() throws RemoteException {
        Parcel a = mo31750a(5, mo31749a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    /* renamed from: a */
    public final void mo29367a(zzaau zzaau) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzaau);
        mo31752b(8, a);
    }

    /* renamed from: K */
    public final float mo29364K() throws RemoteException {
        Parcel a = mo31750a(9, mo31749a());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    /* renamed from: Xa */
    public final boolean mo29366Xa() throws RemoteException {
        Parcel a = mo31750a(10, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: ma */
    public final zzaau mo29370ma() throws RemoteException {
        zzaau zzaau;
        Parcel a = mo31750a(11, mo31749a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaau = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            if (queryLocalInterface instanceof zzaau) {
                zzaau = (zzaau) queryLocalInterface;
            } else {
                zzaau = new zzaaw(readStrongBinder);
            }
        }
        a.recycle();
        return zzaau;
    }

    /* renamed from: O */
    public final boolean mo29365O() throws RemoteException {
        Parcel a = mo31750a(12, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }
}
