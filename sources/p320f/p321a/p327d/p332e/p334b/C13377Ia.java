package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.internal.operators.observable.ObservablePublishSelector.TargetObserver;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p345i.C13788a;

/* renamed from: f.a.d.e.b.Ia */
/* compiled from: ObservablePublishSelector */
public final class C13377Ia<T, R> extends C13485a<T, R> {

    /* renamed from: b */
    final C13212n<? super C13797m<T>, ? extends C13802r<R>> f40683b;

    /* renamed from: f.a.d.e.b.Ia$a */
    /* compiled from: ObservablePublishSelector */
    static final class C13378a<T, R> implements C13804t<T> {

        /* renamed from: a */
        final C13788a<T> f40684a;

        /* renamed from: b */
        final AtomicReference<C13194b> f40685b;

        C13378a(C13788a<T> subject, AtomicReference<C13194b> target) {
            this.f40684a = subject;
            this.f40685b = target;
        }

        public void onSubscribe(C13194b d) {
            C13218c.m43153c(this.f40685b, d);
        }

        public void onNext(T value) {
            this.f40684a.onNext(value);
        }

        public void onError(Throwable e) {
            this.f40684a.onError(e);
        }

        public void onComplete() {
            this.f40684a.onComplete();
        }
    }

    /* renamed from: f.a.d.e.b.Ia$b */
    /* compiled from: ObservablePublishSelector */
    static final class C13379b<T, R> extends AtomicReference<C13194b> implements C13804t<R>, C13194b {

        /* renamed from: a */
        final C13804t<? super R> f40686a;

        /* renamed from: b */
        C13194b f40687b;

        C13379b(C13804t<? super R> actual) {
            this.f40686a = actual;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f40687b, d)) {
                this.f40687b = d;
                this.f40686a.onSubscribe(this);
            }
        }

        public void onNext(R value) {
            this.f40686a.onNext(value);
        }

        public void onError(Throwable e) {
            C13218c.m43150a((AtomicReference<C13194b>) this);
            this.f40686a.onError(e);
        }

        public void onComplete() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
            this.f40686a.onComplete();
        }

        public void dispose() {
            this.f40687b.dispose();
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    public C13377Ia(C13802r<T> source, C13212n<? super C13797m<T>, ? extends C13802r<R>> selector) {
        super(source);
        this.f40683b = selector;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super R> observer) {
        PublishSubject<T> subject = C13788a.m43852b();
        try {
            Object apply = this.f40683b.apply(subject);
            C13264b.m43226a(apply, "The selector returned a null ObservableSource");
            ObservableSource<? extends R> target = (C13802r) apply;
            TargetObserver<T, R> o = new C13379b<>(observer);
            target.subscribe(o);
            this.f41005a.subscribe(new C13378a(subject, o));
        } catch (Throwable ex) {
            C13980a.m44462b(ex);
            C13219d.m43157a(ex, observer);
        }
    }
}
