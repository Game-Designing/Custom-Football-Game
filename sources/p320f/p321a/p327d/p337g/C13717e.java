package p320f.p321a.p327d.p337g;

import java.util.concurrent.ThreadFactory;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;

/* renamed from: f.a.d.g.e */
/* compiled from: NewThreadScheduler */
public final class C13717e extends C13805u {

    /* renamed from: b */
    private static final C13720h f41799b = new C13720h("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: c */
    final ThreadFactory f41800c;

    public C13717e() {
        this(f41799b);
    }

    public C13717e(ThreadFactory threadFactory) {
        this.f41800c = threadFactory;
    }

    /* renamed from: a */
    public C13808c mo42242a() {
        return new C13718f(this.f41800c);
    }
}
