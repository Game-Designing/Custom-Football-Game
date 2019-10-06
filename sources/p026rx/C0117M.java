package p026rx;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p026rx.C0120S.C0122a;
import p026rx.Single.C0124a;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0131o;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14537m;
import p026rx.p029i.C14976d;
import p026rx.p390c.p391a.C14661f;
import p026rx.p390c.p391a.C14665g;
import p026rx.p390c.p391a.C14672i;
import p026rx.p390c.p395e.C14900u;
import p026rx.p399e.C14913c;
import p026rx.p400f.C14948s;
import p026rx.schedulers.Schedulers;

/* renamed from: rx.M */
/* compiled from: Completable */
public class C0117M {

    /* renamed from: a */
    static final C0117M f153a = new C0117M(new C14985n(), false);

    /* renamed from: b */
    static final C0117M f154b = new C0117M(new C14490A(), false);

    /* renamed from: c */
    private final C0118a f155c;

    /* renamed from: rx.M$a */
    /* compiled from: Completable */
    public interface C0118a extends C0129b<C14503O> {
    }

    /* renamed from: rx.M$b */
    /* compiled from: Completable */
    public interface C0119b extends C0132p<C14503O, C14503O> {
    }

    /* renamed from: b */
    public static C0117M m590b() {
        C0118a cos = C14948s.m46705a(f153a.f155c);
        C0117M m = f153a;
        if (cos == m.f155c) {
            return m;
        }
        return new C0117M(cos, false);
    }

    /* renamed from: a */
    public static C0117M m587a(C0117M... sources) {
        m583a((T) sources);
        if (sources.length == 0) {
            return m590b();
        }
        if (sources.length == 1) {
            return sources[0];
        }
        return m585a((C0118a) new C14665g(sources));
    }

    /* renamed from: a */
    public static C0117M m585a(C0118a onSubscribe) {
        m583a((T) onSubscribe);
        try {
            return new C0117M(onSubscribe);
        } catch (NullPointerException ex) {
            throw ex;
        } catch (Throwable ex2) {
            C14948s.m46719b(ex2);
            throw m595c(ex2);
        }
    }

    /* renamed from: a */
    public static C0117M m586a(C0131o<? extends C0117M> completableFunc0) {
        m583a((T) completableFunc0);
        return m585a((C0118a) new C14498I(completableFunc0));
    }

    /* renamed from: b */
    public static C0117M m591b(Throwable error) {
        m583a((T) error);
        return m585a((C0118a) new C14499J(error));
    }

    /* renamed from: c */
    public static C0117M m597c(C0128a action) {
        m583a((T) action);
        return m585a((C0118a) new C14500K(action));
    }

    /* renamed from: a */
    public static C0117M m584a(Callable<?> callable) {
        m583a((T) callable);
        return m585a((C0118a) new C14501L(callable));
    }

    /* renamed from: c */
    public static C0117M m598c(C0129b<C14502N> producer) {
        return m585a((C0118a) new C14661f(producer));
    }

    /* renamed from: b */
    public static C0117M m592b(C0120S<?> flowable) {
        m583a((T) flowable);
        return m585a((C0118a) new C14551c(flowable));
    }

    /* renamed from: b */
    public static C0117M m593b(Single<?> single) {
        m583a((T) single);
        return m585a((C0118a) new C14910e(single));
    }

    /* renamed from: b */
    public static C0117M m594b(C0117M... sources) {
        m583a((T) sources);
        if (sources.length == 0) {
            return m590b();
        }
        if (sources.length == 1) {
            return sources[0];
        }
        return m585a((C0118a) new C14672i(sources));
    }

    /* renamed from: c */
    public static C0117M m596c() {
        C0118a cos = C14948s.m46705a(f154b.f155c);
        C0117M m = f154b;
        if (cos == m.f155c) {
            return m;
        }
        return new C0117M(cos, false);
    }

    /* renamed from: a */
    static <T> T m583a(T o) {
        if (o != null) {
            return o;
        }
        throw new NullPointerException();
    }

    /* renamed from: c */
    static NullPointerException m595c(Throwable ex) {
        NullPointerException npe = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        npe.initCause(ex);
        return npe;
    }

    protected C0117M(C0118a onSubscribe) {
        this.f155c = C14948s.m46705a(onSubscribe);
    }

    protected C0117M(C0118a onSubscribe, boolean useHook) {
        this.f155c = useHook ? C14948s.m46705a(onSubscribe) : onSubscribe;
    }

    /* renamed from: a */
    public final void mo3589a() {
        CountDownLatch cdl = new CountDownLatch(1);
        Throwable[] err = new Throwable[1];
        mo3599b((C14503O) new C14928f(this, cdl, err));
        if (cdl.getCount() != 0) {
            try {
                cdl.await();
                if (err[0] != null) {
                    C14927a.m46677b(err[0]);
                    throw null;
                }
            } catch (InterruptedException ex) {
                C14927a.m46677b(ex);
                throw null;
            }
        } else if (err[0] != null) {
            C14927a.m46677b(err[0]);
            throw null;
        }
    }

    /* renamed from: a */
    public final <T> C0120S<T> mo3586a(C0120S<T> next) {
        m583a((T) next);
        return next.mo3633b(mo3604f());
    }

    /* renamed from: a */
    public final <T> Single<T> mo3587a(Single<T> next) {
        m583a((T) next);
        return next.mo3684a(mo3604f());
    }

    /* renamed from: a */
    public final C0117M mo3580a(C0117M next) {
        return mo3592b(next);
    }

    /* renamed from: b */
    public final C0117M mo3592b(C0117M other) {
        m583a((T) other);
        return m587a(this, other);
    }

    /* renamed from: a */
    public final C0117M mo3578a(long delay, TimeUnit unit) {
        return mo3579a(delay, unit, Schedulers.computation(), false);
    }

    /* renamed from: a */
    public final C0117M mo3579a(long delay, TimeUnit unit, C0126V scheduler, boolean delayError) {
        m583a((T) unit);
        m583a((T) scheduler);
        C14981j jVar = new C14981j(this, scheduler, delay, unit, delayError);
        return m585a((C0118a) jVar);
    }

    /* renamed from: a */
    public final C0117M mo3582a(C0128a onCompleted) {
        return mo3584a(C14537m.m46177a(), C14537m.m46177a(), onCompleted, C14537m.m46177a(), C14537m.m46177a());
    }

    /* renamed from: a */
    public final C0117M mo3583a(C0129b<? super Throwable> onError) {
        return mo3584a(C14537m.m46177a(), onError, C14537m.m46177a(), C14537m.m46177a(), C14537m.m46177a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C0117M mo3584a(C0129b<? super C0137ja> onSubscribe, C0129b<? super Throwable> onError, C0128a onComplete, C0128a onAfterTerminate, C0128a onUnsubscribe) {
        m583a((T) onSubscribe);
        m583a((T) onError);
        m583a((T) onComplete);
        m583a((T) onAfterTerminate);
        m583a((T) onUnsubscribe);
        C14984m mVar = new C14984m(this, onComplete, onAfterTerminate, onError, onSubscribe, onUnsubscribe);
        return m585a((C0118a) mVar);
    }

    /* renamed from: b */
    public final C0117M mo3595b(C0129b<? super C0137ja> onSubscribe) {
        return mo3584a(onSubscribe, C14537m.m46177a(), C14537m.m46177a(), C14537m.m46177a(), C14537m.m46177a());
    }

    /* renamed from: b */
    public final C0117M mo3594b(C0128a onTerminate) {
        return mo3584a(C14537m.m46177a(), new C14986o(this, onTerminate), onTerminate, C14537m.m46177a(), C14537m.m46177a());
    }

    /* renamed from: c */
    public final C0117M mo3600c(C0117M other) {
        m583a((T) other);
        return m594b(this, other);
    }

    /* renamed from: a */
    public final C0117M mo3581a(C0126V scheduler) {
        m583a((T) scheduler);
        return m585a((C0118a) new C14990s(this, scheduler));
    }

    /* renamed from: d */
    public final C0117M mo3602d() {
        return mo3585a(C14900u.m46629a());
    }

    /* renamed from: a */
    public final C0117M mo3585a(C0132p<? super Throwable, Boolean> predicate) {
        m583a((T) predicate);
        return m585a((C0118a) new C14997u(this, predicate));
    }

    /* renamed from: b */
    public final C0117M mo3596b(C0132p<? super Throwable, ? extends C0117M> errorMapper) {
        m583a((T) errorMapper);
        return m585a((C0118a) new C15000x(this, errorMapper));
    }

    /* renamed from: c */
    public final C0117M mo3601c(C0132p<? super C0120S<? extends Throwable>, ? extends C0120S<?>> handler) {
        return m592b(mo3604f().mo3676m(handler));
    }

    /* renamed from: e */
    public final C0137ja mo3603e() {
        C14976d mad = new C14976d();
        mo3599b((C14503O) new C15001y(this, mad));
        return mad;
    }

    /* renamed from: a */
    public final C0137ja mo3588a(C0128a onComplete, C0129b<? super Throwable> onError) {
        m583a((T) onComplete);
        m583a((T) onError);
        C14976d mad = new C14976d();
        mo3599b((C14503O) new C15002z(this, onComplete, mad, onError));
        return mad;
    }

    /* renamed from: a */
    static void m588a(Throwable e) {
        Thread thread = Thread.currentThread();
        thread.getUncaughtExceptionHandler().uncaughtException(thread, e);
    }

    /* renamed from: b */
    public final void mo3599b(C14503O s) {
        m583a((T) s);
        try {
            C14948s.m46706a(this, this.f155c).call(s);
        } catch (NullPointerException ex) {
            throw ex;
        } catch (Throwable ex2) {
            C14927a.m46678c(ex2);
            Throwable ex3 = C14948s.m46704a(ex2);
            C14948s.m46719b(ex3);
            throw m595c(ex3);
        }
    }

    /* renamed from: a */
    public final void mo3590a(C14503O s) {
        if (!(s instanceof C14913c)) {
            s = new C14913c(s);
        }
        mo3599b(s);
    }

    /* renamed from: a */
    public final <T> void mo3591a(C14980ia<T> s) {
        m589a(s, true);
    }

    /* renamed from: a */
    private <T> void m589a(C14980ia<T> s, boolean callOnStart) {
        m583a((T) s);
        if (callOnStart) {
            try {
                s.onStart();
            } catch (NullPointerException ex) {
                throw ex;
            } catch (Throwable ex2) {
                C14927a.m46678c(ex2);
                Throwable ex3 = C14948s.m46720c(ex2);
                C14948s.m46719b(ex3);
                throw m595c(ex3);
            }
        }
        mo3599b((C14503O) new C14491B(this, s));
        C14948s.m46715a((C0137ja) s);
    }

    /* renamed from: b */
    public final C0117M mo3593b(C0126V scheduler) {
        m583a((T) scheduler);
        return m585a((C0118a) new C14493D(this, scheduler));
    }

    /* renamed from: f */
    public final <T> C0120S<T> mo3604f() {
        return C0120S.m648b((C0122a<T>) new C14494E<T>(this));
    }

    /* renamed from: b */
    public final <T> Single<T> mo3598b(C0131o<? extends T> completionValueFunc0) {
        m583a((T) completionValueFunc0);
        return Single.m737a((C0124a<T>) new C14496G<T>(this, completionValueFunc0));
    }

    /* renamed from: b */
    public final <T> Single<T> mo3597b(T completionValue) {
        m583a(completionValue);
        return mo3598b((C0131o<? extends T>) new C14497H<Object>(this, completionValue));
    }
}
