package p346g.p347a.p356a.p358b.p359a;

import java.io.IOException;
import p346g.p347a.C13821d;
import p346g.p347a.p356a.C14127g;
import p346g.p347a.p356a.C14130i;
import p346g.p347a.p356a.C14138j;
import p346g.p347a.p356a.C14138j.C14143e;
import p346g.p347a.p356a.C14164v;
import p346g.p347a.p356a.p357a.C14103d;
import p346g.p347a.p356a.p357a.C14104e;

/* renamed from: g.a.a.b.a.c */
/* compiled from: ServiceResolver */
public class C14113c extends C14111a {

    /* renamed from: d */
    private final String f42907d;

    public C14113c(C14164v jmDNSImpl, String type) {
        super(jmDNSImpl);
        this.f42907d = type;
    }

    /* renamed from: b */
    public String mo43881b() {
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceResolver(");
        sb.append(mo43880a() != null ? mo43880a().mo44087G() : "");
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C14127g mo43883a(C14127g out) throws IOException {
        C14127g newOut = out;
        long now = System.currentTimeMillis();
        for (C13821d info : mo43880a().mo44089J().values()) {
            C14143e eVar = new C14143e(info.mo43185s(), C14103d.CLASS_IN, false, 3600, info.mo43181o());
            newOut = mo43879a(newOut, (C14138j) eVar, now);
        }
        return newOut;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C14127g mo43885b(C14127g out) throws IOException {
        return mo43877a(out, C14130i.m45277a(this.f42907d, C14104e.TYPE_PTR, C14103d.CLASS_IN, false));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo43886c() {
        return "querying service";
    }
}
