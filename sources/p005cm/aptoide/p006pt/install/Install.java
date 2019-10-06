package p005cm.aptoide.p006pt.install;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.install.Install */
public class Install {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String appName;
    private final String icon;
    private final boolean isIndeterminate;
    private final String md5;
    private final String packageName;
    private final int progress;
    private final int speed;
    private final InstallationStatus state;
    private final InstallationType type;
    private final int versionCode;
    private final String versionName;

    /* renamed from: cm.aptoide.pt.install.Install$InstallationStatus */
    public enum InstallationStatus {
        DOWNLOADING,
        PAUSED,
        INSTALLED,
        UNINSTALLED,
        INSTALLATION_TIMEOUT,
        GENERIC_ERROR,
        NOT_ENOUGH_SPACE_ERROR,
        INITIAL_STATE,
        IN_QUEUE,
        INSTALLING;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    /* renamed from: cm.aptoide.pt.install.Install$InstallationType */
    public enum InstallationType {
        INSTALLED,
        INSTALL,
        UPDATE,
        DOWNGRADE;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1847717521681415925L, "cm/aptoide/pt/install/Install", 40);
        $jacocoData = probes;
        return probes;
    }

    public Install(int progress2, InstallationStatus state2, InstallationType type2, boolean isIndeterminate2, int speed2, String md52, String packageName2, int versionCode2, String versionName2, String appName2, String icon2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.progress = progress2;
        this.state = state2;
        this.type = type2;
        this.isIndeterminate = isIndeterminate2;
        this.speed = speed2;
        this.md5 = md52;
        this.packageName = packageName2;
        this.versionCode = versionCode2;
        this.versionName = versionName2;
        this.appName = appName2;
        this.icon = icon2;
        $jacocoInit[0] = true;
    }

    public InstallationType getType() {
        boolean[] $jacocoInit = $jacocoInit();
        InstallationType installationType = this.type;
        $jacocoInit[1] = true;
        return installationType;
    }

    public int getProgress() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.progress;
        $jacocoInit[2] = true;
        return i;
    }

    public InstallationStatus getState() {
        boolean[] $jacocoInit = $jacocoInit();
        InstallationStatus installationStatus = this.state;
        $jacocoInit[3] = true;
        return installationStatus;
    }

    public boolean isIndeterminate() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isIndeterminate;
        $jacocoInit[4] = true;
        return z;
    }

    public int getSpeed() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.speed;
        $jacocoInit[5] = true;
        return i;
    }

    public String getMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        $jacocoInit[6] = true;
        return str;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[7] = true;
        return str;
    }

    public int getVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[8] = true;
        return i;
    }

    public String getAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[9] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[10] = true;
        return str;
    }

    public int hashCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int result = this.state.hashCode();
        $jacocoInit[11] = true;
        int result2 = (result * 31) + this.md5.hashCode();
        $jacocoInit[12] = true;
        int result3 = (result2 * 31) + this.packageName.hashCode();
        $jacocoInit[13] = true;
        int result4 = (((result3 * 31) + this.versionName.hashCode()) * 31) + this.versionCode;
        $jacocoInit[14] = true;
        return result4;
    }

    public boolean equals(Object o) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this == o) {
            $jacocoInit[15] = true;
            return true;
        }
        if (o == null) {
            $jacocoInit[16] = true;
        } else if (getClass() != o.getClass()) {
            $jacocoInit[17] = true;
        } else {
            Install that = (Install) o;
            $jacocoInit[19] = true;
            if (!this.versionName.equals(that.versionName)) {
                $jacocoInit[20] = true;
                return false;
            } else if (this.versionCode != that.versionCode) {
                $jacocoInit[21] = true;
                return false;
            } else if (this.state != that.state) {
                $jacocoInit[22] = true;
                return false;
            } else if (!this.md5.equals(that.md5)) {
                $jacocoInit[23] = true;
                return false;
            } else if (this.progress != that.progress) {
                $jacocoInit[24] = true;
                return false;
            } else {
                boolean equals = this.packageName.equals(that.packageName);
                $jacocoInit[25] = true;
                return equals;
            }
        }
        $jacocoInit[18] = true;
        return false;
    }

    public String toString() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("Install{state=");
        sb.append(this.state);
        sb.append(", isIndeterminate=");
        sb.append(this.isIndeterminate);
        sb.append('}');
        String sb2 = sb.toString();
        $jacocoInit[26] = true;
        return sb2;
    }

    public boolean isFailed() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        InstallationStatus installationStatus = this.state;
        if (installationStatus == InstallationStatus.GENERIC_ERROR) {
            $jacocoInit[27] = true;
        } else if (installationStatus == InstallationStatus.INSTALLATION_TIMEOUT) {
            $jacocoInit[28] = true;
        } else if (installationStatus == InstallationStatus.NOT_ENOUGH_SPACE_ERROR) {
            $jacocoInit[29] = true;
        } else {
            z = false;
            $jacocoInit[31] = true;
            $jacocoInit[32] = true;
            return z;
        }
        $jacocoInit[30] = true;
        z = true;
        $jacocoInit[32] = true;
        return z;
    }

    public boolean hasDownloadStarted() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        InstallationStatus installationStatus = this.state;
        if (installationStatus == InstallationStatus.IN_QUEUE) {
            $jacocoInit[33] = true;
        } else if (installationStatus == InstallationStatus.INITIAL_STATE) {
            $jacocoInit[34] = true;
        } else if (installationStatus == InstallationStatus.PAUSED) {
            $jacocoInit[35] = true;
        } else {
            $jacocoInit[36] = true;
            z = true;
            $jacocoInit[38] = true;
            return z;
        }
        z = false;
        $jacocoInit[37] = true;
        $jacocoInit[38] = true;
        return z;
    }

    public String getVersionName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.versionName;
        $jacocoInit[39] = true;
        return str;
    }
}
