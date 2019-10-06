package p005cm.aptoide.p006pt.notification;

import android.app.Notification;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.notification.ua */
/* compiled from: lambda */
public final /* synthetic */ class C4230ua implements C0129b {

    /* renamed from: a */
    private final /* synthetic */ SystemNotificationShower f7805a;

    /* renamed from: b */
    private final /* synthetic */ int f7806b;

    public /* synthetic */ C4230ua(SystemNotificationShower systemNotificationShower, int i) {
        this.f7805a = systemNotificationShower;
        this.f7806b = i;
    }

    public final void call(Object obj) {
        this.f7805a.mo2262b(this.f7806b, (Notification) obj);
    }
}
