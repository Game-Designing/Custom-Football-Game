package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.ads.nt */
final class C9614nt implements zzun {

    /* renamed from: a */
    private final /* synthetic */ Activity f22822a;

    /* renamed from: b */
    private final /* synthetic */ Bundle f22823b;

    C9614nt(C9592mt mtVar, Activity activity, Bundle bundle) {
        this.f22822a = activity;
        this.f22823b = bundle;
    }

    /* renamed from: a */
    public final void mo29105a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f22822a, this.f22823b);
    }
}
