package p026rx.p390c.p391a;

import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C14972ha;
import p026rx.Single.C0124a;
import p026rx.p027b.C0128a;
import rx.internal.operators.SingleObserveOn.ObserveOnSingleSubscriber;

/* renamed from: rx.c.a.zb */
/* compiled from: SingleObserveOn */
public final class C14768zb<T> implements C0124a<T> {

    /* renamed from: a */
    final C0124a<T> f43940a;

    /* renamed from: b */
    final C0126V f43941b;

    /* renamed from: rx.c.a.zb$a */
    /* compiled from: SingleObserveOn */
    static final class C14769a<T> extends C14972ha<T> implements C0128a {

        /* renamed from: b */
        final C14972ha<? super T> f43942b;

        /* renamed from: c */
        final C0127a f43943c;

        /* renamed from: d */
        T f43944d;

        /* renamed from: e */
        Throwable f43945e;

        public C14769a(C14972ha<? super T> actual, C0127a w) {
            this.f43942b = actual;
            this.f43943c = w;
        }

        /* renamed from: a */
        public void mo45712a(T value) {
            this.f43944d = value;
            this.f43943c.mo3707a(this);
        }

        public void onError(Throwable error) {
            this.f43945e = error;
            this.f43943c.mo3707a(this);
        }

        public void call() {
            try {
                Throwable ex = this.f43945e;
                if (ex != null) {
                    this.f43945e = null;
                    this.f43942b.onError(ex);
                } else {
                    T v = this.f43944d;
                    this.f43944d = null;
                    this.f43942b.mo45712a(v);
                }
            } finally {
                this.f43943c.unsubscribe();
            }
        }
    }

    public C14768zb(C0124a<T> source, C0126V scheduler) {
        this.f43940a = source;
        this.f43941b = scheduler;
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> t) {
        C0127a w = this.f43941b.createWorker();
        ObserveOnSingleSubscriber<T> parent = new C14769a<>(t, w);
        t.mo46195b(w);
        t.mo46195b(parent);
        this.f43940a.call(parent);
    }
}
