package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.auth.api.signin.internal.a */
final class C8619a extends C8623e<Status> {
    C8619a(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ void mo27234a(AnyClient anyClient) throws RemoteException {
        zzg zzg = (zzg) anyClient;
        ((zzu) zzg.getService()).mo27254a(new C8620b(this), zzg.mo27247k());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ Result mo27233a(Status status) {
        return status;
    }
}
