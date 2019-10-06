package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public final class zzaek extends zzfm implements zzaei {
    zzaek(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    /* renamed from: Pa */
    public final IObjectWrapper mo29639Pa() throws RemoteException {
        Parcel a = mo31750a(1, mo31749a());
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final Uri getUri() throws RemoteException {
        Parcel a = mo31750a(2, mo31749a());
        Uri uri = (Uri) zzfo.m30220a(a, Uri.CREATOR);
        a.recycle();
        return uri;
    }

    /* renamed from: ha */
    public final double mo29643ha() throws RemoteException {
        Parcel a = mo31750a(3, mo31749a());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    public final int getWidth() throws RemoteException {
        Parcel a = mo31750a(4, mo31749a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    public final int getHeight() throws RemoteException {
        Parcel a = mo31750a(5, mo31749a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
