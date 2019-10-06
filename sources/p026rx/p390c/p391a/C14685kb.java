package p026rx.p390c.p391a;

import p026rx.C14508U;
import p026rx.C14980ia;

/* renamed from: rx.c.a.kb */
/* compiled from: OperatorTimeoutBase */
class C14685kb extends C14980ia<T> {

    /* renamed from: a */
    final /* synthetic */ C14682c f43700a;

    C14685kb(C14682c cVar) {
        this.f43700a = cVar;
    }

    public void onNext(T t) {
        this.f43700a.f43691b.onNext(t);
    }

    public void onError(Throwable e) {
        this.f43700a.f43691b.onError(e);
    }

    public void onCompleted() {
        this.f43700a.f43691b.onCompleted();
    }

    public void setProducer(C14508U p) {
        this.f43700a.f43695f.mo45915a(p);
    }
}
