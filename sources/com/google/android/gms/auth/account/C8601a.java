package com.google.android.gms.auth.account;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth.zzr;

/* renamed from: com.google.android.gms.auth.account.a */
final class C8601a extends AbstractClientBuilder<zzr, NoOptions> {
    C8601a() {
    }

    /* renamed from: a */
    public final /* synthetic */ Client mo27090a(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        zzr zzr = new zzr(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
        return zzr;
    }
}
