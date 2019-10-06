package com.crashlytics.android.p126c;

import java.util.concurrent.Callable;

/* renamed from: com.crashlytics.android.c.S */
/* compiled from: CrashlyticsController */
class C6448S implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ long f11556a;

    /* renamed from: b */
    final /* synthetic */ String f11557b;

    /* renamed from: c */
    final /* synthetic */ C6452U f11558c;

    C6448S(C6452U this$0, long j, String str) {
        this.f11558c = this$0;
        this.f11556a = j;
        this.f11557b = str;
    }

    public Void call() throws Exception {
        if (!this.f11558c.mo19492g()) {
            this.f11558c.f11581r.mo19607a(this.f11556a, this.f11557b);
        }
        return null;
    }
}
