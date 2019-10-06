package p320f.p321a.p327d.p332e.p334b;

import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.Ga */
/* compiled from: ObservableOnErrorReturn */
public final class C13356Ga<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13212n<? super Throwable, ? extends T> f40604b;

    /* renamed from: f.a.d.e.b.Ga$a */
    /* compiled from: ObservableOnErrorReturn */
    static final class C13357a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40605a;

        /* renamed from: b */
        final C13212n<? super Throwable, ? extends T> f40606b;

        /* renamed from: c */
        C13194b f40607c;

        C13357a(C13804t<? super T> actual, C13212n<? super Throwable, ? extends T> valueSupplier) {
            this.f40605a = actual;
            this.f40606b = valueSupplier;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40607c, s)) {
                this.f40607c = s;
                this.f40605a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f40607c.dispose();
        }

        public void onNext(T t) {
            this.f40605a.onNext(t);
        }

        public void onError(Throwable t) {
            try {
                T v = this.f40606b.apply(t);
                if (v == null) {
                    NullPointerException e = new NullPointerException("The supplied value is null");
                    e.initCause(t);
                    this.f40605a.onError(e);
                    return;
                }
                this.f40605a.onNext(v);
                this.f40605a.onComplete();
            } catch (Throwable e2) {
                C13980a.m44462b(e2);
                this.f40605a.onError(new CompositeException(t, e2));
            }
        }

        public void onComplete() {
            this.f40605a.onComplete();
        }
    }

    public C13356Ga(C13802r<T> source, C13212n<? super Throwable, ? extends T> valueSupplier) {
        super(source);
        this.f40604b = valueSupplier;
    }

    public void subscribeActual(C13804t<? super T> t) {
        this.f41005a.subscribe(new C13357a(t, this.f40604b));
    }
}
