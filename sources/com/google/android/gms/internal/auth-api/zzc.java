package com.google.android.gms.internal.auth-api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzc implements IInterface {

    /* renamed from: a */
    private final IBinder f29812a;

    /* renamed from: b */
    private final String f29813b;

    protected zzc(IBinder iBinder, String str) {
        this.f29812a = iBinder;
        this.f29813b = str;
    }

    public IBinder asBinder() {
        return this.f29812a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo32409a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f29813b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo32410a(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f29812a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
