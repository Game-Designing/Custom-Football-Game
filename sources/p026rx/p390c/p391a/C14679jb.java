package p026rx.p390c.p391a;

import java.util.concurrent.TimeoutException;
import p026rx.C0120S;
import p026rx.C0120S.C0123b;
import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.p027b.C14542r;
import p026rx.p027b.C14543s;
import p026rx.p029i.C14977e;
import p026rx.p390c.p392b.C14771b;
import p026rx.p399e.C14917f;
import rx.Subscriber;

/* renamed from: rx.c.a.jb */
/* compiled from: OperatorTimeoutBase */
class C14679jb<T> implements C0123b<T, T> {

    /* renamed from: a */
    final C14680a<T> f43686a;

    /* renamed from: b */
    final C14681b<T> f43687b;

    /* renamed from: c */
    final C0120S<? extends T> f43688c;

    /* renamed from: d */
    final C0126V f43689d;

    /* renamed from: rx.c.a.jb$a */
    /* compiled from: OperatorTimeoutBase */
    interface C14680a<T> extends C14542r<C14682c<T>, Long, C0127a, C0137ja> {
    }

    /* renamed from: rx.c.a.jb$b */
    /* compiled from: OperatorTimeoutBase */
    interface C14681b<T> extends C14543s<C14682c<T>, Long, T, C0127a, C0137ja> {
    }

    /* renamed from: rx.c.a.jb$c */
    /* compiled from: OperatorTimeoutBase */
    static final class C14682c<T> extends C14980ia<T> {

        /* renamed from: a */
        final C14977e f43690a;

        /* renamed from: b */
        final C14917f<T> f43691b;

        /* renamed from: c */
        final C14681b<T> f43692c;

        /* renamed from: d */
        final C0120S<? extends T> f43693d;

        /* renamed from: e */
        final C0127a f43694e;

        /* renamed from: f */
        final C14771b f43695f = new C14771b();

        /* renamed from: g */
        boolean f43696g;

        /* renamed from: h */
        long f43697h;

        C14682c(C14917f<T> serializedSubscriber, C14681b<T> timeoutStub, C14977e serial, C0120S<? extends T> other, C0127a inner) {
            this.f43691b = serializedSubscriber;
            this.f43692c = timeoutStub;
            this.f43690a = serial;
            this.f43693d = other;
            this.f43694e = inner;
        }

        public void setProducer(C14508U p) {
            this.f43695f.mo45915a(p);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r0 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
            r7.f43691b.onNext(r8);
            r7.f43690a.mo46198a((p026rx.C0137ja) r7.f43692c.mo45721a(r7, java.lang.Long.valueOf(r1), r8, r7.f43694e));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r8) {
            /*
                r7 = this;
                r0 = 0
                monitor-enter(r7)
                r1 = 0
                boolean r3 = r7.f43696g     // Catch:{ all -> 0x0030 }
                if (r3 != 0) goto L_0x0012
                long r3 = r7.f43697h     // Catch:{ all -> 0x0030 }
                r5 = 1
                long r3 = r3 + r5
                r7.f43697h = r3     // Catch:{ all -> 0x0030 }
                r1 = r3
                r0 = 1
                goto L_0x0014
            L_0x0012:
                long r1 = r7.f43697h     // Catch:{ all -> 0x0030 }
            L_0x0014:
                monitor-exit(r7)     // Catch:{ all -> 0x0033 }
                if (r0 == 0) goto L_0x002f
                rx.e.f<T> r3 = r7.f43691b
                r3.onNext(r8)
                rx.i.e r3 = r7.f43690a
                rx.c.a.jb$b<T> r4 = r7.f43692c
                java.lang.Long r5 = java.lang.Long.valueOf(r1)
                rx.V$a r6 = r7.f43694e
                java.lang.Object r4 = r4.mo45721a(r7, r5, r8, r6)
                rx.ja r4 = (p026rx.C0137ja) r4
                r3.mo46198a(r4)
            L_0x002f:
                return
            L_0x0030:
                r3 = move-exception
            L_0x0031:
                monitor-exit(r7)     // Catch:{ all -> 0x0033 }
                throw r3
            L_0x0033:
                r3 = move-exception
                goto L_0x0031
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14679jb.C14682c.onNext(java.lang.Object):void");
        }

        public void onError(Throwable error) {
            boolean onErrorWins = false;
            synchronized (this) {
                if (!this.f43696g) {
                    this.f43696g = true;
                    onErrorWins = true;
                }
            }
            if (onErrorWins) {
                this.f43690a.unsubscribe();
                this.f43691b.onError(error);
            }
        }

        public void onCompleted() {
            boolean onCompletedWins = false;
            synchronized (this) {
                if (!this.f43696g) {
                    this.f43696g = true;
                    onCompletedWins = true;
                }
            }
            if (onCompletedWins) {
                this.f43690a.unsubscribe();
                this.f43691b.onCompleted();
            }
        }

        /* renamed from: a */
        public void mo45825a(long seqId) {
            long expected = seqId;
            boolean timeoutWins = false;
            synchronized (this) {
                if (expected == this.f43697h && !this.f43696g) {
                    this.f43696g = true;
                    timeoutWins = true;
                }
            }
            if (!timeoutWins) {
                return;
            }
            if (this.f43693d == null) {
                this.f43691b.onError(new TimeoutException());
                return;
            }
            Subscriber<T> second = new C14685kb<>(this);
            this.f43693d.mo3640b((C14980ia<? super T>) second);
            this.f43690a.mo46198a(second);
        }
    }

    C14679jb(C14680a<T> firstTimeoutStub, C14681b<T> timeoutStub, C0120S<? extends T> other, C0126V scheduler) {
        this.f43686a = firstTimeoutStub;
        this.f43687b = timeoutStub;
        this.f43688c = other;
        this.f43689d = scheduler;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> subscriber) {
        C0127a inner = this.f43689d.createWorker();
        subscriber.add(inner);
        C14917f fVar = new C14917f(subscriber);
        C14977e serial = new C14977e();
        fVar.add(serial);
        C14682c cVar = new C14682c(fVar, this.f43687b, serial, this.f43688c, inner);
        fVar.add(cVar);
        fVar.setProducer(cVar.f43695f);
        serial.mo46198a((C0137ja) this.f43686a.call(cVar, Long.valueOf(0), inner));
        return cVar;
    }
}
