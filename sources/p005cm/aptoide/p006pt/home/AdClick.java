package p005cm.aptoide.p006pt.home;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.data.ApplicationAd;
import p005cm.aptoide.p006pt.ads.data.AptoideNativeAd;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad;

/* renamed from: cm.aptoide.pt.home.AdClick */
public class AdClick {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: ad */
    private final ApplicationAd f6727ad;
    private final String tag;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6323578603364649875L, "cm/aptoide/pt/home/AdClick", 5);
        $jacocoData = probes;
        return probes;
    }

    public AdClick(C2842Ad ad, String tag2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
        this.f6727ad = new AptoideNativeAd(ad);
        this.tag = tag2;
        $jacocoInit[1] = true;
    }

    public AdClick(ApplicationAd ad, String tag2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.f6727ad = ad;
        this.tag = tag2;
        $jacocoInit[2] = true;
    }

    public ApplicationAd getAd() {
        boolean[] $jacocoInit = $jacocoInit();
        ApplicationAd applicationAd = this.f6727ad;
        $jacocoInit[3] = true;
        return applicationAd;
    }

    public String getTag() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.tag;
        $jacocoInit[4] = true;
        return str;
    }
}
