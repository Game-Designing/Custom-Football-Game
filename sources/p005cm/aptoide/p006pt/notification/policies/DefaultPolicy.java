package p005cm.aptoide.p006pt.notification.policies;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.notification.Policy;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.notification.policies.DefaultPolicy */
public class DefaultPolicy implements Policy {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8183394851814304385L, "cm/aptoide/pt/notification/policies/DefaultPolicy", 2);
        $jacocoData = probes;
        return probes;
    }

    public DefaultPolicy() {
        $jacocoInit()[0] = true;
    }

    public Single<Boolean> shouldShow() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Boolean> a = Single.m734a(Boolean.valueOf(false));
        $jacocoInit[1] = true;
        return a;
    }
}
