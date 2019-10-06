package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

public abstract class zzanh extends zzfn implements zzang {
    public zzanh() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    /* renamed from: a */
    public static zzang m25416a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
        if (queryLocalInterface instanceof zzang) {
            return (zzang) queryLocalInterface;
        }
        return new zzani(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                String o = mo29945o();
                parcel2.writeNoException();
                parcel2.writeString(o);
                break;
            case 3:
                List q = mo29947q();
                parcel2.writeNoException();
                parcel2.writeList(q);
                break;
            case 4:
                String p = mo29946p();
                parcel2.writeNoException();
                parcel2.writeString(p);
                break;
            case 5:
                zzaei t = mo29949t();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) t);
                break;
            case 6:
                String m = mo29943m();
                parcel2.writeNoException();
                parcel2.writeString(m);
                break;
            case 7:
                String x = mo29951x();
                parcel2.writeNoException();
                parcel2.writeString(x);
                break;
            case 8:
                double j = mo29941j();
                parcel2.writeNoException();
                parcel2.writeDouble(j);
                break;
            case 9:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                break;
            case 10:
                String u = mo29950u();
                parcel2.writeNoException();
                parcel2.writeString(u);
                break;
            case 11:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) videoController);
                break;
            case 12:
                zzaea l = mo29942l();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) l);
                break;
            case 13:
                IObjectWrapper B = mo29931B();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) B);
                break;
            case 14:
                IObjectWrapper A = mo29930A();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) A);
                break;
            case 15:
                IObjectWrapper n = mo29944n();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) n);
                break;
            case 16:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.m30226b(parcel2, extras);
                break;
            case 17:
                boolean C = mo29932C();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, C);
                break;
            case 18:
                boolean F = mo29933F();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, F);
                break;
            case 19:
                recordImpression();
                parcel2.writeNoException();
                break;
            case 20:
                mo29934a(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 21:
                mo29935a(Stub.m22186a(parcel.readStrongBinder()), Stub.m22186a(parcel.readStrongBinder()), Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 22:
                mo29936b(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 23:
                float ia = mo29940ia();
                parcel2.writeNoException();
                parcel2.writeFloat(ia);
                break;
            default:
                return false;
        }
        return true;
    }
}
