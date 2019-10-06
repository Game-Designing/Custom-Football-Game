package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableScalarXMap.ScalarDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p330c.C13269d;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Ya */
/* compiled from: ObservableScalarXMap */
public final class C13475Ya {

    /* renamed from: f.a.d.e.b.Ya$a */
    /* compiled from: ObservableScalarXMap */
    public static final class C13476a<T> extends AtomicInteger implements C13269d<T>, Runnable {

        /* renamed from: a */
        final C13804t<? super T> f40977a;

        /* renamed from: b */
        final T f40978b;

        public C13476a(C13804t<? super T> observer, T value) {
            this.f40977a = observer;
            this.f40978b = value;
        }

        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.f40978b;
        }

        public boolean isEmpty() {
            return get() != 1;
        }

        public void clear() {
            lazySet(3);
        }

        public void dispose() {
            set(3);
        }

        /* renamed from: a */
        public int mo42274a(int mode) {
            if ((mode & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f40977a.onNext(this.f40978b);
                if (get() == 2) {
                    lazySet(3);
                    this.f40977a.onComplete();
                }
            }
        }
    }

    /* renamed from: f.a.d.e.b.Ya$b */
    /* compiled from: ObservableScalarXMap */
    static final class C13477b<T, R> extends C13797m<R> {

        /* renamed from: a */
        final T f40979a;

        /* renamed from: b */
        final C13212n<? super T, ? extends C13802r<? extends R>> f40980b;

        C13477b(T value, C13212n<? super T, ? extends C13802r<? extends R>> mapper) {
            this.f40979a = value;
            this.f40980b = mapper;
        }

        public void subscribeActual(C13804t<? super R> s) {
            try {
                Object apply = this.f40980b.apply(this.f40979a);
                C13264b.m43226a(apply, "The mapper returned a null ObservableSource");
                C13802r rVar = (C13802r) apply;
                if (rVar instanceof Callable) {
                    try {
                        R u = ((Callable) rVar).call();
                        if (u == null) {
                            C13219d.m43156a(s);
                            return;
                        }
                        ScalarDisposable<R> sd = new C13476a<>(s, u);
                        s.onSubscribe(sd);
                        sd.run();
                    } catch (Throwable ex) {
                        C13980a.m44462b(ex);
                        C13219d.m43157a(ex, s);
                    }
                } else {
                    rVar.subscribe(s);
                }
            } catch (Throwable e) {
                C13219d.m43157a(e, s);
            }
        }
    }

    /* renamed from: a */
    public static <T, R> boolean m43450a(C13802r<T> source, C13804t<? super R> observer, C13212n<? super T, ? extends C13802r<? extends R>> mapper) {
        if (!(source instanceof Callable)) {
            return false;
        }
        try {
            T t = ((Callable) source).call();
            if (t == null) {
                C13219d.m43156a(observer);
                return true;
            }
            try {
                Object apply = mapper.apply(t);
                C13264b.m43226a(apply, "The mapper returned a null ObservableSource");
                C13802r rVar = (C13802r) apply;
                if (rVar instanceof Callable) {
                    try {
                        R u = ((Callable) rVar).call();
                        if (u == null) {
                            C13219d.m43156a(observer);
                            return true;
                        }
                        ScalarDisposable<R> sd = new C13476a<>(observer, u);
                        observer.onSubscribe(sd);
                        sd.run();
                    } catch (Throwable ex) {
                        C13980a.m44462b(ex);
                        C13219d.m43157a(ex, observer);
                        return true;
                    }
                } else {
                    rVar.subscribe(observer);
                }
                return true;
            } catch (Throwable ex2) {
                C13980a.m44462b(ex2);
                C13219d.m43157a(ex2, observer);
                return true;
            }
        } catch (Throwable ex3) {
            C13980a.m44462b(ex3);
            C13219d.m43157a(ex3, observer);
            return true;
        }
    }

    /* renamed from: a */
    public static <T, U> C13797m<U> m43449a(T value, C13212n<? super T, ? extends C13802r<? extends U>> mapper) {
        return C13774a.m43821a((C13797m<T>) new C13477b<T>(value, mapper));
    }
}
