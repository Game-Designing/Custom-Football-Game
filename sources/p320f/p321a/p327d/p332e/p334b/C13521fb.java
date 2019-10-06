package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;

/* renamed from: f.a.d.e.b.fb */
/* compiled from: ObservableSkip */
public final class C13521fb<T> extends C13485a<T, T> {

    /* renamed from: b */
    final long f41123b;

    /* renamed from: f.a.d.e.b.fb$a */
    /* compiled from: ObservableSkip */
    static final class C13522a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41124a;

        /* renamed from: b */
        long f41125b;

        /* renamed from: c */
        C13194b f41126c;

        C13522a(C13804t<? super T> actual, long n) {
            this.f41124a = actual;
            this.f41125b = n;
        }

        public void onSubscribe(C13194b s) {
            this.f41126c = s;
            this.f41124a.onSubscribe(this);
        }

        public void onNext(T t) {
            long j = this.f41125b;
            if (j != 0) {
                this.f41125b = j - 1;
            } else {
                this.f41124a.onNext(t);
            }
        }

        public void onError(Throwable t) {
            this.f41124a.onError(t);
        }

        public void onComplete() {
            this.f41124a.onComplete();
        }

        public void dispose() {
            this.f41126c.dispose();
        }
    }

    public C13521fb(C13802r<T> source, long n) {
        super(source);
        this.f41123b = n;
    }

    public void subscribeActual(C13804t<? super T> s) {
        this.f41005a.subscribe(new C13522a(s, this.f41123b));
    }
}
