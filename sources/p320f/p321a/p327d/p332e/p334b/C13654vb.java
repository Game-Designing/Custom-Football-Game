package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.TimeUnit;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p344h.C13786c;

/* renamed from: f.a.d.e.b.vb */
/* compiled from: ObservableTimeInterval */
public final class C13654vb<T> extends C13485a<T, C13786c<T>> {

    /* renamed from: b */
    final C13805u f41602b;

    /* renamed from: c */
    final TimeUnit f41603c;

    /* renamed from: f.a.d.e.b.vb$a */
    /* compiled from: ObservableTimeInterval */
    static final class C13655a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super C13786c<T>> f41604a;

        /* renamed from: b */
        final TimeUnit f41605b;

        /* renamed from: c */
        final C13805u f41606c;

        /* renamed from: d */
        long f41607d;

        /* renamed from: e */
        C13194b f41608e;

        C13655a(C13804t<? super C13786c<T>> actual, TimeUnit unit, C13805u scheduler) {
            this.f41604a = actual;
            this.f41606c = scheduler;
            this.f41605b = unit;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41608e, s)) {
                this.f41608e = s;
                this.f41607d = this.f41606c.mo43147a(this.f41605b);
                this.f41604a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41608e.dispose();
        }

        public void onNext(T t) {
            long now = this.f41606c.mo43147a(this.f41605b);
            long last = this.f41607d;
            this.f41607d = now;
            this.f41604a.onNext(new C13786c(t, now - last, this.f41605b));
        }

        public void onError(Throwable t) {
            this.f41604a.onError(t);
        }

        public void onComplete() {
            this.f41604a.onComplete();
        }
    }

    public C13654vb(C13802r<T> source, TimeUnit unit, C13805u scheduler) {
        super(source);
        this.f41602b = scheduler;
        this.f41603c = unit;
    }

    public void subscribeActual(C13804t<? super C13786c<T>> t) {
        this.f41005a.subscribe(new C13655a(t, this.f41603c, this.f41602b));
    }
}
