package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

/* renamed from: com.google.android.gms.internal.ads.sq */
final class C9718sq implements zzdu {

    /* renamed from: a */
    private final /* synthetic */ Activity f22969a;

    C9718sq(C9433fo foVar, Activity activity) {
        this.f22969a = activity;
    }

    /* renamed from: a */
    public final void mo28570a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f22969a);
    }
}
