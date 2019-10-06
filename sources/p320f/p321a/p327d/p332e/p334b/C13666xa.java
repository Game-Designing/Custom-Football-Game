package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p331d.C13275a;

/* renamed from: f.a.d.e.b.xa */
/* compiled from: ObservableMap */
public final class C13666xa<T, U> extends C13485a<T, U> {

    /* renamed from: b */
    final C13212n<? super T, ? extends U> f41651b;

    /* renamed from: f.a.d.e.b.xa$a */
    /* compiled from: ObservableMap */
    static final class C13667a<T, U> extends C13275a<T, U> {

        /* renamed from: f */
        final C13212n<? super T, ? extends U> f41652f;

        C13667a(C13804t<? super U> actual, C13212n<? super T, ? extends U> mapper) {
            super(actual);
            this.f41652f = mapper;
        }

        public void onNext(T t) {
            if (!this.f40357d) {
                if (this.f40358e != 0) {
                    this.f40354a.onNext(null);
                    return;
                }
                try {
                    U v = this.f41652f.apply(t);
                    C13264b.m43226a(v, "The mapper function returned a null value.");
                    this.f40354a.onNext(v);
                } catch (Throwable ex) {
                    mo42319a(ex);
                }
            }
        }

        /* renamed from: a */
        public int mo42274a(int mode) {
            return mo42320b(mode);
        }

        public U poll() throws Exception {
            T t = this.f40356c.poll();
            if (t == null) {
                return null;
            }
            U apply = this.f41652f.apply(t);
            C13264b.m43226a(apply, "The mapper function returned a null value.");
            return apply;
        }
    }

    public C13666xa(C13802r<T> source, C13212n<? super T, ? extends U> function) {
        super(source);
        this.f41651b = function;
    }

    public void subscribeActual(C13804t<? super U> t) {
        this.f41005a.subscribe(new C13667a(t, this.f41651b));
    }
}
