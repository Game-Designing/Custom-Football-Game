package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzana extends IInterface {
    /* renamed from: A */
    IObjectWrapper mo29890A() throws RemoteException;

    /* renamed from: B */
    IObjectWrapper mo29891B() throws RemoteException;

    /* renamed from: C */
    boolean mo29892C() throws RemoteException;

    /* renamed from: F */
    boolean mo29893F() throws RemoteException;

    /* renamed from: a */
    void mo29894a(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: a */
    void mo29895a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    /* renamed from: b */
    void mo29896b(IObjectWrapper iObjectWrapper) throws RemoteException;

    /* renamed from: c */
    void mo29897c(IObjectWrapper iObjectWrapper) throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getStore() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    /* renamed from: j */
    double mo29901j() throws RemoteException;

    /* renamed from: l */
    zzaea mo29902l() throws RemoteException;

    /* renamed from: m */
    String mo29903m() throws RemoteException;

    /* renamed from: n */
    IObjectWrapper mo29904n() throws RemoteException;

    /* renamed from: o */
    String mo29905o() throws RemoteException;

    /* renamed from: p */
    String mo29906p() throws RemoteException;

    /* renamed from: q */
    List mo29907q() throws RemoteException;

    void recordImpression() throws RemoteException;

    /* renamed from: t */
    zzaei mo29909t() throws RemoteException;

    /* renamed from: u */
    String mo29910u() throws RemoteException;
}
