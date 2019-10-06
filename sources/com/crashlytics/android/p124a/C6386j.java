package com.crashlytics.android.p124a;

import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.a.j */
/* compiled from: AnswersEventsHandler */
class C6386j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6388l f11414a;

    C6386j(C6388l this$0) {
        this.f11414a = this$0;
    }

    public void run() {
        try {
            this.f11414a.f11425h.mo19422a();
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("Answers", "Failed to flush events", e);
        }
    }
}
