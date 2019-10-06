package p005cm.aptoide.p006pt.home;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad;

/* renamed from: cm.aptoide.pt.home.AdsTagWrapper */
public class AdsTagWrapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<C2842Ad> ads;
    private final String tag;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2425300225724312679L, "cm/aptoide/pt/home/AdsTagWrapper", 3);
        $jacocoData = probes;
        return probes;
    }

    public AdsTagWrapper(List<C2842Ad> ads2, String tag2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.ads = ads2;
        this.tag = tag2;
        $jacocoInit[0] = true;
    }

    public List<C2842Ad> getAds() {
        boolean[] $jacocoInit = $jacocoInit();
        List<C2842Ad> list = this.ads;
        $jacocoInit[1] = true;
        return list;
    }

    public String getTag() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.tag;
        $jacocoInit[2] = true;
        return str;
    }
}
