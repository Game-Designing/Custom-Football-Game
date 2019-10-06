package p005cm.aptoide.p006pt.ads;

import java.util.Date;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.database.realm.StoredMinimalAd;
import p005cm.aptoide.p006pt.dataprovider.model.MinimalAdInterface;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.Partner;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.Partner.Data;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.Partner.Info;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;

/* renamed from: cm.aptoide.pt.ads.MinimalAdMapper */
public class MinimalAdMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1034308922612977350L, "cm/aptoide/pt/ads/MinimalAdMapper", 30);
        $jacocoData = probes;
        return probes;
    }

    public MinimalAdMapper() {
        $jacocoInit()[0] = true;
    }

    public MinimalAd map(C2842Ad ad) {
        boolean[] $jacocoInit = $jacocoInit();
        Partner partner = ad.getPartner();
        int id = 0;
        String clickUrl = null;
        if (partner == null) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            Info info = partner.getInfo();
            $jacocoInit[3] = true;
            id = info.getId();
            $jacocoInit[4] = true;
            Data data = partner.getData();
            $jacocoInit[5] = true;
            clickUrl = data.getClickUrl();
            $jacocoInit[6] = true;
        }
        GetAdsResponse.Data data2 = ad.getData();
        $jacocoInit[7] = true;
        String packageName = data2.getPackageName();
        long j = (long) id;
        GetAdsResponse.Info info2 = ad.getInfo();
        $jacocoInit[8] = true;
        String cpcUrl = info2.getCpcUrl();
        GetAdsResponse.Info info3 = ad.getInfo();
        $jacocoInit[9] = true;
        String cpdUrl = info3.getCpdUrl();
        GetAdsResponse.Data data3 = ad.getData();
        $jacocoInit[10] = true;
        long id2 = data3.getId();
        GetAdsResponse.Info info4 = ad.getInfo();
        $jacocoInit[11] = true;
        long adId = info4.getAdId();
        GetAdsResponse.Info info5 = ad.getInfo();
        $jacocoInit[12] = true;
        String cpiUrl = info5.getCpiUrl();
        GetAdsResponse.Data data4 = ad.getData();
        $jacocoInit[13] = true;
        String name = data4.getName();
        GetAdsResponse.Data data5 = ad.getData();
        $jacocoInit[14] = true;
        String icon = data5.getIcon();
        GetAdsResponse.Data data6 = ad.getData();
        $jacocoInit[15] = true;
        String description = data6.getDescription();
        GetAdsResponse.Data data7 = ad.getData();
        $jacocoInit[16] = true;
        int downloads = data7.getDownloads();
        GetAdsResponse.Data data8 = ad.getData();
        $jacocoInit[17] = true;
        int stars = data8.getStars();
        GetAdsResponse.Data data9 = ad.getData();
        $jacocoInit[18] = true;
        Date modified = data9.getModified();
        $jacocoInit[19] = true;
        long time = modified.getTime();
        $jacocoInit[20] = true;
        MinimalAd minimalAd = new MinimalAd(packageName, j, clickUrl, cpcUrl, cpdUrl, id2, adId, cpiUrl, name, icon, description, downloads, stars, Long.valueOf(time));
        $jacocoInit[21] = true;
        return minimalAd;
    }

    public StoredMinimalAd map(SearchAdResult searchAdResult, String referrer) {
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = searchAdResult.getPackageName();
        $jacocoInit[22] = true;
        String cpcUrl = searchAdResult.getCpcUrl();
        $jacocoInit[23] = true;
        String cpdUrl = searchAdResult.getClickPerDownloadUrl();
        $jacocoInit[24] = true;
        String cpiUrl = searchAdResult.getClickPerInstallUrl();
        $jacocoInit[25] = true;
        long adId = searchAdResult.getAdId();
        $jacocoInit[26] = true;
        StoredMinimalAd storedMinimalAd = new StoredMinimalAd(packageName, referrer, cpcUrl, cpdUrl, cpiUrl, adId);
        $jacocoInit[27] = true;
        return storedMinimalAd;
    }

    public MinimalAdInterface map(final StoredMinimalAd storedMinimalAd) {
        boolean[] $jacocoInit = $jacocoInit();
        C16481 r1 = new MinimalAdInterface(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            public String cpdUrl;
            final /* synthetic */ MinimalAdMapper this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-8139158116219767467L, "cm/aptoide/pt/ads/MinimalAdMapper$1", 7);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public String getCpcUrl() {
                boolean[] $jacocoInit = $jacocoInit();
                String cpcUrl = storedMinimalAd.getCpcUrl();
                $jacocoInit[1] = true;
                return cpcUrl;
            }

            public String getCpdUrl() {
                boolean[] $jacocoInit = $jacocoInit();
                String str = this.cpdUrl;
                if (str == null) {
                    str = storedMinimalAd.getCpdUrl();
                    $jacocoInit[2] = true;
                } else {
                    $jacocoInit[3] = true;
                }
                $jacocoInit[4] = true;
                return str;
            }

            public void setCpdUrl(String cpdUrl2) {
                boolean[] $jacocoInit = $jacocoInit();
                this.cpdUrl = cpdUrl2;
                $jacocoInit[5] = true;
            }

            public String getCpiUrl() {
                boolean[] $jacocoInit = $jacocoInit();
                String cpiUrl = storedMinimalAd.getCpiUrl();
                $jacocoInit[6] = true;
                return cpiUrl;
            }
        };
        $jacocoInit[28] = true;
        return r1;
    }

    public MinimalAdInterface map(final SearchAdResult searchAdResult) {
        boolean[] $jacocoInit = $jacocoInit();
        C16492 r1 = new MinimalAdInterface(this) {
            private static transient /* synthetic */ boolean[] $jacocoData;
            public String cpdUrl;
            final /* synthetic */ MinimalAdMapper this$0;

            private static /* synthetic */ boolean[] $jacocoInit() {
                boolean[] zArr = $jacocoData;
                if (zArr != null) {
                    return zArr;
                }
                boolean[] probes = Offline.getProbes(-2743458878039571186L, "cm/aptoide/pt/ads/MinimalAdMapper$2", 7);
                $jacocoData = probes;
                return probes;
            }

            {
                boolean[] $jacocoInit = $jacocoInit();
                this.this$0 = this$0;
                $jacocoInit[0] = true;
            }

            public String getCpcUrl() {
                boolean[] $jacocoInit = $jacocoInit();
                String cpcUrl = searchAdResult.getCpcUrl();
                $jacocoInit[1] = true;
                return cpcUrl;
            }

            public String getCpdUrl() {
                boolean[] $jacocoInit = $jacocoInit();
                String str = this.cpdUrl;
                if (str == null) {
                    str = searchAdResult.getClickPerDownloadUrl();
                    $jacocoInit[2] = true;
                } else {
                    $jacocoInit[3] = true;
                }
                $jacocoInit[4] = true;
                return str;
            }

            public void setCpdUrl(String cpdUrl2) {
                boolean[] $jacocoInit = $jacocoInit();
                this.cpdUrl = cpdUrl2;
                $jacocoInit[5] = true;
            }

            public String getCpiUrl() {
                boolean[] $jacocoInit = $jacocoInit();
                String clickPerInstallUrl = searchAdResult.getClickPerInstallUrl();
                $jacocoInit[6] = true;
                return clickPerInstallUrl;
            }
        };
        $jacocoInit[29] = true;
        return r1;
    }
}
