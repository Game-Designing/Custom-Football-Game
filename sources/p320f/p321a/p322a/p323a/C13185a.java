package p320f.p321a.p322a.p323a;

import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13805u;
import p320f.p321a.p326c.C13212n;

/* renamed from: f.a.a.a.a */
/* compiled from: RxAndroidPlugins */
public final class C13185a {

    /* renamed from: a */
    private static volatile C13212n<Callable<C13805u>, C13805u> f40285a;

    /* renamed from: b */
    private static volatile C13212n<C13805u, C13805u> f40286b;

    /* renamed from: b */
    public static C13805u m43116b(Callable<C13805u> scheduler) {
        if (scheduler != null) {
            Function<Callable<Scheduler>, Scheduler> f = f40285a;
            if (f == null) {
                return m43114a(scheduler);
            }
            return m43112a((C13212n<Callable<C13805u>, C13805u>) f, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    /* renamed from: a */
    public static C13805u m43113a(C13805u scheduler) {
        if (scheduler != null) {
            Function<Scheduler, Scheduler> f = f40286b;
            if (f == null) {
                return scheduler;
            }
            return (C13805u) m43115a((C13212n<T, R>) f, (T) scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    /* renamed from: a */
    static C13805u m43114a(Callable<C13805u> s) {
        try {
            C13805u scheduler = (C13805u) s.call();
            if (scheduler != null) {
                return scheduler;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable ex) {
            C13980a.m44461a(ex);
            throw null;
        }
    }

    /* renamed from: a */
    static C13805u m43112a(C13212n<Callable<C13805u>, C13805u> f, Callable<C13805u> s) {
        C13805u scheduler = (C13805u) m43115a(f, (T) s);
        if (scheduler != null) {
            return scheduler;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    /* renamed from: a */
    static <T, R> R m43115a(C13212n<T, R> f, T t) {
        try {
            return f.apply(t);
        } catch (Throwable ex) {
            C13980a.m44461a(ex);
            throw null;
        }
    }
}
