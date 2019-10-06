package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableTakeUntil.TakeUntilObserver;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicBoolean;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13216a;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p342f.C13770f;

/* renamed from: f.a.d.e.b.rb */
/* compiled from: ObservableTakeUntil */
public final class C13625rb<T, U> extends C13485a<T, T> {

    /* renamed from: b */
    final C13802r<? extends U> f41473b;

    /* renamed from: f.a.d.e.b.rb$a */
    /* compiled from: ObservableTakeUntil */
    final class C13626a implements C13804t<U> {

        /* renamed from: a */
        private final C13216a f41474a;

        /* renamed from: b */
        private final C13770f<T> f41475b;

        C13626a(C13216a frc, C13770f<T> serial) {
            this.f41474a = frc;
            this.f41475b = serial;
        }

        public void onSubscribe(C13194b s) {
            this.f41474a.mo42273a(1, s);
        }

        public void onNext(U u) {
            this.f41474a.dispose();
            this.f41475b.onComplete();
        }

        public void onError(Throwable t) {
            this.f41474a.dispose();
            this.f41475b.onError(t);
        }

        public void onComplete() {
            this.f41474a.dispose();
            this.f41475b.onComplete();
        }
    }

    /* renamed from: f.a.d.e.b.rb$b */
    /* compiled from: ObservableTakeUntil */
    static final class C13627b<T> extends AtomicBoolean implements C13804t<T> {

        /* renamed from: a */
        final C13804t<? super T> f41477a;

        /* renamed from: b */
        final C13216a f41478b;

        /* renamed from: c */
        C13194b f41479c;

        C13627b(C13804t<? super T> actual, C13216a frc) {
            this.f41477a = actual;
            this.f41478b = frc;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41479c, s)) {
                this.f41479c = s;
                this.f41478b.mo42273a(0, s);
            }
        }

        public void onNext(T t) {
            this.f41477a.onNext(t);
        }

        public void onError(Throwable t) {
            this.f41478b.dispose();
            this.f41477a.onError(t);
        }

        public void onComplete() {
            this.f41478b.dispose();
            this.f41477a.onComplete();
        }
    }

    public C13625rb(C13802r<T> source, C13802r<? extends U> other) {
        super(source);
        this.f41473b = other;
    }

    public void subscribeActual(C13804t<? super T> child) {
        SerializedObserver<T> serial = new C13770f<>(child);
        C13216a frc = new C13216a(2);
        TakeUntilObserver<T> tus = new C13627b<>(serial, frc);
        child.onSubscribe(frc);
        this.f41473b.subscribe(new C13626a(frc, serial));
        this.f41005a.subscribe(tus);
    }
}
