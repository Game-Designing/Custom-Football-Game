package com.crashlytics.android.p124a;

import android.content.Context;
import android.os.Looper;
import java.io.IOException;
import p024io.fabric.sdk.android.p348a.p350b.C13837E;
import p024io.fabric.sdk.android.p348a.p351c.C13879h;
import p024io.fabric.sdk.android.p348a.p352d.C13882a;

/* renamed from: com.crashlytics.android.a.m */
/* compiled from: AnswersFilesManagerProvider */
class C6389m {

    /* renamed from: a */
    final Context f11426a;

    /* renamed from: b */
    final C13882a f11427b;

    public C6389m(Context context, C13882a fileStore) {
        this.f11426a = context;
        this.f11427b = fileStore;
    }

    /* renamed from: a */
    public C6366H mo19403a() throws IOException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return new C6366H(this.f11426a, new C6375O(), new C13837E(), new C13879h(this.f11426a, this.f11427b.mo43292a(), "session_analytics.tap", "session_analytics_to_send"));
        }
        throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
    }
}
