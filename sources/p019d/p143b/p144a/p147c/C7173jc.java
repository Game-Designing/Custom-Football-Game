package p019d.p143b.p144a.p147c;

import org.json.JSONObject;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.jc */
class C7173jc implements C7198q<JSONObject> {

    /* renamed from: a */
    final /* synthetic */ C7169ic f13600a;

    C7173jc(C7169ic icVar) {
        this.f13600a = icVar;
    }

    /* renamed from: a */
    public void mo22856a(int i) {
        C7262l lVar = this.f13600a.f13626c;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to report reward for ad: ");
        sb.append(this.f13600a.f13597f.mo22758b());
        sb.append(" - error code: ");
        sb.append(i);
        lVar.mo22916b("TaskReportReward", sb.toString());
    }

    /* renamed from: a */
    public void mo22857a(JSONObject jSONObject, int i) {
        C7262l lVar = this.f13600a.f13626c;
        StringBuilder sb = new StringBuilder();
        sb.append("Reported reward successfully for ad: ");
        sb.append(this.f13600a.f13597f.mo22758b());
        lVar.mo22918c("TaskReportReward", sb.toString());
    }
}
