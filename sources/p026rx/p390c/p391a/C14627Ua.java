package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicLong;
import p026rx.C14508U;

/* renamed from: rx.c.a.Ua */
/* compiled from: OperatorTake */
class C14627Ua implements C14508U {

    /* renamed from: a */
    final AtomicLong f43567a = new AtomicLong(0);

    /* renamed from: b */
    final /* synthetic */ C14508U f43568b;

    /* renamed from: c */
    final /* synthetic */ C14629Va f43569c;

    C14627Ua(C14629Va va, C14508U u) {
        this.f43569c = va;
        this.f43568b = u;
    }

    public void request(long n) {
        long r;
        long c;
        if (n > 0 && !this.f43569c.f43573b) {
            do {
                r = this.f43567a.get();
                c = Math.min(n, ((long) this.f43569c.f43575d.f43580a) - r);
                if (c == 0) {
                    return;
                }
            } while (!this.f43567a.compareAndSet(r, r + c));
            this.f43568b.request(c);
        }
    }
}
