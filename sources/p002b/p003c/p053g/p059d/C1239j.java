package p002b.p003c.p053g.p059d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: b.c.g.d.j */
/* compiled from: SelfDestructiveThread */
class C1239j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AtomicReference f3993a;

    /* renamed from: b */
    final /* synthetic */ Callable f3994b;

    /* renamed from: c */
    final /* synthetic */ ReentrantLock f3995c;

    /* renamed from: d */
    final /* synthetic */ AtomicBoolean f3996d;

    /* renamed from: e */
    final /* synthetic */ Condition f3997e;

    /* renamed from: f */
    final /* synthetic */ C1240k f3998f;

    C1239j(C1240k this$0, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
        this.f3998f = this$0;
        this.f3993a = atomicReference;
        this.f3994b = callable;
        this.f3995c = reentrantLock;
        this.f3996d = atomicBoolean;
        this.f3997e = condition;
    }

    public void run() {
        try {
            this.f3993a.set(this.f3994b.call());
        } catch (Exception e) {
        }
        this.f3995c.lock();
        try {
            this.f3996d.set(false);
            this.f3997e.signal();
        } finally {
            this.f3995c.unlock();
        }
    }
}
