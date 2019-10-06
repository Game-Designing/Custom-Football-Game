package p005cm.aptoide.p006pt.search.model;

import java.util.Date;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Rank;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App.Stats.Rating;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.File;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.search.SearchApp;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;

/* renamed from: cm.aptoide.pt.search.model.SearchAppResult */
public class SearchAppResult {
    private static transient /* synthetic */ boolean[] $jacocoData;
    long appId;
    String appName;
    private boolean appcAdvertising;
    private boolean appcBilling;
    float averageRating;
    boolean hasOtherVersions;
    String icon;
    long modifiedDate;
    String packageName;
    int rank;
    String storeName;
    String storeTheme;
    long totalDownloads;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(404073369574703465L, "cm/aptoide/pt/search/model/SearchAppResult", 28);
        $jacocoData = probes;
        return probes;
    }

    public SearchAppResult() {
        $jacocoInit()[0] = true;
    }

    public SearchAppResult(int rank2, String icon2, String storeName2, String storeTheme2, long modifiedDate2, float averageRating2, long totalDownloads2, String appName2, String packageName2, long appId2, boolean hasOtherVersions2, boolean appcBilling2, boolean appcAdvertising2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.rank = rank2;
        this.icon = icon2;
        this.storeName = storeName2;
        this.storeTheme = storeTheme2;
        this.modifiedDate = modifiedDate2;
        this.averageRating = averageRating2;
        this.totalDownloads = totalDownloads2;
        this.appName = appName2;
        this.packageName = packageName2;
        this.appId = appId2;
        this.hasOtherVersions = hasOtherVersions2;
        this.appcBilling = appcBilling2;
        this.appcAdvertising = appcAdvertising2;
        $jacocoInit[1] = true;
    }

    public SearchAppResult(SearchApp searchApp) {
        boolean[] $jacocoInit = $jacocoInit();
        File file = searchApp.getFile();
        $jacocoInit[2] = true;
        Malware malware = file.getMalware();
        $jacocoInit[3] = true;
        Rank rank2 = malware.getRank();
        $jacocoInit[4] = true;
        int ordinal = rank2.ordinal();
        String icon2 = searchApp.getIcon();
        Store store = searchApp.getStore();
        $jacocoInit[5] = true;
        String name = store.getName();
        Store store2 = searchApp.getStore();
        $jacocoInit[6] = true;
        Appearance appearance = store2.getAppearance();
        $jacocoInit[7] = true;
        String theme = appearance.getTheme();
        Date modified = searchApp.getModified();
        $jacocoInit[8] = true;
        long time = modified.getTime();
        Stats stats = searchApp.getStats();
        $jacocoInit[9] = true;
        Rating rating = stats.getRating();
        $jacocoInit[10] = true;
        float avg = rating.getAvg();
        Stats stats2 = searchApp.getStats();
        $jacocoInit[11] = true;
        long pdownloads = (long) stats2.getPdownloads();
        String name2 = searchApp.getName();
        String packageName2 = searchApp.getPackageName();
        long id = searchApp.getId();
        $jacocoInit[12] = true;
        boolean hasVersions = searchApp.hasVersions();
        boolean hasBilling = searchApp.hasBilling();
        boolean hasAdvertising = searchApp.hasAdvertising();
        $jacocoInit[13] = true;
        this(ordinal, icon2, name, theme, time, avg, pdownloads, name2, packageName2, id, hasVersions, hasBilling, hasAdvertising);
        $jacocoInit[14] = true;
    }

    public int getRank() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.rank;
        $jacocoInit[15] = true;
        return i;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[16] = true;
        return str;
    }

    public String getStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        $jacocoInit[17] = true;
        return str;
    }

    public String getStoreTheme() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeTheme;
        $jacocoInit[18] = true;
        return str;
    }

    public long getModifiedDate() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.modifiedDate;
        $jacocoInit[19] = true;
        return j;
    }

    public float getAverageRating() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.averageRating;
        $jacocoInit[20] = true;
        return f;
    }

    public long getTotalDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.totalDownloads;
        $jacocoInit[21] = true;
        return j;
    }

    public String getAppName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.appName;
        $jacocoInit[22] = true;
        return str;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[23] = true;
        return str;
    }

    public long getAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.appId;
        $jacocoInit[24] = true;
        return j;
    }

    public boolean hasOtherVersions() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasOtherVersions;
        $jacocoInit[25] = true;
        return z;
    }

    public boolean hasAppcAdvertising() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.appcAdvertising;
        $jacocoInit[26] = true;
        return z;
    }

    public boolean hasAppcBilling() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.appcBilling;
        $jacocoInit[27] = true;
        return z;
    }
}
