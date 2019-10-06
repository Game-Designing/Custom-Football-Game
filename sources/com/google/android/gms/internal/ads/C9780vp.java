package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

/* renamed from: com.google.android.gms.internal.ads.vp */
final class C9780vp implements zzdu {

    /* renamed from: a */
    private final /* synthetic */ Activity f23340a;

    C9780vp(C9433fo foVar, Activity activity) {
        this.f23340a = activity;
    }

    /* renamed from: a */
    public final void mo28570a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f23340a);
    }
}
