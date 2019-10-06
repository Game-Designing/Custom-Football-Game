package com.crashlytics.android.p126c;

import java.util.Date;

/* renamed from: com.crashlytics.android.c.T */
/* compiled from: CrashlyticsController */
class C6450T implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Date f11559a;

    /* renamed from: b */
    final /* synthetic */ Thread f11560b;

    /* renamed from: c */
    final /* synthetic */ Throwable f11561c;

    /* renamed from: d */
    final /* synthetic */ C6452U f11562d;

    C6450T(C6452U this$0, Date date, Thread thread, Throwable th) {
        this.f11562d = this$0;
        this.f11559a = date;
        this.f11560b = thread;
        this.f11561c = th;
    }

    public void run() {
        if (!this.f11562d.mo19492g()) {
            this.f11562d.m12534a(this.f11559a, this.f11560b, this.f11561c);
        }
    }
}
