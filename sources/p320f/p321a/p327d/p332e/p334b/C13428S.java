package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13775h;
import p320f.p321a.C13787i;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13266a;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.S */
/* compiled from: ObservableElementAtMaybe */
public final class C13428S<T> extends C13775h<T> implements C13266a<T> {

    /* renamed from: a */
    final C13802r<T> f40841a;

    /* renamed from: b */
    final long f40842b;

    /* renamed from: f.a.d.e.b.S$a */
    /* compiled from: ObservableElementAtMaybe */
    static final class C13429a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13787i<? super T> f40843a;

        /* renamed from: b */
        final long f40844b;

        /* renamed from: c */
        C13194b f40845c;

        /* renamed from: d */
        long f40846d;

        /* renamed from: e */
        boolean f40847e;

        C13429a(C13787i<? super T> actual, long index) {
            this.f40843a = actual;
            this.f40844b = index;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40845c, s)) {
                this.f40845c = s;
                this.f40843a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f40845c.dispose();
        }

        public void onNext(T t) {
            if (!this.f40847e) {
                long c = this.f40846d;
                if (c == this.f40844b) {
                    this.f40847e = true;
                    this.f40845c.dispose();
                    this.f40843a.onSuccess(t);
                    return;
                }
                this.f40846d = 1 + c;
            }
        }

        public void onError(Throwable t) {
            if (this.f40847e) {
                C13774a.m43836b(t);
                return;
            }
            this.f40847e = true;
            this.f40843a.onError(t);
        }

        public void onComplete() {
            if (!this.f40847e) {
                this.f40847e = true;
                this.f40843a.onComplete();
            }
        }
    }

    public C13428S(C13802r<T> source, long index) {
        this.f40841a = source;
        this.f40842b = index;
    }

    /* renamed from: b */
    public void mo42443b(C13787i<? super T> t) {
        this.f40841a.subscribe(new C13429a(t, this.f40842b));
    }

    /* renamed from: a */
    public C13797m<T> mo42316a() {
        C13421Q q = new C13421Q(this.f40841a, this.f40842b, null, false);
        return C13774a.m43821a((C13797m<T>) q);
    }
}
