package com.flurry.sdk;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.flurry.sdk.C7395Ib.C7396a;
import java.lang.ref.WeakReference;

/* renamed from: com.flurry.sdk.Jb */
class C7401Jb implements ActivityLifecycleCallbacks {

    /* renamed from: a */
    final /* synthetic */ C7412Lb f14514a;

    C7401Jb(C7412Lb lb) {
        this.f14514a = lb;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        C7513ec.m16639a(3, C7412Lb.f14527a, "onActivityCreated for activity:".concat(String.valueOf(activity)));
        m16375a(activity, C7396a.f14501a);
        synchronized (this.f14514a) {
            if (C7412Lb.f14531e == null) {
                C7412Lb.f14531e = activity.getClass().getName();
            }
        }
    }

    public final void onActivityStarted(Activity activity) {
        C7513ec.m16639a(3, C7412Lb.f14527a, "onActivityStarted for activity:".concat(String.valueOf(activity)));
        if (m16376a(activity)) {
            m16375a(activity, C7396a.f14505e);
        }
    }

    public final void onActivityResumed(Activity activity) {
        C7513ec.m16639a(3, C7412Lb.f14527a, "onActivityResumed for activity:".concat(String.valueOf(activity)));
        if (!C7412Lb.f14530d) {
            C7412Lb.m16400a(true);
        }
        m16375a(activity, C7396a.f14504d);
    }

    public final void onActivityPaused(Activity activity) {
        C7513ec.m16639a(3, C7412Lb.f14527a, "onActivityPaused for activity:".concat(String.valueOf(activity)));
        m16375a(activity, C7396a.f14503c);
    }

    public final void onActivityStopped(Activity activity) {
        C7513ec.m16639a(3, C7412Lb.f14527a, "onActivityStopped for activity:".concat(String.valueOf(activity)));
        if (m16376a(activity)) {
            m16375a(activity, C7396a.f14506f);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        C7513ec.m16639a(3, C7412Lb.f14527a, "onActivitySaveInstanceState for activity:".concat(String.valueOf(activity)));
        m16375a(activity, C7396a.f14507g);
    }

    public final void onActivityDestroyed(Activity activity) {
        C7513ec.m16639a(3, C7412Lb.f14527a, "onActivityDestroyed for activity:".concat(String.valueOf(activity)));
        m16375a(activity, C7396a.f14502b);
    }

    /* renamed from: a */
    private static void m16375a(Activity activity, int i) {
        C7395Ib ib = new C7395Ib();
        ib.f14499b = new WeakReference<>(activity);
        ib.f14500c = i;
        ib.mo23885b();
    }

    /* renamed from: a */
    private static boolean m16376a(Activity activity) {
        return !C7412Lb.f14528b.contains(activity.getClass().getSimpleName());
    }
}
