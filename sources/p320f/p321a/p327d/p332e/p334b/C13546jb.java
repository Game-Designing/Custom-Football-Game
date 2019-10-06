package p320f.p321a.p327d.p332e.p334b;

import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13214p;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.jb */
/* compiled from: ObservableSkipWhile */
public final class C13546jb<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13214p<? super T> f41204b;

    /* renamed from: f.a.d.e.b.jb$a */
    /* compiled from: ObservableSkipWhile */
    static final class C13547a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41205a;

        /* renamed from: b */
        final C13214p<? super T> f41206b;

        /* renamed from: c */
        C13194b f41207c;

        /* renamed from: d */
        boolean f41208d;

        C13547a(C13804t<? super T> actual, C13214p<? super T> predicate) {
            this.f41205a = actual;
            this.f41206b = predicate;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41207c, s)) {
                this.f41207c = s;
                this.f41205a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41207c.dispose();
        }

        public void onNext(T t) {
            if (this.f41208d) {
                this.f41205a.onNext(t);
            } else {
                try {
                    if (!this.f41206b.test(t)) {
                        this.f41208d = true;
                        this.f41205a.onNext(t);
                    }
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f41207c.dispose();
                    this.f41205a.onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            this.f41205a.onError(t);
        }

        public void onComplete() {
            this.f41205a.onComplete();
        }
    }

    public C13546jb(C13802r<T> source, C13214p<? super T> predicate) {
        super(source);
        this.f41204b = predicate;
    }

    public void subscribeActual(C13804t<? super T> s) {
        this.f41005a.subscribe(new C13547a(s, this.f41204b));
    }
}
