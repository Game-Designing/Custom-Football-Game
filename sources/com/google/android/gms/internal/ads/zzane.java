package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

public abstract class zzane extends zzfn implements zzand {
    public zzane() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                String o = mo29925o();
                parcel2.writeNoException();
                parcel2.writeString(o);
                break;
            case 3:
                List q = mo29927q();
                parcel2.writeNoException();
                parcel2.writeList(q);
                break;
            case 4:
                String p = mo29926p();
                parcel2.writeNoException();
                parcel2.writeString(p);
                break;
            case 5:
                zzaei J = mo29915J();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) J);
                break;
            case 6:
                String m = mo29923m();
                parcel2.writeNoException();
                parcel2.writeString(m);
                break;
            case 7:
                String x = mo29929x();
                parcel2.writeNoException();
                parcel2.writeString(x);
                break;
            case 8:
                recordImpression();
                parcel2.writeNoException();
                break;
            case 9:
                mo29916a(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 10:
                mo29919c(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 11:
                boolean C = mo29913C();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, C);
                break;
            case 12:
                boolean F = mo29914F();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, F);
                break;
            case 13:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.m30226b(parcel2, extras);
                break;
            case 14:
                mo29918b(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 15:
                IObjectWrapper B = mo29912B();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) B);
                break;
            case 16:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) videoController);
                break;
            case 19:
                zzaea l = mo29922l();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) l);
                break;
            case 20:
                IObjectWrapper A = mo29911A();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) A);
                break;
            case 21:
                IObjectWrapper n = mo29924n();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) n);
                break;
            case 22:
                mo29917a(Stub.m22186a(parcel.readStrongBinder()), Stub.m22186a(parcel.readStrongBinder()), Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
