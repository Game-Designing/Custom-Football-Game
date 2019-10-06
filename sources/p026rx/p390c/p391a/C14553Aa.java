package p026rx.p390c.p391a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import p026rx.C0120S.C0123b;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C14980ia;
import p026rx.exceptions.MissingBackpressureException;
import p026rx.p027b.C0128a;
import p026rx.p390c.p393c.C14775B;
import p026rx.p390c.p393c.C14797m;
import p026rx.p390c.p395e.C14880h;
import p026rx.p390c.p395e.p396a.C14828e;
import p026rx.p390c.p395e.p397b.C14839G;
import p026rx.p390c.p395e.p397b.C14859t;
import p026rx.p400f.C14948s;
import rx.Subscriber;

/* renamed from: rx.c.a.Aa */
/* compiled from: OperatorObserveOn */
public final class C14553Aa<T> implements C0123b<T, T> {

    /* renamed from: a */
    private final C0126V f43360a;

    /* renamed from: b */
    private final boolean f43361b;

    /* renamed from: c */
    private final int f43362c;

    /* renamed from: rx.c.a.Aa$a */
    /* compiled from: OperatorObserveOn */
    static final class C14554a<T> extends C14980ia<T> implements C0128a {

        /* renamed from: a */
        final C14980ia<? super T> f43363a;

        /* renamed from: b */
        final C0127a f43364b;

        /* renamed from: c */
        final boolean f43365c;

        /* renamed from: d */
        final Queue<Object> f43366d;

        /* renamed from: e */
        final int f43367e;

        /* renamed from: f */
        volatile boolean f43368f;

        /* renamed from: g */
        final AtomicLong f43369g = new AtomicLong();

        /* renamed from: h */
        Throwable f43370h;

        /* renamed from: i */
        long f43371i;
        final AtomicLong requested = new AtomicLong();

        public C14554a(C0126V scheduler, C14980ia<? super T> child, boolean delayError, int bufferSize) {
            this.f43363a = child;
            this.f43364b = scheduler.createWorker();
            this.f43365c = delayError;
            int calculatedSize = bufferSize > 0 ? bufferSize : C14880h.f44165a;
            this.f43367e = calculatedSize - (calculatedSize >> 2);
            if (C14839G.m46555a()) {
                this.f43366d = new C14859t(calculatedSize);
            } else {
                this.f43366d = new C14828e(calculatedSize);
            }
            request((long) calculatedSize);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45726a() {
            Subscriber<? super T> localChild = this.f43363a;
            localChild.setProducer(new C14767za(this));
            localChild.add(this.f43364b);
            localChild.add(this);
        }

        public void onNext(T t) {
            if (!isUnsubscribed() && !this.f43368f) {
                if (!this.f43366d.offer(C14689m.m46326d(t))) {
                    onError(new MissingBackpressureException());
                } else {
                    mo45728b();
                }
            }
        }

        public void onCompleted() {
            if (!isUnsubscribed() && !this.f43368f) {
                this.f43368f = true;
                mo45728b();
            }
        }

        public void onError(Throwable e) {
            if (isUnsubscribed() || this.f43368f) {
                C14948s.m46719b(e);
                return;
            }
            this.f43370h = e;
            this.f43368f = true;
            mo45728b();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo45728b() {
            if (this.f43369g.getAndIncrement() == 0) {
                this.f43364b.mo3707a(this);
            }
        }

        public void call() {
            long missed = 1;
            long currentEmission = this.f43371i;
            Queue<Object> q = this.f43366d;
            Subscriber<? super T> localChild = this.f43363a;
            do {
                long requestAmount = this.requested.get();
                while (requestAmount != currentEmission) {
                    boolean done = this.f43368f;
                    Object v = q.poll();
                    boolean empty = v == null;
                    if (!mo45727a(done, empty, localChild, q)) {
                        if (empty) {
                            break;
                        }
                        localChild.onNext(C14689m.m46324b(v));
                        currentEmission++;
                        if (currentEmission == ((long) this.f43367e)) {
                            requestAmount = C14640a.m46285b(this.requested, currentEmission);
                            request(currentEmission);
                            currentEmission = 0;
                        }
                    } else {
                        return;
                    }
                }
                if (requestAmount != currentEmission || !mo45727a(this.f43368f, q.isEmpty(), localChild, q)) {
                    this.f43371i = currentEmission;
                    missed = this.f43369g.addAndGet(-missed);
                } else {
                    return;
                }
            } while (missed != 0);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo45727a(boolean done, boolean isEmpty, C14980ia<? super T> a, Queue<Object> q) {
            if (a.isUnsubscribed()) {
                q.clear();
                return true;
            }
            if (done) {
                if (!this.f43365c) {
                    Throwable e = this.f43370h;
                    if (e != null) {
                        q.clear();
                        try {
                            a.onError(e);
                            return true;
                        } finally {
                            this.f43364b.unsubscribe();
                        }
                    } else if (isEmpty) {
                        try {
                            a.onCompleted();
                            return true;
                        } finally {
                            this.f43364b.unsubscribe();
                        }
                    }
                } else if (isEmpty) {
                    Throwable e2 = this.f43370h;
                    if (e2 != null) {
                        try {
                            a.onError(e2);
                        } catch (Throwable th) {
                            this.f43364b.unsubscribe();
                            throw th;
                        }
                    } else {
                        a.onCompleted();
                    }
                    this.f43364b.unsubscribe();
                }
            }
            return false;
        }
    }

    public C14553Aa(C0126V scheduler, boolean delayError, int bufferSize) {
        this.f43360a = scheduler;
        this.f43361b = delayError;
        this.f43362c = bufferSize > 0 ? bufferSize : C14880h.f44165a;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        C0126V v = this.f43360a;
        if ((v instanceof C14797m) || (v instanceof C14775B)) {
            return child;
        }
        C14554a aVar = new C14554a(v, child, this.f43361b, this.f43362c);
        aVar.mo45726a();
        return aVar;
    }
}
