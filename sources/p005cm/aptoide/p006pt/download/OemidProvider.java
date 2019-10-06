package p005cm.aptoide.p006pt.download;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.download.OemidProvider */
public class OemidProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(9067985656414574007L, "cm/aptoide/pt/download/OemidProvider", 2);
        $jacocoData = probes;
        return probes;
    }

    public OemidProvider() {
        $jacocoInit()[0] = true;
    }

    public String getOemid() {
        $jacocoInit()[1] = true;
        return "";
    }
}
