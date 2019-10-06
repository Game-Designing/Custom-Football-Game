package p019d.p143b.p144a.p147c;

import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.I */
class C7072I {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7142c f13241a;

    /* renamed from: b */
    private final C7262l f13242b;

    /* renamed from: c */
    private final Object f13243c = new Object();

    /* renamed from: d */
    private final C7176kb f13244d = new C7176kb(this, null);

    C7072I(C7142c cVar) {
        if (cVar != null) {
            this.f13241a = cVar;
            this.f13242b = cVar.mo23049b();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    private C7081Ka m14759a(C7071Hc hc) {
        C7081Ka ka;
        synchronized (this.f13243c) {
            String i = hc.mo22846i();
            ka = (C7081Ka) this.f13244d.get(i);
            if (ka == null) {
                ka = new C7081Ka(i, hc.mo22847j(), hc.mo22848k(), null);
                this.f13244d.put(i, ka);
            }
        }
        return ka;
    }

    /* renamed from: a */
    private void m14761a(JSONObject jSONObject) {
        C7175ka kaVar = new C7175ka(this, "POST", new JSONObject(), "RepeatSubmitAdEvents", this.f13241a);
        kaVar.mo23150a(m14762c());
        kaVar.mo23151a(jSONObject);
        kaVar.mo23155b(m14763d());
        kaVar.mo23153b(((Integer) this.f13241a.mo23039a(C7196pb.f13733Nd)).intValue());
        kaVar.mo23156c(((Integer) this.f13241a.mo23039a(C7196pb.f13738Od)).intValue());
        kaVar.mo23149a(C7196pb.f13857o);
        kaVar.mo23154b(C7196pb.f13877s);
        this.f13241a.mo23027C().mo22970a((C7184mb) kaVar, C7113Tb.BACKGROUND);
    }

    /* renamed from: c */
    private String m14762c() {
        return C7202r.m15401a("s", null, this.f13241a);
    }

    /* renamed from: d */
    private String m14763d() {
        return C7202r.m15411c("s", null, this.f13241a);
    }

    /* renamed from: e */
    private void m14764e() {
        HashSet hashSet;
        synchronized (this.f13243c) {
            hashSet = new HashSet(this.f13244d.size());
            for (C7081Ka ka : this.f13244d.values()) {
                try {
                    String a = ka.m14810b();
                    if (a != null) {
                        hashSet.add(a);
                    }
                } catch (JSONException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to serialize ");
                    sb.append(ka);
                    this.f13242b.mo22917b("AdEventStatsManager", sb.toString(), e);
                }
            }
        }
        this.f13241a.mo23052b(C7216ub.f13982i, hashSet);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22852a() {
        String str;
        C7262l lVar;
        if (((Boolean) this.f13241a.mo23039a(C7196pb.f13728Md)).booleanValue()) {
            String str2 = "AdEventStatsManager";
            if (C7182m.m15322b()) {
                Set<String> set = (Set) this.f13241a.mo23041a(C7216ub.f13982i, new HashSet(0));
                this.f13241a.mo23051b(C7216ub.f13982i);
                if (set == null || set.isEmpty()) {
                    lVar = this.f13242b;
                    str = "No serialized ad events found";
                } else {
                    C7262l lVar2 = this.f13242b;
                    StringBuilder sb = new StringBuilder();
                    sb.append("De-serializing ");
                    sb.append(set.size());
                    sb.append(" stat ad events");
                    lVar2.mo22918c(str2, sb.toString());
                    JSONArray jSONArray = new JSONArray();
                    for (String str3 : set) {
                        try {
                            jSONArray.put(new JSONObject(str3));
                        } catch (JSONException e) {
                            C7262l lVar3 = this.f13242b;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed to parse: ");
                            sb2.append(str3);
                            lVar3.mo22917b(str2, sb2.toString(), e);
                        }
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("stats", jSONArray);
                        m14761a(jSONObject);
                        return;
                    } catch (JSONException e2) {
                        this.f13242b.mo22917b(str2, "Failed to create stats to submit", e2);
                        return;
                    }
                }
            } else {
                lVar = this.f13242b;
                str = "Not loading new event stat due to old Android version...";
            }
            lVar.mo22918c(str2, str);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22853a(C7162h hVar, long j, C7071Hc hc) {
        if (hc == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (hVar == null) {
            throw new IllegalArgumentException("No key specified");
        } else if (((Boolean) this.f13241a.mo23039a(C7196pb.f13728Md)).booleanValue()) {
            synchronized (this.f13243c) {
                m14759a(hc).mo22879a(hVar.mo23158a(), j);
            }
            m14764e();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo22854b() {
        synchronized (this.f13243c) {
            this.f13244d.clear();
        }
    }
}
