package p320f.p321a.p327d.p332e.p334b;

import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13775h;
import p320f.p321a.C13787i;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.La */
/* compiled from: ObservableReduceMaybe */
public final class C13400La<T> extends C13775h<T> {

    /* renamed from: a */
    final C13802r<T> f40750a;

    /* renamed from: b */
    final C13201c<T, T, T> f40751b;

    /* renamed from: f.a.d.e.b.La$a */
    /* compiled from: ObservableReduceMaybe */
    static final class C13401a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13787i<? super T> f40752a;

        /* renamed from: b */
        final C13201c<T, T, T> f40753b;

        /* renamed from: c */
        boolean f40754c;

        /* renamed from: d */
        T f40755d;

        /* renamed from: e */
        C13194b f40756e;

        C13401a(C13787i<? super T> observer, C13201c<T, T, T> reducer) {
            this.f40752a = observer;
            this.f40753b = reducer;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f40756e, d)) {
                this.f40756e = d;
                this.f40752a.onSubscribe(this);
            }
        }

        public void onNext(T value) {
            if (!this.f40754c) {
                T v = this.f40755d;
                if (v == null) {
                    this.f40755d = value;
                    return;
                }
                try {
                    T apply = this.f40753b.apply(v, value);
                    C13264b.m43226a(apply, "The reducer returned a null value");
                    this.f40755d = apply;
                } catch (Throwable ex) {
                    C13980a.m44462b(ex);
                    this.f40756e.dispose();
                    onError(ex);
                }
            }
        }

        public void onError(Throwable e) {
            if (this.f40754c) {
                C13774a.m43836b(e);
                return;
            }
            this.f40754c = true;
            this.f40755d = null;
            this.f40752a.onError(e);
        }

        public void onComplete() {
            if (!this.f40754c) {
                this.f40754c = true;
                T v = this.f40755d;
                this.f40755d = null;
                if (v != null) {
                    this.f40752a.onSuccess(v);
                } else {
                    this.f40752a.onComplete();
                }
            }
        }

        public void dispose() {
            this.f40756e.dispose();
        }
    }

    public C13400La(C13802r<T> source, C13201c<T, T, T> reducer) {
        this.f40750a = source;
        this.f40751b = reducer;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42443b(C13787i<? super T> observer) {
        this.f40750a.subscribe(new C13401a(observer, this.f40751b));
    }
}
