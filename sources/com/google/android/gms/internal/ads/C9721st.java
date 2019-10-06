package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.ads.st */
final class C9721st implements zzun {

    /* renamed from: a */
    private final /* synthetic */ Activity f23001a;

    /* renamed from: b */
    private final /* synthetic */ Bundle f23002b;

    C9721st(C9592mt mtVar, Activity activity, Bundle bundle) {
        this.f23001a = activity;
        this.f23002b = bundle;
    }

    /* renamed from: a */
    public final void mo29105a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f23001a, this.f23002b);
    }
}
