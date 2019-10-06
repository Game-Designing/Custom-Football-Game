package p026rx.p390c.p391a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C14972ha;
import p026rx.Single.C0124a;
import p026rx.Single.OnSubscribe;
import p026rx.p027b.C0128a;
import p026rx.p400f.C14948s;
import rx.internal.operators.SingleTimeout.TimeoutSingleSubscriber;
import rx.internal.operators.SingleTimeout.TimeoutSingleSubscriber.OtherSubscriber;

/* renamed from: rx.c.a.Kb */
/* compiled from: SingleTimeout */
public final class C14598Kb<T> implements C0124a<T> {

    /* renamed from: a */
    final C0124a<T> f43479a;

    /* renamed from: b */
    final long f43480b;

    /* renamed from: c */
    final TimeUnit f43481c;

    /* renamed from: d */
    final C0126V f43482d;

    /* renamed from: e */
    final C0124a<? extends T> f43483e;

    /* renamed from: rx.c.a.Kb$a */
    /* compiled from: SingleTimeout */
    static final class C14599a<T> extends C14972ha<T> implements C0128a {

        /* renamed from: b */
        final C14972ha<? super T> f43484b;

        /* renamed from: c */
        final AtomicBoolean f43485c = new AtomicBoolean();

        /* renamed from: d */
        final C0124a<? extends T> f43486d;

        /* renamed from: rx.c.a.Kb$a$a */
        /* compiled from: SingleTimeout */
        static final class C14600a<T> extends C14972ha<T> {

            /* renamed from: b */
            final C14972ha<? super T> f43487b;

            C14600a(C14972ha<? super T> actual) {
                this.f43487b = actual;
            }

            /* renamed from: a */
            public void mo45712a(T value) {
                this.f43487b.mo45712a(value);
            }

            public void onError(Throwable error) {
                this.f43487b.onError(error);
            }
        }

        C14599a(C14972ha<? super T> actual, C0124a<? extends T> other) {
            this.f43484b = actual;
            this.f43486d = other;
        }

        /* renamed from: a */
        public void mo45712a(T value) {
            if (this.f43485c.compareAndSet(false, true)) {
                try {
                    this.f43484b.mo45712a(value);
                } finally {
                    unsubscribe();
                }
            }
        }

        public void onError(Throwable error) {
            if (this.f43485c.compareAndSet(false, true)) {
                try {
                    this.f43484b.onError(error);
                } finally {
                    unsubscribe();
                }
            } else {
                C14948s.m46719b(error);
            }
        }

        public void call() {
            if (this.f43485c.compareAndSet(false, true)) {
                try {
                    OnSubscribe<? extends T> o = this.f43486d;
                    if (o == null) {
                        this.f43484b.onError(new TimeoutException());
                    } else {
                        OtherSubscriber<T> p = new C14600a<>(this.f43484b);
                        this.f43484b.mo46195b(p);
                        o.call(p);
                    }
                } finally {
                    unsubscribe();
                }
            }
        }
    }

    public C14598Kb(C0124a<T> source, long timeout, TimeUnit unit, C0126V scheduler, C0124a<? extends T> other) {
        this.f43479a = source;
        this.f43480b = timeout;
        this.f43481c = unit;
        this.f43482d = scheduler;
        this.f43483e = other;
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> t) {
        TimeoutSingleSubscriber<T> parent = new C14599a<>(t, this.f43483e);
        C0127a w = this.f43482d.createWorker();
        parent.mo46195b(w);
        t.mo46195b(parent);
        w.mo3709a(parent, this.f43480b, this.f43481c);
        this.f43479a.call(parent);
    }
}
