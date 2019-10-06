package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

public abstract class zzamt extends zzfn implements zzams {
    public zzamt() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzamv zzamv;
        zzamv zzamv2;
        zzamv zzamv3;
        zzamv zzamv4;
        zzamv zzamv5 = null;
        String str = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener";
        switch (i) {
            case 1:
                IObjectWrapper a = Stub.m22186a(parcel.readStrongBinder());
                zzyd zzyd = (zzyd) zzfo.m30220a(parcel, zzyd.CREATOR);
                zzxz zzxz = (zzxz) zzfo.m30220a(parcel, zzxz.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzamv = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface(str);
                    if (queryLocalInterface instanceof zzamv) {
                        zzamv = (zzamv) queryLocalInterface;
                    } else {
                        zzamv = new zzamx(readStrongBinder);
                    }
                }
                mo29847a(a, zzyd, zzxz, readString, zzamv);
                parcel2.writeNoException();
                break;
            case 2:
                IObjectWrapper Ca = mo29837Ca();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) Ca);
                break;
            case 3:
                IObjectWrapper a2 = Stub.m22186a(parcel.readStrongBinder());
                zzxz zzxz2 = (zzxz) zzfo.m30220a(parcel, zzxz.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface(str);
                    if (queryLocalInterface2 instanceof zzamv) {
                        zzamv5 = (zzamv) queryLocalInterface2;
                    } else {
                        zzamv5 = new zzamx(readStrongBinder2);
                    }
                }
                mo29851b(a2, zzxz2, readString2, zzamv5);
                parcel2.writeNoException();
                break;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                break;
            case 5:
                destroy();
                parcel2.writeNoException();
                break;
            case 6:
                IObjectWrapper a3 = Stub.m22186a(parcel.readStrongBinder());
                zzyd zzyd2 = (zzyd) zzfo.m30220a(parcel, zzyd.CREATOR);
                zzxz zzxz3 = (zzxz) zzfo.m30220a(parcel, zzxz.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 == null) {
                    zzamv2 = null;
                } else {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface(str);
                    if (queryLocalInterface3 instanceof zzamv) {
                        zzamv2 = (zzamv) queryLocalInterface3;
                    } else {
                        zzamv2 = new zzamx(readStrongBinder3);
                    }
                }
                mo29848a(a3, zzyd2, zzxz3, readString3, readString4, zzamv2);
                parcel2.writeNoException();
                break;
            case 7:
                IObjectWrapper a4 = Stub.m22186a(parcel.readStrongBinder());
                zzxz zzxz4 = (zzxz) zzfo.m30220a(parcel, zzxz.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 == null) {
                    zzamv3 = null;
                } else {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface(str);
                    if (queryLocalInterface4 instanceof zzamv) {
                        zzamv3 = (zzamv) queryLocalInterface4;
                    } else {
                        zzamv3 = new zzamx(readStrongBinder4);
                    }
                }
                mo29845a(a4, zzxz4, readString5, readString6, zzamv3);
                parcel2.writeNoException();
                break;
            case 8:
                pause();
                parcel2.writeNoException();
                break;
            case 9:
                resume();
                parcel2.writeNoException();
                break;
            case 10:
                mo29844a(Stub.m22186a(parcel.readStrongBinder()), (zzxz) zzfo.m30220a(parcel, zzxz.CREATOR), parcel.readString(), zzatl.m25796a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                mo29849a((zzxz) zzfo.m30220a(parcel, zzxz.CREATOR), parcel.readString());
                parcel2.writeNoException();
                break;
            case 12:
                showVideo();
                parcel2.writeNoException();
                break;
            case 13:
                boolean isInitialized = isInitialized();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, isInitialized);
                break;
            case 14:
                IObjectWrapper a5 = Stub.m22186a(parcel.readStrongBinder());
                zzxz zzxz5 = (zzxz) zzfo.m30220a(parcel, zzxz.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 == null) {
                    zzamv4 = null;
                } else {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface(str);
                    if (queryLocalInterface5 instanceof zzamv) {
                        zzamv4 = (zzamv) queryLocalInterface5;
                    } else {
                        zzamv4 = new zzamx(readStrongBinder5);
                    }
                }
                mo29846a(a5, zzxz5, readString7, readString8, zzamv4, (zzady) zzfo.m30220a(parcel, zzady.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                break;
            case 15:
                zzana eb = mo29855eb();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) eb);
                break;
            case 16:
                zzand bb = mo29852bb();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) bb);
                break;
            case 17:
                Bundle zzsh = zzsh();
                parcel2.writeNoException();
                zzfo.m30226b(parcel2, zzsh);
                break;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzfo.m30226b(parcel2, interstitialAdapterInfo);
                break;
            case 19:
                Bundle Oa = mo29838Oa();
                parcel2.writeNoException();
                zzfo.m30226b(parcel2, Oa);
                break;
            case 20:
                mo29850a((zzxz) zzfo.m30220a(parcel, zzxz.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 21:
                mo29860m(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 22:
                boolean da = mo29853da();
                parcel2.writeNoException();
                zzfo.m30223a(parcel2, da);
                break;
            case 23:
                mo29842a(Stub.m22186a(parcel.readStrongBinder()), zzatl.m25796a(parcel.readStrongBinder()), (List<String>) parcel.createStringArrayList());
                parcel2.writeNoException();
                break;
            case 24:
                zzafe Y = mo29840Y();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) Y);
                break;
            case 25:
                setImmersiveMode(zzfo.m30224a(parcel));
                parcel2.writeNoException();
                break;
            case 26:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) videoController);
                break;
            case 27:
                zzang S = mo29839S();
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) S);
                break;
            case 28:
                IObjectWrapper a6 = Stub.m22186a(parcel.readStrongBinder());
                zzxz zzxz6 = (zzxz) zzfo.m30220a(parcel, zzxz.CREATOR);
                String readString9 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface(str);
                    if (queryLocalInterface6 instanceof zzamv) {
                        zzamv5 = (zzamv) queryLocalInterface6;
                    } else {
                        zzamv5 = new zzamx(readStrongBinder6);
                    }
                }
                mo29843a(a6, zzxz6, readString9, zzamv5);
                parcel2.writeNoException();
                break;
            case 30:
                mo29859l(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 31:
                mo29841a(Stub.m22186a(parcel.readStrongBinder()), zzair.m25083a(parcel.readStrongBinder()), (List<zzaiw>) parcel.createTypedArrayList(zzaiw.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
