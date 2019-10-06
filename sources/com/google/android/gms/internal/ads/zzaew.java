package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzaew extends IInterface {
    /* renamed from: b */
    boolean mo29650b(Bundle bundle) throws RemoteException;

    /* renamed from: c */
    void mo29651c(Bundle bundle) throws RemoteException;

    /* renamed from: d */
    void mo29652d(Bundle bundle) throws RemoteException;

    void destroy() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    String getStore() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    /* renamed from: j */
    double mo29658j() throws RemoteException;

    /* renamed from: l */
    zzaea mo29659l() throws RemoteException;

    /* renamed from: m */
    String mo29660m() throws RemoteException;

    /* renamed from: n */
    IObjectWrapper mo29661n() throws RemoteException;

    /* renamed from: o */
    String mo29662o() throws RemoteException;

    /* renamed from: p */
    String mo29663p() throws RemoteException;

    /* renamed from: q */
    List mo29664q() throws RemoteException;

    /* renamed from: t */
    zzaei mo29665t() throws RemoteException;

    /* renamed from: u */
    String mo29666u() throws RemoteException;

    /* renamed from: v */
    IObjectWrapper mo29667v() throws RemoteException;
}
