package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty.SwitchIfEmptyObserver;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13225j;

/* renamed from: f.a.d.e.b.lb */
/* compiled from: ObservableSwitchIfEmpty */
public final class C13564lb<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13802r<? extends T> f41279b;

    /* renamed from: f.a.d.e.b.lb$a */
    /* compiled from: ObservableSwitchIfEmpty */
    static final class C13565a<T> implements C13804t<T> {

        /* renamed from: a */
        final C13804t<? super T> f41280a;

        /* renamed from: b */
        final C13802r<? extends T> f41281b;

        /* renamed from: c */
        final C13225j f41282c = new C13225j();

        /* renamed from: d */
        boolean f41283d = true;

        C13565a(C13804t<? super T> actual, C13802r<? extends T> other) {
            this.f41280a = actual;
            this.f41281b = other;
        }

        public void onSubscribe(C13194b s) {
            this.f41282c.mo42288b(s);
        }

        public void onNext(T t) {
            if (this.f41283d) {
                this.f41283d = false;
            }
            this.f41280a.onNext(t);
        }

        public void onError(Throwable t) {
            this.f41280a.onError(t);
        }

        public void onComplete() {
            if (this.f41283d) {
                this.f41283d = false;
                this.f41281b.subscribe(this);
                return;
            }
            this.f41280a.onComplete();
        }
    }

    public C13564lb(C13802r<T> source, C13802r<? extends T> other) {
        super(source);
        this.f41279b = other;
    }

    public void subscribeActual(C13804t<? super T> t) {
        SwitchIfEmptyObserver<T> parent = new C13565a<>(t, this.f41279b);
        t.onSubscribe(parent.f41282c);
        this.f41005a.subscribe(parent);
    }
}
