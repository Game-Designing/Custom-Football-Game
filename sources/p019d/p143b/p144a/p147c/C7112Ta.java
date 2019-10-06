package p019d.p143b.p144a.p147c;

import p019d.p143b.p149c.C7247a;
import p019d.p143b.p149c.C7249c;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.Ta */
class C7112Ta implements C7249c {

    /* renamed from: a */
    final /* synthetic */ C7109Sa f13377a;

    C7112Ta(C7109Sa sa) {
        this.f13377a = sa;
    }

    /* renamed from: a */
    public void mo22974a(C7247a aVar) {
        this.f13377a.mo23145c((C7231ya) aVar);
    }

    /* renamed from: a */
    public void mo22975a(C7247a aVar, int i) {
        C7109Sa sa = this.f13377a;
        sa.mo23144c(C7059Ec.m14685j(sa.f13541a), i);
    }

    /* renamed from: b */
    public void mo22976b(C7247a aVar) {
        if (!C7269s.m15819a(aVar.mo23130p())) {
            this.f13377a.mo23145c((C7231ya) aVar);
        }
    }

    /* renamed from: b */
    public void mo22977b(C7247a aVar, int i) {
        C7262l lVar = this.f13377a.f13542b;
        StringBuilder sb = new StringBuilder();
        sb.append("Video failed to cache during native ad preload. ");
        sb.append(i);
        lVar.mo22913a("NativeAdPreloadManager", sb.toString());
        this.f13377a.mo23145c((C7231ya) aVar);
    }
}
