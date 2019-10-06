package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zag extends zaa implements zaf {
    zag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    /* renamed from: j */
    public final void mo33164j(int i) throws RemoteException {
        Parcel a = mo32451a();
        a.writeInt(i);
        mo32454b(7, a);
    }

    /* renamed from: a */
    public final void mo33162a(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException {
        Parcel a = mo32451a();
        zac.m31706a(a, (IInterface) iAccountAccessor);
        a.writeInt(i);
        zac.m31708a(a, z);
        mo32454b(9, a);
    }

    /* renamed from: a */
    public final void mo33163a(zah zah, zad zad) throws RemoteException {
        Parcel a = mo32451a();
        zac.m31707a(a, (Parcelable) zah);
        zac.m31706a(a, (IInterface) zad);
        mo32454b(12, a);
    }
}
