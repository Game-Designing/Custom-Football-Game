package p026rx.p390c.p391a;

import p026rx.C14508U;
import p026rx.C14980ia;

/* renamed from: rx.c.a.Ma */
/* compiled from: OperatorSkip */
class C14607Ma extends C14980ia<T> {

    /* renamed from: a */
    int f43506a;

    /* renamed from: b */
    final /* synthetic */ C14980ia f43507b;

    /* renamed from: c */
    final /* synthetic */ C14609Na f43508c;

    C14607Ma(C14609Na na, C14980ia x0, C14980ia iaVar) {
        this.f43508c = na;
        this.f43507b = iaVar;
        super(x0);
    }

    public void onCompleted() {
        this.f43507b.onCompleted();
    }

    public void onError(Throwable e) {
        this.f43507b.onError(e);
    }

    public void onNext(T t) {
        int i = this.f43506a;
        if (i >= this.f43508c.f43510a) {
            this.f43507b.onNext(t);
        } else {
            this.f43506a = i + 1;
        }
    }

    public void setProducer(C14508U producer) {
        this.f43507b.setProducer(producer);
        producer.request((long) this.f43508c.f43510a);
    }
}
