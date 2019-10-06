package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.auth.api.signin.internal.c */
final class C8621c extends C8623e<Status> {
    C8621c(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ void mo27234a(AnyClient anyClient) throws RemoteException {
        zzg zzg = (zzg) anyClient;
        ((zzu) zzg.getService()).mo27255b(new C8622d(this), zzg.mo27247k());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Result mo27233a(Status status) {
        return status;
    }
}
