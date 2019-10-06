package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableSkipUntil.SkipUntilObserver;
import io.reactivex.observers.SerializedObserver;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13216a;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p342f.C13770f;

/* renamed from: f.a.d.e.b.ib */
/* compiled from: ObservableSkipUntil */
public final class C13539ib<T, U> extends C13485a<T, T> {

    /* renamed from: b */
    final C13802r<U> f41177b;

    /* renamed from: f.a.d.e.b.ib$a */
    /* compiled from: ObservableSkipUntil */
    final class C13540a implements C13804t<U> {

        /* renamed from: a */
        private final C13216a f41178a;

        /* renamed from: b */
        private final C13541b<T> f41179b;

        /* renamed from: c */
        private final C13770f<T> f41180c;

        /* renamed from: d */
        C13194b f41181d;

        C13540a(C13216a frc, C13541b<T> sus, C13770f<T> serial) {
            this.f41178a = frc;
            this.f41179b = sus;
            this.f41180c = serial;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41181d, s)) {
                this.f41181d = s;
                this.f41178a.mo42273a(1, s);
            }
        }

        public void onNext(U u) {
            this.f41181d.dispose();
            this.f41179b.f41186d = true;
        }

        public void onError(Throwable t) {
            this.f41178a.dispose();
            this.f41180c.onError(t);
        }

        public void onComplete() {
            this.f41179b.f41186d = true;
        }
    }

    /* renamed from: f.a.d.e.b.ib$b */
    /* compiled from: ObservableSkipUntil */
    static final class C13541b<T> implements C13804t<T> {

        /* renamed from: a */
        final C13804t<? super T> f41183a;

        /* renamed from: b */
        final C13216a f41184b;

        /* renamed from: c */
        C13194b f41185c;

        /* renamed from: d */
        volatile boolean f41186d;

        /* renamed from: e */
        boolean f41187e;

        C13541b(C13804t<? super T> actual, C13216a frc) {
            this.f41183a = actual;
            this.f41184b = frc;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41185c, s)) {
                this.f41185c = s;
                this.f41184b.mo42273a(0, s);
            }
        }

        public void onNext(T t) {
            if (this.f41187e) {
                this.f41183a.onNext(t);
            } else if (this.f41186d) {
                this.f41187e = true;
                this.f41183a.onNext(t);
            }
        }

        public void onError(Throwable t) {
            this.f41184b.dispose();
            this.f41183a.onError(t);
        }

        public void onComplete() {
            this.f41184b.dispose();
            this.f41183a.onComplete();
        }
    }

    public C13539ib(C13802r<T> source, C13802r<U> other) {
        super(source);
        this.f41177b = other;
    }

    public void subscribeActual(C13804t<? super T> child) {
        SerializedObserver<T> serial = new C13770f<>(child);
        C13216a frc = new C13216a(2);
        serial.onSubscribe(frc);
        SkipUntilObserver<T> sus = new C13541b<>(serial, frc);
        this.f41177b.subscribe(new C13540a(frc, sus, serial));
        this.f41005a.subscribe(sus);
    }
}
