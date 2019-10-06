package com.smaato.soma.p261j;

import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p252i.C12279e;
import com.smaato.soma.p261j.p262a.C12464l.C12465a;
import java.util.Vector;

/* renamed from: com.smaato.soma.j.I */
/* compiled from: Video */
class C12441I implements C12465a {

    /* renamed from: a */
    final /* synthetic */ C12442J f38842a;

    C12441I(C12442J this$1) {
        this.f38842a = this$1;
    }

    public void onComplete(boolean success) {
        if (success) {
            C12146d.m39965a(new C12147e("VIDEO", "Cached", 1, C12143a.DEBUG));
            C12446N n = this.f38842a.f38844b;
            n.m40900a(n.f38856h);
            this.f38842a.f38844b.mo39970f();
            return;
        }
        C12442J j = this.f38842a;
        j.f38844b.mo39964a(j.f38843a);
        new C12279e().execute(new Vector[]{this.f38842a.f38844b.f38856h.mo39702d()});
        this.f38842a.f38844b.f38855g.mo39480a();
    }
}
