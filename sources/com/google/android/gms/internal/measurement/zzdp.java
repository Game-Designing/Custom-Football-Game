package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzdp extends zzq implements zzdn {
    zzdp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    /* renamed from: a */
    public final void mo32763a(IObjectWrapper iObjectWrapper, zzdy zzdy, long j) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) iObjectWrapper);
        zzs.m32376a(a, (Parcelable) zzdy);
        a.writeLong(j);
        mo32833a(1, a);
    }

    /* renamed from: a */
    public final void mo32772a(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel a = mo32832a();
        a.writeString(str);
        a.writeString(str2);
        zzs.m32376a(a, (Parcelable) bundle);
        zzs.m32377a(a, z);
        zzs.m32377a(a, z2);
        a.writeLong(j);
        mo32833a(2, a);
    }

    /* renamed from: a */
    public final void mo32773a(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel a = mo32832a();
        a.writeString(str);
        a.writeString(str2);
        zzs.m32375a(a, (IInterface) iObjectWrapper);
        zzs.m32377a(a, z);
        a.writeLong(j);
        mo32833a(4, a);
    }

    /* renamed from: a */
    public final void mo32775a(String str, String str2, boolean z, zzdq zzdq) throws RemoteException {
        Parcel a = mo32832a();
        a.writeString(str);
        a.writeString(str2);
        zzs.m32377a(a, z);
        zzs.m32375a(a, (IInterface) zzdq);
        mo32833a(5, a);
    }

    /* renamed from: a */
    public final void mo32770a(String str, zzdq zzdq) throws RemoteException {
        Parcel a = mo32832a();
        a.writeString(str);
        zzs.m32375a(a, (IInterface) zzdq);
        mo32833a(6, a);
    }

    /* renamed from: a */
    public final void mo32758a(Bundle bundle, long j) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32376a(a, (Parcelable) bundle);
        a.writeLong(j);
        mo32833a(8, a);
    }

    /* renamed from: b */
    public final void mo32783b(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel a = mo32832a();
        a.writeString(str);
        a.writeString(str2);
        zzs.m32376a(a, (Parcelable) bundle);
        mo32833a(9, a);
    }

    /* renamed from: a */
    public final void mo32774a(String str, String str2, zzdq zzdq) throws RemoteException {
        Parcel a = mo32832a();
        a.writeString(str);
        a.writeString(str2);
        zzs.m32375a(a, (IInterface) zzdq);
        mo32833a(10, a);
    }

    /* renamed from: a */
    public final void mo32764a(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        a.writeString(str2);
        a.writeLong(j);
        mo32833a(15, a);
    }

    /* renamed from: f */
    public final void mo32793f(zzdq zzdq) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) zzdq);
        mo32833a(16, a);
    }

    /* renamed from: b */
    public final void mo32780b(zzdq zzdq) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) zzdq);
        mo32833a(17, a);
    }

    /* renamed from: e */
    public final void mo32792e(zzdq zzdq) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) zzdq);
        mo32833a(19, a);
    }

    /* renamed from: c */
    public final void mo32786c(zzdq zzdq) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) zzdq);
        mo32833a(21, a);
    }

    /* renamed from: d */
    public final void mo32790d(zzdq zzdq) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) zzdq);
        mo32833a(22, a);
    }

    /* renamed from: b */
    public final void mo32782b(String str, long j) throws RemoteException {
        Parcel a = mo32832a();
        a.writeString(str);
        a.writeLong(j);
        mo32833a(23, a);
    }

    /* renamed from: c */
    public final void mo32788c(String str, long j) throws RemoteException {
        Parcel a = mo32832a();
        a.writeString(str);
        a.writeLong(j);
        mo32833a(24, a);
    }

    /* renamed from: c */
    public final void mo32785c(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) iObjectWrapper);
        a.writeLong(j);
        mo32833a(25, a);
    }

    /* renamed from: a */
    public final void mo32760a(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) iObjectWrapper);
        a.writeLong(j);
        mo32833a(26, a);
    }

    /* renamed from: a */
    public final void mo32761a(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) iObjectWrapper);
        zzs.m32376a(a, (Parcelable) bundle);
        a.writeLong(j);
        mo32833a(27, a);
    }

    /* renamed from: b */
    public final void mo32779b(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) iObjectWrapper);
        a.writeLong(j);
        mo32833a(28, a);
    }

    /* renamed from: d */
    public final void mo32789d(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) iObjectWrapper);
        a.writeLong(j);
        mo32833a(29, a);
    }

    /* renamed from: e */
    public final void mo32791e(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) iObjectWrapper);
        a.writeLong(j);
        mo32833a(30, a);
    }

    /* renamed from: a */
    public final void mo32762a(IObjectWrapper iObjectWrapper, zzdq zzdq, long j) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32375a(a, (IInterface) iObjectWrapper);
        zzs.m32375a(a, (IInterface) zzdq);
        a.writeLong(j);
        mo32833a(31, a);
    }

    /* renamed from: a */
    public final void mo32759a(Bundle bundle, zzdq zzdq, long j) throws RemoteException {
        Parcel a = mo32832a();
        zzs.m32376a(a, (Parcelable) bundle);
        zzs.m32375a(a, (IInterface) zzdq);
        a.writeLong(j);
        mo32833a(32, a);
    }

    /* renamed from: a */
    public final void mo32756a(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel a = mo32832a();
        a.writeInt(i);
        a.writeString(str);
        zzs.m32375a(a, (IInterface) iObjectWrapper);
        zzs.m32375a(a, (IInterface) iObjectWrapper2);
        zzs.m32375a(a, (IInterface) iObjectWrapper3);
        mo32833a(33, a);
    }
}
