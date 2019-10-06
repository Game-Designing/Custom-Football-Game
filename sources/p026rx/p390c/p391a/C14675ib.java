package p026rx.p390c.p391a;

import java.util.concurrent.TimeUnit;
import p026rx.C0120S;
import p026rx.C0126V;
import p026rx.C14980ia;

/* renamed from: rx.c.a.ib */
/* compiled from: OperatorTimeout */
public final class C14675ib<T> extends C14679jb<T> {
    /* renamed from: a */
    public /* bridge */ /* synthetic */ C14980ia mo45822a(C14980ia x0) {
        return super.call(x0);
    }

    public C14675ib(long timeout, TimeUnit timeUnit, C0120S<? extends T> other, C0126V scheduler) {
        super(new C14664fb(timeout, timeUnit), new C14671hb(timeout, timeUnit), other, scheduler);
    }
}
