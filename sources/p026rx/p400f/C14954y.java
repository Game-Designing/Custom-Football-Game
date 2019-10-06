package p026rx.p400f;

import java.util.concurrent.ThreadFactory;
import p026rx.C0126V;
import p026rx.p027b.C0128a;
import p026rx.p390c.p393c.C14780c;
import p026rx.p390c.p393c.C14787g;
import p026rx.p390c.p393c.C14799n;
import p026rx.p390c.p395e.C14882j;

/* renamed from: rx.f.y */
/* compiled from: RxJavaSchedulersHook */
public class C14954y {

    /* renamed from: a */
    private static final C14954y f44281a = new C14954y();

    /* renamed from: a */
    public static C0126V m46733a() {
        return m46734a((ThreadFactory) new C14882j("RxComputationScheduler-"));
    }

    /* renamed from: a */
    public static C0126V m46734a(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new C14787g(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    /* renamed from: b */
    public static C0126V m46735b() {
        return m46736b(new C14882j("RxIoScheduler-"));
    }

    /* renamed from: b */
    public static C0126V m46736b(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new C14780c(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    /* renamed from: c */
    public static C0126V m46737c() {
        return m46738c(new C14882j("RxNewThreadScheduler-"));
    }

    /* renamed from: c */
    public static C0126V m46738c(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new C14799n(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    /* renamed from: d */
    public C0126V mo46167d() {
        return null;
    }

    /* renamed from: f */
    public C0126V mo46168f() {
        return null;
    }

    /* renamed from: g */
    public C0126V mo46169g() {
        return null;
    }

    @Deprecated
    /* renamed from: a */
    public C0128a mo46166a(C0128a action) {
        return action;
    }

    /* renamed from: e */
    public static C14954y m46739e() {
        return f44281a;
    }
}
