package p005cm.aptoide.p006pt.home;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.view.app.Application;

/* renamed from: cm.aptoide.pt.home.RewardApp */
public class RewardApp extends Application {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String clickUrl;
    private String downloadUrl;
    private float reward;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(110956559965745731L, "cm/aptoide/pt/home/RewardApp", 4);
        $jacocoData = probes;
        return probes;
    }

    public RewardApp(String appName, String appIcon, float ratingAverage, int downloadsNumber, String packageName, long appId, String tag, boolean hasBilling, String clickUrl2, String downloadUrl2, float reward2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(appName, appIcon, ratingAverage, downloadsNumber, packageName, appId, tag, hasBilling);
        this.clickUrl = clickUrl2;
        this.downloadUrl = downloadUrl2;
        this.reward = reward2;
        $jacocoInit[0] = true;
    }

    public String getClickUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.clickUrl;
        $jacocoInit[1] = true;
        return str;
    }

    public String getDownloadUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.downloadUrl;
        $jacocoInit[2] = true;
        return str;
    }

    public float getReward() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.reward;
        $jacocoInit[3] = true;
        return f;
    }
}
