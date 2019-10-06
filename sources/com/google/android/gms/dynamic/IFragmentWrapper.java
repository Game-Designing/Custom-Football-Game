package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public interface IFragmentWrapper extends IInterface {

    public static abstract class Stub extends zzb implements IFragmentWrapper {

        public static class zza extends com.google.android.gms.internal.common.zza implements IFragmentWrapper {
        }

        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final boolean mo27802a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    IObjectWrapper aa = mo27966aa();
                    parcel2.writeNoException();
                    zzc.m31717a(parcel2, (IInterface) aa);
                    break;
                case 3:
                    Bundle Va = mo27964Va();
                    parcel2.writeNoException();
                    zzc.m31718a(parcel2, (Parcelable) Va);
                    break;
                case 4:
                    int id = getId();
                    parcel2.writeNoException();
                    parcel2.writeInt(id);
                    break;
                case 5:
                    IFragmentWrapper ea = mo27968ea();
                    parcel2.writeNoException();
                    zzc.m31717a(parcel2, (IInterface) ea);
                    break;
                case 6:
                    IObjectWrapper R = mo27962R();
                    parcel2.writeNoException();
                    zzc.m31717a(parcel2, (IInterface) R);
                    break;
                case 7:
                    boolean Ga = mo27957Ga();
                    parcel2.writeNoException();
                    zzc.m31719a(parcel2, Ga);
                    break;
                case 8:
                    String tag = getTag();
                    parcel2.writeNoException();
                    parcel2.writeString(tag);
                    break;
                case 9:
                    IFragmentWrapper V = mo27963V();
                    parcel2.writeNoException();
                    zzc.m31717a(parcel2, (IInterface) V);
                    break;
                case 10:
                    int oa = mo27979oa();
                    parcel2.writeNoException();
                    parcel2.writeInt(oa);
                    break;
                case 11:
                    boolean P = mo27961P();
                    parcel2.writeNoException();
                    zzc.m31719a(parcel2, P);
                    break;
                case 12:
                    IObjectWrapper sa = mo27980sa();
                    parcel2.writeNoException();
                    zzc.m31717a(parcel2, (IInterface) sa);
                    break;
                case 13:
                    boolean ka = mo27976ka();
                    parcel2.writeNoException();
                    zzc.m31719a(parcel2, ka);
                    break;
                case 14:
                    boolean Ea = mo27956Ea();
                    parcel2.writeNoException();
                    zzc.m31719a(parcel2, Ea);
                    break;
                case 15:
                    boolean isHidden = isHidden();
                    parcel2.writeNoException();
                    zzc.m31719a(parcel2, isHidden);
                    break;
                case 16:
                    boolean Ja = mo27958Ja();
                    parcel2.writeNoException();
                    zzc.m31719a(parcel2, Ja);
                    break;
                case 17:
                    boolean Ma = mo27959Ma();
                    parcel2.writeNoException();
                    zzc.m31719a(parcel2, Ma);
                    break;
                case 18:
                    boolean Na = mo27960Na();
                    parcel2.writeNoException();
                    zzc.m31719a(parcel2, Na);
                    break;
                case 19:
                    boolean isVisible = isVisible();
                    parcel2.writeNoException();
                    zzc.m31719a(parcel2, isVisible);
                    break;
                case 20:
                    mo27978n(com.google.android.gms.dynamic.IObjectWrapper.Stub.m22186a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 21:
                    mo27977l(zzc.m31720a(parcel));
                    parcel2.writeNoException();
                    break;
                case 22:
                    mo27969f(zzc.m31720a(parcel));
                    parcel2.writeNoException();
                    break;
                case 23:
                    mo27974j(zzc.m31720a(parcel));
                    parcel2.writeNoException();
                    break;
                case 24:
                    mo27967e(zzc.m31720a(parcel));
                    parcel2.writeNoException();
                    break;
                case 25:
                    mo27965a((Intent) zzc.m31716a(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    break;
                case 26:
                    startActivityForResult((Intent) zzc.m31716a(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    break;
                case 27:
                    mo27975k(com.google.android.gms.dynamic.IObjectWrapper.Stub.m22186a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    /* renamed from: Ea */
    boolean mo27956Ea() throws RemoteException;

    /* renamed from: Ga */
    boolean mo27957Ga() throws RemoteException;

    /* renamed from: Ja */
    boolean mo27958Ja() throws RemoteException;

    /* renamed from: Ma */
    boolean mo27959Ma() throws RemoteException;

    /* renamed from: Na */
    boolean mo27960Na() throws RemoteException;

    /* renamed from: P */
    boolean mo27961P() throws RemoteException;

    /* renamed from: R */
    IObjectWrapper mo27962R() throws RemoteException;

    /* renamed from: V */
    IFragmentWrapper mo27963V() throws RemoteException;

    /* renamed from: Va */
    Bundle mo27964Va() throws RemoteException;

    /* renamed from: a */
    void mo27965a(Intent intent) throws RemoteException;

    /* renamed from: aa */
    IObjectWrapper mo27966aa() throws RemoteException;

    /* renamed from: e */
    void mo27967e(boolean z) throws RemoteException;

    /* renamed from: ea */
    IFragmentWrapper mo27968ea() throws RemoteException;

    /* renamed from: f */
    void mo27969f(boolean z) throws RemoteException;

    int getId() throws RemoteException;

    String getTag() throws RemoteException;

    boolean isHidden() throws RemoteException;

    boolean isVisible() throws RemoteException;

    /* renamed from: j */
    void mo27974j(boolean z) throws RemoteException;

    /* renamed from: k */
    void mo27975k(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: ka */
    boolean mo27976ka() throws RemoteException;

    /* renamed from: l */
    void mo27977l(boolean z) throws RemoteException;

    /* renamed from: n */
    void mo27978n(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: oa */
    int mo27979oa() throws RemoteException;

    /* renamed from: sa */
    IObjectWrapper mo27980sa() throws RemoteException;

    void startActivityForResult(Intent intent, int i) throws RemoteException;
}
