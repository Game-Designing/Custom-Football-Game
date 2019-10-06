package com.crashlytics.android.p124a;

import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.a.h */
/* compiled from: AnswersEventsHandler */
class C6384h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6388l f11412a;

    C6384h(C6388l this$0) {
        this.f11412a = this$0;
    }

    public void run() {
        try {
            this.f11412a.f11425h.mo19364c();
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("Answers", "Failed to send events files", e);
        }
    }
}
