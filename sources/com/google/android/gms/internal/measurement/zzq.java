package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzq implements IInterface {

    /* renamed from: a */
    private final IBinder f30241a;

    /* renamed from: b */
    private final String f30242b;

    protected zzq(IBinder iBinder, String str) {
        this.f30241a = iBinder;
        this.f30242b = str;
    }

    public IBinder asBinder() {
        return this.f30241a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo32832a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f30242b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo32833a(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f30241a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
