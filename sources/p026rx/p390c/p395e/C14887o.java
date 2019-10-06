package p026rx.p390c.p395e;

import java.util.concurrent.atomic.AtomicBoolean;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0125T;
import p026rx.C0126V;
import p026rx.C0137ja;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;
import p026rx.p390c.p392b.C14773d;
import p026rx.p390c.p393c.C14787g;
import p026rx.p400f.C14948s;
import rx.Subscriber;

/* renamed from: rx.c.e.o */
/* compiled from: ScalarSynchronousObservable */
public final class C14887o<T> extends C0120S<T> {

    /* renamed from: b */
    static final boolean f44180b = Boolean.valueOf(System.getProperty("rx.just.strong-mode", AdultContentAnalytics.UNLOCK)).booleanValue();

    /* renamed from: c */
    final T f44181c;

    /* renamed from: rx.c.e.o$a */
    /* compiled from: ScalarSynchronousObservable */
    static final class C14888a<T> implements C0122a<T> {

        /* renamed from: a */
        final T f44182a;

        C14888a(T value) {
            this.f44182a = value;
        }

        /* renamed from: a */
        public void call(C14980ia<? super T> s) {
            s.setProducer(C14887o.m46611a(s, this.f44182a));
        }
    }

    /* renamed from: rx.c.e.o$b */
    /* compiled from: ScalarSynchronousObservable */
    static final class C14889b<T> implements C0122a<T> {

        /* renamed from: a */
        final T f44183a;

        /* renamed from: b */
        final C0132p<C0128a, C0137ja> f44184b;

        C14889b(T value, C0132p<C0128a, C0137ja> onSchedule) {
            this.f44183a = value;
            this.f44184b = onSchedule;
        }

        /* renamed from: a */
        public void call(C14980ia<? super T> s) {
            s.setProducer(new C14890c(s, this.f44183a, this.f44184b));
        }
    }

    /* renamed from: rx.c.e.o$c */
    /* compiled from: ScalarSynchronousObservable */
    static final class C14890c<T> extends AtomicBoolean implements C14508U, C0128a {

        /* renamed from: a */
        final C14980ia<? super T> f44185a;

        /* renamed from: b */
        final T f44186b;

        /* renamed from: c */
        final C0132p<C0128a, C0137ja> f44187c;

        public C14890c(C14980ia<? super T> actual, T value, C0132p<C0128a, C0137ja> onSchedule) {
            this.f44185a = actual;
            this.f44186b = value;
            this.f44187c = onSchedule;
        }

        public void request(long n) {
            if (n < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("n >= 0 required but it was ");
                sb.append(n);
                throw new IllegalArgumentException(sb.toString());
            } else if (n != 0 && compareAndSet(false, true)) {
                this.f44185a.add((C0137ja) this.f44187c.call(this));
            }
        }

        public void call() {
            Subscriber<? super T> a = this.f44185a;
            if (!a.isUnsubscribed()) {
                T v = this.f44186b;
                try {
                    a.onNext(v);
                    if (!a.isUnsubscribed()) {
                        a.onCompleted();
                    }
                } catch (Throwable e) {
                    C14927a.m46673a(e, (C0125T<?>) a, (Object) v);
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ScalarAsyncProducer[");
            sb.append(this.f44186b);
            sb.append(", ");
            sb.append(get());
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: rx.c.e.o$d */
    /* compiled from: ScalarSynchronousObservable */
    static final class C14891d<T> implements C14508U {

        /* renamed from: a */
        final C14980ia<? super T> f44188a;

        /* renamed from: b */
        final T f44189b;

        /* renamed from: c */
        boolean f44190c;

        public C14891d(C14980ia<? super T> actual, T value) {
            this.f44188a = actual;
            this.f44189b = value;
        }

        public void request(long n) {
            if (!this.f44190c) {
                if (n < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("n >= required but it was ");
                    sb.append(n);
                    throw new IllegalStateException(sb.toString());
                } else if (n != 0) {
                    this.f44190c = true;
                    Subscriber<? super T> a = this.f44188a;
                    if (!a.isUnsubscribed()) {
                        T v = this.f44189b;
                        try {
                            a.onNext(v);
                            if (!a.isUnsubscribed()) {
                                a.onCompleted();
                            }
                        } catch (Throwable e) {
                            C14927a.m46673a(e, (C0125T<?>) a, (Object) v);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    static <T> C14508U m46611a(C14980ia<? super T> s, T v) {
        if (f44180b) {
            return new C14773d(s, v);
        }
        return new C14891d(s, v);
    }

    /* renamed from: f */
    public static <T> C14887o<T> m46612f(T t) {
        return new C14887o<>(t);
    }

    protected C14887o(T t) {
        super(C14948s.m46707a((C0122a<T>) new C14888a<T>(t)));
        this.f44181c = t;
    }

    /* renamed from: o */
    public T mo46096o() {
        return this.f44181c;
    }

    /* renamed from: d */
    public C0120S<T> mo46095d(C0126V scheduler) {
        C0132p pVar;
        if (scheduler instanceof C14787g) {
            pVar = new C14883k(this, (C14787g) scheduler);
        } else {
            pVar = new C14885m(this, scheduler);
        }
        return C0120S.m648b((C0122a<T>) new C14889b<T>(this.f44181c, pVar));
    }

    /* renamed from: r */
    public <R> C0120S<R> mo46097r(C0132p<? super T, ? extends C0120S<? extends R>> func) {
        return C0120S.m648b((C0122a<T>) new C14886n<T>(this, func));
    }
}
