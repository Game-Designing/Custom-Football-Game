package p320f.p321a.p327d.p332e.p334b;

import java.util.NoSuchElementException;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.eb */
/* compiled from: ObservableSingleSingle */
public final class C13516eb<T> extends C13810v<T> {

    /* renamed from: a */
    final C13802r<? extends T> f41108a;

    /* renamed from: b */
    final T f41109b;

    /* renamed from: f.a.d.e.b.eb$a */
    /* compiled from: ObservableSingleSingle */
    static final class C13517a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13812x<? super T> f41110a;

        /* renamed from: b */
        final T f41111b;

        /* renamed from: c */
        C13194b f41112c;

        /* renamed from: d */
        T f41113d;

        /* renamed from: e */
        boolean f41114e;

        C13517a(C13812x<? super T> actual, T defaultValue) {
            this.f41110a = actual;
            this.f41111b = defaultValue;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41112c, s)) {
                this.f41112c = s;
                this.f41110a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41112c.dispose();
        }

        public void onNext(T t) {
            if (!this.f41114e) {
                if (this.f41113d != null) {
                    this.f41114e = true;
                    this.f41112c.dispose();
                    this.f41110a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f41113d = t;
            }
        }

        public void onError(Throwable t) {
            if (this.f41114e) {
                C13774a.m43836b(t);
                return;
            }
            this.f41114e = true;
            this.f41110a.onError(t);
        }

        public void onComplete() {
            if (!this.f41114e) {
                this.f41114e = true;
                T v = this.f41113d;
                this.f41113d = null;
                if (v == null) {
                    v = this.f41111b;
                }
                if (v != null) {
                    this.f41110a.onSuccess(v);
                } else {
                    this.f41110a.onError(new NoSuchElementException());
                }
            }
        }
    }

    public C13516eb(C13802r<? extends T> source, T defaultValue) {
        this.f41108a = source;
        this.f41109b = defaultValue;
    }

    /* renamed from: b */
    public void mo42365b(C13812x<? super T> t) {
        this.f41108a.subscribe(new C13517a(t, this.f41109b));
    }
}
