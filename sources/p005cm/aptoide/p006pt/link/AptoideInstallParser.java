package p005cm.aptoide.p006pt.link;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.downloadmanager.Constants;

/* renamed from: cm.aptoide.pt.link.AptoideInstallParser */
public class AptoideInstallParser {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4832462032898140729L, "cm/aptoide/pt/link/AptoideInstallParser", 21);
        $jacocoData = probes;
        return probes;
    }

    public AptoideInstallParser() {
        $jacocoInit()[0] = true;
    }

    public AptoideInstall parse(String substring) {
        boolean[] $jacocoInit = $jacocoInit();
        String substring2 = substring.replace("\"", "");
        $jacocoInit[1] = true;
        String[] split = substring2.split("&");
        int length = split.length;
        $jacocoInit[2] = true;
        boolean showPopup = false;
        String packageName = null;
        String repo = null;
        int i = 0;
        while (i < length) {
            String property = split[i];
            $jacocoInit[3] = true;
            String lowerCase = property.toLowerCase();
            $jacocoInit[4] = true;
            String str = "=";
            if (lowerCase.contains(Constants.PACKAGE)) {
                $jacocoInit[5] = true;
                packageName = property.split(str)[1];
                $jacocoInit[6] = true;
            } else {
                String lowerCase2 = property.toLowerCase();
                $jacocoInit[7] = true;
                if (lowerCase2.contains("store")) {
                    $jacocoInit[8] = true;
                    repo = property.split(str)[1];
                    $jacocoInit[9] = true;
                } else {
                    String lowerCase3 = property.toLowerCase();
                    $jacocoInit[10] = true;
                    if (!lowerCase3.contains("show_install_popup")) {
                        $jacocoInit[11] = true;
                        try {
                            long id = Long.parseLong(split[0]);
                            $jacocoInit[14] = true;
                            AptoideInstall aptoideInstall = new AptoideInstall(id, packageName, false);
                            $jacocoInit[15] = true;
                            return aptoideInstall;
                        } catch (NumberFormatException e) {
                            $jacocoInit[16] = true;
                            CrashReport instance = CrashReport.getInstance();
                            $jacocoInit[17] = true;
                            instance.log(e);
                            $jacocoInit[18] = true;
                        }
                    } else {
                        $jacocoInit[12] = true;
                        showPopup = property.split(str)[1].equals("true");
                        $jacocoInit[13] = true;
                    }
                }
            }
            i++;
            $jacocoInit[19] = true;
        }
        AptoideInstall aptoideInstall2 = new AptoideInstall(repo, packageName, showPopup);
        $jacocoInit[20] = true;
        return aptoideInstall2;
    }
}
