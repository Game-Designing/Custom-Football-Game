package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13775h;
import p320f.p321a.C13787i;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.db */
/* compiled from: ObservableSingleMaybe */
public final class C13510db<T> extends C13775h<T> {

    /* renamed from: a */
    final C13802r<T> f41092a;

    /* renamed from: f.a.d.e.b.db$a */
    /* compiled from: ObservableSingleMaybe */
    static final class C13511a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13787i<? super T> f41093a;

        /* renamed from: b */
        C13194b f41094b;

        /* renamed from: c */
        T f41095c;

        /* renamed from: d */
        boolean f41096d;

        C13511a(C13787i<? super T> actual) {
            this.f41093a = actual;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41094b, s)) {
                this.f41094b = s;
                this.f41093a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41094b.dispose();
        }

        public void onNext(T t) {
            if (!this.f41096d) {
                if (this.f41095c != null) {
                    this.f41096d = true;
                    this.f41094b.dispose();
                    this.f41093a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f41095c = t;
            }
        }

        public void onError(Throwable t) {
            if (this.f41096d) {
                C13774a.m43836b(t);
                return;
            }
            this.f41096d = true;
            this.f41093a.onError(t);
        }

        public void onComplete() {
            if (!this.f41096d) {
                this.f41096d = true;
                T v = this.f41095c;
                this.f41095c = null;
                if (v == null) {
                    this.f41093a.onComplete();
                } else {
                    this.f41093a.onSuccess(v);
                }
            }
        }
    }

    public C13510db(C13802r<T> source) {
        this.f41092a = source;
    }

    /* renamed from: b */
    public void mo42443b(C13787i<? super T> t) {
        this.f41092a.subscribe(new C13511a(t));
    }
}
