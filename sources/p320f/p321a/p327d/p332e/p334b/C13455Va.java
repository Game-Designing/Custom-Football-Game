package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.internal.operators.observable.ObservableRetryWhen.RepeatWhenObserver;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
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
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p327d.p340j.C13750k;
import p320f.p321a.p345i.C13788a;
import p320f.p321a.p345i.C13791c;

/* renamed from: f.a.d.e.b.Va */
/* compiled from: ObservableRetryWhen */
public final class C13455Va<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13212n<? super C13797m<Throwable>, ? extends C13802r<?>> f40908b;

    /* renamed from: f.a.d.e.b.Va$a */
    /* compiled from: ObservableRetryWhen */
    static final class C13456a<T> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40909a;

        /* renamed from: b */
        final AtomicInteger f40910b = new AtomicInteger();

        /* renamed from: c */
        final C13741c f40911c = new C13741c();

        /* renamed from: d */
        final C13791c<Throwable> f40912d;

        /* renamed from: e */
        final C13457a f40913e = new C13457a<>();

        /* renamed from: f */
        final AtomicReference<C13194b> f40914f = new AtomicReference<>();

        /* renamed from: g */
        final C13802r<T> f40915g;

        /* renamed from: h */
        volatile boolean f40916h;

        /* renamed from: f.a.d.e.b.Va$a$a */
        /* compiled from: ObservableRetryWhen */
        final class C13457a extends AtomicReference<C13194b> implements C13804t<Object> {
            C13457a() {
            }

            public void onSubscribe(C13194b d) {
                C13218c.m43153c(this, d);
            }

            public void onNext(Object t) {
                C13456a.this.mo42483b();
            }

            public void onError(Throwable e) {
                C13456a.this.mo42482a(e);
            }

            public void onComplete() {
                C13456a.this.mo42481a();
            }
        }

        C13456a(C13804t<? super T> actual, C13791c<Throwable> signaller, C13802r<T> source) {
            this.f40909a = actual;
            this.f40912d = signaller;
            this.f40915g = source;
        }

        public void onSubscribe(C13194b d) {
            C13218c.m43151a(this.f40914f, d);
        }

        public void onNext(T t) {
            C13750k.m43764a(this.f40909a, t, (AtomicInteger) this, this.f40911c);
        }

        public void onError(Throwable e) {
            this.f40916h = false;
            this.f40912d.onNext(e);
        }

        public void onComplete() {
            C13218c.m43150a((AtomicReference<C13194b>) this.f40913e);
            C13750k.m43766a(this.f40909a, (AtomicInteger) this, this.f40911c);
        }

        /* renamed from: c */
        public boolean mo42484c() {
            return C13218c.m43148a((C13194b) this.f40914f.get());
        }

        public void dispose() {
            C13218c.m43150a(this.f40914f);
            C13218c.m43150a((AtomicReference<C13194b>) this.f40913e);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42483b() {
            mo42485d();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42482a(Throwable ex) {
            C13218c.m43150a(this.f40914f);
            C13750k.m43765a(this.f40909a, ex, (AtomicInteger) this, this.f40911c);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42481a() {
            C13218c.m43150a(this.f40914f);
            C13750k.m43766a(this.f40909a, (AtomicInteger) this, this.f40911c);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42485d() {
            if (this.f40910b.getAndIncrement() == 0) {
                while (!mo42484c()) {
                    if (!this.f40916h) {
                        this.f40916h = true;
                        this.f40915g.subscribe(this);
                    }
                    if (this.f40910b.decrementAndGet() == 0) {
                    }
                }
            }
        }
    }

    public C13455Va(C13802r<T> source, C13212n<? super C13797m<Throwable>, ? extends C13802r<?>> handler) {
        super(source);
        this.f40908b = handler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        Subject<Throwable> signaller = C13788a.m43852b().mo42808a();
        try {
            Object apply = this.f40908b.apply(signaller);
            C13264b.m43226a(apply, "The handler returned a null ObservableSource");
            ObservableSource<?> other = (C13802r) apply;
            RepeatWhenObserver<T> parent = new C13456a<>(observer, signaller, this.f41005a);
            observer.onSubscribe(parent);
            other.subscribe(parent.f40913e);
            parent.mo42485d();
        } catch (Throwable ex) {
            C13980a.m44462b(ex);
            C13219d.m43157a(ex, observer);
        }
    }
}
