package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

/* renamed from: com.google.android.gms.common.api.internal.o */
final class C8675o implements ConnectionCallbacks, OnConnectionFailedListener {

    /* renamed from: a */
    private final /* synthetic */ zaak f19767a;

    private C8675o(zaak zaak) {
        this.f19767a = zaak;
    }

    public final void onConnected(Bundle bundle) {
        if (this.f19767a.f19808r.mo27770k()) {
            this.f19767a.f19792b.lock();
            try {
                if (this.f19767a.f19801k != null) {
                    this.f19767a.f19801k.mo33153a(new C8673m(this.f19767a));
                    this.f19767a.f19792b.unlock();
                }
            } finally {
                this.f19767a.f19792b.unlock();
            }
        } else {
            this.f19767a.f19801k.mo33153a(new C8673m(this.f19767a));
        }
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f19767a.f19792b.lock();
        try {
            if (this.f19767a.m21452a(connectionResult)) {
                this.f19767a.m21464e();
                this.f19767a.m21461c();
            } else {
                this.f19767a.m21456b(connectionResult);
            }
        } finally {
            this.f19767a.f19792b.unlock();
        }
    }

    /* synthetic */ C8675o(zaak zaak, C8667g gVar) {
        this(zaak);
    }
}
