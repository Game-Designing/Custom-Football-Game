package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.api.internal.V */
final class C8656V implements zabt {

    /* renamed from: a */
    private final /* synthetic */ C8653S f19735a;

    private C8656V(C8653S s) {
        this.f19735a = s;
    }

    /* renamed from: a */
    public final void mo27562a(Bundle bundle) {
        this.f19735a.f19727m.lock();
        try {
            this.f19735a.f19725k = ConnectionResult.f19510a;
            this.f19735a.m21371f();
        } finally {
            this.f19735a.f19727m.unlock();
        }
    }

    /* renamed from: a */
    public final void mo27563a(ConnectionResult connectionResult) {
        this.f19735a.f19727m.lock();
        try {
            this.f19735a.f19725k = connectionResult;
            this.f19735a.m21371f();
        } finally {
            this.f19735a.f19727m.unlock();
        }
    }

    /* renamed from: a */
    public final void mo27561a(int i, boolean z) {
        this.f19735a.f19727m.lock();
        try {
            if (this.f19735a.f19726l) {
                this.f19735a.f19726l = false;
                this.f19735a.m21356a(i, z);
                return;
            }
            this.f19735a.f19726l = true;
            this.f19735a.f19718d.onConnectionSuspended(i);
            this.f19735a.f19727m.unlock();
        } finally {
            this.f19735a.f19727m.unlock();
        }
    }

    /* synthetic */ C8656V(C8653S s, C8654T t) {
        this(s);
    }
}
