package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;

/* renamed from: com.google.android.gms.common.api.internal.B */
final class C8633B implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ ConnectionResult f19610a;

    /* renamed from: b */
    private final /* synthetic */ zaa f19611b;

    C8633B(zaa zaa, ConnectionResult connectionResult) {
        this.f19611b = zaa;
        this.f19610a = connectionResult;
    }

    public final void run() {
        this.f19611b.onConnectionFailed(this.f19610a);
    }
}
