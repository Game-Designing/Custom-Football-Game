package p320f.p321a.p327d.p332e.p334b;

import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Ma */
/* compiled from: ObservableReduceSeedSingle */
public final class C13406Ma<T, R> extends C13810v<R> {

    /* renamed from: a */
    final C13802r<T> f40767a;

    /* renamed from: b */
    final R f40768b;

    /* renamed from: c */
    final C13201c<R, ? super T, R> f40769c;

    /* renamed from: f.a.d.e.b.Ma$a */
    /* compiled from: ObservableReduceSeedSingle */
    static final class C13407a<T, R> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13812x<? super R> f40770a;

        /* renamed from: b */
        final C13201c<R, ? super T, R> f40771b;

        /* renamed from: c */
        R f40772c;

        /* renamed from: d */
        C13194b f40773d;

        C13407a(C13812x<? super R> actual, C13201c<R, ? super T, R> reducer, R value) {
            this.f40770a = actual;
            this.f40772c = value;
            this.f40771b = reducer;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f40773d, d)) {
                this.f40773d = d;
                this.f40770a.onSubscribe(this);
            }
        }

        public void onNext(T value) {
            R v = this.f40772c;
            if (v != null) {
                try {
                    R apply = this.f40771b.apply(v, value);
                    C13264b.m43226a(apply, "The reducer returned a null value");
                    this.f40772c = apply;
                } catch (Throwable ex) {
                    C13980a.m44462b(ex);
                    this.f40773d.dispose();
                    onError(ex);
                }
            }
        }

        public void onError(Throwable e) {
            R v = this.f40772c;
            this.f40772c = null;
            if (v != null) {
                this.f40770a.onError(e);
            } else {
                C13774a.m43836b(e);
            }
        }

        public void onComplete() {
            R v = this.f40772c;
            this.f40772c = null;
            if (v != null) {
                this.f40770a.onSuccess(v);
            }
        }

        public void dispose() {
            this.f40773d.dispose();
        }
    }

    public C13406Ma(C13802r<T> source, R seed, C13201c<R, ? super T, R> reducer) {
        this.f40767a = source;
        this.f40768b = seed;
        this.f40769c = reducer;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super R> observer) {
        this.f40767a.subscribe(new C13407a(observer, this.f40769c, this.f40768b));
    }
}
