package com.facebook.p127a.p130b;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.facebook.C6537C;
import com.facebook.internal.C6676H;
import com.facebook.p127a.C6638q;

/* renamed from: com.facebook.a.b.a */
/* compiled from: ActivityLifecycleTracker */
class C6595a implements ActivityLifecycleCallbacks {
    C6595a() {
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        C6676H.m13322a(C6537C.APP_EVENTS, C6602h.f11985a, "onActivityCreated");
        C6603i.m13109a();
        C6602h.m13086b(activity);
    }

    public void onActivityStarted(Activity activity) {
        C6602h.m13088c();
        C6676H.m13322a(C6537C.APP_EVENTS, C6602h.f11985a, "onActivityStarted");
    }

    public void onActivityResumed(Activity activity) {
        C6676H.m13322a(C6537C.APP_EVENTS, C6602h.f11985a, "onActivityResumed");
        C6603i.m13109a();
        C6602h.m13089c(activity);
    }

    public void onActivityPaused(Activity activity) {
        C6676H.m13322a(C6537C.APP_EVENTS, C6602h.f11985a, "onActivityPaused");
        C6603i.m13109a();
        C6602h.m13092d(activity);
    }

    public void onActivityStopped(Activity activity) {
        C6676H.m13322a(C6537C.APP_EVENTS, C6602h.f11985a, "onActivityStopped");
        C6638q.m13225e();
        C6602h.m13091d();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        C6676H.m13322a(C6537C.APP_EVENTS, C6602h.f11985a, "onActivitySaveInstanceState");
    }

    public void onActivityDestroyed(Activity activity) {
        C6676H.m13322a(C6537C.APP_EVENTS, C6602h.f11985a, "onActivityDestroyed");
    }
}
