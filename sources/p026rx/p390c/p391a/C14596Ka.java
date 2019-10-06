package p026rx.p390c.p391a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S.C0123b;
import p026rx.C0125T;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0128a;
import p026rx.p399e.C14917f;
import rx.observers.SerializedSubscriber;

/* renamed from: rx.c.a.Ka */
/* compiled from: OperatorSampleWithTime */
public final class C14596Ka<T> implements C0123b<T, T> {

    /* renamed from: a */
    final long f43474a;

    /* renamed from: b */
    final TimeUnit f43475b;

    /* renamed from: c */
    final C0126V f43476c;

    /* renamed from: rx.c.a.Ka$a */
    /* compiled from: OperatorSampleWithTime */
    static final class C14597a<T> extends C14980ia<T> implements C0128a {

        /* renamed from: a */
        private static final Object f43477a = new Object();

        /* renamed from: b */
        final AtomicReference<Object> f43478b = new AtomicReference<>(f43477a);
        private final C14980ia<? super T> subscriber;

        public C14597a(C14980ia<? super T> subscriber2) {
            this.subscriber = subscriber2;
        }

        public void onStart() {
            request(Long.MAX_VALUE);
        }

        public void onNext(T t) {
            this.f43478b.set(t);
        }

        public void onError(Throwable e) {
            this.subscriber.onError(e);
            unsubscribe();
        }

        public void onCompleted() {
            m46242a();
            this.subscriber.onCompleted();
            unsubscribe();
        }

        public void call() {
            m46242a();
        }

        /* renamed from: a */
        private void m46242a() {
            Object localValue = this.f43478b.getAndSet(f43477a);
            if (localValue != f43477a) {
                try {
                    this.subscriber.onNext(localValue);
                } catch (Throwable e) {
                    C14927a.m46672a(e, (C0125T<?>) this);
                }
            }
        }
    }

    public C14596Ka(long time, TimeUnit unit, C0126V scheduler) {
        this.f43474a = time;
        this.f43475b = unit;
        this.f43476c = scheduler;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        SerializedSubscriber<T> s = new C14917f<>(child);
        C0127a worker = this.f43476c.createWorker();
        child.add(worker);
        C14597a aVar = new C14597a(s);
        child.add(aVar);
        long j = this.f43474a;
        worker.mo3708a(aVar, j, j, this.f43475b);
        return aVar;
    }
}
