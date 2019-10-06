package com.flurry.sdk;

import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.flurry.sdk.mc */
public class C7560mc {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f14944a = C7560mc.class.getSimpleName();

    /* renamed from: b */
    private Timer f14945b;

    /* renamed from: c */
    private C7561a f14946c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C7577pc f14947d;

    /* renamed from: com.flurry.sdk.mc$a */
    class C7561a extends TimerTask {
        private C7561a() {
        }

        /* synthetic */ C7561a(C7560mc mcVar, byte b) {
            this();
        }

        public final void run() {
            C7513ec.m16639a(3, C7560mc.f14944a, "HttpRequest timed out. Cancelling.");
            C7577pc a = C7560mc.this.f14947d;
            long currentTimeMillis = System.currentTimeMillis() - a.f15014u;
            String str = C7577pc.f14996e;
            StringBuilder sb = new StringBuilder("Timeout (");
            sb.append(currentTimeMillis);
            sb.append("MS) for url: ");
            sb.append(a.f15002i);
            C7513ec.m16639a(3, str, sb.toString());
            a.f15017x = 629;
            a.f14998B = true;
            a.mo23992f();
            a.mo23993g();
        }
    }

    public C7560mc(C7577pc pcVar) {
        this.f14947d = pcVar;
    }

    /* renamed from: a */
    public final synchronized void mo23979a(long j) {
        if (this.f14945b != null) {
            mo23978a();
        }
        this.f14945b = new Timer("HttpRequestTimeoutTimer");
        this.f14946c = new C7561a(this, 0);
        this.f14945b.schedule(this.f14946c, j);
        String str = f14944a;
        StringBuilder sb = new StringBuilder("HttpRequestTimeoutTimer started: ");
        sb.append(j);
        sb.append("MS");
        C7513ec.m16639a(3, str, sb.toString());
    }

    /* renamed from: a */
    public final synchronized void mo23978a() {
        if (this.f14945b != null) {
            this.f14945b.cancel();
            this.f14945b = null;
            C7513ec.m16639a(3, f14944a, "HttpRequestTimeoutTimer stopped.");
        }
        this.f14946c = null;
    }
}
