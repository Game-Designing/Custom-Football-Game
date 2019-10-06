package p005cm.aptoide.p006pt.promotions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;

/* renamed from: cm.aptoide.pt.promotions.PromotionApp */
public class PromotionApp {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String alternativePath;
    private final String appIcon;
    private final long appId;
    private final float appcValue;
    private final String description;
    private final String downloadPath;
    private final boolean hasAppc;
    private final boolean isClaimed;
    private final String md5;
    private final String name;
    private final int numberOfDownloads;
    private final Obb obb;
    private final String packageName;
    private final float rating;
    private final String signature;
    private final long size;
    private final int versionCode;
    private final String versionName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2260808565033883400L, "cm/aptoide/pt/promotions/PromotionApp", 19);
        $jacocoData = probes;
        return probes;
    }

    public PromotionApp(String name2, String packageName2, long appId2, String downloadPath2, String alternativePath2, String appIcon2, String description2, long size2, float rating2, int numberOfDownloads2, String md52, int versionCode2, boolean isClaimed2, String versionName2, Obb obb2, float appcValue2, String signature2, boolean hasAppc2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.name = name2;
        this.packageName = packageName2;
        this.appId = appId2;
        this.downloadPath = downloadPath2;
        this.alternativePath = alternativePath2;
        this.appIcon = appIcon2;
        this.description = description2;
        this.size = size2;
        this.rating = rating2;
        this.numberOfDownloads = numberOfDownloads2;
        this.md5 = md52;
        this.versionCode = versionCode2;
        this.isClaimed = isClaimed2;
        this.versionName = versionName2;
        this.obb = obb2;
        this.appcValue = appcValue2;
        this.signature = signature2;
        this.hasAppc = hasAppc2;
        $jacocoInit[0] = true;
    }

    public String getName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[1] = true;
        return str;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[2] = true;
        return str;
    }

    public long getAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.appId;
        $jacocoInit[3] = true;
        return j;
    }

    public String getDownloadPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.downloadPath;
        $jacocoInit[4] = true;
        return str;
    }

    public String getAlternativePath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.alternativePath;
        $jacocoInit[5] = true;
        return str;
    }

    public String getAppIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appIcon;
        $jacocoInit[6] = true;
        return str;
    }

    public String getDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.description;
        $jacocoInit[7] = true;
        return str;
    }

    public long getSize() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.size;
        $jacocoInit[8] = true;
        return j;
    }

    public float getRating() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.rating;
        $jacocoInit[9] = true;
        return f;
    }

    public int getNumberOfDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.numberOfDownloads;
        $jacocoInit[10] = true;
        return i;
    }

    public String getMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        $jacocoInit[11] = true;
        return str;
    }

    public int getVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[12] = true;
        return i;
    }

    public boolean isClaimed() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isClaimed;
        $jacocoInit[13] = true;
        return z;
    }

    public Obb getObb() {
        boolean[] $jacocoInit = $jacocoInit();
        Obb obb2 = this.obb;
        $jacocoInit[14] = true;
        return obb2;
    }

    public String getVersionName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.versionName;
        $jacocoInit[15] = true;
        return str;
    }

    public float getAppcValue() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.appcValue;
        $jacocoInit[16] = true;
        return f;
    }

    public String getSignature() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.signature;
        $jacocoInit[17] = true;
        return str;
    }

    public boolean hasAppc() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasAppc;
        $jacocoInit[18] = true;
        return z;
    }
}
