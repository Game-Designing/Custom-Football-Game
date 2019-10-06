package p005cm.aptoide.p006pt.home.apps;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.apps.App.Type;
import p005cm.aptoide.p006pt.home.apps.StateApp.Status;

/* renamed from: cm.aptoide.pt.home.apps.DownloadApp */
public class DownloadApp implements StateApp {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String appName;
    private Status downloadStatus;
    private String icon;
    private boolean isIndeterminate;
    private String md5;
    private String packageName;
    private int progress;
    private int versionCode;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5412784857731432700L, "cm/aptoide/pt/home/apps/DownloadApp", 20);
        $jacocoData = probes;
        return probes;
    }

    public DownloadApp(String appName2, String md52, String packageName2, String icon2, int progress2, boolean isIndeterminate2, int versionCode2, Status downloadStatus2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appName = appName2;
        this.md5 = md52;
        this.packageName = packageName2;
        this.icon = icon2;
        this.progress = progress2;
        this.isIndeterminate = isIndeterminate2;
        this.versionCode = versionCode2;
        this.downloadStatus = downloadStatus2;
        $jacocoInit[0] = true;
    }

    public String getName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[1] = true;
        return str;
    }

    public String getMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        $jacocoInit[2] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[3] = true;
        return str;
    }

    public boolean isIndeterminate() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isIndeterminate;
        $jacocoInit[4] = true;
        return z;
    }

    public void setIndeterminate(boolean indeterminate) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isIndeterminate = indeterminate;
        $jacocoInit[5] = true;
    }

    public Status getStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        Status status = this.downloadStatus;
        $jacocoInit[6] = true;
        return status;
    }

    public void setStatus(Status status) {
        boolean[] $jacocoInit = $jacocoInit();
        this.downloadStatus = status;
        $jacocoInit[7] = true;
    }

    public int getProgress() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.progress;
        $jacocoInit[8] = true;
        return i;
    }

    public int getVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[9] = true;
        return i;
    }

    public Type getType() {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = Type.DOWNLOAD;
        $jacocoInit[10] = true;
        return type;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[11] = true;
        return str;
    }

    public boolean equals(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        if (!(obj instanceof DownloadApp)) {
            $jacocoInit[12] = true;
            return false;
        }
        DownloadApp other = (DownloadApp) obj;
        $jacocoInit[13] = true;
        if (!this.md5.equals(other.getMd5())) {
            $jacocoInit[14] = true;
        } else if (!getType().equals(other.getType())) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            z = true;
            $jacocoInit[18] = true;
            return z;
        }
        $jacocoInit[17] = true;
        $jacocoInit[18] = true;
        return z;
    }

    public String toString() {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadApp{appName='");
        sb.append(this.appName);
        sb.append('\'');
        sb.append(", md5='");
        sb.append(this.md5);
        sb.append('\'');
        sb.append(", packageName='");
        sb.append(this.packageName);
        sb.append('\'');
        sb.append(", icon='");
        sb.append(this.icon);
        sb.append('\'');
        sb.append(", progress=");
        sb.append(this.progress);
        sb.append(", isIndeterminate=");
        sb.append(this.isIndeterminate);
        sb.append(", versionCode=");
        sb.append(this.versionCode);
        sb.append(", downloadStatus=");
        sb.append(this.downloadStatus);
        sb.append('}');
        String sb2 = sb.toString();
        $jacocoInit[19] = true;
        return sb2;
    }
}
