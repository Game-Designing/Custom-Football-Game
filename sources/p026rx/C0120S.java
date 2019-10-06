package p026rx;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import p026rx.C14504P.C14505a;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.OnErrorFailedException;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0131o;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14537m;
import p026rx.p027b.C14541q;
import p026rx.p027b.C14542r;
import p026rx.p027b.C14544t;
import p026rx.p027b.C14545u;
import p026rx.p027b.C14549z;
import p026rx.p390c.p391a.C14553Aa;
import p026rx.p390c.p391a.C14557B;
import p026rx.p390c.p391a.C14560Ba;
import p026rx.p390c.p391a.C14564C;
import p026rx.p390c.p391a.C14568D;
import p026rx.p390c.p391a.C14571E;
import p026rx.p390c.p391a.C14576F;
import p026rx.p390c.p391a.C14579G;
import p026rx.p390c.p391a.C14581Ga;
import p026rx.p390c.p391a.C14583H;
import p026rx.p390c.p391a.C14588Ia;
import p026rx.p390c.p391a.C14596Ka;
import p026rx.p390c.p391a.C14602La;
import p026rx.p390c.p391a.C14609Na;
import p026rx.p390c.p391a.C14615Qa;
import p026rx.p390c.p391a.C14617Ra;
import p026rx.p390c.p391a.C14622S;
import p026rx.p390c.p391a.C14631Wa;
import p026rx.p390c.p391a.C14634Y;
import p026rx.p390c.p391a.C14636Z;
import p026rx.p390c.p391a.C14638Za;
import p026rx.p390c.p391a.C14641aa;
import p026rx.p390c.p391a.C14644ab;
import p026rx.p390c.p391a.C14647ba;
import p026rx.p390c.p391a.C14655da;
import p026rx.p390c.p391a.C14656db;
import p026rx.p390c.p391a.C14663fa;
import p026rx.p390c.p391a.C14673ia;
import p026rx.p390c.p391a.C14675ib;
import p026rx.p390c.p391a.C14676j;
import p026rx.p390c.p391a.C14677ja;
import p026rx.p390c.p391a.C14691ma;
import p026rx.p390c.p391a.C14693mb;
import p026rx.p390c.p391a.C14698o;
import p026rx.p390c.p391a.C14705pb;
import p026rx.p390c.p391a.C14707q;
import p026rx.p390c.p391a.C14714ra;
import p026rx.p390c.p391a.C14716s;
import p026rx.p390c.p391a.C14726t;
import p026rx.p390c.p391a.C14727ta;
import p026rx.p390c.p391a.C14729tb;
import p026rx.p390c.p391a.C14731ua;
import p026rx.p390c.p391a.C14732ub;
import p026rx.p390c.p391a.C14737v;
import p026rx.p390c.p391a.C14738va;
import p026rx.p390c.p391a.C14741w;
import p026rx.p390c.p391a.C14743wa;
import p026rx.p390c.p391a.C14748x;
import p026rx.p390c.p391a.C14753y;
import p026rx.p390c.p391a.C14756ya;
import p026rx.p390c.p391a.C14763z;
import p026rx.p390c.p395e.C14823a;
import p026rx.p390c.p395e.C14832b;
import p026rx.p390c.p395e.C14870f;
import p026rx.p390c.p395e.C14880h;
import p026rx.p390c.p395e.C14887o;
import p026rx.p390c.p395e.C14900u;
import p026rx.p398d.C14906b;
import p026rx.p398d.C14908d;
import p026rx.p399e.C14914d;
import p026rx.p400f.C14948s;
import p026rx.schedulers.Schedulers;

/* renamed from: rx.S */
/* compiled from: Observable */
public class C0120S<T> {

    /* renamed from: a */
    final C0122a<T> f156a;

    /* renamed from: rx.S$c */
    /* compiled from: Observable */
    public interface C0121c<T, R> extends C0132p<C0120S<T>, C0120S<R>> {
    }

    /* renamed from: rx.S$a */
    /* compiled from: Observable */
    public interface C0122a<T> extends C0129b<C14980ia<? super T>> {
    }

    /* renamed from: rx.S$b */
    /* compiled from: Observable */
    public interface C0123b<R, T> extends C0132p<C14980ia<? super R>, C14980ia<? super T>> {
    }

    protected C0120S(C0122a<T> f) {
        this.f156a = f;
    }

    @Deprecated
    /* renamed from: a */
    public static <T> C0120S<T> m634a(C0122a<T> f) {
        return new C0120S<>(C14948s.m46707a(f));
    }

    /* renamed from: a */
    public static <T> C0120S<T> m642a(C0129b<C14504P<T>> emitter, C14505a backpressure) {
        return m648b((C0122a<T>) new C14716s<T>(emitter, backpressure));
    }

    /* renamed from: b */
    public static <T> C0120S<T> m648b(C0122a<T> f) {
        return new C0120S<>(C14948s.m46707a(f));
    }

    /* renamed from: a */
    public final <R> C0120S<R> mo3613a(C0123b<? extends R, ? super T> operator) {
        return m648b((C0122a<T>) new C14576F<T>(this.f156a, operator));
    }

    /* renamed from: a */
    public <R> C0120S<R> mo3614a(C0121c<? super T, ? extends R> transformer) {
        return (C0120S) transformer.call(this);
    }

    /* renamed from: n */
    public Single<T> mo3678n() {
        return new Single<>(C14634Y.m46278a(this));
    }

    /* renamed from: l */
    public C0117M mo3673l() {
        return C0117M.m592b(this);
    }

    /* renamed from: a */
    public static <T1, T2, R> C0120S<R> m641a(C0120S<? extends T1> o1, C0120S<? extends T2> o2, C14541q<? super T1, ? super T2, ? extends R> combineFunction) {
        return m632a(Arrays.asList(new C0120S[]{o1, o2}), C14549z.m46180a(combineFunction));
    }

    /* renamed from: a */
    public static <T1, T2, T3, R> C0120S<R> m640a(C0120S<? extends T1> o1, C0120S<? extends T2> o2, C0120S<? extends T3> o3, C14542r<? super T1, ? super T2, ? super T3, ? extends R> combineFunction) {
        return m632a(Arrays.asList(new C0120S[]{o1, o2, o3}), C14549z.m46181a(combineFunction));
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, R> C0120S<R> m639a(C0120S<? extends T1> o1, C0120S<? extends T2> o2, C0120S<? extends T3> o3, C0120S<? extends T4> o4, C0120S<? extends T5> o5, C14544t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> combineFunction) {
        return m632a(Arrays.asList(new C0120S[]{o1, o2, o3, o4, o5}), C14549z.m46182a(combineFunction));
    }

    /* renamed from: a */
    public static <T, R> C0120S<R> m632a(List<? extends C0120S<? extends T>> sources, C14545u<? extends R> combineFunction) {
        return m648b((C0122a<T>) new C14698o<T>(sources, combineFunction));
    }

    /* renamed from: a */
    public static <T> C0120S<T> m635a(C0120S<? extends C0120S<? extends T>> observables) {
        return observables.mo3622a(C14900u.m46630b());
    }

    /* renamed from: a */
    public static <T> C0120S<T> m636a(C0120S<? extends T> t1, C0120S<? extends T> t2) {
        return m635a(m630a((T) t1, (T) t2));
    }

    /* renamed from: a */
    public static <T> C0120S<T> m643a(C0131o<C0120S<T>> observableFactory) {
        return m648b((C0122a<T>) new C14726t<T>(observableFactory));
    }

    /* renamed from: c */
    public static <T> C0120S<T> m651c() {
        return C14676j.m46315e();
    }

    /* renamed from: a */
    public static <T> C0120S<T> m631a(Throwable exception) {
        return m648b((C0122a<T>) new C14647ba<T>(exception));
    }

    /* renamed from: a */
    public static <T> C0120S<T> m629a(Iterable<? extends T> iterable) {
        return m648b((C0122a<T>) new C14571E<T>(iterable));
    }

    /* renamed from: a */
    public static <T> C0120S<T> m644a(T[] array) {
        int n = array.length;
        if (n == 0) {
            return m651c();
        }
        if (n == 1) {
            return m652c(array[0]);
        }
        return m648b((C0122a<T>) new C14564C<T>(array));
    }

    /* renamed from: a */
    public static <T> C0120S<T> m633a(Callable<? extends T> func) {
        return m648b((C0122a<T>) new C14568D<T>(func));
    }

    /* renamed from: a */
    public static C0120S<Long> m627a(long initialDelay, long period, TimeUnit unit) {
        return m628a(initialDelay, period, unit, Schedulers.computation());
    }

    /* renamed from: a */
    public static C0120S<Long> m628a(long initialDelay, long period, TimeUnit unit, C0126V scheduler) {
        C14663fa faVar = new C14663fa(initialDelay, period, unit, scheduler);
        return m648b((C0122a<T>) faVar);
    }

    /* renamed from: c */
    public static <T> C0120S<T> m652c(T value) {
        return C14887o.m46612f(value);
    }

    /* renamed from: a */
    public static <T> C0120S<T> m630a(T t1, T t2) {
        return m644a((T[]) new Object[]{t1, t2});
    }

    /* renamed from: b */
    public static <T> C0120S<T> m647b(Iterable<? extends C0120S<? extends T>> sequences) {
        return m653c(m629a(sequences));
    }

    /* renamed from: c */
    public static <T> C0120S<T> m653c(C0120S<? extends C0120S<? extends T>> source) {
        if (source.getClass() == C14887o.class) {
            return ((C14887o) source).mo46097r(C14900u.m46630b());
        }
        return source.mo3613a((C0123b<? extends R, ? super T>) C14756ya.m46395a(false));
    }

    /* renamed from: b */
    public static <T> C0120S<T> m649b(C0120S<? extends T> t1, C0120S<? extends T> t2) {
        return m645a((C0120S<? extends T>[]) new C0120S[]{t1, t2});
    }

    /* renamed from: a */
    public static <T> C0120S<T> m637a(C0120S<? extends T> t1, C0120S<? extends T> t2, C0120S<? extends T> t3) {
        return m645a((C0120S<? extends T>[]) new C0120S[]{t1, t2, t3});
    }

    /* renamed from: a */
    public static <T> C0120S<T> m638a(C0120S<? extends T> t1, C0120S<? extends T> t2, C0120S<? extends T> t3, C0120S<? extends T> t4) {
        return m645a((C0120S<? extends T>[]) new C0120S[]{t1, t2, t3, t4});
    }

    /* renamed from: a */
    public static <T> C0120S<T> m645a(C0120S<? extends T>[] sequences) {
        return m653c(m644a((T[]) sequences));
    }

    /* renamed from: a */
    public static C0120S<Integer> m626a(int start, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count can not be negative");
        } else if (count == 0) {
            return m651c();
        } else {
            if (start > (MoPubClientPositioning.NO_REPEAT - count) + 1) {
                throw new IllegalArgumentException("start + count can not exceed Integer.MAX_VALUE");
            } else if (count == 1) {
                return m652c((T) Integer.valueOf(start));
            } else {
                return m648b((C0122a<T>) new C14583H<T>(start, (count - 1) + start));
            }
        }
    }

    /* renamed from: g */
    public static <T> C0120S<T> m656g(C0120S<? extends C0120S<? extends T>> sequenceOfSequences) {
        return sequenceOfSequences.mo3613a((C0123b<? extends R, ? super T>) C14617Ra.m46253a(false));
    }

    /* renamed from: f */
    public static C0120S<Long> m655f(long delay, TimeUnit unit) {
        return m654e(delay, unit, Schedulers.computation());
    }

    /* renamed from: e */
    public static C0120S<Long> m654e(long delay, TimeUnit unit, C0126V scheduler) {
        return m648b((C0122a<T>) new C14655da<T>(delay, unit, scheduler));
    }

    /* renamed from: b */
    public static <T1, T2, R> C0120S<R> m650b(C0120S<? extends T1> o1, C0120S<? extends T2> o2, C14541q<? super T1, ? super T2, ? extends R> zipFunction) {
        return m652c((T) new C0120S[]{o1, o2}).mo3613a((C0123b<? extends R, ? super T>) new C14732ub<Object,Object>(zipFunction));
    }

    /* renamed from: a */
    public final C0120S<T> mo3605a() {
        return mo3613a((C0123b<? extends R, ? super T>) C14673ia.m46312a());
    }

    /* renamed from: a */
    public final <R> C0120S<R> mo3611a(Class<R> klass) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14677ja<Object,Object>(klass));
    }

    /* renamed from: a */
    public final <R> C0120S<R> mo3622a(C0132p<? super T, ? extends C0120S<? extends R>> func) {
        if (this instanceof C14887o) {
            return ((C14887o) this).mo46097r(func);
        }
        return m648b((C0122a<T>) new C14707q<T>(this, func, 2, 0));
    }

    /* renamed from: a */
    public final C0120S<T> mo3607a(long timeout, TimeUnit unit) {
        return mo3610a(timeout, unit, Schedulers.computation());
    }

    /* renamed from: a */
    public final C0120S<T> mo3610a(long timeout, TimeUnit unit, C0126V scheduler) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14691ma<Object,Object>(timeout, unit, scheduler));
    }

    /* renamed from: a */
    public final C0120S<T> mo3612a(T defaultValue) {
        return mo3659f(m652c(defaultValue));
    }

    /* renamed from: f */
    public final C0120S<T> mo3659f(C0120S<? extends T> alternate) {
        if (alternate != null) {
            return m648b((C0122a<T>) new C14641aa<T>(this, alternate));
        }
        throw new NullPointerException("alternate is null");
    }

    /* renamed from: b */
    public final C0120S<T> mo3630b(long delay, TimeUnit unit) {
        return mo3631b(delay, unit, Schedulers.computation());
    }

    /* renamed from: b */
    public final C0120S<T> mo3631b(long delay, TimeUnit unit, C0126V scheduler) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14714ra<Object,Object>(delay, unit, scheduler));
    }

    /* renamed from: b */
    public final <U> C0120S<T> mo3633b(C0120S<U> other) {
        if (other != null) {
            return m648b((C0122a<T>) new C14737v<T>(this, other));
        }
        throw new NullPointerException();
    }

    /* renamed from: b */
    public final C0120S<T> mo3628b() {
        return mo3613a((C0123b<? extends R, ? super T>) C14727ta.m46368a());
    }

    /* renamed from: c */
    public final <U> C0120S<T> mo3645c(C0132p<? super T, ? extends U> keySelector) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14727ta<Object,Object>(keySelector));
    }

    /* renamed from: a */
    public final C0120S<T> mo3620a(C0128a onCompleted) {
        return m648b((C0122a<T>) new C14741w<T>(this, new C14823a<>(C14537m.m46177a(), C14537m.m46177a(), onCompleted)));
    }

    /* renamed from: a */
    public final C0120S<T> mo3621a(C0129b<? super Throwable> onError) {
        return m648b((C0122a<T>) new C14741w<T>(this, new C14823a<>(C14537m.m46177a(), onError, C14537m.m46177a())));
    }

    /* renamed from: b */
    public final C0120S<T> mo3636b(C0129b<? super T> onNext) {
        return m648b((C0122a<T>) new C14741w<T>(this, new C14823a<>(onNext, C14537m.m46177a(), C14537m.m46177a())));
    }

    /* renamed from: b */
    public final C0120S<T> mo3635b(C0128a subscribe) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14731ua<Object,Object>(subscribe));
    }

    /* renamed from: c */
    public final C0120S<T> mo3644c(C0128a onTerminate) {
        return m648b((C0122a<T>) new C14741w<T>(this, new C14823a<>(C14537m.m46177a(), C14537m.m46176a(onTerminate), onTerminate)));
    }

    /* renamed from: d */
    public final C0120S<T> mo3652d(C0128a unsubscribe) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14738va<Object,Object>(unsubscribe));
    }

    /* renamed from: b */
    public final <R> C0120S<R> mo3637b(C0132p<? super T, ? extends C0120S<? extends R>> mapper) {
        return mo3623a(mapper, C14880h.f44165a);
    }

    /* renamed from: a */
    public final <R> C0120S<R> mo3623a(C0132p<? super T, ? extends C0120S<? extends R>> mapper, int capacityHint) {
        if (capacityHint >= 1) {
            return mo3613a((C0123b<? extends R, ? super T>) new C14743wa<Object,Object>(mapper, capacityHint, MoPubClientPositioning.NO_REPEAT));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("capacityHint > 0 required but it was ");
        sb.append(capacityHint);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: d */
    public final C0120S<T> mo3653d(C0132p<? super T, Boolean> predicate) {
        return m648b((C0122a<T>) new C14748x<T>(this, predicate));
    }

    /* renamed from: d */
    public final C0120S<T> mo3647d() {
        return mo3629b(1).mo3667i();
    }

    /* renamed from: e */
    public final C0120S<T> mo3658e(C0132p<? super T, Boolean> predicate) {
        return mo3679o(predicate).mo3667i();
    }

    /* renamed from: b */
    public final C0120S<T> mo3632b(T defaultValue) {
        return mo3629b(1).mo3650d(defaultValue);
    }

    /* renamed from: f */
    public final <R> C0120S<R> mo3660f(C0132p<? super T, ? extends C0120S<? extends R>> func) {
        if (getClass() == C14887o.class) {
            return ((C14887o) this).mo46097r(func);
        }
        return m653c(mo3669j(func));
    }

    /* renamed from: g */
    public final C0120S<T> mo3663g(C0132p<? super T, ? extends C0117M> mapper) {
        return mo3624a(mapper, false, (int) MoPubClientPositioning.NO_REPEAT);
    }

    /* renamed from: a */
    public final C0120S<T> mo3624a(C0132p<? super T, ? extends C0117M> mapper, boolean delayErrors, int maxConcurrency) {
        return m648b((C0122a<T>) new C14753y<T>(this, mapper, delayErrors, maxConcurrency));
    }

    /* renamed from: h */
    public final <R> C0120S<R> mo3666h(C0132p<? super T, ? extends Iterable<? extends R>> collectionSelector) {
        return mo3638b(collectionSelector, C14880h.f44165a);
    }

    /* renamed from: b */
    public final <R> C0120S<R> mo3638b(C0132p<? super T, ? extends Iterable<? extends R>> collectionSelector, int maxConcurrent) {
        return C14557B.m46191a(this, collectionSelector, maxConcurrent);
    }

    /* renamed from: i */
    public final <R> C0120S<R> mo3668i(C0132p<? super T, ? extends Single<? extends R>> mapper) {
        return mo3639b(mapper, false, (int) MoPubClientPositioning.NO_REPEAT);
    }

    /* renamed from: b */
    public final <R> C0120S<R> mo3639b(C0132p<? super T, ? extends Single<? extends R>> mapper, boolean delayErrors, int maxConcurrency) {
        return m648b((C0122a<T>) new C14763z<T>(this, mapper, delayErrors, maxConcurrency));
    }

    /* renamed from: j */
    public final <R> C0120S<R> mo3669j(C0132p<? super T, ? extends R> func) {
        return m648b((C0122a<T>) new C14579G<T>(this, func));
    }

    /* renamed from: d */
    public final C0120S<T> mo3651d(C0120S<? extends T> t1) {
        return m649b(this, t1);
    }

    /* renamed from: a */
    public final C0120S<T> mo3616a(C0126V scheduler) {
        return mo3617a(scheduler, C14880h.f44165a);
    }

    /* renamed from: a */
    public final C0120S<T> mo3617a(C0126V scheduler, int bufferSize) {
        return mo3619a(scheduler, false, bufferSize);
    }

    /* renamed from: a */
    public final C0120S<T> mo3619a(C0126V scheduler, boolean delayError, int bufferSize) {
        if (this instanceof C14887o) {
            return ((C14887o) this).mo46095d(scheduler);
        }
        return mo3613a((C0123b<? extends R, ? super T>) new C14553Aa<Object,Object>(scheduler, delayError, bufferSize));
    }

    /* renamed from: e */
    public final C0120S<T> mo3654e() {
        return mo3613a((C0123b<? extends R, ? super T>) C14560Ba.m46197a());
    }

    /* renamed from: k */
    public final C0120S<T> mo3671k(C0132p<? super Throwable, ? extends C0120S<? extends T>> resumeFunction) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14581Ga<Object,Object>(resumeFunction));
    }

    /* renamed from: e */
    public final C0120S<T> mo3657e(C0120S<? extends T> resumeSequence) {
        return mo3613a((C0123b<? extends R, ? super T>) C14581Ga.m46218a(resumeSequence));
    }

    /* renamed from: l */
    public final C0120S<T> mo3674l(C0132p<? super Throwable, ? extends T> resumeFunction) {
        return mo3613a((C0123b<? extends R, ? super T>) C14581Ga.m46219a(resumeFunction));
    }

    /* renamed from: f */
    public final C14908d<T> mo3661f() {
        return C14588Ia.m46229i(this);
    }

    /* renamed from: g */
    public final C0120S<T> mo3662g() {
        return C14622S.m46268a(this);
    }

    /* renamed from: m */
    public final C0120S<T> mo3676m(C0132p<? super C0120S<? extends Throwable>, ? extends C0120S<?>> notificationHandler) {
        return C14622S.m46269a(this, C14870f.m46588a(notificationHandler));
    }

    /* renamed from: c */
    public final C0120S<T> mo3641c(long period, TimeUnit unit) {
        return mo3642c(period, unit, Schedulers.computation());
    }

    /* renamed from: c */
    public final C0120S<T> mo3642c(long period, TimeUnit unit, C0126V scheduler) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14596Ka<Object,Object>(period, unit, scheduler));
    }

    /* renamed from: h */
    public final C0120S<T> mo3664h() {
        return mo3661f().mo46117q();
    }

    /* renamed from: i */
    public final C0120S<T> mo3667i() {
        return mo3613a((C0123b<? extends R, ? super T>) C14602La.m46246a());
    }

    /* renamed from: d */
    public final C0120S<T> mo3650d(T defaultValue) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14602La<Object,Object>(defaultValue));
    }

    /* renamed from: a */
    public final C0120S<T> mo3606a(int count) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14609Na<Object,Object>(count));
    }

    /* renamed from: d */
    public final C0120S<T> mo3648d(long time, TimeUnit unit) {
        return mo3649d(time, unit, Schedulers.computation());
    }

    /* renamed from: d */
    public final C0120S<T> mo3649d(long time, TimeUnit unit, C0126V scheduler) {
        C14636Z z = new C14636Z(this, time, unit, scheduler);
        return m648b((C0122a<T>) z);
    }

    /* renamed from: e */
    public final C0120S<T> mo3656e(T t1) {
        return m636a(m652c(t1), this);
    }

    /* renamed from: j */
    public final C0137ja mo3670j() {
        return mo3627a((C14980ia<? super T>) new C14832b<Object>(C14537m.m46177a(), C14870f.f44159g, C14537m.m46177a()));
    }

    /* renamed from: c */
    public final C0137ja mo3646c(C0129b<? super T> onNext) {
        if (onNext != null) {
            return mo3627a((C14980ia<? super T>) new C14832b<Object>(onNext, C14870f.f44159g, C14537m.m46177a()));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    /* renamed from: a */
    public final C0137ja mo3626a(C0129b<? super T> onNext, C0129b<Throwable> onError) {
        if (onNext == null) {
            throw new IllegalArgumentException("onNext can not be null");
        } else if (onError != null) {
            return mo3627a((C14980ia<? super T>) new C14832b<Object>(onNext, onError, C14537m.m46177a()));
        } else {
            throw new IllegalArgumentException("onError can not be null");
        }
    }

    /* renamed from: b */
    public final C0137ja mo3640b(C14980ia<? super T> subscriber) {
        try {
            subscriber.onStart();
            C14948s.m46708a(this, this.f156a).call(subscriber);
            return C14948s.m46715a((C0137ja) subscriber);
        } catch (Throwable e2) {
            C14927a.m46678c(e2);
            StringBuilder sb = new StringBuilder();
            sb.append("Error occurred attempting to subscribe [");
            sb.append(e.getMessage());
            sb.append("] and then again while trying to pass to onError.");
            RuntimeException r = new OnErrorFailedException(sb.toString(), e2);
            C14948s.m46720c((Throwable) r);
            throw r;
        }
    }

    /* renamed from: a */
    public final C0137ja mo3627a(C14980ia<? super T> subscriber) {
        return m646a(subscriber, this);
    }

    /* renamed from: a */
    static <T> C0137ja m646a(C14980ia<? super T> subscriber, C0120S<T> observable) {
        if (subscriber == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        } else if (observable.f156a != null) {
            subscriber.onStart();
            if (!(subscriber instanceof C14914d)) {
                subscriber = new C14914d<>(subscriber);
            }
            try {
                C14948s.m46708a(observable, observable.f156a).call(subscriber);
                return C14948s.m46715a((C0137ja) subscriber);
            } catch (Throwable e2) {
                C14927a.m46678c(e2);
                StringBuilder sb = new StringBuilder();
                sb.append("Error occurred attempting to subscribe [");
                sb.append(e.getMessage());
                sb.append("] and then again while trying to pass to onError.");
                RuntimeException r = new OnErrorFailedException(sb.toString(), e2);
                C14948s.m46720c((Throwable) r);
                throw r;
            }
        } else {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
    }

    /* renamed from: b */
    public final C0120S<T> mo3634b(C0126V scheduler) {
        return mo3618a(scheduler, !(this.f156a instanceof C14716s));
    }

    /* renamed from: a */
    public final C0120S<T> mo3618a(C0126V scheduler, boolean requestOn) {
        if (this instanceof C14887o) {
            return ((C14887o) this).mo46095d(scheduler);
        }
        return m648b((C0122a<T>) new C14615Qa<T>(this, scheduler, requestOn));
    }

    /* renamed from: n */
    public final <R> C0120S<R> mo3677n(C0132p<? super T, ? extends C0120S<? extends R>> func) {
        return m656g(mo3669j(func));
    }

    /* renamed from: b */
    public final C0120S<T> mo3629b(int count) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14631Wa<Object,Object>(count));
    }

    /* renamed from: o */
    public final C0120S<T> mo3679o(C0132p<? super T, Boolean> predicate) {
        return mo3653d(predicate).mo3629b(1);
    }

    /* renamed from: h */
    public final <E> C0120S<T> mo3665h(C0120S<? extends E> other) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14638Za<Object,Object>(other));
    }

    /* renamed from: q */
    public final C0120S<T> mo3681q(C0132p<? super T, Boolean> predicate) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14656db<Object,Object>(predicate));
    }

    /* renamed from: p */
    public final C0120S<T> mo3680p(C0132p<? super T, Boolean> stopPredicate) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14644ab<Object,Object>(stopPredicate));
    }

    /* renamed from: e */
    public final C0120S<T> mo3655e(long intervalDuration, TimeUnit unit) {
        return mo3641c(intervalDuration, unit);
    }

    /* renamed from: a */
    public final C0120S<T> mo3608a(long timeout, TimeUnit timeUnit, C0120S<? extends T> other) {
        return mo3609a(timeout, timeUnit, other, Schedulers.computation());
    }

    /* renamed from: a */
    public final C0120S<T> mo3609a(long timeout, TimeUnit timeUnit, C0120S<? extends T> other, C0126V scheduler) {
        C14675ib ibVar = new C14675ib(timeout, timeUnit, other, scheduler);
        return mo3613a((C0123b<? extends R, ? super T>) ibVar);
    }

    /* renamed from: k */
    public final C14906b<T> mo3672k() {
        return C14906b.m46633a(this);
    }

    /* renamed from: m */
    public final C0120S<List<T>> mo3675m() {
        return mo3613a((C0123b<? extends R, ? super T>) C14693mb.m46332a());
    }

    /* renamed from: a */
    public final C0120S<List<T>> mo3625a(C14541q<? super T, ? super T, Integer> sortFunction) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14705pb<Object,Object>(sortFunction, 10));
    }

    /* renamed from: c */
    public final C0120S<T> mo3643c(C0126V scheduler) {
        return mo3613a((C0123b<? extends R, ? super T>) new C14729tb<Object,Object>(scheduler));
    }

    /* renamed from: a */
    public final <T2, R> C0120S<R> mo3615a(C0120S<? extends T2> other, C14541q<? super T, ? super T2, ? extends R> zipFunction) {
        return m650b(this, other, zipFunction);
    }
}
