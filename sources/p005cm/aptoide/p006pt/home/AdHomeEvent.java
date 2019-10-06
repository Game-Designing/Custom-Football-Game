package p005cm.aptoide.p006pt.home;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;

/* renamed from: cm.aptoide.pt.home.AdHomeEvent */
public class AdHomeEvent extends HomeEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AdClick adClick;
    private final int position;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7247188352505442362L, "cm/aptoide/pt/home/AdHomeEvent", 3);
        $jacocoData = probes;
        return probes;
    }

    public AdHomeEvent(AdClick ad, int position2, HomeBundle bundle, int bundlePosition, Type clickType) {
        boolean[] $jacocoInit = $jacocoInit();
        super(bundle, bundlePosition, clickType);
        this.adClick = ad;
        this.position = position2;
        $jacocoInit[0] = true;
    }

    public AdClick getAdClick() {
        boolean[] $jacocoInit = $jacocoInit();
        AdClick adClick2 = this.adClick;
        $jacocoInit[1] = true;
        return adClick2;
    }

    public int getPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.position;
        $jacocoInit[2] = true;
        return i;
    }
}
