package com.google.android.gms.safetynet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.safetynet.zzx;

/* renamed from: com.google.android.gms.safetynet.a */
final class C10038a extends AbstractClientBuilder<zzx, NoOptions> {
    C10038a() {
    }

    /* renamed from: a */
    public final /* synthetic */ Client mo27090a(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        zzx zzx = new zzx(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
        return zzx;
    }
}
