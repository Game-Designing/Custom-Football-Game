package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.List;

public final class zzamu extends zzfm implements zzams {
    zzamu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    /* renamed from: a */
    public final void mo29847a(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30222a(a, (Parcelable) zzyd);
        zzfo.m30222a(a, (Parcelable) zzxz);
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) zzamv);
        mo31752b(1, a);
    }

    /* renamed from: Ca */
    public final IObjectWrapper mo29837Ca() throws RemoteException {
        Parcel a = mo31750a(2, mo31749a());
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final void mo29851b(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30222a(a, (Parcelable) zzxz);
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) zzamv);
        mo31752b(3, a);
    }

    public final void showInterstitial() throws RemoteException {
        mo31752b(4, mo31749a());
    }

    public final void destroy() throws RemoteException {
        mo31752b(5, mo31749a());
    }

    /* renamed from: a */
    public final void mo29848a(IObjectWrapper iObjectWrapper, zzyd zzyd, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30222a(a, (Parcelable) zzyd);
        zzfo.m30222a(a, (Parcelable) zzxz);
        a.writeString(str);
        a.writeString(str2);
        zzfo.m30221a(a, (IInterface) zzamv);
        mo31752b(6, a);
    }

    /* renamed from: a */
    public final void mo29845a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30222a(a, (Parcelable) zzxz);
        a.writeString(str);
        a.writeString(str2);
        zzfo.m30221a(a, (IInterface) zzamv);
        mo31752b(7, a);
    }

    public final void pause() throws RemoteException {
        mo31752b(8, mo31749a());
    }

    public final void resume() throws RemoteException {
        mo31752b(9, mo31749a());
    }

    /* renamed from: a */
    public final void mo29844a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzatk zzatk, String str2) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30222a(a, (Parcelable) zzxz);
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) zzatk);
        a.writeString(str2);
        mo31752b(10, a);
    }

    /* renamed from: a */
    public final void mo29849a(zzxz zzxz, String str) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzxz);
        a.writeString(str);
        mo31752b(11, a);
    }

    public final void showVideo() throws RemoteException {
        mo31752b(12, mo31749a());
    }

    public final boolean isInitialized() throws RemoteException {
        Parcel a = mo31750a(13, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final void mo29846a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, String str2, zzamv zzamv, zzady zzady, List<String> list) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30222a(a, (Parcelable) zzxz);
        a.writeString(str);
        a.writeString(str2);
        zzfo.m30221a(a, (IInterface) zzamv);
        zzfo.m30222a(a, (Parcelable) zzady);
        a.writeStringList(list);
        mo31752b(14, a);
    }

    /* renamed from: eb */
    public final zzana mo29855eb() throws RemoteException {
        zzana zzana;
        Parcel a = mo31750a(15, mo31749a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzana = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            if (queryLocalInterface instanceof zzana) {
                zzana = (zzana) queryLocalInterface;
            } else {
                zzana = new zzanc(readStrongBinder);
            }
        }
        a.recycle();
        return zzana;
    }

    /* renamed from: bb */
    public final zzand mo29852bb() throws RemoteException {
        zzand zzand;
        Parcel a = mo31750a(16, mo31749a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzand = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            if (queryLocalInterface instanceof zzand) {
                zzand = (zzand) queryLocalInterface;
            } else {
                zzand = new zzanf(readStrongBinder);
            }
        }
        a.recycle();
        return zzand;
    }

    /* renamed from: m */
    public final void mo29860m(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(21, a);
    }

    /* renamed from: da */
    public final boolean mo29853da() throws RemoteException {
        Parcel a = mo31750a(22, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final void mo29842a(IObjectWrapper iObjectWrapper, zzatk zzatk, List<String> list) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30221a(a, (IInterface) zzatk);
        a.writeStringList(list);
        mo31752b(23, a);
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30223a(a, z);
        mo31752b(25, a);
    }

    public final zzaar getVideoController() throws RemoteException {
        Parcel a = mo31750a(26, mo31749a());
        zzaar a2 = zzaas.m24526a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: S */
    public final zzang mo29839S() throws RemoteException {
        zzang zzang;
        Parcel a = mo31750a(27, mo31749a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzang = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            if (queryLocalInterface instanceof zzang) {
                zzang = (zzang) queryLocalInterface;
            } else {
                zzang = new zzani(readStrongBinder);
            }
        }
        a.recycle();
        return zzang;
    }

    /* renamed from: a */
    public final void mo29843a(IObjectWrapper iObjectWrapper, zzxz zzxz, String str, zzamv zzamv) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30222a(a, (Parcelable) zzxz);
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) zzamv);
        mo31752b(28, a);
    }

    /* renamed from: l */
    public final void mo29859l(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(30, a);
    }

    /* renamed from: a */
    public final void mo29841a(IObjectWrapper iObjectWrapper, zzaiq zzaiq, List<zzaiw> list) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30221a(a, (IInterface) zzaiq);
        a.writeTypedList(list);
        mo31752b(31, a);
    }
}
