package p026rx.p390c.p391a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0137ja;
import p026rx.C14508U;
import p026rx.C14972ha;
import p026rx.C14980ia;
import p026rx.Single;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import p026rx.p390c.p395e.C14869e;
import p026rx.p390c.p395e.p396a.C14827d;
import p026rx.p390c.p395e.p397b.C14839G;
import p026rx.p390c.p395e.p397b.C14848i;
import p026rx.p400f.C14948s;
import rx.Subscriber;
import rx.internal.operators.OnSubscribeFlatMapSingle.FlatMapSingleSubscriber;
import rx.internal.operators.OnSubscribeFlatMapSingle.FlatMapSingleSubscriber.InnerSubscriber;

/* renamed from: rx.c.a.z */
/* compiled from: OnSubscribeFlatMapSingle */
public final class C14763z<T, R> implements C0122a<R> {

    /* renamed from: a */
    final C0120S<T> f43922a;

    /* renamed from: b */
    final C0132p<? super T, ? extends Single<? extends R>> f43923b;

    /* renamed from: c */
    final boolean f43924c;

    /* renamed from: d */
    final int f43925d;

    /* renamed from: rx.c.a.z$a */
    /* compiled from: OnSubscribeFlatMapSingle */
    static final class C14764a<T, R> extends C14980ia<T> {

        /* renamed from: a */
        final C14980ia<? super R> f43926a;

        /* renamed from: b */
        final C0132p<? super T, ? extends Single<? extends R>> f43927b;

        /* renamed from: c */
        final boolean f43928c;

        /* renamed from: d */
        final int f43929d;

        /* renamed from: e */
        final AtomicInteger f43930e = new AtomicInteger();

        /* renamed from: f */
        final AtomicInteger f43931f = new AtomicInteger();

        /* renamed from: g */
        final C0136c f43932g = new C0136c();

        /* renamed from: h */
        final AtomicReference<Throwable> f43933h = new AtomicReference<>();

        /* renamed from: i */
        final Queue<Object> f43934i;

        /* renamed from: j */
        volatile boolean f43935j;

        /* renamed from: k */
        volatile boolean f43936k;
        final C14766b requested = new C14766b<>();

        /* renamed from: rx.c.a.z$a$a */
        /* compiled from: OnSubscribeFlatMapSingle */
        final class C14765a extends C14972ha<R> {
            C14765a() {
            }

            /* renamed from: a */
            public void mo45712a(R t) {
                C14764a.this.mo45909a(this, t);
            }

            public void onError(Throwable error) {
                C14764a.this.mo45910a(this, error);
            }
        }

        /* renamed from: rx.c.a.z$a$b */
        /* compiled from: OnSubscribeFlatMapSingle */
        final class C14766b extends AtomicLong implements C14508U, C0137ja {
            C14766b() {
            }

            public void request(long n) {
                if (n > 0) {
                    C14640a.m46283a((AtomicLong) this, n);
                    C14764a.this.mo45908a();
                }
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo45911a(long e) {
                C14640a.m46285b(this, e);
            }

            public void unsubscribe() {
                C14764a aVar = C14764a.this;
                aVar.f43936k = true;
                aVar.unsubscribe();
                if (C14764a.this.f43930e.getAndIncrement() == 0) {
                    C14764a.this.f43934i.clear();
                }
            }

            public boolean isUnsubscribed() {
                return C14764a.this.f43936k;
            }
        }

        C14764a(C14980ia<? super R> actual, C0132p<? super T, ? extends Single<? extends R>> mapper, boolean delayErrors, int maxConcurrency) {
            this.f43926a = actual;
            this.f43927b = mapper;
            this.f43928c = delayErrors;
            this.f43929d = maxConcurrency;
            if (C14839G.m46555a()) {
                this.f43934i = new C14848i();
            } else {
                this.f43934i = new C14827d();
            }
            request(maxConcurrency != Integer.MAX_VALUE ? (long) maxConcurrency : Long.MAX_VALUE);
        }

        public void onNext(T t) {
            try {
                Single single = (Single) this.f43927b.call(t);
                if (single != null) {
                    InnerSubscriber inner = new C14765a<>();
                    this.f43932g.mo3713a((C0137ja) inner);
                    this.f43931f.incrementAndGet();
                    single.mo3691a((C14972ha<? super T>) inner);
                    return;
                }
                try {
                    throw new NullPointerException("The mapper returned a null Single");
                } catch (Throwable th) {
                    ex = th;
                    C14927a.m46678c(ex);
                    unsubscribe();
                    onError(ex);
                }
            } catch (Throwable th2) {
                ex = th2;
                C14927a.m46678c(ex);
                unsubscribe();
                onError(ex);
            }
        }

        public void onError(Throwable e) {
            if (this.f43928c) {
                C14869e.m46587a(this.f43933h, e);
            } else {
                this.f43932g.unsubscribe();
                if (!this.f43933h.compareAndSet(null, e)) {
                    C14948s.m46719b(e);
                    return;
                }
            }
            this.f43935j = true;
            mo45908a();
        }

        public void onCompleted() {
            this.f43935j = true;
            mo45908a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45909a(C14765a inner, R value) {
            this.f43934i.offer(C14689m.m46326d(value));
            this.f43932g.mo3714b(inner);
            this.f43931f.decrementAndGet();
            mo45908a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45910a(C14765a inner, Throwable e) {
            if (this.f43928c) {
                C14869e.m46587a(this.f43933h, e);
                this.f43932g.mo3714b(inner);
                if (!this.f43935j && this.f43929d != Integer.MAX_VALUE) {
                    request(1);
                }
            } else {
                this.f43932g.unsubscribe();
                unsubscribe();
                if (!this.f43933h.compareAndSet(null, e)) {
                    C14948s.m46719b(e);
                    return;
                }
                this.f43935j = true;
            }
            this.f43931f.decrementAndGet();
            mo45908a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45908a() {
            if (this.f43930e.getAndIncrement() == 0) {
                int missed = 1;
                Subscriber<? super R> a = this.f43926a;
                Queue<Object> q = this.f43934i;
                boolean delayError = this.f43928c;
                AtomicInteger act = this.f43931f;
                do {
                    long r = this.requested.get();
                    long e = 0;
                    while (e != r) {
                        if (this.f43936k) {
                            q.clear();
                            return;
                        }
                        boolean d = this.f43935j;
                        if (delayError || !d || ((Throwable) this.f43933h.get()) == null) {
                            Object o = q.poll();
                            boolean empty = o == null;
                            if (d && act.get() == 0 && empty) {
                                if (((Throwable) this.f43933h.get()) != null) {
                                    a.onError(C14869e.m46585a(this.f43933h));
                                } else {
                                    a.onCompleted();
                                }
                                return;
                            } else if (empty) {
                                break;
                            } else {
                                a.onNext(C14689m.m46324b(o));
                                e++;
                            }
                        } else {
                            q.clear();
                            a.onError(C14869e.m46585a(this.f43933h));
                            return;
                        }
                    }
                    if (e == r) {
                        if (this.f43936k) {
                            q.clear();
                            return;
                        } else if (this.f43935j) {
                            if (delayError) {
                                if (act.get() == 0 && q.isEmpty()) {
                                    if (((Throwable) this.f43933h.get()) != null) {
                                        a.onError(C14869e.m46585a(this.f43933h));
                                    } else {
                                        a.onCompleted();
                                    }
                                    return;
                                }
                            } else if (((Throwable) this.f43933h.get()) != null) {
                                q.clear();
                                a.onError(C14869e.m46585a(this.f43933h));
                                return;
                            } else if (act.get() == 0 && q.isEmpty()) {
                                a.onCompleted();
                                return;
                            }
                        }
                    }
                    if (e != 0) {
                        this.requested.mo45911a(e);
                        if (!this.f43935j && this.f43929d != Integer.MAX_VALUE) {
                            request(e);
                        }
                    }
                    missed = this.f43930e.addAndGet(-missed);
                } while (missed != 0);
            }
        }
    }

    public C14763z(C0120S<T> source, C0132p<? super T, ? extends Single<? extends R>> mapper, boolean delayErrors, int maxConcurrency) {
        if (mapper == null) {
            throw new NullPointerException("mapper is null");
        } else if (maxConcurrency > 0) {
            this.f43922a = source;
            this.f43923b = mapper;
            this.f43924c = delayErrors;
            this.f43925d = maxConcurrency;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("maxConcurrency > 0 required but it was ");
            sb.append(maxConcurrency);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public void call(C14980ia<? super R> child) {
        FlatMapSingleSubscriber<T, R> parent = new C14764a<>(child, this.f43923b, this.f43924c, this.f43925d);
        child.add(parent.f43932g);
        child.add(parent.requested);
        child.setProducer(parent.requested);
        this.f43922a.mo3640b((C14980ia<? super T>) parent);
    }
}
