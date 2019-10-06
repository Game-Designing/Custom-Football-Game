package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

/* renamed from: com.google.android.gms.internal.ads.Ht */
final class C8906Ht implements BaseConnectionCallbacks {

    /* renamed from: a */
    private final /* synthetic */ zzvv f21235a;

    /* renamed from: b */
    private final /* synthetic */ zzbbr f21236b;

    /* renamed from: c */
    final /* synthetic */ zzwb f21237c;

    C8906Ht(zzwb zzwb, zzvv zzvv, zzbbr zzbbr) {
        this.f21237c = zzwb;
        this.f21235a = zzvv;
        this.f21236b = zzbbr;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.f21237c.f29562d) {
            if (!this.f21237c.f29560b) {
                this.f21237c.f29560b = true;
                zzvu d = this.f21237c.f29559a;
                if (d != null) {
                    this.f21236b.mo28811a(new C8948Jt(this.f21236b, zzaxg.m26094a((Runnable) new C8927It(this, d, this.f21235a, this.f21236b))), zzbbm.f25065b);
                }
            }
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
