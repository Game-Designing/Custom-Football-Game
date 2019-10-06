package com.smaato.soma.p261j;

import com.smaato.soma.C12064Na;
import com.smaato.soma.C12398ha;
import com.smaato.soma.C12408ia;
import com.smaato.soma.C12431j;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p261j.p262a.C12450b;
import com.smaato.soma.p261j.p262a.C12464l;

/* renamed from: com.smaato.soma.j.J */
/* compiled from: Video */
class C12442J extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12064Na f38843a;

    /* renamed from: b */
    final /* synthetic */ C12446N f38844b;

    C12442J(C12446N this$0, C12064Na na) {
        this.f38844b = this$0;
        this.f38843a = na;
    }

    public Void process() throws Exception {
        if (this.f38843a.mo39290g() != C12408ia.NO_ERROR || (!(this.f38843a.mo39284b() == C12431j.f38814h || this.f38843a.mo39284b() == C12431j.REWARDED || this.f38843a.mo39284b() == C12431j.VIDEO) || this.f38843a.mo39300o() == null)) {
            C12146d.m39965a(new C12147e("VIDEO", "No Ad", 1, C12143a.DEBUG));
            this.f38844b.f38855g.mo39480a();
        } else {
            this.f38844b.f38862n = this.f38843a.getSessionId();
            this.f38844b.f38856h = this.f38843a.mo39300o();
            if (!C12450b.m40932b(this.f38844b.f38852d)) {
                this.f38844b.f38855g.mo39480a();
                return null;
            }
            C12446N n = this.f38844b;
            if (n.m40900a(n.f38856h)) {
                this.f38844b.mo39970f();
                return null;
            }
            C12464l.m40997a(String.valueOf(this.f38844b.f38856h.mo39709i()), new C12441I(this));
        }
        return null;
    }
}
