package p005cm.aptoide.p006pt.notification;

import android.app.PendingIntent;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.notification.ga */
/* compiled from: lambda */
public final /* synthetic */ class C4199ga implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ SystemNotificationShower f7754a;

    /* renamed from: b */
    private final /* synthetic */ AptoideNotification f7755b;

    /* renamed from: c */
    private final /* synthetic */ int f7756c;

    public /* synthetic */ C4199ga(SystemNotificationShower systemNotificationShower, AptoideNotification aptoideNotification, int i) {
        this.f7754a = systemNotificationShower;
        this.f7755b = aptoideNotification;
        this.f7756c = i;
    }

    public final Object call(Object obj) {
        return this.f7754a.mo2255a(this.f7755b, this.f7756c, (PendingIntent) obj);
    }
}
