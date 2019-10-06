package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;

/* renamed from: cm.aptoide.pt.view.AppViewConfiguration */
public class AppViewConfiguration {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final long appId;
    private final double appc;
    private final String campaignUrl;
    private final String editorsChoice;
    private final String md5;
    private final SearchAdResult minimalAd;
    private final String originTag;
    private final String packageName;
    private final OpenType shouldInstall;
    private final String storeName;
    private final String storeTheme;
    private final String uniqueName;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4913776111880983011L, "cm/aptoide/pt/view/AppViewConfiguration", 23);
        $jacocoData = probes;
        return probes;
    }

    public AppViewConfiguration(long appId2, String packageName2, String storeName2, String storeTheme2, SearchAdResult minimalAd2, OpenType shouldInstall2, String md52, String uniqueName2, double appc2, String editorsChoice2, String originTag2, String campaignUrl2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appId = appId2;
        this.packageName = packageName2;
        this.storeName = storeName2;
        this.storeTheme = storeTheme2;
        this.minimalAd = minimalAd2;
        this.shouldInstall = shouldInstall2;
        this.md5 = md52;
        this.uniqueName = uniqueName2;
        this.appc = appc2;
        this.editorsChoice = editorsChoice2;
        this.originTag = originTag2;
        this.campaignUrl = campaignUrl2;
        $jacocoInit[0] = true;
    }

    public long getAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.appId;
        $jacocoInit[1] = true;
        return j;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[2] = true;
        return str;
    }

    public String getStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        $jacocoInit[3] = true;
        return str;
    }

    public String getStoreTheme() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeTheme;
        $jacocoInit[4] = true;
        return str;
    }

    public SearchAdResult getMinimalAd() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAdResult searchAdResult = this.minimalAd;
        $jacocoInit[5] = true;
        return searchAdResult;
    }

    public OpenType shouldInstall() {
        boolean[] $jacocoInit = $jacocoInit();
        OpenType openType = this.shouldInstall;
        $jacocoInit[6] = true;
        return openType;
    }

    public String getMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        $jacocoInit[7] = true;
        return str;
    }

    public String getUniqueName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.uniqueName;
        $jacocoInit[8] = true;
        return str;
    }

    public double getAppc() {
        boolean[] $jacocoInit = $jacocoInit();
        double d = this.appc;
        $jacocoInit[9] = true;
        return d;
    }

    public boolean hasMd5() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        if (str == null) {
            $jacocoInit[10] = true;
        } else if (str.isEmpty()) {
            $jacocoInit[11] = true;
        } else {
            $jacocoInit[12] = true;
            z = true;
            $jacocoInit[14] = true;
            return z;
        }
        z = false;
        $jacocoInit[13] = true;
        $jacocoInit[14] = true;
        return z;
    }

    public boolean hasUniqueName() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.uniqueName;
        if (str == null) {
            $jacocoInit[15] = true;
        } else if (str.isEmpty()) {
            $jacocoInit[16] = true;
        } else {
            $jacocoInit[17] = true;
            z = true;
            $jacocoInit[19] = true;
            return z;
        }
        z = false;
        $jacocoInit[18] = true;
        $jacocoInit[19] = true;
        return z;
    }

    public String getEditorsChoice() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.editorsChoice;
        $jacocoInit[20] = true;
        return str;
    }

    public String getOriginTag() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.originTag;
        $jacocoInit[21] = true;
        return str;
    }

    public String getCampaignUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.campaignUrl;
        $jacocoInit[22] = true;
        return str;
    }
}
