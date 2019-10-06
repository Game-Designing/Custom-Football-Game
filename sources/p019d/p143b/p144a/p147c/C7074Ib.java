package p019d.p143b.p144a.p147c;

import org.json.JSONObject;

/* renamed from: d.b.a.c.Ib */
class C7074Ib extends C7161gc<JSONObject> {

    /* renamed from: s */
    final /* synthetic */ C7070Hb f13249s;

    C7074Ib(C7070Hb hb, String str, JSONObject jSONObject, String str2, C7142c cVar) {
        this.f13249s = hb;
        super(str, jSONObject, str2, cVar);
    }

    /* renamed from: a */
    public void mo22856a(int i) {
        this.f13249s.f13228h.onPostbackFailure(this.f13249s.f13226f, i);
    }

    /* renamed from: a */
    public void mo22857a(JSONObject jSONObject, int i) {
        this.f13249s.f13228h.onPostbackSuccess(this.f13249s.f13226f);
    }
}
