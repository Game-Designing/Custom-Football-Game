package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzafa extends IInterface {
    /* renamed from: J */
    zzaei mo29669J() throws RemoteException;

    /* renamed from: b */
    boolean mo29670b(Bundle bundle) throws RemoteException;

    /* renamed from: c */
    void mo29671c(Bundle bundle) throws RemoteException;

    /* renamed from: d */
    void mo29672d(Bundle bundle) throws RemoteException;

    void destroy() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    /* renamed from: l */
    zzaea mo29677l() throws RemoteException;

    /* renamed from: m */
    String mo29678m() throws RemoteException;

    /* renamed from: n */
    IObjectWrapper mo29679n() throws RemoteException;

    /* renamed from: o */
    String mo29680o() throws RemoteException;

    /* renamed from: p */
    String mo29681p() throws RemoteException;

    /* renamed from: q */
    List mo29682q() throws RemoteException;

    /* renamed from: v */
    IObjectWrapper mo29683v() throws RemoteException;

    /* renamed from: x */
    String mo29684x() throws RemoteException;
}
