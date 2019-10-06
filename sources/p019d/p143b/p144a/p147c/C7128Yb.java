package p019d.p143b.p144a.p147c;

import org.json.JSONArray;
import org.json.JSONObject;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.Yb */
class C7128Yb extends C7184mb {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final JSONObject f13413f;

    /* renamed from: g */
    private final C7059Ec f13414g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C7047Bc f13415h;

    /* renamed from: i */
    private final C7254d f13416i;

    C7128Yb(JSONObject jSONObject, C7059Ec ec, C7047Bc bc, C7254d dVar, C7142c cVar) {
        super("TaskProcessAdWaterfall", cVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (ec != null) {
            this.f13413f = jSONObject;
            this.f13414g = ec;
            this.f13415h = bc;
            this.f13416i = dVar;
        } else {
            throw new IllegalArgumentException("No zone specified");
        }
    }

    /* renamed from: a */
    private void m14972a(int i) {
        C7209sc.m15473a(this.f13416i, this.f13414g, i, this.f13625b);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14975a(C7251a aVar) {
        try {
            if (this.f13416i != null) {
                this.f13416i.adReceived(aVar);
            }
        } catch (Throwable th) {
            this.f13626c.mo22917b(this.f13624a, "Unable process a ad received notification", th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14977b() {
        m14972a(-6);
    }

    public void run() {
        try {
            this.f13626c.mo22918c(this.f13624a, "Processing ad response...");
            JSONArray jSONArray = this.f13413f.getJSONArray("ads");
            int length = jSONArray.length();
            if (length > 0) {
                C7262l lVar = this.f13626c;
                String str = this.f13624a;
                StringBuilder sb = new StringBuilder();
                sb.append("Loading the first out of ");
                sb.append(length);
                sb.append(" ads...");
                lVar.mo22918c(str, sb.toString());
                this.f13625b.mo23027C().mo22969a((C7184mb) new C7131Zb(this, 0, jSONArray));
                return;
            }
            this.f13626c.mo22913a(this.f13624a, "No ads were returned from the server");
            m14972a(204);
        } catch (Throwable th) {
            this.f13626c.mo22917b(this.f13624a, "Encountered error while processing ad response", th);
            m14977b();
        }
    }
}
