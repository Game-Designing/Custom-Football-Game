package p005cm.aptoide.p006pt.notification.policies;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.Policy;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.notification.policies.CampaignPolicy */
public class CampaignPolicy implements Policy {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(93726343412811303L, "cm/aptoide/pt/notification/policies/CampaignPolicy", 2);
        $jacocoData = probes;
        return probes;
    }

    public CampaignPolicy() {
        $jacocoInit()[0] = true;
    }

    public Single<Boolean> shouldShow() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> a = Single.m734a(Boolean.valueOf(true));
        $jacocoInit[1] = true;
        return a;
    }
}
