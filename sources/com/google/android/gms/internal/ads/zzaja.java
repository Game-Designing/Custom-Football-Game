package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzaja extends IInterface {
    /* renamed from: a */
    void mo29764a(IObjectWrapper iObjectWrapper, zzajc zzajc) throws RemoteException;

    void destroy() throws RemoteException;

    zzaar getVideoController() throws RemoteException;
}
