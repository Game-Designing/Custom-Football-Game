package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

/* renamed from: com.google.android.gms.internal.ads.tt */
final class C9742tt implements zzun {

    /* renamed from: a */
    private final /* synthetic */ Activity f23047a;

    C9742tt(C9592mt mtVar, Activity activity) {
        this.f23047a = activity;
    }

    /* renamed from: a */
    public final void mo29105a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f23047a);
    }
}
