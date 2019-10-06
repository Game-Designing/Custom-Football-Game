package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.ads.xo */
final class C9821xo implements zzdu {

    /* renamed from: a */
    private final /* synthetic */ Activity f23477a;

    /* renamed from: b */
    private final /* synthetic */ Bundle f23478b;

    C9821xo(C9433fo foVar, Activity activity, Bundle bundle) {
        this.f23477a = activity;
        this.f23478b = bundle;
    }

    /* renamed from: a */
    public final void mo28570a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f23477a, this.f23478b);
    }
}
