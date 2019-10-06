package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

/* renamed from: com.google.android.gms.internal.ads.U */
final class C9162U implements BaseOnConnectionFailedListener {

    /* renamed from: a */
    private final /* synthetic */ zzbbr f21787a;

    C9162U(zzaii zzaii, zzbbr zzbbr) {
        this.f21787a = zzbbr;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f21787a.mo30337a(new RuntimeException("Connection failed."));
    }
}
