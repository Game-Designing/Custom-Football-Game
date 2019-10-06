package p320f.p321a.p327d.p332e.p335c;

import io.reactivex.SingleSource;
import io.reactivex.internal.operators.single.SingleZipArray.ZipCoordinator;
import io.reactivex.internal.operators.single.SingleZipArray.ZipSingleObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.C13814z;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.c.h */
/* compiled from: SingleZipArray */
public final class C13699h<T, R> extends C13810v<R> {

    /* renamed from: a */
    final C13814z<? extends T>[] f41729a;

    /* renamed from: b */
    final C13212n<? super Object[], ? extends R> f41730b;

    /* renamed from: f.a.d.e.c.h$a */
    /* compiled from: SingleZipArray */
    final class C13700a implements C13212n<T, R> {
        C13700a() {
        }

        public R apply(T t) throws Exception {
            R apply = C13699h.this.f41730b.apply(new Object[]{t});
            C13264b.m43226a(apply, "The zipper returned a null value");
            return apply;
        }
    }

    /* renamed from: f.a.d.e.c.h$b */
    /* compiled from: SingleZipArray */
    static final class C13701b<T, R> extends AtomicInteger implements C13194b {

        /* renamed from: a */
        final C13812x<? super R> f41732a;

        /* renamed from: b */
        final C13212n<? super Object[], ? extends R> f41733b;

        /* renamed from: c */
        final C13702c<T>[] f41734c;

        /* renamed from: d */
        final Object[] f41735d;

        C13701b(C13812x<? super R> observer, int n, C13212n<? super Object[], ? extends R> zipper) {
            super(n);
            this.f41732a = observer;
            this.f41733b = zipper;
            ZipSingleObserver<T>[] o = new C13702c[n];
            for (int i = 0; i < n; i++) {
                o[i] = new C13702c<>(this, i);
            }
            this.f41734c = o;
            this.f41735d = new Object[n];
        }

        /* renamed from: a */
        public boolean mo42670a() {
            return get() <= 0;
        }

        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipSingleObserver<?> d : this.f41734c) {
                    d.mo42671a();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42668a(T value, int index) {
            this.f41735d[index] = value;
            if (decrementAndGet() == 0) {
                try {
                    R v = this.f41733b.apply(this.f41735d);
                    C13264b.m43226a(v, "The zipper returned a null value");
                    this.f41732a.onSuccess(v);
                } catch (Throwable ex) {
                    C13980a.m44462b(ex);
                    this.f41732a.onError(ex);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42667a(int index) {
            ZipSingleObserver<T>[] observers = this.f41734c;
            int n = observers.length;
            for (int i = 0; i < index; i++) {
                observers[i].mo42671a();
            }
            for (int i2 = index + 1; i2 < n; i2++) {
                observers[i2].mo42671a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42669a(Throwable ex, int index) {
            if (getAndSet(0) > 0) {
                mo42667a(index);
                this.f41732a.onError(ex);
                return;
            }
            C13774a.m43836b(ex);
        }
    }

    /* renamed from: f.a.d.e.c.h$c */
    /* compiled from: SingleZipArray */
    static final class C13702c<T> extends AtomicReference<C13194b> implements C13812x<T> {

        /* renamed from: a */
        final C13701b<T, ?> f41736a;

        /* renamed from: b */
        final int f41737b;

        C13702c(C13701b<T, ?> parent, int index) {
            this.f41736a = parent;
            this.f41737b = index;
        }

        /* renamed from: a */
        public void mo42671a() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }

        public void onSubscribe(C13194b d) {
            C13218c.m43153c(this, d);
        }

        public void onSuccess(T value) {
            this.f41736a.mo42668a(value, this.f41737b);
        }

        public void onError(Throwable e) {
            this.f41736a.mo42669a(e, this.f41737b);
        }
    }

    public C13699h(C13814z<? extends T>[] sources, C13212n<? super Object[], ? extends R> zipper) {
        this.f41729a = sources;
        this.f41730b = zipper;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super R> observer) {
        SingleSource<? extends T>[] sources = this.f41729a;
        int n = sources.length;
        if (n == 1) {
            sources[0].mo43156a(new C13692a(observer, new C13700a()));
            return;
        }
        ZipCoordinator<T, R> parent = new C13701b<>(observer, n, this.f41730b);
        observer.onSubscribe(parent);
        int i = 0;
        while (i < n && !parent.mo42670a()) {
            SingleSource<? extends T> source = sources[i];
            if (source == null) {
                parent.mo42669a((Throwable) new NullPointerException("One of the sources is null"), i);
                return;
            } else {
                source.mo43156a(parent.f41734c[i]);
                i++;
            }
        }
    }
}
