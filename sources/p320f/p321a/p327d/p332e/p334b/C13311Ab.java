package p320f.p321a.p327d.p332e.p334b;

import java.util.Collection;
import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13226a;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p330c.C13266a;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Ab */
/* compiled from: ObservableToListSingle */
public final class C13311Ab<T, U extends Collection<? super T>> extends C13810v<U> implements C13266a<U> {

    /* renamed from: a */
    final C13802r<T> f40443a;

    /* renamed from: b */
    final Callable<U> f40444b;

    /* renamed from: f.a.d.e.b.Ab$a */
    /* compiled from: ObservableToListSingle */
    static final class C13312a<T, U extends Collection<? super T>> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13812x<? super U> f40445a;

        /* renamed from: b */
        U f40446b;

        /* renamed from: c */
        C13194b f40447c;

        C13312a(C13812x<? super U> actual, U collection) {
            this.f40445a = actual;
            this.f40446b = collection;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40447c, s)) {
                this.f40447c = s;
                this.f40445a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f40447c.dispose();
        }

        public void onNext(T t) {
            this.f40446b.add(t);
        }

        public void onError(Throwable t) {
            this.f40446b = null;
            this.f40445a.onError(t);
        }

        public void onComplete() {
            U c = this.f40446b;
            this.f40446b = null;
            this.f40445a.onSuccess(c);
        }
    }

    public C13311Ab(C13802r<T> source, int defaultCapacityHint) {
        this.f40443a = source;
        this.f40444b = C13226a.m43192a(defaultCapacityHint);
    }

    public C13311Ab(C13802r<T> source, Callable<U> collectionSupplier) {
        this.f40443a = source;
        this.f40444b = collectionSupplier;
    }

    /* renamed from: b */
    public void mo42365b(C13812x<? super U> t) {
        try {
            U call = this.f40444b.call();
            C13264b.m43226a(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.f40443a.subscribe(new C13312a(t, (Collection) call));
        } catch (Throwable e) {
            C13980a.m44462b(e);
            C13219d.m43158a(e, t);
        }
    }

    /* renamed from: a */
    public C13797m<U> mo42316a() {
        return C13774a.m43821a((C13797m<T>) new C13684zb<T>(this.f40443a, this.f40444b));
    }
}
