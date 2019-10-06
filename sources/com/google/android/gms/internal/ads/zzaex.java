package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract class zzaex extends zzfn implements zzaew {
    public zzaex() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                IObjectWrapper v = mo29667v();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) v);
                break;
            case 3:
                String o = mo29662o();
                parcel2.writeNoException();
                parcel2.writeString(o);
                break;
            case 4:
                List q = mo29664q();
                parcel2.writeNoException();
                parcel2.writeList(q);
                break;
            case 5:
                String p = mo29663p();
                parcel2.writeNoException();
                parcel2.writeString(p);
                break;
            case 6:
                zzaei t = mo29665t();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) t);
                break;
            case 7:
                String m = mo29660m();
                parcel2.writeNoException();
                parcel2.writeString(m);
                break;
            case 8:
                double j = mo29658j();
                parcel2.writeNoException();
                parcel2.writeDouble(j);
                break;
            case 9:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                break;
            case 10:
                String u = mo29666u();
                parcel2.writeNoException();
                parcel2.writeString(u);
                break;
            case 11:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.m30226b(parcel2, extras);
                break;
            case 12:
                destroy();
                parcel2.writeNoException();
                break;
            case 13:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) videoController);
                break;
            case 14:
                mo29652d((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 15:
                boolean b = mo29650b((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, b);
                break;
            case 16:
                mo29651c((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 17:
                zzaea l = mo29659l();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) l);
                break;
            case 18:
                IObjectWrapper n = mo29661n();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) n);
                break;
            case 19:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            default:
                return false;
        }
        return true;
    }
}
