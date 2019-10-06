package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

public abstract class zzanb extends zzfn implements zzana {
    public zzanb() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                String o = mo29905o();
                parcel2.writeNoException();
                parcel2.writeString(o);
                break;
            case 3:
                List q = mo29907q();
                parcel2.writeNoException();
                parcel2.writeList(q);
                break;
            case 4:
                String p = mo29906p();
                parcel2.writeNoException();
                parcel2.writeString(p);
                break;
            case 5:
                zzaei t = mo29909t();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) t);
                break;
            case 6:
                String m = mo29903m();
                parcel2.writeNoException();
                parcel2.writeString(m);
                break;
            case 7:
                double j = mo29901j();
                parcel2.writeNoException();
                parcel2.writeDouble(j);
                break;
            case 8:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                break;
            case 9:
                String u = mo29910u();
                parcel2.writeNoException();
                parcel2.writeString(u);
                break;
            case 10:
                recordImpression();
                parcel2.writeNoException();
                break;
            case 11:
                mo29894a(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 12:
                mo29897c(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 13:
                boolean C = mo29892C();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, C);
                break;
            case 14:
                boolean F = mo29893F();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, F);
                break;
            case 15:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.m30226b(parcel2, extras);
                break;
            case 16:
                mo29896b(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 17:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) videoController);
                break;
            case 18:
                IObjectWrapper B = mo29891B();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) B);
                break;
            case 19:
                zzaea l = mo29902l();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) l);
                break;
            case 20:
                IObjectWrapper A = mo29890A();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) A);
                break;
            case 21:
                IObjectWrapper n = mo29904n();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) n);
                break;
            case 22:
                mo29895a(Stub.m22186a(parcel.readStrongBinder()), Stub.m22186a(parcel.readStrongBinder()), Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
