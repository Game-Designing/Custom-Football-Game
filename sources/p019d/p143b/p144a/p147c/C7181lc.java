package p019d.p143b.p144a.p147c;

import p019d.p143b.p144a.p145a.C6931g;
import p019d.p143b.p144a.p145a.C6932h;
import p019d.p143b.p144a.p145a.C6938n;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.lc */
class C7181lc extends C7184mb {
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C6931g f13618f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C7254d f13619g;

    C7181lc(C6931g gVar, C7254d dVar, C7142c cVar) {
        super("TaskResolveVastWrapper", cVar);
        this.f13619g = dVar;
        this.f13618f = gVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15315a(int i) {
        C7262l lVar = this.f13626c;
        String str = this.f13624a;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to resolve VAST wrapper due to error code ");
        sb.append(i);
        lVar.mo22916b(str, sb.toString());
        if (i == -103) {
            C7209sc.m15473a(this.f13619g, this.f13618f.mo22444g(), i, this.f13625b);
        } else {
            C6938n.m14207a(this.f13618f, this.f13619g, i == -102 ? C6932h.TIMED_OUT : C6932h.GENERAL_WRAPPER_ERROR, i, this.f13625b);
        }
    }

    public void run() {
        String a = C6938n.m14203a(this.f13618f);
        if (C7269s.m15819a(a)) {
            C7262l lVar = this.f13626c;
            String str = this.f13624a;
            StringBuilder sb = new StringBuilder();
            sb.append("Resolving VAST ad with depth ");
            sb.append(this.f13618f.mo22438a());
            sb.append(" at ");
            sb.append(a);
            lVar.mo22918c(str, sb.toString());
            try {
                C7185mc mcVar = new C7185mc(this, "GET", C7217uc.f13987a, "RepeatResolveVastWrapper", this.f13625b);
                mcVar.mo23150a(a);
                mcVar.mo23153b(((Integer) this.f13625b.mo23039a(C7196pb.f13906xd)).intValue());
                mcVar.mo23156c(((Integer) this.f13625b.mo23039a(C7196pb.f13901wd)).intValue());
                this.f13625b.mo23027C().mo22969a((C7184mb) mcVar);
            } catch (Throwable th) {
                this.f13626c.mo22917b(this.f13624a, "Unable to resolve VAST wrapper", th);
            }
        } else {
            this.f13626c.mo22916b(this.f13624a, "Resolving VAST failed. Could not find resolution URL");
            m15315a(-1);
        }
    }
}
