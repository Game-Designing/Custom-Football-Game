package p026rx;

import p026rx.C0117M.C0118a;
import p026rx.p029i.C14978f;

/* renamed from: rx.J */
/* compiled from: Completable */
class C14499J implements C0118a {

    /* renamed from: a */
    final /* synthetic */ Throwable f43301a;

    C14499J(Throwable th) {
        this.f43301a = th;
    }

    /* renamed from: a */
    public void call(C14503O s) {
        s.mo45688a(C14978f.m46782b());
        s.onError(this.f43301a);
    }
}
