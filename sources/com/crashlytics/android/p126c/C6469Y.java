package com.crashlytics.android.p126c;

import java.util.concurrent.Callable;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.c.Y */
/* compiled from: CrashlyticsCore */
class C6469Y implements Callable<Void> {

    /* renamed from: a */
    final /* synthetic */ C6472aa f11609a;

    C6469Y(C6472aa this$0) {
        this.f11609a = this$0;
    }

    public Void call() throws Exception {
        this.f11609a.f11619i.mo19528a();
        C13920f.m44245e().mo43326c("CrashlyticsCore", "Initialization marker file created.");
        return null;
    }
}
