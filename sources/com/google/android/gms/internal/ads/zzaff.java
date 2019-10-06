package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

public abstract class zzaff extends zzfn implements zzafe {
    public zzaff() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    /* renamed from: a */
    public static zzafe m24934a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        if (queryLocalInterface instanceof zzafe) {
            return (zzafe) queryLocalInterface;
        }
        return new zzafg(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String m = mo29691m(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(m);
                break;
            case 2:
                zzaei o = mo29692o(parcel.readString());
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) o);
                break;
            case 3:
                List availableAssetNames = getAvailableAssetNames();
                parcel2.writeNoException();
                parcel2.writeStringList(availableAssetNames);
                break;
            case 4:
                String customTemplateId = getCustomTemplateId();
                parcel2.writeNoException();
                parcel2.writeString(customTemplateId);
                break;
            case 5:
                performClick(parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                recordImpression();
                parcel2.writeNoException();
                break;
            case 7:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) videoController);
                break;
            case 8:
                destroy();
                parcel2.writeNoException();
                break;
            case 9:
                IObjectWrapper la = mo29690la();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) la);
                break;
            case 10:
                boolean j = mo29689j(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, j);
                break;
            case 11:
                IObjectWrapper v = mo29695v();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) v);
                break;
            default:
                return false;
        }
        return true;
    }
}
