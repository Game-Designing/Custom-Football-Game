package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13225j;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.H */
/* compiled from: ObservableDelaySubscriptionOther */
public final class C13361H<T, U> extends C13797m<T> {

    /* renamed from: a */
    final C13802r<? extends T> f40619a;

    /* renamed from: b */
    final C13802r<U> f40620b;

    /* renamed from: f.a.d.e.b.H$a */
    /* compiled from: ObservableDelaySubscriptionOther */
    final class C13362a implements C13804t<U> {

        /* renamed from: a */
        final C13225j f40621a;

        /* renamed from: b */
        final C13804t<? super T> f40622b;

        /* renamed from: c */
        boolean f40623c;

        /* renamed from: f.a.d.e.b.H$a$a */
        /* compiled from: ObservableDelaySubscriptionOther */
        final class C13363a implements C13804t<T> {
            C13363a() {
            }

            public void onSubscribe(C13194b d) {
                C13362a.this.f40621a.mo42288b(d);
            }

            public void onNext(T value) {
                C13362a.this.f40622b.onNext(value);
            }

            public void onError(Throwable e) {
                C13362a.this.f40622b.onError(e);
            }

            public void onComplete() {
                C13362a.this.f40622b.onComplete();
            }
        }

        C13362a(C13225j serial, C13804t<? super T> child) {
            this.f40621a = serial;
            this.f40622b = child;
        }

        public void onSubscribe(C13194b d) {
            this.f40621a.mo42288b(d);
        }

        public void onNext(U u) {
            onComplete();
        }

        public void onError(Throwable e) {
            if (this.f40623c) {
                C13774a.m43836b(e);
                return;
            }
            this.f40623c = true;
            this.f40622b.onError(e);
        }

        public void onComplete() {
            if (!this.f40623c) {
                this.f40623c = true;
                C13361H.this.f40619a.subscribe(new C13363a());
            }
        }
    }

    public C13361H(C13802r<? extends T> main, C13802r<U> other) {
        this.f40619a = main;
        this.f40620b = other;
    }

    public void subscribeActual(C13804t<? super T> child) {
        C13225j serial = new C13225j();
        child.onSubscribe(serial);
        this.f40620b.subscribe(new C13362a<>(serial, child));
    }
}
