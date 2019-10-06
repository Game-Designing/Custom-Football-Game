package p026rx;

import java.util.Arrays;
import java.util.Collection;
import p026rx.exceptions.CompositeException;
import p026rx.p029i.C14978f;
import p026rx.p400f.C14948s;

/* renamed from: rx.l */
/* compiled from: Completable */
class C14983l implements C14503O {

    /* renamed from: a */
    final /* synthetic */ C14503O f44337a;

    /* renamed from: b */
    final /* synthetic */ C14984m f44338b;

    C14983l(C14984m mVar, C14503O o) {
        this.f44338b = mVar;
        this.f44337a = o;
    }

    public void onCompleted() {
        try {
            this.f44338b.f44339a.call();
            this.f44337a.onCompleted();
            try {
                this.f44338b.f44340b.call();
            } catch (Throwable e) {
                C14948s.m46719b(e);
            }
        } catch (Throwable e2) {
            this.f44337a.onError(e2);
        }
    }

    public void onError(Throwable e) {
        try {
            this.f44338b.f44341c.call(e);
        } catch (Throwable ex) {
            e = new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{e, ex}));
        }
        this.f44337a.onError(e);
        try {
            this.f44338b.f44340b.call();
        } catch (Throwable ex2) {
            C14948s.m46719b(ex2);
        }
    }

    /* renamed from: a */
    public void mo45688a(C0137ja d) {
        try {
            this.f44338b.f44342d.call(d);
            this.f44337a.mo45688a(C14978f.m46781a(new C14982k(this, d)));
        } catch (Throwable ex) {
            d.unsubscribe();
            this.f44337a.mo45688a(C14978f.m46782b());
            this.f44337a.onError(ex);
        }
    }
}
