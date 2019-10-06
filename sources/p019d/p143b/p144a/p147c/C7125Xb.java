package p019d.p143b.p144a.p147c;

import org.json.JSONObject;

/* renamed from: d.b.a.c.Xb */
public class C7125Xb extends C7184mb {

    /* renamed from: f */
    private final JSONObject f13406f;

    /* renamed from: g */
    private final JSONObject f13407g;

    C7125Xb(JSONObject jSONObject, JSONObject jSONObject2, C7142c cVar) {
        super("TaskLoadAdapterAd", cVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        } else if (jSONObject2 != null) {
            this.f13406f = jSONObject;
            this.f13407g = jSONObject2;
        } else {
            throw new IllegalArgumentException("No response specified");
        }
    }

    public void run() {
        try {
            this.f13625b.mo23076u().mo23095a(new C7235za(this.f13406f, this.f13407g, C7047Bc.MEDIATED_SDK, this.f13625b));
        } catch (Throwable th) {
            this.f13626c.mo22917b(this.f13624a, "Unable to prepare adapter ad", th);
        }
    }
}
