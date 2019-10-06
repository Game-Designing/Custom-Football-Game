package p026rx.p400f;

import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
import p026rx.C0117M;
import p026rx.C0117M.C0118a;
import p026rx.C0117M.C0119b;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0120S.C0123b;
import p026rx.C0126V;
import p026rx.C0137ja;
import p026rx.Single;
import p026rx.Single.C0124a;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0131o;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;
import rx.Completable;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

/* renamed from: rx.f.s */
/* compiled from: RxJavaHooks */
public final class C14948s {

    /* renamed from: a */
    static volatile C0129b<Throwable> f44252a;

    /* renamed from: b */
    static volatile C0132p<C0122a, C0122a> f44253b;

    /* renamed from: c */
    static volatile C0132p<C0124a, C0124a> f44254c;

    /* renamed from: d */
    static volatile C0132p<C0118a, C0118a> f44255d;

    /* renamed from: e */
    static volatile C14541q<C0120S, C0122a, C0122a> f44256e;

    /* renamed from: f */
    static volatile C14541q<Single, C0124a, C0124a> f44257f;

    /* renamed from: g */
    static volatile C14541q<C0117M, C0118a, C0118a> f44258g;

    /* renamed from: h */
    static volatile C0132p<C0126V, C0126V> f44259h;

    /* renamed from: i */
    static volatile C0132p<C0126V, C0126V> f44260i;

    /* renamed from: j */
    static volatile C0132p<C0126V, C0126V> f44261j;

    /* renamed from: k */
    static volatile C0132p<C0128a, C0128a> f44262k;

    /* renamed from: l */
    static volatile C0132p<C0137ja, C0137ja> f44263l;

    /* renamed from: m */
    static volatile C0132p<C0137ja, C0137ja> f44264m;

    /* renamed from: n */
    static volatile C0131o<? extends ScheduledExecutorService> f44265n;

    /* renamed from: o */
    static volatile C0132p<Throwable, Throwable> f44266o;

    /* renamed from: p */
    static volatile C0132p<Throwable, Throwable> f44267p;

    /* renamed from: q */
    static volatile C0132p<Throwable, Throwable> f44268q;

    /* renamed from: r */
    static volatile C0132p<C0123b, C0123b> f44269r;

    /* renamed from: s */
    static volatile C0132p<C0123b, C0123b> f44270s;

    /* renamed from: t */
    static volatile C0132p<C0119b, C0119b> f44271t;

    static {
        m46718b();
    }

    /* renamed from: b */
    static void m46718b() {
        f44252a = new C14939j();
        f44256e = new C14940k();
        f44263l = new C14941l();
        f44257f = new C14942m();
        f44264m = new C14943n();
        f44258g = new C14944o();
        f44262k = new C14945p();
        f44266o = new C14946q();
        f44269r = new C14947r();
        f44267p = new C14932c();
        f44270s = new C14933d();
        f44268q = new C14934e();
        f44271t = new C14935f();
        m46722c();
    }

    /* renamed from: c */
    static void m46722c() {
        f44253b = new C14936g();
        f44254c = new C14937h();
        f44255d = new C14938i();
    }

    /* renamed from: b */
    public static void m46719b(Throwable ex) {
        Action1<Throwable> f = f44252a;
        if (f != null) {
            try {
                f.call(ex);
                return;
            } catch (Throwable pluginException) {
                PrintStream printStream = System.err;
                StringBuilder sb = new StringBuilder();
                sb.append("The onError handler threw an Exception. It shouldn't. => ");
                sb.append(pluginException.getMessage());
                printStream.println(sb.toString());
                pluginException.printStackTrace();
                m46724e(pluginException);
            }
        }
        m46724e(ex);
    }

    /* renamed from: e */
    static void m46724e(Throwable ex) {
        Thread current = Thread.currentThread();
        current.getUncaughtExceptionHandler().uncaughtException(current, ex);
    }

    /* renamed from: a */
    public static <T> C0122a<T> m46707a(C0122a<T> onSubscribe) {
        Func1<OnSubscribe, OnSubscribe> f = f44253b;
        if (f != null) {
            return (C0122a) f.call(onSubscribe);
        }
        return onSubscribe;
    }

    /* renamed from: a */
    public static <T> C0124a<T> m46710a(C0124a<T> onSubscribe) {
        Func1<Single.OnSubscribe, Single.OnSubscribe> f = f44254c;
        if (f != null) {
            return (C0124a) f.call(onSubscribe);
        }
        return onSubscribe;
    }

    /* renamed from: a */
    public static C0118a m46705a(C0118a onSubscribe) {
        Func1<Completable.OnSubscribe, Completable.OnSubscribe> f = f44255d;
        if (f != null) {
            return (C0118a) f.call(onSubscribe);
        }
        return onSubscribe;
    }

    /* renamed from: a */
    public static C0126V m46712a(C0126V scheduler) {
        Func1<Scheduler, Scheduler> f = f44259h;
        if (f != null) {
            return (C0126V) f.call(scheduler);
        }
        return scheduler;
    }

    /* renamed from: b */
    public static C0126V m46716b(C0126V scheduler) {
        Func1<Scheduler, Scheduler> f = f44260i;
        if (f != null) {
            return (C0126V) f.call(scheduler);
        }
        return scheduler;
    }

    /* renamed from: c */
    public static C0126V m46721c(C0126V scheduler) {
        Func1<Scheduler, Scheduler> f = f44261j;
        if (f != null) {
            return (C0126V) f.call(scheduler);
        }
        return scheduler;
    }

    /* renamed from: a */
    public static C0128a m46713a(C0128a action) {
        Func1<Action0, Action0> f = f44262k;
        if (f != null) {
            return (C0128a) f.call(action);
        }
        return action;
    }

    /* renamed from: a */
    public static <T> C0122a<T> m46708a(C0120S<T> instance, C0122a<T> onSubscribe) {
        Func2<Observable, OnSubscribe, OnSubscribe> f = f44256e;
        if (f != null) {
            return (C0122a) f.call(instance, onSubscribe);
        }
        return onSubscribe;
    }

    /* renamed from: a */
    public static C0137ja m46715a(C0137ja subscription) {
        Func1<Subscription, Subscription> f = f44263l;
        if (f != null) {
            return (C0137ja) f.call(subscription);
        }
        return subscription;
    }

    /* renamed from: c */
    public static Throwable m46720c(Throwable error) {
        Func1<Throwable, Throwable> f = f44266o;
        if (f != null) {
            return (Throwable) f.call(error);
        }
        return error;
    }

    /* renamed from: a */
    public static <T, R> C0123b<R, T> m46709a(C0123b<R, T> operator) {
        Func1<Operator, Operator> f = f44269r;
        if (f != null) {
            return (C0123b) f.call(operator);
        }
        return operator;
    }

    /* renamed from: a */
    public static <T> C0124a<T> m46711a(Single<T> instance, C0124a<T> onSubscribe) {
        Func2<Single, Single.OnSubscribe, Single.OnSubscribe> f = f44257f;
        if (f != null) {
            return (C0124a) f.call(instance, onSubscribe);
        }
        return onSubscribe;
    }

    /* renamed from: b */
    public static C0137ja m46717b(C0137ja subscription) {
        Func1<Subscription, Subscription> f = f44264m;
        if (f != null) {
            return (C0137ja) f.call(subscription);
        }
        return subscription;
    }

    /* renamed from: d */
    public static Throwable m46723d(Throwable error) {
        Func1<Throwable, Throwable> f = f44267p;
        if (f != null) {
            return (Throwable) f.call(error);
        }
        return error;
    }

    /* renamed from: a */
    public static <T> C0118a m46706a(C0117M instance, C0118a onSubscribe) {
        Func2<Completable, Completable.OnSubscribe, Completable.OnSubscribe> f = f44258g;
        if (f != null) {
            return (C0118a) f.call(instance, onSubscribe);
        }
        return onSubscribe;
    }

    /* renamed from: a */
    public static Throwable m46704a(Throwable error) {
        Func1<Throwable, Throwable> f = f44268q;
        if (f != null) {
            return (Throwable) f.call(error);
        }
        return error;
    }

    /* renamed from: a */
    public static C0131o<? extends ScheduledExecutorService> m46714a() {
        return f44265n;
    }
}
