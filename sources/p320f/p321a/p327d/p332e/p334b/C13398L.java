package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p326c.C13202d;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p331d.C13275a;

/* renamed from: f.a.d.e.b.L */
/* compiled from: ObservableDistinctUntilChanged */
public final class C13398L<T, K> extends C13485a<T, T> {

    /* renamed from: b */
    final C13212n<? super T, K> f40744b;

    /* renamed from: c */
    final C13202d<? super K, ? super K> f40745c;

    /* renamed from: f.a.d.e.b.L$a */
    /* compiled from: ObservableDistinctUntilChanged */
    static final class C13399a<T, K> extends C13275a<T, T> {

        /* renamed from: f */
        final C13212n<? super T, K> f40746f;

        /* renamed from: g */
        final C13202d<? super K, ? super K> f40747g;

        /* renamed from: h */
        K f40748h;

        /* renamed from: i */
        boolean f40749i;

        C13399a(C13804t<? super T> actual, C13212n<? super T, K> keySelector, C13202d<? super K, ? super K> comparer) {
            super(actual);
            this.f40746f = keySelector;
            this.f40747g = comparer;
        }

        public void onNext(T t) {
            if (!this.f40357d) {
                if (this.f40358e != 0) {
                    this.f40354a.onNext(t);
                    return;
                }
                try {
                    K key = this.f40746f.apply(t);
                    if (this.f40749i) {
                        boolean equal = this.f40747g.test(this.f40748h, key);
                        this.f40748h = key;
                        if (equal) {
                            return;
                        }
                    } else {
                        this.f40749i = true;
                        this.f40748h = key;
                    }
                    this.f40354a.onNext(t);
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
            while (true) {
                T v = this.f40356c.poll();
                if (v == null) {
                    return null;
                }
                K key = this.f40746f.apply(v);
                if (!this.f40749i) {
                    this.f40749i = true;
                    this.f40748h = key;
                    return v;
                } else if (!this.f40747g.test(this.f40748h, key)) {
                    this.f40748h = key;
                    return v;
                } else {
                    this.f40748h = key;
                }
            }
        }
    }

    public C13398L(C13802r<T> source, C13212n<? super T, K> keySelector, C13202d<? super K, ? super K> comparer) {
        super(source);
        this.f40744b = keySelector;
        this.f40745c = comparer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> s) {
        this.f41005a.subscribe(new C13399a(s, this.f40744b, this.f40745c));
    }
}
