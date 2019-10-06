package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.ads.hq */
final class C9479hq implements zzdu {

    /* renamed from: a */
    private final /* synthetic */ Activity f22426a;

    /* renamed from: b */
    private final /* synthetic */ Bundle f22427b;

    C9479hq(C9433fo foVar, Activity activity, Bundle bundle) {
        this.f22426a = activity;
        this.f22427b = bundle;
    }

    /* renamed from: a */
    public final void mo28570a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f22426a, this.f22427b);
    }
}
