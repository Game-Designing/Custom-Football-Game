package p019d.p143b.p144a.p147c;

import org.json.JSONObject;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Kb */
class C7082Kb extends C7161gc<JSONObject> {

    /* renamed from: s */
    final /* synthetic */ C7078Jb f13275s;

    C7082Kb(C7078Jb jb, String str, JSONObject jSONObject, String str2, C7142c cVar) {
        this.f13275s = jb;
        super(str, jSONObject, str2, cVar);
    }

    /* renamed from: a */
    public void mo22856a(int i) {
        C7262l lVar = this.f13626c;
        String a = mo23203a();
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to fetch basic SDK settings: server returned ");
        sb.append(i);
        lVar.mo22916b(a, sb.toString());
        this.f13625b.mo23048a(false);
    }

    /* renamed from: a */
    public void mo22857a(JSONObject jSONObject, int i) {
        C7202r.m15404a(jSONObject, this.f13625b);
        this.f13626c.mo22920d(mo23203a(), "Executing initialize SDK...");
        this.f13625b.mo23027C().mo22969a((C7184mb) new C7105Qb(this.f13625b));
        C7202r.m15410b(jSONObject, this.f13625b);
        this.f13626c.mo22920d(mo23203a(), "Finished executing initialize SDK");
    }
}
