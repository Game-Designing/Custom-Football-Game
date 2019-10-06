package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzatt extends IInterface {
    /* renamed from: C */
    void mo29546C(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: a */
    void mo29547a(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo29548a(zzaao zzaao) throws RemoteException;

    /* renamed from: a */
    void mo29549a(zzatw zzatw) throws RemoteException;

    /* renamed from: a */
    void mo29550a(zzaue zzaue) throws RemoteException;

    /* renamed from: a */
    void mo29551a(zzaum zzaum) throws RemoteException;

    /* renamed from: a */
    void mo29552a(zzxz zzxz, zzaub zzaub) throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    /* renamed from: xa */
    zzatq mo29556xa() throws RemoteException;
}
