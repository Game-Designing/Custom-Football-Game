package com.inmobi.ads.p212c;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import com.inmobi.ads.C10455bi;
import com.inmobi.ads.C10456bj;
import com.inmobi.ads.C10478c;
import com.inmobi.ads.C10537f;
import com.inmobi.ads.C10545i;
import com.inmobi.ads.C10545i.C10578e;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.p225b.C10691b;
import com.inmobi.commons.p217a.C10619a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.inmobi.ads.c.a */
/* compiled from: AdPreFetcher */
public class C10491a implements C10644c {

    /* renamed from: a */
    public static ConcurrentHashMap<C10455bi, C10545i> f31975a = new ConcurrentHashMap<>(8, 0.9f, 3);

    /* renamed from: b */
    public static C10478c f31976b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String f31977d = C10491a.class.getSimpleName();

    /* renamed from: e */
    private static volatile C10491a f31978e;

    /* renamed from: f */
    private static volatile C10491a f31979f;

    /* renamed from: g */
    private static volatile C10491a f31980g;

    /* renamed from: h */
    private static final Object f31981h = new Object();

    /* renamed from: i */
    private static final Object f31982i = new Object();

    /* renamed from: j */
    private static final Object f31983j = new Object();

    /* renamed from: c */
    public String f31984c;

    /* renamed from: com.inmobi.ads.c.a$a */
    /* compiled from: AdPreFetcher */
    static class C10499a implements C10578e {

        /* renamed from: a */
        private C10455bi f31999a;

        C10499a(C10455bi biVar) {
            this.f31999a = biVar;
        }

        /* renamed from: a */
        public final void mo33744a(C10545i iVar) {
            C10491a.f31977d;
            C10491a.f31975a.remove(this.f31999a);
        }

        /* renamed from: a */
        public final void mo33745a(C10545i iVar, InMobiAdRequestStatus inMobiAdRequestStatus) {
            C10491a.f31977d;
            new StringBuilder("onAdLoadFailed called. Status:").append(inMobiAdRequestStatus.getMessage());
            C10491a.f31975a.remove(this.f31999a);
            if (StatusCode.NO_FILL.equals(inMobiAdRequestStatus.getStatusCode())) {
                iVar.mo34296d("PreLoadServerNoFill");
            }
        }
    }

    /* renamed from: d */
    private static C10491a m34330d() {
        C10491a aVar = f31978e;
        if (aVar == null) {
            synchronized (f31981h) {
                aVar = f31978e;
                if (aVar == null) {
                    aVar = new C10491a("banner");
                    f31978e = aVar;
                }
            }
        }
        return aVar;
    }

    /* renamed from: e */
    private static C10491a m34331e() {
        C10491a aVar = f31979f;
        if (aVar == null) {
            synchronized (f31982i) {
                aVar = f31979f;
                if (aVar == null) {
                    aVar = new C10491a("int");
                    f31979f = aVar;
                }
            }
        }
        return aVar;
    }

    /* renamed from: f */
    private static C10491a m34332f() {
        C10491a aVar = f31980g;
        if (aVar == null) {
            synchronized (f31983j) {
                aVar = f31980g;
                if (aVar == null) {
                    aVar = new C10491a("native");
                    f31980g = aVar;
                }
            }
        }
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.inmobi.ads.p212c.C10491a m34323a(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1396342996(0xffffffffacc57f2c, float:-5.6131957E-12)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -1052618729(0xffffffffc1425017, float:-12.144553)
            if (r0 == r1) goto L_0x0020
            r1 = 104431(0x197ef, float:1.46339E-40)
            if (r0 == r1) goto L_0x0016
        L_0x0015:
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "int"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0015
            r4 = 2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "native"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0015
            r4 = 1
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "banner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0015
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x004d
            if (r4 == r3) goto L_0x0048
            if (r4 != r2) goto L_0x0040
            com.inmobi.ads.c.a r4 = m34331e()
            return r4
        L_0x0040:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Unknown adType passed"
            r4.<init>(r0)
            throw r4
        L_0x0048:
            com.inmobi.ads.c.a r4 = m34332f()
            return r4
        L_0x004d:
            com.inmobi.ads.c.a r4 = m34330d()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.p212c.C10491a.m34323a(java.lang.String):com.inmobi.ads.c.a");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[Catch:{ IllegalStateException -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004a A[Catch:{ IllegalStateException -> 0x004f }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.inmobi.ads.C10545i m34328b(java.lang.String r6, android.content.Context r7, com.inmobi.ads.C10455bi r8) {
        /*
            r0 = -1
            r1 = 0
            int r2 = r6.hashCode()     // Catch:{ IllegalStateException -> 0x004f }
            r3 = -1396342996(0xffffffffacc57f2c, float:-5.6131957E-12)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L_0x002c
            r3 = -1052618729(0xffffffffc1425017, float:-12.144553)
            if (r2 == r3) goto L_0x0022
            r3 = 104431(0x197ef, float:1.46339E-40)
            if (r2 == r3) goto L_0x0018
        L_0x0017:
            goto L_0x0035
        L_0x0018:
            java.lang.String r2 = "int"
            boolean r6 = r6.equals(r2)     // Catch:{ IllegalStateException -> 0x004f }
            if (r6 == 0) goto L_0x0017
            r0 = 1
            goto L_0x0035
        L_0x0022:
            java.lang.String r2 = "native"
            boolean r6 = r6.equals(r2)     // Catch:{ IllegalStateException -> 0x004f }
            if (r6 == 0) goto L_0x0017
            r0 = 2
            goto L_0x0035
        L_0x002c:
            java.lang.String r2 = "banner"
            boolean r6 = r6.equals(r2)     // Catch:{ IllegalStateException -> 0x004f }
            if (r6 == 0) goto L_0x0017
            r0 = 0
        L_0x0035:
            if (r0 == 0) goto L_0x004a
            if (r0 == r5) goto L_0x0041
            if (r0 == r4) goto L_0x003c
            goto L_0x0053
        L_0x003c:
            com.inmobi.ads.aj r6 = com.inmobi.ads.C10396aj.m34024a(r7, r8, r1, r5)     // Catch:{ IllegalStateException -> 0x004f }
            return r6
        L_0x0041:
            android.content.Context r6 = com.inmobi.commons.p217a.C10619a.m34839b()     // Catch:{ IllegalStateException -> 0x004f }
            com.inmobi.ads.ac r6 = com.inmobi.ads.C10365ac.C10372a.m33886a(r6, r8, r1)     // Catch:{ IllegalStateException -> 0x004f }
            return r6
        L_0x004a:
            com.inmobi.ads.p r6 = com.inmobi.ads.C10591p.m34724a(r7, r8, r1, r5)     // Catch:{ IllegalStateException -> 0x004f }
            return r6
        L_0x004f:
            r6 = move-exception
            r6.getMessage()
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.p212c.C10491a.m34328b(java.lang.String, android.content.Context, com.inmobi.ads.bi):com.inmobi.ads.i");
    }

    C10491a(String str) {
        this.f31984c = str;
        f31976b = new C10478c();
        C10641b.m34915a().mo34452a((C10639a) f31976b, (C10644c) this);
        C10659b.m34983a().mo34486a("ads", f31976b.f31900l);
    }

    /* renamed from: a */
    public final void mo33666a(C10639a aVar) {
        f31976b = (C10478c) aVar;
        C10659b.m34983a().mo34486a("ads", f31976b.f31900l);
    }

    /* renamed from: g */
    private void m34333g() {
        Iterator it = f31975a.entrySet().iterator();
        while (it.hasNext()) {
            try {
                Entry entry = (Entry) it.next();
                final C10545i iVar = (C10545i) entry.getValue();
                if (iVar.mo34300h()) {
                    StringBuilder sb = new StringBuilder("cleanUpExpiredCachedAdUnits. pid:");
                    sb.append(((C10455bi) entry.getKey()).f31801a);
                    sb.append(" tp:");
                    sb.append(((C10455bi) entry.getKey()).f31802b);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            try {
                                iVar.mo33995v();
                            } catch (Exception e) {
                                C10491a.f31977d;
                                new StringBuilder("Encountered an unexpected error clearing the ad unit: ").append(e.getMessage());
                                Logger.m35065a(InternalLogLevel.DEBUG, "InMobi", "SDK encountered an unexpected error clearing an old ad");
                                C10621a.m34854a().mo34423a(new C10658a(e));
                            }
                        }
                    });
                    it.remove();
                }
            } catch (Exception e) {
                new StringBuilder("SDK encountered an unexpected error in expiring ad units; ").append(e.getMessage());
                C10621a.m34854a().mo34423a(new C10658a(e));
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo34210a() {
        Application application = (Application) C10619a.m34839b();
        if (application != null) {
            application.registerComponentCallbacks(new ComponentCallbacks2() {
                public final void onTrimMemory(int i) {
                    if (i == 15) {
                        C10491a.m34326a(C10491a.this);
                    }
                }

                public final void onConfigurationChanged(Configuration configuration) {
                }

                public final void onLowMemory() {
                }
            });
        }
        m34334h();
        m34333g();
        if (f31976b.mo34205c(this.f31984c).f31940a) {
            C10456bj.m34231a();
            ArrayList arrayList = (ArrayList) C10456bj.m34232a(this.f31984c);
            for (int i = 0; i < arrayList.size(); i++) {
                final C10455bi biVar = (C10455bi) arrayList.get(i);
                new Handler(Looper.getMainLooper()).post(new Runnable() {

                    /* renamed from: c */
                    private C10578e f31987c;

                    public final void run() {
                        try {
                            Context b = C10619a.m34839b();
                            if (b != null) {
                                C10491a.f31977d;
                                StringBuilder sb = new StringBuilder("preFetchAdUnit. pid:");
                                sb.append(biVar.f31801a);
                                sb.append(" tp:");
                                sb.append(biVar.f31802b);
                                if (biVar.f31803c == null && biVar.f31802b != null) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("tp", biVar.f31802b);
                                    biVar.f31803c = hashMap;
                                }
                                this.f31987c = new C10499a(biVar);
                                C10545i a = C10491a.m34328b(C10491a.this.f31984c, b, biVar);
                                if (a != null) {
                                    a.f32169e = biVar.f31804d;
                                    a.f32170f = biVar.f31803c;
                                    a.f32178n = true;
                                    a.f32181q = this.f31987c;
                                    a.mo34081a(true);
                                }
                            }
                        } catch (Exception e) {
                            C10491a.f31977d;
                            new StringBuilder("SDK encountered an unexpected error preloading ad units; ").append(e.getMessage());
                            C10621a.m34854a().mo34423a(new C10658a(e));
                        }
                    }
                });
            }
        }
    }

    /* renamed from: b */
    public final void mo34212b() {
        m34334h();
        m34333g();
    }

    /* renamed from: a */
    public final void mo34211a(final C10455bi biVar) {
        if (f31976b.mo34205c(this.f31984c).f31940a) {
            new Thread() {
                public final void run() {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(biVar);
                    int a = C10456bj.m34231a().mo34168a((List<C10455bi>) arrayList, C10491a.f31976b.mo34205c(C10491a.this.f31984c).f31942c);
                    if (a > 0) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("count", Integer.valueOf(a));
                        hashMap.put("type", C10491a.this.f31984c);
                        hashMap.put("plId", Long.valueOf(biVar.f31801a));
                        C10659b.m34983a();
                        C10659b.m34987a("ads", "PreLoadPidOverflow", hashMap);
                    }
                }
            }.start();
        }
    }

    /* renamed from: h */
    private void m34334h() {
        if (f31976b.mo34205c(this.f31984c).f31940a) {
            C10456bj.m34231a();
            int a = C10456bj.m34230a(f31976b.mo34205c(this.f31984c).f31941b, this.f31984c);
            if (a > 0) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", this.f31984c);
                    hashMap.put("count", Integer.valueOf(a));
                    C10659b.m34983a();
                    C10659b.m34987a("ads", "PreLoadPidExpiry", hashMap);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                    sb.append(e.getMessage());
                    sb.append(")");
                }
            }
        }
    }

    /* renamed from: a */
    public static String m34325a(Map<String, String> map) {
        String str = "";
        if (map == null) {
            return str;
        }
        String str2 = "tp";
        if (((String) map.get(str2)) == null) {
            return str;
        }
        return (String) map.get(str2);
    }

    /* renamed from: a */
    public static void m34327a(String str, Map<String, Object> map, C10537f fVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", fVar.f32121e);
        hashMap.put("plId", Long.valueOf(fVar.f32117a));
        hashMap.put("isPreloaded", Integer.valueOf(1));
        hashMap.put("networkType", Integer.valueOf(C10691b.m35099a()));
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        String str2 = "clientRequestId";
        if (map.get(str2) == null) {
            hashMap.put(str2, fVar.f32125i);
        }
        for (Entry entry : map.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        try {
            C10659b.m34983a();
            C10659b.m34987a("ads", str, hashMap);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
            sb.append(e.getMessage());
            sb.append(")");
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m34326a(C10491a aVar) {
        Context b = C10619a.m34839b();
        if (b != null) {
            new Handler(b.getMainLooper()).post(new Runnable() {
                public final void run() {
                    try {
                        C10491a.f31977d;
                        Iterator it = C10491a.f31975a.entrySet().iterator();
                        while (it.hasNext()) {
                            ((C10545i) ((Entry) it.next()).getValue()).mo33995v();
                            it.remove();
                        }
                    } catch (Exception e) {
                        C10491a.f31977d;
                        new StringBuilder("SDK encountered unexpected error in flushing ad unit cache; ").append(e.getMessage());
                        C10621a.m34854a().mo34423a(new C10658a(e));
                    }
                }
            });
        }
    }
}
