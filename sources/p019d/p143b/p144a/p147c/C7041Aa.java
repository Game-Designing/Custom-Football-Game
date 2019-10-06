package p019d.p143b.p144a.p147c;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import p019d.p143b.p148b.C7240c;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Aa */
class C7041Aa implements C7240c {

    /* renamed from: a */
    private final C7142c f13139a;

    /* renamed from: b */
    private final C7262l f13140b;

    /* renamed from: c */
    private final String f13141c;

    /* renamed from: d */
    private final String f13142d;

    /* renamed from: e */
    private final Object f13143e = new Object();

    /* renamed from: f */
    private Map<String, String> f13144f;

    /* renamed from: g */
    private final Set<String> f13145g = new HashSet(5);

    /* renamed from: h */
    private final Map<String, String> f13146h = new HashMap(5);

    C7041Aa(String str, C7142c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (str != null) {
            this.f13139a = cVar;
            this.f13140b = cVar.mo23049b();
            this.f13141c = str.toLowerCase();
            StringBuilder sb = new StringBuilder();
            sb.append("applovin.mediation.");
            sb.append(str);
            sb.append(":config");
            this.f13142d = sb.toString();
        } else {
            throw new IllegalArgumentException("No classname specified");
        }
    }

    /* renamed from: a */
    private Map<String, String> m14571a() {
        C7262l lVar;
        String sb;
        String str = "MediationAdapterConfigWrapper";
        Map<String, String> map = null;
        try {
            String str2 = (String) this.f13139a.mo23040a(new C7216ub<>(this.f13142d, String.class));
            String str3 = "Last known config for '";
            if (str2 != null) {
                if (!str2.isEmpty()) {
                    map = C7167ia.m15260a(new JSONObject(str2));
                    lVar = this.f13140b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str3);
                    sb2.append(this.f13141c);
                    sb2.append("' is: ");
                    sb2.append(map);
                    sb = sb2.toString();
                    lVar.mo22918c(str, sb);
                    return map;
                }
            }
            lVar = this.f13140b;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(this.f13141c);
            sb3.append("' is missing");
            sb = sb3.toString();
            lVar.mo22918c(str, sb);
        } catch (Throwable th) {
            C7262l lVar2 = this.f13140b;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Unable to load the last known configuration for ");
            sb4.append(this.f13141c);
            lVar2.mo22917b(str, sb4.toString(), th);
        }
        return map;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22734a(Map<String, String> map) {
        synchronized (this.f13143e) {
            if (map != null) {
                if (!map.isEmpty()) {
                    this.f13144f = map;
                    mo22735b(map);
                }
            }
            this.f13144f = m14571a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo22735b(Map<String, String> map) {
        if (map != null) {
            try {
                String jSONObject = C7167ia.m15262a(map).toString();
                this.f13139a.mo23052b(new C7216ub(this.f13142d, String.class), jSONObject);
                synchronized (this.f13143e) {
                    this.f13144f = map;
                }
            } catch (Throwable th) {
                C7262l lVar = this.f13140b;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to save the last known configuration for ");
                sb.append(this.f13141c);
                lVar.mo22917b("MediationAdapterConfigWrapper", sb.toString(), th);
            }
        }
    }
}
