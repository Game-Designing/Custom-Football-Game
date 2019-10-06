package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public interface zzs extends IInterface {
    /* renamed from: a */
    void mo27239a(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException;

    /* renamed from: g */
    void mo27235g(Status status) throws RemoteException;

    /* renamed from: h */
    void mo27236h(Status status) throws RemoteException;
}
