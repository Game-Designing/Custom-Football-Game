package p019d.p143b.p144a.p147c;

import java.util.Map;
import p019d.p143b.p148b.C7240c;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.Ea */
class C7057Ea implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Map f13192a;

    /* renamed from: b */
    final /* synthetic */ C7053Da f13193b;

    C7057Ea(C7053Da da, Map map) {
        this.f13193b = da;
        this.f13192a = map;
    }

    public void run() {
        try {
            this.f13193b.f13182e.mo22734a(this.f13192a);
            this.f13193b.f13179b.mo23457a((C7240c) this.f13193b.f13182e, (C7267q) this.f13193b.f13180c, this.f13193b.f13180c.mo23073r());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
