package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.common.api.internal.s */
final class C8679s implements OnConnectionFailedListener {

    /* renamed from: a */
    private final /* synthetic */ StatusPendingResult f19773a;

    C8679s(zaaw zaaw, StatusPendingResult statusPendingResult) {
        this.f19773a = statusPendingResult;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f19773a.mo27451a(new Status(8));
    }
}
