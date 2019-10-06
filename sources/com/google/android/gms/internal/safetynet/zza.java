package com.google.android.gms.internal.safetynet;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza implements IInterface {

    /* renamed from: a */
    private final IBinder f30439a;

    /* renamed from: b */
    private final String f30440b;

    protected zza(IBinder iBinder, String str) {
        this.f30439a = iBinder;
        this.f30440b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo32969a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f30440b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo32970a(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f30439a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f30439a;
    }
}
