package com.crashlytics.android.p126c;

import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.c.o */
/* compiled from: CrashlyticsBackgroundWorker */
class C6508o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Runnable f11681a;

    /* renamed from: b */
    final /* synthetic */ C6512q f11682b;

    C6508o(C6512q this$0, Runnable runnable) {
        this.f11682b = this$0;
        this.f11681a = runnable;
    }

    public void run() {
        try {
            this.f11681a.run();
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("CrashlyticsCore", "Failed to execute task.", e);
        }
    }
}
