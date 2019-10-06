package p026rx.p390c.p391a;

import p026rx.C14506Q;
import p026rx.C14508U;
import p026rx.C14980ia;

/* renamed from: rx.c.a.M */
/* compiled from: OnSubscribeRedo */
class C14606M extends C14980ia<C14506Q<?>> {

    /* renamed from: a */
    final /* synthetic */ C14980ia f43504a;

    /* renamed from: b */
    final /* synthetic */ C14608N f43505b;

    C14606M(C14608N n, C14980ia x0, C14980ia iaVar) {
        this.f43505b = n;
        this.f43504a = iaVar;
        super(x0);
    }

    public void onCompleted() {
        this.f43504a.onCompleted();
    }

    public void onError(Throwable e) {
        this.f43504a.onError(e);
    }

    /* renamed from: a */
    public void onNext(C14506Q<?> t) {
        if (t.mo45707g() && this.f43505b.f43509a.f43556d) {
            this.f43504a.onCompleted();
        } else if (!t.mo45708h() || !this.f43505b.f43509a.f43557e) {
            this.f43504a.onNext(t);
        } else {
            this.f43504a.onError(t.mo45702c());
        }
    }

    public void setProducer(C14508U producer) {
        producer.request(Long.MAX_VALUE);
    }
}
