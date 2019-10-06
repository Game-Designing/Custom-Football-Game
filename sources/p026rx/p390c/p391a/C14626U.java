package p026rx.p390c.p391a;

import p026rx.C14980ia;
import p026rx.p029i.C0136c;

/* renamed from: rx.c.a.U */
/* compiled from: OnSubscribeRefCount */
class C14626U extends C14980ia<T> {

    /* renamed from: a */
    final /* synthetic */ C14980ia f43564a;

    /* renamed from: b */
    final /* synthetic */ C0136c f43565b;

    /* renamed from: c */
    final /* synthetic */ C14630W f43566c;

    C14626U(C14630W w, C14980ia x0, C14980ia iaVar, C0136c cVar) {
        this.f43566c = w;
        this.f43564a = iaVar;
        this.f43565b = cVar;
        super(x0);
    }

    public void onError(Throwable e) {
        mo45795a();
        this.f43564a.onError(e);
    }

    public void onNext(T t) {
        this.f43564a.onNext(t);
    }

    public void onCompleted() {
        mo45795a();
        this.f43564a.onCompleted();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo45795a() {
        this.f43566c.f43579d.lock();
        try {
            if (this.f43566c.f43577b == this.f43565b) {
                this.f43566c.f43577b.unsubscribe();
                this.f43566c.f43577b = new C0136c();
                this.f43566c.f43578c.set(0);
            }
        } finally {
            this.f43566c.f43579d.unlock();
        }
    }
}
