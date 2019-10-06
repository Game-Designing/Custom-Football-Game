package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.ca */
/* compiled from: ObservableFlattenIterable */
public final class C13502ca<T, R> extends C13485a<T, R> {

    /* renamed from: b */
    final C13212n<? super T, ? extends Iterable<? extends R>> f41077b;

    /* renamed from: f.a.d.e.b.ca$a */
    /* compiled from: ObservableFlattenIterable */
    static final class C13503a<T, R> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super R> f41078a;

        /* renamed from: b */
        final C13212n<? super T, ? extends Iterable<? extends R>> f41079b;

        /* renamed from: c */
        C13194b f41080c;

        C13503a(C13804t<? super R> actual, C13212n<? super T, ? extends Iterable<? extends R>> mapper) {
            this.f41078a = actual;
            this.f41079b = mapper;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f41080c, d)) {
                this.f41080c = d;
                this.f41078a.onSubscribe(this);
            }
        }

        public void onNext(T value) {
            if (this.f41080c != C13218c.DISPOSED) {
                try {
                    Observer<? super R> a = this.f41078a;
                    for (R v : (Iterable) this.f41079b.apply(value)) {
                        try {
                            try {
                                C13264b.m43226a(v, "The iterator returned a null value");
                                a.onNext(v);
                            } catch (Throwable ex) {
                                C13980a.m44462b(ex);
                                this.f41080c.dispose();
                                onError(ex);
                                return;
                            }
                        } catch (Throwable ex2) {
                            C13980a.m44462b(ex2);
                            this.f41080c.dispose();
                            onError(ex2);
                            return;
                        }
                    }
                } catch (Throwable ex3) {
                    C13980a.m44462b(ex3);
                    this.f41080c.dispose();
                    onError(ex3);
                }
            }
        }

        public void onError(Throwable e) {
            C13194b bVar = this.f41080c;
            C13218c cVar = C13218c.DISPOSED;
            if (bVar == cVar) {
                C13774a.m43836b(e);
                return;
            }
            this.f41080c = cVar;
            this.f41078a.onError(e);
        }

        public void onComplete() {
            C13194b bVar = this.f41080c;
            C13218c cVar = C13218c.DISPOSED;
            if (bVar != cVar) {
                this.f41080c = cVar;
                this.f41078a.onComplete();
            }
        }

        public void dispose() {
            this.f41080c.dispose();
            this.f41080c = C13218c.DISPOSED;
        }
    }

    public C13502ca(C13802r<T> source, C13212n<? super T, ? extends Iterable<? extends R>> mapper) {
        super(source);
        this.f41077b = mapper;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super R> observer) {
        this.f41005a.subscribe(new C13503a(observer, this.f41077b));
    }
}
