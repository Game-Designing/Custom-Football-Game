package p019d.p143b.p144a.p147c;

import java.util.Map;
import org.json.JSONObject;
import p019d.p143b.p149c.C7248b;

/* renamed from: d.b.a.c.Ob */
class C7098Ob extends C7090Mb {

    /* renamed from: i */
    private final int f13324i;

    /* renamed from: j */
    private final C7248b f13325j;

    public C7098Ob(String str, int i, C7142c cVar, C7248b bVar) {
        super(C7059Ec.m14676b(str, cVar), null, cVar);
        this.f13324i = i;
        this.f13325j = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C7184mb mo22900a(JSONObject jSONObject) {
        return new C7153ec(jSONObject, this.f13625b, this.f13325j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo22901a(Map<String, String> map) {
        return C7202r.m15407b("nad", map, this.f13625b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo22902a(int i) {
        C7248b bVar = this.f13325j;
        if (bVar != null) {
            bVar.onNativeAdsFailedToLoad(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo22904b(Map<String, String> map) {
        return C7202r.m15412d("nad", map, this.f13625b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Map<String, String> mo22905b() {
        Map<String, String> b = super.mo22905b();
        b.put("slot_count", Integer.toString(this.f13324i));
        return b;
    }
}
