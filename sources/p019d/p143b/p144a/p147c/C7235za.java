package p019d.p143b.p144a.p147c;

import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p143b.p148b.C7238a;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7258h;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.za */
public class C7235za extends C7071Hc {

    /* renamed from: i */
    private final boolean f14057i = false;

    /* renamed from: j */
    private final C7238a f14058j = null;

    C7235za(JSONObject jSONObject, JSONObject jSONObject2, C7047Bc bc, C7142c cVar) {
        super(jSONObject, jSONObject2, bc, cVar);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ C7257g mo22756a() {
        return super.mo22756a();
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ long mo22758b() {
        return super.mo22758b();
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ boolean mo22402c() {
        return super.mo22402c();
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ C7258h mo22759d() {
        return super.mo22759d();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        C7235za zaVar = (C7235za) obj;
        if (this.f14057i != zaVar.f14057i) {
            return false;
        }
        C7238a aVar = this.f14058j;
        if (aVar == null) {
            if (zaVar.f14058j != null) {
                z = false;
            }
            return z;
        }
        aVar.equals(zaVar.f14058j);
        throw null;
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ long mo22404f() {
        return super.mo22404f();
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ C7063Fc mo22760g() {
        return super.mo22760g();
    }

    /* renamed from: h */
    public /* bridge */ /* synthetic */ String mo22761h() {
        return super.mo22761h();
    }

    public int hashCode() {
        int hashCode = ((super.hashCode() * 31) + (this.f14057i ? 1 : 0)) * 31;
        C7238a aVar = this.f14058j;
        if (aVar == null) {
            return hashCode + 0;
        }
        aVar.hashCode();
        throw null;
    }

    /* renamed from: n */
    public /* bridge */ /* synthetic */ C7059Ec mo22762n() {
        return super.mo22762n();
    }

    /* renamed from: q */
    public boolean mo22764q() {
        return this.f14057i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public String mo23445r() {
        return C7167ia.m15258a(this.f13233a, "class", (String) null, (C7267q) this.f13235c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public String mo23446s() {
        return C7167ia.m15258a(this.f13233a, "name", (String) null, (C7267q) this.f13235c);
    }

    /* renamed from: t */
    public C7238a mo23447t() {
        return this.f14058j;
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* renamed from: u */
    public Map<String, String> mo23448u() {
        String str = "config";
        if (this.f13233a.has(str)) {
            try {
                return C7167ia.m15260a(this.f13233a.getJSONObject(str));
            } catch (JSONException e) {
                this.f13235c.mo23049b().mo22917b("MediatedAd", "Failed to retrieve mediation configuration", e);
            }
        }
        return Collections.emptyMap();
    }

    /* renamed from: v */
    public int mo23449v() {
        return C7167ia.m15254a(this.f13233a, "timeout_sec", 5, (C7267q) this.f13235c);
    }
}
