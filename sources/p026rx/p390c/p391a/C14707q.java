package p026rx.p390c.p391a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.MissingBackpressureException;
import p026rx.p027b.C0132p;
import p026rx.p029i.C14977e;
import p026rx.p390c.p392b.C14771b;
import p026rx.p390c.p395e.C14869e;
import p026rx.p390c.p395e.C14887o;
import p026rx.p390c.p395e.p396a.C14828e;
import p026rx.p390c.p395e.p397b.C14839G;
import p026rx.p390c.p395e.p397b.C14859t;
import p026rx.p399e.C14917f;
import p026rx.p400f.C14948s;
import rx.internal.operators.OnSubscribeConcatMap.ConcatMapInnerSubscriber;
import rx.internal.operators.OnSubscribeConcatMap.ConcatMapSubscriber;
import rx.internal.util.ScalarSynchronousObservable;

/* renamed from: rx.c.a.q */
/* compiled from: OnSubscribeConcatMap */
public final class C14707q<T, R> implements C0122a<R> {

    /* renamed from: a */
    final C0120S<? extends T> f43766a;

    /* renamed from: b */
    final C0132p<? super T, ? extends C0120S<? extends R>> f43767b;

    /* renamed from: c */
    final int f43768c;

    /* renamed from: d */
    final int f43769d;

    /* renamed from: rx.c.a.q$a */
    /* compiled from: OnSubscribeConcatMap */
    static final class C14708a<T, R> implements C14508U {

        /* renamed from: a */
        final R f43770a;

        /* renamed from: b */
        final C14710c<T, R> f43771b;

        /* renamed from: c */
        boolean f43772c;

        public C14708a(R value, C14710c<T, R> parent) {
            this.f43770a = value;
            this.f43771b = parent;
        }

        public void request(long n) {
            if (!this.f43772c && n > 0) {
                this.f43772c = true;
                ConcatMapSubscriber<T, R> p = this.f43771b;
                p.mo45850a(this.f43770a);
                p.mo45849a(1);
            }
        }
    }

    /* renamed from: rx.c.a.q$b */
    /* compiled from: OnSubscribeConcatMap */
    static final class C14709b<T, R> extends C14980ia<R> {

        /* renamed from: a */
        final C14710c<T, R> f43773a;

        /* renamed from: b */
        long f43774b;

        public C14709b(C14710c<T, R> parent) {
            this.f43773a = parent;
        }

        public void setProducer(C14508U p) {
            this.f43773a.f43778d.mo45915a(p);
        }

        public void onNext(R t) {
            this.f43774b++;
            this.f43773a.mo45850a(t);
        }

        public void onError(Throwable e) {
            this.f43773a.mo45851a(e, this.f43774b);
        }

        public void onCompleted() {
            this.f43773a.mo45849a(this.f43774b);
        }
    }

    /* renamed from: rx.c.a.q$c */
    /* compiled from: OnSubscribeConcatMap */
    static final class C14710c<T, R> extends C14980ia<T> {

        /* renamed from: a */
        final C14980ia<? super R> f43775a;

        /* renamed from: b */
        final C0132p<? super T, ? extends C0120S<? extends R>> f43776b;

        /* renamed from: c */
        final int f43777c;

        /* renamed from: d */
        final C14771b f43778d = new C14771b();

        /* renamed from: e */
        final Queue<Object> f43779e;

        /* renamed from: f */
        final AtomicInteger f43780f = new AtomicInteger();

        /* renamed from: g */
        final AtomicReference<Throwable> f43781g = new AtomicReference<>();

        /* renamed from: h */
        final C14977e f43782h;

        /* renamed from: i */
        volatile boolean f43783i;

        /* renamed from: j */
        volatile boolean f43784j;

        public C14710c(C14980ia<? super R> actual, C0132p<? super T, ? extends C0120S<? extends R>> mapper, int prefetch, int delayErrorMode) {
            Queue<Object> q;
            this.f43775a = actual;
            this.f43776b = mapper;
            this.f43777c = delayErrorMode;
            if (C14839G.m46555a()) {
                q = new C14859t<>(prefetch);
            } else {
                q = new C14828e<>(prefetch);
            }
            this.f43779e = q;
            this.f43782h = new C14977e();
            request((long) prefetch);
        }

        public void onNext(T t) {
            if (!this.f43779e.offer(C14689m.m46326d(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            mo45848a();
        }

        public void onError(Throwable mainError) {
            if (C14869e.m46587a(this.f43781g, mainError)) {
                this.f43783i = true;
                if (this.f43777c == 0) {
                    Throwable ex = C14869e.m46585a(this.f43781g);
                    if (!C14869e.m46586a(ex)) {
                        this.f43775a.onError(ex);
                    }
                    this.f43782h.unsubscribe();
                    return;
                }
                mo45848a();
                return;
            }
            mo45854c(mainError);
        }

        public void onCompleted() {
            this.f43783i = true;
            mo45848a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45852b(long n) {
            if (n > 0) {
                this.f43778d.request(n);
            } else if (n < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("n >= 0 required but it was ");
                sb.append(n);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45850a(R value) {
            this.f43775a.onNext(value);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45851a(Throwable innerError, long produced) {
            if (!C14869e.m46587a(this.f43781g, innerError)) {
                mo45854c(innerError);
            } else if (this.f43777c == 0) {
                Throwable ex = C14869e.m46585a(this.f43781g);
                if (!C14869e.m46586a(ex)) {
                    this.f43775a.onError(ex);
                }
                unsubscribe();
            } else {
                if (produced != 0) {
                    this.f43778d.mo45914a(produced);
                }
                this.f43784j = false;
                mo45848a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45849a(long produced) {
            if (produced != 0) {
                this.f43778d.mo45914a(produced);
            }
            this.f43784j = false;
            mo45848a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo45854c(Throwable e) {
            C14948s.m46719b(e);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45848a() {
            if (this.f43780f.getAndIncrement() == 0) {
                int delayErrorMode = this.f43777c;
                while (!this.f43775a.isUnsubscribed()) {
                    if (!this.f43784j) {
                        if (delayErrorMode != 1 || this.f43781g.get() == null) {
                            boolean mainDone = this.f43783i;
                            Object v = this.f43779e.poll();
                            boolean empty = v == null;
                            if (mainDone && empty) {
                                Throwable ex = C14869e.m46585a(this.f43781g);
                                if (ex == null) {
                                    this.f43775a.onCompleted();
                                } else if (!C14869e.m46586a(ex)) {
                                    this.f43775a.onError(ex);
                                }
                                return;
                            } else if (!empty) {
                                try {
                                    C0120S s = (C0120S) this.f43776b.call(C14689m.m46324b(v));
                                    if (s == null) {
                                        mo45853b((Throwable) new NullPointerException("The source returned by the mapper was null"));
                                        return;
                                    } else if (s != C0120S.m651c()) {
                                        if (s instanceof C14887o) {
                                            ScalarSynchronousObservable<? extends R> scalarSource = (C14887o) s;
                                            this.f43784j = true;
                                            this.f43778d.mo45915a((C14508U) new C14708a(scalarSource.mo46096o(), this));
                                        } else {
                                            ConcatMapInnerSubscriber<T, R> innerSubscriber = new C14709b<>(this);
                                            this.f43782h.mo46198a(innerSubscriber);
                                            if (!innerSubscriber.isUnsubscribed()) {
                                                this.f43784j = true;
                                                s.mo3640b((C14980ia<? super T>) innerSubscriber);
                                            } else {
                                                return;
                                            }
                                        }
                                        request(1);
                                    } else {
                                        request(1);
                                    }
                                } catch (Throwable mapperError) {
                                    C14927a.m46678c(mapperError);
                                    mo45853b(mapperError);
                                    return;
                                }
                            }
                        } else {
                            Throwable ex2 = C14869e.m46585a(this.f43781g);
                            if (!C14869e.m46586a(ex2)) {
                                this.f43775a.onError(ex2);
                            }
                            return;
                        }
                    }
                    if (this.f43780f.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45853b(Throwable mapperError) {
            unsubscribe();
            if (C14869e.m46587a(this.f43781g, mapperError)) {
                Throwable ex = C14869e.m46585a(this.f43781g);
                if (!C14869e.m46586a(ex)) {
                    this.f43775a.onError(ex);
                    return;
                }
                return;
            }
            mo45854c(mapperError);
        }
    }

    public C14707q(C0120S<? extends T> source, C0132p<? super T, ? extends C0120S<? extends R>> mapper, int prefetch, int delayErrorMode) {
        this.f43766a = source;
        this.f43767b = mapper;
        this.f43768c = prefetch;
        this.f43769d = delayErrorMode;
    }

    /* renamed from: a */
    public void call(C14980ia<? super R> child) {
        C14980ia<? super R> iaVar;
        if (this.f43769d == 0) {
            iaVar = new C14917f<>(child);
        } else {
            iaVar = child;
        }
        ConcatMapSubscriber<T, R> parent = new C14710c<>(iaVar, this.f43767b, this.f43768c, this.f43769d);
        child.add(parent);
        child.add(parent.f43782h);
        child.setProducer(new C14703p(this, parent));
        if (!child.isUnsubscribed()) {
            this.f43766a.mo3640b((C14980ia<? super T>) parent);
        }
    }
}
