package p005cm.aptoide.p006pt.notification;

import p005cm.aptoide.p006pt.database.realm.Notification;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.notification.ma */
/* compiled from: lambda */
public final /* synthetic */ class C4211ma implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ NotificationInfo f7775a;

    public /* synthetic */ C4211ma(NotificationInfo notificationInfo) {
        this.f7775a = notificationInfo;
    }

    public final Object call(Object obj) {
        NotificationInfo notificationInfo = this.f7775a;
        SystemNotificationShower.m450b(notificationInfo, (Notification) obj);
        return notificationInfo;
    }
}
