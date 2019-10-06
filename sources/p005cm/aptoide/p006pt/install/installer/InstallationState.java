package p005cm.aptoide.p006pt.install.installer;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.install.installer.InstallationState */
public class InstallationState {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String icon;
    private final String name;
    private final String packageName;
    private final int status;
    private final int type;
    private final int versionCode;
    private final String versionName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-747051545070504291L, "cm/aptoide/pt/install/installer/InstallationState", 9);
        $jacocoData = probes;
        return probes;
    }

    public InstallationState(String packageName2, int versionCode2, int status2, int type2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.packageName = packageName2;
        this.versionCode = versionCode2;
        this.status = status2;
        this.type = type2;
        this.name = null;
        this.icon = null;
        this.versionName = "";
        $jacocoInit[0] = true;
    }

    public InstallationState(String packageName2, int versionCode2, String versionName2, int status2, int type2, String name2, String icon2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.packageName = packageName2;
        this.versionCode = versionCode2;
        this.versionName = versionName2;
        this.status = status2;
        this.type = type2;
        this.name = name2;
        this.icon = icon2;
        $jacocoInit[1] = true;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[2] = true;
        return str;
    }

    public int getVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[3] = true;
        return i;
    }

    public String getName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[4] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[5] = true;
        return str;
    }

    public int getStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.status;
        $jacocoInit[6] = true;
        return i;
    }

    public int getType() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.type;
        $jacocoInit[7] = true;
        return i;
    }

    public String getVersionName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.versionName;
        $jacocoInit[8] = true;
        return str;
    }
}
