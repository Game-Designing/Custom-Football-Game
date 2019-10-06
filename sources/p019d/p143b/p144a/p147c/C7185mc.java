package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.mc */
class C7185mc extends C7161gc<C7217uc> {

    /* renamed from: s */
    final /* synthetic */ C7181lc f13629s;

    C7185mc(C7181lc lcVar, String str, C7217uc ucVar, String str2, C7142c cVar) {
        this.f13629s = lcVar;
        super(str, ucVar, str2, cVar);
    }

    /* renamed from: a */
    public void mo22856a(int i) {
        C7262l lVar = this.f13626c;
        String str = this.f13624a;
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to resolve VAST wrapper. Server returned ");
        sb.append(i);
        lVar.mo22916b(str, sb.toString());
        this.f13629s.m15315a(i);
    }

    /* renamed from: a */
    public void mo22857a(C7217uc ucVar, int i) {
        this.f13625b.mo23027C().mo22969a((C7184mb) C7133_b.m14993a(ucVar, this.f13629s.f13618f, this.f13629s.f13619g, this.f13625b));
    }
}
