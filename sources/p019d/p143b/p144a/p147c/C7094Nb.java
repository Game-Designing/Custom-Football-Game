package p019d.p143b.p144a.p147c;

import org.json.JSONObject;

/* renamed from: d.b.a.c.Nb */
class C7094Nb extends C7161gc<JSONObject> {

    /* renamed from: s */
    final /* synthetic */ C7090Mb f13317s;

    C7094Nb(C7090Mb mb, String str, JSONObject jSONObject, String str2, C7142c cVar) {
        this.f13317s = mb;
        super(str, jSONObject, str2, cVar);
    }

    /* renamed from: a */
    public void mo22856a(int i) {
        this.f13317s.m14835b(i);
    }

    /* renamed from: a */
    public void mo22857a(JSONObject jSONObject, int i) {
        if (i == 200) {
            C7167ia.m15266b(jSONObject, "fetch_ad_latency_millis", this.f13560r.mo23226a(), this.f13625b);
            C7167ia.m15266b(jSONObject, "fetch_ad_response_size", this.f13560r.mo23227b(), this.f13625b);
            this.f13317s.m14836b(jSONObject);
            return;
        }
        this.f13317s.m14835b(i);
    }
}
