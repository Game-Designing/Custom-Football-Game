package com.google.android.gms.internal.location;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

public final class zzaz extends zzk {

    /* renamed from: H */
    private final zzas f29944H;

    public zzaz(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, ClientSettings.m21779a(context));
    }

    public zzaz(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, ClientSettings clientSettings) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, clientSettings);
        this.f29944H = new zzas(context, this.f29972G);
    }

    public final void disconnect() {
        synchronized (this.f29944H) {
            if (isConnected()) {
                try {
                    this.f29944H.mo32505b();
                    this.f29944H.mo32506c();
                } catch (Exception e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    /* renamed from: k */
    public final Location mo27247k() throws RemoteException {
        return this.f29944H.mo32503a();
    }
}
