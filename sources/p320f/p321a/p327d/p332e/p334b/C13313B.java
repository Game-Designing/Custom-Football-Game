package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13266a;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.B */
/* compiled from: ObservableCountSingle */
public final class C13313B<T> extends C13810v<Long> implements C13266a<Long> {

    /* renamed from: a */
    final C13802r<T> f40448a;

    /* renamed from: f.a.d.e.b.B$a */
    /* compiled from: ObservableCountSingle */
    static final class C13314a implements C13804t<Object>, C13194b {

        /* renamed from: a */
        final C13812x<? super Long> f40449a;

        /* renamed from: b */
        C13194b f40450b;

        /* renamed from: c */
        long f40451c;

        C13314a(C13812x<? super Long> actual) {
            this.f40449a = actual;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f40450b, d)) {
                this.f40450b = d;
                this.f40449a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f40450b.dispose();
            this.f40450b = C13218c.DISPOSED;
        }

        public void onNext(Object t) {
            this.f40451c++;
        }

        public void onError(Throwable t) {
            this.f40450b = C13218c.DISPOSED;
            this.f40449a.onError(t);
        }

        public void onComplete() {
            this.f40450b = C13218c.DISPOSED;
            this.f40449a.onSuccess(Long.valueOf(this.f40451c));
        }
    }

    public C13313B(C13802r<T> source) {
        this.f40448a = source;
    }

    /* renamed from: b */
    public void mo42365b(C13812x<? super Long> t) {
        this.f40448a.subscribe(new C13314a(t));
    }

    /* renamed from: a */
    public C13797m<Long> mo42316a() {
        return C13774a.m43821a((C13797m<T>) new C13306A<T>(this.f40448a));
    }
}
