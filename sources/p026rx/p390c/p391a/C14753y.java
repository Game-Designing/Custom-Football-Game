package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0137ja;
import p026rx.C14503O;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0132p;
import p026rx.p029i.C0136c;
import p026rx.p390c.p395e.C14869e;
import p026rx.p400f.C14948s;
import rx.internal.operators.OnSubscribeFlatMapCompletable.FlatMapCompletableSubscriber;
import rx.internal.operators.OnSubscribeFlatMapCompletable.FlatMapCompletableSubscriber.InnerSubscriber;

/* renamed from: rx.c.a.y */
/* compiled from: OnSubscribeFlatMapCompletable */
public final class C14753y<T> implements C0122a<T> {

    /* renamed from: a */
    final C0120S<T> f43882a;

    /* renamed from: b */
    final C0132p<? super T, ? extends C0117M> f43883b;

    /* renamed from: c */
    final boolean f43884c;

    /* renamed from: d */
    final int f43885d;

    /* renamed from: rx.c.a.y$a */
    /* compiled from: OnSubscribeFlatMapCompletable */
    static final class C14754a<T> extends C14980ia<T> {

        /* renamed from: a */
        final C14980ia<? super T> f43886a;

        /* renamed from: b */
        final C0132p<? super T, ? extends C0117M> f43887b;

        /* renamed from: c */
        final boolean f43888c;

        /* renamed from: d */
        final int f43889d;

        /* renamed from: e */
        final AtomicInteger f43890e = new AtomicInteger(1);

        /* renamed from: f */
        final C0136c f43891f = new C0136c();

        /* renamed from: g */
        final AtomicReference<Throwable> f43892g = new AtomicReference<>();

        /* renamed from: rx.c.a.y$a$a */
        /* compiled from: OnSubscribeFlatMapCompletable */
        final class C14755a extends AtomicReference<C0137ja> implements C14503O, C0137ja {
            C14755a() {
            }

            public void unsubscribe() {
                C0137ja s = (C0137ja) getAndSet(this);
                if (s != null && s != this) {
                    s.unsubscribe();
                }
            }

            public boolean isUnsubscribed() {
                return get() == this;
            }

            public void onCompleted() {
                C14754a.this.mo45885a(this);
            }

            public void onError(Throwable e) {
                C14754a.this.mo45886a(this, e);
            }

            /* renamed from: a */
            public void mo45688a(C0137ja d) {
                if (!compareAndSet(null, d)) {
                    d.unsubscribe();
                    if (get() != this) {
                        C14948s.m46719b((Throwable) new IllegalStateException("Subscription already set!"));
                    }
                }
            }
        }

        C14754a(C14980ia<? super T> actual, C0132p<? super T, ? extends C0117M> mapper, boolean delayErrors, int maxConcurrency) {
            this.f43886a = actual;
            this.f43887b = mapper;
            this.f43888c = delayErrors;
            this.f43889d = maxConcurrency;
            request(maxConcurrency != Integer.MAX_VALUE ? (long) maxConcurrency : Long.MAX_VALUE);
        }

        public void onNext(T t) {
            try {
                C0117M c = (C0117M) this.f43887b.call(t);
                if (c != null) {
                    InnerSubscriber inner = new C14755a<>();
                    this.f43891f.mo3713a((C0137ja) inner);
                    this.f43890e.getAndIncrement();
                    c.mo3599b((C14503O) inner);
                    return;
                }
                try {
                    throw new NullPointerException("The mapper returned a null Completable");
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
            if (this.f43888c) {
                C14869e.m46587a(this.f43892g, e);
                onCompleted();
                return;
            }
            this.f43891f.unsubscribe();
            if (this.f43892g.compareAndSet(null, e)) {
                this.f43886a.onError(C14869e.m46585a(this.f43892g));
            } else {
                C14948s.m46719b(e);
            }
        }

        public void onCompleted() {
            mo45887a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo45887a() {
            if (this.f43890e.decrementAndGet() != 0) {
                return false;
            }
            Throwable ex = C14869e.m46585a(this.f43892g);
            if (ex != null) {
                this.f43886a.onError(ex);
            } else {
                this.f43886a.onCompleted();
            }
            return true;
        }

        /* renamed from: a */
        public void mo45886a(C14755a inner, Throwable e) {
            this.f43891f.mo3714b(inner);
            if (this.f43888c) {
                C14869e.m46587a(this.f43892g, e);
                if (!mo45887a() && this.f43889d != Integer.MAX_VALUE) {
                    request(1);
                    return;
                }
                return;
            }
            this.f43891f.unsubscribe();
            unsubscribe();
            if (this.f43892g.compareAndSet(null, e)) {
                this.f43886a.onError(C14869e.m46585a(this.f43892g));
            } else {
                C14948s.m46719b(e);
            }
        }

        /* renamed from: a */
        public void mo45885a(C14755a inner) {
            this.f43891f.mo3714b(inner);
            if (!mo45887a() && this.f43889d != Integer.MAX_VALUE) {
                request(1);
            }
        }
    }

    public C14753y(C0120S<T> source, C0132p<? super T, ? extends C0117M> mapper, boolean delayErrors, int maxConcurrency) {
        if (mapper == null) {
            throw new NullPointerException("mapper is null");
        } else if (maxConcurrency > 0) {
            this.f43882a = source;
            this.f43883b = mapper;
            this.f43884c = delayErrors;
            this.f43885d = maxConcurrency;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("maxConcurrency > 0 required but it was ");
            sb.append(maxConcurrency);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> child) {
        FlatMapCompletableSubscriber<T> parent = new C14754a<>(child, this.f43883b, this.f43884c, this.f43885d);
        child.add(parent);
        child.add(parent.f43891f);
        this.f43882a.mo3640b((C14980ia<? super T>) parent);
    }
}
