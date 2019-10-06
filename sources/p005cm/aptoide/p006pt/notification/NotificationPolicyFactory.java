package p005cm.aptoide.p006pt.notification;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.policies.CampaignPolicy;
import p005cm.aptoide.p006pt.notification.policies.DefaultPolicy;
import p005cm.aptoide.p006pt.notification.policies.SocialPolicy;

/* renamed from: cm.aptoide.pt.notification.NotificationPolicyFactory */
public class NotificationPolicyFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private NotificationProvider notificationProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5674782241258326074L, "cm/aptoide/pt/notification/NotificationPolicyFactory", 8);
        $jacocoData = probes;
        return probes;
    }

    public NotificationPolicyFactory(NotificationProvider notificationProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.notificationProvider = notificationProvider2;
        $jacocoInit[0] = true;
    }

    /* access modifiers changed from: 0000 */
    public Policy getPolicy(AptoideNotification notification) {
        boolean[] $jacocoInit = $jacocoInit();
        switch (notification.getType()) {
            case 0:
            case 7:
                CampaignPolicy campaignPolicy = new CampaignPolicy();
                $jacocoInit[1] = true;
                return campaignPolicy;
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                NotificationProvider notificationProvider2 = this.notificationProvider;
                $jacocoInit[2] = true;
                $jacocoInit[3] = true;
                SocialPolicy socialPolicy = new SocialPolicy(notificationProvider2, new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(4)});
                $jacocoInit[4] = true;
                return socialPolicy;
            case 3:
                NotificationProvider notificationProvider3 = this.notificationProvider;
                $jacocoInit[5] = true;
                SocialPolicy socialPolicy2 = new SocialPolicy(notificationProvider3, new Integer[]{Integer.valueOf(3)});
                $jacocoInit[6] = true;
                return socialPolicy2;
            default:
                DefaultPolicy defaultPolicy = new DefaultPolicy();
                $jacocoInit[7] = true;
                return defaultPolicy;
        }
    }
}
