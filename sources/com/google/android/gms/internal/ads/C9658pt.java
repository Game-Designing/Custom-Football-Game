package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

/* renamed from: com.google.android.gms.internal.ads.pt */
final class C9658pt implements zzun {

    /* renamed from: a */
    private final /* synthetic */ Activity f22884a;

    C9658pt(C9592mt mtVar, Activity activity) {
        this.f22884a = activity;
    }

    /* renamed from: a */
    public final void mo29105a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.f22884a);
    }
}
