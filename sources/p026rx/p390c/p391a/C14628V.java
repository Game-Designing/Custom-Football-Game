package p026rx.p390c.p391a;

import p026rx.p027b.C0128a;
import p026rx.p029i.C0136c;

/* renamed from: rx.c.a.V */
/* compiled from: OnSubscribeRefCount */
class C14628V implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C0136c f43570a;

    /* renamed from: b */
    final /* synthetic */ C14630W f43571b;

    C14628V(C14630W w, C0136c cVar) {
        this.f43571b = w;
        this.f43570a = cVar;
    }

    public void call() {
        this.f43571b.f43579d.lock();
        try {
            if (this.f43571b.f43577b == this.f43570a && this.f43571b.f43578c.decrementAndGet() == 0) {
                this.f43571b.f43577b.unsubscribe();
                this.f43571b.f43577b = new C0136c();
            }
        } finally {
            this.f43571b.f43579d.unlock();
        }
    }
}
