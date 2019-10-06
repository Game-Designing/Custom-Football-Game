package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzand extends IInterface {
    /* renamed from: A */
    IObjectWrapper mo29911A() throws RemoteException;

    /* renamed from: B */
    IObjectWrapper mo29912B() throws RemoteException;

    /* renamed from: C */
    boolean mo29913C() throws RemoteException;

    /* renamed from: F */
    boolean mo29914F() throws RemoteException;

    /* renamed from: J */
    zzaei mo29915J() throws RemoteException;

    /* renamed from: a */
    void mo29916a(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: a */
    void mo29917a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    /* renamed from: b */
    void mo29918b(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: c */
    void mo29919c(IObjectWrapper iObjectWrapper) throws RemoteException;

    Bundle getExtras() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    /* renamed from: l */
    zzaea mo29922l() throws RemoteException;

    /* renamed from: m */
    String mo29923m() throws RemoteException;

    /* renamed from: n */
    IObjectWrapper mo29924n() throws RemoteException;

    /* renamed from: o */
    String mo29925o() throws RemoteException;

    /* renamed from: p */
    String mo29926p() throws RemoteException;

    /* renamed from: q */
    List mo29927q() throws RemoteException;

    void recordImpression() throws RemoteException;

    /* renamed from: x */
    String mo29929x() throws RemoteException;
}
