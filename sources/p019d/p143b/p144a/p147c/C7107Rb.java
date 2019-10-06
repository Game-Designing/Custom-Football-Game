package p019d.p143b.p144a.p147c;

import org.json.JSONObject;
import p019d.p143b.p150d.C7254d;

/* renamed from: d.b.a.c.Rb */
public class C7107Rb extends C7184mb {

    /* renamed from: f */
    private final JSONObject f13361f;

    /* renamed from: g */
    private final JSONObject f13362g;

    /* renamed from: h */
    private final C7254d f13363h;

    C7107Rb(JSONObject jSONObject, JSONObject jSONObject2, C7142c cVar, C7254d dVar) {
        super("TaskLoadAdapterAd", cVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        } else if (jSONObject2 != null) {
            this.f13361f = jSONObject;
            this.f13362g = jSONObject2;
            this.f13363h = dVar;
        } else {
            throw new IllegalArgumentException("No response specified");
        }
    }

    public void run() {
        try {
            this.f13625b.mo23076u().mo23096a(new C7235za(this.f13361f, this.f13362g, C7047Bc.MEDIATED_SDK, this.f13625b), this.f13363h);
        } catch (Throwable th) {
            this.f13626c.mo22917b(this.f13624a, "Unable to process adapter ad", th);
            C7254d dVar = this.f13363h;
            if (dVar != null) {
                dVar.failedToReceiveAd(-5001);
            }
        }
    }
}
