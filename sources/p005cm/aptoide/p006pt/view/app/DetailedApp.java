package p005cm.aptoide.p006pt.view.app;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetAppMeta.Pay;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;

/* renamed from: cm.aptoide.pt.view.app.DetailedApp */
public class DetailedApp {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String added;
    private final AppDeveloper appDeveloper;
    private final AppFlags appFlags;
    private List<String> bdsFlags;
    private final long fileSize;
    private final String graphic;
    private boolean hasAdvertising;
    private boolean hasBilling;
    private final String icon;

    /* renamed from: id */
    private long f9003id;
    private final boolean isGoodApp;
    private final boolean isLatestTrustedVersion;
    private boolean isMature;
    private final boolean isPaid;
    private final Malware malware;
    private final String md5;
    private final AppMedia media;
    private final String modified;
    private final String name;
    private final Obb obb;
    private final String packageName;
    private final String paidAppPath;
    private String path;
    private final String pathAlt;
    private final Pay pay;
    private final String paymentStatus;
    private String signature;
    private final long size;
    private final AppStats stats;
    private final Store store;
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
        boolean[] probes = Offline.getProbes(584176781740951014L, "cm/aptoide/pt/view/app/DetailedApp", 43);
        $jacocoData = probes;
        return probes;
    }

    public DetailedApp(long id, String name2, String packageName2, long size2, String icon2, String graphic2, String added2, String modified2, boolean isGoodApp2, Malware malware2, AppFlags appFlags2, List<String> tags2, List<String> usedFeatures2, List<String> usedPermissions2, long fileSize2, String md52, String path2, String pathAlt2, int versionCode2, String versionName2, AppDeveloper appDeveloper2, Store store2, AppMedia media2, AppStats stats2, Obb obb2, Pay pay2, String webUrls2, boolean isPaid2, boolean wasPaid2, String paidAppPath2, String paymentStatus2, boolean isLatestTrustedVersion2, String uniqueName2, boolean hasBilling2, boolean hasAdvertising2, List<String> bdsFlags2, boolean isMature2, String signature2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f9003id = id;
        this.name = name2;
        this.packageName = packageName2;
        this.size = size2;
        this.icon = icon2;
        this.graphic = graphic2;
        this.added = added2;
        this.modified = modified2;
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
        this.appDeveloper = appDeveloper2;
        this.store = store2;
        this.media = media2;
        this.stats = stats2;
        this.obb = obb2;
        this.pay = pay2;
        this.webUrls = webUrls2;
        this.isPaid = isPaid2;
        this.wasPaid = wasPaid2;
        this.paidAppPath = paidAppPath2;
        this.paymentStatus = paymentStatus2;
        this.isLatestTrustedVersion = isLatestTrustedVersion2;
        this.uniqueName = uniqueName2;
        this.hasBilling = hasBilling2;
        this.hasAdvertising = hasAdvertising2;
        this.bdsFlags = bdsFlags2;
        this.isMature = isMature2;
        this.signature = signature2;
        $jacocoInit[0] = true;
    }

    public DetailedApp(long id, String name2, String packageName2, long size2, String icon2, String graphic2, String added2, String modified2, boolean isGoodApp2, Malware malware2, AppFlags appFlags2, List<String> tags2, List<String> usedFeatures2, List<String> usedPermissions2, long fileSize2, String md52, String path2, String pathAlt2, int versionCode2, String versionName2, AppDeveloper appDeveloper2, Store store2, AppMedia media2, AppStats stats2, Obb obb2, Pay pay2, String webUrls2, boolean isPaid2, boolean isLatestTrustedVersion2, String uniqueName2, boolean hasBilling2, boolean hasAdvertising2, List<String> bdsFlags2, boolean isMature2, String signature2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f9003id = id;
        this.name = name2;
        this.packageName = packageName2;
        this.size = size2;
        this.icon = icon2;
        this.graphic = graphic2;
        this.added = added2;
        this.modified = modified2;
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
        this.appDeveloper = appDeveloper2;
        this.store = store2;
        this.media = media2;
        this.stats = stats2;
        this.obb = obb2;
        this.pay = pay2;
        this.webUrls = webUrls2;
        this.isPaid = isPaid2;
        this.hasBilling = hasBilling2;
        this.hasAdvertising = hasAdvertising2;
        this.bdsFlags = bdsFlags2;
        this.isMature = isMature2;
        this.wasPaid = false;
        String str = "";
        this.paidAppPath = str;
        this.paymentStatus = str;
        this.signature = signature2;
        this.isLatestTrustedVersion = isLatestTrustedVersion2;
        this.uniqueName = uniqueName2;
        $jacocoInit[1] = true;
    }

    public long getId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.f9003id;
        $jacocoInit[2] = true;
        return j;
    }

    public void setId(long id) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f9003id = id;
        $jacocoInit[3] = true;
    }

    public String getName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[4] = true;
        return str;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[5] = true;
        return str;
    }

    public long getSize() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.size;
        $jacocoInit[6] = true;
        return j;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[7] = true;
        return str;
    }

    public String getGraphic() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.graphic;
        $jacocoInit[8] = true;
        return str;
    }

    public String getAdded() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.added;
        $jacocoInit[9] = true;
        return str;
    }

    public String getModified() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.modified;
        $jacocoInit[10] = true;
        return str;
    }

    public Store getStore() {
        boolean[] $jacocoInit = $jacocoInit();
        Store store2 = this.store;
        $jacocoInit[11] = true;
        return store2;
    }

    public AppDeveloper getDeveloper() {
        boolean[] $jacocoInit = $jacocoInit();
        AppDeveloper appDeveloper2 = this.appDeveloper;
        $jacocoInit[12] = true;
        return appDeveloper2;
    }

    public AppMedia getMedia() {
        boolean[] $jacocoInit = $jacocoInit();
        AppMedia appMedia = this.media;
        $jacocoInit[13] = true;
        return appMedia;
    }

    public AppStats getStats() {
        boolean[] $jacocoInit = $jacocoInit();
        AppStats appStats = this.stats;
        $jacocoInit[14] = true;
        return appStats;
    }

    public Obb getObb() {
        boolean[] $jacocoInit = $jacocoInit();
        Obb obb2 = this.obb;
        $jacocoInit[15] = true;
        return obb2;
    }

    public Pay getPay() {
        boolean[] $jacocoInit = $jacocoInit();
        Pay pay2 = this.pay;
        $jacocoInit[16] = true;
        return pay2;
    }

    public String getWebUrls() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.webUrls;
        $jacocoInit[17] = true;
        return str;
    }

    public AppFlags getAppFlags() {
        boolean[] $jacocoInit = $jacocoInit();
        AppFlags appFlags2 = this.appFlags;
        $jacocoInit[18] = true;
        return appFlags2;
    }

    public List<String> getTags() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> list = this.tags;
        $jacocoInit[19] = true;
        return list;
    }

    public List<String> getUsedFeatures() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> list = this.usedFeatures;
        $jacocoInit[20] = true;
        return list;
    }

    public List<String> getUsedPermissions() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> list = this.usedPermissions;
        $jacocoInit[21] = true;
        return list;
    }

    public long getFileSize() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.fileSize;
        $jacocoInit[22] = true;
        return j;
    }

    public String getMd5() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.md5;
        $jacocoInit[23] = true;
        return str;
    }

    public String getPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.path;
        $jacocoInit[24] = true;
        return str;
    }

    public void setPath(String path2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.path = path2;
        $jacocoInit[25] = true;
    }

    public String getPathAlt() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.pathAlt;
        $jacocoInit[26] = true;
        return str;
    }

    public int getVersionCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.versionCode;
        $jacocoInit[27] = true;
        return i;
    }

    public String getVersionName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.versionName;
        $jacocoInit[28] = true;
        return str;
    }

    public boolean isGoodApp() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isGoodApp;
        $jacocoInit[29] = true;
        return z;
    }

    public Malware getMalware() {
        boolean[] $jacocoInit = $jacocoInit();
        Malware malware2 = this.malware;
        $jacocoInit[30] = true;
        return malware2;
    }

    public boolean isPaid() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isPaid;
        $jacocoInit[31] = true;
        return z;
    }

    public String getUniqueName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.uniqueName;
        $jacocoInit[32] = true;
        return str;
    }

    public boolean isLatestTrustedVersion() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isLatestTrustedVersion;
        $jacocoInit[33] = true;
        return z;
    }

    public String getPaidAppPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.paidAppPath;
        $jacocoInit[34] = true;
        return str;
    }

    public String getPaymentStatus() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.paymentStatus;
        $jacocoInit[35] = true;
        return str;
    }

    public boolean wasPaid() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.wasPaid;
        $jacocoInit[36] = true;
        return z;
    }

    public boolean hasBilling() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasBilling;
        $jacocoInit[37] = true;
        return z;
    }

    public boolean hasAdvertising() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasAdvertising;
        $jacocoInit[38] = true;
        return z;
    }

    public List<String> getBdsFlags() {
        boolean[] $jacocoInit = $jacocoInit();
        List<String> list = this.bdsFlags;
        $jacocoInit[39] = true;
        return list;
    }

    public void setBdsFlags(List<String> bdsFlags2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bdsFlags = bdsFlags2;
        $jacocoInit[40] = true;
    }

    public boolean isMature() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isMature;
        $jacocoInit[41] = true;
        return z;
    }

    public String getSignature() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.signature;
        $jacocoInit[42] = true;
        return str;
    }
}
