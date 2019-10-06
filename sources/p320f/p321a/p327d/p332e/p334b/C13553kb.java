package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableSubscribeOn.SubscribeOnObserver;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.kb */
/* compiled from: ObservableSubscribeOn */
public final class C13553kb<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13805u f41232b;

    /* renamed from: f.a.d.e.b.kb$a */
    /* compiled from: ObservableSubscribeOn */
    static final class C13554a<T> extends AtomicReference<C13194b> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41233a;

        /* renamed from: b */
        final AtomicReference<C13194b> f41234b = new AtomicReference<>();

        C13554a(C13804t<? super T> actual) {
            this.f41233a = actual;
        }

        public void onSubscribe(C13194b s) {
            C13218c.m43153c(this.f41234b, s);
        }

        public void onNext(T t) {
            this.f41233a.onNext(t);
        }

        public void onError(Throwable t) {
            this.f41233a.onError(t);
        }

        public void onComplete() {
            this.f41233a.onComplete();
        }

        public void dispose() {
            C13218c.m43150a(this.f41234b);
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42575a(C13194b d) {
            C13218c.m43153c(this, d);
        }
    }

    /* renamed from: f.a.d.e.b.kb$b */
    /* compiled from: ObservableSubscribeOn */
    final class C13555b implements Runnable {

        /* renamed from: a */
        private final C13554a<T> f41235a;

        C13555b(C13554a<T> parent) {
            this.f41235a = parent;
        }

        public void run() {
            C13553kb.this.f41005a.subscribe(this.f41235a);
        }
    }

    public C13553kb(C13802r<T> source, C13805u scheduler) {
        super(source);
        this.f41232b = scheduler;
    }

    public void subscribeActual(C13804t<? super T> s) {
        SubscribeOnObserver<T> parent = new C13554a<>(s);
        s.onSubscribe(parent);
        parent.mo42575a(this.f41232b.mo42721a((Runnable) new C13555b(parent)));
    }
}
