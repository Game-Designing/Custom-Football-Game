package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p327d.p331d.C13275a;

/* renamed from: f.a.d.e.b.M */
/* compiled from: ObservableDoAfterNext */
public final class C13404M<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13204f<? super T> f40765b;

    /* renamed from: f.a.d.e.b.M$a */
    /* compiled from: ObservableDoAfterNext */
    static final class C13405a<T> extends C13275a<T, T> {

        /* renamed from: f */
        final C13204f<? super T> f40766f;

        C13405a(C13804t<? super T> actual, C13204f<? super T> onAfterNext) {
            super(actual);
            this.f40766f = onAfterNext;
        }

        public void onNext(T t) {
            this.f40354a.onNext(t);
            if (this.f40358e == 0) {
                try {
                    this.f40766f.accept(t);
                } catch (Throwable ex) {
                    mo42319a(ex);
                }
            }
        }

        /* renamed from: a */
        public int mo42274a(int mode) {
            return mo42320b(mode);
        }

        public T poll() throws Exception {
            T v = this.f40356c.poll();
            if (v != null) {
                this.f40766f.accept(v);
            }
            return v;
        }
    }

    public C13404M(C13802r<T> source, C13204f<? super T> onAfterNext) {
        super(source);
        this.f40765b = onAfterNext;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> s) {
        this.f41005a.subscribe(new C13405a(s, this.f40765b));
    }
}
