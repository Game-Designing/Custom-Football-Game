package com.facebook.p127a.p130b;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.facebook.C6787r;

/* renamed from: com.facebook.a.b.r */
/* compiled from: InAppPurchaseActivityLifecycleTracker */
class C6614r implements ActivityLifecycleCallbacks {
    C6614r() {
    }

    public void onActivityResumed(Activity activity) {
        C6787r.m13822l().execute(new C6612p(this));
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
        if (C6615s.f12017d.booleanValue() && activity.getLocalClassName().equals("com.android.billingclient.api.ProxyBillingActivity")) {
            C6787r.m13822l().execute(new C6613q(this));
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    public void onActivityDestroyed(Activity activity) {
    }
}
