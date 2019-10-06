package p019d.p143b.p144a.p147c;

import org.json.JSONObject;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.dc */
class C7149dc extends C7184mb {

    /* renamed from: f */
    private final JSONObject f13494f;

    /* renamed from: g */
    private final JSONObject f13495g;

    /* renamed from: h */
    private final C7254d f13496h;

    /* renamed from: i */
    private final C7047Bc f13497i;

    C7149dc(JSONObject jSONObject, JSONObject jSONObject2, C7047Bc bc, C7254d dVar, C7142c cVar) {
        super("TaskRenderAppLovinAd", cVar);
        this.f13494f = jSONObject;
        this.f13495g = jSONObject2;
        this.f13497i = bc;
        this.f13496h = dVar;
    }

    /* renamed from: a */
    private C7113Tb m15136a(String str) {
        return "main".equalsIgnoreCase(str) ? C7113Tb.MAIN : C7113Tb.BACKGROUND;
    }

    public void run() {
        this.f13626c.mo22918c(this.f13624a, "Rendering ad...");
        C7043Ac ac = new C7043Ac(this.f13494f, this.f13495g, this.f13497i, this.f13625b);
        boolean booleanValue = C7167ia.m15256a(this.f13494f, "vs_cache_immediately", Boolean.valueOf(false), (C7267q) this.f13625b).booleanValue();
        boolean booleanValue2 = C7167ia.m15256a(this.f13494f, "vs_load_immediately", Boolean.valueOf(true), (C7267q) this.f13625b).booleanValue();
        String a = C7167ia.m15258a(this.f13494f, "vs_ad_cache_priority", "background", (C7267q) this.f13625b);
        this.f13626c.mo22918c(this.f13624a, "Creating cache task...");
        C7042Ab ab = new C7042Ab(ac, this.f13496h, this.f13625b);
        ab.mo22736a(booleanValue2);
        if (!ac.mo22405ha() || booleanValue) {
            this.f13625b.mo23027C().mo22969a((C7184mb) ab);
            return;
        }
        this.f13625b.mo23027C().mo22970a((C7184mb) ab, m15136a(a));
    }
}
