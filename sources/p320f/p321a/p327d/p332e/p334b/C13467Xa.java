package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p342f.C13770f;

/* renamed from: f.a.d.e.b.Xa */
/* compiled from: ObservableSampleWithObservable */
public final class C13467Xa<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13802r<?> f40958b;

    /* renamed from: c */
    final boolean f40959c;

    /* renamed from: f.a.d.e.b.Xa$a */
    /* compiled from: ObservableSampleWithObservable */
    static final class C13468a<T> extends C13470c<T> {

        /* renamed from: e */
        final AtomicInteger f40960e = new AtomicInteger();

        /* renamed from: f */
        volatile boolean f40961f;

        C13468a(C13804t<? super T> actual, C13802r<?> other) {
            super(actual, other);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42501b() {
            this.f40961f = true;
            if (this.f40960e.getAndIncrement() == 0) {
                mo42507d();
                this.f40962a.onComplete();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo42502c() {
            this.f40961f = true;
            if (this.f40960e.getAndIncrement() == 0) {
                mo42507d();
                this.f40962a.onComplete();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo42503e() {
            if (this.f40960e.getAndIncrement() == 0) {
                do {
                    boolean d = this.f40961f;
                    mo42507d();
                    if (d) {
                        this.f40962a.onComplete();
                        return;
                    }
                } while (this.f40960e.decrementAndGet() != 0);
            }
        }
    }

    /* renamed from: f.a.d.e.b.Xa$b */
    /* compiled from: ObservableSampleWithObservable */
    static final class C13469b<T> extends C13470c<T> {
        C13469b(C13804t<? super T> actual, C13802r<?> other) {
            super(actual, other);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42501b() {
            this.f40962a.onComplete();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo42502c() {
            this.f40962a.onComplete();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo42503e() {
            mo42507d();
        }
    }

    /* renamed from: f.a.d.e.b.Xa$c */
    /* compiled from: ObservableSampleWithObservable */
    static abstract class C13470c<T> extends AtomicReference<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40962a;

        /* renamed from: b */
        final C13802r<?> f40963b;

        /* renamed from: c */
        final AtomicReference<C13194b> f40964c = new AtomicReference<>();

        /* renamed from: d */
        C13194b f40965d;

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public abstract void mo42501b();

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public abstract void mo42502c();

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public abstract void mo42503e();

        C13470c(C13804t<? super T> actual, C13802r<?> other) {
            this.f40962a = actual;
            this.f40963b = other;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40965d, s)) {
                this.f40965d = s;
                this.f40962a.onSubscribe(this);
                if (this.f40964c.get() == null) {
                    this.f40963b.subscribe(new C13471d(this));
                }
            }
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onError(Throwable t) {
            C13218c.m43150a(this.f40964c);
            this.f40962a.onError(t);
        }

        public void onComplete() {
            C13218c.m43150a(this.f40964c);
            mo42501b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42506a(C13194b o) {
            return C13218c.m43153c(this.f40964c, o);
        }

        public void dispose() {
            C13218c.m43150a(this.f40964c);
            this.f40965d.dispose();
        }

        /* renamed from: a */
        public void mo42505a(Throwable e) {
            this.f40965d.dispose();
            this.f40962a.onError(e);
        }

        /* renamed from: a */
        public void mo42504a() {
            this.f40965d.dispose();
            mo42502c();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42507d() {
            T value = getAndSet(null);
            if (value != null) {
                this.f40962a.onNext(value);
            }
        }
    }

    /* renamed from: f.a.d.e.b.Xa$d */
    /* compiled from: ObservableSampleWithObservable */
    static final class C13471d<T> implements C13804t<Object> {

        /* renamed from: a */
        final C13470c<T> f40966a;

        C13471d(C13470c<T> parent) {
            this.f40966a = parent;
        }

        public void onSubscribe(C13194b s) {
            this.f40966a.mo42506a(s);
        }

        public void onNext(Object t) {
            this.f40966a.mo42503e();
        }

        public void onError(Throwable t) {
            this.f40966a.mo42505a(t);
        }

        public void onComplete() {
            this.f40966a.mo42504a();
        }
    }

    public C13467Xa(C13802r<T> source, C13802r<?> other, boolean emitLast) {
        super(source);
        this.f40958b = other;
        this.f40959c = emitLast;
    }

    public void subscribeActual(C13804t<? super T> t) {
        SerializedObserver<T> serial = new C13770f<>(t);
        if (this.f40959c) {
            this.f41005a.subscribe(new C13468a(serial, this.f40958b));
        } else {
            this.f41005a.subscribe(new C13469b(serial, this.f40958b));
        }
    }
}
