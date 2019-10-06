package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzasw extends IInterface {
    /* renamed from: A */
    void mo29557A(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: D */
    void mo29558D(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: G */
    void mo29559G(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: a */
    void mo29560a(zzasu zzasu) throws RemoteException;

    /* renamed from: a */
    void mo29561a(zzatb zzatb) throws RemoteException;

    /* renamed from: a */
    void mo29562a(zzath zzath) throws RemoteException;

    /* renamed from: a */
    void mo29563a(zzzp zzzp) throws RemoteException;

    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    /* renamed from: h */
    void mo29567h(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: h */
    void mo29568h(String str) throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setCustomData(String str) throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void show() throws RemoteException;
}
