package p320f.p321a.p327d.p331d;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p340j.C13753n;

/* renamed from: f.a.d.d.h */
/* compiled from: BlockingObserver */
public final class C13282h<T> extends AtomicReference<C13194b> implements C13804t<T>, C13194b {

    /* renamed from: a */
    public static final Object f40367a = new Object();

    /* renamed from: b */
    final Queue<Object> f40368b;

    public C13282h(Queue<Object> queue) {
        this.f40368b = queue;
    }

    public void onSubscribe(C13194b s) {
        C13218c.m43153c(this, s);
    }

    public void onNext(T t) {
        Queue<Object> queue = this.f40368b;
        C13753n.m43785g(t);
        queue.offer(t);
    }

    public void onError(Throwable t) {
        this.f40368b.offer(C13753n.m43776a(t));
    }

    public void onComplete() {
        this.f40368b.offer(C13753n.m43782e());
    }

    public void dispose() {
        if (C13218c.m43150a((AtomicReference<C13194b>) this)) {
            this.f40368b.offer(f40367a);
        }
    }

    /* renamed from: a */
    public boolean mo42326a() {
        return get() == C13218c.DISPOSED;
    }
}
