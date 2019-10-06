package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import java.io.InputStream;

public abstract class zzchx implements BaseConnectionCallbacks, BaseOnConnectionFailedListener {

    /* renamed from: a */
    protected final zzbbr<InputStream> f26649a = new zzbbr<>();

    /* renamed from: b */
    protected final Object f26650b = new Object();

    /* renamed from: c */
    protected boolean f26651c = false;

    /* renamed from: d */
    protected boolean f26652d = false;

    /* renamed from: e */
    protected zzarx f26653e;

    /* renamed from: f */
    protected zzarf f26654f;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo31167a() {
        synchronized (this.f26650b) {
            this.f26652d = true;
            if (this.f26654f.isConnected() || this.f26654f.isConnecting()) {
                this.f26654f.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    public void onConnectionSuspended(int i) {
        zzbad.m26352a("Cannot connect to remote service, fallback to local instance.");
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        zzbad.m26352a("Disconnected from remote ad request service.");
        this.f26649a.mo30337a(new zzcie(0));
    }
}
