package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzadl extends IInterface {
    /* renamed from: f */
    void mo29623f(IObjectWrapper iObjectWrapper) throws RemoteException;

    String getContent() throws RemoteException;

    /* renamed from: qa */
    String mo29625qa() throws RemoteException;

    void recordClick() throws RemoteException;

    void recordImpression() throws RemoteException;
}
