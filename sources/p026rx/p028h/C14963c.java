package p026rx.p028h;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S.C0122a;
import p026rx.C0125T;
import p026rx.C0137ja;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.MissingBackpressureException;
import p026rx.p390c.p391a.C14640a;
import rx.subjects.PublishSubject.PublishSubjectProducer;

/* renamed from: rx.h.c */
/* compiled from: PublishSubject */
public final class C14963c<T> extends C0135f<T, T> {

    /* renamed from: b */
    final C14965b<T> f44293b;

    /* renamed from: rx.h.c$a */
    /* compiled from: PublishSubject */
    static final class C14964a<T> extends AtomicLong implements C14508U, C0137ja, C0125T<T> {

        /* renamed from: a */
        final C14965b<T> f44294a;

        /* renamed from: b */
        final C14980ia<? super T> f44295b;

        /* renamed from: c */
        long f44296c;

        public C14964a(C14965b<T> parent, C14980ia<? super T> actual) {
            this.f44294a = parent;
            this.f44295b = actual;
        }

        public void request(long n) {
            long r;
            if (C14640a.m46284a(n)) {
                do {
                    r = get();
                    if (r == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(r, C14640a.m46282a(r, n)));
            }
        }

        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f44294a.mo46179b(this);
            }
        }

        public void onNext(T t) {
            long r = get();
            if (r != Long.MIN_VALUE) {
                long p = this.f44296c;
                if (r != p) {
                    this.f44296c = 1 + p;
                    this.f44295b.onNext(t);
                    return;
                }
                unsubscribe();
                this.f44295b.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
            }
        }

        public void onError(Throwable e) {
            if (get() != Long.MIN_VALUE) {
                this.f44295b.onError(e);
            }
        }

        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.f44295b.onCompleted();
            }
        }
    }

    /* renamed from: rx.h.c$b */
    /* compiled from: PublishSubject */
    static final class C14965b<T> extends AtomicReference<C14964a<T>[]> implements C0122a<T>, C0125T<T> {

        /* renamed from: a */
        static final C14964a[] f44297a = new C14964a[0];

        /* renamed from: b */
        static final C14964a[] f44298b = new C14964a[0];

        /* renamed from: c */
        Throwable f44299c;

        public C14965b() {
            lazySet(f44297a);
        }

        /* renamed from: a */
        public void call(C14980ia<? super T> t) {
            PublishSubjectProducer<T> pp = new C14964a<>(this, t);
            t.add(pp);
            t.setProducer(pp);
            if (!mo46178a((C14964a<T>) pp)) {
                Throwable ex = this.f44299c;
                if (ex != null) {
                    t.onError(ex);
                } else {
                    t.onCompleted();
                }
            } else if (pp.isUnsubscribed()) {
                mo46179b(pp);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo46178a(C14964a<T> inner) {
            PublishSubjectProducer<T>[] curr;
            PublishSubjectProducer<T>[] next;
            do {
                curr = (C14964a[]) get();
                if (curr == f44298b) {
                    return false;
                }
                int n = curr.length;
                next = new C14964a[(n + 1)];
                System.arraycopy(curr, 0, next, 0, n);
                next[n] = inner;
            } while (!compareAndSet(curr, next));
            return true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo46179b(C14964a<T> inner) {
            PublishSubjectProducer<T>[] curr;
            C14964a[] aVarArr;
            do {
                curr = (C14964a[]) get();
                if (curr != f44298b && curr != f44297a) {
                    int n = curr.length;
                    int j = -1;
                    int i = 0;
                    while (true) {
                        if (i >= n) {
                            break;
                        } else if (curr[i] == inner) {
                            j = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (j >= 0) {
                        if (n == 1) {
                            aVarArr = f44297a;
                        } else {
                            C14964a[] aVarArr2 = new C14964a[(n - 1)];
                            System.arraycopy(curr, 0, aVarArr2, 0, j);
                            System.arraycopy(curr, j + 1, aVarArr2, j, (n - j) - 1);
                            aVarArr = aVarArr2;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(curr, aVarArr));
        }

        public void onNext(T t) {
            for (PublishSubjectProducer<T> pp : (C14964a[]) get()) {
                pp.onNext(t);
            }
        }

        public void onError(Throwable e) {
            this.f44299c = e;
            List<Throwable> errors = null;
            for (PublishSubjectProducer<T> pp : (C14964a[]) getAndSet(f44298b)) {
                try {
                    pp.onError(e);
                } catch (Throwable ex) {
                    if (errors == null) {
                        errors = new ArrayList<>(1);
                    }
                    errors.add(ex);
                }
            }
            C14927a.m46676a(errors);
        }

        public void onCompleted() {
            for (PublishSubjectProducer<T> pp : (C14964a[]) getAndSet(f44298b)) {
                pp.onCompleted();
            }
        }
    }

    /* renamed from: p */
    public static <T> C14963c<T> m46753p() {
        return new C14963c<>(new C14965b());
    }

    protected C14963c(C14965b<T> state) {
        super(state);
        this.f44293b = state;
    }

    public void onNext(T v) {
        this.f44293b.onNext(v);
    }

    public void onError(Throwable e) {
        this.f44293b.onError(e);
    }

    public void onCompleted() {
        this.f44293b.onCompleted();
    }
}
