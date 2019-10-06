package p019d.p143b.p144a.p147c;

import org.json.JSONObject;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.ka */
class C7175ka extends C7161gc<JSONObject> {

    /* renamed from: s */
    final /* synthetic */ C7072I f13605s;

    C7175ka(C7072I i, String str, JSONObject jSONObject, String str2, C7142c cVar) {
        this.f13605s = i;
        super(str, jSONObject, str2, cVar);
    }

    /* renamed from: a */
    public void mo22856a(int i) {
        C7262l lVar = this.f13626c;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to submitted ad stats: ");
        sb.append(i);
        lVar.mo22916b("AdEventStatsManager", sb.toString());
    }

    /* renamed from: a */
    public void mo22857a(JSONObject jSONObject, int i) {
        C7262l lVar = this.f13626c;
        StringBuilder sb = new StringBuilder();
        sb.append("Ad stats submitted: ");
        sb.append(i);
        lVar.mo22918c("AdEventStatsManager", sb.toString());
    }
}
