package p026rx.p390c.p391a;

import p026rx.C14508U;
import p026rx.C14980ia;

/* renamed from: rx.c.a.Ea */
/* compiled from: OperatorOnErrorResumeNextViaFunction */
class C14573Ea extends C14980ia<T> {

    /* renamed from: a */
    final /* synthetic */ C14577Fa f43419a;

    C14573Ea(C14577Fa fa) {
        this.f43419a = fa;
    }

    public void onNext(T t) {
        this.f43419a.f43429c.onNext(t);
    }

    public void onError(Throwable e) {
        this.f43419a.f43429c.onError(e);
    }

    public void onCompleted() {
        this.f43419a.f43429c.onCompleted();
    }

    public void setProducer(C14508U producer) {
        this.f43419a.f43430d.mo45915a(producer);
    }
}
