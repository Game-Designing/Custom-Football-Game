package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public interface zad extends IInterface {
    /* renamed from: a */
    void mo33158a(ConnectionResult connectionResult, zaa zaa) throws RemoteException;

    /* renamed from: a */
    void mo33159a(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    /* renamed from: a */
    void mo27573a(zaj zaj) throws RemoteException;

    /* renamed from: b */
    void mo33160b(Status status) throws RemoteException;

    /* renamed from: c */
    void mo33161c(Status status) throws RemoteException;
}
