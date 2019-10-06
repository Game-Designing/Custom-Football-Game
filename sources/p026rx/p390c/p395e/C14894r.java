package p026rx.p390c.p395e;

import p026rx.C14972ha;
import p026rx.Single;
import p026rx.Single.C0124a;
import p026rx.p027b.C0132p;
import rx.SingleSubscriber;

/* renamed from: rx.c.e.r */
/* compiled from: ScalarSynchronousSingle */
class C14894r implements C0124a<R> {

    /* renamed from: a */
    final /* synthetic */ C0132p f44194a;

    /* renamed from: b */
    final /* synthetic */ C14895s f44195b;

    C14894r(C14895s sVar, C0132p pVar) {
        this.f44195b = sVar;
        this.f44194a = pVar;
    }

    /* renamed from: a */
    public void call(C14972ha<? super R> child) {
        Single<? extends R> o = (Single) this.f44194a.call(this.f44195b.f44196b);
        if (o instanceof C14895s) {
            child.mo45712a(((C14895s) o).f44196b);
            return;
        }
        SingleSubscriber<R> subscriber = new C14893q<>(this, child);
        child.mo46195b(subscriber);
        o.mo3691a((C14972ha<? super T>) subscriber);
    }
}
