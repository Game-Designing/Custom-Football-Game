package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Emitter;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.operators.observable.ObservableGenerate.GeneratorDisposable;
import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13761e;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.ja */
/* compiled from: ObservableGenerate */
public final class C13544ja<T, S> extends C13797m<T> {

    /* renamed from: a */
    final Callable<S> f41194a;

    /* renamed from: b */
    final C13201c<S, C13761e<T>, S> f41195b;

    /* renamed from: c */
    final C13204f<? super S> f41196c;

    /* renamed from: f.a.d.e.b.ja$a */
    /* compiled from: ObservableGenerate */
    static final class C13545a<T, S> implements C13761e<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41197a;

        /* renamed from: b */
        final C13201c<S, ? super C13761e<T>, S> f41198b;

        /* renamed from: c */
        final C13204f<? super S> f41199c;

        /* renamed from: d */
        S f41200d;

        /* renamed from: e */
        volatile boolean f41201e;

        /* renamed from: f */
        boolean f41202f;

        /* renamed from: g */
        boolean f41203g;

        C13545a(C13804t<? super T> actual, C13201c<S, ? super C13761e<T>, S> generator, C13204f<? super S> disposeState, S initialState) {
            this.f41197a = actual;
            this.f41198b = generator;
            this.f41199c = disposeState;
            this.f41200d = initialState;
        }

        /* renamed from: b */
        public void mo42565b() {
            S s = this.f41200d;
            if (this.f41201e) {
                this.f41200d = null;
                m43503a(s);
                return;
            }
            BiFunction<S, ? super Emitter<T>, S> f = this.f41198b;
            while (!this.f41201e) {
                this.f41203g = false;
                try {
                    s = f.apply(s, this);
                    if (this.f41202f) {
                        this.f41201e = true;
                        this.f41200d = null;
                        m43503a(s);
                        return;
                    }
                } catch (Throwable ex) {
                    C13980a.m44462b(ex);
                    this.f41200d = null;
                    this.f41201e = true;
                    onError(ex);
                    m43503a(s);
                    return;
                }
            }
            this.f41200d = null;
            m43503a(s);
        }

        /* renamed from: a */
        private void m43503a(S s) {
            try {
                this.f41199c.accept(s);
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                C13774a.m43836b(ex);
            }
        }

        public void dispose() {
            this.f41201e = true;
        }

        public void onError(Throwable t) {
            if (this.f41202f) {
                C13774a.m43836b(t);
                return;
            }
            if (t == null) {
                t = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f41202f = true;
            this.f41197a.onError(t);
        }
    }

    public C13544ja(Callable<S> stateSupplier, C13201c<S, C13761e<T>, S> generator, C13204f<? super S> disposeState) {
        this.f41194a = stateSupplier;
        this.f41195b = generator;
        this.f41196c = disposeState;
    }

    public void subscribeActual(C13804t<? super T> s) {
        try {
            GeneratorDisposable<T, S> gd = new C13545a<>(s, this.f41195b, this.f41196c, this.f41194a.call());
            s.onSubscribe(gd);
            gd.mo42565b();
        } catch (Throwable e) {
            C13980a.m44462b(e);
            C13219d.m43157a(e, s);
        }
    }
}
