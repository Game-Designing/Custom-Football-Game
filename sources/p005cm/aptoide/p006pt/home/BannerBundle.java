package p005cm.aptoide.p006pt.home;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.home.HomeBundle.BundleType;

/* renamed from: cm.aptoide.pt.home.BannerBundle */
public class BannerBundle extends DummyBundle {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(829439849619693340L, "cm/aptoide/pt/home/BannerBundle", 6);
        $jacocoData = probes;
        return probes;
    }

    public BannerBundle() {
        $jacocoInit()[0] = true;
    }

    public /* bridge */ /* synthetic */ List getContent() {
        boolean[] $jacocoInit = $jacocoInit();
        List content = super.getContent();
        $jacocoInit[4] = true;
        return content;
    }

    public /* bridge */ /* synthetic */ Event getEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Event event = super.getEvent();
        $jacocoInit[3] = true;
        return event;
    }

    public /* bridge */ /* synthetic */ String getTag() {
        boolean[] $jacocoInit = $jacocoInit();
        String tag = super.getTag();
        $jacocoInit[2] = true;
        return tag;
    }

    public /* bridge */ /* synthetic */ String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String title = super.getTitle();
        $jacocoInit[5] = true;
        return title;
    }

    public BundleType getType() {
        boolean[] $jacocoInit = $jacocoInit();
        BundleType bundleType = BundleType.SMALL_BANNER;
        $jacocoInit[1] = true;
        return bundleType;
    }
}
