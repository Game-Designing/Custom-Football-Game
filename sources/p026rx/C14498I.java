package p026rx;

import p026rx.C0117M.C0118a;
import p026rx.p027b.C0131o;
import p026rx.p029i.C14978f;

/* renamed from: rx.I */
/* compiled from: Completable */
class C14498I implements C0118a {

    /* renamed from: a */
    final /* synthetic */ C0131o f43300a;

    C14498I(C0131o oVar) {
        this.f43300a = oVar;
    }

    /* renamed from: a */
    public void call(C14503O s) {
        try {
            C0117M c = (C0117M) this.f43300a.call();
            if (c == null) {
                s.mo45688a(C14978f.m46782b());
                s.onError(new NullPointerException("The completable returned is null"));
                return;
            }
            c.mo3599b(s);
        } catch (Throwable e) {
            s.mo45688a(C14978f.m46782b());
            s.onError(e);
        }
    }
}
