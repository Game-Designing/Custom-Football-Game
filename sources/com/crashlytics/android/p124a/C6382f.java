package com.crashlytics.android.p124a;

import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p353e.C13888b;

/* renamed from: com.crashlytics.android.a.f */
/* compiled from: AnswersEventsHandler */
class C6382f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C13888b f11408a;

    /* renamed from: b */
    final /* synthetic */ String f11409b;

    /* renamed from: c */
    final /* synthetic */ C6388l f11410c;

    C6382f(C6388l this$0, C13888b bVar, String str) {
        this.f11410c = this$0;
        this.f11408a = bVar;
        this.f11409b = str;
    }

    public void run() {
        try {
            this.f11410c.f11425h.mo19363a(this.f11408a, this.f11409b);
        } catch (Exception e) {
            C13920f.m44245e().mo43325b("Answers", "Failed to set analytics settings data", e);
        }
    }
}
