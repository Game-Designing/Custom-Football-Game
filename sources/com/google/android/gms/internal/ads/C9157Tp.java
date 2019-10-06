package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

/* renamed from: com.google.android.gms.internal.ads.Tp */
final class C9157Tp implements zzdu {

    /* renamed from: a */
    private final /* synthetic */ Activity f21783a;

    C9157Tp(C9433fo foVar, Activity activity) {
        this.f21783a = activity;
    }

    /* renamed from: a */
    public final void mo28570a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.f21783a);
    }
}
