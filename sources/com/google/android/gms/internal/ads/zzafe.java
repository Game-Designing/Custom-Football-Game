package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzafe extends IInterface {
    void destroy() throws RemoteException;

    List<String> getAvailableAssetNames() throws RemoteException;

    String getCustomTemplateId() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    /* renamed from: j */
    boolean mo29689j(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: la */
    IObjectWrapper mo29690la() throws RemoteException;

    /* renamed from: m */
    String mo29691m(String str) throws RemoteException;

    /* renamed from: o */
    zzaei mo29692o(String str) throws RemoteException;

    void performClick(String str) throws RemoteException;

    void recordImpression() throws RemoteException;

    /* renamed from: v */
    IObjectWrapper mo29695v() throws RemoteException;
}
