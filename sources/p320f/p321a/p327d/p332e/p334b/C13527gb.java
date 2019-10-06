package p320f.p321a.p327d.p332e.p334b;

import java.util.ArrayDeque;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.gb */
/* compiled from: ObservableSkipLast */
public final class C13527gb<T> extends C13485a<T, T> {

    /* renamed from: b */
    final int f41140b;

    /* renamed from: f.a.d.e.b.gb$a */
    /* compiled from: ObservableSkipLast */
    static final class C13528a<T> extends ArrayDeque<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41141a;

        /* renamed from: b */
        final int f41142b;

        /* renamed from: c */
        C13194b f41143c;

        C13528a(C13804t<? super T> actual, int skip) {
            super(skip);
            this.f41141a = actual;
            this.f41142b = skip;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41143c, s)) {
                this.f41143c = s;
                this.f41141a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41143c.dispose();
        }

        public void onNext(T t) {
            if (this.f41142b == size()) {
                this.f41141a.onNext(poll());
            }
            offer(t);
        }

        public void onError(Throwable t) {
            this.f41141a.onError(t);
        }

        public void onComplete() {
            this.f41141a.onComplete();
        }
    }

    public C13527gb(C13802r<T> source, int skip) {
        super(source);
        this.f41140b = skip;
    }

    public void subscribeActual(C13804t<? super T> s) {
        this.f41005a.subscribe(new C13528a(s, this.f41140b));
    }
}
