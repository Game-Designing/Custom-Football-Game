package p026rx;

import java.util.Arrays;
import java.util.Collection;
import p026rx.exceptions.CompositeException;
import p026rx.p029i.C14977e;

/* renamed from: rx.w */
/* compiled from: Completable */
class C14999w implements C14503O {

    /* renamed from: a */
    final /* synthetic */ C14503O f44374a;

    /* renamed from: b */
    final /* synthetic */ C14977e f44375b;

    /* renamed from: c */
    final /* synthetic */ C15000x f44376c;

    C14999w(C15000x xVar, C14503O o, C14977e eVar) {
        this.f44376c = xVar;
        this.f44374a = o;
        this.f44375b = eVar;
    }

    public void onCompleted() {
        this.f44374a.onCompleted();
    }

    public void onError(Throwable e) {
        try {
            C0117M c = (C0117M) this.f44376c.f44377a.call(e);
            if (c == null) {
                this.f44374a.onError(new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{e, new NullPointerException("The completable returned is null")})));
                return;
            }
            c.mo3599b((C14503O) new C14998v(this));
        } catch (Throwable ex) {
            this.f44374a.onError(new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{e, ex})));
        }
    }

    /* renamed from: a */
    public void mo45688a(C0137ja d) {
        this.f44375b.mo46198a(d);
    }
}
