package p005cm.aptoide.p006pt.download;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.download.DownloadApkPathsProvider */
public class DownloadApkPathsProvider {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String DOWNGRADE_ACTION = "?action=downgrade";
    private static final String INSTALL_ACTION = "?action=install";
    private static final String OEMID_QUERY = "&oemid=";
    private static final String UPDATE_ACTION = "?action=update";
    private final OemidProvider oemidProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8480661079411517489L, "cm/aptoide/pt/download/DownloadApkPathsProvider", 12);
        $jacocoData = probes;
        return probes;
    }

    public DownloadApkPathsProvider(OemidProvider oemidProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.oemidProvider = oemidProvider2;
        $jacocoInit[0] = true;
    }

    public ApkPaths getDownloadPaths(int downloadAction, String path, String altPath) {
        boolean[] $jacocoInit = $jacocoInit();
        String oemid = getOemidQueryString();
        if (downloadAction == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(path);
            String str = INSTALL_ACTION;
            sb.append(str);
            sb.append(oemid);
            path = sb.toString();
            $jacocoInit[2] = true;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(altPath);
            sb2.append(str);
            sb2.append(oemid);
            altPath = sb2.toString();
            $jacocoInit[3] = true;
        } else if (downloadAction == 1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(path);
            String str2 = UPDATE_ACTION;
            sb3.append(str2);
            sb3.append(oemid);
            path = sb3.toString();
            $jacocoInit[6] = true;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(altPath);
            sb4.append(str2);
            sb4.append(oemid);
            altPath = sb4.toString();
            $jacocoInit[7] = true;
        } else if (downloadAction != 2) {
            $jacocoInit[1] = true;
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(path);
            String str3 = DOWNGRADE_ACTION;
            sb5.append(str3);
            sb5.append(oemid);
            path = sb5.toString();
            $jacocoInit[4] = true;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(altPath);
            sb6.append(str3);
            sb6.append(oemid);
            altPath = sb6.toString();
            $jacocoInit[5] = true;
        }
        ApkPaths apkPaths = new ApkPaths(path, altPath);
        $jacocoInit[8] = true;
        return apkPaths;
    }

    private String getOemidQueryString() {
        boolean[] $jacocoInit = $jacocoInit();
        String oemid = this.oemidProvider.getOemid();
        $jacocoInit[9] = true;
        if (oemid.isEmpty()) {
            $jacocoInit[10] = true;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(OEMID_QUERY);
        sb.append(oemid);
        String sb2 = sb.toString();
        $jacocoInit[11] = true;
        return sb2;
    }
}
