package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

/* renamed from: com.google.android.gms.common.internal.e */
final class C8704e implements BaseOnConnectionFailedListener {

    /* renamed from: a */
    private final /* synthetic */ OnConnectionFailedListener f20149a;

    C8704e(OnConnectionFailedListener onConnectionFailedListener) {
        this.f20149a = onConnectionFailedListener;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f20149a.onConnectionFailed(connectionResult);
    }
}
