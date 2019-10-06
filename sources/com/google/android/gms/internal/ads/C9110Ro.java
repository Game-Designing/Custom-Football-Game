package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

/* renamed from: com.google.android.gms.internal.ads.Ro */
final class C9110Ro implements zzdu {

    /* renamed from: a */
    private final /* synthetic */ Activity f21671a;

    C9110Ro(C9433fo foVar, Activity activity) {
        this.f21671a = activity;
    }

    /* renamed from: a */
    public final void mo28570a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.f21671a);
    }
}
