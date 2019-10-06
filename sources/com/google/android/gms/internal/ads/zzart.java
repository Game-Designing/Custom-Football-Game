package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzart extends zzfm implements zzarr {
    zzart(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    /* renamed from: a */
    public final void mo30025a(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) parcelFileDescriptor);
        mo31752b(1, a);
    }

    /* renamed from: a */
    public final void mo30026a(zzaym zzaym) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzaym);
        mo31752b(2, a);
    }
}
