package com.facebook.p127a.p130b;

import java.util.concurrent.TimeUnit;

/* renamed from: com.facebook.a.b.f */
/* compiled from: ActivityLifecycleTracker */
class C6600f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f11982a;

    /* renamed from: b */
    final /* synthetic */ String f11983b;

    C6600f(long j, String str) {
        this.f11982a = j;
        this.f11983b = str;
    }

    public void run() {
        if (C6602h.f11990f == null) {
            C6602h.f11990f = new C6617u(Long.valueOf(this.f11982a), null);
        }
        C6602h.f11990f.mo19805a(Long.valueOf(this.f11982a));
        if (C6602h.f11989e.get() <= 0) {
            Runnable task = new C6599e(this);
            synchronized (C6602h.f11988d) {
                C6602h.f11987c = C6602h.f11986b.schedule(task, (long) C6602h.m13106r(), TimeUnit.SECONDS);
            }
        }
        long appearTime = C6602h.f11993i;
        long timeSpentOnActivityInSeconds = 0;
        if (appearTime > 0) {
            timeSpentOnActivityInSeconds = (this.f11982a - appearTime) / 1000;
        }
        C6608m.m13116a(this.f11983b, timeSpentOnActivityInSeconds);
        C6602h.f11990f.mo19813j();
    }
}
