package p320f.p321a.p327d.p332e.p334b;

import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13214p;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.tb */
/* compiled from: ObservableTakeWhile */
public final class C13638tb<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13214p<? super T> f41533b;

    /* renamed from: f.a.d.e.b.tb$a */
    /* compiled from: ObservableTakeWhile */
    static final class C13639a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41534a;

        /* renamed from: b */
        final C13214p<? super T> f41535b;

        /* renamed from: c */
        C13194b f41536c;

        /* renamed from: d */
        boolean f41537d;

        C13639a(C13804t<? super T> actual, C13214p<? super T> predicate) {
            this.f41534a = actual;
            this.f41535b = predicate;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41536c, s)) {
                this.f41536c = s;
                this.f41534a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41536c.dispose();
        }

        public void onNext(T t) {
            if (!this.f41537d) {
                try {
                    if (!this.f41535b.test(t)) {
                        this.f41537d = true;
                        this.f41536c.dispose();
                        this.f41534a.onComplete();
                        return;
                    }
                    this.f41534a.onNext(t);
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f41536c.dispose();
                    onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f41537d) {
                C13774a.m43836b(t);
                return;
            }
            this.f41537d = true;
            this.f41534a.onError(t);
        }

        public void onComplete() {
            if (!this.f41537d) {
                this.f41537d = true;
                this.f41534a.onComplete();
            }
        }
    }

    public C13638tb(C13802r<T> source, C13214p<? super T> predicate) {
        super(source);
        this.f41533b = predicate;
    }

    public void subscribeActual(C13804t<? super T> t) {
        this.f41005a.subscribe(new C13639a(t, this.f41533b));
    }
}
