package p320f.p321a.p327d.p331d;

import io.reactivex.Observer;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p330c.C13273h;
import p320f.p321a.p327d.p340j.C13756o;
import p320f.p321a.p327d.p340j.C13759r;

/* renamed from: f.a.d.d.q */
/* compiled from: QueueDrainObserver */
public abstract class C13291q<T, U, V> extends C13293s implements C13804t<T>, C13756o<U, V> {

    /* renamed from: b */
    protected final C13804t<? super V> f40393b;

    /* renamed from: c */
    protected final C13273h<U> f40394c;

    /* renamed from: d */
    protected volatile boolean f40395d;

    /* renamed from: e */
    protected volatile boolean f40396e;

    /* renamed from: f */
    protected Throwable f40397f;

    public C13291q(C13804t<? super V> actual, C13273h<U> queue) {
        this.f40393b = actual;
        this.f40394c = queue;
    }

    /* renamed from: a */
    public final boolean mo42345a() {
        return this.f40395d;
    }

    public final boolean done() {
        return this.f40396e;
    }

    /* renamed from: b */
    public final boolean mo42347b() {
        return this.f40398a.getAndIncrement() == 0;
    }

    /* renamed from: c */
    public final boolean mo42348c() {
        return this.f40398a.get() == 0 && this.f40398a.compareAndSet(0, 1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo42344a(U value, boolean delayError, C13194b dispose) {
        Observer<? super V> s = this.f40393b;
        SimplePlainQueue<U> q = this.f40394c;
        if (this.f40398a.get() != 0 || !this.f40398a.compareAndSet(0, 1)) {
            q.offer(value);
            if (!mo42347b()) {
                return;
            }
        } else {
            mo42343a(s, value);
            if (mo42342a(-1) == 0) {
                return;
            }
        }
        C13759r.m43798a(q, s, delayError, dispose, this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo42346b(U value, boolean delayError, C13194b disposable) {
        Observer<? super V> s = this.f40393b;
        SimplePlainQueue<U> q = this.f40394c;
        if (this.f40398a.get() != 0 || !this.f40398a.compareAndSet(0, 1)) {
            q.offer(value);
            if (!mo42347b()) {
                return;
            }
        } else if (q.isEmpty()) {
            mo42343a(s, value);
            if (mo42342a(-1) == 0) {
                return;
            }
        } else {
            q.offer(value);
        }
        C13759r.m43798a(q, s, delayError, disposable, this);
    }

    public final Throwable error() {
        return this.f40397f;
    }

    /* renamed from: a */
    public final int mo42342a(int m) {
        return this.f40398a.addAndGet(m);
    }

    /* renamed from: a */
    public void mo42343a(C13804t<? super V> tVar, U u) {
    }
}
