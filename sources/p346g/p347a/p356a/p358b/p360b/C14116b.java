package p346g.p347a.p356a.p358b.p360b;

import java.io.IOException;
import java.util.Timer;
import p346g.p347a.p356a.C14096C;
import p346g.p347a.p356a.C14123d;
import p346g.p347a.p356a.C14127g;
import p346g.p347a.p356a.C14138j;
import p346g.p347a.p356a.C14164v;
import p346g.p347a.p356a.p357a.C14103d;
import p346g.p347a.p356a.p357a.C14107h;
import p363i.p369c.C14236b;
import p363i.p369c.C14246c;

/* renamed from: g.a.a.b.b.b */
/* compiled from: Canceler */
public class C14116b extends C14117c {

    /* renamed from: f */
    static C14236b f42910f = C14246c.m45851a(C14116b.class.getName());

    public C14116b(C14164v jmDNSImpl) {
        super(jmDNSImpl, 0);
        mo43904b(C14107h.CANCELING_1);
        mo43902a(C14107h.CANCELING_1);
    }

    /* renamed from: b */
    public String mo43881b() {
        StringBuilder sb = new StringBuilder();
        sb.append("Canceler(");
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
    public void mo43900a(Timer timer) {
        timer.schedule(this, 0, 1000);
    }

    public boolean cancel() {
        mo43907j();
        return super.cancel();
    }

    /* renamed from: h */
    public String mo43899h() {
        return "canceling";
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo43897d() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C14127g mo43898e() {
        return new C14127g(33792);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C14127g mo43892a(C14127g out) throws IOException {
        C14127g newOut = out;
        for (C14138j answer : mo43880a().mo44086F().mo44049a(C14103d.CLASS_ANY, true, mo43905g())) {
            newOut = mo43876a(newOut, (C14123d) null, answer);
        }
        return newOut;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C14127g mo43891a(C14096C info, C14127g out) throws IOException {
        C14127g newOut = out;
        for (C14138j answer : info.mo43794a(C14103d.CLASS_ANY, true, mo43905g(), mo43880a().mo44086F())) {
            newOut = mo43876a(newOut, (C14123d) null, answer);
        }
        return newOut;
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
        if (!mo43906i().mo43843j()) {
            cancel();
        }
    }
}
