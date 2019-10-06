package p026rx.p390c.p391a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S.C0122a;
import p026rx.C0137ja;
import p026rx.C14504P;
import p026rx.C14504P.C14505a;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.MissingBackpressureException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C14540n;
import p026rx.p029i.C14977e;
import p026rx.p390c.p394d.C14820a;
import p026rx.p390c.p395e.C14880h;
import p026rx.p390c.p395e.p396a.C14831h;
import p026rx.p390c.p395e.p397b.C14833A;
import p026rx.p390c.p395e.p397b.C14839G;
import p026rx.p400f.C14948s;
import rx.Subscriber;

/* renamed from: rx.c.a.s */
/* compiled from: OnSubscribeCreate */
public final class C14716s<T> implements C0122a<T> {

    /* renamed from: a */
    final C0129b<C14504P<T>> f43797a;

    /* renamed from: b */
    final C14505a f43798b;

    /* renamed from: rx.c.a.s$a */
    /* compiled from: OnSubscribeCreate */
    static abstract class C14717a<T> extends AtomicLong implements C14504P<T>, C14508U, C0137ja {

        /* renamed from: a */
        final C14980ia<? super T> f43799a;

        /* renamed from: b */
        final C14977e f43800b = new C14977e();

        public C14717a(C14980ia<? super T> actual) {
            this.f43799a = actual;
        }

        public void onCompleted() {
            if (!this.f43799a.isUnsubscribed()) {
                try {
                    this.f43799a.onCompleted();
                } finally {
                    this.f43800b.unsubscribe();
                }
            }
        }

        public void onError(Throwable e) {
            if (!this.f43799a.isUnsubscribed()) {
                try {
                    this.f43799a.onError(e);
                } finally {
                    this.f43800b.unsubscribe();
                }
            }
        }

        public final void unsubscribe() {
            this.f43800b.unsubscribe();
            mo45859b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45859b() {
        }

        public final boolean isUnsubscribed() {
            return this.f43800b.isUnsubscribed();
        }

        public final void request(long n) {
            if (C14640a.m46284a(n)) {
                C14640a.m46283a((AtomicLong) this, n);
                mo45857a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45857a() {
        }

        /* renamed from: a */
        public final void mo45858a(C0137ja s) {
            this.f43800b.mo46198a(s);
        }

        /* renamed from: a */
        public final void mo45700a(C14540n c) {
            mo45858a((C0137ja) new C14820a(c));
        }
    }

    /* renamed from: rx.c.a.s$b */
    /* compiled from: OnSubscribeCreate */
    static final class C14718b<T> extends C14717a<T> {

        /* renamed from: c */
        final Queue<Object> f43801c;

        /* renamed from: d */
        Throwable f43802d;

        /* renamed from: e */
        volatile boolean f43803e;

        /* renamed from: f */
        final AtomicInteger f43804f;

        public C14718b(C14980ia<? super T> actual, int capacityHint) {
            super(actual);
            this.f43801c = C14839G.m46555a() ? new C14833A<>(capacityHint) : new C14831h<>(capacityHint);
            this.f43804f = new AtomicInteger();
        }

        public void onNext(T t) {
            this.f43801c.offer(C14689m.m46326d(t));
            mo45860c();
        }

        public void onError(Throwable e) {
            this.f43802d = e;
            this.f43803e = true;
            mo45860c();
        }

        public void onCompleted() {
            this.f43803e = true;
            mo45860c();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45857a() {
            mo45860c();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45859b() {
            if (this.f43804f.getAndIncrement() == 0) {
                this.f43801c.clear();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo45860c() {
            if (this.f43804f.getAndIncrement() == 0) {
                int missed = 1;
                Subscriber<? super T> a = this.f43799a;
                Queue<Object> q = this.f43801c;
                do {
                    long r = get();
                    long e = 0;
                    while (e != r) {
                        if (a.isUnsubscribed()) {
                            q.clear();
                            return;
                        }
                        boolean d = this.f43803e;
                        Object o = q.poll();
                        boolean empty = o == null;
                        if (d && empty) {
                            Throwable ex = this.f43802d;
                            if (ex != null) {
                                super.onError(ex);
                            } else {
                                super.onCompleted();
                            }
                            return;
                        } else if (empty) {
                            break;
                        } else {
                            a.onNext(C14689m.m46324b(o));
                            e++;
                        }
                    }
                    if (e == r) {
                        if (a.isUnsubscribed()) {
                            q.clear();
                            return;
                        }
                        boolean d2 = this.f43803e;
                        boolean empty2 = q.isEmpty();
                        if (d2 && empty2) {
                            Throwable ex2 = this.f43802d;
                            if (ex2 != null) {
                                super.onError(ex2);
                            } else {
                                super.onCompleted();
                            }
                            return;
                        }
                    }
                    if (e != 0) {
                        C14640a.m46285b(this, e);
                    }
                    missed = this.f43804f.addAndGet(-missed);
                } while (missed != 0);
            }
        }
    }

    /* renamed from: rx.c.a.s$c */
    /* compiled from: OnSubscribeCreate */
    static final class C14719c<T> extends C14722f<T> {
        public C14719c(C14980ia<? super T> actual) {
            super(actual);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo45861c() {
        }
    }

    /* renamed from: rx.c.a.s$d */
    /* compiled from: OnSubscribeCreate */
    static final class C14720d<T> extends C14722f<T> {

        /* renamed from: c */
        private boolean f43805c;

        public C14720d(C14980ia<? super T> actual) {
            super(actual);
        }

        public void onNext(T t) {
            if (!this.f43805c) {
                super.onNext(t);
            }
        }

        public void onCompleted() {
            if (!this.f43805c) {
                this.f43805c = true;
                super.onCompleted();
            }
        }

        public void onError(Throwable e) {
            if (this.f43805c) {
                C14948s.m46719b(e);
                return;
            }
            this.f43805c = true;
            super.onError(e);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo45861c() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    /* renamed from: rx.c.a.s$e */
    /* compiled from: OnSubscribeCreate */
    static final class C14721e<T> extends C14717a<T> {

        /* renamed from: c */
        final AtomicReference<Object> f43806c = new AtomicReference<>();

        /* renamed from: d */
        Throwable f43807d;

        /* renamed from: e */
        volatile boolean f43808e;

        /* renamed from: f */
        final AtomicInteger f43809f = new AtomicInteger();

        public C14721e(C14980ia<? super T> actual) {
            super(actual);
        }

        public void onNext(T t) {
            this.f43806c.set(C14689m.m46326d(t));
            mo45862c();
        }

        public void onError(Throwable e) {
            this.f43807d = e;
            this.f43808e = true;
            mo45862c();
        }

        public void onCompleted() {
            this.f43808e = true;
            mo45862c();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45857a() {
            mo45862c();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45859b() {
            if (this.f43809f.getAndIncrement() == 0) {
                this.f43806c.lazySet(null);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo45862c() {
            boolean empty;
            if (this.f43809f.getAndIncrement() == 0) {
                int missed = 1;
                Subscriber<? super T> a = this.f43799a;
                AtomicReference<Object> q = this.f43806c;
                do {
                    long r = get();
                    long e = 0;
                    while (true) {
                        empty = true;
                        if (e == r) {
                            break;
                        } else if (a.isUnsubscribed()) {
                            q.lazySet(null);
                            return;
                        } else {
                            boolean d = this.f43808e;
                            Object o = q.getAndSet(null);
                            boolean empty2 = o == null;
                            if (d && empty2) {
                                Throwable ex = this.f43807d;
                                if (ex != null) {
                                    super.onError(ex);
                                } else {
                                    super.onCompleted();
                                }
                                return;
                            } else if (empty2) {
                                break;
                            } else {
                                a.onNext(C14689m.m46324b(o));
                                e++;
                            }
                        }
                    }
                    if (e == r) {
                        if (a.isUnsubscribed()) {
                            q.lazySet(null);
                            return;
                        }
                        boolean d2 = this.f43808e;
                        if (q.get() != null) {
                            empty = false;
                        }
                        if (d2 && empty) {
                            Throwable ex2 = this.f43807d;
                            if (ex2 != null) {
                                super.onError(ex2);
                            } else {
                                super.onCompleted();
                            }
                            return;
                        }
                    }
                    if (e != 0) {
                        C14640a.m46285b(this, e);
                    }
                    missed = this.f43809f.addAndGet(-missed);
                } while (missed != 0);
            }
        }
    }

    /* renamed from: rx.c.a.s$f */
    /* compiled from: OnSubscribeCreate */
    static abstract class C14722f<T> extends C14717a<T> {
        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public abstract void mo45861c();

        public C14722f(C14980ia<? super T> actual) {
            super(actual);
        }

        public void onNext(T t) {
            if (!this.f43799a.isUnsubscribed()) {
                if (get() != 0) {
                    this.f43799a.onNext(t);
                    C14640a.m46285b(this, 1);
                } else {
                    mo45861c();
                }
            }
        }
    }

    /* renamed from: rx.c.a.s$g */
    /* compiled from: OnSubscribeCreate */
    static final class C14723g<T> extends C14717a<T> {
        public C14723g(C14980ia<? super T> actual) {
            super(actual);
        }

        public void onNext(T t) {
            long r;
            if (!this.f43799a.isUnsubscribed()) {
                this.f43799a.onNext(t);
                do {
                    r = get();
                    if (r == 0) {
                        break;
                    }
                } while (!compareAndSet(r, r - 1));
            }
        }
    }

    public C14716s(C0129b<C14504P<T>> Emitter, C14505a backpressure) {
        this.f43797a = Emitter;
        this.f43798b = backpressure;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> t) {
        C14717a aVar;
        int i = C14713r.f43791a[this.f43798b.ordinal()];
        if (i == 1) {
            aVar = new C14723g(t);
        } else if (i == 2) {
            aVar = new C14720d(t);
        } else if (i == 3) {
            aVar = new C14719c(t);
        } else if (i != 4) {
            aVar = new C14718b(t, C14880h.f44165a);
        } else {
            aVar = new C14721e(t);
        }
        t.add(aVar);
        t.setProducer(aVar);
        this.f43797a.call(aVar);
    }
}
