package p026rx.p390c.p395e;

import java.util.List;
import p026rx.C0120S;
import p026rx.C0120S.C0123b;
import p026rx.C14506Q;
import p026rx.exceptions.OnErrorNotImplementedException;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;
import p026rx.p390c.p391a.C14670ha;

/* renamed from: rx.c.e.f */
/* compiled from: InternalObservableUtils */
public enum C14870f {
    ;
    

    /* renamed from: a */
    public static final C14875e f44153a = null;

    /* renamed from: b */
    public static final C14873c f44154b = null;

    /* renamed from: c */
    public static final C14878h f44155c = null;

    /* renamed from: d */
    static final C14877g f44156d = null;

    /* renamed from: e */
    public static final C14874d f44157e = null;

    /* renamed from: f */
    static final C14872b f44158f = null;

    /* renamed from: g */
    public static final C0129b<Throwable> f44159g = null;

    /* renamed from: h */
    public static final C0123b<Boolean, Object> f44160h = null;

    /* renamed from: rx.c.e.f$a */
    /* compiled from: InternalObservableUtils */
    static final class C14871a implements C0129b<Throwable> {
        C14871a() {
        }

        public /* bridge */ /* synthetic */ void call(Object x0) {
            mo46076a((Throwable) x0);
            throw null;
        }

        /* renamed from: a */
        public void mo46076a(Throwable t) {
            throw new OnErrorNotImplementedException(t);
        }
    }

    /* renamed from: rx.c.e.f$b */
    /* compiled from: InternalObservableUtils */
    static final class C14872b implements C0132p<C14506Q<?>, Throwable> {
        C14872b() {
        }

        /* renamed from: a */
        public Throwable call(C14506Q<?> t) {
            return t.mo45702c();
        }
    }

    /* renamed from: rx.c.e.f$c */
    /* compiled from: InternalObservableUtils */
    static final class C14873c implements C14541q<Object, Object, Boolean> {
        C14873c() {
        }

        public Boolean call(Object first, Object second) {
            return Boolean.valueOf(first == second || (first != null && first.equals(second)));
        }
    }

    /* renamed from: rx.c.e.f$d */
    /* compiled from: InternalObservableUtils */
    static final class C14874d implements C14541q<Integer, Object, Integer> {
        C14874d() {
        }

        /* renamed from: a */
        public Integer call(Integer count, Object o) {
            return Integer.valueOf(count.intValue() + 1);
        }
    }

    /* renamed from: rx.c.e.f$e */
    /* compiled from: InternalObservableUtils */
    static final class C14875e implements C14541q<Long, Object, Long> {
        C14875e() {
        }

        /* renamed from: a */
        public Long call(Long count, Object o) {
            return Long.valueOf(count.longValue() + 1);
        }
    }

    /* renamed from: rx.c.e.f$f */
    /* compiled from: InternalObservableUtils */
    static final class C14876f implements C0132p<C0120S<? extends C14506Q<?>>, C0120S<?>> {

        /* renamed from: a */
        final C0132p<? super C0120S<? extends Throwable>, ? extends C0120S<?>> f44162a;

        public C14876f(C0132p<? super C0120S<? extends Throwable>, ? extends C0120S<?>> notificationHandler) {
            this.f44162a = notificationHandler;
        }

        /* renamed from: a */
        public C0120S<?> call(C0120S<? extends C14506Q<?>> notifications) {
            return (C0120S) this.f44162a.call(notifications.mo3669j(C14870f.f44158f));
        }
    }

    /* renamed from: rx.c.e.f$g */
    /* compiled from: InternalObservableUtils */
    static final class C14877g implements C0132p<Object, Void> {
        C14877g() {
        }

        public Void call(Object t) {
            return null;
        }
    }

    /* renamed from: rx.c.e.f$h */
    /* compiled from: InternalObservableUtils */
    static final class C14878h implements C0132p<List<? extends C0120S<?>>, C0120S<?>[]> {
        C14878h() {
        }

        /* renamed from: a */
        public C0120S<?>[] call(List<? extends C0120S<?>> o) {
            return (C0120S[]) o.toArray(new C0120S[o.size()]);
        }
    }

    static {
        f44153a = new C14875e();
        f44154b = new C14873c();
        f44155c = new C14878h();
        f44156d = new C14877g();
        f44157e = new C14874d();
        f44158f = new C14872b();
        f44159g = new C14871a();
        f44160h = new C14670ha(C14900u.m46629a(), true);
    }

    /* renamed from: a */
    public static C0132p<C0120S<? extends C14506Q<?>>, C0120S<?>> m46588a(C0132p<? super C0120S<? extends Throwable>, ? extends C0120S<?>> notificationHandler) {
        return new C14876f(notificationHandler);
    }
}
