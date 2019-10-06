package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;
import java.util.Map;

public abstract class zzbjg extends zzfn implements zzbjf {
    public zzbjg() {
        super("com.google.android.gms.ads.measurement.IAppMeasurementProxy");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                mo29826e((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                Bundle g = mo29828g((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfo.m30226b(parcel2, g);
                break;
            case 3:
                mo29821a(parcel.readString(), parcel.readString(), (Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 4:
                mo29822a(parcel.readString(), parcel.readString(), Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 5:
                Map a = mo29820a(parcel.readString(), parcel.readString(), zzfo.m30224a(parcel));
                parcel2.writeNoException();
                parcel2.writeMap(a);
                break;
            case 6:
                int s = mo29832s(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(s);
                break;
            case 7:
                mo29827f((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 8:
                mo29824b(parcel.readString(), parcel.readString(), (Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 9:
                List c = mo29825c(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeList(c);
                break;
            case 10:
                String W = mo29818W();
                parcel2.writeNoException();
                parcel2.writeString(W);
                break;
            case 11:
                String ja = mo29830ja();
                parcel2.writeNoException();
                parcel2.writeString(ja);
                break;
            case 12:
                long Ia = mo29815Ia();
                parcel2.writeNoException();
                parcel2.writeLong(Ia);
                break;
            case 13:
                mo29829i(parcel.readString());
                parcel2.writeNoException();
                break;
            case 14:
                mo29831l(parcel.readString());
                parcel2.writeNoException();
                break;
            case 15:
                mo29823b(Stub.m22186a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 16:
                String Z = mo29819Z();
                parcel2.writeNoException();
                parcel2.writeString(Z);
                break;
            case 17:
                String Ua = mo29817Ua();
                parcel2.writeNoException();
                parcel2.writeString(Ua);
                break;
            case 18:
                String La = mo29816La();
                parcel2.writeNoException();
                parcel2.writeString(La);
                break;
            default:
                return false;
        }
        return true;
    }
}
