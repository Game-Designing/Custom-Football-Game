package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

public abstract class zzaac extends zzfn implements zzaab {
    public zzaac() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                mo29344E();
                parcel2.writeNoException();
                break;
            case 2:
                mo29346a(parcel.readFloat());
                parcel2.writeNoException();
                break;
            case 3:
                mo29353g(parcel.readString());
                parcel2.writeNoException();
                break;
            case 4:
                mo29354g(zzfo.m30224a(parcel));
                parcel2.writeNoException();
                break;
            case 5:
                mo29347a(Stub.m22186a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                mo29350a(parcel.readString(), Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 7:
                float Ra = mo29345Ra();
                parcel2.writeNoException();
                parcel2.writeFloat(Ra);
                break;
            case 8:
                boolean ga = mo29355ga();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, ga);
                break;
            case 9:
                String fa = mo29352fa();
                parcel2.writeNoException();
                parcel2.writeString(fa);
                break;
            case 10:
                mo29356p(parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                mo29349a(zzamq.m25249a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 12:
                mo29348a(zzaiu.m25086a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 13:
                List ba = mo29351ba();
                parcel2.writeNoException();
                parcel2.writeTypedList(ba);
                break;
            default:
                return false;
        }
        return true;
    }
}
