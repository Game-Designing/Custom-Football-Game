package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzang extends IInterface {
    /* renamed from: A */
    IObjectWrapper mo29930A() throws RemoteException;

    /* renamed from: B */
    IObjectWrapper mo29931B() throws RemoteException;

    /* renamed from: C */
    boolean mo29932C() throws RemoteException;

    /* renamed from: F */
    boolean mo29933F() throws RemoteException;

    /* renamed from: a */
    void mo29934a(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: a */
    void mo29935a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    /* renamed from: b */
    void mo29936b(IObjectWrapper iObjectWrapper) throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getStore() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    /* renamed from: ia */
    float mo29940ia() throws RemoteException;

    /* renamed from: j */
    double mo29941j() throws RemoteException;

    /* renamed from: l */
    zzaea mo29942l() throws RemoteException;

    /* renamed from: m */
    String mo29943m() throws RemoteException;

    /* renamed from: n */
    IObjectWrapper mo29944n() throws RemoteException;

    /* renamed from: o */
    String mo29945o() throws RemoteException;

    /* renamed from: p */
    String mo29946p() throws RemoteException;

    /* renamed from: q */
    List mo29947q() throws RemoteException;

    void recordImpression() throws RemoteException;

    /* renamed from: t */
    zzaei mo29949t() throws RemoteException;

    /* renamed from: u */
    String mo29950u() throws RemoteException;

    /* renamed from: x */
    String mo29951x() throws RemoteException;
}
