package p019d.p143b.p144a.p147c;

import java.util.HashMap;
import java.util.Map;
import p019d.p143b.p150d.C7254d;

/* renamed from: d.b.a.c.Pb */
class C7102Pb extends C7090Mb {

    /* renamed from: i */
    private final C7051Cc f13332i;

    C7102Pb(C7051Cc cc, C7254d dVar, C7142c cVar) {
        super(C7059Ec.m14672a("adtoken_zone", cVar), dVar, cVar);
        this.f13332i = cc;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Map<String, String> mo22905b() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("adtoken", C7209sc.m15487d(this.f13332i.mo22773a()));
        hashMap.put("adtoken_prefix", C7209sc.m15487d(this.f13332i.mo22775c()));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C7047Bc mo22906c() {
        return C7047Bc.REGULAR_AD_TOKEN;
    }
}
