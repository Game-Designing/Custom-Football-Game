package p005cm.aptoide.p006pt.notification;

import p005cm.aptoide.p006pt.notification.sync.LocalNotificationSync;
import p005cm.aptoide.p006pt.sync.Sync;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.notification.LocalNotificationSyncPersistence */
public interface LocalNotificationSyncPersistence {
    C0120S<Sync> get();

    void remove(String str);

    void save(LocalNotificationSync localNotificationSync);
}
