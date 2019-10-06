package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableCache.ReplayDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13225j;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p340j.C13752m;
import p320f.p321a.p327d.p340j.C13753n;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.q */
/* compiled from: ObservableCache */
public final class C13614q<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13615a<T> f41420b;

    /* renamed from: c */
    final AtomicBoolean f41421c = new AtomicBoolean();

    /* renamed from: f.a.d.e.b.q$a */
    /* compiled from: ObservableCache */
    static final class C13615a<T> extends C13752m implements C13804t<T> {

        /* renamed from: f */
        static final C13616b[] f41422f = new C13616b[0];

        /* renamed from: g */
        static final C13616b[] f41423g = new C13616b[0];

        /* renamed from: h */
        final C13797m<? extends T> f41424h;

        /* renamed from: i */
        final C13225j f41425i = new C13225j();

        /* renamed from: j */
        final AtomicReference<C13616b<T>[]> f41426j = new AtomicReference<>(f41422f);

        /* renamed from: k */
        volatile boolean f41427k;

        /* renamed from: l */
        boolean f41428l;

        C13615a(C13797m<? extends T> source, int capacityHint) {
            super(capacityHint);
            this.f41424h = source;
        }

        /* renamed from: a */
        public boolean mo42620a(C13616b<T> p) {
            ReplayDisposable<T>[] a;
            ReplayDisposable<T>[] b;
            do {
                a = (C13616b[]) this.f41426j.get();
                if (a == f41423g) {
                    return false;
                }
                int n = a.length;
                b = new C13616b[(n + 1)];
                System.arraycopy(a, 0, b, 0, n);
                b[n] = p;
            } while (!this.f41426j.compareAndSet(a, b));
            return true;
        }

        /* renamed from: b */
        public void mo42621b(C13616b<T> p) {
            ReplayDisposable<T>[] a;
            C13616b[] bVarArr;
            do {
                a = (C13616b[]) this.f41426j.get();
                int n = a.length;
                if (n != 0) {
                    int j = -1;
                    int i = 0;
                    while (true) {
                        if (i >= n) {
                            break;
                        } else if (a[i].equals(p)) {
                            j = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (j >= 0) {
                        if (n == 1) {
                            bVarArr = f41422f;
                        } else {
                            C13616b[] bVarArr2 = new C13616b[(n - 1)];
                            System.arraycopy(a, 0, bVarArr2, 0, j);
                            System.arraycopy(a, j + 1, bVarArr2, j, (n - j) - 1);
                            bVarArr = bVarArr2;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.f41426j.compareAndSet(a, bVarArr));
        }

        public void onSubscribe(C13194b s) {
            this.f41425i.mo42288b(s);
        }

        /* renamed from: c */
        public void mo42622c() {
            this.f41424h.subscribe((C13804t<? super T>) this);
            this.f41427k = true;
        }

        public void onNext(T t) {
            if (!this.f41428l) {
                mo42737a(C13753n.m43785g(t));
                for (ReplayDisposable<?> rp : (C13616b[]) this.f41426j.get()) {
                    rp.mo42623a();
                }
            }
        }

        public void onError(Throwable e) {
            if (!this.f41428l) {
                this.f41428l = true;
                mo42737a(C13753n.m43776a(e));
                this.f41425i.dispose();
                for (ReplayDisposable<?> rp : (C13616b[]) this.f41426j.getAndSet(f41423g)) {
                    rp.mo42623a();
                }
            }
        }

        public void onComplete() {
            if (!this.f41428l) {
                this.f41428l = true;
                mo42737a(C13753n.m43782e());
                this.f41425i.dispose();
                for (ReplayDisposable<?> rp : (C13616b[]) this.f41426j.getAndSet(f41423g)) {
                    rp.mo42623a();
                }
            }
        }
    }

    /* renamed from: f.a.d.e.b.q$b */
    /* compiled from: ObservableCache */
    static final class C13616b<T> extends AtomicInteger implements C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41429a;

        /* renamed from: b */
        final C13615a<T> f41430b;

        /* renamed from: c */
        Object[] f41431c;

        /* renamed from: d */
        int f41432d;

        /* renamed from: e */
        int f41433e;

        /* renamed from: f */
        volatile boolean f41434f;

        C13616b(C13804t<? super T> child, C13615a<T> state) {
            this.f41429a = child;
            this.f41430b = state;
        }

        public void dispose() {
            if (!this.f41434f) {
                this.f41434f = true;
                this.f41430b.mo42621b(this);
            }
        }

        /* renamed from: a */
        public void mo42623a() {
            if (getAndIncrement() == 0) {
                Observer<? super T> child = this.f41429a;
                int missed = 1;
                while (!this.f41434f) {
                    int s = this.f41430b.mo42739b();
                    if (s != 0) {
                        Object[] b = this.f41431c;
                        if (b == null) {
                            b = this.f41430b.mo42738a();
                            this.f41431c = b;
                        }
                        int n = b.length - 1;
                        int j = this.f41433e;
                        int k = this.f41432d;
                        while (j < s) {
                            if (!this.f41434f) {
                                if (k == n) {
                                    b = (Object[]) b[n];
                                    k = 0;
                                }
                                if (!C13753n.m43777a(b[k], child)) {
                                    k++;
                                    j++;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (!this.f41434f) {
                            this.f41433e = j;
                            this.f41432d = k;
                            this.f41431c = b;
                        } else {
                            return;
                        }
                    }
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static <T> C13797m<T> m43581a(C13797m<T> source) {
        return m43582a(source, 16);
    }

    /* renamed from: a */
    public static <T> C13797m<T> m43582a(C13797m<T> source, int capacityHint) {
        C13264b.m43222a(capacityHint, "capacityHint");
        return C13774a.m43821a((C13797m<T>) new C13614q<T>(source, new C13615a<>(source, capacityHint)));
    }

    private C13614q(C13797m<T> source, C13615a<T> state) {
        super(source);
        this.f41420b = state;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> t) {
        ReplayDisposable<T> rp = new C13616b<>(t, this.f41420b);
        t.onSubscribe(rp);
        this.f41420b.mo42620a(rp);
        if (!this.f41421c.get() && this.f41421c.compareAndSet(false, true)) {
            this.f41420b.mo42622c();
        }
        rp.mo42623a();
    }
}
