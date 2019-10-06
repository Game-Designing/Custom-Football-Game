package com.crashlytics.android.p126c;

import java.util.concurrent.Callable;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;

/* renamed from: com.crashlytics.android.c.Z */
/* compiled from: CrashlyticsCore */
class C6470Z implements Callable<Boolean> {

    /* renamed from: a */
    final /* synthetic */ C6472aa f11610a;

    C6470Z(C6472aa this$0) {
        this.f11610a = this$0;
    }

    public Boolean call() throws Exception {
        String str = "CrashlyticsCore";
        try {
            boolean removed = this.f11610a.f11619i.mo19530c();
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("Initialization marker file removed: ");
            sb.append(removed);
            e.mo43326c(str, sb.toString());
            return Boolean.valueOf(removed);
        } catch (Exception e2) {
            C13920f.m44245e().mo43325b(str, "Problem encountered deleting Crashlytics initialization marker.", e2);
            return Boolean.valueOf(false);
        }
    }
}
