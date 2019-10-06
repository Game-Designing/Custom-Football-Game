package p005cm.aptoide.p006pt.home.apps;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.Installed;

/* renamed from: cm.aptoide.pt.home.apps.InstalledToInstalledAppMapper */
class InstalledToInstalledAppMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-734912625493535166L, "cm/aptoide/pt/home/apps/InstalledToInstalledAppMapper", 9);
        $jacocoData = probes;
        return probes;
    }

    InstalledToInstalledAppMapper() {
        $jacocoInit()[0] = true;
    }

    public List<App> getInstalledApps(List<Installed> installeds) {
        boolean[] $jacocoInit = $jacocoInit();
        List<App> installedAppsList = new ArrayList<>();
        $jacocoInit[1] = true;
        int i = 0;
        $jacocoInit[2] = true;
        while (i < installeds.size()) {
            $jacocoInit[3] = true;
            Installed installed = (Installed) installeds.get(i);
            $jacocoInit[4] = true;
            String name = installed.getName();
            String packageName = installed.getPackageName();
            $jacocoInit[5] = true;
            InstalledApp installedApp = new InstalledApp(name, packageName, installed.getVersionName(), installed.getIcon());
            $jacocoInit[6] = true;
            installedAppsList.add(installedApp);
            i++;
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
        return installedAppsList;
    }
}
