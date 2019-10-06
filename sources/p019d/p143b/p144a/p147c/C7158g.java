package p019d.p143b.p144a.p147c;

import java.util.Map;
import p019d.p143b.p150d.C7264n;
import p019d.p143b.p150d.C7265o;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.g */
public class C7158g implements C7265o {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7142c f13539a;

    C7158g(C7142c cVar) {
        this.f13539a = cVar;
    }

    /* renamed from: a */
    public void mo23136a(String str, C7264n nVar) {
        mo23138a(str, null, null, nVar);
    }

    /* renamed from: a */
    public void mo23137a(String str, Map<String, String> map, String str2, int i, long j, int i2, C7264n nVar) {
        if (C7269s.m15819a(str)) {
            this.f13539a.mo23066k();
            C7070Hb hb = new C7070Hb(this.f13539a, str, map, new C7156fb(this, nVar));
            hb.mo22839a(i);
            hb.mo22840a(j);
            hb.mo22842b(i2);
            hb.mo22841a(str2);
            this.f13539a.mo23027C().mo22970a((C7184mb) hb, C7113Tb.POSTBACKS);
            return;
        }
        this.f13539a.mo23049b().mo22916b("PostbackService", "Requested a postback dispatch for an empty URL; nothing to do...");
        if (nVar != null) {
            nVar.onPostbackFailure(str, -900);
        }
    }

    /* renamed from: a */
    public void mo23138a(String str, Map<String, String> map, String str2, C7264n nVar) {
        mo23137a(str, map, str2, ((Integer) this.f13539a.mo23039a(C7196pb.f13859ob)).intValue(), ((Long) this.f13539a.mo23039a(C7196pb.f13892v)).longValue(), ((Integer) this.f13539a.mo23039a(C7196pb.f13854nb)).intValue(), nVar);
    }
}
