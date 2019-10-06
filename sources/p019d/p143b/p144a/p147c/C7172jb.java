package p019d.p143b.p144a.p147c;

import org.json.JSONObject;

/* renamed from: d.b.a.c.jb */
abstract class C7172jb extends C7184mb {
    protected C7172jb(String str, C7142c cVar) {
        super(str, cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23180a(String str, JSONObject jSONObject, C7198q qVar) {
        JSONObject jSONObject2 = new JSONObject();
        StringBuilder sb = new StringBuilder();
        sb.append("Repeat");
        sb.append(this.f13624a);
        C7180lb lbVar = new C7180lb(this, "POST", jSONObject2, sb.toString(), this.f13625b, qVar);
        lbVar.mo23150a(C7202r.m15401a(str, null, this.f13625b));
        lbVar.mo23155b(C7202r.m15411c(str, null, this.f13625b));
        lbVar.mo23151a(jSONObject);
        lbVar.mo23156c(((Integer) this.f13625b.mo23039a(C7196pb.f13842l)).intValue());
        lbVar.mo23149a(C7196pb.f13857o);
        lbVar.mo23154b(C7196pb.f13877s);
        lbVar.run();
    }
}
