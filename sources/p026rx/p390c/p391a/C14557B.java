package p026rx.p390c.p391a;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.MissingBackpressureException;
import p026rx.p027b.C0132p;
import p026rx.p390c.p395e.C14869e;
import p026rx.p390c.p395e.C14880h;
import p026rx.p390c.p395e.C14887o;
import p026rx.p390c.p395e.p396a.C14828e;
import p026rx.p390c.p395e.p396a.C14830g;
import p026rx.p390c.p395e.p397b.C14839G;
import p026rx.p390c.p395e.p397b.C14859t;
import p026rx.p400f.C14948s;
import rx.Subscriber;
import rx.internal.operators.OnSubscribeFlattenIterable.FlattenIterableSubscriber;

/* renamed from: rx.c.a.B */
/* compiled from: OnSubscribeFlattenIterable */
public final class C14557B<T, R> implements C0122a<R> {

    /* renamed from: a */
    final C0120S<? extends T> f43376a;

    /* renamed from: b */
    final C0132p<? super T, ? extends Iterable<? extends R>> f43377b;

    /* renamed from: c */
    final int f43378c;

    /* renamed from: rx.c.a.B$a */
    /* compiled from: OnSubscribeFlattenIterable */
    static final class C14558a<T, R> extends C14980ia<T> {

        /* renamed from: a */
        final C14980ia<? super R> f43379a;

        /* renamed from: b */
        final C0132p<? super T, ? extends Iterable<? extends R>> f43380b;

        /* renamed from: c */
        final long f43381c;

        /* renamed from: d */
        final Queue<Object> f43382d;

        /* renamed from: e */
        final AtomicReference<Throwable> f43383e = new AtomicReference<>();

        /* renamed from: f */
        final AtomicInteger f43384f = new AtomicInteger();

        /* renamed from: g */
        volatile boolean f43385g;

        /* renamed from: h */
        long f43386h;

        /* renamed from: i */
        Iterator<? extends R> f43387i;
        final AtomicLong requested = new AtomicLong();

        public C14558a(C14980ia<? super R> actual, C0132p<? super T, ? extends Iterable<? extends R>> mapper, int prefetch) {
            this.f43379a = actual;
            this.f43380b = mapper;
            if (prefetch == Integer.MAX_VALUE) {
                this.f43381c = Long.MAX_VALUE;
                this.f43382d = new C14830g(C14880h.f44165a);
            } else {
                this.f43381c = (long) (prefetch - (prefetch >> 2));
                if (C14839G.m46555a()) {
                    this.f43382d = new C14859t(prefetch);
                } else {
                    this.f43382d = new C14828e(prefetch);
                }
            }
            request((long) prefetch);
        }

        public void onNext(T t) {
            if (!this.f43382d.offer(C14689m.m46326d(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            mo45731a();
        }

        public void onError(Throwable e) {
            if (C14869e.m46587a(this.f43383e, e)) {
                this.f43385g = true;
                mo45731a();
                return;
            }
            C14948s.m46719b(e);
        }

        public void onCompleted() {
            this.f43385g = true;
            mo45731a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45732a(long n) {
            if (n > 0) {
                C14640a.m46283a(this.requested, n);
                mo45731a();
            } else if (n < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("n >= 0 required but it was ");
                sb.append(n);
                throw new IllegalStateException(sb.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45731a() {
            boolean z;
            if (this.f43384f.getAndIncrement() == 0) {
                Subscriber<? super R> actual = this.f43379a;
                Queue<Object> queue = this.f43382d;
                int missed = 1;
                boolean b = false;
                Object obj = null;
                while (true) {
                    Iterator<? extends R> it = this.f43387i;
                    if (it == null) {
                        boolean d = this.f43385g;
                        Object v = queue.poll();
                        boolean empty = v == null;
                        if (!mo45733a(d, empty, actual, queue)) {
                            if (!empty) {
                                long p = this.f43386h + 1;
                                if (p == this.f43381c) {
                                    this.f43386h = 0;
                                    request(p);
                                } else {
                                    this.f43386h = p;
                                }
                                try {
                                    it = ((Iterable) this.f43380b.call(C14689m.m46324b(v))).iterator();
                                    b = it.hasNext();
                                    if (!b) {
                                        continue;
                                    } else {
                                        this.f43387i = it;
                                    }
                                } catch (Throwable ex) {
                                    C14927a.m46678c(ex);
                                    onError(ex);
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    if (it != null) {
                        long r = this.requested.get();
                        long e = 0;
                        while (true) {
                            if (e == r) {
                                z = false;
                                break;
                            } else if (!mo45733a(this.f43385g, false, actual, queue)) {
                                try {
                                    obj = it.next();
                                    actual.onNext(obj);
                                    z = false;
                                    if (!mo45733a(this.f43385g, false, actual, queue)) {
                                        e++;
                                        try {
                                            b = it.hasNext();
                                            if (!b) {
                                                this.f43387i = null;
                                                it = null;
                                                break;
                                            }
                                        } catch (Throwable th) {
                                            Throwable th2 = th;
                                            boolean b2 = b;
                                            Throwable ex2 = th2;
                                            C14927a.m46678c(ex2);
                                            it = null;
                                            this.f43387i = null;
                                            onError(ex2);
                                            b = b2;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th3) {
                                    z = false;
                                    Throwable th4 = th3;
                                    Object obj2 = obj;
                                    Throwable ex3 = th4;
                                    C14927a.m46678c(ex3);
                                    it = null;
                                    this.f43387i = null;
                                    onError(ex3);
                                    obj = obj2;
                                }
                            } else {
                                return;
                            }
                        }
                        if (e == r) {
                            boolean z2 = this.f43385g;
                            if (queue.isEmpty() && it == null) {
                                z = true;
                            }
                            if (mo45733a(z2, z, actual, queue)) {
                                return;
                            }
                        }
                        if (e != 0) {
                            C14640a.m46285b(this.requested, e);
                        }
                        if (it == null) {
                            continue;
                        }
                    }
                    missed = this.f43384f.addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo45733a(boolean d, boolean empty, C14980ia<?> a, Queue<?> q) {
            if (a.isUnsubscribed()) {
                q.clear();
                this.f43387i = null;
                return true;
            }
            if (d) {
                if (((Throwable) this.f43383e.get()) != null) {
                    Throwable ex = C14869e.m46585a(this.f43383e);
                    unsubscribe();
                    q.clear();
                    this.f43387i = null;
                    a.onError(ex);
                    return true;
                } else if (empty) {
                    a.onCompleted();
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: rx.c.a.B$b */
    /* compiled from: OnSubscribeFlattenIterable */
    static final class C14559b<T, R> implements C0122a<R> {

        /* renamed from: a */
        final T f43388a;

        /* renamed from: b */
        final C0132p<? super T, ? extends Iterable<? extends R>> f43389b;

        public C14559b(T value, C0132p<? super T, ? extends Iterable<? extends R>> mapper) {
            this.f43388a = value;
            this.f43389b = mapper;
        }

        /* renamed from: a */
        public void call(C14980ia<? super R> t) {
            try {
                Iterator<? extends R> iterator = ((Iterable) this.f43389b.call(this.f43388a)).iterator();
                try {
                    if (!iterator.hasNext()) {
                        t.onCompleted();
                    } else {
                        t.setProducer(new C14572a(t, iterator));
                    }
                } catch (Throwable th) {
                    ex = th;
                    C14927a.m46673a(ex, (C0125T<?>) t, (Object) this.f43388a);
                }
            } catch (Throwable th2) {
                ex = th2;
                C14927a.m46673a(ex, (C0125T<?>) t, (Object) this.f43388a);
            }
        }
    }

    protected C14557B(C0120S<? extends T> source, C0132p<? super T, ? extends Iterable<? extends R>> mapper, int prefetch) {
        this.f43376a = source;
        this.f43377b = mapper;
        this.f43378c = prefetch;
    }

    /* renamed from: a */
    public void call(C14980ia<? super R> t) {
        FlattenIterableSubscriber<T, R> parent = new C14558a<>(t, this.f43377b, this.f43378c);
        t.add(parent);
        t.setProducer(new C14552A(this, parent));
        this.f43376a.mo3640b((C14980ia<? super T>) parent);
    }

    /* renamed from: a */
    public static <T, R> C0120S<R> m46191a(C0120S<? extends T> source, C0132p<? super T, ? extends Iterable<? extends R>> mapper, int prefetch) {
        if (source instanceof C14887o) {
            return C0120S.m648b((C0122a<T>) new C14559b<T>(((C14887o) source).mo46096o(), mapper));
        }
        return C0120S.m648b((C0122a<T>) new C14557B<T>(source, mapper, prefetch));
    }
}
