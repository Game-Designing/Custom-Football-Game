package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.SingleSource;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.C13812x;
import p320f.p321a.C13814z;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.z */
/* compiled from: ObservableConcatWithSingle */
public final class C13680z<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13814z<? extends T> f41694b;

    /* renamed from: f.a.d.e.b.z$a */
    /* compiled from: ObservableConcatWithSingle */
    static final class C13681a<T> extends AtomicReference<C13194b> implements C13804t<T>, C13812x<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41695a;

        /* renamed from: b */
        C13814z<? extends T> f41696b;

        /* renamed from: c */
        boolean f41697c;

        C13681a(C13804t<? super T> actual, C13814z<? extends T> other) {
            this.f41695a = actual;
            this.f41696b = other;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43153c(this, d) && !this.f41697c) {
                this.f41695a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f41695a.onNext(t);
        }

        public void onSuccess(T t) {
            this.f41695a.onNext(t);
            this.f41695a.onComplete();
        }

        public void onError(Throwable e) {
            this.f41695a.onError(e);
        }

        public void onComplete() {
            this.f41697c = true;
            C13218c.m43151a((AtomicReference<C13194b>) this, (C13194b) null);
            SingleSource<? extends T> ss = this.f41696b;
            this.f41696b = null;
            ss.mo43156a(this);
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    public C13680z(C13797m<T> source, C13814z<? extends T> other) {
        super(source);
        this.f41694b = other;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        this.f41005a.subscribe(new C13681a(observer, this.f41694b));
    }
}
