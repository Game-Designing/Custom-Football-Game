package p320f.p321a.p327d.p332e.p335c;

import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.C13812x;
import p320f.p321a.C13814z;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.c.g */
/* compiled from: SingleToObservable */
public final class C13697g<T> extends C13797m<T> {

    /* renamed from: a */
    final C13814z<? extends T> f41726a;

    /* renamed from: f.a.d.e.c.g$a */
    /* compiled from: SingleToObservable */
    static final class C13698a<T> implements C13812x<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41727a;

        /* renamed from: b */
        C13194b f41728b;

        C13698a(C13804t<? super T> actual) {
            this.f41727a = actual;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f41728b, d)) {
                this.f41728b = d;
                this.f41727a.onSubscribe(this);
            }
        }

        public void onSuccess(T value) {
            this.f41727a.onNext(value);
            this.f41727a.onComplete();
        }

        public void onError(Throwable e) {
            this.f41727a.onError(e);
        }

        public void dispose() {
            this.f41728b.dispose();
        }
    }

    public C13697g(C13814z<? extends T> source) {
        this.f41726a = source;
    }

    public void subscribeActual(C13804t<? super T> s) {
        this.f41726a.mo43156a(new C13698a(s));
    }
}
