package p005cm.aptoide.p006pt.notification;

/* renamed from: cm.aptoide.pt.notification.NotificationSyncScheduler */
public interface NotificationSyncScheduler {
    void forceSync();

    void removeSchedules();

    void schedule();

    void setEnabled(boolean z);
}
