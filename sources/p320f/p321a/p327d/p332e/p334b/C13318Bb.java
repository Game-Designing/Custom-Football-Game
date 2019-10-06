package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.atomic.AtomicBoolean;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Bb */
/* compiled from: ObservableUnsubscribeOn */
public final class C13318Bb<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13805u f40463b;

    /* renamed from: f.a.d.e.b.Bb$a */
    /* compiled from: ObservableUnsubscribeOn */
    static final class C13319a<T> extends AtomicBoolean implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40464a;

        /* renamed from: b */
        final C13805u f40465b;

        /* renamed from: c */
        C13194b f40466c;

        /* renamed from: f.a.d.e.b.Bb$a$a */
        /* compiled from: ObservableUnsubscribeOn */
        final class C13320a implements Runnable {
            C13320a() {
            }

            public void run() {
                C13319a.this.f40466c.dispose();
            }
        }

        C13319a(C13804t<? super T> actual, C13805u scheduler) {
            this.f40464a = actual;
            this.f40465b = scheduler;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40466c, s)) {
                this.f40466c = s;
                this.f40464a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!get()) {
                this.f40464a.onNext(t);
            }
        }

        public void onError(Throwable t) {
            if (get()) {
                C13774a.m43836b(t);
            } else {
                this.f40464a.onError(t);
            }
        }

        public void onComplete() {
            if (!get()) {
                this.f40464a.onComplete();
            }
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f40465b.mo42721a((Runnable) new C13320a());
            }
        }
    }

    public C13318Bb(C13802r<T> source, C13805u scheduler) {
        super(source);
        this.f40463b = scheduler;
    }

    public void subscribeActual(C13804t<? super T> t) {
        this.f41005a.subscribe(new C13319a(t, this.f40463b));
    }
}
