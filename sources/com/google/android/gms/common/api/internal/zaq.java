package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;

public final class zaq implements ConnectionCallbacks, OnConnectionFailedListener {

    /* renamed from: a */
    public final Api<?> f19910a;

    /* renamed from: b */
    private final boolean f19911b;

    /* renamed from: c */
    private zar f19912c;

    public zaq(Api<?> api, boolean z) {
        this.f19910a = api;
        this.f19911b = z;
    }

    public final void onConnected(Bundle bundle) {
        m21640a();
        this.f19912c.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i) {
        m21640a();
        this.f19912c.onConnectionSuspended(i);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        m21640a();
        this.f19912c.mo27488a(connectionResult, this.f19910a, this.f19911b);
    }

    /* renamed from: a */
    public final void mo27634a(zar zar) {
        this.f19912c = zar;
    }

    /* renamed from: a */
    private final void m21640a() {
        Preconditions.m21858a(this.f19912c, (Object) "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }
}
