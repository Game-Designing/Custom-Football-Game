package p005cm.aptoide.p006pt.database.schedulers;

import android.os.HandlerThread;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0126V;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.database.schedulers.RealmSchedulers */
public final class RealmSchedulers {
    private static final AtomicReference<RealmSchedulers> INSTANCE = new AtomicReference<>();
    private static final String THREAD_NAME = "Realm Thread";
    private final HandlerThread handlerThread = new HandlerThread(THREAD_NAME);
    private final C0126V threadScheduler;

    private RealmSchedulers() {
        this.handlerThread.start();
        this.threadScheduler = C14522a.m46171a(this.handlerThread.getLooper());
    }

    public static C0126V getScheduler() {
        return getInstance().threadScheduler;
    }

    private static RealmSchedulers getInstance() {
        RealmSchedulers current;
        do {
            RealmSchedulers current2 = (RealmSchedulers) INSTANCE.get();
            if (current2 != null) {
                return current2;
            }
            current = new RealmSchedulers();
        } while (!INSTANCE.compareAndSet(null, current));
        return current;
    }

    public static boolean isRealmSchedulerThread(Thread otherThread) {
        return otherThread != null && TextUtils.equals(otherThread.getName(), THREAD_NAME);
    }
}
