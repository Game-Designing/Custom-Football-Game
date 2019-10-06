package p320f.p321a.p327d.p332e.p334b;

import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13214p;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.f */
/* compiled from: ObservableAll */
public final class C13518f<T> extends C13485a<T, Boolean> {

    /* renamed from: b */
    final C13214p<? super T> f41115b;

    /* renamed from: f.a.d.e.b.f$a */
    /* compiled from: ObservableAll */
    static final class C13519a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super Boolean> f41116a;

        /* renamed from: b */
        final C13214p<? super T> f41117b;

        /* renamed from: c */
        C13194b f41118c;

        /* renamed from: d */
        boolean f41119d;

        C13519a(C13804t<? super Boolean> actual, C13214p<? super T> predicate) {
            this.f41116a = actual;
            this.f41117b = predicate;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41118c, s)) {
                this.f41118c = s;
                this.f41116a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f41119d) {
                try {
                    if (!this.f41117b.test(t)) {
                        this.f41119d = true;
                        this.f41118c.dispose();
                        this.f41116a.onNext(Boolean.valueOf(false));
                        this.f41116a.onComplete();
                    }
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f41118c.dispose();
                    onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f41119d) {
                C13774a.m43836b(t);
                return;
            }
            this.f41119d = true;
            this.f41116a.onError(t);
        }

        public void onComplete() {
            if (!this.f41119d) {
                this.f41119d = true;
                this.f41116a.onNext(Boolean.valueOf(true));
                this.f41116a.onComplete();
            }
        }

        public void dispose() {
            this.f41118c.dispose();
        }
    }

    public C13518f(C13802r<T> source, C13214p<? super T> predicate) {
        super(source);
        this.f41115b = predicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super Boolean> t) {
        this.f41005a.subscribe(new C13519a(t, this.f41115b));
    }
}
