package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.api.internal.U */
final class C8655U implements zabt {

    /* renamed from: a */
    private final /* synthetic */ C8653S f19734a;

    private C8655U(C8653S s) {
        this.f19734a = s;
    }

    /* renamed from: a */
    public final void mo27562a(Bundle bundle) {
        this.f19734a.f19727m.lock();
        try {
            this.f19734a.m21357a(bundle);
            this.f19734a.f19724j = ConnectionResult.f19510a;
            this.f19734a.m21371f();
        } finally {
            this.f19734a.f19727m.unlock();
        }
    }

    /* renamed from: a */
    public final void mo27563a(ConnectionResult connectionResult) {
        this.f19734a.f19727m.lock();
        try {
            this.f19734a.f19724j = connectionResult;
            this.f19734a.m21371f();
        } finally {
            this.f19734a.f19727m.unlock();
        }
    }

    /* renamed from: a */
    public final void mo27561a(int i, boolean z) {
        this.f19734a.f19727m.lock();
        try {
            if (!this.f19734a.f19726l && this.f19734a.f19725k != null) {
                if (this.f19734a.f19725k.mo27281f()) {
                    this.f19734a.f19726l = true;
                    this.f19734a.f19719e.onConnectionSuspended(i);
                    this.f19734a.f19727m.unlock();
                    return;
                }
            }
            this.f19734a.f19726l = false;
            this.f19734a.m21356a(i, z);
        } finally {
            this.f19734a.f19727m.unlock();
        }
    }

    /* synthetic */ C8655U(C8653S s, C8654T t) {
        this(s);
    }
}
