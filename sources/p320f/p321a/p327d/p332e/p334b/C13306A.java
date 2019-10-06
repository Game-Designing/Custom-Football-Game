package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.A */
/* compiled from: ObservableCount */
public final class C13306A<T> extends C13485a<T, Long> {

    /* renamed from: f.a.d.e.b.A$a */
    /* compiled from: ObservableCount */
    static final class C13307a implements C13804t<Object>, C13194b {

        /* renamed from: a */
        final C13804t<? super Long> f40432a;

        /* renamed from: b */
        C13194b f40433b;

        /* renamed from: c */
        long f40434c;

        C13307a(C13804t<? super Long> actual) {
            this.f40432a = actual;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40433b, s)) {
                this.f40433b = s;
                this.f40432a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f40433b.dispose();
        }

        public void onNext(Object t) {
            this.f40434c++;
        }

        public void onError(Throwable t) {
            this.f40432a.onError(t);
        }

        public void onComplete() {
            this.f40432a.onNext(Long.valueOf(this.f40434c));
            this.f40432a.onComplete();
        }
    }

    public C13306A(C13802r<T> source) {
        super(source);
    }

    public void subscribeActual(C13804t<? super Long> t) {
        this.f41005a.subscribe(new C13307a(t));
    }
}
