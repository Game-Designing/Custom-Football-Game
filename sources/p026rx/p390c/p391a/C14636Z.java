package p026rx.p390c.p391a;

import java.util.concurrent.TimeUnit;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C14980ia;
import p026rx.p027b.C0128a;
import rx.internal.operators.OnSubscribeSkipTimed.SkipTimedSubscriber;

/* renamed from: rx.c.a.Z */
/* compiled from: OnSubscribeSkipTimed */
public final class C14636Z<T> implements C0122a<T> {

    /* renamed from: a */
    final long f43591a;

    /* renamed from: b */
    final TimeUnit f43592b;

    /* renamed from: c */
    final C0126V f43593c;

    /* renamed from: d */
    final C0120S<T> f43594d;

    /* renamed from: rx.c.a.Z$a */
    /* compiled from: OnSubscribeSkipTimed */
    static final class C14637a<T> extends C14980ia<T> implements C0128a {

        /* renamed from: a */
        final C14980ia<? super T> f43595a;

        /* renamed from: b */
        volatile boolean f43596b;

        C14637a(C14980ia<? super T> child) {
            this.f43595a = child;
        }

        public void call() {
            this.f43596b = true;
        }

        public void onNext(T t) {
            if (this.f43596b) {
                this.f43595a.onNext(t);
            }
        }

        public void onError(Throwable e) {
            try {
                this.f43595a.onError(e);
            } finally {
                unsubscribe();
            }
        }

        public void onCompleted() {
            try {
                this.f43595a.onCompleted();
            } finally {
                unsubscribe();
            }
        }
    }

    public C14636Z(C0120S<T> source, long time, TimeUnit unit, C0126V scheduler) {
        this.f43594d = source;
        this.f43591a = time;
        this.f43592b = unit;
        this.f43593c = scheduler;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> child) {
        C0127a worker = this.f43593c.createWorker();
        SkipTimedSubscriber<T> subscriber = new C14637a<>(child);
        subscriber.add(worker);
        child.add(subscriber);
        worker.mo3709a(subscriber, this.f43591a, this.f43592b);
        this.f43594d.mo3640b((C14980ia<? super T>) subscriber);
    }
}
