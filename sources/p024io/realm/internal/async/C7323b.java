package p024io.realm.internal.async;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* renamed from: io.realm.internal.async.b */
/* compiled from: RealmThreadPoolExecutor */
public class C7323b extends ThreadPoolExecutor {

    /* renamed from: a */
    private static final int f14289a = m16086b();

    /* renamed from: b */
    private boolean f14290b;

    /* renamed from: c */
    private ReentrantLock f14291c = new ReentrantLock();

    /* renamed from: d */
    private Condition f14292d = this.f14291c.newCondition();

    /* renamed from: a */
    public static C7323b m16085a() {
        int i = f14289a;
        return new C7323b(i, i);
    }

    /* renamed from: b */
    private static int m16086b() {
        int cpus = m16084a("/sys/devices/system/cpu/", "cpu[0-9]+");
        if (cpus <= 0) {
            cpus = Runtime.getRuntime().availableProcessors();
        }
        if (cpus <= 0) {
            return 1;
        }
        return 1 + (cpus * 2);
    }

    /* renamed from: a */
    private static int m16084a(String dirPath, String pattern) {
        int i = 0;
        try {
            File[] files = new File(dirPath).listFiles(new C7322a(Pattern.compile(pattern)));
            if (files != null) {
                i = files.length;
            }
            return i;
        } catch (SecurityException e) {
            return 0;
        }
    }

    private C7323b(int corePoolSize, int maxPoolSize) {
        super(corePoolSize, maxPoolSize, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(100));
    }

    /* access modifiers changed from: protected */
    public void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        this.f14291c.lock();
        while (this.f14290b) {
            try {
                this.f14292d.await();
            } catch (InterruptedException e) {
                t.interrupt();
            } catch (Throwable th) {
                this.f14291c.unlock();
                throw th;
            }
        }
        this.f14291c.unlock();
    }
}
