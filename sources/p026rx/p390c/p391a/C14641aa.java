package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicInteger;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.p029i.C14977e;
import p026rx.p390c.p392b.C14771b;
import rx.internal.operators.OnSubscribeSwitchIfEmpty.ParentSubscriber;

/* renamed from: rx.c.a.aa */
/* compiled from: OnSubscribeSwitchIfEmpty */
public final class C14641aa<T> implements C0122a<T> {

    /* renamed from: a */
    final C0120S<? extends T> f43600a;

    /* renamed from: b */
    final C0120S<? extends T> f43601b;

    /* renamed from: rx.c.a.aa$a */
    /* compiled from: OnSubscribeSwitchIfEmpty */
    static final class C14642a<T> extends C14980ia<T> {

        /* renamed from: a */
        private final C14771b f43602a;

        /* renamed from: b */
        private final C14980ia<? super T> f43603b;

        C14642a(C14980ia<? super T> child, C14771b arbiter) {
            this.f43603b = child;
            this.f43602a = arbiter;
        }

        public void setProducer(C14508U producer) {
            this.f43602a.mo45915a(producer);
        }

        public void onCompleted() {
            this.f43603b.onCompleted();
        }

        public void onError(Throwable e) {
            this.f43603b.onError(e);
        }

        public void onNext(T t) {
            this.f43603b.onNext(t);
            this.f43602a.mo45914a(1);
        }
    }

    /* renamed from: rx.c.a.aa$b */
    /* compiled from: OnSubscribeSwitchIfEmpty */
    static final class C14643b<T> extends C14980ia<T> {

        /* renamed from: a */
        private boolean f43604a = true;

        /* renamed from: b */
        private final C14980ia<? super T> f43605b;

        /* renamed from: c */
        private final C14977e f43606c;

        /* renamed from: d */
        private final C14771b f43607d;

        /* renamed from: e */
        private final C0120S<? extends T> f43608e;

        /* renamed from: f */
        final AtomicInteger f43609f;

        /* renamed from: g */
        volatile boolean f43610g;

        C14643b(C14980ia<? super T> child, C14977e serial, C14771b arbiter, C0120S<? extends T> alternate) {
            this.f43605b = child;
            this.f43606c = serial;
            this.f43607d = arbiter;
            this.f43608e = alternate;
            this.f43609f = new AtomicInteger();
        }

        public void setProducer(C14508U producer) {
            this.f43607d.mo45915a(producer);
        }

        public void onCompleted() {
            if (!this.f43604a) {
                this.f43605b.onCompleted();
            } else if (!this.f43605b.isUnsubscribed()) {
                this.f43610g = false;
                mo45803a(null);
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Incorrect type for immutable var: ssa=rx.S<? extends T>, code=rx.Observable<? extends T>, for r5v0, types: [rx.S<? extends T>] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45803a(rx.Observable<? extends T> r5) {
            /*
                r4 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r4.f43609f
                int r0 = r0.getAndIncrement()
                if (r0 != 0) goto L_0x003c
            L_0x0008:
                rx.ia<? super T> r0 = r4.f43605b
                boolean r0 = r0.isUnsubscribed()
                if (r0 == 0) goto L_0x0011
                goto L_0x003c
            L_0x0011:
                boolean r0 = r4.f43610g
                if (r0 != 0) goto L_0x0034
                r0 = 1
                if (r5 != 0) goto L_0x002e
                rx.c.a.aa$a r1 = new rx.c.a.aa$a
                rx.ia<? super T> r2 = r4.f43605b
                rx.c.b.b r3 = r4.f43607d
                r1.<init>(r2, r3)
                rx.i.e r2 = r4.f43606c
                r2.mo46198a(r1)
                r4.f43610g = r0
                rx.S<? extends T> r0 = r4.f43608e
                r0.mo3640b(r1)
                goto L_0x0034
            L_0x002e:
                r4.f43610g = r0
                r5.mo3640b(r4)
                r5 = 0
            L_0x0034:
                java.util.concurrent.atomic.AtomicInteger r0 = r4.f43609f
                int r0 = r0.decrementAndGet()
                if (r0 != 0) goto L_0x0008
            L_0x003c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14641aa.C14643b.mo45803a(rx.S):void");
        }

        public void onError(Throwable e) {
            this.f43605b.onError(e);
        }

        public void onNext(T t) {
            this.f43604a = false;
            this.f43605b.onNext(t);
            this.f43607d.mo45914a(1);
        }
    }

    public C14641aa(C0120S<? extends T> source, C0120S<? extends T> alternate) {
        this.f43600a = source;
        this.f43601b = alternate;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> child) {
        C14977e serial = new C14977e();
        C14771b arbiter = new C14771b();
        ParentSubscriber<T> parent = new C14643b<>(child, serial, arbiter, this.f43601b);
        serial.mo46198a(parent);
        child.add(serial);
        child.setProducer(arbiter);
        parent.mo45803a(this.f43600a);
    }
}
