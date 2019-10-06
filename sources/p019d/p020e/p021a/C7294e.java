package p019d.p020e.p021a;

import android.content.Context;
import android.text.TextUtils;
import com.flurry.sdk.C7354Ad;
import com.flurry.sdk.C7374Eb;
import com.flurry.sdk.C7379Fb;
import com.flurry.sdk.C7422Md;
import com.flurry.sdk.C7449Rd;
import com.flurry.sdk.C7452Sb;
import com.flurry.sdk.C7462Ub;
import com.flurry.sdk.C7475Xa;
import com.flurry.sdk.C7513ec;
import com.flurry.sdk.C7537id;
import com.flurry.sdk.C7585qd;
import com.flurry.sdk.C7602td;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: d.e.a.e */
public final class C7294e {

    /* renamed from: a */
    private static final String f14157a = C7294e.class.getSimpleName();

    /* renamed from: b */
    public static String f14158b = "!SDK-VERSION-STRING!:com.flurry.android:analytics:11.6.0";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static C7295f f14159c = null;

    /* renamed from: d */
    private static final C7452Sb<C7537id> f14160d = new C7292c();

    /* renamed from: e */
    private static boolean f14161e = false;

    /* renamed from: f */
    private static int f14162f = 5;

    /* renamed from: g */
    private static long f14163g = 10000;

    /* renamed from: h */
    private static boolean f14164h = true;

    /* renamed from: i */
    private static boolean f14165i = true;

    /* renamed from: j */
    private static List<C7297h> f14166j = new ArrayList();

    /* renamed from: k */
    private static String f14167k = null;

    /* renamed from: l */
    private static String f14168l = null;

    /* renamed from: m */
    private static C7290a f14169m = null;

    /* renamed from: d.e.a.e$a */
    public static class C0098a {

        /* renamed from: a */
        private static C7295f f131a = null;

        /* renamed from: b */
        private boolean f132b = false;

        /* renamed from: c */
        private int f133c = 5;

        /* renamed from: d */
        private long f134d = 10000;

        /* renamed from: e */
        private boolean f135e = true;

        /* renamed from: f */
        private boolean f136f = false;

        /* renamed from: g */
        private boolean f137g = true;

        /* renamed from: h */
        List<C7297h> f138h = new ArrayList();

        /* renamed from: i */
        C7290a f139i;

        /* renamed from: a */
        public C0098a mo3299a(boolean z) {
            this.f132b = z;
            return this;
        }

        /* renamed from: a */
        public void mo3300a(Context context, String str) {
            if (C7294e.m15873e()) {
                C7294e.m15865a(f131a, this.f132b, this.f133c, this.f134d, this.f135e, this.f136f, this.f137g, this.f138h, this.f139i, context, str);
            }
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<d.e.a.h>, for r8v0, types: [java.util.List, java.util.List<d.e.a.h>] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void m15865a(p019d.p020e.p021a.C7295f r0, boolean r1, int r2, long r3, boolean r5, boolean r6, boolean r7, java.util.List<p019d.p020e.p021a.C7297h> r8, p019d.p020e.p021a.C7290a r9, android.content.Context r10, java.lang.String r11) {
        /*
            f14159c = r0
            m15864a(r0)
            f14161e = r1
            m15869b(r1)
            f14162f = r2
            m15860a(r2)
            f14163g = r3
            m15861a(r3)
            f14164h = r5
            m15867a(r5)
            android.content.res.Resources r0 = r10.getResources()
            java.lang.String r1 = r10.getPackageName()
            java.lang.String r2 = "FLURRY_IS_YAHOO_APP"
            java.lang.String r3 = "bool"
            int r0 = r0.getIdentifier(r2, r3, r1)
            if (r0 == 0) goto L_0x004b
            android.content.res.Resources r1 = r10.getResources()
            boolean r0 = r1.getBoolean(r0)
            java.lang.String r1 = f14157a
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "Found FLURRY_IS_YAHOO_APP resource id. Value: "
            java.lang.String r2 = r3.concat(r2)
            com.flurry.sdk.C7513ec.m16649c(r1, r2)
            goto L_0x004c
        L_0x004b:
            r0 = 0
        L_0x004c:
            if (r0 == 0) goto L_0x0069
            com.flurry.sdk.td r0 = com.flurry.sdk.C7602td.m16825a()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r6)
            java.lang.String r2 = "ProtonEnabled"
            r0.mo24025a(r2, r1)
            if (r6 != 0) goto L_0x0072
            com.flurry.sdk.td r0 = com.flurry.sdk.C7602td.m16825a()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            java.lang.String r2 = "analyticsEnabled"
            r0.mo24025a(r2, r1)
            goto L_0x0072
        L_0x0069:
            if (r6 == 0) goto L_0x0072
            java.lang.String r0 = f14157a
            java.lang.String r1 = "Flurry Pulse is not available anymore and the API will be removed in an upcoming release"
            com.flurry.sdk.C7513ec.m16651d(r0, r1)
        L_0x0072:
            f14165i = r7
            boolean r0 = m15873e()
            if (r0 == 0) goto L_0x0088
            com.flurry.sdk.td r0 = com.flurry.sdk.C7602td.m16825a()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)
            java.lang.String r2 = "IncludeBackgroundSessionsInMetrics"
            r0.mo24025a(r2, r1)
        L_0x0088:
            java.util.Iterator r0 = r8.iterator()
        L_0x008c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x009e
            java.lang.Object r1 = r0.next()
            d.e.a.h r1 = (p019d.p020e.p021a.C7297h) r1
            com.flurry.sdk.hc r1 = (com.flurry.sdk.C7530hc) r1
            com.flurry.sdk.C7525gc.m16681a(r1)
            goto L_0x008c
        L_0x009e:
            f14169m = r9
            f14167k = r11
            java.lang.String r0 = f14167k
            m15863a(r10, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p020e.p021a.C7294e.m15865a(d.e.a.f, boolean, int, long, boolean, boolean, boolean, java.util.List, d.e.a.a, android.content.Context, java.lang.String):void");
    }

    private C7294e() {
    }

    @Deprecated
    /* renamed from: a */
    public static void m15864a(C7295f fVar) {
        if (m15873e()) {
            f14159c = fVar;
            C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.FlurrySessionEvent", f14160d);
        }
    }

    @Deprecated
    /* renamed from: b */
    public static void m15869b(boolean z) {
        if (m15873e()) {
            if (z) {
                C7513ec.m16643b();
            } else {
                C7513ec.m16637a();
            }
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m15860a(int i) {
        if (m15873e()) {
            C7513ec.m16638a(i);
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m15861a(long j) {
        if (m15873e()) {
            if (j < 5000) {
                C7513ec.m16646b(f14157a, "Invalid time set for session resumption: ".concat(String.valueOf(j)));
                return;
            }
            C7602td.m16825a().mo24025a("ContinueSessionMillis", (Object) Long.valueOf(j));
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m15867a(boolean z) {
        if (m15873e()) {
            C7602td.m16825a().mo24025a("CaptureUncaughtExceptions", (Object) Boolean.valueOf(z));
        }
    }

    @Deprecated
    /* renamed from: a */
    public static synchronized void m15863a(Context context, String str) {
        synchronized (C7294e.class) {
            if (m15873e()) {
                if (!TextUtils.isEmpty(str)) {
                    if (C7379Fb.m16300a() != null) {
                        C7513ec.m16651d(f14157a, "Flurry is already initialized");
                    }
                    try {
                        C7422Md.m16415a();
                        C7379Fb.m16301a(context, str);
                    } catch (Throwable th) {
                        C7513ec.m16642a(f14157a, "", th);
                    }
                } else {
                    throw new IllegalArgumentException("API key not specified");
                }
            }
        }
    }

    /* renamed from: d */
    public static String m15872d() {
        return f14168l;
    }

    /* renamed from: c */
    public static synchronized C7290a m15871c() {
        C7290a aVar;
        synchronized (C7294e.class) {
            aVar = f14169m;
        }
        return aVar;
    }

    /* renamed from: b */
    public static void m15868b(Context context) {
        if (m15873e()) {
            m15874f();
            try {
                C7585qd.m16785a().mo24002b(context);
            } catch (Throwable th) {
                C7513ec.m16642a(f14157a, "", th);
            }
        }
    }

    /* renamed from: a */
    public static void m15862a(Context context) {
        if (m15873e()) {
            m15874f();
            try {
                C7585qd.m16785a().mo24005c(context);
            } catch (Throwable th) {
                C7513ec.m16642a(f14157a, "", th);
            }
        }
    }

    /* renamed from: a */
    public static C7296g m15858a(String str) {
        C7296g gVar = C7296g.kFlurryEventFailed;
        if (!m15873e()) {
            return gVar;
        }
        try {
            gVar = C7449Rd.m16479a().mo23891a(str, null, false, 0);
        } catch (Throwable th) {
            C7513ec.m16642a(f14157a, "Failed to log event: ".concat(String.valueOf(str)), th);
        }
        return gVar;
    }

    /* renamed from: a */
    public static C7296g m15859a(String str, Map<String, String> map) {
        C7296g gVar = C7296g.kFlurryEventFailed;
        if (!m15873e()) {
            return gVar;
        }
        try {
            gVar = C7449Rd.m16479a().mo23889a(str, map, 0);
        } catch (Throwable th) {
            C7513ec.m16642a(f14157a, "Failed to log event: ".concat(String.valueOf(str)), th);
        }
        return gVar;
    }

    /* renamed from: a */
    public static void m15866a(String str, String str2) {
        if (m15873e()) {
            if (TextUtils.isEmpty(str)) {
                C7513ec.m16646b(f14157a, "Session property name was empty");
            } else if (TextUtils.isEmpty(str2)) {
                C7513ec.m16646b(f14157a, "Session property value was empty");
            } else {
                m15874f();
                C7475Xa.m16549a();
                C7374Eb b = C7475Xa.m16550b();
                if (b != null) {
                    b.mo23808a(str, str2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static boolean m15873e() {
        if (C7354Ad.m16262a(16)) {
            return true;
        }
        C7513ec.m16646b(f14157a, String.format(Locale.getDefault(), "Device SDK Version older than %d", new Object[]{Integer.valueOf(16)}));
        return false;
    }

    /* renamed from: f */
    private static void m15874f() {
        if (C7379Fb.m16300a() == null) {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
    }
}
