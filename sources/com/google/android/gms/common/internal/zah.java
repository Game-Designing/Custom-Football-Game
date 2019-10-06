package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zah extends zaa implements ISignInButtonCreator {
    zah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    /* renamed from: a */
    public final IObjectWrapper mo27809a(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel a = mo32451a();
        zac.m31706a(a, (IInterface) iObjectWrapper);
        zac.m31707a(a, (Parcelable) signInButtonConfig);
        Parcel a2 = mo32452a(2, a);
        IObjectWrapper a3 = Stub.m22186a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
