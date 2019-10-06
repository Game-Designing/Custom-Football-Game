package p320f.p321a.p342f;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p340j.C13760s;
import p320f.p321a.p342f.C13765a;

/* renamed from: f.a.f.a */
/* compiled from: BaseTestConsumer */
public abstract class C13765a<T, U extends C13765a<T, U>> implements C13194b {

    /* renamed from: a */
    protected final CountDownLatch f41877a = new CountDownLatch(1);

    /* renamed from: b */
    protected final List<T> f41878b = new C13760s();

    /* renamed from: c */
    protected final List<Throwable> f41879c = new C13760s();

    /* renamed from: d */
    protected long f41880d;

    /* renamed from: e */
    protected Thread f41881e;

    /* renamed from: f */
    protected boolean f41882f;

    /* renamed from: g */
    protected int f41883g;

    /* renamed from: h */
    protected int f41884h;
}
