package p005cm.aptoide.p006pt.home.apps;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.apps.App.Type;
import p005cm.aptoide.p006pt.home.apps.StateApp.Status;

/* renamed from: cm.aptoide.pt.home.apps.UpdateApp */
public class UpdateApp implements StateApp {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private long appId;
    private String icon;
    private boolean isIndeterminate;
    private String md5;
    private String name;
    private String packageName;
    private int progress;
    private Status updateStatus;
    private String version;
    private int versionCode;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2683353382930456085L, "cm/aptoide/pt/home/apps/UpdateApp", 22);
        $jacocoData = probes;
        return probes;
    }

    public UpdateApp(String name2, String md52, String icon2, String packageName2, int progress2, boolean isIndeterminate2, String version2, int versionCode2, Status updateStatus2, long appId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.name = name2;
        this.md5 = md52;
        this.icon = icon2;
        this.packageName = packageName2;
        this.progress = progress2;
        this.isIndeterminate = isIndeterminate2;
        this.version = version2;
        this.versionCode = versionCode2;
        this.updateStatus = updateStatus2;
        this.appId = appId2;
        $jacocoInit[0] = true;
    }

    public Type getType() {
        boolean[] $jacocoInit = $jacocoInit();
        Type type = Type.UPDATE;
        $jacocoInit[1] = true;
        return type;
    }

    public String getName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[2] = true;
        return str;
    }

    public String getMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        $jacocoInit[3] = true;
        return str;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[4] = true;
        return str;
    }

    public String getVersion() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.version;
        $jacocoInit[5] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[6] = true;
        return str;
    }

    public boolean isIndeterminate() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isIndeterminate;
        $jacocoInit[7] = true;
        return z;
    }

    public void setIndeterminate(boolean isIndeterminate2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isIndeterminate = isIndeterminate2;
        $jacocoInit[8] = true;
    }

    public Status getStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        Status status = this.updateStatus;
        $jacocoInit[9] = true;
        return status;
    }

    public void setStatus(Status status) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updateStatus = status;
        $jacocoInit[10] = true;
    }

    public int getProgress() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.progress;
        $jacocoInit[11] = true;
        return i;
    }

    public boolean equals(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = false;
        if (!(obj instanceof UpdateApp)) {
            $jacocoInit[12] = true;
            return false;
        }
        UpdateApp other = (UpdateApp) obj;
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
        sb.append("UpdateApp{name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", md5='");
        sb.append(this.md5);
        sb.append('\'');
        sb.append(", icon='");
        sb.append(this.icon);
        sb.append('\'');
        sb.append(", packageName='");
        sb.append(this.packageName);
        sb.append('\'');
        sb.append(", progress=");
        sb.append(this.progress);
        sb.append(", isIndeterminate=");
        sb.append(this.isIndeterminate);
        sb.append(", version='");
        sb.append(this.version);
        sb.append('\'');
        sb.append(", versionCode=");
        sb.append(this.versionCode);
        sb.append(", updateStatus=");
        sb.append(this.updateStatus);
        sb.append(", appId=");
        sb.append(this.appId);
        sb.append('}');
        String sb2 = sb.toString();
        $jacocoInit[19] = true;
        return sb2;
    }

    public int getVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[20] = true;
        return i;
    }

    public long getAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.appId;
        $jacocoInit[21] = true;
        return j;
    }
}
