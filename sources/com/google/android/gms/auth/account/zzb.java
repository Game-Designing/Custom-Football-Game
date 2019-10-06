package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzc;

public abstract class zzb extends com.google.android.gms.internal.auth.zzb implements zza {
    public zzb() {
        super("com.google.android.gms.auth.account.IWorkAccountCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo27093a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo27091a((Account) zzc.m31675a(parcel, Account.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            mo27092d(zzc.m31676a(parcel));
        }
        return true;
    }
}
