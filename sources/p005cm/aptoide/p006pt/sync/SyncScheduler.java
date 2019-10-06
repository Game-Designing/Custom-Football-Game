package p005cm.aptoide.p006pt.sync;

/* renamed from: cm.aptoide.pt.sync.SyncScheduler */
public interface SyncScheduler {
    void cancel(String str);

    void reschedule(Sync sync);

    void schedule(Sync sync);
}
