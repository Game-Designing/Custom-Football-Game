package p005cm.aptoide.p006pt;

import android.app.NotificationManager;
import com.trello.rxlifecycle.C0096f;
import com.trello.rxlifecycle.C0097g;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.notification.NotificationAnalytics;
import p005cm.aptoide.p006pt.notification.NotificationCenter;
import p005cm.aptoide.p006pt.notification.NotificationIdsMapper;
import p005cm.aptoide.p006pt.notification.NotificationInfo;
import p005cm.aptoide.p006pt.notification.NotificationProvider;
import p005cm.aptoide.p006pt.notification.NotificationReceiver;
import p005cm.aptoide.p006pt.notification.SystemNotificationShower;
import p005cm.aptoide.p006pt.presenter.NotificationView;
import p005cm.aptoide.p006pt.presenter.Presenter;
import p005cm.aptoide.p006pt.presenter.View.LifecycleEvent;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.p028h.C0134b;
import p026rx.p029i.C0136c;

/* renamed from: cm.aptoide.pt.NotificationApplicationView */
public abstract class NotificationApplicationView extends AptoideApplication implements NotificationView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private C0134b<LifecycleEvent> lifecycleEventBehaviorSubject;
    private SystemNotificationShower systemNotificationShower;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5110256336477286847L, "cm/aptoide/pt/NotificationApplicationView", 27);
        $jacocoData = probes;
        return probes;
    }

    public NotificationApplicationView() {
        $jacocoInit()[0] = true;
    }

    public void onCreate() {
        boolean[] $jacocoInit = $jacocoInit();
        super.onCreate();
        $jacocoInit[1] = true;
        this.lifecycleEventBehaviorSubject = C0134b.m768p();
        $jacocoInit[2] = true;
        this.lifecycleEventBehaviorSubject.onNext(LifecycleEvent.CREATE);
        $jacocoInit[3] = true;
        attachPresenter(getSystemNotificationShower());
        $jacocoInit[4] = true;
    }

    /* access modifiers changed from: protected */
    public SystemNotificationShower getSystemNotificationShower() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.systemNotificationShower != null) {
            $jacocoInit[5] = true;
        } else {
            $jacocoInit[6] = true;
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            NotificationIdsMapper notificationIdsMapper = new NotificationIdsMapper();
            $jacocoInit[7] = true;
            NotificationCenter notificationCenter = getNotificationCenter();
            NotificationAnalytics notificationAnalytics = getNotificationAnalytics();
            $jacocoInit[8] = true;
            CrashReport instance = CrashReport.getInstance();
            NotificationProvider notificationProvider = getNotificationProvider();
            C0136c cVar = new C0136c();
            $jacocoInit[9] = true;
            SystemNotificationShower systemNotificationShower2 = new SystemNotificationShower(this, notificationManager, notificationIdsMapper, notificationCenter, notificationAnalytics, instance, notificationProvider, this, cVar, getNavigationTracker());
            this.systemNotificationShower = systemNotificationShower2;
            $jacocoInit[10] = true;
        }
        SystemNotificationShower systemNotificationShower3 = this.systemNotificationShower;
        $jacocoInit[11] = true;
        return systemNotificationShower3;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m121b(NotificationInfo notificationInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        String action = notificationInfo.getAction();
        $jacocoInit[24] = true;
        boolean equals = action.equals(NotificationReceiver.NOTIFICATION_PRESSED_ACTION);
        $jacocoInit[25] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[26] = true;
        return valueOf;
    }

    public C0120S<NotificationInfo> getNotificationClick() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<NotificationInfo> d = getNotificationsPublishRelay().mo3653d((C0132p<? super T, Boolean>) C0040K.f37a);
        $jacocoInit[12] = true;
        return d;
    }

    /* renamed from: c */
    static /* synthetic */ Boolean m122c(NotificationInfo notificationInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        String action = notificationInfo.getAction();
        $jacocoInit[21] = true;
        boolean equals = action.equals(NotificationReceiver.NOTIFICATION_DISMISSED_ACTION);
        $jacocoInit[22] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[23] = true;
        return valueOf;
    }

    public C0120S<NotificationInfo> getNotificationDismissed() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<NotificationInfo> d = getNotificationsPublishRelay().mo3653d((C0132p<? super T, Boolean>) C0039J.f36a);
        $jacocoInit[13] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m120a(NotificationInfo notificationInfo) {
        boolean[] $jacocoInit = $jacocoInit();
        String action = notificationInfo.getAction();
        $jacocoInit[18] = true;
        boolean equals = action.equals("android.intent.action.BOOT_COMPLETED");
        $jacocoInit[19] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[20] = true;
        return valueOf;
    }

    public C0120S<NotificationInfo> getActionBootCompleted() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<NotificationInfo> d = getNotificationsPublishRelay().mo3653d((C0132p<? super T, Boolean>) C0038I.f35a);
        $jacocoInit[14] = true;
        return d;
    }

    public <T> C0096f<T> bindUntilEvent(LifecycleEvent lifecycleEvent) {
        boolean[] $jacocoInit = $jacocoInit();
        C0096f<T> a = C0097g.m559a(getLifecycleEvent(), lifecycleEvent);
        $jacocoInit[15] = true;
        return a;
    }

    public C0120S<LifecycleEvent> getLifecycleEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        C0134b<LifecycleEvent> bVar = this.lifecycleEventBehaviorSubject;
        $jacocoInit[16] = true;
        return bVar;
    }

    public void attachPresenter(Presenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        presenter.present();
        $jacocoInit[17] = true;
    }
}
