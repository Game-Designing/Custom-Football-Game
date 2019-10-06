package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzaow extends zzfn implements zzaov {
    public zzaow() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    /* renamed from: a */
    public static zzaov m25592a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (queryLocalInterface instanceof zzaov) {
            return (zzaov) queryLocalInterface;
        }
        return new zzaox(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaoy zzaoy;
        zzaoj zzaoj;
        zzaom zzaom;
        zzaos zzaos;
        zzaop zzaop;
        int i3 = i;
        Parcel parcel3 = parcel;
        Parcel parcel4 = parcel2;
        if (i3 == 1) {
            IObjectWrapper a = Stub.m22186a(parcel.readStrongBinder());
            String readString = parcel.readString();
            Bundle bundle = (Bundle) zzfo.m30220a(parcel, Bundle.CREATOR);
            Bundle bundle2 = (Bundle) zzfo.m30220a(parcel, Bundle.CREATOR);
            zzyd zzyd = (zzyd) zzfo.m30220a(parcel, zzyd.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzaoy = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                if (queryLocalInterface instanceof zzaoy) {
                    zzaoy = (zzaoy) queryLocalInterface;
                } else {
                    zzaoy = new zzapa(readStrongBinder);
                }
            }
            mo29957a(a, readString, bundle, bundle2, zzyd, zzaoy);
            parcel2.writeNoException();
        } else if (i3 == 2) {
            zzapj _a = mo29956_a();
            parcel2.writeNoException();
            zzfo.m30226b(parcel4, _a);
        } else if (i3 == 3) {
            zzapj Wa = mo29955Wa();
            parcel2.writeNoException();
            zzfo.m30226b(parcel4, Wa);
        } else if (i3 == 5) {
            zzaar videoController = getVideoController();
            parcel2.writeNoException();
            zzfo.m30221a(parcel4, (IInterface) videoController);
        } else if (i3 == 10) {
            mo29966x(Stub.m22186a(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i3 != 11) {
            switch (i3) {
                case 13:
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    zzxz zzxz = (zzxz) zzfo.m30220a(parcel, zzxz.CREATOR);
                    IObjectWrapper a2 = Stub.m22186a(parcel.readStrongBinder());
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 == null) {
                        zzaoj = null;
                    } else {
                        IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        if (queryLocalInterface2 instanceof zzaoj) {
                            zzaoj = (zzaoj) queryLocalInterface2;
                        } else {
                            zzaoj = new zzaol(readStrongBinder2);
                        }
                    }
                    mo29958a(readString2, readString3, zzxz, a2, zzaoj, zzamw.m25301a(parcel.readStrongBinder()), (zzyd) zzfo.m30220a(parcel, zzyd.CREATOR));
                    parcel2.writeNoException();
                    break;
                case 14:
                    String readString4 = parcel.readString();
                    String readString5 = parcel.readString();
                    zzxz zzxz2 = (zzxz) zzfo.m30220a(parcel, zzxz.CREATOR);
                    IObjectWrapper a3 = Stub.m22186a(parcel.readStrongBinder());
                    IBinder readStrongBinder3 = parcel.readStrongBinder();
                    if (readStrongBinder3 == null) {
                        zzaom = null;
                    } else {
                        IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        if (queryLocalInterface3 instanceof zzaom) {
                            zzaom = (zzaom) queryLocalInterface3;
                        } else {
                            zzaom = new zzaoo(readStrongBinder3);
                        }
                    }
                    mo29959a(readString4, readString5, zzxz2, a3, zzaom, zzamw.m25301a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 15:
                    boolean u = mo29964u(Stub.m22186a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzfo.m30223a(parcel4, u);
                    break;
                case 16:
                    String readString6 = parcel.readString();
                    String readString7 = parcel.readString();
                    zzxz zzxz3 = (zzxz) zzfo.m30220a(parcel, zzxz.CREATOR);
                    IObjectWrapper a4 = Stub.m22186a(parcel.readStrongBinder());
                    IBinder readStrongBinder4 = parcel.readStrongBinder();
                    if (readStrongBinder4 == null) {
                        zzaos = null;
                    } else {
                        IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        if (queryLocalInterface4 instanceof zzaos) {
                            zzaos = (zzaos) queryLocalInterface4;
                        } else {
                            zzaos = new zzaou(readStrongBinder4);
                        }
                    }
                    mo29961a(readString6, readString7, zzxz3, a4, zzaos, zzamw.m25301a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 17:
                    boolean v = mo29965v(Stub.m22186a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzfo.m30223a(parcel4, v);
                    break;
                case 18:
                    String readString8 = parcel.readString();
                    String readString9 = parcel.readString();
                    zzxz zzxz4 = (zzxz) zzfo.m30220a(parcel, zzxz.CREATOR);
                    IObjectWrapper a5 = Stub.m22186a(parcel.readStrongBinder());
                    IBinder readStrongBinder5 = parcel.readStrongBinder();
                    if (readStrongBinder5 == null) {
                        zzaop = null;
                    } else {
                        IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        if (queryLocalInterface5 instanceof zzaop) {
                            zzaop = (zzaop) queryLocalInterface5;
                        } else {
                            zzaop = new zzaor(readStrongBinder5);
                        }
                    }
                    mo29960a(readString8, readString9, zzxz4, a5, zzaop, zzamw.m25301a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
        } else {
            mo29962a(parcel.createStringArray(), (Bundle[]) parcel.createTypedArray(Bundle.CREATOR));
            parcel2.writeNoException();
        }
        return true;
    }
}
