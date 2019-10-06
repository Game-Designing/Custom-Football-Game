package p005cm.aptoide.p006pt.home.apps;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.apps.App.Type;

/* renamed from: cm.aptoide.pt.home.apps.InstalledApp */
public class InstalledApp implements App {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String appName;
    private String icon;
    private String packageName;
    private String version;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8273158295502351254L, "cm/aptoide/pt/home/apps/InstalledApp", 6);
        $jacocoData = probes;
        return probes;
    }

    public InstalledApp(String appName2, String packageName2, String version2, String icon2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appName = appName2;
        this.packageName = packageName2;
        this.version = version2;
        this.icon = icon2;
        $jacocoInit[0] = true;
    }

    public String getAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[1] = true;
        return str;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[2] = true;
        return str;
    }

    public String getVersion() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.version;
        $jacocoInit[3] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[4] = true;
        return str;
    }

    public Type getType() {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = Type.INSTALLED;
        $jacocoInit[5] = true;
        return type;
    }
}
