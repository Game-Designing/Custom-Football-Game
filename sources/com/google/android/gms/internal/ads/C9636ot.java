package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

/* renamed from: com.google.android.gms.internal.ads.ot */
final class C9636ot implements zzun {

    /* renamed from: a */
    private final /* synthetic */ Activity f22854a;

    C9636ot(C9592mt mtVar, Activity activity) {
        this.f22854a = activity;
    }

    /* renamed from: a */
    public final void mo29105a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.f22854a);
    }
}
