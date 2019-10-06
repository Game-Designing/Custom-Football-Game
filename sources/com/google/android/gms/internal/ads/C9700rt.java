package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

/* renamed from: com.google.android.gms.internal.ads.rt */
final class C9700rt implements zzun {

    /* renamed from: a */
    private final /* synthetic */ Activity f22944a;

    C9700rt(C9592mt mtVar, Activity activity) {
        this.f22944a = activity;
    }

    /* renamed from: a */
    public final void mo29105a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.f22944a);
    }
}
