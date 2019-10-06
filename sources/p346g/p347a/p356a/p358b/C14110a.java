package p346g.p347a.p356a.p358b;

import java.io.IOException;
import java.util.TimerTask;
import p346g.p347a.p356a.C14123d;
import p346g.p347a.p356a.C14127g;
import p346g.p347a.p356a.C14130i;
import p346g.p347a.p356a.C14138j;
import p346g.p347a.p356a.C14164v;

/* renamed from: g.a.a.b.a */
/* compiled from: DNSTask */
public abstract class C14110a extends TimerTask {

    /* renamed from: a */
    private final C14164v f42903a;

    /* renamed from: b */
    public abstract String mo43881b();

    protected C14110a(C14164v jmDNSImpl) {
        this.f42903a = jmDNSImpl;
    }

    /* renamed from: a */
    public C14164v mo43880a() {
        return this.f42903a;
    }

    public String toString() {
        return mo43881b();
    }

    /* renamed from: a */
    public C14127g mo43877a(C14127g out, C14130i rec) throws IOException {
        C14127g newOut = out;
        try {
            newOut.mo43953a(rec);
            return newOut;
        } catch (IOException e) {
            int flags = newOut.mo43936e();
            boolean multicast = newOut.mo43946o();
            int maxUDPPayload = newOut.mo43961x();
            int id = newOut.mo43937f();
            newOut.mo43931a(flags | 512);
            newOut.mo43933b(id);
            this.f42903a.mo44109a(newOut);
            C14127g newOut2 = new C14127g(flags, multicast, maxUDPPayload);
            newOut2.mo43953a(rec);
            return newOut2;
        }
    }

    /* renamed from: a */
    public C14127g mo43876a(C14127g out, C14123d in, C14138j rec) throws IOException {
        C14127g newOut = out;
        try {
            newOut.mo43952a(in, rec);
            return newOut;
        } catch (IOException e) {
            int flags = newOut.mo43936e();
            boolean multicast = newOut.mo43946o();
            int maxUDPPayload = newOut.mo43961x();
            int id = newOut.mo43937f();
            newOut.mo43931a(flags | 512);
            newOut.mo43933b(id);
            this.f42903a.mo44109a(newOut);
            C14127g newOut2 = new C14127g(flags, multicast, maxUDPPayload);
            newOut2.mo43952a(in, rec);
            return newOut2;
        }
    }

    /* renamed from: a */
    public C14127g mo43879a(C14127g out, C14138j rec, long now) throws IOException {
        C14127g newOut = out;
        try {
            newOut.mo43955a(rec, now);
            return newOut;
        } catch (IOException e) {
            int flags = newOut.mo43936e();
            boolean multicast = newOut.mo43946o();
            int maxUDPPayload = newOut.mo43961x();
            int id = newOut.mo43937f();
            newOut.mo43931a(flags | 512);
            newOut.mo43933b(id);
            this.f42903a.mo44109a(newOut);
            C14127g newOut2 = new C14127g(flags, multicast, maxUDPPayload);
            newOut2.mo43955a(rec, now);
            return newOut2;
        }
    }

    /* renamed from: a */
    public C14127g mo43878a(C14127g out, C14138j rec) throws IOException {
        C14127g newOut = out;
        try {
            newOut.mo43954a(rec);
            return newOut;
        } catch (IOException e) {
            int flags = newOut.mo43936e();
            boolean multicast = newOut.mo43946o();
            int maxUDPPayload = newOut.mo43961x();
            int id = newOut.mo43937f();
            newOut.mo43931a(flags | 512);
            newOut.mo43933b(id);
            this.f42903a.mo44109a(newOut);
            C14127g newOut2 = new C14127g(flags, multicast, maxUDPPayload);
            newOut2.mo43954a(rec);
            return newOut2;
        }
    }
}
