package p026rx.p390c.p393c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import p026rx.p390c.p395e.C14882j;
import p026rx.p400f.C14948s;
import rx.functions.Func0;

/* renamed from: rx.c.c.l */
/* compiled from: GenericScheduledExecutorServiceFactory */
enum C14796l {
    ;
    

    /* renamed from: a */
    static final C14882j f44022a = null;

    static {
        f44022a = new C14882j("RxScheduledExecutorPool-");
    }

    /* renamed from: g */
    static ThreadFactory m46454g() {
        return f44022a;
    }

    /* renamed from: e */
    public static ScheduledExecutorService m46452e() {
        Func0<? extends ScheduledExecutorService> f = C14948s.m46714a();
        if (f == null) {
            return m46453f();
        }
        return (ScheduledExecutorService) f.call();
    }

    /* renamed from: f */
    static ScheduledExecutorService m46453f() {
        return Executors.newScheduledThreadPool(1, m46454g());
    }
}
