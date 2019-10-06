package p346g.p347a.p356a.p358b.p359a;

import java.io.IOException;
import java.util.Timer;
import p346g.p347a.p356a.C14127g;
import p346g.p347a.p356a.C14164v;
import p346g.p347a.p356a.p358b.C14110a;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.b.a.a */
/* compiled from: DNSResolverTask */
public abstract class C14111a extends C14110a {

    /* renamed from: b */
    private static C14236b f42904b = C14246c.m45851a(C14111a.class.getName());

    /* renamed from: c */
    protected int f42905c = 0;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C14127g mo43883a(C14127g gVar) throws IOException;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract C14127g mo43885b(C14127g gVar) throws IOException;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract String mo43886c();

    public C14111a(C14164v jmDNSImpl) {
        super(jmDNSImpl);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" count: ");
        sb.append(this.f42905c);
        return sb.toString();
    }

    /* renamed from: a */
    public void mo43884a(Timer timer) {
        if (!mo43880a().mo44096Q() && !mo43880a().mo44095P()) {
            timer.schedule(this, 225, 225);
        }
    }

    public void run() {
        try {
            if (!mo43880a().mo44096Q()) {
                if (!mo43880a().mo44095P()) {
                    int i = this.f42905c;
                    this.f42905c = i + 1;
                    if (i < 3) {
                        if (f42904b.isDebugEnabled()) {
                            C14236b bVar = f42904b;
                            StringBuilder sb = new StringBuilder();
                            sb.append(mo43881b());
                            sb.append(".run() JmDNS ");
                            sb.append(mo43886c());
                            bVar.mo44340a(sb.toString());
                        }
                        C14127g out = mo43885b(new C14127g(0));
                        if (mo43880a().mo44094O()) {
                            out = mo43883a(out);
                        }
                        if (!out.mo43945n()) {
                            mo43880a().mo44109a(out);
                        }
                        return;
                    }
                    cancel();
                    return;
                }
            }
            cancel();
        } catch (Throwable e) {
            C14236b bVar2 = f42904b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mo43881b());
            sb2.append(".run() exception ");
            bVar2.mo44344b(sb2.toString(), e);
            mo43880a().mo44099T();
        }
    }
}
