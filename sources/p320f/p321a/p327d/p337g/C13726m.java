package p320f.p321a.p327d.p337g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.g.m */
/* compiled from: SchedulerPoolFactory */
public final class C13726m {

    /* renamed from: a */
    public static final boolean f41811a;

    /* renamed from: b */
    public static final int f41812b;

    /* renamed from: c */
    static final AtomicReference<ScheduledExecutorService> f41813c = new AtomicReference<>();

    /* renamed from: d */
    static final Map<ScheduledThreadPoolExecutor, Object> f41814d = new ConcurrentHashMap();

    /* renamed from: f.a.d.g.m$a */
    /* compiled from: SchedulerPoolFactory */
    static final class C13727a implements Runnable {
        C13727a() {
        }

        public void run() {
            try {
                Iterator it = new ArrayList(C13726m.f41814d.keySet()).iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor e = (ScheduledThreadPoolExecutor) it.next();
                    if (e.isShutdown()) {
                        C13726m.f41814d.remove(e);
                    } else {
                        e.purge();
                    }
                }
            } catch (Throwable e2) {
                C13774a.m43836b(e2);
            }
        }
    }

    static {
        boolean purgeEnable = true;
        int purgePeriod = 1;
        Properties properties = System.getProperties();
        String str = "rx2.purge-enabled";
        if (properties.containsKey(str)) {
            purgeEnable = Boolean.getBoolean(str);
        }
        if (purgeEnable) {
            String str2 = "rx2.purge-period-seconds";
            if (properties.containsKey(str2)) {
                purgePeriod = Integer.getInteger(str2, 1).intValue();
            }
        }
        f41811a = purgeEnable;
        f41812b = purgePeriod;
        m43719a();
    }

    /* renamed from: a */
    public static void m43719a() {
        if (f41811a) {
            while (true) {
                ScheduledExecutorService curr = (ScheduledExecutorService) f41813c.get();
                if (curr == null || curr.isShutdown()) {
                    ScheduledExecutorService next = Executors.newScheduledThreadPool(1, new C13720h("RxSchedulerPurge"));
                    if (f41813c.compareAndSet(curr, next)) {
                        C13727a aVar = new C13727a();
                        int i = f41812b;
                        next.scheduleAtFixedRate(aVar, (long) i, (long) i, TimeUnit.SECONDS);
                        return;
                    }
                    next.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static ScheduledExecutorService m43718a(ThreadFactory factory) {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1, factory);
        if (f41811a && (exec instanceof ScheduledThreadPoolExecutor)) {
            f41814d.put((ScheduledThreadPoolExecutor) exec, exec);
        }
        return exec;
    }
}
