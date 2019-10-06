package com.crashlytics.android.p124a;

import android.app.Activity;
import android.os.Bundle;
import p024io.fabric.sdk.android.C13914b.C13916b;

/* renamed from: com.crashlytics.android.a.n */
/* compiled from: AnswersLifecycleCallbacks */
class C6390n extends C13916b {

    /* renamed from: a */
    private final C6368J f11428a;

    /* renamed from: b */
    private final C6395s f11429b;

    public C6390n(C6368J analyticsManager, C6395s backgroundManager) {
        this.f11428a = analyticsManager;
        this.f11429b = backgroundManager;
    }

    /* renamed from: a */
    public void mo19405a(Activity activity, Bundle bundle) {
    }

    /* renamed from: d */
    public void mo19409d(Activity activity) {
        this.f11428a.mo19354a(activity, C6373b.START);
    }

    /* renamed from: c */
    public void mo19408c(Activity activity) {
        this.f11428a.mo19354a(activity, C6373b.RESUME);
        this.f11429b.mo19419b();
    }

    /* renamed from: b */
    public void mo19406b(Activity activity) {
        this.f11428a.mo19354a(activity, C6373b.PAUSE);
        this.f11429b.mo19416a();
    }

    /* renamed from: e */
    public void mo19410e(Activity activity) {
        this.f11428a.mo19354a(activity, C6373b.STOP);
    }

    /* renamed from: b */
    public void mo19407b(Activity activity, Bundle bundle) {
    }

    /* renamed from: a */
    public void mo19404a(Activity activity) {
    }
}
