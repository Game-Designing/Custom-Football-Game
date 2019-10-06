package p005cm.aptoide.p006pt.notification;

import java.util.List;
import p005cm.aptoide.accountmanager.Account;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.notification.w */
/* compiled from: lambda */
public final /* synthetic */ class C4248w implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ NotificationService f7825a;

    /* renamed from: b */
    private final /* synthetic */ List f7826b;

    public /* synthetic */ C4248w(NotificationService notificationService, List list) {
        this.f7825a = notificationService;
        this.f7826b = list;
    }

    public final Object call(Object obj) {
        return this.f7825a.mo2232a(this.f7826b, (Account) obj);
    }
}
