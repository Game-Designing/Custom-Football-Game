package p005cm.aptoide.p006pt.install.installer;

import android.content.Context;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.install.Install;
import p005cm.aptoide.p006pt.install.InstallManager;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.notification.SystemNotificationShower;
import p019d.p022i.p023b.C0100e;
import p026rx.C0120S;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p387a.p389b.C14522a;

/* renamed from: cm.aptoide.pt.install.installer.RootInstallationRetryHandler */
public class RootInstallationRetryHandler {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = RootInstallationRetryHandler.class.getSimpleName();
    private Context context;
    private int count;
    private final C0100e<List<Install>> handler;
    private final InstallManager installManager;
    private final int notificationId;
    private RootInstallErrorNotificationFactory rootInstallErrorNotificationFactory;
    private C0137ja subscription;
    private final SystemNotificationShower systemNotificationShower;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6701041534531668287L, "cm/aptoide/pt/install/installer/RootInstallationRetryHandler", 30);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[29] = true;
    }

    public RootInstallationRetryHandler(int notificationId2, SystemNotificationShower systemNotificationShower2, InstallManager installManager2, C0100e<List<Install>> handler2, int initialCount, Context context2, RootInstallErrorNotificationFactory rootInstallErrorNotificationFactory2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationId = notificationId2;
        this.systemNotificationShower = systemNotificationShower2;
        this.installManager = installManager2;
        this.handler = handler2;
        this.count = initialCount;
        this.context = context2;
        this.rootInstallErrorNotificationFactory = rootInstallErrorNotificationFactory2;
        $jacocoInit[0] = true;
    }

    public void start() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S timedOutInstallations = this.installManager.getTimedOutInstallations();
        $jacocoInit[1] = true;
        C0120S a = timedOutInstallations.mo3616a(C14522a.m46170a());
        C4062H h = new C4062H(this);
        $jacocoInit[2] = true;
        C0120S b = a.mo3636b((C0129b<? super T>) h);
        C4060F f = C4060F.f7566a;
        C4063I i = C4063I.f7569a;
        $jacocoInit[3] = true;
        this.subscription = b.mo3626a((C0129b<? super T>) f, (C0129b<Throwable>) i);
        $jacocoInit[4] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2127a(List installationProgresses) {
        boolean[] $jacocoInit = $jacocoInit();
        if (installationProgresses.isEmpty()) {
            $jacocoInit[25] = true;
            dismissNotifications();
            $jacocoInit[26] = true;
        } else {
            showNotification(installationProgresses);
            $jacocoInit[27] = true;
        }
        $jacocoInit[28] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m380a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("start: ");
        sb.append(throwable);
        String sb2 = sb.toString();
        $jacocoInit[22] = true;
        instance.mo2140e(str, sb2);
        $jacocoInit[23] = true;
    }

    /* renamed from: b */
    static /* synthetic */ void m381b(List rootInstallErrorNotification) {
        $jacocoInit()[24] = true;
    }

    private void showNotification(List<Install> installs) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.count == 0) {
            $jacocoInit[5] = true;
            showSystemNotification(installs);
            $jacocoInit[6] = true;
        } else {
            this.handler.call(installs);
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
    }

    private void showSystemNotification(List<Install> installs) {
        boolean[] $jacocoInit = $jacocoInit();
        SystemNotificationShower systemNotificationShower2 = this.systemNotificationShower;
        Context context2 = this.context;
        RootInstallErrorNotificationFactory rootInstallErrorNotificationFactory2 = this.rootInstallErrorNotificationFactory;
        $jacocoInit[9] = true;
        RootInstallErrorNotification create = rootInstallErrorNotificationFactory2.create(context2, installs);
        $jacocoInit[10] = true;
        systemNotificationShower2.showNotification(context2, create);
        $jacocoInit[11] = true;
    }

    private void dismissNotifications() {
        boolean[] $jacocoInit = $jacocoInit();
        this.systemNotificationShower.dismissNotification(this.notificationId);
        $jacocoInit[12] = true;
        this.handler.call(Collections.emptyList());
        $jacocoInit[13] = true;
    }

    public void stop() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.subscription.isUnsubscribed()) {
            $jacocoInit[14] = true;
        } else {
            $jacocoInit[15] = true;
            this.subscription.unsubscribe();
            $jacocoInit[16] = true;
        }
        $jacocoInit[17] = true;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2126a() {
        boolean[] $jacocoInit = $jacocoInit();
        this.count++;
        $jacocoInit[21] = true;
    }

    public C0120S<List<Install>> retries() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S b = this.handler.mo3635b((C0128a) new C4061G(this));
        C4059E e = new C4059E(this);
        $jacocoInit[18] = true;
        C0120S<List<Install>> d = b.mo3652d((C0128a) e);
        $jacocoInit[19] = true;
        return d;
    }

    /* renamed from: b */
    public /* synthetic */ void mo2128b() {
        boolean[] $jacocoInit = $jacocoInit();
        this.count--;
        $jacocoInit[20] = true;
    }
}
