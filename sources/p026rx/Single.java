package p026rx;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p026rx.C0117M.C0118a;
import p026rx.C0120S.C0122a;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14537m;
import p026rx.p027b.C14541q;
import p026rx.p027b.C14542r;
import p026rx.p390c.p391a.C14555Ab;
import p026rx.p390c.p391a.C14570Db;
import p026rx.p390c.p391a.C14574Eb;
import p026rx.p390c.p391a.C14582Gb;
import p026rx.p390c.p391a.C14594Jb;
import p026rx.p390c.p391a.C14598Kb;
import p026rx.p390c.p391a.C14605Lb;
import p026rx.p390c.p391a.C14657e;
import p026rx.p390c.p391a.C14739vb;
import p026rx.p390c.p391a.C14747wb;
import p026rx.p390c.p391a.C14768zb;
import p026rx.p390c.p395e.C14895s;
import p026rx.p390c.p395e.C14900u;
import p026rx.p400f.C14948s;
import p026rx.p401g.C14959b;
import p026rx.schedulers.Schedulers;

/* renamed from: rx.Single */
public class Single<T> {

    /* renamed from: a */
    final C0124a<T> f157a;

    /* renamed from: rx.Single$a */
    public interface C0124a<T> extends C0129b<C14972ha<? super T>> {
    }

    protected Single(C0124a<T> f) {
        this.f157a = C14948s.m46710a(f);
    }

    /* renamed from: a */
    public static <T> Single<T> m737a(C0124a<T> f) {
        return new Single<>(f);
    }

    /* renamed from: b */
    private static <T> C0120S<T> m741b(Single<T> t) {
        return C0120S.m648b((C0122a<T>) new C14605Lb<T>(t.f157a));
    }

    /* renamed from: a */
    public static <T> Single<T> m735a(Throwable exception) {
        return m737a((C0124a<T>) new C14903ca<T>(exception));
    }

    /* renamed from: b */
    public static <T> Single<T> m742b(Callable<? extends T> func) {
        return m737a((C0124a<T>) new C14747wb<T>(func));
    }

    /* renamed from: a */
    public static <T> Single<T> m734a(T value) {
        return C14895s.m46621b(value);
    }

    /* renamed from: a */
    public static <T> Single<T> m738a(Single<? extends Single<? extends T>> source) {
        if (source instanceof C14895s) {
            return ((C14895s) source).mo46104h(C14900u.m46630b());
        }
        return m737a((C0124a<T>) new C14921ea<T>(source));
    }

    /* renamed from: a */
    public static <T1, T2, R> Single<R> m740a(Single<? extends T1> s1, Single<? extends T2> s2, C14541q<? super T1, ? super T2, ? extends R> zipFunction) {
        return C14594Jb.m46239a(new Single[]{s1, s2}, new C14956fa(zipFunction));
    }

    /* renamed from: a */
    public static <T1, T2, T3, R> Single<R> m739a(Single<? extends T1> s1, Single<? extends T2> s2, Single<? extends T3> s3, C14542r<? super T1, ? super T2, ? super T3, ? extends R> zipFunction) {
        return C14594Jb.m46239a(new Single[]{s1, s2, s3}, new C14960ga(zipFunction));
    }

    /* renamed from: a */
    public final <R> Single<R> mo3688a(C0132p<? super T, ? extends Single<? extends R>> func) {
        if (this instanceof C14895s) {
            return ((C14895s) this).mo46104h(func);
        }
        return m738a(mo3698d(func));
    }

    /* renamed from: c */
    public final <R> C0120S<R> mo3697c(C0132p<? super T, ? extends C0120S<? extends R>> func) {
        return C0120S.m653c(m741b(mo3698d(func)));
    }

    /* renamed from: b */
    public final C0117M mo3693b(C0132p<? super T, ? extends C0117M> func) {
        return C0117M.m585a((C0118a) new C14657e(this, func));
    }

    /* renamed from: d */
    public final <R> Single<R> mo3698d(C0132p<? super T, ? extends R> func) {
        return m737a((C0124a<T>) new C14574Eb<T>(this, func));
    }

    /* renamed from: a */
    public final Single<T> mo3686a(C0126V scheduler) {
        if (this instanceof C14895s) {
            return ((C14895s) this).mo46103c(scheduler);
        }
        if (scheduler != null) {
            return m737a((C0124a<T>) new C14768zb<T>(this.f157a, scheduler));
        }
        throw new NullPointerException("scheduler is null");
    }

    /* renamed from: f */
    public final Single<T> mo3700f(C0132p<Throwable, ? extends T> resumeFunction) {
        return m737a((C0124a<T>) new C14555Ab<T>(this.f157a, resumeFunction));
    }

    /* renamed from: e */
    public final Single<T> mo3699e(C0132p<Throwable, ? extends Single<? extends T>> resumeFunctionInCaseOfError) {
        return new Single<>(C14582Gb.m46221a(this, resumeFunctionInCaseOfError));
    }

    /* renamed from: a */
    public final C0137ja mo3690a(C0129b<? super T> onSuccess, C0129b<Throwable> onError) {
        if (onSuccess == null) {
            throw new IllegalArgumentException("onSuccess can not be null");
        } else if (onError != null) {
            return mo3691a((C14972ha<? super T>) new C14509W<Object>(this, onError, onSuccess));
        } else {
            throw new IllegalArgumentException("onError can not be null");
        }
    }

    /* renamed from: a */
    public final C0137ja mo3691a(C14972ha<? super T> te) {
        if (te != null) {
            try {
                C14948s.m46711a(this, this.f157a).call(te);
                return C14948s.m46717b((C0137ja) te);
            } catch (Throwable e2) {
                C14927a.m46678c(e2);
                StringBuilder sb = new StringBuilder();
                sb.append("Error occurred attempting to subscribe [");
                sb.append(ex.getMessage());
                sb.append("] and then again while trying to pass to onError.");
                RuntimeException r = new RuntimeException(sb.toString(), e2);
                C14948s.m46723d(r);
                throw r;
            }
        } else {
            throw new IllegalArgumentException("te is null");
        }
    }

    /* renamed from: b */
    public final Single<T> mo3694b(C0126V scheduler) {
        if (this instanceof C14895s) {
            return ((C14895s) this).mo46103c(scheduler);
        }
        return m737a((C0124a<T>) new C14512Z<T>(this, scheduler));
    }

    /* renamed from: c */
    public final C0120S<T> mo3696c() {
        return m741b(this);
    }

    /* renamed from: b */
    public final C0117M mo3692b() {
        return C0117M.m593b(this);
    }

    /* renamed from: a */
    public final Single<T> mo3682a(long timeout, TimeUnit timeUnit) {
        return mo3683a(timeout, timeUnit, null, Schedulers.computation());
    }

    /* renamed from: a */
    public final Single<T> mo3683a(long timeout, TimeUnit timeUnit, Single<? extends T> other, C0126V scheduler) {
        if (other == null) {
            other = m735a((Throwable) new TimeoutException());
        }
        C14598Kb kb = new C14598Kb(this.f157a, timeout, timeUnit, scheduler, other.f157a);
        return m737a((C0124a<T>) kb);
    }

    /* renamed from: a */
    public final C14959b<T> mo3689a() {
        return C14959b.m46750a(this);
    }

    /* renamed from: a */
    public final <T2, R> Single<R> mo3685a(Single<? extends T2> other, C14541q<? super T, ? super T2, ? extends R> zipFunction) {
        return m740a(this, other, zipFunction);
    }

    /* renamed from: a */
    public final Single<T> mo3687a(C0129b<Throwable> onError) {
        if (onError != null) {
            return m737a((C0124a<T>) new C14739vb<T>(this, C14537m.m46177a(), new C14526aa(this, onError)));
        }
        throw new IllegalArgumentException("onError is null");
    }

    /* renamed from: b */
    public final Single<T> mo3695b(C0129b<? super T> onSuccess) {
        if (onSuccess != null) {
            return m737a((C0124a<T>) new C14739vb<T>(this, onSuccess, C14537m.m46177a()));
        }
        throw new IllegalArgumentException("onSuccess is null");
    }

    /* renamed from: a */
    public static <T> Single<T> m736a(Callable<Single<T>> singleFactory) {
        return m737a((C0124a<T>) new C14550ba<T>(singleFactory));
    }

    /* renamed from: g */
    public final Single<T> mo3701g(C0132p<C0120S<? extends Throwable>, ? extends C0120S<?>> notificationHandler) {
        return mo3696c().mo3676m(notificationHandler).mo3678n();
    }

    /* renamed from: a */
    public final Single<T> mo3684a(C0120S<?> other) {
        if (other != null) {
            return m737a((C0124a<T>) new C14570Db<T>(this, other));
        }
        throw new NullPointerException();
    }
}
