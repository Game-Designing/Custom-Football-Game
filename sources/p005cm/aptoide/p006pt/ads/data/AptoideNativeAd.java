package p005cm.aptoide.p006pt.ads.data;

import android.view.View;
import java.util.Date;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd.Network;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.Partner;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.Partner.Data;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.Partner.Info;

/* renamed from: cm.aptoide.pt.ads.data.AptoideNativeAd */
public class AptoideNativeAd implements ApplicationAd {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private Long adId;
    private Long appId;
    private String clickUrl;
    private String cpcUrl;
    private String cpdUrl;
    private String cpiUrl;
    private String description;
    private Integer downloads;
    private String iconPath;
    private Long modified;
    private String name;
    private Long networkId;
    private String packageName;
    private Integer stars;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1391278290935642505L, "cm/aptoide/pt/ads/data/AptoideNativeAd", 117);
        $jacocoData = probes;
        return probes;
    }

    public AptoideNativeAd(MinimalAd ad) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.packageName = ad.getPackageName();
        $jacocoInit[1] = true;
        this.networkId = ad.getNetworkId();
        $jacocoInit[2] = true;
        this.clickUrl = ad.getClickUrl();
        $jacocoInit[3] = true;
        this.cpcUrl = ad.getCpcUrl();
        $jacocoInit[4] = true;
        this.cpdUrl = ad.getCpdUrl();
        $jacocoInit[5] = true;
        this.appId = ad.getAppId();
        $jacocoInit[6] = true;
        this.adId = ad.getAdId();
        $jacocoInit[7] = true;
        this.cpiUrl = ad.getCpiUrl();
        $jacocoInit[8] = true;
        this.name = ad.getName();
        $jacocoInit[9] = true;
        this.iconPath = ad.getIconPath();
        $jacocoInit[10] = true;
        this.description = ad.getDescription();
        $jacocoInit[11] = true;
        this.downloads = ad.getDownloads();
        $jacocoInit[12] = true;
        this.stars = ad.getStars();
        $jacocoInit[13] = true;
        this.modified = ad.getModified();
        $jacocoInit[14] = true;
    }

    public AptoideNativeAd(C2842Ad ad) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[15] = true;
        Partner partner = ad.getPartner();
        int id = 0;
        String clickUrl2 = null;
        if (partner == null) {
            $jacocoInit[16] = true;
        } else {
            $jacocoInit[17] = true;
            Info info = partner.getInfo();
            $jacocoInit[18] = true;
            id = info.getId();
            $jacocoInit[19] = true;
            Data data = partner.getData();
            $jacocoInit[20] = true;
            clickUrl2 = data.getClickUrl();
            $jacocoInit[21] = true;
        }
        GetAdsResponse.Data data2 = ad.getData();
        $jacocoInit[22] = true;
        this.packageName = data2.getPackageName();
        $jacocoInit[23] = true;
        this.networkId = Long.valueOf((long) id);
        this.clickUrl = clickUrl2;
        $jacocoInit[24] = true;
        GetAdsResponse.Info info2 = ad.getInfo();
        $jacocoInit[25] = true;
        this.cpcUrl = info2.getCpcUrl();
        $jacocoInit[26] = true;
        GetAdsResponse.Info info3 = ad.getInfo();
        $jacocoInit[27] = true;
        this.cpdUrl = info3.getCpdUrl();
        $jacocoInit[28] = true;
        GetAdsResponse.Data data3 = ad.getData();
        $jacocoInit[29] = true;
        long id2 = data3.getId();
        $jacocoInit[30] = true;
        this.appId = Long.valueOf(id2);
        $jacocoInit[31] = true;
        GetAdsResponse.Info info4 = ad.getInfo();
        $jacocoInit[32] = true;
        long adId2 = info4.getAdId();
        $jacocoInit[33] = true;
        this.adId = Long.valueOf(adId2);
        $jacocoInit[34] = true;
        GetAdsResponse.Info info5 = ad.getInfo();
        $jacocoInit[35] = true;
        this.cpiUrl = info5.getCpiUrl();
        $jacocoInit[36] = true;
        GetAdsResponse.Data data4 = ad.getData();
        $jacocoInit[37] = true;
        this.name = data4.getName();
        $jacocoInit[38] = true;
        GetAdsResponse.Data data5 = ad.getData();
        $jacocoInit[39] = true;
        this.iconPath = data5.getIcon();
        $jacocoInit[40] = true;
        GetAdsResponse.Data data6 = ad.getData();
        $jacocoInit[41] = true;
        this.description = data6.getDescription();
        $jacocoInit[42] = true;
        GetAdsResponse.Data data7 = ad.getData();
        $jacocoInit[43] = true;
        int downloads2 = data7.getDownloads();
        $jacocoInit[44] = true;
        this.downloads = Integer.valueOf(downloads2);
        $jacocoInit[45] = true;
        GetAdsResponse.Data data8 = ad.getData();
        $jacocoInit[46] = true;
        int stars2 = data8.getStars();
        $jacocoInit[47] = true;
        this.stars = Integer.valueOf(stars2);
        $jacocoInit[48] = true;
        GetAdsResponse.Data data9 = ad.getData();
        $jacocoInit[49] = true;
        Date modified2 = data9.getModified();
        $jacocoInit[50] = true;
        long time = modified2.getTime();
        $jacocoInit[51] = true;
        this.modified = Long.valueOf(time);
        $jacocoInit[52] = true;
    }

    public String getAdTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[53] = true;
        return str;
    }

    public String getIconUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.iconPath;
        $jacocoInit[54] = true;
        return str;
    }

    public Integer getStars() {
        boolean[] $jacocoInit = $jacocoInit();
        Integer num = this.stars;
        $jacocoInit[55] = true;
        return num;
    }

    public void registerClickableView(View view) {
        $jacocoInit()[56] = true;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[57] = true;
        return str;
    }

    public Network getNetwork() {
        boolean[] $jacocoInit = $jacocoInit();
        Network network = Network.SERVER;
        $jacocoInit[58] = true;
        return network;
    }

    public void setAdView(View adView) {
        $jacocoInit()[59] = true;
    }

    public String getCpdUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.cpdUrl;
        $jacocoInit[60] = true;
        return str;
    }

    public String getDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.description;
        $jacocoInit[61] = true;
        return str;
    }

    public Long getNetworkId() {
        boolean[] $jacocoInit = $jacocoInit();
        Long l = this.networkId;
        $jacocoInit[62] = true;
        return l;
    }

    public String getClickUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.clickUrl;
        $jacocoInit[63] = true;
        return str;
    }

    public String getCpcUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.cpcUrl;
        $jacocoInit[64] = true;
        return str;
    }

    public Long getAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        Long l = this.appId;
        $jacocoInit[65] = true;
        return l;
    }

    public Long getAdId() {
        boolean[] $jacocoInit = $jacocoInit();
        Long l = this.adId;
        $jacocoInit[66] = true;
        return l;
    }

    public String getCpiUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.cpiUrl;
        $jacocoInit[67] = true;
        return str;
    }

    public Integer getDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        Integer num = this.downloads;
        $jacocoInit[68] = true;
        return num;
    }

    public Long getModified() {
        boolean[] $jacocoInit = $jacocoInit();
        Long l = this.modified;
        $jacocoInit[69] = true;
        return l;
    }

    public int hashCode() {
        boolean[] $jacocoInit = $jacocoInit();
        int result = this.cpdUrl.hashCode();
        $jacocoInit[70] = true;
        int result2 = (result * 31) + this.description.hashCode();
        $jacocoInit[71] = true;
        int result3 = (result2 * 31) + this.packageName.hashCode();
        $jacocoInit[72] = true;
        int result4 = (result3 * 31) + this.clickUrl.hashCode();
        $jacocoInit[73] = true;
        int result5 = (result4 * 31) + this.cpcUrl.hashCode();
        $jacocoInit[74] = true;
        int result6 = (result5 * 31) + this.cpiUrl.hashCode();
        $jacocoInit[75] = true;
        int result7 = (result6 * 31) + this.name.hashCode();
        $jacocoInit[76] = true;
        int result8 = (result7 * 31) + this.iconPath.hashCode();
        $jacocoInit[77] = true;
        int result9 = (result8 * 31) + this.downloads.hashCode();
        $jacocoInit[78] = true;
        int result10 = (result9 * 31) + this.stars.hashCode();
        $jacocoInit[79] = true;
        int result11 = (result10 * 31) + ((int) (this.networkId.longValue() ^ (this.networkId.longValue() >>> 32)));
        $jacocoInit[80] = true;
        int result12 = (result11 * 31) + ((int) (this.appId.longValue() ^ (this.appId.longValue() >>> 32)));
        $jacocoInit[81] = true;
        int result13 = (result12 * 31) + ((int) (this.adId.longValue() ^ (this.adId.longValue() >>> 32)));
        $jacocoInit[82] = true;
        int result14 = (result13 * 31) + ((int) (this.modified.longValue() ^ (this.modified.longValue() >>> 32)));
        $jacocoInit[83] = true;
        return result14;
    }

    public boolean equals(Object o) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this == o) {
            $jacocoInit[84] = true;
            return true;
        }
        boolean z = false;
        if (!(o instanceof AptoideNativeAd)) {
            $jacocoInit[85] = true;
            return false;
        }
        AptoideNativeAd ad = (AptoideNativeAd) o;
        $jacocoInit[86] = true;
        if (!ad.modified.equals(this.modified)) {
            $jacocoInit[87] = true;
        } else {
            Integer num = ad.stars;
            Integer num2 = this.stars;
            $jacocoInit[88] = true;
            if (!num.equals(num2)) {
                $jacocoInit[89] = true;
            } else {
                Integer num3 = ad.downloads;
                Integer num4 = this.downloads;
                $jacocoInit[90] = true;
                if (!num3.equals(num4)) {
                    $jacocoInit[91] = true;
                } else {
                    String str = ad.description;
                    String str2 = this.description;
                    $jacocoInit[92] = true;
                    if (!str.equals(str2)) {
                        $jacocoInit[93] = true;
                    } else {
                        String str3 = ad.iconPath;
                        String str4 = this.iconPath;
                        $jacocoInit[94] = true;
                        if (!str3.equals(str4)) {
                            $jacocoInit[95] = true;
                        } else {
                            String str5 = ad.name;
                            String str6 = this.name;
                            $jacocoInit[96] = true;
                            if (!str5.equals(str6)) {
                                $jacocoInit[97] = true;
                            } else {
                                String str7 = ad.cpiUrl;
                                String str8 = this.cpiUrl;
                                $jacocoInit[98] = true;
                                if (!str7.equals(str8)) {
                                    $jacocoInit[99] = true;
                                } else {
                                    Long l = ad.adId;
                                    Long l2 = this.adId;
                                    $jacocoInit[100] = true;
                                    if (!l.equals(l2)) {
                                        $jacocoInit[101] = true;
                                    } else {
                                        String str9 = ad.cpdUrl;
                                        String str10 = this.cpdUrl;
                                        $jacocoInit[102] = true;
                                        if (!str9.equals(str10)) {
                                            $jacocoInit[103] = true;
                                        } else {
                                            String str11 = ad.cpcUrl;
                                            String str12 = this.cpcUrl;
                                            $jacocoInit[104] = true;
                                            if (!str11.equals(str12)) {
                                                $jacocoInit[105] = true;
                                            } else {
                                                Long l3 = ad.appId;
                                                Long l4 = this.appId;
                                                $jacocoInit[106] = true;
                                                if (!l3.equals(l4)) {
                                                    $jacocoInit[107] = true;
                                                } else {
                                                    String str13 = ad.clickUrl;
                                                    String str14 = this.clickUrl;
                                                    $jacocoInit[108] = true;
                                                    if (!str13.equals(str14)) {
                                                        $jacocoInit[109] = true;
                                                    } else {
                                                        Long l5 = ad.networkId;
                                                        Long l6 = this.networkId;
                                                        $jacocoInit[110] = true;
                                                        if (!l5.equals(l6)) {
                                                            $jacocoInit[111] = true;
                                                        } else {
                                                            String str15 = ad.packageName;
                                                            String str16 = this.packageName;
                                                            $jacocoInit[112] = true;
                                                            if (!str15.equals(str16)) {
                                                                $jacocoInit[113] = true;
                                                            } else {
                                                                $jacocoInit[114] = true;
                                                                z = true;
                                                                $jacocoInit[116] = true;
                                                                return z;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        $jacocoInit[115] = true;
        $jacocoInit[116] = true;
        return z;
    }
}
