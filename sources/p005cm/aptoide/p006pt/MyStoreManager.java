package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.MyStoreManager */
public class MyStoreManager {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4675091109079659734L, "cm/aptoide/pt/MyStoreManager", 2);
        $jacocoData = probes;
        return probes;
    }

    public MyStoreManager() {
        $jacocoInit()[0] = true;
    }

    public static boolean shouldShowCreateStore() {
        $jacocoInit()[1] = true;
        return true;
    }
}
