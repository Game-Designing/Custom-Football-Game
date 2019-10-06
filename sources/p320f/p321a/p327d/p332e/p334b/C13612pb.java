package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.pb */
/* compiled from: ObservableTakeLastOne */
public final class C13612pb<T> extends C13485a<T, T> {

    /* renamed from: f.a.d.e.b.pb$a */
    /* compiled from: ObservableTakeLastOne */
    static final class C13613a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41417a;

        /* renamed from: b */
        C13194b f41418b;

        /* renamed from: c */
        T f41419c;

        C13613a(C13804t<? super T> actual) {
            this.f41417a = actual;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41418b, s)) {
                this.f41418b = s;
                this.f41417a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f41419c = t;
        }

        public void onError(Throwable t) {
            this.f41419c = null;
            this.f41417a.onError(t);
        }

        public void onComplete() {
            mo42619a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42619a() {
            T v = this.f41419c;
            if (v != null) {
                this.f41419c = null;
                this.f41417a.onNext(v);
            }
            this.f41417a.onComplete();
        }

        public void dispose() {
            this.f41419c = null;
            this.f41418b.dispose();
        }
    }

    public C13612pb(C13802r<T> source) {
        super(source);
    }

    public void subscribeActual(C13804t<? super T> s) {
        this.f41005a.subscribe(new C13613a(s));
    }
}
