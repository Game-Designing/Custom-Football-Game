package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.atomic.AtomicInteger;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13203e;
import p320f.p321a.p327d.p328a.C13225j;

/* renamed from: f.a.d.e.b.Qa */
/* compiled from: ObservableRepeatUntil */
public final class C13423Qa<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13203e f40826b;

    /* renamed from: f.a.d.e.b.Qa$a */
    /* compiled from: ObservableRepeatUntil */
    static final class C13424a<T> extends AtomicInteger implements C13804t<T> {

        /* renamed from: a */
        final C13804t<? super T> f40827a;

        /* renamed from: b */
        final C13225j f40828b;

        /* renamed from: c */
        final C13802r<? extends T> f40829c;

        /* renamed from: d */
        final C13203e f40830d;

        C13424a(C13804t<? super T> actual, C13203e until, C13225j sd, C13802r<? extends T> source) {
            this.f40827a = actual;
            this.f40828b = sd;
            this.f40829c = source;
            this.f40830d = until;
        }

        public void onSubscribe(C13194b s) {
            this.f40828b.mo42287a(s);
        }

        public void onNext(T t) {
            this.f40827a.onNext(t);
        }

        public void onError(Throwable t) {
            this.f40827a.onError(t);
        }

        public void onComplete() {
            try {
                if (this.f40830d.getAsBoolean()) {
                    this.f40827a.onComplete();
                } else {
                    mo42452a();
                }
            } catch (Throwable e) {
                C13980a.m44462b(e);
                this.f40827a.onError(e);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42452a() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                do {
                    this.f40829c.subscribe(this);
                    missed = addAndGet(-missed);
                } while (missed != 0);
            }
        }
    }

    public C13423Qa(C13797m<T> source, C13203e until) {
        super(source);
        this.f40826b = until;
    }

    public void subscribeActual(C13804t<? super T> s) {
        C13225j sd = new C13225j();
        s.onSubscribe(sd);
        new C13424a<>(s, this.f40826b, sd, this.f41005a).mo42452a();
    }
}
