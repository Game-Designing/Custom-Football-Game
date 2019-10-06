package p019d.p143b.p144a.p147c;

import java.util.HashMap;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.E */
class C7056E implements C7066Gb {

    /* renamed from: a */
    final /* synthetic */ C7168ib f13189a;

    /* renamed from: b */
    final /* synthetic */ boolean f13190b;

    /* renamed from: c */
    final /* synthetic */ C7146d f13191c;

    C7056E(C7146d dVar, C7168ib ibVar, boolean z) {
        this.f13191c = dVar;
        this.f13189a = ibVar;
        this.f13190b = z;
    }

    /* renamed from: a */
    public void mo22796a(C7218v vVar) {
        try {
            HashMap a = this.f13191c.m15123a(this.f13189a, vVar);
            String uri = this.f13191c.m15129b(this.f13191c.m15120a(), a).toString();
            String uri2 = this.f13191c.m15129b(this.f13191c.m15130b(), a).toString();
            if (this.f13190b) {
                this.f13191c.f13489a.mo23077v().mo23086a(uri, this.f13189a.mo23171b(), true, uri2);
            } else {
                this.f13191c.f13489a.mo23078w().mo23138a(uri, this.f13189a.mo23171b(), uri2, null);
            }
        } catch (Exception e) {
            C7262l b = this.f13191c.f13489a.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to track event due to failure to convert event parameters into JSONObject for event: ");
            sb.append(this.f13189a);
            b.mo22917b("EventServiceImpl", sb.toString(), e);
        }
    }
}
