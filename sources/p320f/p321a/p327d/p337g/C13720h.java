package p320f.p321a.p327d.p337g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: f.a.d.g.h */
/* compiled from: RxThreadFactory */
public final class C13720h extends AtomicLong implements ThreadFactory {

    /* renamed from: a */
    final String f41803a;

    /* renamed from: b */
    final int f41804b;

    /* renamed from: c */
    final boolean f41805c;

    /* renamed from: f.a.d.g.h$a */
    /* compiled from: RxThreadFactory */
    static final class C13721a extends Thread implements C13719g {
        C13721a(Runnable run, String name) {
            super(run, name);
        }
    }

    public C13720h(String prefix) {
        this(prefix, 5, false);
    }

    public C13720h(String prefix, int priority) {
        this(prefix, priority, false);
    }

    public C13720h(String prefix, int priority, boolean nonBlocking) {
        this.f41803a = prefix;
        this.f41804b = priority;
        this.f41805c = nonBlocking;
    }

    public Thread newThread(Runnable r) {
        StringBuilder sb = new StringBuilder(this.f41803a);
        sb.append('-');
        String name = sb.append(incrementAndGet()).toString();
        Thread t = this.f41805c ? new C13721a(r, name) : new Thread(r, name);
        t.setPriority(this.f41804b);
        t.setDaemon(true);
        return t;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RxThreadFactory[");
        sb.append(this.f41803a);
        sb.append("]");
        return sb.toString();
    }
}
