package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.fuseable.QueueDisposable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13199a;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13269d;
import p320f.p321a.p327d.p331d.C13276b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.N */
/* compiled from: ObservableDoFinally */
public final class C13409N<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13199a f40776b;

    /* renamed from: f.a.d.e.b.N$a */
    /* compiled from: ObservableDoFinally */
    static final class C13410a<T> extends C13276b<T> implements C13804t<T> {

        /* renamed from: a */
        final C13804t<? super T> f40777a;

        /* renamed from: b */
        final C13199a f40778b;

        /* renamed from: c */
        C13194b f40779c;

        /* renamed from: d */
        C13269d<T> f40780d;

        /* renamed from: e */
        boolean f40781e;

        C13410a(C13804t<? super T> actual, C13199a onFinally) {
            this.f40777a = actual;
            this.f40778b = onFinally;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f40779c, d)) {
                this.f40779c = d;
                if (d instanceof C13269d) {
                    this.f40780d = (C13269d) d;
                }
                this.f40777a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f40777a.onNext(t);
        }

        public void onError(Throwable t) {
            this.f40777a.onError(t);
            mo42446a();
        }

        public void onComplete() {
            this.f40777a.onComplete();
            mo42446a();
        }

        public void dispose() {
            this.f40779c.dispose();
            mo42446a();
        }

        /* renamed from: a */
        public int mo42274a(int mode) {
            QueueDisposable<T> qd = this.f40780d;
            boolean z = false;
            if (qd == null || (mode & 4) != 0) {
                return 0;
            }
            int m = qd.mo42274a(mode);
            if (m != 0) {
                if (m == 1) {
                    z = true;
                }
                this.f40781e = z;
            }
            return m;
        }

        public void clear() {
            this.f40780d.clear();
        }

        public boolean isEmpty() {
            return this.f40780d.isEmpty();
        }

        public T poll() throws Exception {
            T v = this.f40780d.poll();
            if (v == null && this.f40781e) {
                mo42446a();
            }
            return v;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42446a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f40778b.run();
                } catch (Throwable ex) {
                    C13980a.m44462b(ex);
                    C13774a.m43836b(ex);
                }
            }
        }
    }

    public C13409N(C13802r<T> source, C13199a onFinally) {
        super(source);
        this.f40776b = onFinally;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> s) {
        this.f41005a.subscribe(new C13410a(s, this.f40776b));
    }
}
