package p026rx.p390c.p391a;

import p026rx.C14972ha;
import p026rx.C14980ia;
import p026rx.p390c.p392b.C14773d;

/* renamed from: rx.c.a.yb */
/* compiled from: SingleLiftObservableOperator */
final class C14762yb<T> extends C14972ha<T> {

    /* renamed from: b */
    final C14980ia<? super T> f43921b;

    C14762yb(C14980ia<? super T> actual) {
        this.f43921b = actual;
    }

    /* renamed from: a */
    public void mo45712a(T value) {
        C14980ia<? super T> iaVar = this.f43921b;
        iaVar.setProducer(new C14773d(iaVar, value));
    }

    public void onError(Throwable error) {
        this.f43921b.onError(error);
    }
}
