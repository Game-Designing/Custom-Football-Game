package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zaa implements IInterface {

    /* renamed from: a */
    private final IBinder f29899a;

    /* renamed from: b */
    private final String f29900b;

    protected zaa(IBinder iBinder, String str) {
        this.f29899a = iBinder;
        this.f29900b = str;
    }

    public IBinder asBinder() {
        return this.f29899a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo32451a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f29900b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo32452a(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f29899a.transact(i, parcel, parcel, 0);
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
    public final void mo32454b(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f29899a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo32455c(int i, Parcel parcel) throws RemoteException {
        try {
            this.f29899a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
