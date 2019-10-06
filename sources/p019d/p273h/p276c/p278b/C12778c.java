package p019d.p273h.p276c.p278b;

import java.util.ArrayList;
import java.util.List;
import p019d.p273h.p275b.C12733b;

/* renamed from: d.h.c.b.c */
/* compiled from: BaseEventsManager */
class C12778c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f39295a;

    /* renamed from: b */
    final /* synthetic */ ArrayList f39296b;

    /* renamed from: c */
    final /* synthetic */ C12779d f39297c;

    C12778c(C12779d this$1, boolean z, ArrayList arrayList) {
        this.f39297c = this$1;
        this.f39295a = z;
        this.f39296b = arrayList;
    }

    public void run() {
        if (this.f39295a) {
            this.f39297c.f39298a.f39322p = this.f39297c.f39298a.f39318l.mo41151b(this.f39297c.f39298a.f39301B).size() + this.f39297c.f39298a.f39320n.size();
        } else if (this.f39296b != null) {
            this.f39297c.f39298a.f39318l.mo41150a((List<C12733b>) this.f39296b, this.f39297c.f39298a.f39301B);
            this.f39297c.f39298a.f39322p = this.f39297c.f39298a.f39318l.mo41151b(this.f39297c.f39298a.f39301B).size() + this.f39297c.f39298a.f39320n.size();
        }
    }
}
