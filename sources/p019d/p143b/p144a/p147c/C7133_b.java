package p019d.p143b.p144a.p147c;

import org.json.JSONObject;
import p019d.p143b.p144a.p145a.C6931g;
import p019d.p143b.p144a.p145a.C6932h;
import p019d.p143b.p144a.p145a.C6938n;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c._b */
abstract class C7133_b extends C7184mb {

    /* renamed from: f */
    private final C7254d f13428f;

    /* renamed from: g */
    private final C7137ac f13429g;

    C7133_b(C6931g gVar, C7254d dVar, C7142c cVar) {
        super("TaskProcessVastResponse", cVar);
        if (gVar != null) {
            this.f13428f = dVar;
            this.f13429g = (C7137ac) gVar;
            return;
        }
        throw new IllegalArgumentException("No context specified.");
    }

    /* renamed from: a */
    public static C7133_b m14993a(C7217uc ucVar, C6931g gVar, C7254d dVar, C7142c cVar) {
        return new C7145cc(ucVar, gVar, dVar, cVar);
    }

    /* renamed from: a */
    public static C7133_b m14994a(JSONObject jSONObject, JSONObject jSONObject2, C7047Bc bc, C7254d dVar, C7142c cVar) {
        return new C7141bc(new C7137ac(jSONObject, jSONObject2, bc, cVar), dVar, cVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23000a(C6932h hVar) {
        C7262l lVar = this.f13626c;
        String str = this.f13624a;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to process VAST response due to VAST error code ");
        sb.append(hVar);
        lVar.mo22916b(str, sb.toString());
        C6938n.m14207a((C6931g) this.f13429g, this.f13428f, hVar, -6, this.f13625b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23001a(C7217uc ucVar) {
        C6932h hVar;
        C7184mb mbVar;
        int a = this.f13429g.mo22438a();
        C7262l lVar = this.f13626c;
        String str = this.f13624a;
        StringBuilder sb = new StringBuilder();
        sb.append("Finished parsing XML at depth ");
        sb.append(a);
        lVar.mo22918c(str, sb.toString());
        this.f13429g.mo23019a(ucVar);
        if (C6938n.m14213a(ucVar)) {
            int intValue = ((Integer) this.f13625b.mo23039a(C7196pb.f13896vd)).intValue();
            if (a < intValue) {
                this.f13626c.mo22918c(this.f13624a, "VAST response is wrapper. Resolving...");
                mbVar = new C7181lc(this.f13429g, this.f13428f, this.f13625b);
            } else {
                C7262l lVar2 = this.f13626c;
                String str2 = this.f13624a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Reached beyond max wrapper depth of ");
                sb2.append(intValue);
                lVar2.mo22916b(str2, sb2.toString());
                hVar = C6932h.WRAPPER_LIMIT_REACHED;
                mo23000a(hVar);
                return;
            }
        } else if (C6938n.m14216b(ucVar)) {
            this.f13626c.mo22918c(this.f13624a, "VAST response is inline. Rendering ad...");
            mbVar = new C7157fc(this.f13429g, this.f13428f, this.f13625b);
        } else {
            this.f13626c.mo22916b(this.f13624a, "VAST response is an error");
            hVar = C6932h.NO_WRAPPER_RESPONSE;
            mo23000a(hVar);
            return;
        }
        this.f13625b.mo23027C().mo22969a(mbVar);
    }
}
