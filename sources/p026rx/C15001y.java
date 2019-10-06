package p026rx;

import p026rx.p029i.C14976d;
import p026rx.p400f.C14948s;

/* renamed from: rx.y */
/* compiled from: Completable */
class C15001y implements C14503O {

    /* renamed from: a */
    final /* synthetic */ C14976d f44379a;

    /* renamed from: b */
    final /* synthetic */ C0117M f44380b;

    C15001y(C0117M m, C14976d dVar) {
        this.f44380b = m;
        this.f44379a = dVar;
    }

    public void onCompleted() {
        this.f44379a.unsubscribe();
    }

    public void onError(Throwable e) {
        C14948s.m46719b(e);
        this.f44379a.unsubscribe();
        C0117M.m588a(e);
    }

    /* renamed from: a */
    public void mo45688a(C0137ja d) {
        this.f44379a.mo46196a(d);
    }
}
