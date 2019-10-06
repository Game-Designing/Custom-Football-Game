package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.SettingsManager */
public class SettingsManager {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8374696393267707348L, "cm/aptoide/pt/SettingsManager", 3);
        $jacocoData = probes;
        return probes;
    }

    public SettingsManager() {
        $jacocoInit()[0] = true;
    }

    public boolean showAdultContent() {
        $jacocoInit()[1] = true;
        return true;
    }

    public boolean showGDPR() {
        $jacocoInit()[2] = true;
        return true;
    }
}
