package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13775h;
import p320f.p321a.C13787i;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.ua */
/* compiled from: ObservableLastMaybe */
public final class C13645ua<T> extends C13775h<T> {

    /* renamed from: a */
    final C13802r<T> f41567a;

    /* renamed from: f.a.d.e.b.ua$a */
    /* compiled from: ObservableLastMaybe */
    static final class C13646a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13787i<? super T> f41568a;

        /* renamed from: b */
        C13194b f41569b;

        /* renamed from: c */
        T f41570c;

        C13646a(C13787i<? super T> actual) {
            this.f41568a = actual;
        }

        public void dispose() {
            this.f41569b.dispose();
            this.f41569b = C13218c.DISPOSED;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41569b, s)) {
                this.f41569b = s;
                this.f41568a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f41570c = t;
        }

        public void onError(Throwable t) {
            this.f41569b = C13218c.DISPOSED;
            this.f41570c = null;
            this.f41568a.onError(t);
        }

        public void onComplete() {
            this.f41569b = C13218c.DISPOSED;
            T v = this.f41570c;
            if (v != null) {
                this.f41570c = null;
                this.f41568a.onSuccess(v);
                return;
            }
            this.f41568a.onComplete();
        }
    }

    public C13645ua(C13802r<T> source) {
        this.f41567a = source;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42443b(C13787i<? super T> observer) {
        this.f41567a.subscribe(new C13646a(observer));
    }
}
