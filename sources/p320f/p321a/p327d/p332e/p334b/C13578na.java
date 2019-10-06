package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;

/* renamed from: f.a.d.e.b.na */
/* compiled from: ObservableIgnoreElements */
public final class C13578na<T> extends C13485a<T, T> {

    /* renamed from: f.a.d.e.b.na$a */
    /* compiled from: ObservableIgnoreElements */
    static final class C13579a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41331a;

        /* renamed from: b */
        C13194b f41332b;

        C13579a(C13804t<? super T> t) {
            this.f41331a = t;
        }

        public void onSubscribe(C13194b s) {
            this.f41332b = s;
            this.f41331a.onSubscribe(this);
        }

        public void onNext(T t) {
        }

        public void onError(Throwable e) {
            this.f41331a.onError(e);
        }

        public void onComplete() {
            this.f41331a.onComplete();
        }

        public void dispose() {
            this.f41332b.dispose();
        }
    }

    public C13578na(C13802r<T> source) {
        super(source);
    }

    public void subscribeActual(C13804t<? super T> t) {
        this.f41005a.subscribe(new C13579a(t));
    }
}
