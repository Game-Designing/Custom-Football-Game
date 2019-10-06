package com.crashlytics.android.p126c;

import java.util.concurrent.Callable;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.c.p */
/* compiled from: CrashlyticsBackgroundWorker */
class C6510p implements Callable<T> {

    /* renamed from: a */
    final /* synthetic */ Callable f11691a;

    /* renamed from: b */
    final /* synthetic */ C6512q f11692b;

    C6510p(C6512q this$0, Callable callable) {
        this.f11692b = this$0;
        this.f11691a = callable;
    }

    public T call() throws Exception {
        try {
            return this.f11691a.call();
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("CrashlyticsCore", "Failed to execute task.", e);
            return null;
        }
    }
}
