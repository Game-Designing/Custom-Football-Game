package p320f.p321a.p345i;

import io.reactivex.Observer;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p330c.C13274i;
import p320f.p321a.p327d.p331d.C13276b;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.i.d */
/* compiled from: UnicastSubject */
public final class C13792d<T> extends C13791c<T> {

    /* renamed from: a */
    final C13706c<T> f41945a;

    /* renamed from: b */
    final AtomicReference<C13804t<? super T>> f41946b;

    /* renamed from: c */
    final AtomicReference<Runnable> f41947c;

    /* renamed from: d */
    final boolean f41948d;

    /* renamed from: e */
    volatile boolean f41949e;

    /* renamed from: f */
    volatile boolean f41950f;

    /* renamed from: g */
    Throwable f41951g;

    /* renamed from: h */
    final AtomicBoolean f41952h;

    /* renamed from: i */
    final C13276b<T> f41953i;

    /* renamed from: j */
    boolean f41954j;

    /* renamed from: f.a.i.d$a */
    /* compiled from: UnicastSubject */
    final class C13793a extends C13276b<T> {
        C13793a() {
        }

        /* renamed from: a */
        public int mo42274a(int mode) {
            if ((mode & 2) == 0) {
                return 0;
            }
            C13792d.this.f41954j = true;
            return 2;
        }

        public T poll() throws Exception {
            return C13792d.this.f41945a.poll();
        }

        public boolean isEmpty() {
            return C13792d.this.f41945a.isEmpty();
        }

        public void clear() {
            C13792d.this.f41945a.clear();
        }

        public void dispose() {
            if (!C13792d.this.f41949e) {
                C13792d dVar = C13792d.this;
                dVar.f41949e = true;
                dVar.mo42812c();
                C13792d.this.f41946b.lazySet(null);
                if (C13792d.this.f41953i.getAndIncrement() == 0) {
                    C13792d.this.f41946b.lazySet(null);
                    C13792d.this.f41945a.clear();
                }
            }
        }
    }

    /* renamed from: b */
    public static <T> C13792d<T> m43863b() {
        return new C13792d<>(C13797m.bufferSize(), true);
    }

    /* renamed from: a */
    public static <T> C13792d<T> m43861a(int capacityHint) {
        return new C13792d<>(capacityHint, true);
    }

    /* renamed from: a */
    public static <T> C13792d<T> m43862a(int capacityHint, Runnable onTerminate) {
        return new C13792d<>(capacityHint, onTerminate, true);
    }

    C13792d(int capacityHint, boolean delayError) {
        C13264b.m43222a(capacityHint, "capacityHint");
        this.f41945a = new C13706c<>(capacityHint);
        this.f41947c = new AtomicReference<>();
        this.f41948d = delayError;
        this.f41946b = new AtomicReference<>();
        this.f41952h = new AtomicBoolean();
        this.f41953i = new C13793a();
    }

    C13792d(int capacityHint, Runnable onTerminate, boolean delayError) {
        C13264b.m43222a(capacityHint, "capacityHint");
        this.f41945a = new C13706c<>(capacityHint);
        C13264b.m43226a(onTerminate, "onTerminate");
        this.f41947c = new AtomicReference<>(onTerminate);
        this.f41948d = delayError;
        this.f41946b = new AtomicReference<>();
        this.f41952h = new AtomicBoolean();
        this.f41953i = new C13793a();
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        if (this.f41952h.get() || !this.f41952h.compareAndSet(false, true)) {
            C13219d.m43157a((Throwable) new IllegalStateException("Only a single observer allowed."), observer);
        } else {
            observer.onSubscribe(this.f41953i);
            this.f41946b.lazySet(observer);
            if (this.f41949e) {
                this.f41946b.lazySet(null);
                return;
            }
            mo42814d();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo42812c() {
        Runnable r = (Runnable) this.f41947c.get();
        if (r != null && this.f41947c.compareAndSet(r, null)) {
            r.run();
        }
    }

    public void onSubscribe(C13194b s) {
        if (this.f41950f || this.f41949e) {
            s.dispose();
        }
    }

    public void onNext(T t) {
        C13264b.m43226a(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f41950f && !this.f41949e) {
            this.f41945a.offer(t);
            mo42814d();
        }
    }

    public void onError(Throwable t) {
        C13264b.m43226a(t, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f41950f || this.f41949e) {
            C13774a.m43836b(t);
            return;
        }
        this.f41951g = t;
        this.f41950f = true;
        mo42812c();
        mo42814d();
    }

    public void onComplete() {
        if (!this.f41950f && !this.f41949e) {
            this.f41950f = true;
            mo42812c();
            mo42814d();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo42811b(C13804t<? super T> a) {
        int missed = 1;
        SimpleQueue<T> q = this.f41945a;
        boolean failFast = !this.f41948d;
        boolean canBeError = true;
        while (!this.f41949e) {
            boolean d = this.f41950f;
            T v = this.f41945a.poll();
            boolean empty = v == null;
            if (d) {
                if (failFast && canBeError) {
                    if (!mo42810a((C13274i<T>) q, a)) {
                        canBeError = false;
                    } else {
                        return;
                    }
                }
                if (empty) {
                    mo42813c(a);
                    return;
                }
            }
            if (empty) {
                missed = this.f41953i.addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            } else {
                a.onNext(v);
            }
        }
        this.f41946b.lazySet(null);
        q.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42809a(C13804t<? super T> a) {
        int missed = 1;
        SpscLinkedArrayQueue<T> q = this.f41945a;
        boolean failFast = !this.f41948d;
        while (!this.f41949e) {
            boolean d = this.f41950f;
            if (!failFast || !d || !mo42810a((C13274i<T>) q, a)) {
                a.onNext(null);
                if (d) {
                    mo42813c(a);
                    return;
                }
                missed = this.f41953i.addAndGet(-missed);
                if (missed == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f41946b.lazySet(null);
        q.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo42813c(C13804t<? super T> a) {
        this.f41946b.lazySet(null);
        Throwable ex = this.f41951g;
        if (ex != null) {
            a.onError(ex);
        } else {
            a.onComplete();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo42810a(C13274i<T> q, C13804t<? super T> a) {
        Throwable ex = this.f41951g;
        if (ex == null) {
            return false;
        }
        this.f41946b.lazySet(null);
        q.clear();
        a.onError(ex);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo42814d() {
        if (this.f41953i.getAndIncrement() == 0) {
            Observer<? super T> a = (C13804t) this.f41946b.get();
            int missed = 1;
            while (a == null) {
                missed = this.f41953i.addAndGet(-missed);
                if (missed != 0) {
                    a = (C13804t) this.f41946b.get();
                } else {
                    return;
                }
            }
            if (this.f41954j) {
                mo42809a((C13804t<? super T>) a);
            } else {
                mo42811b(a);
            }
        }
    }
}
