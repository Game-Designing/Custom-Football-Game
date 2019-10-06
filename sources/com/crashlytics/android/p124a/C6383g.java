package com.crashlytics.android.p124a;

import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.a.g */
/* compiled from: AnswersEventsHandler */
class C6383g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6388l f11411a;

    C6383g(C6388l this$0) {
        this.f11411a = this$0;
    }

    public void run() {
        try {
            C6369K prevStrategy = this.f11411a.f11425h;
            this.f11411a.f11425h = new C6398u();
            prevStrategy.mo19365d();
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("Answers", "Failed to disable events", e);
        }
    }
}
