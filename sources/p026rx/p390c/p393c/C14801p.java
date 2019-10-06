package p026rx.p390c.p393c;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0128a;
import p026rx.p029i.C0136c;
import p026rx.p029i.C14978f;
import p026rx.p390c.p395e.C14879g;
import p026rx.p390c.p395e.C14882j;
import p026rx.p390c.p395e.C14899t;
import p026rx.p400f.C14948s;

/* renamed from: rx.c.c.p */
/* compiled from: NewThreadWorker */
public class C14801p extends C0127a implements C0137ja {

    /* renamed from: a */
    private static final boolean f44028a;

    /* renamed from: b */
    public static final int f44029b = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    /* renamed from: c */
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f44030c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private static final AtomicReference<ScheduledExecutorService> f44031d = new AtomicReference<>();

    /* renamed from: e */
    private static volatile Object f44032e;

    /* renamed from: f */
    private static final Object f44033f = new Object();

    /* renamed from: g */
    private final ScheduledExecutorService f44034g;

    /* renamed from: h */
    volatile boolean f44035h;

    static {
        boolean purgeForce = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int androidApiVersion = C14879g.m46595a();
        f44028a = !purgeForce && (androidApiVersion == 0 || androidApiVersion >= 21);
    }

    /* renamed from: a */
    public static void m46458a(ScheduledThreadPoolExecutor service) {
        while (true) {
            if (((ScheduledExecutorService) f44031d.get()) != null) {
                break;
            }
            ScheduledExecutorService exec = Executors.newScheduledThreadPool(1, new C14882j("RxSchedulerPurge-"));
            if (f44031d.compareAndSet(null, exec)) {
                C14800o oVar = new C14800o();
                int i = f44029b;
                exec.scheduleAtFixedRate(oVar, (long) i, (long) i, TimeUnit.MILLISECONDS);
                break;
            }
            exec.shutdownNow();
        }
        f44030c.putIfAbsent(service, service);
    }

    /* renamed from: a */
    public static void m46457a(ScheduledExecutorService service) {
        f44030c.remove(service);
    }

    /* renamed from: c */
    static void m46460c() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = f44030c.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor exec = (ScheduledThreadPoolExecutor) it.next();
                if (!exec.isShutdown()) {
                    exec.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable t) {
            C14927a.m46678c(t);
            C14948s.m46719b(t);
        }
    }

    /* renamed from: c */
    public static boolean m46461c(ScheduledExecutorService executor) {
        Method methodToCall;
        if (f44028a) {
            if (executor instanceof ScheduledThreadPoolExecutor) {
                Object localSetRemoveOnCancelPolicyMethod = f44032e;
                if (localSetRemoveOnCancelPolicyMethod == f44033f) {
                    return false;
                }
                if (localSetRemoveOnCancelPolicyMethod == null) {
                    Method method = m46459b(executor);
                    f44032e = method != 0 ? method : f44033f;
                    methodToCall = method;
                } else {
                    methodToCall = (Method) localSetRemoveOnCancelPolicyMethod;
                }
            } else {
                methodToCall = m46459b(executor);
            }
            if (methodToCall != 0) {
                try {
                    methodToCall.invoke(executor, new Object[]{Boolean.valueOf(true)});
                    return true;
                } catch (InvocationTargetException e) {
                    C14948s.m46719b((Throwable) e);
                } catch (IllegalAccessException e2) {
                    C14948s.m46719b((Throwable) e2);
                } catch (IllegalArgumentException e3) {
                    C14948s.m46719b((Throwable) e3);
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    static Method m46459b(ScheduledExecutorService executor) {
        Method[] arr$;
        for (Method method : executor.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public C14801p(ThreadFactory threadFactory) {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1, threadFactory);
        if (!m46461c(exec) && (exec instanceof ScheduledThreadPoolExecutor)) {
            m46458a((ScheduledThreadPoolExecutor) exec);
        }
        this.f44034g = exec;
    }

    /* renamed from: a */
    public C0137ja mo3707a(C0128a action) {
        return mo3709a(action, 0, null);
    }

    /* renamed from: a */
    public C0137ja mo3709a(C0128a action, long delayTime, TimeUnit unit) {
        if (this.f44035h) {
            return C14978f.m46782b();
        }
        return mo45937b(action, delayTime, unit);
    }

    /* renamed from: b */
    public C14805s mo45937b(C0128a action, long delayTime, TimeUnit unit) {
        Future<?> f;
        C14805s run = new C14805s(C14948s.m46713a(action));
        if (delayTime <= 0) {
            f = this.f44034g.submit(run);
        } else {
            f = this.f44034g.schedule(run, delayTime, unit);
        }
        run.mo45940a(f);
        return run;
    }

    /* renamed from: a */
    public C14805s mo45936a(C0128a action, long delayTime, TimeUnit unit, C0136c parent) {
        Future<?> f;
        C14805s run = new C14805s(C14948s.m46713a(action), parent);
        parent.mo3713a((C0137ja) run);
        if (delayTime <= 0) {
            f = this.f44034g.submit(run);
        } else {
            f = this.f44034g.schedule(run, delayTime, unit);
        }
        run.mo45940a(f);
        return run;
    }

    /* renamed from: a */
    public C14805s mo45935a(C0128a action, long delayTime, TimeUnit unit, C14899t parent) {
        Future<?> f;
        C14805s run = new C14805s(C14948s.m46713a(action), parent);
        parent.mo46107a((C0137ja) run);
        if (delayTime <= 0) {
            f = this.f44034g.submit(run);
        } else {
            f = this.f44034g.schedule(run, delayTime, unit);
        }
        run.mo45940a(f);
        return run;
    }

    public void unsubscribe() {
        this.f44035h = true;
        this.f44034g.shutdownNow();
        m46457a(this.f44034g);
    }

    public boolean isUnsubscribed() {
        return this.f44035h;
    }
}
