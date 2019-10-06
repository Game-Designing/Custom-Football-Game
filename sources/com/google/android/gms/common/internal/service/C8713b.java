package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

/* renamed from: com.google.android.gms.common.internal.service.b */
final class C8713b extends C8716e {
    C8713b(zad zad, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ void mo27234a(AnyClient anyClient) throws RemoteException {
        ((zal) ((zai) anyClient).getService()).mo27848a(new C8714c(this));
    }
}
