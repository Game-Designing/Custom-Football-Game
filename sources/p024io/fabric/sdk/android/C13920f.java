package p024io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import p024io.fabric.sdk.android.p348a.p350b.C13858o;
import p024io.fabric.sdk.android.p348a.p350b.C13868y;
import p024io.fabric.sdk.android.services.concurrency.C0104j;
import p024io.fabric.sdk.android.services.concurrency.C13958r;
import p024io.fabric.sdk.android.services.concurrency.C13960s;
import p024io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

/* renamed from: io.fabric.sdk.android.f */
/* compiled from: Fabric */
public class C13920f {

    /* renamed from: a */
    static volatile C13920f f42220a;

    /* renamed from: b */
    static final C13929o f42221b = new C13917c();

    /* renamed from: c */
    private final Context f42222c;

    /* renamed from: d */
    private final Map<Class<? extends C0102l>, C0102l> f42223d;

    /* renamed from: e */
    private final ExecutorService f42224e;

    /* renamed from: f */
    private final Handler f42225f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C13925j<C13920f> f42226g;

    /* renamed from: h */
    private final C13925j<?> f42227h;

    /* renamed from: i */
    private final C13868y f42228i;

    /* renamed from: j */
    private C13914b f42229j;

    /* renamed from: k */
    private WeakReference<Activity> f42230k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public AtomicBoolean f42231l = new AtomicBoolean(false);

    /* renamed from: m */
    final C13929o f42232m;

    /* renamed from: n */
    final boolean f42233n;

    /* renamed from: io.fabric.sdk.android.f$a */
    /* compiled from: Fabric */
    public static class C13921a {

        /* renamed from: a */
        private final Context f42234a;

        /* renamed from: b */
        private C0102l[] f42235b;

        /* renamed from: c */
        private C13958r f42236c;

        /* renamed from: d */
        private Handler f42237d;

        /* renamed from: e */
        private C13929o f42238e;

        /* renamed from: f */
        private boolean f42239f;

        /* renamed from: g */
        private String f42240g;

        /* renamed from: h */
        private String f42241h;

        /* renamed from: i */
        private C13925j<C13920f> f42242i;

        public C13921a(Context context) {
            if (context != null) {
                this.f42234a = context;
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        /* renamed from: a */
        public C13921a mo43344a(C0102l... kits) {
            if (this.f42235b == null) {
                if (!C13858o.m44068a(this.f42234a).mo43247a()) {
                    List<Kit> whitelistedKits = new ArrayList<>();
                    boolean warned = false;
                    for (C0102l kit : kits) {
                        String u = kit.mo2535u();
                        char c = 65535;
                        int hashCode = u.hashCode();
                        if (hashCode != 607220212) {
                            if (hashCode == 1830452504 && u.equals("com.crashlytics.sdk.android:crashlytics")) {
                                c = 0;
                            }
                        } else if (u.equals("com.crashlytics.sdk.android:answers")) {
                            c = 1;
                        }
                        if (c == 0 || c == 1) {
                            whitelistedKits.add(kit);
                        } else if (!warned) {
                            warned = true;
                            C13920f.m44245e().mo43321a("Fabric", "Fabric will not initialize any kits when Firebase automatic data collection is disabled; to use Third-party kits with automatic data collection disabled, initialize these kits via non-Fabric means.");
                        }
                    }
                    kits = (C0102l[]) whitelistedKits.toArray(new C0102l[0]);
                }
                this.f42235b = kits;
                return this;
            }
            throw new IllegalStateException("Kits already set.");
        }

        /* renamed from: a */
        public C13920f mo43345a() {
            Map<Class<? extends Kit>, Kit> kitMap;
            if (this.f42236c == null) {
                this.f42236c = C13958r.m44361a();
            }
            if (this.f42237d == null) {
                this.f42237d = new Handler(Looper.getMainLooper());
            }
            if (this.f42238e == null) {
                if (this.f42239f) {
                    this.f42238e = new C13917c(3);
                } else {
                    this.f42238e = new C13917c();
                }
            }
            if (this.f42241h == null) {
                this.f42241h = this.f42234a.getPackageName();
            }
            if (this.f42242i == null) {
                this.f42242i = C13925j.f42246a;
            }
            C0102l[] lVarArr = this.f42235b;
            if (lVarArr == null) {
                kitMap = new HashMap<>();
            } else {
                kitMap = C13920f.m44242b((Collection<? extends C0102l>) Arrays.asList(lVarArr));
            }
            Context appContext = this.f42234a.getApplicationContext();
            Context context = appContext;
            Map map = kitMap;
            C13920f fVar = new C13920f(context, map, this.f42236c, this.f42237d, this.f42238e, this.f42239f, this.f42242i, new C13868y(appContext, this.f42241h, this.f42240g, kitMap.values()), C13920f.m44244d(this.f42234a));
            return fVar;
        }
    }

    /* renamed from: h */
    static C13920f m44247h() {
        if (f42220a != null) {
            return f42220a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    C13920f(Context context, Map<Class<? extends C0102l>, C0102l> kits, C13958r threadPoolExecutor, Handler mainHandler, C13929o logger, boolean debuggable, C13925j callback, C13868y idManager, Activity rootActivity) {
        this.f42222c = context;
        this.f42223d = kits;
        this.f42224e = threadPoolExecutor;
        this.f42225f = mainHandler;
        this.f42232m = logger;
        this.f42233n = debuggable;
        this.f42226g = callback;
        this.f42227h = mo43336a(kits.size());
        this.f42228i = idManager;
        mo43335a(rootActivity);
    }

    /* renamed from: a */
    public static C13920f m44236a(Context context, C0102l... kits) {
        if (f42220a == null) {
            synchronized (C13920f.class) {
                if (f42220a == null) {
                    C13921a aVar = new C13921a(context);
                    aVar.mo43344a(kits);
                    m44243c(aVar.mo43345a());
                }
            }
        }
        return f42220a;
    }

    /* renamed from: c */
    private static void m44243c(C13920f fabric) {
        f42220a = fabric;
        fabric.m44248i();
    }

    /* renamed from: a */
    public C13920f mo43335a(Activity activity) {
        this.f42230k = new WeakReference<>(activity);
        return this;
    }

    /* renamed from: a */
    public Activity mo43334a() {
        WeakReference<Activity> weakReference = this.f42230k;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    /* renamed from: i */
    private void m44248i() {
        this.f42229j = new C13914b(this.f42222c);
        this.f42229j.mo43318a(new C13918d(this));
        mo43341c(this.f42222c);
    }

    /* renamed from: f */
    public String mo43343f() {
        return "1.4.8.32";
    }

    /* renamed from: c */
    public String mo43340c() {
        return "io.fabric.sdk.android:fabric";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo43341c(Context context) {
        StringBuilder initInfo;
        Future<Map<String, KitInfo>> installedKitsFuture = mo43339b(context);
        Collection<Kit> providedKits = mo43342d();
        C13930p onboarding = new C13930p(installedKitsFuture, providedKits);
        List<Kit> kits = new ArrayList<>(providedKits);
        Collections.sort(kits);
        onboarding.mo3302a(context, this, C13925j.f42246a, this.f42228i);
        Iterator it = kits.iterator();
        while (it.hasNext()) {
            ((C0102l) it.next()).mo3302a(context, this, this.f42227h, this.f42228i);
        }
        onboarding.mo3313y();
        String str = "Fabric";
        String str2 = " [Version: ";
        if (m44245e().mo43323a(str, 3)) {
            StringBuilder sb = new StringBuilder("Initializing ");
            sb.append(mo43340c());
            sb.append(str2);
            sb.append(mo43343f());
            initInfo = sb.append("], with the following kits:\n");
        } else {
            initInfo = null;
        }
        Iterator it2 = kits.iterator();
        while (it2.hasNext()) {
            C0102l kit = (C0102l) it2.next();
            kit.f144b.mo43381a((C13960s) onboarding.f144b);
            mo43337a(this.f42223d, kit);
            kit.mo3313y();
            if (initInfo != null) {
                initInfo.append(kit.mo2535u());
                initInfo.append(str2);
                initInfo.append(kit.mo2536w());
                initInfo.append("]\n");
            }
        }
        if (initInfo != null) {
            m44245e().mo43326c(str, initInfo.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo43337a(Map<Class<? extends C0102l>, C0102l> kits, C0102l dependentKit) {
        Class<?>[] dependencies;
        C0104j dependsOn = dependentKit.f148f;
        if (dependsOn != null) {
            for (Class<?> dependency : dependsOn.value()) {
                if (dependency.isInterface()) {
                    for (C0102l kit : kits.values()) {
                        if (dependency.isAssignableFrom(kit.getClass())) {
                            dependentKit.f144b.mo43381a((C13960s) kit.f144b);
                        }
                    }
                } else if (((C0102l) kits.get(dependency)) != null) {
                    dependentKit.f144b.mo43381a((C13960s) ((C0102l) kits.get(dependency)).f144b);
                } else {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static Activity m44244d(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    /* renamed from: b */
    public ExecutorService mo43338b() {
        return this.f42224e;
    }

    /* renamed from: d */
    public Collection<C0102l> mo43342d() {
        return this.f42223d.values();
    }

    /* renamed from: a */
    public static <T extends C0102l> T m44237a(Class<T> cls) {
        return (C0102l) m44247h().f42223d.get(cls);
    }

    /* renamed from: e */
    public static C13929o m44245e() {
        if (f42220a == null) {
            return f42221b;
        }
        return f42220a.f42232m;
    }

    /* renamed from: g */
    public static boolean m44246g() {
        if (f42220a == null) {
            return false;
        }
        return f42220a.f42233n;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Map<Class<? extends C0102l>, C0102l> m44242b(Collection<? extends C0102l> kits) {
        HashMap<Class<? extends Kit>, Kit> map = new HashMap<>(kits.size());
        m44240a((Map<Class<? extends C0102l>, C0102l>) map, kits);
        return map;
    }

    /* renamed from: a */
    private static void m44240a(Map<Class<? extends C0102l>, C0102l> map, Collection<? extends C0102l> kits) {
        for (C0102l kit : kits) {
            map.put(kit.getClass(), kit);
            if (kit instanceof C0103m) {
                m44240a(map, ((C0103m) kit).mo2533f());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C13925j<?> mo43336a(int size) {
        return new C13919e(this, size);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Future<Map<String, C13928n>> mo43339b(Context context) {
        return mo43338b().submit(new C13923h(context.getPackageCodePath()));
    }
}
