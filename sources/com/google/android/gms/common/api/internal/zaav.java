package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import java.util.Collections;

public final class zaav implements zabd {

    /* renamed from: a */
    private final zabe f19812a;

    public zaav(zabe zabe) {
        this.f19812a = zabe;
    }

    /* renamed from: a */
    public final void mo27590a() {
        for (Client disconnect : this.f19812a.f19844f.values()) {
            disconnect.disconnect();
        }
        this.f19812a.f19852n.f19828q = Collections.emptySet();
    }

    /* renamed from: b */
    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T mo27592b(T t) {
        this.f19812a.f19852n.f19820i.add(t);
        return t;
    }

    /* renamed from: a */
    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T mo27589a(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final boolean disconnect() {
        return true;
    }

    public final void connect() {
        this.f19812a.mo27609e();
    }

    public final void onConnected(Bundle bundle) {
    }

    /* renamed from: a */
    public final void mo27591a(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    public final void onConnectionSuspended(int i) {
    }
}
