package com.google.android.gms.internal.auth-api;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public interface zzu extends IInterface {
    /* renamed from: a */
    void mo32414a(Status status, Credential credential) throws RemoteException;

    /* renamed from: a */
    void mo32415a(Status status, String str) throws RemoteException;

    /* renamed from: f */
    void mo32416f(Status status) throws RemoteException;
}
