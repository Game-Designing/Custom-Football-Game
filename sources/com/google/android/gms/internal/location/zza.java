package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza implements IInterface {

    /* renamed from: a */
    private final IBinder f29933a;

    /* renamed from: b */
    private final String f29934b;

    protected zza(IBinder iBinder, String str) {
        this.f29933a = iBinder;
        this.f29934b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo32486a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f29934b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo32487a(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f29933a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f29933a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo32489b(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f29933a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
