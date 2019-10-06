package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7264n;

/* renamed from: d.b.a.c.fb */
class C7156fb implements C7264n {

    /* renamed from: a */
    final /* synthetic */ C7264n f13535a;

    /* renamed from: b */
    final /* synthetic */ C7158g f13536b;

    C7156fb(C7158g gVar, C7264n nVar) {
        this.f13536b = gVar;
        this.f13535a = nVar;
    }

    public void onPostbackFailure(String str, int i) {
        C7262l b = this.f13536b.f13539a.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to dispatch postback. Error code: ");
        sb.append(i);
        sb.append(" URL: ");
        sb.append(str);
        b.mo22916b("PostbackService", sb.toString());
        C7264n nVar = this.f13535a;
        if (nVar != null) {
            nVar.onPostbackFailure(str, i);
        }
    }

    public void onPostbackSuccess(String str) {
        C7262l b = this.f13536b.f13539a.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("Successfully dispatched postback to URL: ");
        sb.append(str);
        b.mo22918c("PostbackService", sb.toString());
        C7264n nVar = this.f13535a;
        if (nVar != null) {
            nVar.onPostbackSuccess(str);
        }
    }
}
