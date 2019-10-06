package p026rx.p390c.p391a;

import p026rx.C14508U;
import p026rx.C14980ia;

/* renamed from: rx.c.a.O */
/* compiled from: OnSubscribeRedo */
class C14610O extends C14980ia<Object> {

    /* renamed from: a */
    final /* synthetic */ C14612P f43511a;

    C14610O(C14612P p, C14980ia x0) {
        this.f43511a = p;
        super(x0);
    }

    public void onCompleted() {
        this.f43511a.f43515b.onCompleted();
    }

    public void onError(Throwable e) {
        this.f43511a.f43515b.onError(e);
    }

    public void onNext(Object t) {
        if (this.f43511a.f43515b.isUnsubscribed()) {
            return;
        }
        if (this.f43511a.f43516c.get() > 0) {
            C14612P p = this.f43511a;
            p.f43517d.mo3707a(p.f43518e);
            return;
        }
        this.f43511a.f43519f.compareAndSet(false, true);
    }

    public void setProducer(C14508U producer) {
        producer.request(Long.MAX_VALUE);
    }
}
