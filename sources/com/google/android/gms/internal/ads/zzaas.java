package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaas extends zzfn implements zzaar {
    public zzaas() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    /* renamed from: a */
    public static zzaar m24526a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        if (queryLocalInterface instanceof zzaar) {
            return (zzaar) queryLocalInterface;
        }
        return new zzaat(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaau zzaau;
        switch (i) {
            case 1:
                play();
                parcel2.writeNoException();
                break;
            case 2:
                pause();
                parcel2.writeNoException();
                break;
            case 3:
                mo29368h(zzfo.m30224a(parcel));
                parcel2.writeNoException();
                break;
            case 4:
                boolean Da = mo29363Da();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, Da);
                break;
            case 5:
                int i3 = mo29369i();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                break;
            case 6:
                float ya = mo29374ya();
                parcel2.writeNoException();
                parcel2.writeFloat(ya);
                break;
            case 7:
                float ra = mo29373ra();
                parcel2.writeNoException();
                parcel2.writeFloat(ra);
                break;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzaau = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    if (queryLocalInterface instanceof zzaau) {
                        zzaau = (zzaau) queryLocalInterface;
                    } else {
                        zzaau = new zzaaw(readStrongBinder);
                    }
                }
                mo29367a(zzaau);
                parcel2.writeNoException();
                break;
            case 9:
                float K = mo29364K();
                parcel2.writeNoException();
                parcel2.writeFloat(K);
                break;
            case 10:
                boolean Xa = mo29366Xa();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, Xa);
                break;
            case 11:
                zzaau ma = mo29370ma();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) ma);
                break;
            case 12:
                boolean O = mo29365O();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, O);
                break;
            default:
                return false;
        }
        return true;
    }
}
