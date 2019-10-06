package p320f.p321a.p327d.p332e.p334b;

import java.util.NoSuchElementException;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13266a;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.T */
/* compiled from: ObservableElementAtSingle */
public final class C13447T<T> extends C13810v<T> implements C13266a<T> {

    /* renamed from: a */
    final C13802r<T> f40884a;

    /* renamed from: b */
    final long f40885b;

    /* renamed from: c */
    final T f40886c;

    /* renamed from: f.a.d.e.b.T$a */
    /* compiled from: ObservableElementAtSingle */
    static final class C13448a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13812x<? super T> f40887a;

        /* renamed from: b */
        final long f40888b;

        /* renamed from: c */
        final T f40889c;

        /* renamed from: d */
        C13194b f40890d;

        /* renamed from: e */
        long f40891e;

        /* renamed from: f */
        boolean f40892f;

        C13448a(C13812x<? super T> actual, long index, T defaultValue) {
            this.f40887a = actual;
            this.f40888b = index;
            this.f40889c = defaultValue;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40890d, s)) {
                this.f40890d = s;
                this.f40887a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f40890d.dispose();
        }

        public void onNext(T t) {
            if (!this.f40892f) {
                long c = this.f40891e;
                if (c == this.f40888b) {
                    this.f40892f = true;
                    this.f40890d.dispose();
                    this.f40887a.onSuccess(t);
                    return;
                }
                this.f40891e = 1 + c;
            }
        }

        public void onError(Throwable t) {
            if (this.f40892f) {
                C13774a.m43836b(t);
                return;
            }
            this.f40892f = true;
            this.f40887a.onError(t);
        }

        public void onComplete() {
            if (!this.f40892f) {
                this.f40892f = true;
                T v = this.f40889c;
                if (v != null) {
                    this.f40887a.onSuccess(v);
                } else {
                    this.f40887a.onError(new NoSuchElementException());
                }
            }
        }
    }

    public C13447T(C13802r<T> source, long index, T defaultValue) {
        this.f40884a = source;
        this.f40885b = index;
        this.f40886c = defaultValue;
    }

    /* renamed from: b */
    public void mo42365b(C13812x<? super T> t) {
        this.f40884a.subscribe(new C13448a(t, this.f40885b, this.f40886c));
    }

    /* renamed from: a */
    public C13797m<T> mo42316a() {
        C13421Q q = new C13421Q(this.f40884a, this.f40885b, this.f40886c, true);
        return C13774a.m43821a((C13797m<T>) q);
    }
}
