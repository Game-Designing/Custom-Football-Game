package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p326c.C13214p;
import p320f.p321a.p327d.p331d.C13275a;

/* renamed from: f.a.d.e.b.W */
/* compiled from: ObservableFilter */
public final class C13458W<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13214p<? super T> f40918b;

    /* renamed from: f.a.d.e.b.W$a */
    /* compiled from: ObservableFilter */
    static final class C13459a<T> extends C13275a<T, T> {

        /* renamed from: f */
        final C13214p<? super T> f40919f;

        C13459a(C13804t<? super T> actual, C13214p<? super T> filter) {
            super(actual);
            this.f40919f = filter;
        }

        public void onNext(T t) {
            if (this.f40358e == 0) {
                try {
                    if (this.f40919f.test(t)) {
                        this.f40354a.onNext(t);
                    }
                } catch (Throwable e) {
                    mo42319a(e);
                }
            } else {
                this.f40354a.onNext(null);
            }
        }

        /* renamed from: a */
        public int mo42274a(int mode) {
            return mo42320b(mode);
        }

        public T poll() throws Exception {
            T v;
            do {
                v = this.f40356c.poll();
                if (v == null) {
                    break;
                }
            } while (!this.f40919f.test(v));
            return v;
        }
    }

    public C13458W(C13802r<T> source, C13214p<? super T> predicate) {
        super(source);
        this.f40918b = predicate;
    }

    public void subscribeActual(C13804t<? super T> s) {
        this.f41005a.subscribe(new C13459a(s, this.f40918b));
    }
}
