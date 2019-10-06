package p320f.p321a.p327d.p332e.p334b;

import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13214p;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.sb */
/* compiled from: ObservableTakeUntilPredicate */
public final class C13632sb<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13214p<? super T> f41509b;

    /* renamed from: f.a.d.e.b.sb$a */
    /* compiled from: ObservableTakeUntilPredicate */
    static final class C13633a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41510a;

        /* renamed from: b */
        final C13214p<? super T> f41511b;

        /* renamed from: c */
        C13194b f41512c;

        /* renamed from: d */
        boolean f41513d;

        C13633a(C13804t<? super T> actual, C13214p<? super T> predicate) {
            this.f41510a = actual;
            this.f41511b = predicate;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41512c, s)) {
                this.f41512c = s;
                this.f41510a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41512c.dispose();
        }

        public void onNext(T t) {
            if (!this.f41513d) {
                this.f41510a.onNext(t);
                try {
                    if (this.f41511b.test(t)) {
                        this.f41513d = true;
                        this.f41512c.dispose();
                        this.f41510a.onComplete();
                    }
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f41512c.dispose();
                    onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            if (!this.f41513d) {
                this.f41513d = true;
                this.f41510a.onError(t);
                return;
            }
            C13774a.m43836b(t);
        }

        public void onComplete() {
            if (!this.f41513d) {
                this.f41513d = true;
                this.f41510a.onComplete();
            }
        }
    }

    public C13632sb(C13802r<T> source, C13214p<? super T> predicate) {
        super(source);
        this.f41509b = predicate;
    }

    public void subscribeActual(C13804t<? super T> s) {
        this.f41005a.subscribe(new C13633a(s, this.f41509b));
    }
}
