package com.facebook.p127a.p130b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;
import com.facebook.C6787r;
import com.facebook.internal.C6670D;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6738z;
import com.facebook.p127a.p128a.C6579e;
import com.facebook.p127a.p128a.C6589l;
import com.facebook.p127a.p128a.C6591m;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.a.b.h */
/* compiled from: ActivityLifecycleTracker */
public class C6602h {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11985a = C6602h.class.getCanonicalName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final ScheduledExecutorService f11986b = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static volatile ScheduledFuture f11987c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Object f11988d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static AtomicInteger f11989e = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static volatile C6617u f11990f;

    /* renamed from: g */
    private static AtomicBoolean f11991g = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static String f11992h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static long f11993i;

    /* renamed from: j */
    private static final C6579e f11994j = new C6579e();

    /* renamed from: k */
    private static final C6591m f11995k = new C6591m();

    /* renamed from: l */
    private static SensorManager f11996l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static C6589l f11997m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public static String f11998n = null;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public static Boolean f11999o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public static volatile Boolean f12000p;

    /* renamed from: q */
    private static int f12001q = 0;

    /* renamed from: c */
    static /* synthetic */ int m13088c() {
        int i = f12001q;
        f12001q = i + 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m13091d() {
        int i = f12001q;
        f12001q = i - 1;
        return i;
    }

    static {
        Boolean valueOf = Boolean.valueOf(false);
        f11999o = valueOf;
        f12000p = valueOf;
    }

    /* renamed from: a */
    public static void m13083a(Application application, String appId) {
        if (f11991g.compareAndSet(false, true)) {
            f11992h = appId;
            application.registerActivityLifecycleCallbacks(new C6595a());
        }
    }

    /* renamed from: p */
    public static boolean m13104p() {
        return f12001q == 0;
    }

    /* renamed from: n */
    public static UUID m13102n() {
        if (f11990f != null) {
            return f11990f.mo19808d();
        }
        return null;
    }

    /* renamed from: b */
    public static void m13086b(Activity activity) {
        f11986b.execute(new C6596b());
    }

    /* renamed from: c */
    public static void m13089c(Activity activity) {
        f11989e.incrementAndGet();
        m13105q();
        long currentTime = System.currentTimeMillis();
        f11993i = currentTime;
        String activityName = C6694S.m13431b((Context) activity);
        f11994j.mo19757a(activity);
        f11986b.execute(new C6597c(currentTime, activityName));
        Context applicationContext = activity.getApplicationContext();
        String appId = C6787r.m13816f();
        C6738z appSettings = C6670D.m13306b(appId);
        if (appSettings != null && appSettings.mo19974b()) {
            f11996l = (SensorManager) applicationContext.getSystemService("sensor");
            SensorManager sensorManager = f11996l;
            if (sensorManager != null) {
                Sensor accelerometer = sensorManager.getDefaultSensor(1);
                f11997m = new C6589l(activity);
                f11995k.mo19774a(new C6598d(appSettings, appId));
                f11996l.registerListener(f11995k, accelerometer, 2);
                if (appSettings != null && appSettings.mo19974b()) {
                    f11997m.mo19771b();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m13092d(Activity activity) {
        if (f11989e.decrementAndGet() < 0) {
            f11989e.set(0);
            Log.w(f11985a, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
        }
        m13105q();
        long currentTime = System.currentTimeMillis();
        String activityName = C6694S.m13431b((Context) activity);
        f11994j.mo19758b(activity);
        f11986b.execute(new C6600f(currentTime, activityName));
        C6589l lVar = f11997m;
        if (lVar != null) {
            lVar.mo19772c();
        }
        SensorManager sensorManager = f11996l;
        if (sensorManager != null) {
            sensorManager.unregisterListener(f11995k);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public static int m13106r() {
        C6738z settings = C6670D.m13306b(C6787r.m13816f());
        if (settings == null) {
            return C6610n.m13121a();
        }
        return settings.mo19980h();
    }

    /* renamed from: q */
    private static void m13105q() {
        synchronized (f11988d) {
            if (f11987c != null) {
                f11987c.cancel(false);
            }
            f11987c = null;
        }
    }

    /* renamed from: b */
    public static void m13087b(String applicationId) {
        if (!f12000p.booleanValue()) {
            f12000p = Boolean.valueOf(true);
            C6787r.m13822l().execute(new C6601g(applicationId));
        }
    }

    /* renamed from: m */
    public static String m13101m() {
        if (f11998n == null) {
            f11998n = UUID.randomUUID().toString();
        }
        return f11998n;
    }

    /* renamed from: o */
    public static boolean m13103o() {
        return f11999o.booleanValue();
    }

    /* renamed from: c */
    public static void m13090c(Boolean appIndexingEnalbed) {
        f11999o = appIndexingEnalbed;
    }
}
