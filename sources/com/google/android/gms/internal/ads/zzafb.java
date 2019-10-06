package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract class zzafb extends zzfn implements zzafa {
    public zzafb() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                IObjectWrapper v = mo29683v();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) v);
                break;
            case 3:
                String o = mo29680o();
                parcel2.writeNoException();
                parcel2.writeString(o);
                break;
            case 4:
                List q = mo29682q();
                parcel2.writeNoException();
                parcel2.writeList(q);
                break;
            case 5:
                String p = mo29681p();
                parcel2.writeNoException();
                parcel2.writeString(p);
                break;
            case 6:
                zzaei J = mo29669J();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) J);
                break;
            case 7:
                String m = mo29678m();
                parcel2.writeNoException();
                parcel2.writeString(m);
                break;
            case 8:
                String x = mo29684x();
                parcel2.writeNoException();
                parcel2.writeString(x);
                break;
            case 9:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.m30226b(parcel2, extras);
                break;
            case 10:
                destroy();
                parcel2.writeNoException();
                break;
            case 11:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) videoController);
                break;
            case 12:
                mo29672d((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                boolean b = mo29670b((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, b);
                break;
            case 14:
                mo29671c((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 15:
                zzaea l = mo29677l();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) l);
                break;
            case 16:
                IObjectWrapper n = mo29679n();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) n);
                break;
            case 17:
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
