package p005cm.aptoide.p006pt.download;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.download.ApkPaths */
public class ApkPaths {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String altPath;
    private String path;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-746904049101022432L, "cm/aptoide/pt/download/ApkPaths", 3);
        $jacocoData = probes;
        return probes;
    }

    public ApkPaths(String path2, String altPath2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.path = path2;
        this.altPath = altPath2;
        $jacocoInit[0] = true;
    }

    public String getPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.path;
        $jacocoInit[1] = true;
        return str;
    }

    public String getAltPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.altPath;
        $jacocoInit[2] = true;
        return str;
    }
}
