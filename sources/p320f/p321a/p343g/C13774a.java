package p320f.p321a.p343g;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import p024io.reactivex.exceptions.CompositeException;
import p024io.reactivex.exceptions.MissingBackpressureException;
import p024io.reactivex.exceptions.OnErrorNotImplementedException;
import p024io.reactivex.exceptions.UndeliverableException;
import p320f.p321a.C13192b;
import p320f.p321a.C13198c;
import p320f.p321a.C13764f;
import p320f.p321a.C13775h;
import p320f.p321a.C13787i;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.C13810v;
import p320f.p321a.C13812x;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p326c.C13203e;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p340j.C13748j;
import p320f.p321a.p341e.C13762a;
import p363i.p368b.C14229b;

/* renamed from: f.a.g.a */
/* compiled from: RxJavaPlugins */
public final class C13774a {

    /* renamed from: a */
    static volatile C13204f<? super Throwable> f41901a;

    /* renamed from: b */
    static volatile C13212n<? super Runnable, ? extends Runnable> f41902b;

    /* renamed from: c */
    static volatile C13212n<? super Callable<C13805u>, ? extends C13805u> f41903c;

    /* renamed from: d */
    static volatile C13212n<? super Callable<C13805u>, ? extends C13805u> f41904d;

    /* renamed from: e */
    static volatile C13212n<? super Callable<C13805u>, ? extends C13805u> f41905e;

    /* renamed from: f */
    static volatile C13212n<? super Callable<C13805u>, ? extends C13805u> f41906f;

    /* renamed from: g */
    static volatile C13212n<? super C13805u, ? extends C13805u> f41907g;

    /* renamed from: h */
    static volatile C13212n<? super C13805u, ? extends C13805u> f41908h;

    /* renamed from: i */
    static volatile C13212n<? super C13805u, ? extends C13805u> f41909i;

    /* renamed from: j */
    static volatile C13212n<? super C13764f, ? extends C13764f> f41910j;

    /* renamed from: k */
    static volatile C13212n<? super C13797m, ? extends C13797m> f41911k;

    /* renamed from: l */
    static volatile C13212n<? super C13762a, ? extends C13762a> f41912l;

    /* renamed from: m */
    static volatile C13212n<? super C13775h, ? extends C13775h> f41913m;

    /* renamed from: n */
    static volatile C13212n<? super C13810v, ? extends C13810v> f41914n;

    /* renamed from: o */
    static volatile C13212n<? super C13192b, ? extends C13192b> f41915o;

    /* renamed from: p */
    static volatile C13201c<? super C13764f, ? super C14229b, ? extends C14229b> f41916p;

    /* renamed from: q */
    static volatile C13201c<? super C13775h, ? super C13787i, ? extends C13787i> f41917q;

    /* renamed from: r */
    static volatile C13201c<? super C13797m, ? super C13804t, ? extends C13804t> f41918r;

    /* renamed from: s */
    static volatile C13201c<? super C13810v, ? super C13812x, ? extends C13812x> f41919s;

    /* renamed from: t */
    static volatile C13201c<? super C13192b, ? super C13198c, ? extends C13198c> f41920t;

    /* renamed from: u */
    static volatile C13203e f41921u;

    /* renamed from: v */
    static volatile boolean f41922v;

    /* renamed from: a */
    public static boolean m43832a() {
        return f41922v;
    }

    /* renamed from: b */
    public static C13805u m43835b(Callable<C13805u> defaultScheduler) {
        C13264b.m43226a(defaultScheduler, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> f = f41903c;
        if (f == null) {
            return m43825a(defaultScheduler);
        }
        return m43823a((C13212n<? super Callable<C13805u>, ? extends C13805u>) f, defaultScheduler);
    }

    /* renamed from: c */
    public static C13805u m43839c(Callable<C13805u> defaultScheduler) {
        C13264b.m43226a(defaultScheduler, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> f = f41905e;
        if (f == null) {
            return m43825a(defaultScheduler);
        }
        return m43823a((C13212n<? super Callable<C13805u>, ? extends C13805u>) f, defaultScheduler);
    }

    /* renamed from: d */
    public static C13805u m43841d(Callable<C13805u> defaultScheduler) {
        C13264b.m43226a(defaultScheduler, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> f = f41906f;
        if (f == null) {
            return m43825a(defaultScheduler);
        }
        return m43823a((C13212n<? super Callable<C13805u>, ? extends C13805u>) f, defaultScheduler);
    }

    /* renamed from: e */
    public static C13805u m43842e(Callable<C13805u> defaultScheduler) {
        C13264b.m43226a(defaultScheduler, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> f = f41904d;
        if (f == null) {
            return m43825a(defaultScheduler);
        }
        return m43823a((C13212n<? super Callable<C13805u>, ? extends C13805u>) f, defaultScheduler);
    }

    /* renamed from: a */
    public static C13805u m43824a(C13805u defaultScheduler) {
        Function<? super Scheduler, ? extends Scheduler> f = f41907g;
        if (f == null) {
            return defaultScheduler;
        }
        return (C13805u) m43830a((C13212n<T, R>) f, (T) defaultScheduler);
    }

    /* renamed from: b */
    public static void m43836b(Throwable error) {
        Consumer<? super Throwable> f = f41901a;
        if (error == null) {
            error = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!m43833a(error)) {
            error = new UndeliverableException(error);
        }
        if (f != null) {
            try {
                f.accept(error);
                return;
            } catch (Throwable e) {
                e.printStackTrace();
                m43840c(e);
            }
        }
        error.printStackTrace();
        m43840c(error);
    }

    /* renamed from: a */
    static boolean m43833a(Throwable error) {
        if (!(error instanceof OnErrorNotImplementedException) && !(error instanceof MissingBackpressureException) && !(error instanceof IllegalStateException) && !(error instanceof NullPointerException) && !(error instanceof IllegalArgumentException) && !(error instanceof CompositeException)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    static void m43840c(Throwable error) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
    }

    /* renamed from: b */
    public static C13805u m43834b(C13805u defaultScheduler) {
        Function<? super Scheduler, ? extends Scheduler> f = f41908h;
        if (f == null) {
            return defaultScheduler;
        }
        return (C13805u) m43830a((C13212n<T, R>) f, (T) defaultScheduler);
    }

    /* renamed from: c */
    public static C13805u m43838c(C13805u defaultScheduler) {
        Function<? super Scheduler, ? extends Scheduler> f = f41909i;
        if (f == null) {
            return defaultScheduler;
        }
        return (C13805u) m43830a((C13212n<T, R>) f, (T) defaultScheduler);
    }

    /* renamed from: a */
    public static Runnable m43831a(Runnable run) {
        C13264b.m43226a(run, "run is null");
        Function<? super Runnable, ? extends Runnable> f = f41902b;
        if (f == null) {
            return run;
        }
        return (Runnable) m43830a((C13212n<T, R>) f, (T) run);
    }

    /* renamed from: a */
    public static <T> C14229b<? super T> m43828a(C13764f<T> source, C14229b<? super T> subscriber) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> f = f41916p;
        if (f != null) {
            return (C14229b) m43829a(f, source, subscriber);
        }
        return subscriber;
    }

    /* renamed from: a */
    public static <T> C13804t<? super T> m43822a(C13797m<T> source, C13804t<? super T> observer) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> f = f41918r;
        if (f != null) {
            return (C13804t) m43829a(f, source, observer);
        }
        return observer;
    }

    /* renamed from: a */
    public static <T> C13812x<? super T> m43827a(C13810v<T> source, C13812x<? super T> observer) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> f = f41919s;
        if (f != null) {
            return (C13812x) m43829a(f, source, observer);
        }
        return observer;
    }

    /* renamed from: a */
    public static C13198c m43816a(C13192b source, C13198c observer) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> f = f41920t;
        if (f != null) {
            return (C13198c) m43829a(f, source, observer);
        }
        return observer;
    }

    /* renamed from: a */
    public static <T> C13787i<? super T> m43820a(C13775h<T> source, C13787i<? super T> subscriber) {
        BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> f = f41917q;
        if (f != null) {
            return (C13787i) m43829a(f, source, subscriber);
        }
        return subscriber;
    }

    /* renamed from: a */
    public static <T> C13775h<T> m43819a(C13775h<T> source) {
        Function<? super Maybe, ? extends Maybe> f = f41913m;
        if (f != null) {
            return (C13775h) m43830a((C13212n<T, R>) f, (T) source);
        }
        return source;
    }

    /* renamed from: a */
    public static <T> C13764f<T> m43818a(C13764f<T> source) {
        Function<? super Flowable, ? extends Flowable> f = f41910j;
        if (f != null) {
            return (C13764f) m43830a((C13212n<T, R>) f, (T) source);
        }
        return source;
    }

    /* renamed from: a */
    public static <T> C13797m<T> m43821a(C13797m<T> source) {
        Function<? super Observable, ? extends Observable> f = f41911k;
        if (f != null) {
            return (C13797m) m43830a((C13212n<T, R>) f, (T) source);
        }
        return source;
    }

    /* renamed from: a */
    public static <T> C13762a<T> m43817a(C13762a<T> source) {
        Function<? super ConnectableObservable, ? extends ConnectableObservable> f = f41912l;
        if (f != null) {
            return (C13762a) m43830a((C13212n<T, R>) f, (T) source);
        }
        return source;
    }

    /* renamed from: a */
    public static <T> C13810v<T> m43826a(C13810v<T> source) {
        Function<? super Single, ? extends Single> f = f41914n;
        if (f != null) {
            return (C13810v) m43830a((C13212n<T, R>) f, (T) source);
        }
        return source;
    }

    /* renamed from: a */
    public static C13192b m43815a(C13192b source) {
        Function<? super Completable, ? extends Completable> f = f41915o;
        if (f != null) {
            return (C13192b) m43830a((C13212n<T, R>) f, (T) source);
        }
        return source;
    }

    /* renamed from: b */
    public static boolean m43837b() {
        C13203e f = f41921u;
        if (f == null) {
            return false;
        }
        try {
            return f.getAsBoolean();
        } catch (Throwable ex) {
            throw C13748j.m43761a(ex);
        }
    }

    /* renamed from: a */
    static <T, R> R m43830a(C13212n<T, R> f, T t) {
        try {
            return f.apply(t);
        } catch (Throwable ex) {
            throw C13748j.m43761a(ex);
        }
    }

    /* renamed from: a */
    static <T, U, R> R m43829a(C13201c<T, U, R> f, T t, U u) {
        try {
            return f.apply(t, u);
        } catch (Throwable ex) {
            throw C13748j.m43761a(ex);
        }
    }

    /* renamed from: a */
    static C13805u m43825a(Callable<C13805u> s) {
        try {
            Object call = s.call();
            C13264b.m43226a(call, "Scheduler Callable result can't be null");
            return (C13805u) call;
        } catch (Throwable ex) {
            throw C13748j.m43761a(ex);
        }
    }

    /* renamed from: a */
    static C13805u m43823a(C13212n<? super Callable<C13805u>, ? extends C13805u> f, Callable<C13805u> s) {
        Object a = m43830a(f, (T) s);
        C13264b.m43226a(a, "Scheduler Callable result can't be null");
        return (C13805u) a;
    }
}
