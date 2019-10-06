package p320f.p321a.p327d.p332e.p334b;

import java.util.NoSuchElementException;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.va */
/* compiled from: ObservableLastSingle */
public final class C13652va<T> extends C13810v<T> {

    /* renamed from: a */
    final C13802r<T> f41596a;

    /* renamed from: b */
    final T f41597b;

    /* renamed from: f.a.d.e.b.va$a */
    /* compiled from: ObservableLastSingle */
    static final class C13653a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13812x<? super T> f41598a;

        /* renamed from: b */
        final T f41599b;

        /* renamed from: c */
        C13194b f41600c;

        /* renamed from: d */
        T f41601d;

        C13653a(C13812x<? super T> actual, T defaultItem) {
            this.f41598a = actual;
            this.f41599b = defaultItem;
        }

        public void dispose() {
            this.f41600c.dispose();
            this.f41600c = C13218c.DISPOSED;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41600c, s)) {
                this.f41600c = s;
                this.f41598a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f41601d = t;
        }

        public void onError(Throwable t) {
            this.f41600c = C13218c.DISPOSED;
            this.f41601d = null;
            this.f41598a.onError(t);
        }

        public void onComplete() {
            this.f41600c = C13218c.DISPOSED;
            T v = this.f41601d;
            if (v != null) {
                this.f41601d = null;
                this.f41598a.onSuccess(v);
                return;
            }
            T v2 = this.f41599b;
            if (v2 != null) {
                this.f41598a.onSuccess(v2);
            } else {
                this.f41598a.onError(new NoSuchElementException());
            }
        }
    }

    public C13652va(C13802r<T> source, T defaultItem) {
        this.f41596a = source;
        this.f41597b = defaultItem;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super T> observer) {
        this.f41596a.subscribe(new C13653a(observer, this.f41597b));
    }
}
