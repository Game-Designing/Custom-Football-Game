package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p327d.p331d.C13276b;

/* renamed from: f.a.d.e.b.Ka */
/* compiled from: ObservableRangeLong */
public final class C13393Ka extends C13797m<Long> {

    /* renamed from: a */
    private final long f40722a;

    /* renamed from: b */
    private final long f40723b;

    /* renamed from: f.a.d.e.b.Ka$a */
    /* compiled from: ObservableRangeLong */
    static final class C13394a extends C13276b<Long> {

        /* renamed from: a */
        final C13804t<? super Long> f40724a;

        /* renamed from: b */
        final long f40725b;

        /* renamed from: c */
        long f40726c;

        /* renamed from: d */
        boolean f40727d;

        C13394a(C13804t<? super Long> actual, long start, long end) {
            this.f40724a = actual;
            this.f40726c = start;
            this.f40725b = end;
        }

        /* access modifiers changed from: 0000 */
        public void run() {
            if (!this.f40727d) {
                Observer<? super Long> actual = this.f40724a;
                long e = this.f40725b;
                for (long i = this.f40726c; i != e && get() == 0; i++) {
                    actual.onNext(Long.valueOf(i));
                }
                if (get() == 0) {
                    lazySet(1);
                    actual.onComplete();
                }
            }
        }

        public Long poll() throws Exception {
            long i = this.f40726c;
            if (i != this.f40725b) {
                this.f40726c = 1 + i;
                return Long.valueOf(i);
            }
            lazySet(1);
            return null;
        }

        public boolean isEmpty() {
            return this.f40726c == this.f40725b;
        }

        public void clear() {
            this.f40726c = this.f40725b;
            lazySet(1);
        }

        public void dispose() {
            set(1);
        }

        /* renamed from: a */
        public int mo42274a(int mode) {
            if ((mode & 1) == 0) {
                return 0;
            }
            this.f40727d = true;
            return 1;
        }
    }

    public C13393Ka(long start, long count) {
        this.f40722a = start;
        this.f40723b = count;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super Long> o) {
        long j = this.f40722a;
        C13394a parent = new C13394a(o, j, j + this.f40723b);
        o.onSubscribe(parent);
        parent.run();
    }
}
