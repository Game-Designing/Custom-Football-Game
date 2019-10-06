package p346g.p347a.p356a.p358b;

import java.util.Timer;
import p346g.p347a.p356a.C14164v;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.b.b */
/* compiled from: RecordReaper */
public class C14114b extends C14110a {

    /* renamed from: b */
    static C14236b f42908b = C14246c.m45851a(C14114b.class.getName());

    public C14114b(C14164v jmDNSImpl) {
        super(jmDNSImpl);
    }

    /* renamed from: b */
    public String mo43881b() {
        StringBuilder sb = new StringBuilder();
        sb.append("RecordReaper(");
        sb.append(mo43880a() != null ? mo43880a().mo44087G() : "");
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo43889a(Timer timer) {
        if (!mo43880a().mo44096Q() && !mo43880a().mo44095P()) {
            timer.schedule(this, 10000, 10000);
        }
    }

    public void run() {
        if (!mo43880a().mo44096Q() && !mo43880a().mo44095P()) {
            if (f42908b.isTraceEnabled()) {
                C14236b bVar = f42908b;
                StringBuilder sb = new StringBuilder();
                sb.append(mo43881b());
                sb.append(".run() JmDNS reaping cache");
                bVar.mo44345c(sb.toString());
            }
            mo43880a().mo44129x();
        }
    }
}
