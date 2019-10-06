package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableWithLatestFrom.WithLatestFromObserver;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p342f.C13770f;

/* renamed from: f.a.d.e.b.Ib */
/* compiled from: ObservableWithLatestFrom */
public final class C13380Ib<T, U, R> extends C13485a<T, R> {

    /* renamed from: b */
    final C13201c<? super T, ? super U, ? extends R> f40688b;

    /* renamed from: c */
    final C13802r<? extends U> f40689c;

    /* renamed from: f.a.d.e.b.Ib$a */
    /* compiled from: ObservableWithLatestFrom */
    final class C13381a implements C13804t<U> {

        /* renamed from: a */
        private final C13382b<T, U, R> f40690a;

        C13381a(C13382b<T, U, R> wlf) {
            this.f40690a = wlf;
        }

        public void onSubscribe(C13194b s) {
            this.f40690a.mo42427a(s);
        }

        public void onNext(U t) {
            this.f40690a.lazySet(t);
        }

        public void onError(Throwable t) {
            this.f40690a.mo42426a(t);
        }

        public void onComplete() {
        }
    }

    /* renamed from: f.a.d.e.b.Ib$b */
    /* compiled from: ObservableWithLatestFrom */
    static final class C13382b<T, U, R> extends AtomicReference<U> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super R> f40692a;

        /* renamed from: b */
        final C13201c<? super T, ? super U, ? extends R> f40693b;

        /* renamed from: c */
        final AtomicReference<C13194b> f40694c = new AtomicReference<>();

        /* renamed from: d */
        final AtomicReference<C13194b> f40695d = new AtomicReference<>();

        C13382b(C13804t<? super R> actual, C13201c<? super T, ? super U, ? extends R> combiner) {
            this.f40692a = actual;
            this.f40693b = combiner;
        }

        public void onSubscribe(C13194b s) {
            C13218c.m43153c(this.f40694c, s);
        }

        public void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    R r = this.f40693b.apply(t, u);
                    C13264b.m43226a(r, "The combiner returned a null value");
                    this.f40692a.onNext(r);
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    dispose();
                    this.f40692a.onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            C13218c.m43150a(this.f40695d);
            this.f40692a.onError(t);
        }

        public void onComplete() {
            C13218c.m43150a(this.f40695d);
            this.f40692a.onComplete();
        }

        public void dispose() {
            C13218c.m43150a(this.f40694c);
            C13218c.m43150a(this.f40695d);
        }

        /* renamed from: a */
        public boolean mo42427a(C13194b o) {
            return C13218c.m43153c(this.f40695d, o);
        }

        /* renamed from: a */
        public void mo42426a(Throwable e) {
            C13218c.m43150a(this.f40694c);
            this.f40692a.onError(e);
        }
    }

    public C13380Ib(C13802r<T> source, C13201c<? super T, ? super U, ? extends R> combiner, C13802r<? extends U> other) {
        super(source);
        this.f40688b = combiner;
        this.f40689c = other;
    }

    public void subscribeActual(C13804t<? super R> t) {
        SerializedObserver<R> serial = new C13770f<>(t);
        WithLatestFromObserver<T, U, R> wlf = new C13382b<>(serial, this.f40688b);
        serial.onSubscribe(wlf);
        this.f40689c.subscribe(new C13381a(wlf));
        this.f41005a.subscribe(wlf);
    }
}
