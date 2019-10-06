package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.ma */
/* compiled from: ObservableHide */
public final class C13570ma<T> extends C13485a<T, T> {

    /* renamed from: f.a.d.e.b.ma$a */
    /* compiled from: ObservableHide */
    static final class C13571a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41302a;

        /* renamed from: b */
        C13194b f41303b;

        C13571a(C13804t<? super T> actual) {
            this.f41302a = actual;
        }

        public void dispose() {
            this.f41303b.dispose();
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f41303b, d)) {
                this.f41303b = d;
                this.f41302a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f41302a.onNext(t);
        }

        public void onError(Throwable t) {
            this.f41302a.onError(t);
        }

        public void onComplete() {
            this.f41302a.onComplete();
        }
    }

    public C13570ma(C13802r<T> source) {
        super(source);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> o) {
        this.f41005a.subscribe(new C13571a(o));
    }
}
