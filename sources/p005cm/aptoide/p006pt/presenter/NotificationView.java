package p005cm.aptoide.p006pt.presenter;

import p005cm.aptoide.p006pt.notification.NotificationInfo;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.presenter.NotificationView */
public interface NotificationView extends View {
    C0120S<NotificationInfo> getActionBootCompleted();

    C0120S<NotificationInfo> getNotificationClick();

    C0120S<NotificationInfo> getNotificationDismissed();
}
