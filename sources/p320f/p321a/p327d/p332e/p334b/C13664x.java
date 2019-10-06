package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13198c;
import p320f.p321a.C13215d;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.x */
/* compiled from: ObservableConcatWithCompletable */
public final class C13664x<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13215d f41647b;

    /* renamed from: f.a.d.e.b.x$a */
    /* compiled from: ObservableConcatWithCompletable */
    static final class C13665a<T> extends AtomicReference<C13194b> implements C13804t<T>, C13198c, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41648a;

        /* renamed from: b */
        C13215d f41649b;

        /* renamed from: c */
        boolean f41650c;

        C13665a(C13804t<? super T> actual, C13215d other) {
            this.f41648a = actual;
            this.f41649b = other;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43153c(this, d) && !this.f41650c) {
                this.f41648a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f41648a.onNext(t);
        }

        public void onError(Throwable e) {
            this.f41648a.onError(e);
        }

        public void onComplete() {
            if (this.f41650c) {
                this.f41648a.onComplete();
                return;
            }
            this.f41650c = true;
            C13218c.m43151a((AtomicReference<C13194b>) this, (C13194b) null);
            C13215d cs = this.f41649b;
            this.f41649b = null;
            cs.mo42246a(this);
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    public C13664x(C13797m<T> source, C13215d other) {
        super(source);
        this.f41647b = other;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        this.f41005a.subscribe(new C13665a(observer, this.f41647b));
    }
}
