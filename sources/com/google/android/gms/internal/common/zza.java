package com.google.android.gms.internal.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza implements IInterface {

    /* renamed from: a */
    private final IBinder f29921a;

    /* renamed from: b */
    private final String f29922b;

    protected zza(IBinder iBinder, String str) {
        this.f29921a = iBinder;
        this.f29922b = str;
    }

    public IBinder asBinder() {
        return this.f29921a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public final Parcel mo32474E() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f29922b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo32475a(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f29921a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo32477b(int i, Parcel parcel) throws RemoteException {
        try {
            this.f29921a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
