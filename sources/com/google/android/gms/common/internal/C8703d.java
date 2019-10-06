package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

/* renamed from: com.google.android.gms.common.internal.d */
final class C8703d implements BaseConnectionCallbacks {

    /* renamed from: a */
    private final /* synthetic */ ConnectionCallbacks f20148a;

    C8703d(ConnectionCallbacks connectionCallbacks) {
        this.f20148a = connectionCallbacks;
    }

    public final void onConnected(Bundle bundle) {
        this.f20148a.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i) {
        this.f20148a.onConnectionSuspended(i);
    }
}
