package p005cm.aptoide.p006pt.notification;

import android.app.PendingIntent;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.notification.ra */
/* compiled from: lambda */
public final /* synthetic */ class C4223ra implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ SystemNotificationShower f7793a;

    /* renamed from: b */
    private final /* synthetic */ AptoideNotification f7794b;

    /* renamed from: c */
    private final /* synthetic */ int f7795c;

    public /* synthetic */ C4223ra(SystemNotificationShower systemNotificationShower, AptoideNotification aptoideNotification, int i) {
        this.f7793a = systemNotificationShower;
        this.f7794b = aptoideNotification;
        this.f7795c = i;
    }

    public final Object call(Object obj) {
        return this.f7793a.mo2261b(this.f7794b, this.f7795c, (PendingIntent) obj);
    }
}
