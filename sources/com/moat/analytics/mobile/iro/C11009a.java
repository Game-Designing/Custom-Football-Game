package com.moat.analytics.mobile.iro;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.iro.a */
final class C11009a {

    /* renamed from: ˊ */
    static WeakReference<Activity> f33631;

    /* renamed from: ˋ */
    private static boolean f33632 = false;
    /* access modifiers changed from: private */

    /* renamed from: ˎ */
    public static boolean f33633 = false;

    /* renamed from: ˏ */
    private static Application f33634;
    /* access modifiers changed from: private */

    /* renamed from: ॱ */
    public static int f33635 = 0;

    /* renamed from: com.moat.analytics.mobile.iro.a$c */
    static class C11010c implements ActivityLifecycleCallbacks {
        C11010c() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            C11009a.f33635 = 1;
        }

        public final void onActivityStarted(Activity activity) {
            try {
                C11009a.f33631 = new WeakReference<>(activity);
                C11009a.f33635 = 2;
                if (!C11009a.f33633) {
                    m36229(true);
                }
                C11009a.f33633 = true;
                StringBuilder sb = new StringBuilder("Activity started: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11011b.m36234(3, "ActivityState", this, sb.toString());
            } catch (Exception e) {
                C11043o.m36351(e);
            }
        }

        public final void onActivityResumed(Activity activity) {
            try {
                C11009a.f33631 = new WeakReference<>(activity);
                C11009a.f33635 = 3;
                C11054t.m36390().mo36125();
                StringBuilder sb = new StringBuilder("Activity resumed: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11011b.m36234(3, "ActivityState", this, sb.toString());
                if (((C11031j) MoatAnalytics.getInstance()).f33733) {
                    C11018e.m36263(activity);
                }
            } catch (Exception e) {
                C11043o.m36351(e);
            }
        }

        public final void onActivityPaused(Activity activity) {
            try {
                C11009a.f33635 = 4;
                if (C11009a.m36226(activity)) {
                    C11009a.f33631 = new WeakReference<>(null);
                }
                StringBuilder sb = new StringBuilder("Activity paused: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11011b.m36234(3, "ActivityState", this, sb.toString());
            } catch (Exception e) {
                C11043o.m36351(e);
            }
        }

        public final void onActivityStopped(Activity activity) {
            try {
                if (C11009a.f33635 != 3) {
                    C11009a.f33633 = false;
                    m36229(false);
                }
                C11009a.f33635 = 5;
                if (C11009a.m36226(activity)) {
                    C11009a.f33631 = new WeakReference<>(null);
                }
                StringBuilder sb = new StringBuilder("Activity stopped: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11011b.m36234(3, "ActivityState", this, sb.toString());
            } catch (Exception e) {
                C11043o.m36351(e);
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
            try {
                if (!(C11009a.f33635 == 3 || C11009a.f33635 == 5)) {
                    if (C11009a.f33633) {
                        m36229(false);
                    }
                    C11009a.f33633 = false;
                }
                C11009a.f33635 = 6;
                StringBuilder sb = new StringBuilder("Activity destroyed: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11011b.m36234(3, "ActivityState", this, sb.toString());
                if (C11009a.m36226(activity)) {
                    C11009a.f33631 = new WeakReference<>(null);
                }
            } catch (Exception e) {
                C11043o.m36351(e);
            }
        }

        /* renamed from: ˋ */
        private static void m36229(boolean z) {
            String str = "ActivityState";
            if (z) {
                C11011b.m36234(3, str, null, "App became visible");
                if (C11054t.m36390().f33794 == C11060c.f33811 && !((C11031j) MoatAnalytics.getInstance()).f33734) {
                    C11032k.m36332().mo36115();
                }
            } else {
                C11011b.m36234(3, str, null, "App became invisible");
                if (C11054t.m36390().f33794 == C11060c.f33811 && !((C11031j) MoatAnalytics.getInstance()).f33734) {
                    C11032k.m36332().mo36114();
                }
            }
        }
    }

    C11009a() {
    }

    /* renamed from: ˊ */
    static void m36223(Application application) {
        f33634 = application;
        if (!f33632) {
            f33632 = true;
            f33634.registerActivityLifecycleCallbacks(new C11010c());
        }
    }

    /* renamed from: ˎ */
    static Application m36225() {
        return f33634;
    }

    /* renamed from: ˎ */
    static /* synthetic */ boolean m36226(Activity activity) {
        WeakReference<Activity> weakReference = f33631;
        return weakReference != null && weakReference.get() == activity;
    }
}
