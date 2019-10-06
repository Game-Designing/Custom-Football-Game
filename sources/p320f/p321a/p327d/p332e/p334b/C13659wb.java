package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableTimeout.TimeoutInnerObserver;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13224i;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p331d.C13286l;
import p320f.p321a.p342f.C13767c;
import p320f.p321a.p342f.C13770f;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.wb */
/* compiled from: ObservableTimeout */
public final class C13659wb<T, U, V> extends C13485a<T, T> {

    /* renamed from: b */
    final C13802r<U> f41628b;

    /* renamed from: c */
    final C13212n<? super T, ? extends C13802r<V>> f41629c;

    /* renamed from: d */
    final C13802r<? extends T> f41630d;

    /* renamed from: f.a.d.e.b.wb$a */
    /* compiled from: ObservableTimeout */
    interface C13660a {
        /* renamed from: a */
        void mo42652a(long j);

        /* renamed from: a */
        void mo42653a(Throwable th);
    }

    /* renamed from: f.a.d.e.b.wb$b */
    /* compiled from: ObservableTimeout */
    static final class C13661b<T, U, V> extends C13767c<Object> {

        /* renamed from: b */
        final C13660a f41631b;

        /* renamed from: c */
        final long f41632c;

        /* renamed from: d */
        boolean f41633d;

        C13661b(C13660a parent, long index) {
            this.f41631b = parent;
            this.f41632c = index;
        }

        public void onNext(Object t) {
            if (!this.f41633d) {
                this.f41633d = true;
                dispose();
                this.f41631b.mo42652a(this.f41632c);
            }
        }

        public void onError(Throwable t) {
            if (this.f41633d) {
                C13774a.m43836b(t);
                return;
            }
            this.f41633d = true;
            this.f41631b.mo42653a(t);
        }

        public void onComplete() {
            if (!this.f41633d) {
                this.f41633d = true;
                this.f41631b.mo42652a(this.f41632c);
            }
        }
    }

    /* renamed from: f.a.d.e.b.wb$c */
    /* compiled from: ObservableTimeout */
    static final class C13662c<T, U, V> extends AtomicReference<C13194b> implements C13804t<T>, C13194b, C13660a {

        /* renamed from: a */
        final C13804t<? super T> f41634a;

        /* renamed from: b */
        final C13802r<U> f41635b;

        /* renamed from: c */
        final C13212n<? super T, ? extends C13802r<V>> f41636c;

        /* renamed from: d */
        C13194b f41637d;

        /* renamed from: e */
        volatile long f41638e;

        C13662c(C13804t<? super T> actual, C13802r<U> firstTimeoutIndicator, C13212n<? super T, ? extends C13802r<V>> itemTimeoutIndicator) {
            this.f41634a = actual;
            this.f41635b = firstTimeoutIndicator;
            this.f41636c = itemTimeoutIndicator;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41637d, s)) {
                this.f41637d = s;
                Observer<? super T> a = this.f41634a;
                ObservableSource<U> p = this.f41635b;
                if (p != null) {
                    TimeoutInnerObserver<T, U, V> tis = new C13661b<>(this, 0);
                    if (compareAndSet(null, tis)) {
                        a.onSubscribe(this);
                        p.subscribe(tis);
                        return;
                    }
                    return;
                }
                a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            long idx = this.f41638e + 1;
            this.f41638e = idx;
            this.f41634a.onNext(t);
            C13194b d = (C13194b) get();
            if (d != null) {
                d.dispose();
            }
            try {
                Object apply = this.f41636c.apply(t);
                C13264b.m43226a(apply, "The ObservableSource returned is null");
                ObservableSource<V> p = (C13802r) apply;
                TimeoutInnerObserver<T, U, V> tis = new C13661b<>(this, idx);
                if (compareAndSet(d, tis)) {
                    p.subscribe(tis);
                }
            } catch (Throwable e) {
                C13980a.m44462b(e);
                dispose();
                this.f41634a.onError(e);
            }
        }

        public void onError(Throwable t) {
            C13218c.m43150a((AtomicReference<C13194b>) this);
            this.f41634a.onError(t);
        }

        public void onComplete() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
            this.f41634a.onComplete();
        }

        public void dispose() {
            if (C13218c.m43150a((AtomicReference<C13194b>) this)) {
                this.f41637d.dispose();
            }
        }

        /* renamed from: a */
        public void mo42652a(long idx) {
            if (idx == this.f41638e) {
                dispose();
                this.f41634a.onError(new TimeoutException());
            }
        }

        /* renamed from: a */
        public void mo42653a(Throwable e) {
            this.f41637d.dispose();
            this.f41634a.onError(e);
        }
    }

    /* renamed from: f.a.d.e.b.wb$d */
    /* compiled from: ObservableTimeout */
    static final class C13663d<T, U, V> extends AtomicReference<C13194b> implements C13804t<T>, C13194b, C13660a {

        /* renamed from: a */
        final C13804t<? super T> f41639a;

        /* renamed from: b */
        final C13802r<U> f41640b;

        /* renamed from: c */
        final C13212n<? super T, ? extends C13802r<V>> f41641c;

        /* renamed from: d */
        final C13802r<? extends T> f41642d;

        /* renamed from: e */
        final C13224i<T> f41643e;

        /* renamed from: f */
        C13194b f41644f;

        /* renamed from: g */
        boolean f41645g;

        /* renamed from: h */
        volatile long f41646h;

        C13663d(C13804t<? super T> actual, C13802r<U> firstTimeoutIndicator, C13212n<? super T, ? extends C13802r<V>> itemTimeoutIndicator, C13802r<? extends T> other) {
            this.f41639a = actual;
            this.f41640b = firstTimeoutIndicator;
            this.f41641c = itemTimeoutIndicator;
            this.f41642d = other;
            this.f41643e = new C13224i<>(actual, this, 8);
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41644f, s)) {
                this.f41644f = s;
                this.f41643e.mo42285b(s);
                Observer<? super T> a = this.f41639a;
                ObservableSource<U> p = this.f41640b;
                if (p != null) {
                    TimeoutInnerObserver<T, U, V> tis = new C13661b<>(this, 0);
                    if (compareAndSet(null, tis)) {
                        a.onSubscribe(this.f41643e);
                        p.subscribe(tis);
                        return;
                    }
                    return;
                }
                a.onSubscribe(this.f41643e);
            }
        }

        public void onNext(T t) {
            if (!this.f41645g) {
                long idx = this.f41646h + 1;
                this.f41646h = idx;
                if (this.f41643e.mo42283a(t, this.f41644f)) {
                    C13194b d = (C13194b) get();
                    if (d != null) {
                        d.dispose();
                    }
                    try {
                        Object apply = this.f41641c.apply(t);
                        C13264b.m43226a(apply, "The ObservableSource returned is null");
                        ObservableSource<V> p = (C13802r) apply;
                        TimeoutInnerObserver<T, U, V> tis = new C13661b<>(this, idx);
                        if (compareAndSet(d, tis)) {
                            p.subscribe(tis);
                        }
                    } catch (Throwable e) {
                        C13980a.m44462b(e);
                        this.f41639a.onError(e);
                    }
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f41645g) {
                C13774a.m43836b(t);
                return;
            }
            this.f41645g = true;
            dispose();
            this.f41643e.mo42282a(t, this.f41644f);
        }

        public void onComplete() {
            if (!this.f41645g) {
                this.f41645g = true;
                dispose();
                this.f41643e.mo42281a(this.f41644f);
            }
        }

        public void dispose() {
            if (C13218c.m43150a((AtomicReference<C13194b>) this)) {
                this.f41644f.dispose();
            }
        }

        /* renamed from: a */
        public void mo42652a(long idx) {
            if (idx == this.f41646h) {
                dispose();
                this.f41642d.subscribe(new C13286l(this.f41643e));
            }
        }

        /* renamed from: a */
        public void mo42653a(Throwable e) {
            this.f41644f.dispose();
            this.f41639a.onError(e);
        }
    }

    public C13659wb(C13802r<T> source, C13802r<U> firstTimeoutIndicator, C13212n<? super T, ? extends C13802r<V>> itemTimeoutIndicator, C13802r<? extends T> other) {
        super(source);
        this.f41628b = firstTimeoutIndicator;
        this.f41629c = itemTimeoutIndicator;
        this.f41630d = other;
    }

    public void subscribeActual(C13804t<? super T> t) {
        C13802r<? extends T> rVar = this.f41630d;
        if (rVar == null) {
            this.f41005a.subscribe(new C13662c(new C13770f(t), this.f41628b, this.f41629c));
        } else {
            this.f41005a.subscribe(new C13663d(t, this.f41628b, this.f41629c, rVar));
        }
    }
}
