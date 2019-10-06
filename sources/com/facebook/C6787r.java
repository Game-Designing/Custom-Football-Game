package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import com.facebook.GraphRequest.C6545b;
import com.facebook.internal.C6675G;
import com.facebook.internal.C6690N;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6697T;
import com.facebook.internal.C6709b;
import com.facebook.p127a.C6638q;
import com.facebook.p127a.p130b.C6605k;
import com.facebook.p127a.p130b.C6605k.C6606a;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;

/* renamed from: com.facebook.r */
/* compiled from: FacebookSdk */
public final class C6787r {

    /* renamed from: a */
    private static final String f12469a = C6787r.class.getCanonicalName();

    /* renamed from: b */
    private static final HashSet<C6537C> f12470b;

    /* renamed from: c */
    private static Executor f12471c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static volatile String f12472d;

    /* renamed from: e */
    private static volatile String f12473e;

    /* renamed from: f */
    private static volatile String f12474f;

    /* renamed from: g */
    private static volatile Boolean f12475g;

    /* renamed from: h */
    private static volatile String f12476h = "facebook.com";

    /* renamed from: i */
    private static AtomicLong f12477i = new AtomicLong(65536);

    /* renamed from: j */
    private static volatile boolean f12478j = false;

    /* renamed from: k */
    private static boolean f12479k = false;

    /* renamed from: l */
    private static C6675G<File> f12480l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static Context f12481m;

    /* renamed from: n */
    private static int f12482n = 64206;

    /* renamed from: o */
    private static final Object f12483o = new Object();

    /* renamed from: p */
    private static String f12484p = C6690N.m13387a();

    /* renamed from: q */
    private static final BlockingQueue<Runnable> f12485q = new LinkedBlockingQueue(10);

    /* renamed from: r */
    private static final ThreadFactory f12486r = new C6783n();

    /* renamed from: s */
    private static Boolean f12487s;

    /* renamed from: t */
    private static Boolean f12488t;

    /* renamed from: com.facebook.r$a */
    /* compiled from: FacebookSdk */
    public interface C6788a {
        /* renamed from: a */
        void mo20141a();
    }

    static {
        C6537C c = C6537C.DEVELOPER_ERRORS;
        Boolean valueOf = Boolean.valueOf(false);
        f12470b = new HashSet<>(Arrays.asList(new C6537C[]{c}));
        f12487s = valueOf;
        f12488t = valueOf;
    }

    @Deprecated
    /* renamed from: c */
    public static synchronized void m13813c(Context applicationContext) {
        synchronized (C6787r.class) {
            m13804a(applicationContext, (C6788a) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        return;
     */
    @java.lang.Deprecated
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m13804a(android.content.Context r3, com.facebook.C6787r.C6788a r4) {
        /*
            java.lang.Class<com.facebook.r> r0 = com.facebook.C6787r.class
            monitor-enter(r0)
            java.lang.Boolean r1 = f12487s     // Catch:{ all -> 0x0088 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0012
            if (r4 == 0) goto L_0x0010
            r4.mo20141a()     // Catch:{ all -> 0x0088 }
        L_0x0010:
            monitor-exit(r0)
            return
        L_0x0012:
            java.lang.String r1 = "applicationContext"
            com.facebook.internal.C6697T.m13461a(r3, r1)     // Catch:{ all -> 0x0088 }
            r1 = 0
            com.facebook.internal.C6697T.m13460a(r3, r1)     // Catch:{ all -> 0x0088 }
            com.facebook.internal.C6697T.m13466b(r3, r1)     // Catch:{ all -> 0x0088 }
            android.content.Context r1 = r3.getApplicationContext()     // Catch:{ all -> 0x0088 }
            f12481m = r1     // Catch:{ all -> 0x0088 }
            android.content.Context r1 = f12481m     // Catch:{ all -> 0x0088 }
            m13810b(r1)     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = f12472d     // Catch:{ all -> 0x0088 }
            boolean r1 = com.facebook.internal.C6694S.m13436b(r1)     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x0080
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0088 }
            f12487s = r1     // Catch:{ all -> 0x0088 }
            boolean r1 = m13817g()     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0041
            m13812c()     // Catch:{ all -> 0x0088 }
        L_0x0041:
            android.content.Context r1 = f12481m     // Catch:{ all -> 0x0088 }
            boolean r1 = r1 instanceof android.app.Application     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0056
            boolean r1 = com.facebook.C6557O.m12974e()     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0056
            android.content.Context r1 = f12481m     // Catch:{ all -> 0x0088 }
            android.app.Application r1 = (android.app.Application) r1     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = f12472d     // Catch:{ all -> 0x0088 }
            com.facebook.p127a.p130b.C6602h.m13083a(r1, r2)     // Catch:{ all -> 0x0088 }
        L_0x0056:
            com.facebook.internal.C6670D.m13313f()     // Catch:{ all -> 0x0088 }
            com.facebook.internal.C6678J.m13355d()     // Catch:{ all -> 0x0088 }
            android.content.Context r1 = f12481m     // Catch:{ all -> 0x0088 }
            com.facebook.internal.C6712c.m13522a(r1)     // Catch:{ all -> 0x0088 }
            com.facebook.internal.G r1 = new com.facebook.internal.G     // Catch:{ all -> 0x0088 }
            com.facebook.o r2 = new com.facebook.o     // Catch:{ all -> 0x0088 }
            r2.<init>()     // Catch:{ all -> 0x0088 }
            r1.<init>(r2)     // Catch:{ all -> 0x0088 }
            f12480l = r1     // Catch:{ all -> 0x0088 }
            java.util.concurrent.FutureTask r1 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x0088 }
            com.facebook.p r2 = new com.facebook.p     // Catch:{ all -> 0x0088 }
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0088 }
            r1.<init>(r2)     // Catch:{ all -> 0x0088 }
            java.util.concurrent.Executor r2 = m13822l()     // Catch:{ all -> 0x0088 }
            r2.execute(r1)     // Catch:{ all -> 0x0088 }
            monitor-exit(r0)
            return
        L_0x0080:
            com.facebook.FacebookException r1 = new com.facebook.FacebookException     // Catch:{ all -> 0x0088 }
            java.lang.String r2 = "A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk."
            r1.<init>(r2)     // Catch:{ all -> 0x0088 }
            throw r1     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.C6787r.m13804a(android.content.Context, com.facebook.r$a):void");
    }

    /* renamed from: s */
    public static synchronized boolean m13829s() {
        boolean booleanValue;
        synchronized (C6787r.class) {
            booleanValue = f12487s.booleanValue();
        }
        return booleanValue;
    }

    /* renamed from: r */
    public static synchronized boolean m13828r() {
        boolean booleanValue;
        synchronized (C6787r.class) {
            booleanValue = f12488t.booleanValue();
        }
        return booleanValue;
    }

    /* renamed from: c */
    public static void m13812c() {
        f12488t = Boolean.valueOf(true);
    }

    /* renamed from: a */
    public static boolean m13808a(C6537C behavior) {
        boolean z;
        synchronized (f12470b) {
            z = m13827q() && f12470b.contains(behavior);
        }
        return z;
    }

    /* renamed from: q */
    public static boolean m13827q() {
        return f12478j;
    }

    /* renamed from: t */
    public static boolean m13830t() {
        return f12479k;
    }

    /* renamed from: l */
    public static Executor m13822l() {
        synchronized (f12483o) {
            if (f12471c == null) {
                f12471c = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return f12471c;
    }

    /* renamed from: m */
    public static String m13823m() {
        return f12476h;
    }

    /* renamed from: e */
    public static Context m13815e() {
        C6697T.m13468c();
        return f12481m;
    }

    /* renamed from: n */
    public static String m13824n() {
        C6694S.m13433b(f12469a, String.format("getGraphApiVersion: %s", new Object[]{f12484p}));
        return f12484p;
    }

    /* renamed from: b */
    public static void m13811b(Context context, String applicationId) {
        m13822l().execute(new C6786q(context.getApplicationContext(), applicationId));
    }

    /* renamed from: a */
    static void m13805a(Context context, String applicationId) {
        if (context == null || applicationId == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        try {
            C6709b identifiers = C6709b.m13508a(context);
            SharedPreferences preferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
            StringBuilder sb = new StringBuilder();
            sb.append(applicationId);
            sb.append("ping");
            String pingKey = sb.toString();
            long lastPing = preferences.getLong(pingKey, 0);
            GraphRequest publishRequest = GraphRequest.m12875a((AccessToken) null, String.format("%s/activities", new Object[]{applicationId}), C6605k.m13113a(C6606a.MOBILE_INSTALL_EVENT, identifiers, C6638q.m13213a(context), m13807a(context), context), (C6545b) null);
            if (lastPing == 0) {
                C6817z b = publishRequest.mo19680b();
                Editor editor = preferences.edit();
                editor.putLong(pingKey, System.currentTimeMillis());
                editor.apply();
            }
        } catch (JSONException e) {
            throw new FacebookException("An error occurred while publishing install.", e);
        } catch (Exception e2) {
            C6694S.m13422a("Facebook-publish", e2);
        }
    }

    /* renamed from: p */
    public static String m13826p() {
        return "5.0.2";
    }

    /* renamed from: a */
    public static boolean m13807a(Context context) {
        C6697T.m13468c();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    /* renamed from: o */
    public static long m13825o() {
        C6697T.m13468c();
        return f12477i.get();
    }

    /* renamed from: b */
    static void m13810b(Context context) {
        if (context != null) {
            try {
                ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (ai != null && ai.metaData != null) {
                    if (f12472d == null) {
                        Object appId = ai.metaData.get("com.facebook.sdk.ApplicationId");
                        if (appId instanceof String) {
                            String appIdString = (String) appId;
                            if (appIdString.toLowerCase(Locale.ROOT).startsWith("fb")) {
                                f12472d = appIdString.substring(2);
                            } else {
                                f12472d = appIdString;
                            }
                        } else if (appId instanceof Integer) {
                            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (f12473e == null) {
                        f12473e = ai.metaData.getString("com.facebook.sdk.ApplicationName");
                    }
                    if (f12474f == null) {
                        f12474f = ai.metaData.getString("com.facebook.sdk.ClientToken");
                    }
                    if (f12482n == 64206) {
                        f12482n = ai.metaData.getInt("com.facebook.sdk.CallbackOffset", 64206);
                    }
                    if (f12475g == null) {
                        f12475g = Boolean.valueOf(ai.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
                    }
                }
            } catch (NameNotFoundException e) {
            }
        }
    }

    /* renamed from: f */
    public static String m13816f() {
        C6697T.m13468c();
        return f12472d;
    }

    /* renamed from: a */
    public static void m13806a(String applicationId) {
        f12472d = applicationId;
    }

    /* renamed from: j */
    public static String m13820j() {
        C6697T.m13468c();
        return f12474f;
    }

    /* renamed from: g */
    public static boolean m13817g() {
        return C6557O.m12973d();
    }

    /* renamed from: h */
    public static boolean m13818h() {
        return C6557O.m12974e();
    }

    /* renamed from: k */
    public static boolean m13821k() {
        return C6557O.m12975f();
    }

    /* renamed from: d */
    public static boolean m13814d() {
        return C6557O.m12971c();
    }

    /* renamed from: i */
    public static int m13819i() {
        C6697T.m13468c();
        return f12482n;
    }
}
