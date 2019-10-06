package p005cm.aptoide.p006pt.home;

import java.util.AbstractMap.SimpleEntry;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.data.AptoideNativeAd;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.home.AdMapper */
public class AdMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2752807152097205332L, "cm/aptoide/pt/home/AdMapper", 9);
        $jacocoData = probes;
        return probes;
    }

    public AdMapper() {
        $jacocoInit()[0] = true;
    }

    public C0132p<? super AdClick, SimpleEntry<String, SearchAdResult>> mapAdToSearchAd() {
        boolean[] $jacocoInit = $jacocoInit();
        C3843e eVar = C3843e.f7265a;
        $jacocoInit[1] = true;
        return eVar;
    }

    /* renamed from: a */
    static /* synthetic */ SimpleEntry m7927a(AdClick wrappedAd) {
        boolean[] $jacocoInit = $jacocoInit();
        if (wrappedAd == null) {
            $jacocoInit[2] = true;
            SimpleEntry simpleEntry = new SimpleEntry("", new SearchAdResult());
            $jacocoInit[3] = true;
            return simpleEntry;
        }
        AptoideNativeAd ad = (AptoideNativeAd) wrappedAd.getAd();
        $jacocoInit[4] = true;
        String tag = wrappedAd.getTag();
        $jacocoInit[5] = true;
        long longValue = ad.getAdId().longValue();
        String iconUrl = ad.getIconUrl();
        long intValue = (long) ad.getDownloads().intValue();
        float intValue2 = (float) ad.getStars().intValue();
        $jacocoInit[6] = true;
        long longValue2 = ad.getModified().longValue();
        String packageName = ad.getPackageName();
        SearchAdResult searchAdResult = r5;
        String cpcUrl = ad.getCpcUrl();
        String cpdUrl = ad.getCpdUrl();
        String cpiUrl = ad.getCpiUrl();
        $jacocoInit[7] = true;
        SearchAdResult searchAdResult2 = new SearchAdResult(longValue, iconUrl, intValue, intValue2, longValue2, packageName, cpcUrl, cpdUrl, cpiUrl, ad.getClickUrl(), ad.getAdTitle(), ad.getAppId().longValue(), ad.getNetworkId().longValue());
        SimpleEntry simpleEntry2 = new SimpleEntry(tag, searchAdResult);
        $jacocoInit[8] = true;
        return simpleEntry2;
    }
}
