package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzfm implements IInterface {

    /* renamed from: a */
    private final IBinder f28414a;

    /* renamed from: b */
    private final String f28415b;

    protected zzfm(IBinder iBinder, String str) {
        this.f28414a = iBinder;
        this.f28415b = str;
    }

    public IBinder asBinder() {
        return this.f28414a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo31749a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f28415b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo31750a(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f28414a.transact(i, parcel, parcel, 0);
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
    public final void mo31752b(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f28414a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo31753c(int i, Parcel parcel) throws RemoteException {
        try {
            this.f28414a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
