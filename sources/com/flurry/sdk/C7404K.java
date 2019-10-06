package com.flurry.sdk;

import com.flurry.sdk.C7577pc.C7578a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.K */
public class C7404K extends C7353Ac<C7423N> {
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final String f14517k = C7404K.class.getSimpleName();

    /* renamed from: l */
    public static long f14518l;

    /* renamed from: com.flurry.sdk.K$a */
    static class C7405a {

        /* renamed from: a */
        private static HashMap<C7552la, String> f14519a;

        static {
            HashMap<C7552la, String> hashMap = new HashMap<>();
            f14519a = hashMap;
            hashMap.put(C7552la.INSTALL, "Install");
            f14519a.put(C7552la.SESSION_START, "Session Start");
            f14519a.put(C7552la.SESSION_END, "Session End");
            f14519a.put(C7552la.APPLICATION_EVENT, "App Event");
        }

        /* renamed from: a */
        static void m16392a(String str, String str2, C7552la laVar) {
            if (!C7449Rd.m16479a().f14641f) {
                C7513ec.m16639a(4, C7404K.f14517k, "Not yahoo app. Don't log event Flurry.PulseSuccess");
                return;
            }
            HashMap hashMap = new HashMap(3);
            hashMap.put("fl.Partner", str);
            hashMap.put("fl.Event", str2);
            hashMap.put("fl.Trigger", m16391a(laVar));
            try {
                C7449Rd.m16479a().mo23890a("Flurry.PulseSuccess", (Map<String, String>) hashMap, false);
            } catch (Throwable th) {
                C7513ec.m16642a(C7404K.f14517k, "Failed to log event: Flurry.PulseSuccess", th);
            }
        }

        /* renamed from: b */
        static void m16393b(String str, String str2, C7552la laVar) {
            if (!C7449Rd.m16479a().f14641f) {
                C7513ec.m16639a(4, C7404K.f14517k, "Not yahoo app. Don't log event Flurry.PulseFail");
                return;
            }
            HashMap hashMap = new HashMap(3);
            hashMap.put("fl.Partner", str);
            hashMap.put("fl.Event", str2);
            hashMap.put("fl.Trigger", m16391a(laVar));
            try {
                C7449Rd.m16479a().mo23890a("Flurry.PulseFail", (Map<String, String>) hashMap, false);
            } catch (Throwable th) {
                C7513ec.m16642a(C7404K.f14517k, "Failed to log event: Flurry.PulseFail", th);
            }
        }

        /* renamed from: a */
        private static String m16391a(C7552la laVar) {
            String str = (String) f14519a.get(laVar);
            if (str == null) {
                return "Unknown";
            }
            return str;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo23797a(C7589rc rcVar) {
        long j;
        long j2;
        C7423N n = (C7423N) rcVar;
        String str = f14517k;
        StringBuilder sb = new StringBuilder("Sending next pulse report to ");
        sb.append(n.f14563s);
        sb.append(" at: ");
        sb.append(n.f15063e);
        C7513ec.m16639a(3, str, sb.toString());
        C7475Xa.m16549a();
        long c = C7475Xa.m16551c();
        if (c == 0) {
            j = f14518l;
        } else {
            j = c;
        }
        C7475Xa.m16549a();
        long f = C7475Xa.m16554f();
        if (f == 0) {
            j2 = System.currentTimeMillis() - j;
        } else {
            j2 = f;
        }
        C7440Q q = new C7440Q(n, j, j2, n.f15061c);
        C7554lc lcVar = new C7554lc();
        lcVar.f15002i = n.f15063e;
        lcVar.f14426d = 100000;
        if (n.f14555k.equals(C7546ka.f14904c)) {
            lcVar.f14937F = new C7468Vc();
            String str2 = n.f14562r;
            if (str2 != null) {
                lcVar.f14935D = str2.getBytes();
            }
            lcVar.f15003j = C7578a.kPost;
        } else {
            lcVar.f15003j = C7578a.kGet;
        }
        int i = n.f14560p;
        lcVar.f15004k = i * 1000;
        int i2 = n.f14561q;
        lcVar.f15005l = i2 * 1000;
        lcVar.f15013t = true;
        lcVar.f15018y = true;
        lcVar.f15019z = (i + i2) * 1000;
        Map<String, String> map = n.f14556l;
        if (map != null) {
            for (String str3 : map.keySet()) {
                lcVar.mo23988a(str3, (String) map.get(str3));
            }
        }
        lcVar.f15008o = false;
        lcVar.f14934C = new C7399J(this, n, q);
        C7633zb.m16869a().mo23939a((Object) this, lcVar);
    }

    public C7404K() {
        C7353Ac.f14365b = 30000;
    }

    /* renamed from: a */
    public final C7443Qb<List<C7423N>> mo23796a() {
        String str = ".yflurryanpulsecallbackreporter";
        return new C7443Qb<>(C7379Fb.m16300a().f14432d.getFileStreamPath(str), str, 2, new C7393I(this));
    }

    /* renamed from: a */
    public final synchronized void mo23798a(List<C7423N> list) {
        C7490aa.m16578c();
        List<C7505da> d = C7490aa.m16581d();
        if (d != null) {
            if (d.size() != 0) {
                String str = f14517k;
                StringBuilder sb = new StringBuilder("Restoring ");
                sb.append(d.size());
                sb.append(" from report queue.");
                C7513ec.m16639a(3, str, sb.toString());
                for (C7505da b : d) {
                    C7490aa.m16578c().mo23932b(b);
                }
                C7490aa.m16578c();
                for (C7505da a : C7490aa.m16576b()) {
                    for (C7423N n : a.mo23941a()) {
                        if (!n.f14564t) {
                            String str2 = f14517k;
                            StringBuilder sb2 = new StringBuilder("Callback for ");
                            sb2.append(n.f14558n.f14792h);
                            sb2.append(" to ");
                            sb2.append(n.f14563s);
                            sb2.append(" not completed.  Adding to reporter queue.");
                            C7513ec.m16639a(3, str2, sb2.toString());
                            list.add(n);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final synchronized void mo23800b(List<C7423N> list) {
        C7490aa.m16578c().mo23927a();
    }

    /* renamed from: a */
    static /* synthetic */ void m16382a(C7404K k, C7440Q q, C7423N n) {
        C7490aa.m16578c().mo23931b(q);
        k.mo23801c(n);
    }

    /* renamed from: a */
    static /* synthetic */ void m16384a(C7404K k, C7440Q q, C7423N n, String str) {
        boolean b = C7490aa.m16578c().mo23933b(q, str);
        C7513ec.m16639a(3, f14517k, "Failed report retrying: ".concat(String.valueOf(b)));
        if (b) {
            k.mo23802d(n);
        } else {
            k.mo23801c(n);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m16386b(C7404K k, C7440Q q, C7423N n) {
        String str = f14517k;
        StringBuilder sb = new StringBuilder();
        sb.append(n.f14558n.f14792h);
        sb.append(" report sent successfully to : ");
        sb.append(n.f14563s);
        C7513ec.m16639a(3, str, sb.toString());
        C7490aa.m16578c().mo23928a(q);
        k.mo23801c(n);
    }

    /* renamed from: a */
    static /* synthetic */ void m16383a(C7404K k, C7440Q q, C7423N n, C7554lc lcVar) {
        String str;
        String str2 = "Location";
        List a = lcVar.mo23987a(str2);
        if (a == null || a.size() <= 0) {
            str = null;
        } else {
            str = C7381Fd.m16309a((String) a.get(0), n.f15062d);
        }
        boolean a2 = C7490aa.m16578c().mo23930a(q, str);
        if (a2) {
            C7513ec.m16639a(3, f14517k, "Received redirect url. Retrying: ".concat(String.valueOf(str)));
        } else {
            C7513ec.m16639a(3, f14517k, "Received redirect url. Retrying: false");
        }
        if (a2) {
            n.f15063e = str;
            lcVar.f15002i = str;
            C7426Nb<String, String> nb = lcVar.f15000g;
            if (nb != null && nb.f14567a.containsKey(str2)) {
                lcVar.f15000g.mo23868b(str2);
            }
            C7633zb.m16869a().mo23939a((Object) k, lcVar);
            return;
        }
        k.mo23801c(n);
    }
}
