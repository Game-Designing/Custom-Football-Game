package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13795k;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.za */
/* compiled from: ObservableMaterialize */
public final class C13682za<T> extends C13485a<T, C13795k<T>> {

    /* renamed from: f.a.d.e.b.za$a */
    /* compiled from: ObservableMaterialize */
    static final class C13683a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super C13795k<T>> f41698a;

        /* renamed from: b */
        C13194b f41699b;

        C13683a(C13804t<? super C13795k<T>> actual) {
            this.f41698a = actual;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41699b, s)) {
                this.f41699b = s;
                this.f41698a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41699b.dispose();
        }

        public void onNext(T t) {
            this.f41698a.onNext(C13795k.m43873a(t));
        }

        public void onError(Throwable t) {
            this.f41698a.onNext(C13795k.m43874a(t));
            this.f41698a.onComplete();
        }

        public void onComplete() {
            this.f41698a.onNext(C13795k.m43872a());
            this.f41698a.onComplete();
        }
    }

    public C13682za(C13802r<T> source) {
        super(source);
    }

    public void subscribeActual(C13804t<? super C13795k<T>> t) {
        this.f41005a.subscribe(new C13683a(t));
    }
}
