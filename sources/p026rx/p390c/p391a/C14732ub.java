package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicLong;
import p026rx.C0120S;
import p026rx.C0120S.C0123b;
import p026rx.C0125T;
import p026rx.C0137ja;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.MissingBackpressureException;
import p026rx.p027b.C14541q;
import p026rx.p027b.C14545u;
import p026rx.p027b.C14549z;
import p026rx.p029i.C0136c;
import p026rx.p390c.p395e.C14880h;
import rx.Observer;
import rx.internal.operators.OperatorZip.Zip;
import rx.internal.operators.OperatorZip.Zip.InnerSubscriber;
import rx.internal.operators.OperatorZip.ZipProducer;
import rx.internal.operators.OperatorZip.ZipSubscriber;

/* renamed from: rx.c.a.ub */
/* compiled from: OperatorZip */
public final class C14732ub<R> implements C0123b<R, C0120S<?>[]> {

    /* renamed from: a */
    final C14545u<? extends R> f43826a;

    /* renamed from: rx.c.a.ub$a */
    /* compiled from: OperatorZip */
    static final class C14733a<R> extends AtomicLong {

        /* renamed from: a */
        static final int f43827a;

        /* renamed from: b */
        final C0125T<? super R> f43828b;

        /* renamed from: c */
        private final C14545u<? extends R> f43829c;

        /* renamed from: d */
        private final C0136c f43830d = new C0136c();

        /* renamed from: e */
        int f43831e;

        /* renamed from: f */
        private volatile Object[] f43832f;

        /* renamed from: g */
        private AtomicLong f43833g;

        /* renamed from: rx.c.a.ub$a$a */
        /* compiled from: OperatorZip */
        final class C14734a extends C14980ia {

            /* renamed from: a */
            final C14880h f43834a = C14880h.m46598a();

            C14734a() {
            }

            public void onStart() {
                request((long) C14880h.f44165a);
            }

            /* renamed from: a */
            public void mo45870a(long n) {
                request(n);
            }

            public void onCompleted() {
                this.f43834a.mo46086d();
                C14733a.this.mo45868a();
            }

            public void onError(Throwable e) {
                C14733a.this.f43828b.onError(e);
            }

            public void onNext(Object t) {
                try {
                    this.f43834a.mo46084c(t);
                } catch (MissingBackpressureException e) {
                    onError(e);
                }
                C14733a.this.mo45868a();
            }
        }

        static {
            double d = (double) C14880h.f44165a;
            Double.isNaN(d);
            f43827a = (int) (d * 0.7d);
        }

        public C14733a(C14980ia<? super R> child, C14545u<? extends R> zipFunction) {
            this.f43828b = child;
            this.f43829c = zipFunction;
            child.add(this.f43830d);
        }

        /* renamed from: a */
        public void mo45869a(C0120S[] os, AtomicLong requested) {
            Object[] subscribers = new Object[os.length];
            for (int i = 0; i < os.length; i++) {
                InnerSubscriber io = new C14734a<>();
                subscribers[i] = io;
                this.f43830d.mo3713a((C0137ja) io);
            }
            this.f43833g = requested;
            this.f43832f = subscribers;
            for (int i2 = 0; i2 < os.length; i2++) {
                os[i2].mo3640b((C14980ia<? super T>) (C14734a) subscribers[i2]);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45868a() {
            Object[] subscribers = this.f43832f;
            if (subscribers != null && getAndIncrement() == 0) {
                int length = subscribers.length;
                Observer<? super R> child = this.f43828b;
                AtomicLong requested = this.f43833g;
                while (true) {
                    Object[] vs = new Object[length];
                    boolean allHaveValues = true;
                    for (int i = 0; i < length; i++) {
                        C14880h buffer = ((C14734a) subscribers[i]).f43834a;
                        Object n = buffer.mo46087e();
                        if (n == null) {
                            allHaveValues = false;
                        } else if (buffer.mo46083b(n)) {
                            child.onCompleted();
                            this.f43830d.unsubscribe();
                            return;
                        } else {
                            vs[i] = buffer.mo46082a(n);
                        }
                    }
                    if (allHaveValues && requested.get() > 0) {
                        try {
                            child.onNext(this.f43829c.call(vs));
                            requested.decrementAndGet();
                            this.f43831e++;
                            Object[] arr$ = subscribers;
                            int len$ = arr$.length;
                            for (int i$ = 0; i$ < len$; i$++) {
                                C14880h buffer2 = ((C14734a) arr$[i$]).f43834a;
                                buffer2.mo46088f();
                                if (buffer2.mo46083b(buffer2.mo46087e())) {
                                    child.onCompleted();
                                    this.f43830d.unsubscribe();
                                    return;
                                }
                            }
                            if (this.f43831e > f43827a) {
                                Object[] arr$2 = subscribers;
                                int len$2 = arr$2.length;
                                for (int i$2 = 0; i$2 < len$2; i$2++) {
                                    ((C14734a) arr$2[i$2]).mo45870a((long) this.f43831e);
                                }
                                this.f43831e = 0;
                            }
                        } catch (Throwable e) {
                            C14927a.m46673a(e, (C0125T<?>) child, (Object) vs);
                            return;
                        }
                    } else if (decrementAndGet() <= 0) {
                        break;
                    }
                }
            }
        }
    }

    /* renamed from: rx.c.a.ub$b */
    /* compiled from: OperatorZip */
    static final class C14735b<R> extends AtomicLong implements C14508U {

        /* renamed from: a */
        final C14733a<R> f43836a;

        public C14735b(C14733a<R> zipper) {
            this.f43836a = zipper;
        }

        public void request(long n) {
            C14640a.m46283a((AtomicLong) this, n);
            this.f43836a.mo45868a();
        }
    }

    /* renamed from: rx.c.a.ub$c */
    /* compiled from: OperatorZip */
    final class C14736c extends C14980ia<C0120S[]> {

        /* renamed from: a */
        final C14980ia<? super R> f43837a;

        /* renamed from: b */
        final C14733a<R> f43838b;

        /* renamed from: c */
        boolean f43839c;
        final C14735b<R> producer;

        public C14736c(C14980ia<? super R> child, C14733a<R> zipper, C14735b<R> producer2) {
            this.f43837a = child;
            this.f43838b = zipper;
            this.producer = producer2;
        }

        public void onCompleted() {
            if (!this.f43839c) {
                this.f43837a.onCompleted();
            }
        }

        public void onError(Throwable e) {
            this.f43837a.onError(e);
        }

        /* renamed from: a */
        public void onNext(C0120S[] observables) {
            if (observables == null || observables.length == 0) {
                this.f43837a.onCompleted();
                return;
            }
            this.f43839c = true;
            this.f43838b.mo45869a(observables, this.producer);
        }
    }

    public C14732ub(C14541q f) {
        this.f43826a = C14549z.m46180a(f);
    }

    /* renamed from: a */
    public C14980ia<? super C0120S[]> call(C14980ia<? super R> child) {
        Zip<R> zipper = new C14733a<>(child, this.f43826a);
        ZipProducer<R> producer = new C14735b<>(zipper);
        ZipSubscriber subscriber = new C14736c<>(child, zipper, producer);
        child.add(subscriber);
        child.setProducer(producer);
        return subscriber;
    }
}
