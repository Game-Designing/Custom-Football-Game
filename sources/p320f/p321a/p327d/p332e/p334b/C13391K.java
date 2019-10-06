package p320f.p321a.p327d.p332e.p334b;

import java.util.Collection;
import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p331d.C13275a;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.K */
/* compiled from: ObservableDistinct */
public final class C13391K<T, K> extends C13485a<T, T> {

    /* renamed from: b */
    final C13212n<? super T, K> f40718b;

    /* renamed from: c */
    final Callable<? extends Collection<? super K>> f40719c;

    /* renamed from: f.a.d.e.b.K$a */
    /* compiled from: ObservableDistinct */
    static final class C13392a<T, K> extends C13275a<T, T> {

        /* renamed from: f */
        final Collection<? super K> f40720f;

        /* renamed from: g */
        final C13212n<? super T, K> f40721g;

        C13392a(C13804t<? super T> actual, C13212n<? super T, K> keySelector, Collection<? super K> collection) {
            super(actual);
            this.f40721g = keySelector;
            this.f40720f = collection;
        }

        public void onNext(T value) {
            if (!this.f40357d) {
                if (this.f40358e == 0) {
                    try {
                        K key = this.f40721g.apply(value);
                        C13264b.m43226a(key, "The keySelector returned a null key");
                        if (this.f40720f.add(key)) {
                            this.f40354a.onNext(value);
                        }
                    } catch (Throwable ex) {
                        mo42319a(ex);
                    }
                } else {
                    this.f40354a.onNext(null);
                }
            }
        }

        public void onError(Throwable e) {
            if (this.f40357d) {
                C13774a.m43836b(e);
                return;
            }
            this.f40357d = true;
            this.f40720f.clear();
            this.f40354a.onError(e);
        }

        public void onComplete() {
            if (!this.f40357d) {
                this.f40357d = true;
                this.f40720f.clear();
                this.f40354a.onComplete();
            }
        }

        /* renamed from: a */
        public int mo42274a(int mode) {
            return mo42320b(mode);
        }

        public T poll() throws Exception {
            T v;
            Collection<? super K> collection;
            Object apply;
            do {
                v = this.f40356c.poll();
                if (v == null) {
                    break;
                }
                collection = this.f40720f;
                apply = this.f40721g.apply(v);
                C13264b.m43226a(apply, "The keySelector returned a null key");
            } while (!collection.add(apply));
            return v;
        }

        public void clear() {
            this.f40720f.clear();
            super.clear();
        }
    }

    public C13391K(C13802r<T> source, C13212n<? super T, K> keySelector, Callable<? extends Collection<? super K>> collectionSupplier) {
        super(source);
        this.f40718b = keySelector;
        this.f40719c = collectionSupplier;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        try {
            Object call = this.f40719c.call();
            C13264b.m43226a(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.f41005a.subscribe(new C13392a(observer, this.f40718b, (Collection) call));
        } catch (Throwable ex) {
            C13980a.m44462b(ex);
            C13219d.m43157a(ex, observer);
        }
    }
}
