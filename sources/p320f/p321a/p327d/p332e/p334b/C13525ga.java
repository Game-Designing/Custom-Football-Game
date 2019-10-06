package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableFromIterable.FromIterableDisposable;
import java.util.Iterator;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p331d.C13277c;

/* renamed from: f.a.d.e.b.ga */
/* compiled from: ObservableFromIterable */
public final class C13525ga<T> extends C13797m<T> {

    /* renamed from: a */
    final Iterable<? extends T> f41133a;

    /* renamed from: f.a.d.e.b.ga$a */
    /* compiled from: ObservableFromIterable */
    static final class C13526a<T> extends C13277c<T> {

        /* renamed from: a */
        final C13804t<? super T> f41134a;

        /* renamed from: b */
        final Iterator<? extends T> f41135b;

        /* renamed from: c */
        volatile boolean f41136c;

        /* renamed from: d */
        boolean f41137d;

        /* renamed from: e */
        boolean f41138e;

        /* renamed from: f */
        boolean f41139f;

        C13526a(C13804t<? super T> actual, Iterator<? extends T> it) {
            this.f41134a = actual;
            this.f41135b = it;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42560b() {
            while (!mo42559a()) {
                try {
                    T v = this.f41135b.next();
                    C13264b.m43226a(v, "The iterator returned a null value");
                    this.f41134a.onNext(v);
                    if (!mo42559a()) {
                        try {
                            if (!this.f41135b.hasNext()) {
                                if (!mo42559a()) {
                                    this.f41134a.onComplete();
                                }
                                return;
                            }
                        } catch (Throwable e) {
                            C13980a.m44462b(e);
                            this.f41134a.onError(e);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable e2) {
                    C13980a.m44462b(e2);
                    this.f41134a.onError(e2);
                    return;
                }
            }
        }

        /* renamed from: a */
        public int mo42274a(int mode) {
            if ((mode & 1) == 0) {
                return 0;
            }
            this.f41137d = true;
            return 1;
        }

        public T poll() {
            if (this.f41138e) {
                return null;
            }
            if (!this.f41139f) {
                this.f41139f = true;
            } else if (!this.f41135b.hasNext()) {
                this.f41138e = true;
                return null;
            }
            T next = this.f41135b.next();
            C13264b.m43226a(next, "The iterator returned a null value");
            return next;
        }

        public boolean isEmpty() {
            return this.f41138e;
        }

        public void clear() {
            this.f41138e = true;
        }

        public void dispose() {
            this.f41136c = true;
        }

        /* renamed from: a */
        public boolean mo42559a() {
            return this.f41136c;
        }
    }

    public C13525ga(Iterable<? extends T> source) {
        this.f41133a = source;
    }

    public void subscribeActual(C13804t<? super T> s) {
        try {
            Iterator<? extends T> it = this.f41133a.iterator();
            try {
                if (!it.hasNext()) {
                    C13219d.m43156a(s);
                    return;
                }
                FromIterableDisposable<T> d = new C13526a<>(s, it);
                s.onSubscribe(d);
                if (!d.f41137d) {
                    d.mo42560b();
                }
            } catch (Throwable e) {
                C13980a.m44462b(e);
                C13219d.m43157a(e, s);
            }
        } catch (Throwable e2) {
            C13980a.m44462b(e2);
            C13219d.m43157a(e2, s);
        }
    }
}
