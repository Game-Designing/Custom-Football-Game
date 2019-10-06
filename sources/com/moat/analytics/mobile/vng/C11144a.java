package com.moat.analytics.mobile.vng;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* renamed from: com.moat.analytics.mobile.vng.a */
class C11144a {

    /* renamed from: a */
    static WeakReference<Activity> f34033a;

    /* renamed from: b */
    private static boolean f34034b = false;

    /* renamed from: c */
    private static Application f34035c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f34036d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static boolean f34037e = false;

    /* renamed from: com.moat.analytics.mobile.vng.a$a */
    private static class C11145a implements ActivityLifecycleCallbacks {
        C11145a() {
        }

        /* renamed from: a */
        private static void m36680a(boolean z) {
            String str = "ActivityState";
            if (z) {
                C11185p.m36817a(3, str, (Object) null, "App became visible");
                if (C11198w.m36845a().f34158a == C11206d.ON && !((C11174k) MoatAnalytics.getInstance()).f34121c) {
                    C11182o.m36794a().mo36374c();
                    return;
                }
                return;
            }
            C11185p.m36817a(3, str, (Object) null, "App became invisible");
            if (C11198w.m36845a().f34158a == C11206d.ON && !((C11174k) MoatAnalytics.getInstance()).f34121c) {
                C11182o.m36794a().mo36375d();
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            C11144a.f34036d = 1;
        }

        public void onActivityDestroyed(Activity activity) {
            try {
                if (!(C11144a.f34036d == 3 || C11144a.f34036d == 5)) {
                    if (C11144a.f34037e) {
                        m36680a(false);
                    }
                    C11144a.f34037e = false;
                }
                C11144a.f34036d = 6;
                StringBuilder sb = new StringBuilder();
                sb.append("Activity destroyed: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11185p.m36817a(3, "ActivityState", (Object) this, sb.toString());
                if (C11144a.m36678b(activity)) {
                    C11144a.f34033a = new WeakReference<>(null);
                }
            } catch (Exception e) {
                C11176m.m36783a(e);
            }
        }

        public void onActivityPaused(Activity activity) {
            try {
                C11144a.f34036d = 4;
                if (C11144a.m36678b(activity)) {
                    C11144a.f34033a = new WeakReference<>(null);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Activity paused: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11185p.m36817a(3, "ActivityState", (Object) this, sb.toString());
            } catch (Exception e) {
                C11176m.m36783a(e);
            }
        }

        public void onActivityResumed(Activity activity) {
            try {
                C11144a.f34033a = new WeakReference<>(activity);
                C11144a.f34036d = 3;
                C11198w.m36845a().mo36386b();
                StringBuilder sb = new StringBuilder();
                sb.append("Activity resumed: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11185p.m36817a(3, "ActivityState", (Object) this, sb.toString());
                if (((C11174k) MoatAnalytics.getInstance()).f34120b) {
                    C11158f.m36711a(activity);
                }
            } catch (Exception e) {
                C11176m.m36783a(e);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            try {
                C11144a.f34033a = new WeakReference<>(activity);
                C11144a.f34036d = 2;
                if (!C11144a.f34037e) {
                    m36680a(true);
                }
                C11144a.f34037e = true;
                StringBuilder sb = new StringBuilder();
                sb.append("Activity started: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11185p.m36817a(3, "ActivityState", (Object) this, sb.toString());
            } catch (Exception e) {
                C11176m.m36783a(e);
            }
        }

        public void onActivityStopped(Activity activity) {
            try {
                if (C11144a.f34036d != 3) {
                    C11144a.f34037e = false;
                    m36680a(false);
                }
                C11144a.f34036d = 5;
                if (C11144a.m36678b(activity)) {
                    C11144a.f34033a = new WeakReference<>(null);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Activity stopped: ");
                sb.append(activity.getClass());
                sb.append("@");
                sb.append(activity.hashCode());
                C11185p.m36817a(3, "ActivityState", (Object) this, sb.toString());
            } catch (Exception e) {
                C11176m.m36783a(e);
            }
        }
    }

    C11144a() {
    }

    /* renamed from: a */
    static Application m36673a() {
        return f34035c;
    }

    /* renamed from: a */
    static void m36674a(Application application) {
        f34035c = application;
        if (!f34034b) {
            f34034b = true;
            f34035c.registerActivityLifecycleCallbacks(new C11145a());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m36678b(Activity activity) {
        WeakReference<Activity> weakReference = f34033a;
        return weakReference != null && weakReference.get() == activity;
    }
}
