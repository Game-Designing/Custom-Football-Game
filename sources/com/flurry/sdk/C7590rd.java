package com.flurry.sdk;

import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.flurry.sdk.rd */
final class C7590rd {

    /* renamed from: a */
    private Timer f15065a;

    /* renamed from: b */
    private C7591a f15066b;

    /* renamed from: com.flurry.sdk.rd$a */
    class C7591a extends TimerTask {
        C7591a() {
        }

        public final void run() {
            C7590rd.this.mo24017b();
            C7462Ub.m16528a().mo23908a((C7447Rb) new C7597sd());
        }
    }

    C7590rd() {
    }

    /* renamed from: a */
    public final synchronized void mo24015a(long j) {
        if (mo24016a()) {
            mo24017b();
        }
        this.f15065a = new Timer("FlurrySessionTimer");
        this.f15066b = new C7591a();
        this.f15065a.schedule(this.f15066b, j);
    }

    /* renamed from: a */
    public final boolean mo24016a() {
        return this.f15065a != null;
    }

    /* renamed from: b */
    public final synchronized void mo24017b() {
        if (this.f15065a != null) {
            this.f15065a.cancel();
            this.f15065a = null;
        }
        this.f15066b = null;
    }
}
