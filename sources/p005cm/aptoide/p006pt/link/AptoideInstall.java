package p005cm.aptoide.p006pt.link;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.link.AptoideInstall */
public class AptoideInstall {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final long appId;
    private final String packageName;
    private final boolean showPopup;
    private final String storeName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4123923589279045330L, "cm/aptoide/pt/link/AptoideInstall", 6);
        $jacocoData = probes;
        return probes;
    }

    public AptoideInstall(long appId2, String packageName2, boolean showPopup2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appId = appId2;
        this.packageName = packageName2;
        this.showPopup = showPopup2;
        this.storeName = null;
        $jacocoInit[0] = true;
    }

    public AptoideInstall(String storeName2, String packageName2, boolean showPopup2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeName = storeName2;
        this.packageName = packageName2;
        this.showPopup = showPopup2;
        this.appId = -1;
        $jacocoInit[1] = true;
    }

    public String getStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        $jacocoInit[2] = true;
        return str;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[3] = true;
        return str;
    }

    public boolean shouldShowPopup() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.showPopup;
        $jacocoInit[4] = true;
        return z;
    }

    public long getAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.appId;
        $jacocoInit[5] = true;
        return j;
    }
}
