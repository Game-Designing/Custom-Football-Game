package p019d.p143b.p144a.p147c;

import java.util.Arrays;
import org.json.JSONObject;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.Hc */
abstract class C7071Hc implements C7231ya, C7251a {

    /* renamed from: a */
    protected final JSONObject f13233a;

    /* renamed from: b */
    protected final JSONObject f13234b;

    /* renamed from: c */
    protected final C7142c f13235c;

    /* renamed from: d */
    protected final C7047Bc f13236d;

    /* renamed from: e */
    private C7059Ec f13237e;

    /* renamed from: f */
    protected final Object f13238f;

    /* renamed from: g */
    private final long f13239g;

    /* renamed from: h */
    private C7048C f13240h;

    C7071Hc(JSONObject jSONObject, JSONObject jSONObject2, C7047Bc bc, C7142c cVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (cVar != null) {
            this.f13233a = jSONObject;
            this.f13234b = jSONObject2;
            this.f13236d = bc;
            this.f13235c = cVar;
            this.f13238f = new Object();
            this.f13239g = System.currentTimeMillis();
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: q */
    private String mo22764q() {
        String jSONObject;
        synchronized (this.f13238f) {
            jSONObject = this.f13233a.toString();
        }
        char[] charArray = jSONObject.toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb = new StringBuilder();
        sb.append(new String(charArray));
        sb.append(mo22759d());
        sb.append(mo22756a());
        sb.append(mo22761h());
        return sb.toString();
    }

    /* renamed from: a */
    public C7257g mo22756a() {
        return C7257g.m15776a(C7167ia.m15258a(this.f13234b, "ad_size", (String) null, (C7267q) this.f13235c));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22844a(C7048C c) {
        this.f13240h = c;
    }

    /* renamed from: b */
    public long mo22758b() {
        return C7167ia.m15255a(this.f13233a, "ad_id", -1, (C7267q) this.f13235c);
    }

    /* renamed from: c */
    public boolean mo22402c() {
        this.f13235c.mo23049b().mo22916b("AppLovinAdBase", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    /* renamed from: d */
    public C7258h mo22759d() {
        return C7258h.m15781a(C7167ia.m15258a(this.f13234b, "ad_type", (String) null, (C7267q) this.f13235c));
    }

    /* renamed from: e */
    public boolean mo22845e() {
        String str = "is_video_ad";
        return this.f13233a.has(str) ? C7167ia.m15256a(this.f13233a, str, Boolean.valueOf(false), (C7267q) this.f13235c).booleanValue() : mo22402c();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C7048C) {
            Object r = ((C7048C) obj).mo22765r();
            if (r != null) {
                obj = r;
            }
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C7071Hc hc = (C7071Hc) obj;
        C7059Ec ec = this.f13237e;
        if (ec == null ? hc.f13237e != null : !ec.equals(hc.f13237e)) {
            return false;
        }
        if (this.f13236d != hc.f13236d) {
            return false;
        }
        return mo22764q().equals(hc.mo22764q());
    }

    /* renamed from: f */
    public long mo22404f() {
        return this.f13239g;
    }

    /* renamed from: g */
    public C7063Fc mo22760g() {
        return C7063Fc.m14702a(C7167ia.m15258a(this.f13234b, "type", C7063Fc.f13210b.toString(), (C7267q) this.f13235c));
    }

    /* renamed from: h */
    public String mo22761h() {
        String str = "";
        String str2 = "clcode";
        String a = C7167ia.m15258a(this.f13233a, str2, str, (C7267q) this.f13235c);
        return C7269s.m15819a(a) ? a : C7167ia.m15258a(this.f13234b, str2, str, (C7267q) this.f13235c);
    }

    public int hashCode() {
        return this.f13237e.hashCode() + mo22764q().hashCode() + this.f13236d.ordinal();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public String mo22846i() {
        return C7167ia.m15258a(this.f13233a, "pk", "NA", (C7267q) this.f13235c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public String mo22847j() {
        return C7167ia.m15258a(this.f13233a, "sk1", (String) null, (C7267q) this.f13235c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public String mo22848k() {
        return C7167ia.m15258a(this.f13233a, "sk2", (String) null, (C7267q) this.f13235c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public long mo22849l() {
        return C7167ia.m15255a(this.f13234b, "fetch_ad_latency_millis", -1, (C7267q) this.f13235c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public long mo22850m() {
        return C7167ia.m15255a(this.f13234b, "fetch_ad_response_size", -1, (C7267q) this.f13235c);
    }

    /* renamed from: n */
    public C7059Ec mo22762n() {
        C7059Ec ec = this.f13237e;
        if (ec != null) {
            return ec;
        }
        this.f13237e = C7059Ec.m14671a(mo22756a(), mo22759d(), mo22760g(), C7167ia.m15258a(this.f13234b, "zone_id", (String) null, (C7267q) this.f13235c), this.f13235c);
        return this.f13237e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public C7047Bc mo22763o() {
        return this.f13236d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: p */
    public C7048C mo22851p() {
        return this.f13240h;
    }

    public String toString() {
        String jSONObject;
        synchronized (this.f13238f) {
            jSONObject = this.f13233a.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(getClass().getSimpleName());
        sb.append(" #");
        sb.append(mo22758b());
        sb.append(" adType=");
        sb.append(mo22759d());
        sb.append(", adSize=");
        sb.append(mo22756a());
        sb.append(", source=");
        sb.append(mo22763o());
        sb.append(", adObject=");
        sb.append(jSONObject);
        sb.append("]");
        return sb.toString();
    }
}
