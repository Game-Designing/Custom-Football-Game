package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen.RepeatWhenObserver;
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

/* renamed from: f.a.d.e.b.Ra */
/* compiled from: ObservableRepeatWhen */
public final class C13425Ra<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13212n<? super C13797m<Object>, ? extends C13802r<?>> f40831b;

    /* renamed from: f.a.d.e.b.Ra$a */
    /* compiled from: ObservableRepeatWhen */
    static final class C13426a<T> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40832a;

        /* renamed from: b */
        final AtomicInteger f40833b = new AtomicInteger();

        /* renamed from: c */
        final C13741c f40834c = new C13741c();

        /* renamed from: d */
        final C13791c<Object> f40835d;

        /* renamed from: e */
        final C13427a f40836e = new C13427a<>();

        /* renamed from: f */
        final AtomicReference<C13194b> f40837f = new AtomicReference<>();

        /* renamed from: g */
        final C13802r<T> f40838g;

        /* renamed from: h */
        volatile boolean f40839h;

        /* renamed from: f.a.d.e.b.Ra$a$a */
        /* compiled from: ObservableRepeatWhen */
        final class C13427a extends AtomicReference<C13194b> implements C13804t<Object> {
            C13427a() {
            }

            public void onSubscribe(C13194b d) {
                C13218c.m43153c(this, d);
            }

            public void onNext(Object t) {
                C13426a.this.mo42455b();
            }

            public void onError(Throwable e) {
                C13426a.this.mo42454a(e);
            }

            public void onComplete() {
                C13426a.this.mo42453a();
            }
        }

        C13426a(C13804t<? super T> actual, C13791c<Object> signaller, C13802r<T> source) {
            this.f40832a = actual;
            this.f40835d = signaller;
            this.f40838g = source;
        }

        public void onSubscribe(C13194b d) {
            C13218c.m43151a(this.f40837f, d);
        }

        public void onNext(T t) {
            C13750k.m43764a(this.f40832a, t, (AtomicInteger) this, this.f40834c);
        }

        public void onError(Throwable e) {
            C13218c.m43150a((AtomicReference<C13194b>) this.f40836e);
            C13750k.m43765a(this.f40832a, e, (AtomicInteger) this, this.f40834c);
        }

        public void onComplete() {
            this.f40839h = false;
            this.f40835d.onNext(Integer.valueOf(0));
        }

        /* renamed from: c */
        public boolean mo42456c() {
            return C13218c.m43148a((C13194b) this.f40837f.get());
        }

        public void dispose() {
            C13218c.m43150a(this.f40837f);
            C13218c.m43150a((AtomicReference<C13194b>) this.f40836e);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42455b() {
            mo42457d();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42454a(Throwable ex) {
            C13218c.m43150a(this.f40837f);
            C13750k.m43765a(this.f40832a, ex, (AtomicInteger) this, this.f40834c);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42453a() {
            C13218c.m43150a(this.f40837f);
            C13750k.m43766a(this.f40832a, (AtomicInteger) this, this.f40834c);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42457d() {
            if (this.f40833b.getAndIncrement() == 0) {
                while (!mo42456c()) {
                    if (!this.f40839h) {
                        this.f40839h = true;
                        this.f40838g.subscribe(this);
                    }
                    if (this.f40833b.decrementAndGet() == 0) {
                    }
                }
            }
        }
    }

    public C13425Ra(C13802r<T> source, C13212n<? super C13797m<Object>, ? extends C13802r<?>> handler) {
        super(source);
        this.f40831b = handler;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        Subject<Object> signaller = C13788a.m43852b().mo42808a();
        try {
            Object apply = this.f40831b.apply(signaller);
            C13264b.m43226a(apply, "The handler returned a null ObservableSource");
            ObservableSource<?> other = (C13802r) apply;
            RepeatWhenObserver<T> parent = new C13426a<>(observer, signaller, this.f41005a);
            observer.onSubscribe(parent);
            other.subscribe(parent.f40836e);
            parent.mo42457d();
        } catch (Throwable ex) {
            C13980a.m44462b(ex);
            C13219d.m43157a(ex, observer);
        }
    }
}
