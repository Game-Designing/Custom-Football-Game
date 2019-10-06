package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import java.util.ArrayDeque;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.ob */
/* compiled from: ObservableTakeLast */
public final class C13587ob<T> extends C13485a<T, T> {

    /* renamed from: b */
    final int f41349b;

    /* renamed from: f.a.d.e.b.ob$a */
    /* compiled from: ObservableTakeLast */
    static final class C13588a<T> extends ArrayDeque<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41350a;

        /* renamed from: b */
        final int f41351b;

        /* renamed from: c */
        C13194b f41352c;

        /* renamed from: d */
        volatile boolean f41353d;

        C13588a(C13804t<? super T> actual, int count) {
            this.f41350a = actual;
            this.f41351b = count;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41352c, s)) {
                this.f41352c = s;
                this.f41350a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (this.f41351b == size()) {
                poll();
            }
            offer(t);
        }

        public void onError(Throwable t) {
            this.f41350a.onError(t);
        }

        public void onComplete() {
            Observer<? super T> a = this.f41350a;
            while (!this.f41353d) {
                T v = poll();
                if (v == null) {
                    if (!this.f41353d) {
                        a.onComplete();
                    }
                    return;
                }
                a.onNext(v);
            }
        }

        public void dispose() {
            if (!this.f41353d) {
                this.f41353d = true;
                this.f41352c.dispose();
            }
        }
    }

    public C13587ob(C13802r<T> source, int count) {
        super(source);
        this.f41349b = count;
    }

    public void subscribeActual(C13804t<? super T> t) {
        this.f41005a.subscribe(new C13588a(t, this.f41349b));
    }
}
