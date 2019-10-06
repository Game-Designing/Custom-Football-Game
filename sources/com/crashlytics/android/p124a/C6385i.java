package com.crashlytics.android.p124a;

import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p351c.C13876e;

/* renamed from: com.crashlytics.android.a.i */
/* compiled from: AnswersEventsHandler */
class C6385i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6388l f11413a;

    C6385i(C6388l this$0) {
        this.f11413a = this$0;
    }

    public void run() {
        try {
            C6374N metadata = this.f11413a.f11421d.mo19375a();
            C6366H filesManager = this.f11413a.f11420c.mo19403a();
            filesManager.mo43275a((C13876e) this.f11413a);
            C6388l lVar = this.f11413a;
            C6399v vVar = new C6399v(this.f11413a.f11418a, this.f11413a.f11419b, this.f11413a.f11424g, filesManager, this.f11413a.f11422e, metadata, this.f11413a.f11423f);
            lVar.f11425h = vVar;
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("Answers", "Failed to enable events", e);
        }
    }
}
