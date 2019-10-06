package p005cm.aptoide.p006pt.notification;

import p005cm.aptoide.p006pt.database.realm.Notification;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.notification.ta */
/* compiled from: lambda */
public final /* synthetic */ class C4228ta implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ SystemNotificationShower f7802a;

    /* renamed from: b */
    private final /* synthetic */ NotificationInfo f7803b;

    public /* synthetic */ C4228ta(SystemNotificationShower systemNotificationShower, NotificationInfo notificationInfo) {
        this.f7802a = systemNotificationShower;
        this.f7803b = notificationInfo;
    }

    public final void call(Object obj) {
        this.f7802a.mo2259a(this.f7803b, (Notification) obj);
    }
}
