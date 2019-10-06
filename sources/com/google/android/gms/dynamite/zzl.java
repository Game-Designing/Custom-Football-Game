package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzl extends zza implements zzk {
    zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    /* renamed from: a */
    public final IObjectWrapper mo27994a(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel E = mo32474E();
        zzc.m31717a(E, (IInterface) iObjectWrapper);
        E.writeString(str);
        E.writeInt(i);
        zzc.m31717a(E, (IInterface) iObjectWrapper2);
        Parcel a = mo32475a(2, E);
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final IObjectWrapper mo27995b(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel E = mo32474E();
        zzc.m31717a(E, (IInterface) iObjectWrapper);
        E.writeString(str);
        E.writeInt(i);
        zzc.m31717a(E, (IInterface) iObjectWrapper2);
        Parcel a = mo32475a(3, E);
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
