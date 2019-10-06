package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableFlatMapCompletable.FlatMapCompletableMainObserver.InnerObserver;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13198c;
import p320f.p321a.C13215d;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13193a;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p331d.C13276b;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Y */
/* compiled from: ObservableFlatMapCompletable */
public final class C13472Y<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13212n<? super T, ? extends C13215d> f40967b;

    /* renamed from: c */
    final boolean f40968c;

    /* renamed from: f.a.d.e.b.Y$a */
    /* compiled from: ObservableFlatMapCompletable */
    static final class C13473a<T> extends C13276b<T> implements C13804t<T> {

        /* renamed from: a */
        final C13804t<? super T> f40969a;

        /* renamed from: b */
        final C13741c f40970b = new C13741c();

        /* renamed from: c */
        final C13212n<? super T, ? extends C13215d> f40971c;

        /* renamed from: d */
        final boolean f40972d;

        /* renamed from: e */
        final C13193a f40973e = new C13193a();

        /* renamed from: f */
        C13194b f40974f;

        /* renamed from: g */
        volatile boolean f40975g;

        /* renamed from: f.a.d.e.b.Y$a$a */
        /* compiled from: ObservableFlatMapCompletable */
        final class C13474a extends AtomicReference<C13194b> implements C13198c, C13194b {
            C13474a() {
            }

            public void onSubscribe(C13194b d) {
                C13218c.m43153c(this, d);
            }

            public void onComplete() {
                C13473a.this.mo42508a(this);
            }

            public void onError(Throwable e) {
                C13473a.this.mo42509a(this, e);
            }

            public void dispose() {
                C13218c.m43150a((AtomicReference<C13194b>) this);
            }
        }

        C13473a(C13804t<? super T> observer, C13212n<? super T, ? extends C13215d> mapper, boolean delayErrors) {
            this.f40969a = observer;
            this.f40971c = mapper;
            this.f40972d = delayErrors;
            lazySet(1);
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f40974f, d)) {
                this.f40974f = d;
                this.f40969a.onSubscribe(this);
            }
        }

        public void onNext(T value) {
            try {
                Object apply = this.f40971c.apply(value);
                C13264b.m43226a(apply, "The mapper returned a null CompletableSource");
                C13215d cs = (C13215d) apply;
                getAndIncrement();
                InnerObserver inner = new C13474a<>();
                if (!this.f40975g && this.f40973e.mo42252b(inner)) {
                    cs.mo42246a(inner);
                }
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                this.f40974f.dispose();
                onError(ex);
            }
        }

        public void onError(Throwable e) {
            if (!this.f40970b.mo42733a(e)) {
                C13774a.m43836b(e);
            } else if (!this.f40972d) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.f40969a.onError(this.f40970b.mo42732a());
                }
            } else if (decrementAndGet() == 0) {
                this.f40969a.onError(this.f40970b.mo42732a());
            }
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable ex = this.f40970b.mo42732a();
                if (ex != null) {
                    this.f40969a.onError(ex);
                } else {
                    this.f40969a.onComplete();
                }
            }
        }

        public void dispose() {
            this.f40975g = true;
            this.f40974f.dispose();
            this.f40973e.dispose();
        }

        public T poll() throws Exception {
            return null;
        }

        public boolean isEmpty() {
            return true;
        }

        public void clear() {
        }

        /* renamed from: a */
        public int mo42274a(int mode) {
            return mode & 2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42508a(C13474a inner) {
            this.f40973e.mo42253c(inner);
            onComplete();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42509a(C13474a inner, Throwable e) {
            this.f40973e.mo42253c(inner);
            onError(e);
        }
    }

    public C13472Y(C13802r<T> source, C13212n<? super T, ? extends C13215d> mapper, boolean delayErrors) {
        super(source);
        this.f40967b = mapper;
        this.f40968c = delayErrors;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        this.f41005a.subscribe(new C13473a(observer, this.f40967b, this.f40968c));
    }
}
