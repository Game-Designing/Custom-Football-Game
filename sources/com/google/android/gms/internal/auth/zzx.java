package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzl;
import com.google.android.gms.auth.api.accounttransfer.zzt;
import com.google.android.gms.common.api.Status;

public interface zzx extends IInterface {
    /* renamed from: Sa */
    void mo32440Sa() throws RemoteException;

    /* renamed from: a */
    void mo32441a(DeviceMetaData deviceMetaData) throws RemoteException;

    /* renamed from: a */
    void mo32442a(Status status, zzl zzl) throws RemoteException;

    /* renamed from: a */
    void mo32443a(Status status, zzt zzt) throws RemoteException;

    /* renamed from: b */
    void mo32444b(byte[] bArr) throws RemoteException;

    /* renamed from: d */
    void mo32445d(Status status) throws RemoteException;

    /* renamed from: e */
    void mo32446e(Status status) throws RemoteException;
}
