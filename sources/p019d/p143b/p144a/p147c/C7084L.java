package p019d.p143b.p144a.p147c;

import android.content.Context;
import com.applovin.adview.C5860f;
import com.applovin.adview.C5861g;
import java.lang.ref.SoftReference;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7255e;
import p019d.p143b.p150d.C7260j;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.L */
class C7084L implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7071Hc f13277a;

    /* renamed from: b */
    final /* synthetic */ Context f13278b;

    /* renamed from: c */
    final /* synthetic */ C7255e f13279c;

    /* renamed from: d */
    final /* synthetic */ C7260j f13280d;

    /* renamed from: e */
    final /* synthetic */ C7253c f13281e;

    /* renamed from: f */
    final /* synthetic */ C7252b f13282f;

    /* renamed from: g */
    final /* synthetic */ C7080K f13283g;

    C7084L(C7080K k, C7071Hc hc, Context context, C7255e eVar, C7260j jVar, C7253c cVar, C7252b bVar) {
        this.f13283g = k;
        this.f13277a = hc;
        this.f13278b = context;
        this.f13279c = eVar;
        this.f13280d = jVar;
        this.f13281e = cVar;
        this.f13282f = bVar;
    }

    public void run() {
        C7251a a = C7209sc.m15466a((C7251a) this.f13277a, (C7267q) this.f13283g.f13259a);
        if (a != null) {
            C5861g a2 = C5860f.m10676a(this.f13283g.f13259a, this.f13278b);
            C7103Q q = new C7103Q(this.f13283g, this.f13278b, this.f13279c, this.f13280d, this.f13281e, this.f13282f, null);
            a2.mo18323a((C7253c) q);
            a2.mo18324a((C7260j) q);
            a2.mo18322a((C7252b) q);
            a2.mo18321a(a, this.f13283g.f13262d);
            this.f13283g.f13269k = new SoftReference(a2);
            if (a instanceof C7234z) {
                this.f13283g.m14789a((C7234z) a, (C7255e) q);
                return;
            }
            return;
        }
        this.f13283g.m14793a((C7251a) this.f13277a, this.f13280d, this.f13281e);
    }
}
