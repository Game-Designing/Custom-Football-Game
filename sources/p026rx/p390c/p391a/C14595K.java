package p026rx.p390c.p391a;

import p026rx.C14506Q;
import p026rx.C14508U;
import p026rx.C14980ia;

/* renamed from: rx.c.a.K */
/* compiled from: OnSubscribeRedo */
class C14595K extends C14980ia<T> {

    /* renamed from: a */
    boolean f43472a;

    /* renamed from: b */
    final /* synthetic */ C14601L f43473b;

    C14595K(C14601L l) {
        this.f43473b = l;
    }

    public void onCompleted() {
        if (!this.f43472a) {
            this.f43472a = true;
            unsubscribe();
            this.f43473b.f43489b.onNext(C14506Q.m46147a());
        }
    }

    public void onError(Throwable e) {
        if (!this.f43472a) {
            this.f43472a = true;
            unsubscribe();
            this.f43473b.f43489b.onNext(C14506Q.m46149a(e));
        }
    }

    public void onNext(T v) {
        if (!this.f43472a) {
            this.f43473b.f43488a.onNext(v);
            m46240a();
            this.f43473b.f43490c.mo45914a(1);
        }
    }

    /* renamed from: a */
    private void m46240a() {
        long cc;
        do {
            cc = this.f43473b.f43491d.get();
            if (cc == Long.MAX_VALUE) {
                return;
            }
        } while (!this.f43473b.f43491d.compareAndSet(cc, cc - 1));
    }

    public void setProducer(C14508U producer) {
        this.f43473b.f43490c.mo45915a(producer);
    }
}
