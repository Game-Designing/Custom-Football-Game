package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

/* renamed from: com.google.android.gms.internal.ads.Et */
final class C8843Et implements BaseConnectionCallbacks {

    /* renamed from: a */
    private final /* synthetic */ zzvn f20846a;

    C8843Et(zzvn zzvn) {
        this.f20846a = zzvn;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.f20846a.f29546b) {
            try {
                if (this.f20846a.f29547c != null) {
                    this.f20846a.f29549e = this.f20846a.f29547c.mo27780j();
                }
            } catch (DeadObjectException e) {
                zzbad.m26356b("Unable to obtain a cache service instance.", e);
                this.f20846a.m31304c();
            }
            this.f20846a.f29546b.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.f20846a.f29546b) {
            this.f20846a.f29549e = null;
            this.f20846a.f29546b.notifyAll();
        }
    }
}
