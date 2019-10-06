package p026rx.p390c.p393c;

import java.util.concurrent.ThreadFactory;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;

/* renamed from: rx.c.c.n */
/* compiled from: NewThreadScheduler */
public final class C14799n extends C0126V {

    /* renamed from: a */
    private final ThreadFactory f44027a;

    public C14799n(ThreadFactory threadFactory) {
        this.f44027a = threadFactory;
    }

    public C0127a createWorker() {
        return new C14801p(this.f44027a);
    }
}
