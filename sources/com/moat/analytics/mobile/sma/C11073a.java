package com.moat.analytics.mobile.sma;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.sma.a */
class C11073a {

    /* renamed from: a */
    static WeakReference<Activity> f33849a;

    /* renamed from: b */
    private static boolean f33850b = false;

    /* renamed from: c */
    private static Application f33851c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f33852d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static boolean f33853e = false;

    /* renamed from: com.moat.analytics.mobile.sma.a$a */
    private static class C11074a implements ActivityLifecycleCallbacks {
        C11074a() {
        }

        /* renamed from: a */
        private static void m36439a(boolean z) {
            String str = "ActivityState";
            if (z) {
                C11111p.m36577a(3, str, (Object) null, "App became visible");
                if (C11124w.m36605a().f33971a == C11132d.ON && !((C11100k) MoatAnalytics.getInstance()).f33934c) {
                    C11108o.m36554a().mo36242c();
                    return;
                }
                return;
            }
            C11111p.m36577a(3, str, (Object) null, "App became invisible");
            if (C11124w.m36605a().f33971a == C11132d.ON && !((C11100k) MoatAnalytics.getInstance()).f33934c) {
                C11108o.m36554a().mo36243d();
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            C11073a.f33852d = 1;
        }

        public void onActivityDestroyed(Activity activity) {
            try {
                if (!(C11073a.f33852d == 3 || C11073a.f33852d == 5)) {
                    if (C11073a.f33853e) {
                        m36439a(false);
                    }
                    C11073a.f33853e = false;
                }
                C11073a.f33852d = 6;
                StringBuilder sb = new StringBuilder();
                sb.append("Activity destroyed: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11111p.m36577a(3, "ActivityState", (Object) this, sb.toString());
                if (C11073a.m36437b(activity)) {
                    C11073a.f33849a = new WeakReference<>(null);
                }
            } catch (Exception e) {
                C11102m.m36543a(e);
            }
        }

        public void onActivityPaused(Activity activity) {
            try {
                C11073a.f33852d = 4;
                if (C11073a.m36437b(activity)) {
                    C11073a.f33849a = new WeakReference<>(null);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Activity paused: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11111p.m36577a(3, "ActivityState", (Object) this, sb.toString());
            } catch (Exception e) {
                C11102m.m36543a(e);
            }
        }

        public void onActivityResumed(Activity activity) {
            try {
                C11073a.f33849a = new WeakReference<>(activity);
                C11073a.f33852d = 3;
                C11124w.m36605a().mo36254b();
                StringBuilder sb = new StringBuilder();
                sb.append("Activity resumed: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11111p.m36577a(3, "ActivityState", (Object) this, sb.toString());
                if (((C11100k) MoatAnalytics.getInstance()).f33933b) {
                    C11084f.m36470a(activity);
                }
            } catch (Exception e) {
                C11102m.m36543a(e);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            try {
                C11073a.f33849a = new WeakReference<>(activity);
                C11073a.f33852d = 2;
                if (!C11073a.f33853e) {
                    m36439a(true);
                }
                C11073a.f33853e = true;
                StringBuilder sb = new StringBuilder();
                sb.append("Activity started: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11111p.m36577a(3, "ActivityState", (Object) this, sb.toString());
            } catch (Exception e) {
                C11102m.m36543a(e);
            }
        }

        public void onActivityStopped(Activity activity) {
            try {
                if (C11073a.f33852d != 3) {
                    C11073a.f33853e = false;
                    m36439a(false);
                }
                C11073a.f33852d = 5;
                if (C11073a.m36437b(activity)) {
                    C11073a.f33849a = new WeakReference<>(null);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Activity stopped: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11111p.m36577a(3, "ActivityState", (Object) this, sb.toString());
            } catch (Exception e) {
                C11102m.m36543a(e);
            }
        }
    }

    C11073a() {
    }

    /* renamed from: a */
    static Application m36432a() {
        return f33851c;
    }

    /* renamed from: a */
    static void m36433a(Application application) {
        f33851c = application;
        if (!f33850b) {
            f33850b = true;
            f33851c.registerActivityLifecycleCallbacks(new C11074a());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m36437b(Activity activity) {
        WeakReference<Activity> weakReference = f33849a;
        return weakReference != null && weakReference.get() == activity;
    }
}
