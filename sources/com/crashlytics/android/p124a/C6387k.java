package com.crashlytics.android.p124a;

import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.a.k */
/* compiled from: AnswersEventsHandler */
class C6387k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6372a f11415a;

    /* renamed from: b */
    final /* synthetic */ boolean f11416b;

    /* renamed from: c */
    final /* synthetic */ C6388l f11417c;

    C6387k(C6388l this$0, C6372a aVar, boolean z) {
        this.f11417c = this$0;
        this.f11415a = aVar;
        this.f11416b = z;
    }

    public void run() {
        try {
            this.f11417c.f11425h.mo19362a(this.f11415a);
            if (this.f11416b) {
                this.f11417c.f11425h.mo19422a();
            }
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("Answers", "Failed to process event", e);
        }
    }
}
