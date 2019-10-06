package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p327d.p331d.C13276b;

/* renamed from: f.a.d.e.b.Ja */
/* compiled from: ObservableRange */
public final class C13385Ja extends C13797m<Integer> {

    /* renamed from: a */
    private final int f40698a;

    /* renamed from: b */
    private final long f40699b;

    /* renamed from: f.a.d.e.b.Ja$a */
    /* compiled from: ObservableRange */
    static final class C13386a extends C13276b<Integer> {

        /* renamed from: a */
        final C13804t<? super Integer> f40700a;

        /* renamed from: b */
        final long f40701b;

        /* renamed from: c */
        long f40702c;

        /* renamed from: d */
        boolean f40703d;

        C13386a(C13804t<? super Integer> actual, long start, long end) {
            this.f40700a = actual;
            this.f40702c = start;
            this.f40701b = end;
        }

        /* access modifiers changed from: 0000 */
        public void run() {
            if (!this.f40703d) {
                Observer<? super Integer> actual = this.f40700a;
                long e = this.f40701b;
                for (long i = this.f40702c; i != e && get() == 0; i++) {
                    actual.onNext(Integer.valueOf((int) i));
                }
                if (get() == 0) {
                    lazySet(1);
                    actual.onComplete();
                }
            }
        }

        public Integer poll() throws Exception {
            long i = this.f40702c;
            if (i != this.f40701b) {
                this.f40702c = 1 + i;
                return Integer.valueOf((int) i);
            }
            lazySet(1);
            return null;
        }

        public boolean isEmpty() {
            return this.f40702c == this.f40701b;
        }

        public void clear() {
            this.f40702c = this.f40701b;
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
            this.f40703d = true;
            return 1;
        }
    }

    public C13385Ja(int start, int count) {
        this.f40698a = start;
        this.f40699b = ((long) start) + ((long) count);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super Integer> o) {
        C13386a parent = new C13386a(o, (long) this.f40698a, this.f40699b);
        o.onSubscribe(parent);
        parent.run();
    }
}
