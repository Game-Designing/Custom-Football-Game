package com.moat.analytics.mobile.inm;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.inm.a */
class C10929a {

    /* renamed from: a */
    static WeakReference<Activity> f33413a;

    /* renamed from: b */
    private static boolean f33414b = false;

    /* renamed from: c */
    private static Application f33415c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f33416d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static boolean f33417e = false;

    /* renamed from: com.moat.analytics.mobile.inm.a$a */
    private static class C10930a implements ActivityLifecycleCallbacks {
        C10930a() {
        }

        /* renamed from: a */
        private static void m35951a(boolean z) {
            String str = "ActivityState";
            if (z) {
                C10969p.m36113a(3, str, (Object) null, "App became visible");
                if (C10984w.m36151a().f33561a == C10992d.ON && !((C10958k) MoatAnalytics.getInstance()).f33508c) {
                    C10966o.m36089a().mo35962c();
                }
            } else {
                C10969p.m36113a(3, str, (Object) null, "App became invisible");
                if (C10984w.m36151a().f33561a == C10992d.ON && !((C10958k) MoatAnalytics.getInstance()).f33508c) {
                    C10966o.m36089a().mo35963d();
                }
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            C10929a.f33416d = 1;
        }

        public void onActivityDestroyed(Activity activity) {
            try {
                if (!(C10929a.f33416d == 3 || C10929a.f33416d == 5)) {
                    if (C10929a.f33417e) {
                        m35951a(false);
                    }
                    C10929a.f33417e = false;
                }
                C10929a.f33416d = 6;
                StringBuilder sb = new StringBuilder("Activity destroyed: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C10969p.m36113a(3, "ActivityState", (Object) this, sb.toString());
                if (C10929a.m35949b(activity)) {
                    C10929a.f33413a = new WeakReference<>(null);
                }
            } catch (Exception e) {
                C10960m.m36077a(e);
            }
        }

        public void onActivityPaused(Activity activity) {
            try {
                C10929a.f33416d = 4;
                if (C10929a.m35949b(activity)) {
                    C10929a.f33413a = new WeakReference<>(null);
                }
                StringBuilder sb = new StringBuilder("Activity paused: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C10969p.m36113a(3, "ActivityState", (Object) this, sb.toString());
            } catch (Exception e) {
                C10960m.m36077a(e);
            }
        }

        public void onActivityResumed(Activity activity) {
            try {
                C10929a.f33413a = new WeakReference<>(activity);
                C10929a.f33416d = 3;
                C10984w.m36151a().mo35976b();
                StringBuilder sb = new StringBuilder("Activity resumed: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C10969p.m36113a(3, "ActivityState", (Object) this, sb.toString());
                if (((C10958k) MoatAnalytics.getInstance()).f33507b) {
                    C10940f.m35993a(activity);
                }
            } catch (Exception e) {
                C10960m.m36077a(e);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            try {
                C10929a.f33413a = new WeakReference<>(activity);
                C10929a.f33416d = 2;
                if (!C10929a.f33417e) {
                    m35951a(true);
                }
                C10929a.f33417e = true;
                StringBuilder sb = new StringBuilder("Activity started: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C10969p.m36113a(3, "ActivityState", (Object) this, sb.toString());
            } catch (Exception e) {
                C10960m.m36077a(e);
            }
        }

        public void onActivityStopped(Activity activity) {
            try {
                if (C10929a.f33416d != 3) {
                    C10929a.f33417e = false;
                    m35951a(false);
                }
                C10929a.f33416d = 5;
                if (C10929a.m35949b(activity)) {
                    C10929a.f33413a = new WeakReference<>(null);
                }
                StringBuilder sb = new StringBuilder("Activity stopped: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C10969p.m36113a(3, "ActivityState", (Object) this, sb.toString());
            } catch (Exception e) {
                C10960m.m36077a(e);
            }
        }
    }

    C10929a() {
    }

    /* renamed from: a */
    static Application m35944a() {
        return f33415c;
    }

    /* renamed from: a */
    static void m35945a(Application application) {
        f33415c = application;
        if (!f33414b) {
            f33414b = true;
            f33415c.registerActivityLifecycleCallbacks(new C10930a());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m35949b(Activity activity) {
        WeakReference<Activity> weakReference = f33413a;
        return weakReference != null && weakReference.get() == activity;
    }
}
