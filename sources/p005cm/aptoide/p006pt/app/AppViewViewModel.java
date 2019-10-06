package p005cm.aptoide.p006pt.app;

import android.os.Build.VERSION;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.AppViewFragment.OpenType;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Pay;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.view.app.AppDeveloper;
import p005cm.aptoide.p006pt.view.app.AppFlags;
import p005cm.aptoide.p006pt.view.app.AppMedia;
import p005cm.aptoide.p006pt.view.app.AppRating;
import p005cm.aptoide.p006pt.view.app.DetailedAppRequestResult.Error;

/* renamed from: cm.aptoide.pt.app.AppViewViewModel */
public class AppViewViewModel {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String BDS_STORE_FLAG = "STORE_BDS";
    private final String appAdded;
    private final AppDeveloper appDeveloper;
    private final AppFlags appFlags;
    private final long appId;
    private final String appName;
    private final double appc;
    private List<String> bdsFlags;
    private String campaignUrl;
    private final int downloads;
    private final String editorsChoice;
    private final Error error;
    private final long fileSize;
    private final AppRating globalRating;
    private final String graphic;
    private boolean hasAdvertising;
    private boolean hasBilling;
    private final String icon;
    private final boolean isGoodApp;
    private final boolean isLatestTrustedVersion;
    private final boolean isPaid;
    private final boolean isStoreFollowed;
    private final boolean loading;
    private final Malware malware;
    private final String marketName;
    private final String md5;
    private final AppMedia media;
    private final SearchAdResult minimalAd;
    private final String modified;
    private final Obb obb;
    private final OpenType openType;
    private final String originTag;
    private final int packageDownloads;
    private final String packageName;
    private final String paidAppPath;
    private final String path;
    private final String pathAlt;
    private final Pay pay;
    private final String paymentStatus;
    private final AppRating rating;
    private String signature;
    private final long size;
    private final Store store;
    private final String storeTheme;
    private final List<String> tags;
    private final String uniqueName;
    private final List<String> usedFeatures;
    private final List<String> usedPermissions;
    private final int versionCode;
    private final String versionName;
    private final boolean wasPaid;
    private final String webUrls;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7737949199880384363L, "cm/aptoide/pt/app/AppViewViewModel", 73);
        $jacocoData = probes;
        return probes;
    }

    public AppViewViewModel(long appId2, String appName2, Store store2, String storeTheme2, boolean isGoodApp2, Malware malware2, AppFlags appFlags2, List<String> tags2, List<String> usedFeatures2, List<String> usedPermissions2, long fileSize2, String md52, String path2, String pathAlt2, int versionCode2, String versionName2, String packageName2, long size2, int downloads2, AppRating globalRating2, int packageDownloads2, AppRating rating2, AppDeveloper appDeveloper2, String graphic2, String icon2, AppMedia media2, String modified2, String appAdded2, Obb obb2, Pay pay2, String webUrls2, boolean isPaid2, boolean wasPaid2, String paidAppPath2, String paymentStatus2, boolean isLatestTrustedVersion2, String uniqueName2, OpenType openType2, double appc2, SearchAdResult minimalAd2, String editorsChoice2, String originTag2, boolean isStoreFollowed2, String marketName2, boolean hasBilling2, boolean hasAdvertising2, List<String> bdsFlags2, String campaignUrl2, String signature2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appId = appId2;
        this.appName = appName2;
        this.store = store2;
        this.storeTheme = storeTheme2;
        this.isGoodApp = isGoodApp2;
        this.malware = malware2;
        this.appFlags = appFlags2;
        this.tags = tags2;
        this.usedFeatures = usedFeatures2;
        this.usedPermissions = usedPermissions2;
        this.fileSize = fileSize2;
        this.md5 = md52;
        this.path = path2;
        this.pathAlt = pathAlt2;
        this.versionCode = versionCode2;
        this.versionName = versionName2;
        this.packageName = packageName2;
        this.size = size2;
        this.downloads = downloads2;
        this.globalRating = globalRating2;
        this.packageDownloads = packageDownloads2;
        this.rating = rating2;
        this.appDeveloper = appDeveloper2;
        this.graphic = graphic2;
        this.icon = icon2;
        this.media = media2;
        this.modified = modified2;
        this.appAdded = appAdded2;
        this.obb = obb2;
        this.pay = pay2;
        this.webUrls = webUrls2;
        this.isPaid = isPaid2;
        this.wasPaid = wasPaid2;
        this.paidAppPath = paidAppPath2;
        this.paymentStatus = paymentStatus2;
        this.isLatestTrustedVersion = isLatestTrustedVersion2;
        this.uniqueName = uniqueName2;
        this.openType = openType2;
        this.appc = appc2;
        this.minimalAd = minimalAd2;
        this.editorsChoice = editorsChoice2;
        this.originTag = originTag2;
        this.isStoreFollowed = isStoreFollowed2;
        this.marketName = marketName2;
        this.hasBilling = hasBilling2;
        this.hasAdvertising = hasAdvertising2;
        this.bdsFlags = bdsFlags2;
        this.campaignUrl = campaignUrl2;
        this.signature = signature2;
        this.loading = false;
        this.error = null;
        $jacocoInit[0] = true;
    }

    public AppViewViewModel(boolean loading2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = loading2;
        this.appId = -1;
        String str = "";
        this.appName = str;
        this.store = null;
        this.storeTheme = str;
        this.isGoodApp = false;
        this.malware = null;
        this.appFlags = null;
        this.tags = null;
        this.usedFeatures = null;
        this.usedPermissions = null;
        this.fileSize = -1;
        this.md5 = str;
        this.path = str;
        this.pathAlt = str;
        this.versionCode = -1;
        this.versionName = str;
        this.packageName = str;
        this.size = -1;
        this.downloads = -1;
        this.globalRating = null;
        this.packageDownloads = -1;
        this.rating = null;
        this.appDeveloper = null;
        this.graphic = null;
        this.icon = null;
        this.media = null;
        this.modified = null;
        this.appAdded = null;
        this.obb = null;
        this.pay = null;
        this.webUrls = null;
        this.isPaid = false;
        this.wasPaid = false;
        this.paidAppPath = str;
        this.paymentStatus = str;
        this.isLatestTrustedVersion = false;
        this.uniqueName = str;
        this.openType = null;
        this.appc = -1.0d;
        this.minimalAd = null;
        this.editorsChoice = str;
        this.originTag = str;
        this.marketName = str;
        this.isStoreFollowed = false;
        this.signature = str;
        this.error = null;
        this.hasBilling = false;
        this.hasAdvertising = false;
        this.bdsFlags = null;
        this.campaignUrl = str;
        $jacocoInit[1] = true;
    }

    public AppViewViewModel(Error error2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.error = error2;
        this.appId = -1;
        String str = "";
        this.appName = str;
        $jacocoInit[2] = true;
        this.store = new Store();
        $jacocoInit[3] = true;
        this.store.setId(-1);
        this.storeTheme = str;
        this.isGoodApp = false;
        this.malware = null;
        this.appFlags = null;
        this.tags = null;
        this.usedFeatures = null;
        this.usedPermissions = null;
        this.fileSize = -1;
        this.md5 = str;
        this.path = str;
        this.pathAlt = str;
        this.versionCode = -1;
        this.versionName = str;
        this.packageName = str;
        this.size = -1;
        this.downloads = -1;
        this.globalRating = null;
        this.packageDownloads = -1;
        this.rating = null;
        this.appDeveloper = null;
        this.graphic = null;
        this.icon = null;
        this.media = null;
        this.modified = null;
        this.appAdded = null;
        this.obb = null;
        this.pay = null;
        this.webUrls = null;
        this.isPaid = false;
        this.wasPaid = false;
        this.paidAppPath = str;
        this.paymentStatus = str;
        this.isLatestTrustedVersion = false;
        this.uniqueName = str;
        this.openType = null;
        this.appc = -1.0d;
        this.minimalAd = null;
        this.editorsChoice = str;
        this.originTag = str;
        this.marketName = str;
        this.isStoreFollowed = false;
        this.signature = str;
        this.loading = false;
        this.hasBilling = false;
        this.hasAdvertising = false;
        this.bdsFlags = null;
        this.campaignUrl = str;
        $jacocoInit[4] = true;
    }

    public boolean isStoreFollowed() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isStoreFollowed;
        $jacocoInit[5] = true;
        return z;
    }

    public long getAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.appId;
        $jacocoInit[6] = true;
        return j;
    }

    public String getAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[7] = true;
        return str;
    }

    public Store getStore() {
        boolean[] $jacocoInit = $jacocoInit();
        Store store2 = this.store;
        $jacocoInit[8] = true;
        return store2;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[9] = true;
        return str;
    }

    public long getSize() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.size;
        $jacocoInit[10] = true;
        return j;
    }

    public AppDeveloper getDeveloper() {
        boolean[] $jacocoInit = $jacocoInit();
        AppDeveloper appDeveloper2 = this.appDeveloper;
        $jacocoInit[11] = true;
        return appDeveloper2;
    }

    public String getGraphic() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.graphic;
        $jacocoInit[12] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[13] = true;
        return str;
    }

    public AppMedia getMedia() {
        boolean[] $jacocoInit = $jacocoInit();
        AppMedia appMedia = this.media;
        $jacocoInit[14] = true;
        return appMedia;
    }

    public String getModified() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.modified;
        $jacocoInit[15] = true;
        return str;
    }

    public String getAppAdded() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appAdded;
        $jacocoInit[16] = true;
        return str;
    }

    public Obb getObb() {
        boolean[] $jacocoInit = $jacocoInit();
        Obb obb2 = this.obb;
        $jacocoInit[17] = true;
        return obb2;
    }

    public Pay getPay() {
        boolean[] $jacocoInit = $jacocoInit();
        Pay pay2 = this.pay;
        $jacocoInit[18] = true;
        return pay2;
    }

    public int getDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.downloads;
        $jacocoInit[19] = true;
        return i;
    }

    public AppRating getGlobalRating() {
        boolean[] $jacocoInit = $jacocoInit();
        AppRating appRating = this.globalRating;
        $jacocoInit[20] = true;
        return appRating;
    }

    public int getPackageDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.packageDownloads;
        $jacocoInit[21] = true;
        return i;
    }

    public AppRating getRating() {
        boolean[] $jacocoInit = $jacocoInit();
        AppRating appRating = this.rating;
        $jacocoInit[22] = true;
        return appRating;
    }

    public boolean isLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.loading;
        $jacocoInit[23] = true;
        return z;
    }

    public Error getError() {
        boolean[] $jacocoInit = $jacocoInit();
        Error error2 = this.error;
        $jacocoInit[24] = true;
        return error2;
    }

    public boolean hasError() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.error != null) {
            $jacocoInit[25] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[26] = true;
        }
        $jacocoInit[27] = true;
        return z;
    }

    public String getWebUrls() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.webUrls;
        $jacocoInit[28] = true;
        return str;
    }

    public AppFlags getAppFlags() {
        boolean[] $jacocoInit = $jacocoInit();
        AppFlags appFlags2 = this.appFlags;
        $jacocoInit[29] = true;
        return appFlags2;
    }

    public List<String> getTags() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> list = this.tags;
        $jacocoInit[30] = true;
        return list;
    }

    public List<String> getUsedFeatures() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> list = this.usedFeatures;
        $jacocoInit[31] = true;
        return list;
    }

    public List<String> getUsedPermissions() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> list = this.usedPermissions;
        $jacocoInit[32] = true;
        return list;
    }

    public long getFileSize() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.fileSize;
        $jacocoInit[33] = true;
        return j;
    }

    public String getMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        $jacocoInit[34] = true;
        return str;
    }

    public String getPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.path;
        $jacocoInit[35] = true;
        return str;
    }

    public String getPathAlt() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.pathAlt;
        $jacocoInit[36] = true;
        return str;
    }

    public int getVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[37] = true;
        return i;
    }

    public String getVersionName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.versionName;
        $jacocoInit[38] = true;
        return str;
    }

    public boolean isGoodApp() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isGoodApp;
        $jacocoInit[39] = true;
        return z;
    }

    public Malware getMalware() {
        boolean[] $jacocoInit = $jacocoInit();
        Malware malware2 = this.malware;
        $jacocoInit[40] = true;
        return malware2;
    }

    public boolean isPaid() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isPaid;
        $jacocoInit[41] = true;
        return z;
    }

    public String getUniqueName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.uniqueName;
        $jacocoInit[42] = true;
        return str;
    }

    public OpenType getOpenType() {
        boolean[] $jacocoInit = $jacocoInit();
        OpenType openType2 = this.openType;
        $jacocoInit[43] = true;
        return openType2;
    }

    public double getAppc() {
        boolean[] $jacocoInit = $jacocoInit();
        double d = this.appc;
        $jacocoInit[44] = true;
        return d;
    }

    public SearchAdResult getMinimalAd() {
        boolean[] $jacocoInit = $jacocoInit();
        SearchAdResult searchAdResult = this.minimalAd;
        $jacocoInit[45] = true;
        return searchAdResult;
    }

    public String getStoreTheme() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeTheme;
        $jacocoInit[46] = true;
        return str;
    }

    public String getEditorsChoice() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.editorsChoice;
        $jacocoInit[47] = true;
        return str;
    }

    public String getOriginTag() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.originTag;
        $jacocoInit[48] = true;
        return str;
    }

    public boolean isLatestTrustedVersion() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isLatestTrustedVersion;
        $jacocoInit[49] = true;
        return z;
    }

    public boolean wasPaid() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.wasPaid;
        $jacocoInit[50] = true;
        return z;
    }

    public String getPaidAppPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.paidAppPath;
        $jacocoInit[51] = true;
        return str;
    }

    public String getPaymentStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.paymentStatus;
        $jacocoInit[52] = true;
        return str;
    }

    public String getMarketName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.marketName;
        $jacocoInit[53] = true;
        return str;
    }

    public boolean hasBilling() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasBilling;
        $jacocoInit[54] = true;
        return z;
    }

    public boolean isAppCoinApp() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.hasBilling) {
            $jacocoInit[55] = true;
        } else if (this.hasAdvertising) {
            $jacocoInit[56] = true;
        } else {
            z = false;
            $jacocoInit[58] = true;
            $jacocoInit[59] = true;
            return z;
        }
        $jacocoInit[57] = true;
        z = true;
        $jacocoInit[59] = true;
        return z;
    }

    public boolean hasAdvertising() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasAdvertising;
        $jacocoInit[60] = true;
        return z;
    }

    public List<String> getBdsFlags() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> list = this.bdsFlags;
        $jacocoInit[61] = true;
        return list;
    }

    public boolean hasDonations() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        List<String> list = this.bdsFlags;
        if (list == null) {
            $jacocoInit[62] = true;
        } else {
            $jacocoInit[63] = true;
            if (list.isEmpty()) {
                $jacocoInit[64] = true;
            } else {
                List<String> list2 = this.bdsFlags;
                $jacocoInit[65] = true;
                if (!list2.contains(BDS_STORE_FLAG)) {
                    $jacocoInit[66] = true;
                } else if (VERSION.SDK_INT < 21) {
                    $jacocoInit[67] = true;
                } else {
                    $jacocoInit[68] = true;
                    z = true;
                    $jacocoInit[70] = true;
                    return z;
                }
            }
        }
        z = false;
        $jacocoInit[69] = true;
        $jacocoInit[70] = true;
        return z;
    }

    public String getCampaignUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.campaignUrl;
        $jacocoInit[71] = true;
        return str;
    }

    public String getSignature() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.signature;
        $jacocoInit[72] = true;
        return str;
    }
}
