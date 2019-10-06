package p005cm.aptoide.p006pt.search.model;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.data.AptoideNativeAd;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;

/* renamed from: cm.aptoide.pt.search.model.SearchAdResult */
public class SearchAdResult {
    private static transient /* synthetic */ boolean[] $jacocoData;
    long adId;
    long appId;
    String appName;
    String clickPerDownloadUrl;
    String clickPerInstallUrl;
    String clickUrl;
    String cpcUrl;
    String icon;
    long modifiedDate;
    long networkId;
    String packageName;
    float starRating;
    long totalDownloads;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3330684422164279055L, "cm/aptoide/pt/search/model/SearchAdResult", 25);
        $jacocoData = probes;
        return probes;
    }

    public SearchAdResult() {
        $jacocoInit()[0] = true;
    }

    public SearchAdResult(long adId2, String icon2, long totalDownloads2, float starRating2, long modifiedDate2, String packageName2, String cpcUrl2, String clickPerDownloadUrl2, String clickPerInstallUrl2, String clickUrl2, String appName2, long appId2, long networkId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adId = adId2;
        this.icon = icon2;
        this.totalDownloads = totalDownloads2;
        this.starRating = starRating2;
        this.modifiedDate = modifiedDate2;
        this.packageName = packageName2;
        this.cpcUrl = cpcUrl2;
        this.clickPerDownloadUrl = clickPerDownloadUrl2;
        this.clickPerInstallUrl = clickPerInstallUrl2;
        this.clickUrl = clickUrl2;
        this.appName = appName2;
        this.appId = appId2;
        this.networkId = networkId2;
        $jacocoInit[1] = true;
    }

    public SearchAdResult(MinimalAd minimalAd) {
        boolean[] $jacocoInit = $jacocoInit();
        long longValue = minimalAd.getAdId().longValue();
        String iconPath = minimalAd.getIconPath();
        long intValue = (long) minimalAd.getDownloads().intValue();
        $jacocoInit[2] = true;
        float intValue2 = (float) minimalAd.getStars().intValue();
        long longValue2 = minimalAd.getModified().longValue();
        String packageName2 = minimalAd.getPackageName();
        $jacocoInit[3] = true;
        String cpcUrl2 = minimalAd.getCpcUrl();
        String cpdUrl = minimalAd.getCpdUrl();
        String cpiUrl = minimalAd.getCpiUrl();
        $jacocoInit[4] = true;
        String clickUrl2 = minimalAd.getClickUrl();
        String name = minimalAd.getName();
        long longValue3 = minimalAd.getAppId().longValue();
        $jacocoInit[5] = true;
        long longValue4 = minimalAd.getNetworkId().longValue();
        $jacocoInit[6] = true;
        this(longValue, iconPath, intValue, intValue2, longValue2, packageName2, cpcUrl2, cpdUrl, cpiUrl, clickUrl2, name, longValue3, longValue4);
        $jacocoInit[7] = true;
    }

    public SearchAdResult(AptoideNativeAd ad) {
        boolean[] $jacocoInit = $jacocoInit();
        long longValue = ad.getAdId().longValue();
        String iconUrl = ad.getIconUrl();
        long intValue = (long) ad.getDownloads().intValue();
        float intValue2 = (float) ad.getStars().intValue();
        long longValue2 = ad.getModified().longValue();
        $jacocoInit[8] = true;
        String packageName2 = ad.getPackageName();
        String cpcUrl2 = ad.getCpcUrl();
        String cpdUrl = ad.getCpdUrl();
        String cpiUrl = ad.getCpiUrl();
        String clickUrl2 = ad.getClickUrl();
        $jacocoInit[9] = true;
        String adTitle = ad.getAdTitle();
        long longValue3 = ad.getAppId().longValue();
        long longValue4 = ad.getNetworkId().longValue();
        $jacocoInit[10] = true;
        this(longValue, iconUrl, intValue, intValue2, longValue2, packageName2, cpcUrl2, cpdUrl, cpiUrl, clickUrl2, adTitle, longValue3, longValue4);
        $jacocoInit[11] = true;
    }

    public long getAdId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.adId;
        $jacocoInit[12] = true;
        return j;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[13] = true;
        return str;
    }

    public long getTotalDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.totalDownloads;
        $jacocoInit[14] = true;
        return j;
    }

    public float getStarRating() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.starRating;
        $jacocoInit[15] = true;
        return f;
    }

    public long getModifiedDate() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.modifiedDate;
        $jacocoInit[16] = true;
        return j;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[17] = true;
        return str;
    }

    public String getCpcUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.cpcUrl;
        $jacocoInit[18] = true;
        return str;
    }

    public String getClickPerDownloadUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.clickPerDownloadUrl;
        $jacocoInit[19] = true;
        return str;
    }

    public String getClickPerInstallUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.clickPerInstallUrl;
        $jacocoInit[20] = true;
        return str;
    }

    public String getClickUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.clickUrl;
        $jacocoInit[21] = true;
        return str;
    }

    public String getAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[22] = true;
        return str;
    }

    public long getAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.appId;
        $jacocoInit[23] = true;
        return j;
    }

    public long getNetworkId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.networkId;
        $jacocoInit[24] = true;
        return j;
    }
}
