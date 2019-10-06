package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.mt */
final class C9592mt implements ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final Application f22789a;

    /* renamed from: b */
    private final WeakReference<ActivityLifecycleCallbacks> f22790b;

    /* renamed from: c */
    private boolean f22791c = false;

    public C9592mt(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f22790b = new WeakReference<>(activityLifecycleCallbacks);
        this.f22789a = application;
    }

    /* renamed from: a */
    private final void m23939a(zzun zzun) {
        try {
            ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityLifecycleCallbacks) this.f22790b.get();
            if (activityLifecycleCallbacks != null) {
                zzun.mo29105a(activityLifecycleCallbacks);
                return;
            }
            if (!this.f22791c) {
                this.f22789a.unregisterActivityLifecycleCallbacks(this);
                this.f22791c = true;
            }
        } catch (Exception e) {
            zzbad.m26356b("Error while dispatching lifecycle callback.", e);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m23939a(new C9614nt(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        m23939a(new C9636ot(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        m23939a(new C9658pt(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        m23939a(new C9679qt(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        m23939a(new C9700rt(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m23939a(new C9721st(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        m23939a(new C9742tt(this, activity));
    }
}
