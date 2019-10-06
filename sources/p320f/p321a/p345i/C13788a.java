package p320f.p321a.p345i;

import io.reactivex.subjects.PublishSubject.PublishDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.i.a */
/* compiled from: PublishSubject */
public final class C13788a<T> extends C13791c<T> {

    /* renamed from: a */
    static final C13789a[] f41935a = new C13789a[0];

    /* renamed from: b */
    static final C13789a[] f41936b = new C13789a[0];

    /* renamed from: c */
    final AtomicReference<C13789a<T>[]> f41937c = new AtomicReference<>(f41936b);

    /* renamed from: d */
    Throwable f41938d;

    /* renamed from: f.a.i.a$a */
    /* compiled from: PublishSubject */
    static final class C13789a<T> extends AtomicBoolean implements C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41939a;

        /* renamed from: b */
        final C13788a<T> f41940b;

        C13789a(C13804t<? super T> actual, C13788a<T> parent) {
            this.f41939a = actual;
            this.f41940b = parent;
        }

        /* renamed from: a */
        public void mo42803a(T t) {
            if (!get()) {
                this.f41939a.onNext(t);
            }
        }

        /* renamed from: a */
        public void mo42804a(Throwable t) {
            if (get()) {
                C13774a.m43836b(t);
            } else {
                this.f41939a.onError(t);
            }
        }

        /* renamed from: b */
        public void mo42806b() {
            if (!get()) {
                this.f41939a.onComplete();
            }
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f41940b.mo42802b(this);
            }
        }

        /* renamed from: a */
        public boolean mo42805a() {
            return get();
        }
    }

    /* renamed from: b */
    public static <T> C13788a<T> m43852b() {
        return new C13788a<>();
    }

    C13788a() {
    }

    public void subscribeActual(C13804t<? super T> t) {
        PublishDisposable<T> ps = new C13789a<>(t, this);
        t.onSubscribe(ps);
        if (!mo42801a(ps)) {
            Throwable ex = this.f41938d;
            if (ex != null) {
                t.onError(ex);
            } else {
                t.onComplete();
            }
        } else if (ps.mo42805a()) {
            mo42802b(ps);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo42801a(C13789a<T> ps) {
        PublishDisposable<T>[] a;
        PublishDisposable<T>[] b;
        do {
            a = (C13789a[]) this.f41937c.get();
            if (a == f41935a) {
                return false;
            }
            int n = a.length;
            b = new C13789a[(n + 1)];
            System.arraycopy(a, 0, b, 0, n);
            b[n] = ps;
        } while (!this.f41937c.compareAndSet(a, b));
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo42802b(C13789a<T> ps) {
        PublishDisposable<T>[] a;
        C13789a[] aVarArr;
        do {
            a = (C13789a[]) this.f41937c.get();
            if (a != f41935a && a != f41936b) {
                int n = a.length;
                int j = -1;
                int i = 0;
                while (true) {
                    if (i >= n) {
                        break;
                    } else if (a[i] == ps) {
                        j = i;
                        break;
                    } else {
                        i++;
                    }
                }
                if (j >= 0) {
                    if (n == 1) {
                        aVarArr = f41936b;
                    } else {
                        C13789a[] aVarArr2 = new C13789a[(n - 1)];
                        System.arraycopy(a, 0, aVarArr2, 0, j);
                        System.arraycopy(a, j + 1, aVarArr2, j, (n - j) - 1);
                        aVarArr = aVarArr2;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f41937c.compareAndSet(a, aVarArr));
    }

    public void onSubscribe(C13194b s) {
        if (this.f41937c.get() == f41935a) {
            s.dispose();
        }
    }

    public void onNext(T t) {
        C13264b.m43226a(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f41937c.get() != f41935a) {
            for (PublishDisposable<T> s : (C13789a[]) this.f41937c.get()) {
                s.mo42803a(t);
            }
        }
    }

    public void onError(Throwable t) {
        C13264b.m43226a(t, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object obj = this.f41937c.get();
        Object obj2 = f41935a;
        if (obj == obj2) {
            C13774a.m43836b(t);
            return;
        }
        this.f41938d = t;
        for (PublishDisposable<T> s : (C13789a[]) this.f41937c.getAndSet(obj2)) {
            s.mo42804a(t);
        }
    }

    public void onComplete() {
        Object obj = this.f41937c.get();
        Object obj2 = f41935a;
        if (obj != obj2) {
            for (PublishDisposable<T> s : (C13789a[]) this.f41937c.getAndSet(obj2)) {
                s.mo42806b();
            }
        }
    }
}
