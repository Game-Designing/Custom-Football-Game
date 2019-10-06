package p005cm.aptoide.p006pt.notification.view;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.analytics.implementation.navigation.ScreenTagHistory.Builder;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.notification.AptoideNotification;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.notification.NotificationCenter;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.C0120S.C0121c;
import p026rx.C0126V;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.notification.view.InboxPresenter */
public class InboxPresenter implements Presenter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int NUMBER_OF_NOTIFICATIONS = 50;
    private final NotificationAnalytics analytics;
    private final CrashReport crashReport;
    private final NavigationTracker navigationTracker;
    private final NotificationCenter notificationCenter;
    private final InboxView view;
    private final C0126V viewScheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3222887466921689034L, "cm/aptoide/pt/notification/view/InboxPresenter", 39);
        $jacocoData = probes;
        return probes;
    }

    public InboxPresenter(InboxView view2, NotificationCenter notificationCenter2, CrashReport crashReport2, NavigationTracker navigationTracker2, NotificationAnalytics analytics2, C0126V viewScheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.view = view2;
        this.notificationCenter = notificationCenter2;
        this.crashReport = crashReport2;
        this.navigationTracker = navigationTracker2;
        this.analytics = analytics2;
        this.viewScheduler = viewScheduler2;
        $jacocoInit[0] = true;
    }

    public void present() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S lifecycleEvent = this.view.getLifecycleEvent();
        C4243k kVar = C4243k.f7819a;
        $jacocoInit[1] = true;
        C0120S d = lifecycleEvent.mo3653d((C0132p<? super T, Boolean>) kVar);
        C4236d dVar = new C4236d(this);
        $jacocoInit[2] = true;
        C0120S f = d.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) dVar);
        C0126V v = this.viewScheduler;
        $jacocoInit[3] = true;
        C0120S a = f.mo3616a(v);
        C4245m mVar = new C4245m(this);
        $jacocoInit[4] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) mVar);
        InboxView inboxView = this.view;
        LifecycleEvent lifecycleEvent2 = LifecycleEvent.DESTROY;
        $jacocoInit[5] = true;
        C0120S a2 = b.mo3614a((C0121c<? super T, ? extends R>) inboxView.bindUntilEvent(lifecycleEvent2));
        C4237e eVar = C4237e.f7813a;
        C4234b bVar = new C4234b(this);
        $jacocoInit[6] = true;
        a2.mo3626a((C0129b<? super T>) eVar, (C0129b<Throwable>) bVar);
        $jacocoInit[7] = true;
        C0120S lifecycleEvent3 = this.view.getLifecycleEvent();
        C4238f fVar = C4238f.f7814a;
        $jacocoInit[8] = true;
        C0120S d2 = lifecycleEvent3.mo3653d((C0132p<? super T, Boolean>) fVar);
        C4242j jVar = new C4242j(this);
        $jacocoInit[9] = true;
        C0120S f2 = d2.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) jVar);
        C4241i iVar = new C4241i(this);
        $jacocoInit[10] = true;
        C0120S b2 = f2.mo3636b((C0129b<? super T>) iVar);
        InboxView inboxView2 = this.view;
        LifecycleEvent lifecycleEvent4 = LifecycleEvent.DESTROY;
        $jacocoInit[11] = true;
        C0120S a3 = b2.mo3614a((C0121c<? super T, ? extends R>) inboxView2.bindUntilEvent(lifecycleEvent4));
        C4240h hVar = C4240h.f7816a;
        C4235c cVar = new C4235c(this);
        $jacocoInit[12] = true;
        a3.mo3626a((C0129b<? super T>) hVar, (C0129b<Throwable>) cVar);
        $jacocoInit[13] = true;
        C0120S lifecycleEvent5 = this.view.getLifecycleEvent();
        C4244l lVar = C4244l.f7820a;
        $jacocoInit[14] = true;
        C0120S d3 = lifecycleEvent5.mo3653d((C0132p<? super T, Boolean>) lVar);
        C4239g gVar = new C4239g(this);
        $jacocoInit[15] = true;
        C0120S g = d3.mo3663g((C0132p<? super T, ? extends C0117M>) gVar);
        InboxView inboxView3 = this.view;
        LifecycleEvent lifecycleEvent6 = LifecycleEvent.DESTROY;
        $jacocoInit[16] = true;
        C0120S a4 = g.mo3614a((C0121c<? super T, ? extends R>) inboxView3.bindUntilEvent(lifecycleEvent6));
        C4233a aVar = C4233a.f7809a;
        C4246n nVar = new C4246n(this);
        $jacocoInit[17] = true;
        a4.mo3626a((C0129b<? super T>) aVar, (C0129b<Throwable>) nVar);
        $jacocoInit[18] = true;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8637a(LifecycleEvent event) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(event.equals(LifecycleEvent.CREATE));
        $jacocoInit[38] = true;
        return valueOf;
    }

    /* renamed from: b */
    public /* synthetic */ C0120S mo15333b(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S inboxNotifications = this.notificationCenter.getInboxNotifications(50);
        $jacocoInit[37] = true;
        return inboxNotifications;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15332a(List notifications) {
        boolean[] $jacocoInit = $jacocoInit();
        if (notifications.isEmpty()) {
            $jacocoInit[33] = true;
            this.view.showEmptyState();
            $jacocoInit[34] = true;
        } else {
            this.view.showNotifications(notifications);
            $jacocoInit[35] = true;
        }
        $jacocoInit[36] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8639b(List notifications) {
        $jacocoInit()[32] = true;
    }

    /* renamed from: b */
    public /* synthetic */ void mo15334b(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[31] = true;
    }

    /* renamed from: f */
    static /* synthetic */ Boolean m8642f(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[30] = true;
        return valueOf;
    }

    /* renamed from: g */
    public /* synthetic */ C0120S mo15337g(LifecycleEvent __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S notificationSelection = this.view.notificationSelection();
        $jacocoInit[29] = true;
        return notificationSelection;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15330a(AptoideNotification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        this.analytics.sendNotificationTouchEvent(notification.getNotificationCenterUrlTrack());
        $jacocoInit[25] = true;
        NavigationTracker navigationTracker2 = this.navigationTracker;
        Class cls = getClass();
        $jacocoInit[26] = true;
        String simpleName = cls.getSimpleName();
        $jacocoInit[27] = true;
        navigationTracker2.registerScreen(Builder.build(simpleName));
        $jacocoInit[28] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m8638b(AptoideNotification notificationUrl) {
        $jacocoInit()[24] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo15335c(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[23] = true;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m8640c(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(lifecycleEvent.equals(LifecycleEvent.CREATE));
        $jacocoInit[22] = true;
        return valueOf;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo15336d(LifecycleEvent create) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M allNotificationsRead = this.notificationCenter.setAllNotificationsRead();
        $jacocoInit[21] = true;
        return allNotificationsRead;
    }

    /* renamed from: e */
    static /* synthetic */ void m8641e(LifecycleEvent notificationUrl) {
        $jacocoInit()[20] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo15331a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashReport.log(throwable);
        $jacocoInit[19] = true;
    }
}
