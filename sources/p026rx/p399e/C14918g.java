package p026rx.p399e;

import p026rx.C0125T;
import p026rx.C14980ia;

/* renamed from: rx.e.g */
/* compiled from: Subscribers */
class C14918g extends C14980ia<T> {

    /* renamed from: a */
    final /* synthetic */ C0125T f44238a;

    C14918g(C0125T t) {
        this.f44238a = t;
    }

    public void onCompleted() {
        this.f44238a.onCompleted();
    }

    public void onError(Throwable e) {
        this.f44238a.onError(e);
    }

    public void onNext(T t) {
        this.f44238a.onNext(t);
    }
}
