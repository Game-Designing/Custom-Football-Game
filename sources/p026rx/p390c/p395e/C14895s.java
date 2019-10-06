package p026rx.p390c.p395e;

import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C14972ha;
import p026rx.Single;
import p026rx.Single.C0124a;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;
import p026rx.p390c.p393c.C14787g;

/* renamed from: rx.c.e.s */
/* compiled from: ScalarSynchronousSingle */
public final class C14895s<T> extends Single<T> {

    /* renamed from: b */
    final T f44196b;

    /* renamed from: rx.c.e.s$a */
    /* compiled from: ScalarSynchronousSingle */
    static final class C14896a<T> implements C0124a<T> {

        /* renamed from: a */
        private final C14787g f44197a;

        /* renamed from: b */
        private final T f44198b;

        C14896a(C14787g es, T value) {
            this.f44197a = es;
            this.f44198b = value;
        }

        /* renamed from: a */
        public void call(C14972ha<? super T> singleSubscriber) {
            singleSubscriber.mo46195b(this.f44197a.mo45930a(new C14898c(singleSubscriber, this.f44198b)));
        }
    }

    /* renamed from: rx.c.e.s$b */
    /* compiled from: ScalarSynchronousSingle */
    static final class C14897b<T> implements C0124a<T> {

        /* renamed from: a */
        private final C0126V f44199a;

        /* renamed from: b */
        private final T f44200b;

        C14897b(C0126V scheduler, T value) {
            this.f44199a = scheduler;
            this.f44200b = value;
        }

        /* renamed from: a */
        public void call(C14972ha<? super T> singleSubscriber) {
            C0127a worker = this.f44199a.createWorker();
            singleSubscriber.mo46195b(worker);
            worker.mo3707a(new C14898c(singleSubscriber, this.f44200b));
        }
    }

    /* renamed from: rx.c.e.s$c */
    /* compiled from: ScalarSynchronousSingle */
    static final class C14898c<T> implements C0128a {

        /* renamed from: a */
        private final C14972ha<? super T> f44201a;

        /* renamed from: b */
        private final T f44202b;

        C14898c(C14972ha<? super T> subscriber, T value) {
            this.f44201a = subscriber;
            this.f44202b = value;
        }

        public void call() {
            try {
                this.f44201a.mo45712a(this.f44202b);
            } catch (Throwable t) {
                this.f44201a.onError(t);
            }
        }
    }

    /* renamed from: b */
    public static <T> C14895s<T> m46621b(T t) {
        return new C14895s<>(t);
    }

    protected C14895s(T t) {
        super(new C14892p(t));
        this.f44196b = t;
    }

    /* renamed from: c */
    public Single<T> mo46103c(C0126V scheduler) {
        if (scheduler instanceof C14787g) {
            return Single.m737a((C0124a<T>) new C14896a<T>((C14787g) scheduler, this.f44196b));
        }
        return Single.m737a((C0124a<T>) new C14897b<T>(scheduler, this.f44196b));
    }

    /* renamed from: h */
    public <R> Single<R> mo46104h(C0132p<? super T, ? extends Single<? extends R>> func) {
        return Single.m737a((C0124a<T>) new C14894r<T>(this, func));
    }
}
