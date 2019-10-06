package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public abstract class zae extends zab implements zad {
    public zae() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo27506a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 3) {
            mo33158a((ConnectionResult) zac.m31705a(parcel, ConnectionResult.CREATOR), (zaa) zac.m31705a(parcel, zaa.CREATOR));
        } else if (i == 4) {
            mo33160b((Status) zac.m31705a(parcel, Status.CREATOR));
        } else if (i == 6) {
            mo33161c((Status) zac.m31705a(parcel, Status.CREATOR));
        } else if (i == 7) {
            mo33159a((Status) zac.m31705a(parcel, Status.CREATOR), (GoogleSignInAccount) zac.m31705a(parcel, GoogleSignInAccount.CREATOR));
        } else if (i != 8) {
            return false;
        } else {
            mo27573a((zaj) zac.m31705a(parcel, zaj.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
