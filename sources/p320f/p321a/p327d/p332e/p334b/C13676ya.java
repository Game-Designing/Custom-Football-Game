package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;

/* renamed from: f.a.d.e.b.ya */
/* compiled from: ObservableMapNotification */
public final class C13676ya<T, R> extends C13485a<T, C13802r<? extends R>> {

    /* renamed from: b */
    final C13212n<? super T, ? extends C13802r<? extends R>> f41682b;

    /* renamed from: c */
    final C13212n<? super Throwable, ? extends C13802r<? extends R>> f41683c;

    /* renamed from: d */
    final Callable<? extends C13802r<? extends R>> f41684d;

    /* renamed from: f.a.d.e.b.ya$a */
    /* compiled from: ObservableMapNotification */
    static final class C13677a<T, R> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super C13802r<? extends R>> f41685a;

        /* renamed from: b */
        final C13212n<? super T, ? extends C13802r<? extends R>> f41686b;

        /* renamed from: c */
        final C13212n<? super Throwable, ? extends C13802r<? extends R>> f41687c;

        /* renamed from: d */
        final Callable<? extends C13802r<? extends R>> f41688d;

        /* renamed from: e */
        C13194b f41689e;

        C13677a(C13804t<? super C13802r<? extends R>> actual, C13212n<? super T, ? extends C13802r<? extends R>> onNextMapper, C13212n<? super Throwable, ? extends C13802r<? extends R>> onErrorMapper, Callable<? extends C13802r<? extends R>> onCompleteSupplier) {
            this.f41685a = actual;
            this.f41686b = onNextMapper;
            this.f41687c = onErrorMapper;
            this.f41688d = onCompleteSupplier;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41689e, s)) {
                this.f41689e = s;
                this.f41685a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f41689e.dispose();
        }

        public void onNext(T t) {
            try {
                Object apply = this.f41686b.apply(t);
                C13264b.m43226a(apply, "The onNext ObservableSource returned is null");
                this.f41685a.onNext((C13802r) apply);
            } catch (Throwable e) {
                C13980a.m44462b(e);
                this.f41685a.onError(e);
            }
        }

        public void onError(Throwable t) {
            try {
                Object apply = this.f41687c.apply(t);
                C13264b.m43226a(apply, "The onError ObservableSource returned is null");
                this.f41685a.onNext((C13802r) apply);
                this.f41685a.onComplete();
            } catch (Throwable e) {
                C13980a.m44462b(e);
                this.f41685a.onError(new CompositeException(t, e));
            }
        }

        public void onComplete() {
            try {
                Object call = this.f41688d.call();
                C13264b.m43226a(call, "The onComplete ObservableSource returned is null");
                this.f41685a.onNext((C13802r) call);
                this.f41685a.onComplete();
            } catch (Throwable e) {
                C13980a.m44462b(e);
                this.f41685a.onError(e);
            }
        }
    }

    public C13676ya(C13802r<T> source, C13212n<? super T, ? extends C13802r<? extends R>> onNextMapper, C13212n<? super Throwable, ? extends C13802r<? extends R>> onErrorMapper, Callable<? extends C13802r<? extends R>> onCompleteSupplier) {
        super(source);
        this.f41682b = onNextMapper;
        this.f41683c = onErrorMapper;
        this.f41684d = onCompleteSupplier;
    }

    public void subscribeActual(C13804t<? super C13802r<? extends R>> t) {
        this.f41005a.subscribe(new C13677a(t, this.f41682b, this.f41683c, this.f41684d));
    }
}
