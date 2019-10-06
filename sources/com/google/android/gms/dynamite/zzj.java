package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzj extends zza implements zzi {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    /* renamed from: a */
    public final IObjectWrapper mo27990a(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel E = mo32474E();
        zzc.m31717a(E, (IInterface) iObjectWrapper);
        E.writeString(str);
        E.writeInt(i);
        Parcel a = mo32475a(2, E);
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final int mo27991b(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel E = mo32474E();
        zzc.m31717a(E, (IInterface) iObjectWrapper);
        E.writeString(str);
        zzc.m31719a(E, z);
        Parcel a = mo32475a(3, E);
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    /* renamed from: b */
    public final IObjectWrapper mo27992b(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel E = mo32474E();
        zzc.m31717a(E, (IInterface) iObjectWrapper);
        E.writeString(str);
        E.writeInt(i);
        Parcel a = mo32475a(4, E);
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final int mo27989a(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel E = mo32474E();
        zzc.m31717a(E, (IInterface) iObjectWrapper);
        E.writeString(str);
        zzc.m31719a(E, z);
        Parcel a = mo32475a(5, E);
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    /* renamed from: ta */
    public final int mo27993ta() throws RemoteException {
        Parcel a = mo32475a(6, mo32474E());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
