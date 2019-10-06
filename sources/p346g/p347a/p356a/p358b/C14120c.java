package p346g.p347a.p356a.p358b;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import javax.jmdns.impl.DNSQuestion;
import javax.jmdns.impl.DNSRecord;
import p346g.p347a.p356a.C14123d;
import p346g.p347a.p356a.C14127g;
import p346g.p347a.p356a.C14130i;
import p346g.p347a.p356a.C14138j;
import p346g.p347a.p356a.C14164v;
import p346g.p347a.p356a.p357a.C14100a;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.b.c */
/* compiled from: Responder */
public class C14120c extends C14110a {

    /* renamed from: b */
    static C14236b f42917b = C14246c.m45851a(C14120c.class.getName());

    /* renamed from: c */
    private final C14123d f42918c;

    /* renamed from: d */
    private final InetAddress f42919d;

    /* renamed from: e */
    private final int f42920e;

    /* renamed from: f */
    private final boolean f42921f;

    public C14120c(C14164v jmDNSImpl, C14123d in, InetAddress addr, int port) {
        super(jmDNSImpl);
        this.f42918c = in;
        this.f42919d = addr;
        this.f42920e = port;
        this.f42921f = port != C14100a.f42767a;
    }

    /* renamed from: b */
    public String mo43881b() {
        StringBuilder sb = new StringBuilder();
        sb.append("Responder(");
        sb.append(mo43880a() != null ? mo43880a().mo44087G() : "");
        sb.append(")");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" incomming: ");
        sb.append(this.f42918c);
        return sb.toString();
    }

    /* renamed from: a */
    public void mo43913a(Timer timer) {
        boolean iAmTheOnlyOne = true;
        for (C14130i question : this.f42918c.mo43943l()) {
            if (f42917b.isTraceEnabled()) {
                C14236b bVar = f42917b;
                StringBuilder sb = new StringBuilder();
                sb.append(mo43881b());
                sb.append("start() question=");
                sb.append(question);
                bVar.mo44345c(sb.toString());
            }
            iAmTheOnlyOne = question.mo43973a(mo43880a());
            if (!iAmTheOnlyOne) {
                break;
            }
        }
        int delay = (!iAmTheOnlyOne || this.f42918c.mo43949r()) ? (C14164v.m45461H().nextInt(96) + 20) - this.f42918c.mo43920u() : 0;
        if (delay < 0) {
            delay = 0;
        }
        if (f42917b.isTraceEnabled()) {
            C14236b bVar2 = f42917b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mo43881b());
            sb2.append("start() Responder chosen delay=");
            sb2.append(delay);
            bVar2.mo44345c(sb2.toString());
        }
        if (!mo43880a().mo44096Q() && !mo43880a().mo44095P()) {
            timer.schedule(this, (long) delay);
        }
    }

    public void run() {
        mo43880a().mo44115b(this.f42918c);
        Set<DNSQuestion> questions = new HashSet<>();
        Set<DNSRecord> answers = new HashSet<>();
        if (mo43880a().mo44094O()) {
            try {
                for (C14130i question : this.f42918c.mo43943l()) {
                    if (f42917b.isDebugEnabled()) {
                        C14236b bVar = f42917b;
                        StringBuilder sb = new StringBuilder();
                        sb.append(mo43881b());
                        sb.append("run() JmDNS responding to: ");
                        sb.append(question);
                        bVar.mo44340a(sb.toString());
                    }
                    if (this.f42921f) {
                        questions.add(question);
                    }
                    question.mo43971a(mo43880a(), answers);
                }
                long now = System.currentTimeMillis();
                for (C14138j knownAnswer : this.f42918c.mo43934c()) {
                    if (knownAnswer.mo43986c(now)) {
                        answers.remove(knownAnswer);
                        if (f42917b.isDebugEnabled()) {
                            C14236b bVar2 = f42917b;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(mo43881b());
                            sb2.append("JmDNS Responder Known Answer Removed");
                            bVar2.mo44340a(sb2.toString());
                        }
                    }
                }
                if (!answers.isEmpty()) {
                    if (f42917b.isDebugEnabled()) {
                        C14236b bVar3 = f42917b;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(mo43881b());
                        sb3.append("run() JmDNS responding");
                        bVar3.mo44340a(sb3.toString());
                    }
                    C14127g out = new C14127g(33792, !this.f42921f, this.f42918c.mo43921v());
                    if (this.f42921f) {
                        out.mo43956a(new InetSocketAddress(this.f42919d, this.f42920e));
                    }
                    out.mo43933b(this.f42918c.mo43937f());
                    Iterator i$ = questions.iterator();
                    while (i$.hasNext()) {
                        C14130i question2 = (C14130i) i$.next();
                        if (question2 != null) {
                            out = mo43877a(out, question2);
                        }
                    }
                    Iterator i$2 = answers.iterator();
                    while (i$2.hasNext()) {
                        C14138j answer = (C14138j) i$2.next();
                        if (answer != null) {
                            out = mo43876a(out, this.f42918c, answer);
                        }
                    }
                    if (!out.mo43945n()) {
                        mo43880a().mo44109a(out);
                    }
                }
            } catch (Throwable e) {
                C14236b bVar4 = f42917b;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(mo43881b());
                sb4.append("run() exception ");
                bVar4.mo44344b(sb4.toString(), e);
                mo43880a().close();
            }
        }
    }
}
