package com.google.android.gms.internal.safetynet;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.zza;
import com.google.android.gms.safetynet.zzd;
import com.google.android.gms.safetynet.zzf;
import com.google.android.gms.safetynet.zzh;

public interface zzg extends IInterface {
    /* renamed from: a */
    void mo32975a(Status status) throws RemoteException;

    /* renamed from: a */
    void mo32976a(Status status, SafeBrowsingData safeBrowsingData) throws RemoteException;

    /* renamed from: a */
    void mo32977a(Status status, zza zza) throws RemoteException;

    /* renamed from: a */
    void mo32968a(Status status, zzd zzd) throws RemoteException;

    /* renamed from: a */
    void mo32978a(Status status, zzf zzf) throws RemoteException;

    /* renamed from: a */
    void mo32979a(Status status, zzh zzh) throws RemoteException;

    /* renamed from: a */
    void mo32980a(Status status, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo32981b(Status status, boolean z) throws RemoteException;

    /* renamed from: c */
    void mo32982c(String str) throws RemoteException;
}
