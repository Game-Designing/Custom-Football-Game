package p005cm.aptoide.p006pt.home;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Event;
import p005cm.aptoide.p006pt.home.HomeBundle.BundleType;
import p005cm.aptoide.p006pt.view.app.Application;

/* renamed from: cm.aptoide.pt.home.AppBundle */
public class AppBundle implements HomeBundle {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final List<Application> apps;
    private final Event event;
    private final String tag;
    private final String title;
    private final BundleType type;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2040201185224515655L, "cm/aptoide/pt/home/AppBundle", 7);
        $jacocoData = probes;
        return probes;
    }

    public AppBundle(String title2, List<Application> apps2, BundleType type2, Event event2, String tag2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title = title2;
        this.apps = apps2;
        this.type = type2;
        this.event = event2;
        this.tag = tag2;
        $jacocoInit[0] = true;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[1] = true;
        return str;
    }

    public List<?> getContent() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Application> list = this.apps;
        $jacocoInit[2] = true;
        return list;
    }

    public BundleType getType() {
        boolean[] $jacocoInit = $jacocoInit();
        BundleType bundleType = this.type;
        $jacocoInit[3] = true;
        return bundleType;
    }

    public Event getEvent() {
        boolean[] $jacocoInit = $jacocoInit();
        Event event2 = this.event;
        $jacocoInit[4] = true;
        return event2;
    }

    public String getTag() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.tag;
        $jacocoInit[5] = true;
        return str;
    }

    public List<Application> getApps() {
        boolean[] $jacocoInit = $jacocoInit();
        List<Application> list = this.apps;
        $jacocoInit[6] = true;
        return list;
    }
}
