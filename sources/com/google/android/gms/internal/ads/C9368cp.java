package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

/* renamed from: com.google.android.gms.internal.ads.cp */
final class C9368cp implements zzdu {

    /* renamed from: a */
    private final /* synthetic */ Activity f22166a;

    C9368cp(C9433fo foVar, Activity activity) {
        this.f22166a = activity;
    }

    /* renamed from: a */
    public final void mo28570a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.f22166a);
    }
}
