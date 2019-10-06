package p019d.p143b.p144a.p147c;

import android.net.Uri;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import p005cm.aptoide.p006pt.BuildConfig;
import p019d.p143b.p150d.C7261k;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.d */
public class C7146d implements C7261k {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7142c f13489a;

    /* renamed from: b */
    private final List<String> f13490b;

    public C7146d(C7267q qVar) {
        C7142c cVar = (C7142c) qVar;
        this.f13489a = cVar;
        this.f13490b = C7178l.m15309a((String) cVar.mo23039a(C7196pb.f13750Rb));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m15120a() {
        return (String) this.f13489a.mo23039a(C7196pb.f13872r);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public HashMap<String, String> m15123a(C7168ib ibVar, C7218v vVar) {
        C7206s o = this.f13489a.mo23070o();
        C7230y a = o.mo23240a();
        C7222w c = o.mo23244c();
        boolean contains = this.f13490b.contains(ibVar.mo23170a());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("event", contains ? C7209sc.m15487d(ibVar.mo23170a()) : "postinstall");
        hashMap.put("ts", Long.toString(ibVar.mo23172c()));
        hashMap.put("platform", C7209sc.m15487d(a.f14026c));
        hashMap.put("model", C7209sc.m15487d(a.f14024a));
        hashMap.put("package_name", C7209sc.m15487d(c.f14009c));
        hashMap.put("installer_name", C7209sc.m15487d(c.f14010d));
        hashMap.put("sdk_key", this.f13489a.mo23079x());
        hashMap.put("ia", Long.toString(c.f14011e));
        hashMap.put("api_did", this.f13489a.mo23039a(C7196pb.f13822h));
        hashMap.put("brand", C7209sc.m15487d(a.f14027d));
        hashMap.put("brand_name", C7209sc.m15487d(a.f14028e));
        hashMap.put("hardware", C7209sc.m15487d(a.f14029f));
        hashMap.put("revision", C7209sc.m15487d(a.f14030g));
        hashMap.put("sdk_version", BuildConfig.APPLOVIN_SDK_VERSION);
        hashMap.put("os", C7209sc.m15487d(a.f14025b));
        hashMap.put("orientation_lock", a.f14035l);
        hashMap.put("app_version", C7209sc.m15487d(c.f14008b));
        hashMap.put("country_code", C7209sc.m15487d(a.f14032i));
        hashMap.put("carrier", C7209sc.m15487d(a.f14033j));
        hashMap.put("tz_offset", String.valueOf(a.f14038o));
        boolean z = a.f14040q;
        String str = "1";
        String str2 = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
        hashMap.put("adr", z ? str : str2);
        hashMap.put("volume", String.valueOf(a.f14042s));
        if (!a.f14044u) {
            str = str2;
        }
        hashMap.put("sim", str);
        hashMap.put("gy", String.valueOf(a.f14045v));
        m15127a(vVar, (Map<String, String>) hashMap);
        Boolean bool = a.f14046w;
        if (bool != null) {
            hashMap.put("huc", bool.toString());
        }
        Boolean bool2 = a.f14047x;
        if (bool2 != null) {
            hashMap.put("aru", bool2.toString());
        }
        C7226x xVar = a.f14041r;
        if (xVar != null) {
            hashMap.put("act", String.valueOf(xVar.f14017a));
            hashMap.put("acm", String.valueOf(xVar.f14018b));
        }
        String str3 = a.f14043t;
        if (C7269s.m15819a(str3)) {
            hashMap.put("ua", C7209sc.m15487d(str3));
        }
        if (!contains) {
            hashMap.put("sub_event", C7209sc.m15487d(ibVar.mo23170a()));
        }
        hashMap.put("sc", C7209sc.m15487d((String) this.f13489a.mo23039a(C7196pb.f13674C)));
        return hashMap;
    }

    /* renamed from: a */
    private Map<String, String> m15124a(Map<String, String> map) {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (!(key instanceof String) || !(value instanceof String)) {
                    C7262l b = this.f13489a.mo23049b();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected class type in trackEvent(); all keys and values passed as parameters must be String. Encountered ");
                    sb.append(key.getClass().getCanonicalName());
                    sb.append("/");
                    sb.append(value.getClass().getCanonicalName());
                    sb.append("; will use toString() value instead, which may be unexpected...");
                    b.mo22913a("EventServiceImpl", sb.toString());
                    str = key.toString();
                    str2 = value.toString();
                } else {
                    str = (String) key;
                    str2 = (String) value;
                }
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m15125a(C7066Gb gb) {
        this.f13489a.mo23027C().mo22970a((C7184mb) new C7062Fb(this.f13489a, gb), C7113Tb.BACKGROUND);
    }

    /* renamed from: a */
    private void m15126a(C7168ib ibVar, boolean z) {
        if (((Boolean) this.f13489a.mo23039a(C7196pb.f13754Sb)).booleanValue()) {
            C7262l b = this.f13489a.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Tracking event: ");
            sb.append(ibVar);
            b.mo22918c("EventServiceImpl", sb.toString());
            m15125a((C7066Gb) new C7056E(this, ibVar, z));
        }
    }

    /* renamed from: a */
    private void m15127a(C7218v vVar, Map<String, String> map) {
        String str = vVar.f13994b;
        if (C7269s.m15819a(str)) {
            map.put("idfa", str);
        }
        map.put("dnt", Boolean.toString(vVar.f13993a));
    }

    /* renamed from: a */
    private void m15128a(String str, Map<String, String> map, boolean z) {
        C7168ib ibVar = new C7168ib(str, m15124a(map), System.currentTimeMillis(), C7209sc.m15485c(UUID.randomUUID().toString()));
        m15126a(ibVar, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public Uri m15129b(String str, Map<String, String> map) {
        try {
            return Uri.parse(str).buildUpon().encodedQuery(C7209sc.m15471a(map)).build();
        } catch (Throwable th) {
            this.f13489a.mo23049b().mo22917b("EventServiceImpl", "Unable to create postback uri due to invalid endpoint", th);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m15130b() {
        return (String) this.f13489a.mo23039a(C7196pb.f13887u);
    }

    /* renamed from: a */
    public void mo23089a(String str) {
        mo23090a(str, (Map<String, String>) new HashMap<String,String>());
    }

    /* renamed from: a */
    public void mo23090a(String str, Map<String, String> map) {
        m15128a(str, map, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23091a(String str, boolean z) {
        m15128a(str, (Map<String, String>) new HashMap<String,String>(), z);
    }
}
