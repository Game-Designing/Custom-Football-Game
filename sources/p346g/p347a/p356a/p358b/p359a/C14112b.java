package p346g.p347a.p356a.p358b.p359a;

import java.io.IOException;
import p346g.p347a.p356a.C14096C;
import p346g.p347a.p356a.C14127g;
import p346g.p347a.p356a.C14130i;
import p346g.p347a.p356a.C14138j;
import p346g.p347a.p356a.C14164v;
import p346g.p347a.p356a.p357a.C14103d;
import p346g.p347a.p356a.p357a.C14104e;

/* renamed from: g.a.a.b.a.b */
/* compiled from: ServiceInfoResolver */
public class C14112b extends C14111a {

    /* renamed from: d */
    private final C14096C f42906d;

    public C14112b(C14164v jmDNSImpl, C14096C info) {
        super(jmDNSImpl);
        this.f42906d = info;
        info.mo43797a(mo43880a());
        mo43880a().mo44108a((C14125e) info, C14130i.m45277a(info.mo43181o(), C14104e.TYPE_ANY, C14103d.CLASS_IN, false));
    }

    /* renamed from: b */
    public String mo43881b() {
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceInfoResolver(");
        sb.append(mo43880a() != null ? mo43880a().mo44087G() : "");
        sb.append(")");
        return sb.toString();
    }

    public boolean cancel() {
        boolean result = super.cancel();
        if (!this.f42906d.mo43188w()) {
            mo43880a().mo44107a((C14125e) this.f42906d);
        }
        return result;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C14127g mo43883a(C14127g out) throws IOException {
        C14127g newOut = out;
        if (!this.f42906d.mo43187u()) {
            long now = System.currentTimeMillis();
            newOut = mo43879a(mo43879a(newOut, (C14138j) mo43880a().mo44131z().mo43818a(this.f42906d.mo43181o(), C14104e.TYPE_SRV, C14103d.CLASS_IN), now), (C14138j) mo43880a().mo44131z().mo43818a(this.f42906d.mo43181o(), C14104e.TYPE_TXT, C14103d.CLASS_IN), now);
            if (this.f42906d.mo43182p().length() > 0) {
                for (C14138j a : mo43880a().mo44131z().mo43824b(this.f42906d.mo43182p(), C14104e.TYPE_A, C14103d.CLASS_IN)) {
                    newOut = mo43879a(newOut, a, now);
                }
                for (C14138j a2 : mo43880a().mo44131z().mo43824b(this.f42906d.mo43182p(), C14104e.TYPE_AAAA, C14103d.CLASS_IN)) {
                    newOut = mo43879a(newOut, a2, now);
                }
            }
        }
        return newOut;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C14127g mo43885b(C14127g out) throws IOException {
        C14127g newOut = out;
        if (this.f42906d.mo43187u()) {
            return newOut;
        }
        C14127g newOut2 = mo43877a(mo43877a(newOut, C14130i.m45277a(this.f42906d.mo43181o(), C14104e.TYPE_SRV, C14103d.CLASS_IN, false)), C14130i.m45277a(this.f42906d.mo43181o(), C14104e.TYPE_TXT, C14103d.CLASS_IN, false));
        if (this.f42906d.mo43182p().length() > 0) {
            return mo43877a(mo43877a(newOut2, C14130i.m45277a(this.f42906d.mo43182p(), C14104e.TYPE_A, C14103d.CLASS_IN, false)), C14130i.m45277a(this.f42906d.mo43182p(), C14104e.TYPE_AAAA, C14103d.CLASS_IN, false));
        }
        return newOut2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo43886c() {
        StringBuilder sb = new StringBuilder();
        sb.append("querying service info: ");
        C14096C c = this.f42906d;
        sb.append(c != null ? c.mo43181o() : "null");
        return sb.toString();
    }
}
