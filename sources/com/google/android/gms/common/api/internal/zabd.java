package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

public interface zabd {
    /* renamed from: a */
    <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T mo27589a(T t);

    /* renamed from: a */
    void mo27590a();

    /* renamed from: a */
    void mo27591a(ConnectionResult connectionResult, Api<?> api, boolean z);

    /* renamed from: b */
    <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T mo27592b(T t);

    void connect();

    boolean disconnect();

    void onConnected(Bundle bundle);

    void onConnectionSuspended(int i);
}
