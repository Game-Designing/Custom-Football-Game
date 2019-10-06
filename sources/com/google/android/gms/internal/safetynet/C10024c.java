package com.google.android.gms.internal.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

/* renamed from: com.google.android.gms.internal.safetynet.c */
final class C10024c extends C10026a {
    C10024c(zzk zzk, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ void mo27234a(AnyClient anyClient) throws RemoteException {
        zzx zzx = (zzx) anyClient;
        ((zzi) zzx.getService()).mo32983a(this.f30444s);
    }
}
