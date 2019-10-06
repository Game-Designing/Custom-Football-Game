package p005cm.aptoide.p006pt.notification.view;

import java.util.List;
import p005cm.aptoide.p006pt.notification.AptoideNotification;
import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.notification.view.InboxView */
public interface InboxView extends View {
    C0120S<AptoideNotification> notificationSelection();

    void showEmptyState();

    void showNotifications(List<AptoideNotification> list);
}
