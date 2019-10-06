package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;
import java.util.Collections;

/* renamed from: com.google.android.gms.common.api.internal.E */
final class C8637E implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ ConnectionResult f19640a;

    /* renamed from: b */
    private final /* synthetic */ C8641b f19641b;

    C8637E(C8641b bVar, ConnectionResult connectionResult) {
        this.f19641b = bVar;
        this.f19640a = connectionResult;
    }

    public final void run() {
        if (this.f19640a.mo27281f()) {
            this.f19641b.f19668e = true;
            if (this.f19641b.f19664a.requiresSignIn()) {
                this.f19641b.m21263a();
                return;
            }
            try {
                this.f19641b.f19664a.getRemoteService(null, Collections.emptySet());
            } catch (SecurityException e) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
                ((zaa) GoogleApiManager.this.f19657m.get(this.f19641b.f19665b)).onConnectionFailed(new ConnectionResult(10));
            }
        } else {
            ((zaa) GoogleApiManager.this.f19657m.get(this.f19641b.f19665b)).onConnectionFailed(this.f19640a);
        }
    }
}
