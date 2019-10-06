package p346g.p347a.p356a.p358b.p360b;

import java.io.IOException;
import java.util.Timer;
import p346g.p347a.p356a.C14096C;
import p346g.p347a.p356a.C14127g;
import p346g.p347a.p356a.C14130i;
import p346g.p347a.p356a.C14138j;
import p346g.p347a.p356a.C14138j.C14144f;
import p346g.p347a.p356a.C14164v;
import p346g.p347a.p356a.p357a.C14103d;
import p346g.p347a.p356a.p357a.C14104e;
import p346g.p347a.p356a.p357a.C14107h;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.b.b.d */
/* compiled from: Prober */
public class C14118d extends C14117c {

    /* renamed from: f */
    static C14236b f42915f = C14246c.m45851a(C14118d.class.getName());

    public C14118d(C14164v jmDNSImpl) {
        super(jmDNSImpl, C14117c.m45191f());
        mo43904b(C14107h.PROBING_1);
        mo43902a(C14107h.PROBING_1);
    }

    /* renamed from: b */
    public String mo43881b() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prober(");
        sb.append(mo43880a() != null ? mo43880a().mo44087G() : "");
        sb.append(")");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" state: ");
        sb.append(mo43906i());
        return sb.toString();
    }

    /* renamed from: a */
    public void mo43909a(Timer timer) {
        long now = System.currentTimeMillis();
        if (now - mo43880a().mo44085E() < 5000) {
            mo43880a().mo44103a(mo43880a().mo44091L() + 1);
        } else {
            mo43880a().mo44103a(1);
        }
        mo43880a().mo44122h(now);
        if (mo43880a().mo44094O() && mo43880a().mo44091L() < 10) {
            timer.schedule(this, (long) C14164v.m45461H().nextInt(251), 250);
        } else if (!mo43880a().mo44096Q() && !mo43880a().mo44095P()) {
            timer.schedule(this, 1000, 1000);
        }
    }

    public boolean cancel() {
        mo43907j();
        return super.cancel();
    }

    /* renamed from: h */
    public String mo43899h() {
        return "probing";
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo43897d() {
        return !mo43880a().mo44096Q() && !mo43880a().mo44095P();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C14127g mo43898e() {
        return new C14127g(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C14127g mo43892a(C14127g out) throws IOException {
        C14127g newOut = out;
        newOut.mo43953a(C14130i.m45277a(mo43880a().mo44086F().mo44064g(), C14104e.TYPE_ANY, C14103d.CLASS_IN, false));
        for (C14138j answer : mo43880a().mo44086F().mo44049a(C14103d.CLASS_ANY, false, mo43905g())) {
            newOut = mo43878a(newOut, answer);
        }
        return newOut;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C14127g mo43891a(C14096C info, C14127g out) throws IOException {
        C14127g newOut = mo43877a(out, C14130i.m45277a(info.mo43181o(), C14104e.TYPE_ANY, C14103d.CLASS_IN, false));
        C14144f fVar = new C14144f(info.mo43181o(), C14103d.CLASS_IN, false, mo43905g(), info.mo43179m(), info.mo43186t(), info.mo43178l(), mo43880a().mo44086F().mo44064g());
        return mo43878a(newOut, (C14138j) fVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo43893a(Throwable e) {
        mo43880a().mo44099T();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo43895c() {
        mo43904b(mo43906i().mo43839e());
        if (!mo43906i().mo43847u()) {
            cancel();
            mo43880a().mo44036h();
        }
    }
}
