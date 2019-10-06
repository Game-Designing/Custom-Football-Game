package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zza implements IInterface {

    /* renamed from: a */
    private final IBinder f29804a;

    /* renamed from: b */
    private final String f29805b;

    protected zza(IBinder iBinder, String str) {
        this.f29804a = iBinder;
        this.f29805b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo32396a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f29805b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo32397a(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f29804a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f29804a;
    }
}
