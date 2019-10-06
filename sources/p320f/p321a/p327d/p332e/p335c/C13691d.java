package p320f.p321a.p327d.p332e.p335c;

import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.C13814z;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p329b.C13264b;

/* renamed from: f.a.d.e.c.d */
/* compiled from: SingleMap */
public final class C13691d<T, R> extends C13810v<R> {

    /* renamed from: a */
    final C13814z<? extends T> f41711a;

    /* renamed from: b */
    final C13212n<? super T, ? extends R> f41712b;

    /* renamed from: f.a.d.e.c.d$a */
    /* compiled from: SingleMap */
    static final class C13692a<T, R> implements C13812x<T> {

        /* renamed from: a */
        final C13812x<? super R> f41713a;

        /* renamed from: b */
        final C13212n<? super T, ? extends R> f41714b;

        C13692a(C13812x<? super R> t, C13212n<? super T, ? extends R> mapper) {
            this.f41713a = t;
            this.f41714b = mapper;
        }

        public void onSubscribe(C13194b d) {
            this.f41713a.onSubscribe(d);
        }

        public void onSuccess(T value) {
            try {
                R v = this.f41714b.apply(value);
                C13264b.m43226a(v, "The mapper function returned a null value.");
                this.f41713a.onSuccess(v);
            } catch (Throwable e) {
                C13980a.m44462b(e);
                onError(e);
            }
        }

        public void onError(Throwable e) {
            this.f41713a.onError(e);
        }
    }

    public C13691d(C13814z<? extends T> source, C13212n<? super T, ? extends R> mapper) {
        this.f41711a = source;
        this.f41712b = mapper;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super R> t) {
        this.f41711a.mo43156a(new C13692a(t, this.f41712b));
    }
}
