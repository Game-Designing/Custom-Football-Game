package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.ads.fo */
final class C9433fo implements ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final Application f22302a;

    /* renamed from: b */
    private final WeakReference<ActivityLifecycleCallbacks> f22303b;

    /* renamed from: c */
    private boolean f22304c = false;

    public C9433fo(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f22303b = new WeakReference<>(activityLifecycleCallbacks);
        this.f22302a = application;
    }

    /* renamed from: a */
    private final void m23578a(zzdu zzdu) {
        try {
            ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityLifecycleCallbacks) this.f22303b.get();
            if (activityLifecycleCallbacks != null) {
                zzdu.mo28570a(activityLifecycleCallbacks);
                return;
            }
            if (!this.f22304c) {
                this.f22302a.unregisterActivityLifecycleCallbacks(this);
                this.f22304c = true;
            }
        } catch (Exception e) {
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m23578a(new C9821xo(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        m23578a(new C9110Ro(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        m23578a(new C9368cp(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        m23578a(new C9780vp(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        m23578a(new C9157Tp(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m23578a(new C9479hq(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        m23578a(new C9718sq(this, activity));
    }
}
