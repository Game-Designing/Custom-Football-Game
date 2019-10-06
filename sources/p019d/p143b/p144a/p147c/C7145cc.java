package p019d.p143b.p144a.p147c;

import p019d.p143b.p144a.p145a.C6931g;
import p019d.p143b.p150d.C7254d;

/* renamed from: d.b.a.c.cc */
final class C7145cc extends C7133_b {

    /* renamed from: h */
    private final C7217uc f13488h;

    C7145cc(C7217uc ucVar, C6931g gVar, C7254d dVar, C7142c cVar) {
        super(gVar, dVar, cVar);
        if (ucVar == null) {
            throw new IllegalArgumentException("No response specified.");
        } else if (gVar == null) {
            throw new IllegalArgumentException("No context specified.");
        } else if (dVar != null) {
            this.f13488h = ucVar;
        } else {
            throw new IllegalArgumentException("No callback specified.");
        }
    }

    public void run() {
        this.f13626c.mo22918c(this.f13624a, "Processing VAST Wrapper response...");
        mo23001a(this.f13488h);
    }
}
