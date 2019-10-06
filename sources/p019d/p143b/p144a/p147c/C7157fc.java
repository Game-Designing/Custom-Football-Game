package p019d.p143b.p144a.p147c;

import java.util.HashSet;
import java.util.Set;
import p019d.p143b.p144a.p145a.C6925a;
import p019d.p143b.p144a.p145a.C6927c;
import p019d.p143b.p144a.p145a.C6930f;
import p019d.p143b.p144a.p145a.C6931g;
import p019d.p143b.p144a.p145a.C6932h;
import p019d.p143b.p144a.p145a.C6935k;
import p019d.p143b.p144a.p145a.C6936l;
import p019d.p143b.p144a.p145a.C6938n;
import p019d.p143b.p144a.p145a.C6939o;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.fc */
class C7157fc extends C7184mb {

    /* renamed from: f */
    private C6931g f13537f;

    /* renamed from: g */
    private final C7254d f13538g;

    C7157fc(C6931g gVar, C7254d dVar, C7142c cVar) {
        super("TaskRenderVastAd", cVar);
        if (gVar != null) {
            this.f13538g = dVar;
            this.f13537f = gVar;
            return;
        }
        throw new IllegalArgumentException("No context specified.");
    }

    /* renamed from: a */
    private void m15188a(C6932h hVar, Throwable th) {
        this.f13626c.mo22917b(this.f13624a, "Failed to render valid VAST ad", th);
        C6938n.m14207a(this.f13537f, this.f13538g, hVar, -6, this.f13625b);
    }

    public void run() {
        this.f13626c.mo22918c(this.f13624a, "Rendering VAST ad...");
        int size = this.f13537f.mo22439b().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String str = "";
        String str2 = str;
        C6935k kVar = null;
        C6939o oVar = null;
        C6930f fVar = null;
        for (C7217uc ucVar : this.f13537f.mo22439b()) {
            C7217uc c = ucVar.mo23351c(C6938n.m14213a(ucVar) ? "Wrapper" : "InLine");
            if (c != null) {
                C7217uc c2 = c.mo23351c("AdSystem");
                if (c2 != null) {
                    kVar = C6935k.m14193a(c2, kVar, this.f13625b);
                }
                str = C6938n.m14204a(c, "AdTitle", str);
                str2 = C6938n.m14204a(c, "Description", str2);
                C6938n.m14209a(c.mo23348a("Impression"), (Set<C6936l>) hashSet, this.f13537f, (C7267q) this.f13625b);
                C6938n.m14209a(c.mo23348a("Error"), (Set<C6936l>) hashSet2, this.f13537f, (C7267q) this.f13625b);
                C7217uc b = c.mo23349b("Creatives");
                if (b != null) {
                    for (C7217uc ucVar2 : b.mo23353d()) {
                        C7217uc b2 = ucVar2.mo23349b("Linear");
                        if (b2 != null) {
                            oVar = C6939o.m14219a(b2, oVar, this.f13537f, this.f13625b);
                        } else {
                            C7217uc c3 = ucVar2.mo23351c("CompanionAds");
                            if (c3 != null) {
                                C7217uc c4 = c3.mo23351c("Companion");
                                if (c4 != null) {
                                    fVar = C6930f.m14171a(c4, fVar, this.f13537f, this.f13625b);
                                }
                            } else {
                                C7262l lVar = this.f13626c;
                                String str3 = this.f13624a;
                                StringBuilder sb = new StringBuilder();
                                sb.append("Received and will skip rendering for an unidentified creative: ");
                                sb.append(ucVar2);
                                lVar.mo22916b(str3, sb.toString());
                            }
                        }
                    }
                }
            } else {
                C7262l lVar2 = this.f13626c;
                String str4 = this.f13624a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Did not find wrapper or inline response for node: ");
                sb2.append(ucVar);
                lVar2.mo22916b(str4, sb2.toString());
            }
        }
        try {
            C6927c pa = C6925a.m14123pa();
            pa.mo22424a(this.f13625b);
            pa.mo22427a(this.f13537f.mo22440c());
            pa.mo22430b(this.f13537f.mo22441d());
            pa.mo22423a(this.f13537f.mo22442e());
            pa.mo22419a(this.f13537f.mo22443f());
            pa.mo22425a(str);
            pa.mo22428b(str2);
            pa.mo22421a(kVar);
            pa.mo22422a(oVar);
            pa.mo22420a(fVar);
            pa.mo22426a((Set<C6936l>) hashSet);
            pa.mo22429b((Set<C6936l>) hashSet2);
            C6925a a = pa.mo22418a();
            C6932h a2 = C6938n.m14200a(a);
            if (a2 == null) {
                this.f13625b.mo23027C().mo22969a((C7184mb) new C7058Eb(a, this.f13538g, this.f13625b));
            } else {
                m15188a(a2, null);
            }
        } catch (Throwable th) {
            m15188a(C6932h.GENERAL_WRAPPER_ERROR, th);
        }
    }
}
