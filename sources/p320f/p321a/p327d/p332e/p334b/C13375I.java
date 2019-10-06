package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13795k;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.I */
/* compiled from: ObservableDematerialize */
public final class C13375I<T> extends C13485a<C13795k<T>, T> {

    /* renamed from: f.a.d.e.b.I$a */
    /* compiled from: ObservableDematerialize */
    static final class C13376a<T> implements C13804t<C13795k<T>>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40680a;

        /* renamed from: b */
        boolean f40681b;

        /* renamed from: c */
        C13194b f40682c;

        C13376a(C13804t<? super T> actual) {
            this.f40680a = actual;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40682c, s)) {
                this.f40682c = s;
                this.f40680a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f40682c.dispose();
        }

        /* renamed from: a */
        public void onNext(C13795k<T> t) {
            if (this.f40681b) {
                if (t.mo42818e()) {
                    C13774a.m43836b(t.mo42815b());
                }
                return;
            }
            if (t.mo42818e()) {
                this.f40682c.dispose();
                onError(t.mo42815b());
            } else if (t.mo42817d()) {
                this.f40682c.dispose();
                onComplete();
            } else {
                this.f40680a.onNext(t.mo42816c());
            }
        }

        public void onError(Throwable t) {
            if (this.f40681b) {
                C13774a.m43836b(t);
                return;
            }
            this.f40681b = true;
            this.f40680a.onError(t);
        }

        public void onComplete() {
            if (!this.f40681b) {
                this.f40681b = true;
                this.f40680a.onComplete();
            }
        }
    }

    public C13375I(C13802r<C13795k<T>> source) {
        super(source);
    }

    public void subscribeActual(C13804t<? super T> t) {
        this.f41005a.subscribe(new C13376a(t));
    }
}
