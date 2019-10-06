package p005cm.aptoide.p006pt.home;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.home.HomeBundle.BundleType;

/* renamed from: cm.aptoide.pt.home.AdBundle */
public class AdBundle implements HomeBundle {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<AdClick> ads = new ArrayList();
    private final Event event;
    private final String tag;
    private final String title;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5044106990455366328L, "cm/aptoide/pt/home/AdBundle", 12);
        $jacocoData = probes;
        return probes;
    }

    public AdBundle(String title2, AdsTagWrapper ads2, Event event2, String tag2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title = title2;
        $jacocoInit[0] = true;
        $jacocoInit[1] = true;
        $jacocoInit[2] = true;
        for (C2842Ad ad : ads2.getAds()) {
            $jacocoInit[3] = true;
            this.ads.add(new AdClick(ad, tag2));
            $jacocoInit[4] = true;
        }
        this.event = event2;
        this.tag = tag2;
        $jacocoInit[5] = true;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[6] = true;
        return str;
    }

    public List<?> getContent() {
        boolean[] $jacocoInit = $jacocoInit();
        List<AdClick> list = this.ads;
        $jacocoInit[7] = true;
        return list;
    }

    public BundleType getType() {
        boolean[] $jacocoInit = $jacocoInit();
        BundleType bundleType = BundleType.ADS;
        $jacocoInit[8] = true;
        return bundleType;
    }

    public Event getEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Event event2 = this.event;
        $jacocoInit[9] = true;
        return event2;
    }

    public String getTag() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.tag;
        $jacocoInit[10] = true;
        return str;
    }

    public List<AdClick> getAds() {
        boolean[] $jacocoInit = $jacocoInit();
        List<AdClick> list = this.ads;
        $jacocoInit[11] = true;
        return list;
    }
}
