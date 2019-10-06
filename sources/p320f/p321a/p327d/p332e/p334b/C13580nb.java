package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.nb */
/* compiled from: ObservableTake */
public final class C13580nb<T> extends C13485a<T, T> {

    /* renamed from: b */
    final long f41333b;

    /* renamed from: f.a.d.e.b.nb$a */
    /* compiled from: ObservableTake */
    static final class C13581a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41334a;

        /* renamed from: b */
        boolean f41335b;

        /* renamed from: c */
        C13194b f41336c;

        /* renamed from: d */
        long f41337d;

        C13581a(C13804t<? super T> actual, long limit) {
            this.f41334a = actual;
            this.f41337d = limit;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41336c, s)) {
                this.f41336c = s;
                if (this.f41337d == 0) {
                    this.f41335b = true;
                    s.dispose();
                    C13219d.m43156a(this.f41334a);
                    return;
                }
                this.f41334a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f41335b) {
                long j = this.f41337d;
                this.f41337d = j - 1;
                if (j > 0) {
                    boolean stop = this.f41337d == 0;
                    this.f41334a.onNext(t);
                    if (stop) {
                        onComplete();
                    }
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f41335b) {
                C13774a.m43836b(t);
                return;
            }
            this.f41335b = true;
            this.f41336c.dispose();
            this.f41334a.onError(t);
        }

        public void onComplete() {
            if (!this.f41335b) {
                this.f41335b = true;
                this.f41336c.dispose();
                this.f41334a.onComplete();
            }
        }

        public void dispose() {
            this.f41336c.dispose();
        }
    }

    public C13580nb(C13802r<T> source, long limit) {
        super(source);
        this.f41333b = limit;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        this.f41005a.subscribe(new C13581a(observer, this.f41333b));
    }
}
