package p026rx.p390c.p391a;

import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.p027b.C0128a;
import rx.Observable;
import rx.internal.operators.OperatorSubscribeOn.SubscribeOnSubscriber;

/* renamed from: rx.c.a.Qa */
/* compiled from: OperatorSubscribeOn */
public final class C14615Qa<T> implements C0122a<T> {

    /* renamed from: a */
    final C0126V f43529a;

    /* renamed from: b */
    final C0120S<T> f43530b;

    /* renamed from: c */
    final boolean f43531c;

    /* renamed from: rx.c.a.Qa$a */
    /* compiled from: OperatorSubscribeOn */
    static final class C14616a<T> extends C14980ia<T> implements C0128a {

        /* renamed from: a */
        final C14980ia<? super T> f43532a;

        /* renamed from: b */
        final boolean f43533b;

        /* renamed from: c */
        final C0127a f43534c;

        /* renamed from: d */
        C0120S<T> f43535d;

        /* renamed from: e */
        Thread f43536e;

        C14616a(C14980ia<? super T> actual, boolean requestOn, C0127a worker, C0120S<T> source) {
            this.f43532a = actual;
            this.f43533b = requestOn;
            this.f43534c = worker;
            this.f43535d = source;
        }

        public void onNext(T t) {
            this.f43532a.onNext(t);
        }

        public void onError(Throwable e) {
            try {
                this.f43532a.onError(e);
            } finally {
                this.f43534c.unsubscribe();
            }
        }

        public void onCompleted() {
            try {
                this.f43532a.onCompleted();
            } finally {
                this.f43534c.unsubscribe();
            }
        }

        public void call() {
            Observable<T> src = this.f43535d;
            this.f43535d = null;
            this.f43536e = Thread.currentThread();
            src.mo3640b((C14980ia<? super T>) this);
        }

        public void setProducer(C14508U p) {
            this.f43532a.setProducer(new C14613Pa(this, p));
        }
    }

    public C14615Qa(C0120S<T> source, C0126V scheduler, boolean requestOn) {
        this.f43529a = scheduler;
        this.f43530b = source;
        this.f43531c = requestOn;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> subscriber) {
        C0127a inner = this.f43529a.createWorker();
        SubscribeOnSubscriber<T> parent = new C14616a<>(subscriber, this.f43531c, inner, this.f43530b);
        subscriber.add(parent);
        subscriber.add(inner);
        inner.mo3707a(parent);
    }
}
