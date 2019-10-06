package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

/* renamed from: com.google.android.gms.internal.ads.Ft */
final class C8864Ft implements BaseOnConnectionFailedListener {

    /* renamed from: a */
    private final /* synthetic */ zzvn f20879a;

    C8864Ft(zzvn zzvn) {
        this.f20879a = zzvn;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.f20879a.f29546b) {
            this.f20879a.f29549e = null;
            if (this.f20879a.f29547c != null) {
                this.f20879a.f29547c = null;
            }
            this.f20879a.f29546b.notifyAll();
        }
    }
}
