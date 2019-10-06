package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.atomic.AtomicInteger;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13225j;

/* renamed from: f.a.d.e.b.Pa */
/* compiled from: ObservableRepeat */
public final class C13419Pa<T> extends C13485a<T, T> {

    /* renamed from: b */
    final long f40811b;

    /* renamed from: f.a.d.e.b.Pa$a */
    /* compiled from: ObservableRepeat */
    static final class C13420a<T> extends AtomicInteger implements C13804t<T> {

        /* renamed from: a */
        final C13804t<? super T> f40812a;

        /* renamed from: b */
        final C13225j f40813b;

        /* renamed from: c */
        final C13802r<? extends T> f40814c;

        /* renamed from: d */
        long f40815d;

        C13420a(C13804t<? super T> actual, long count, C13225j sd, C13802r<? extends T> source) {
            this.f40812a = actual;
            this.f40813b = sd;
            this.f40814c = source;
            this.f40815d = count;
        }

        public void onSubscribe(C13194b s) {
            this.f40813b.mo42287a(s);
        }

        public void onNext(T t) {
            this.f40812a.onNext(t);
        }

        public void onError(Throwable t) {
            this.f40812a.onError(t);
        }

        public void onComplete() {
            long r = this.f40815d;
            if (r != Long.MAX_VALUE) {
                this.f40815d = r - 1;
            }
            if (r != 0) {
                mo42451a();
            } else {
                this.f40812a.onComplete();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42451a() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                while (!this.f40813b.mo42286a()) {
                    this.f40814c.subscribe(this);
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                    }
                }
            }
        }
    }

    public C13419Pa(C13797m<T> source, long count) {
        super(source);
        this.f40811b = count;
    }

    public void subscribeActual(C13804t<? super T> s) {
        C13225j sd = new C13225j();
        s.onSubscribe(sd);
        long j = this.f40811b;
        long j2 = Long.MAX_VALUE;
        if (j != Long.MAX_VALUE) {
            j2 = j - 1;
        }
        C13420a aVar = new C13420a(s, j2, sd, this.f41005a);
        aVar.mo42451a();
    }
}
