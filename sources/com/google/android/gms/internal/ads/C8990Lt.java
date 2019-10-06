package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

/* renamed from: com.google.android.gms.internal.ads.Lt */
final class C8990Lt implements BaseOnConnectionFailedListener {

    /* renamed from: a */
    private final /* synthetic */ zzbbr f21464a;

    /* renamed from: b */
    private final /* synthetic */ zzwb f21465b;

    C8990Lt(zzwb zzwb, zzbbr zzbbr) {
        this.f21465b = zzwb;
        this.f21464a = zzbbr;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.f21465b.f29562d) {
            this.f21464a.mo30337a(new RuntimeException("Connection failed."));
        }
    }
}
