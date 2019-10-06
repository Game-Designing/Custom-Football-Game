package com.crashlytics.android.p126c;

import android.content.Context;
import android.util.Log;
import com.crashlytics.android.p124a.C6393q;
import com.crashlytics.android.p124a.C6401x;
import io.fabric.sdk.android.services.concurrency.PriorityCallable;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p024io.fabric.sdk.android.C0102l;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13849i;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;
import p024io.fabric.sdk.android.p348a.p350b.C13858o;
import p024io.fabric.sdk.android.p348a.p350b.C13864u;
import p024io.fabric.sdk.android.p348a.p350b.C13867x;
import p024io.fabric.sdk.android.p348a.p350b.C13868y;
import p024io.fabric.sdk.android.p348a.p352d.C13883b;
import p024io.fabric.sdk.android.p348a.p352d.C13885d;
import p024io.fabric.sdk.android.p348a.p353e.C13905s;
import p024io.fabric.sdk.android.p348a.p353e.C13909v;
import p024io.fabric.sdk.android.services.concurrency.C0104j;
import p024io.fabric.sdk.android.services.concurrency.C13960s;
import p024io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import p024io.fabric.sdk.android.services.network.C13967c;
import p024io.fabric.sdk.android.services.network.C13971g;
import p024io.fabric.sdk.android.services.network.C13973i;

@C0104j({C6484ea.class})
/* renamed from: com.crashlytics.android.c.aa */
/* compiled from: CrashlyticsCore */
public class C6472aa extends C0102l<Void> {

    /* renamed from: g */
    private final long f11617g;

    /* renamed from: h */
    private final ConcurrentHashMap<String, String> f11618h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C6477ba f11619i;

    /* renamed from: j */
    private C6477ba f11620j;

    /* renamed from: k */
    private C6480ca f11621k;

    /* renamed from: l */
    private C6452U f11622l;

    /* renamed from: m */
    private String f11623m;

    /* renamed from: n */
    private String f11624n;

    /* renamed from: o */
    private String f11625o;

    /* renamed from: p */
    private float f11626p;

    /* renamed from: q */
    private boolean f11627q;

    /* renamed from: r */
    private final C6409Ba f11628r;

    /* renamed from: s */
    private C13971g f11629s;

    /* renamed from: t */
    private C6512q f11630t;

    /* renamed from: u */
    private C6484ea f11631u;

    /* renamed from: com.crashlytics.android.c.aa$a */
    /* compiled from: CrashlyticsCore */
    public static class C6473a {

        /* renamed from: a */
        private float f11632a = -1.0f;

        /* renamed from: b */
        private C6480ca f11633b;

        /* renamed from: c */
        private C6409Ba f11634c;

        /* renamed from: d */
        private boolean f11635d = false;

        /* renamed from: a */
        public C6473a mo19523a(boolean isDisabled) {
            this.f11635d = isDisabled;
            return this;
        }

        /* renamed from: a */
        public C6472aa mo19524a() {
            if (this.f11632a < 0.0f) {
                this.f11632a = 1.0f;
            }
            return new C6472aa(this.f11632a, this.f11633b, this.f11634c, this.f11635d);
        }
    }

    /* renamed from: com.crashlytics.android.c.aa$b */
    /* compiled from: CrashlyticsCore */
    private static final class C6474b implements Callable<Boolean> {

        /* renamed from: a */
        private final C6477ba f11636a;

        public C6474b(C6477ba crashMarker) {
            this.f11636a = crashMarker;
        }

        public Boolean call() throws Exception {
            if (!this.f11636a.mo19529b()) {
                return Boolean.FALSE;
            }
            C13920f.m44245e().mo43326c("CrashlyticsCore", "Found previous crash marker.");
            this.f11636a.mo19530c();
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.crashlytics.android.c.aa$c */
    /* compiled from: CrashlyticsCore */
    private static final class C6475c implements C6480ca {
        private C6475c() {
        }

        /* synthetic */ C6475c(C6468X x0) {
            this();
        }

        /* renamed from: a */
        public void mo19526a() {
        }
    }

    public C6472aa() {
        this(1.0f, null, null, false);
    }

    C6472aa(float delay, C6480ca listener, C6409Ba pinningInfo, boolean disabled) {
        this(delay, listener, pinningInfo, disabled, C13864u.m44075a("Crashlytics Exception Handler"));
    }

    C6472aa(float delay, C6480ca listener, C6409Ba pinningInfo, boolean disabled, ExecutorService crashHandlerExecutor) {
        this.f11623m = null;
        this.f11624n = null;
        this.f11625o = null;
        this.f11626p = delay;
        this.f11621k = listener != null ? listener : new C6475c(null);
        this.f11628r = pinningInfo;
        this.f11627q = disabled;
        this.f11630t = new C6512q(crashHandlerExecutor);
        this.f11618h = new ConcurrentHashMap<>();
        this.f11617g = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public boolean mo3314z() {
        String str = "!SDK-VERSION-STRING!:com.crashlytics.sdk.android:crashlytics-core:2.7.0.33";
        return mo19522a(super.mo3307i());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19522a(Context context) {
        C6486fa faVar;
        Context context2 = context;
        String str = "CrashlyticsCore";
        if (!C13858o.m44068a(context).mo43247a()) {
            C13920f.m44245e().mo43326c(str, "Crashlytics is disabled, because data collection is disabled by Firebase.");
            this.f11627q = true;
        }
        if (this.f11627q) {
            return false;
        }
        String apiKey = new C13849i().mo43240d(context2);
        if (apiKey == null) {
            return false;
        }
        String buildId = C13852l.m44062n(context);
        boolean requiresBuildId = C13852l.m44040a(context2, "com.crashlytics.RequireBuildId", true);
        if (m12617a(buildId, requiresBuildId)) {
            try {
                C13929o e = C13920f.m44245e();
                StringBuilder sb = new StringBuilder();
                sb.append("Initializing Crashlytics Core ");
                sb.append(mo2536w());
                e.mo43328d(str, sb.toString());
                C13883b bVar = new C13883b(this);
                this.f11620j = new C6477ba("crash_marker", bVar);
                this.f11619i = new C6477ba("initialization_marker", bVar);
                C13885d dVar = new C13885d(mo3307i(), "com.crashlytics.android.core.CrashlyticsCore");
                C6411Ca preferenceManager = C6411Ca.m12428a(dVar, this);
                if (this.f11628r != null) {
                    try {
                        faVar = new C6486fa(this.f11628r);
                    } catch (Exception e2) {
                        e = e2;
                        boolean z = requiresBuildId;
                        String str2 = buildId;
                        String str3 = apiKey;
                    }
                } else {
                    faVar = null;
                }
                C6486fa infoProvider = faVar;
                this.f11629s = new C13967c(C13920f.m44245e());
                this.f11629s.mo43470a(infoProvider);
                C13868y idManager = mo3310t();
                C6471a appData = C6471a.m12611a(context2, idManager, apiKey, buildId);
                C6446Qa unityVersionProvider = new C6434Ka(context2, new C6523ua(context2, appData.f11614d));
                C6476b appMeasurementEventListenerRegistrar = new C6499ka(this);
                C6471a appData2 = appData;
                C6401x firebaseAnalyticsLogger = C6393q.m12381a(context);
                boolean requiresBuildId2 = requiresBuildId;
                try {
                    C13868y idManager2 = idManager;
                    r1 = r1;
                    C13973i iVar = infoProvider;
                    C13885d dVar2 = dVar;
                    C6452U u = r1;
                    boolean z2 = requiresBuildId2;
                    String str4 = buildId;
                    String str5 = apiKey;
                    try {
                        C6452U u2 = new C6452U(this, this.f11630t, this.f11629s, idManager2, preferenceManager, bVar, appData2, unityVersionProvider, appMeasurementEventListenerRegistrar, firebaseAnalyticsLogger);
                        this.f11622l = u;
                        boolean initializeSynchronously = mo19511B();
                        m12613K();
                        this.f11622l.mo19481a(Thread.getDefaultUncaughtExceptionHandler(), new C13867x().mo43258e(context2));
                        if (!initializeSynchronously || !C13852l.m44045b(context)) {
                            C13920f.m44245e().mo43326c(str, "Exception handling initialization successful");
                            return true;
                        }
                        C13920f.m44245e().mo43326c(str, "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                        m12614L();
                        return false;
                    } catch (Exception e3) {
                        e = e3;
                        C13920f.m44245e().mo43325b(str, "Crashlytics was not started due to an exception during initialization", e);
                        this.f11622l = null;
                        return false;
                    }
                } catch (Exception e4) {
                    e = e4;
                    String str6 = apiKey;
                    boolean z3 = requiresBuildId2;
                    String str7 = buildId;
                    C13920f.m44245e().mo43325b(str, "Crashlytics was not started due to an exception during initialization", e);
                    this.f11622l = null;
                    return false;
                }
            } catch (Exception e5) {
                e = e5;
                boolean z4 = requiresBuildId;
                String str8 = buildId;
                String str9 = apiKey;
                C13920f.m44245e().mo43325b(str, "Crashlytics was not started due to an exception during initialization", e);
                this.f11622l = null;
                return false;
            }
        } else {
            String str10 = buildId;
            String str11 = apiKey;
            throw new UnmetDependencyException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Void m12635g() {
        String str = "CrashlyticsCore";
        mo19518J();
        this.f11622l.mo19486b();
        try {
            this.f11622l.mo19497l();
            C13909v settingsData = C13905s.m44193b().mo43313a();
            if (settingsData == null) {
                C13920f.m44245e().mo43321a(str, "Received null settings, skipping report submission!");
                mo19517I();
                return null;
            }
            this.f11622l.mo19480a(settingsData);
            if (!settingsData.f42194d.f42161c) {
                C13920f.m44245e().mo43326c(str, "Collection of crash reports disabled in Crashlytics settings.");
                mo19517I();
                return null;
            } else if (!C13858o.m44068a(mo3307i()).mo43247a()) {
                C13920f.m44245e().mo43326c(str, "Automatic collection of crash reports disabled by Firebase settings.");
                mo19517I();
                return null;
            } else {
                C6482da ndkData = mo19513E();
                if (ndkData != null && !this.f11622l.mo19485a(ndkData)) {
                    C13920f.m44245e().mo43326c(str, "Could not finalize previous NDK sessions.");
                }
                if (!this.f11622l.mo19487b(settingsData.f42192b)) {
                    C13920f.m44245e().mo43326c(str, "Could not finalize previous sessions.");
                }
                this.f11622l.mo19475a(this.f11626p, settingsData);
                mo19517I();
                return null;
            }
        } catch (Exception e) {
            C13920f.m44245e().mo43325b(str, "Crashlytics encountered a problem during asynchronous initialization.", e);
        } catch (Throwable th) {
            mo19517I();
            throw th;
        }
    }

    /* renamed from: u */
    public String mo2535u() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    /* renamed from: w */
    public String mo2536w() {
        return "2.7.0.33";
    }

    /* renamed from: D */
    public static C6472aa m12612D() {
        return (C6472aa) C13920f.m44237a(C6472aa.class);
    }

    /* renamed from: a */
    public void mo19521a(Throwable throwable) {
        if (this.f11627q || !m12619b("prior to logging exceptions.")) {
            return;
        }
        if (throwable == null) {
            C13920f.m44245e().mo43319a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.f11622l.mo19482a(Thread.currentThread(), throwable);
        }
    }

    /* renamed from: a */
    public void mo19519a(String msg) {
        m12616a(3, "CrashlyticsCore", msg);
    }

    /* renamed from: a */
    private void m12616a(int priority, String tag, String msg) {
        if (!this.f11627q && m12619b("prior to logging messages.")) {
            this.f11622l.mo19477a(System.currentTimeMillis() - this.f11617g, m12618b(priority, tag, msg));
        }
    }

    /* renamed from: a */
    public void mo19520a(String key, String value) {
        if (!this.f11627q && m12619b("prior to setting keys.")) {
            String str = "CrashlyticsCore";
            if (key == null) {
                Context context = mo3307i();
                if (context == null || !C13852l.m44058j(context)) {
                    C13920f.m44245e().mo43325b(str, "Attempting to set custom attribute with null key, ignoring.", null);
                    return;
                }
                throw new IllegalArgumentException("Custom attribute key must not be null.");
            }
            String key2 = m12620c(key);
            if (this.f11618h.size() < 64 || this.f11618h.containsKey(key2)) {
                this.f11618h.put(key2, value == null ? "" : m12620c(value));
                this.f11622l.mo19483a((Map<String, String>) this.f11618h);
                return;
            }
            C13920f.m44245e().mo43326c(str, "Exceeded maximum number of custom attributes (64)");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: C */
    public Map<String, String> mo19512C() {
        return Collections.unmodifiableMap(this.f11618h);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: G */
    public String mo19515G() {
        if (mo3310t().mo43259a()) {
            return this.f11623m;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: F */
    public String mo19514F() {
        if (mo3310t().mo43259a()) {
            return this.f11624n;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: H */
    public String mo19516H() {
        if (mo3310t().mo43259a()) {
            return this.f11625o;
        }
        return null;
    }

    /* renamed from: L */
    private void m12614L() {
        PriorityCallable<Void> callable = new C6468X<>(this);
        for (C13960s task : mo3308j()) {
            callable.mo43381a(task);
        }
        Future<Void> future = mo3309s().mo43338b().submit(callable);
        String str = "CrashlyticsCore";
        C13920f.m44245e().mo43326c(str, "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            future.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            C13920f.m44245e().mo43325b(str, "Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            C13920f.m44245e().mo43325b(str, "Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            C13920f.m44245e().mo43325b(str, "Crashlytics timed out during initialization.", e3);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: J */
    public void mo19518J() {
        this.f11630t.mo19602b(new C6469Y(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: I */
    public void mo19517I() {
        this.f11630t.mo19601a((Callable<T>) new C6470Z<T>(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: B */
    public boolean mo19511B() {
        return this.f11619i.mo19529b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: E */
    public C6482da mo19513E() {
        C6484ea eaVar = this.f11631u;
        if (eaVar != null) {
            return eaVar.mo19539a();
        }
        return null;
    }

    /* renamed from: K */
    private void m12613K() {
        if (Boolean.TRUE.equals((Boolean) this.f11630t.mo19602b(new C6474b(this.f11620j)))) {
            try {
                this.f11621k.mo19526a();
            } catch (Exception e) {
                C13920f.m44245e().mo43325b("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: A */
    public void mo19510A() {
        this.f11620j.mo19528a();
    }

    /* renamed from: b */
    private static String m12618b(int priority, String tag, String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(C13852l.m44025a(priority));
        sb.append("/");
        sb.append(tag);
        sb.append(" ");
        sb.append(msg);
        return sb.toString();
    }

    /* renamed from: b */
    private static boolean m12619b(String msg) {
        C6472aa instance = m12612D();
        if (instance != null && instance.f11622l != null) {
            return true;
        }
        C13929o e = C13920f.m44245e();
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics must be initialized by calling Fabric.with(Context) ");
        sb.append(msg);
        e.mo43325b("CrashlyticsCore", sb.toString(), null);
        return false;
    }

    /* renamed from: c */
    private static String m12620c(String input) {
        if (input == null) {
            return input;
        }
        String input2 = input.trim();
        if (input2.length() > 1024) {
            return input2.substring(0, Opcodes.ACC_ABSTRACT);
        }
        return input2;
    }

    /* renamed from: a */
    static boolean m12617a(String buildId, boolean requiresBuildId) {
        String str = "CrashlyticsCore";
        if (!requiresBuildId) {
            C13920f.m44245e().mo43326c(str, "Configured not to require a build ID.");
            return true;
        } else if (!C13852l.m44046b(buildId)) {
            return true;
        } else {
            String str2 = ".";
            Log.e(str, str2);
            Log.e(str, ".     |  | ");
            String str3 = ".     |  |";
            Log.e(str, str3);
            Log.e(str, str3);
            Log.e(str, ".   \\ |  | /");
            Log.e(str, ".    \\    /");
            Log.e(str, ".     \\  /");
            Log.e(str, ".      \\/");
            Log.e(str, str2);
            Log.e(str, "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
            Log.e(str, str2);
            Log.e(str, ".      /\\");
            Log.e(str, ".     /  \\");
            Log.e(str, ".    /    \\");
            Log.e(str, ".   / |  | \\");
            Log.e(str, str3);
            Log.e(str, str3);
            Log.e(str, str3);
            Log.e(str, str2);
            return false;
        }
    }
}
