package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.location.zzaz;

/* renamed from: com.google.android.gms.location.a */
final class C10029a extends AbstractClientBuilder<zzaz, NoOptions> {
    C10029a() {
    }

    /* renamed from: a */
    public final /* synthetic */ Client mo27090a(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        zzaz zzaz = new zzaz(context, looper, connectionCallbacks, onConnectionFailedListener, "activity_recognition");
        return zzaz;
    }
}
