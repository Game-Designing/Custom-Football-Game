package com.crashlytics.android.p126c;

import java.util.concurrent.Callable;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.p348a.p353e.C13903q;

/* renamed from: com.crashlytics.android.c.t */
/* compiled from: CrashlyticsController */
class C6518t implements Callable<Boolean> {

    /* renamed from: a */
    final /* synthetic */ C13903q f11702a;

    /* renamed from: b */
    final /* synthetic */ C6452U f11703b;

    C6518t(C6452U this$0, C13903q qVar) {
        this.f11703b = this$0;
        this.f11702a = qVar;
    }

    public Boolean call() throws Exception {
        String str = "CrashlyticsCore";
        if (this.f11703b.mo19492g()) {
            C13920f.m44245e().mo43326c(str, "Skipping session finalization because a crash has already occurred.");
            return Boolean.FALSE;
        }
        C13920f.m44245e().mo43326c(str, "Finalizing previously open sessions.");
        this.f11703b.m12525a(this.f11702a, true);
        C13920f.m44245e().mo43326c(str, "Closed all previously open sessions");
        return Boolean.TRUE;
    }
}
