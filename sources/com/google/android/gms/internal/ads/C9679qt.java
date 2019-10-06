package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

/* renamed from: com.google.android.gms.internal.ads.qt */
final class C9679qt implements zzun {

    /* renamed from: a */
    private final /* synthetic */ Activity f22922a;

    C9679qt(C9592mt mtVar, Activity activity) {
        this.f22922a = activity;
    }

    /* renamed from: a */
    public final void mo29105a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f22922a);
    }
}
