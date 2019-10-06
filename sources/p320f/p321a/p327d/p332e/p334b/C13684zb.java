package p320f.p321a.p327d.p332e.p334b;

import java.util.Collection;
import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13226a;
import p320f.p321a.p327d.p329b.C13264b;

/* renamed from: f.a.d.e.b.zb */
/* compiled from: ObservableToList */
public final class C13684zb<T, U extends Collection<? super T>> extends C13485a<T, U> {

    /* renamed from: b */
    final Callable<U> f41700b;

    /* renamed from: f.a.d.e.b.zb$a */
    /* compiled from: ObservableToList */
    static final class C13685a<T, U extends Collection<? super T>> implements C13804t<T>, C13194b {

        /* renamed from: a */
        U f41701a;

        /* renamed from: b */
        final C13804t<? super U> f41702b;

        /* renamed from: c */
        C13194b f41703c;

        C13685a(C13804t<? super U> actual, U collection) {
            this.f41702b = actual;
            this.f41701a = collection;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41703c, s)) {
                this.f41703c = s;
                this.f41702b.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41703c.dispose();
        }

        public void onNext(T t) {
            this.f41701a.add(t);
        }

        public void onError(Throwable t) {
            this.f41701a = null;
            this.f41702b.onError(t);
        }

        public void onComplete() {
            U c = this.f41701a;
            this.f41701a = null;
            this.f41702b.onNext(c);
            this.f41702b.onComplete();
        }
    }

    public C13684zb(C13802r<T> source, int defaultCapacityHint) {
        super(source);
        this.f41700b = C13226a.m43192a(defaultCapacityHint);
    }

    public C13684zb(C13802r<T> source, Callable<U> collectionSupplier) {
        super(source);
        this.f41700b = collectionSupplier;
    }

    public void subscribeActual(C13804t<? super U> t) {
        try {
            U call = this.f41700b.call();
            C13264b.m43226a(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.f41005a.subscribe(new C13685a(t, (Collection) call));
        } catch (Throwable e) {
            C13980a.m44462b(e);
            C13219d.m43157a(e, t);
        }
    }
}
