package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.MyAccountManager */
public class MyAccountManager {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4407489876103866362L, "cm/aptoide/pt/MyAccountManager", 2);
        $jacocoData = probes;
        return probes;
    }

    public MyAccountManager() {
        $jacocoInit()[0] = true;
    }

    public boolean shouldShowCreateStore() {
        $jacocoInit()[1] = true;
        return true;
    }
}
