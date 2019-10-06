package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzcy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class zzea {

    /* renamed from: a */
    private static volatile zzea f30223a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f30224b;

    /* renamed from: c */
    protected final Clock f30225c;

    /* renamed from: d */
    private final ExecutorService f30226d;

    /* renamed from: e */
    private final AppMeasurementSdk f30227e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Map<zzcy, Object> f30228f;

    /* renamed from: g */
    private int f30229g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f30230h;

    /* renamed from: i */
    private String f30231i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public zzdn f30232j;

    /* renamed from: com.google.android.gms.internal.measurement.zzea$a */
    class C10017a extends zzdr {

        /* renamed from: b */
        private final AtomicReference<Bundle> f30233b = new AtomicReference<>();

        /* renamed from: c */
        private boolean f30234c;

        C10017a() {
        }

        public final void zzb(Bundle bundle) {
            synchronized (this.f30233b) {
                try {
                    this.f30233b.set(bundle);
                    this.f30234c = true;
                    this.f30233b.notify();
                } catch (Throwable th) {
                    this.f30233b.notify();
                    throw th;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public final String mo32822d(long j) {
            return (String) mo32821a(mo32823e(j), String.class);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public final Bundle mo32823e(long j) {
            Bundle bundle;
            synchronized (this.f30233b) {
                if (!this.f30234c) {
                    try {
                        this.f30233b.wait(j);
                    } catch (InterruptedException e) {
                        return null;
                    }
                }
                bundle = (Bundle) this.f30233b.get();
            }
            return bundle;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final <T> T mo32821a(Bundle bundle, Class<T> cls) {
            if (bundle == null) {
                return null;
            }
            Object obj = bundle.get("r");
            if (obj == null) {
                return null;
            }
            try {
                return cls.cast(obj);
            } catch (ClassCastException e) {
                String str = "Unexpected object type. Expected, Received";
                String canonicalName = cls.getCanonicalName();
                String canonicalName2 = obj.getClass().getCanonicalName();
                zzea.this.mo32806a(5, str, (Object) canonicalName, (Object) canonicalName2, (Object) e);
                Log.w(zzea.this.f30224b, String.format(String.valueOf(str).concat(": %s, %s"), new Object[]{canonicalName, canonicalName2}), e);
                throw e;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.zzea$b */
    abstract class C10018b implements Runnable {

        /* renamed from: a */
        final long f30236a;

        /* renamed from: b */
        final long f30237b;

        /* renamed from: c */
        private final boolean f30238c;

        C10018b(zzea zzea) {
            this(true);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public abstract void mo32712a() throws RemoteException;

        C10018b(boolean z) {
            this.f30236a = zzea.this.f30225c.mo27935b();
            this.f30237b = zzea.this.f30225c.mo27934a();
            this.f30238c = z;
        }

        public void run() {
            if (zzea.this.f30230h) {
                mo32716b();
                return;
            }
            try {
                mo32712a();
            } catch (Exception e) {
                zzea.this.m32333a(e, false, this.f30238c);
                mo32716b();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo32716b() {
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.zzea$c */
    class C10019c implements ActivityLifecycleCallbacks {
        C10019c() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzea.this.m32330a((C10018b) new C10003t(this, activity, bundle));
        }

        public final void onActivityStarted(Activity activity) {
            zzea.this.m32330a((C10018b) new C10005u(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            zzea.this.m32330a((C10018b) new C10007v(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            zzea.this.m32330a((C10018b) new C10009w(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            zzea.this.m32330a((C10018b) new C10011x(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            C10017a aVar = new C10017a();
            zzea.this.m32330a((C10018b) new C10013y(this, activity, aVar));
            Bundle e = aVar.mo32823e(50);
            if (e != null) {
                bundle.putAll(e);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            zzea.this.m32330a((C10018b) new C10015z(this, activity));
        }
    }

    /* renamed from: a */
    public static zzea m32328a(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.m21857a(context);
        if (f30223a == null) {
            synchronized (zzea.class) {
                if (f30223a == null) {
                    zzea zzea = new zzea(context, str, str2, str3, bundle);
                    f30223a = zzea;
                }
            }
        }
        return f30223a;
    }

    /* renamed from: f */
    public final AppMeasurementSdk mo32819f() {
        return this.f30227e;
    }

    private zzea(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !m32339b(str2, str3)) {
            this.f30224b = "FA";
        } else {
            this.f30224b = str;
        }
        this.f30225c = DefaultClock.m22087d();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f30226d = threadPoolExecutor;
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f30224b, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new C10019c());
        }
        this.f30227e = new AppMeasurementSdk(this);
        boolean z = false;
        if (!(!m32342d(context) || m32345h())) {
            this.f30231i = null;
            this.f30230h = true;
            Log.w(this.f30224b, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!m32339b(str2, str3)) {
            this.f30231i = "fa";
            if (str2 == null || str3 == null) {
                boolean z2 = str2 == null;
                if (str3 == null) {
                    z = true;
                }
                if (z2 ^ z) {
                    Log.w(this.f30224b, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.f30224b, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
                this.f30230h = true;
                return;
            }
        } else {
            this.f30231i = str2;
        }
        C9954b bVar = new C9954b(this, context, str2, str3, bundle);
        m32330a((C10018b) bVar);
    }

    /* renamed from: d */
    private static boolean m32342d(Context context) {
        try {
            GoogleServices.m21307a(context);
            if (GoogleServices.m21309a() != null) {
                return true;
            }
            return false;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m32339b(String str, String str2) {
        return (str2 == null || str == null || m32345h()) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32330a(C10018b bVar) {
        this.f30226d.execute(bVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final zzdn mo32803a(Context context) {
        try {
            return zzdo.m32296a(DynamiteModule.m22215a(context, DynamiteModule.f20355l, "com.google.android.gms.measurement.dynamite").mo27984a("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (LoadingException e) {
            m32333a((Exception) e, true, false);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static int m32343e(Context context) {
        return DynamiteModule.m22219b(context, "com.google.android.gms.measurement.dynamite");
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static int m32344f(Context context) {
        return DynamiteModule.m22213a(context, "com.google.android.gms.measurement.dynamite");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32333a(Exception exc, boolean z, boolean z2) {
        this.f30230h |= z;
        if (z) {
            Log.w(this.f30224b, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        String str = "Error with data collection. Data lost.";
        if (z2) {
            mo32806a(5, str, (Object) exc, (Object) null, (Object) null);
        }
        Log.w(this.f30224b, str, exc);
    }

    /* renamed from: h */
    private static boolean m32345h() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* renamed from: b */
    public final void mo32814b(String str, String str2, Bundle bundle) {
        m32334a(str, str2, bundle, true, true, null);
    }

    /* renamed from: a */
    private final void m32334a(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        C9997q qVar = new C9997q(this, l, str, str2, bundle, true, z2);
        m32330a((C10018b) qVar);
    }

    /* renamed from: a */
    public final void mo32811a(String str, String str2, Object obj, boolean z) {
        C9999r rVar = new C9999r(this, str, str2, obj, true);
        m32330a((C10018b) rVar);
    }

    /* renamed from: a */
    public final void mo32808a(Bundle bundle) {
        m32330a((C10018b) new C10001s(this, bundle));
    }

    /* renamed from: a */
    public final void mo32810a(String str, String str2, Bundle bundle) {
        m32330a((C10018b) new C9957c(this, str, str2, bundle));
    }

    /* renamed from: a */
    public final List<Bundle> mo32804a(String str, String str2) {
        C10017a aVar = new C10017a();
        m32330a((C10018b) new C9960d(this, str, str2, aVar));
        List<Bundle> list = (List) aVar.mo32821a(aVar.mo32823e(5000), List.class);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    /* renamed from: a */
    public final void mo32807a(Activity activity, String str, String str2) {
        m32330a((C10018b) new C9963e(this, activity, str, str2));
    }

    /* renamed from: a */
    public final void mo32809a(String str) {
        m32330a((C10018b) new C9966f(this, str));
    }

    /* renamed from: b */
    public final void mo32813b(String str) {
        m32330a((C10018b) new C9969g(this, str));
    }

    /* renamed from: e */
    public final String mo32818e() {
        C10017a aVar = new C10017a();
        m32330a((C10018b) new C9972h(this, aVar));
        return aVar.mo32822d(500);
    }

    /* renamed from: g */
    public final String mo32820g() {
        C10017a aVar = new C10017a();
        m32330a((C10018b) new C9975i(this, aVar));
        return aVar.mo32822d(50);
    }

    /* renamed from: a */
    public final long mo32801a() {
        C10017a aVar = new C10017a();
        m32330a((C10018b) new C9978j(this, aVar));
        Long l = (Long) aVar.mo32821a(aVar.mo32823e(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.f30225c.mo27935b()).nextLong();
        int i = this.f30229g + 1;
        this.f30229g = i;
        return nextLong + ((long) i);
    }

    /* renamed from: d */
    public final String mo32817d() {
        C10017a aVar = new C10017a();
        m32330a((C10018b) new C9981k(this, aVar));
        return aVar.mo32822d(500);
    }

    /* renamed from: c */
    public final String mo32816c() {
        C10017a aVar = new C10017a();
        m32330a((C10018b) new C9984l(this, aVar));
        return aVar.mo32822d(500);
    }

    /* renamed from: a */
    public final Map<String, Object> mo32805a(String str, String str2, boolean z) {
        C10017a aVar = new C10017a();
        C9987m mVar = new C9987m(this, str, str2, z, aVar);
        m32330a((C10018b) mVar);
        Bundle e = aVar.mo32823e(5000);
        if (e == null || e.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(e.size());
        for (String str3 : e.keySet()) {
            Object obj = e.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public final void mo32806a(int i, String str, Object obj, Object obj2, Object obj3) {
        C9990n nVar = new C9990n(this, false, 5, str, obj, obj2, obj3);
        m32330a((C10018b) nVar);
    }

    /* renamed from: a */
    public final Bundle mo32802a(Bundle bundle, boolean z) {
        C10017a aVar = new C10017a();
        m32330a((C10018b) new C9993o(this, bundle, aVar));
        if (z) {
            return aVar.mo32823e(5000);
        }
        return null;
    }

    /* renamed from: c */
    public final int mo32815c(String str) {
        C10017a aVar = new C10017a();
        m32330a((C10018b) new C9995p(this, str, aVar));
        Integer num = (Integer) aVar.mo32821a(aVar.mo32823e(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    /* renamed from: b */
    public final String mo32812b() {
        return this.f30231i;
    }
}
