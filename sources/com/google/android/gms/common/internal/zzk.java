package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.common.zza;

public final class zzk extends zza implements zzi {
    zzk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    /* renamed from: G */
    public final IObjectWrapper mo27651G() throws RemoteException {
        Parcel a = mo32475a(1, mo32474E());
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: h */
    public final int mo27654h() throws RemoteException {
        Parcel a = mo32475a(2, mo32474E());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
