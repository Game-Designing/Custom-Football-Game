package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableFromArray.FromArrayDisposable;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p331d.C13277c;

/* renamed from: f.a.d.e.b.da */
/* compiled from: ObservableFromArray */
public final class C13508da<T> extends C13797m<T> {

    /* renamed from: a */
    final T[] f41086a;

    /* renamed from: f.a.d.e.b.da$a */
    /* compiled from: ObservableFromArray */
    static final class C13509a<T> extends C13277c<T> {

        /* renamed from: a */
        final C13804t<? super T> f41087a;

        /* renamed from: b */
        final T[] f41088b;

        /* renamed from: c */
        int f41089c;

        /* renamed from: d */
        boolean f41090d;

        /* renamed from: e */
        volatile boolean f41091e;

        C13509a(C13804t<? super T> actual, T[] array) {
            this.f41087a = actual;
            this.f41088b = array;
        }

        /* renamed from: a */
        public int mo42274a(int mode) {
            if ((mode & 1) == 0) {
                return 0;
            }
            this.f41090d = true;
            return 1;
        }

        public T poll() {
            int i = this.f41089c;
            T[] a = this.f41088b;
            if (i == a.length) {
                return null;
            }
            this.f41089c = i + 1;
            T t = a[i];
            C13264b.m43226a(t, "The array element is null");
            return t;
        }

        public boolean isEmpty() {
            return this.f41089c == this.f41088b.length;
        }

        public void clear() {
            this.f41089c = this.f41088b.length;
        }

        public void dispose() {
            this.f41091e = true;
        }

        /* renamed from: a */
        public boolean mo42549a() {
            return this.f41091e;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42550b() {
            T[] a = this.f41088b;
            int n = a.length;
            for (int i = 0; i < n && !mo42549a(); i++) {
                T value = a[i];
                if (value == null) {
                    C13804t<? super T> tVar = this.f41087a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("The ");
                    sb.append(i);
                    sb.append("th element is null");
                    tVar.onError(new NullPointerException(sb.toString()));
                    return;
                }
                this.f41087a.onNext(value);
            }
            if (mo42549a() == 0) {
                this.f41087a.onComplete();
            }
        }
    }

    public C13508da(T[] array) {
        this.f41086a = array;
    }

    public void subscribeActual(C13804t<? super T> s) {
        FromArrayDisposable<T> d = new C13509a<>(s, this.f41086a);
        s.onSubscribe(d);
        if (!d.f41090d) {
            d.mo42550b();
        }
    }
}
