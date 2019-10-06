package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract class zzagh extends zzfn implements zzagg {
    public zzagh() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzagd zzagd;
        switch (i) {
            case 2:
                String o = mo29727o();
                parcel2.writeNoException();
                parcel2.writeString(o);
                break;
            case 3:
                List q = mo29729q();
                parcel2.writeNoException();
                parcel2.writeList(q);
                break;
            case 4:
                String p = mo29728p();
                parcel2.writeNoException();
                parcel2.writeString(p);
                break;
            case 5:
                zzaei t = mo29731t();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) t);
                break;
            case 6:
                String m = mo29725m();
                parcel2.writeNoException();
                parcel2.writeString(m);
                break;
            case 7:
                String x = mo29735x();
                parcel2.writeNoException();
                parcel2.writeString(x);
                break;
            case 8:
                double j = mo29723j();
                parcel2.writeNoException();
                parcel2.writeDouble(j);
                break;
            case 9:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                break;
            case 10:
                String u = mo29732u();
                parcel2.writeNoException();
                parcel2.writeString(u);
                break;
            case 11:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) videoController);
                break;
            case 12:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            case 13:
                destroy();
                parcel2.writeNoException();
                break;
            case 14:
                zzaea l = mo29724l();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) l);
                break;
            case 15:
                mo29717d((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 16:
                boolean b = mo29715b((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, b);
                break;
            case 17:
                mo29716c((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 18:
                IObjectWrapper v = mo29734v();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) v);
                break;
            case 19:
                IObjectWrapper n = mo29726n();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) n);
                break;
            case 20:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.m30226b(parcel2, extras);
                break;
            case 21:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzagd = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    if (queryLocalInterface instanceof zzagd) {
                        zzagd = (zzagd) queryLocalInterface;
                    } else {
                        zzagd = new zzagf(readStrongBinder);
                    }
                }
                mo29714a(zzagd);
                parcel2.writeNoException();
                break;
            case 22:
                mo29730r();
                parcel2.writeNoException();
                break;
            case 23:
                List Qa = mo29710Qa();
                parcel2.writeNoException();
                parcel2.writeList(Qa);
                break;
            case 24:
                boolean X = mo29711X();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, X);
                break;
            case 25:
                mo29713a(zzaal.m24510a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 26:
                mo29712a(zzaah.m24507a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 27:
                mo29736y();
                parcel2.writeNoException();
                break;
            case 28:
                mo29733ua();
                parcel2.writeNoException();
                break;
            case 29:
                zzaee Ha = mo29709Ha();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) Ha);
                break;
            default:
                return false;
        }
        return true;
    }
}
