package p005cm.aptoide.p006pt.notification.sync;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.NotificationProvider;
import p005cm.aptoide.p006pt.notification.NotificationService;
import p005cm.aptoide.p006pt.sync.Sync;
import p026rx.C0117M;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.notification.sync.CampaignNotificationSync */
public class CampaignNotificationSync extends Sync {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final NotificationService networkService;
    private final NotificationProvider provider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4680705990371724336L, "cm/aptoide/pt/notification/sync/CampaignNotificationSync", 4);
        $jacocoData = probes;
        return probes;
    }

    public CampaignNotificationSync(String id, NotificationService networkService2, NotificationProvider provider2, boolean periodic, boolean exact, long interval, long trigger) {
        boolean[] $jacocoInit = $jacocoInit();
        super(id, periodic, exact, trigger, interval);
        this.networkService = networkService2;
        this.provider = provider2;
        $jacocoInit[0] = true;
    }

    public C0117M execute() {
        boolean[] $jacocoInit = $jacocoInit();
        Single campaignNotifications = this.networkService.getCampaignNotifications();
        C4226a aVar = new C4226a(this);
        $jacocoInit[1] = true;
        C0117M b = campaignNotifications.mo3693b((C0132p<? super T, ? extends C0117M>) aVar);
        $jacocoInit[2] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo15316a(List aptoideNotification) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M save = this.provider.save(aptoideNotification);
        $jacocoInit[3] = true;
        return save;
    }
}
