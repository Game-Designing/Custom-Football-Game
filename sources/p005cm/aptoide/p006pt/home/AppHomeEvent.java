package p005cm.aptoide.p006pt.home;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.home.HomeEvent.Type;
import p005cm.aptoide.p006pt.view.app.Application;

/* renamed from: cm.aptoide.pt.home.AppHomeEvent */
public class AppHomeEvent extends HomeEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Application app;
    private final int appPosition;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(601399475154089744L, "cm/aptoide/pt/home/AppHomeEvent", 3);
        $jacocoData = probes;
        return probes;
    }

    public AppHomeEvent(Application app2, int appPosition2, HomeBundle bundle, int bundlePosition, Type clickType) {
        boolean[] $jacocoInit = $jacocoInit();
        super(bundle, bundlePosition, clickType);
        this.app = app2;
        this.appPosition = appPosition2;
        $jacocoInit[0] = true;
    }

    public Application getApp() {
        boolean[] $jacocoInit = $jacocoInit();
        Application application = this.app;
        $jacocoInit[1] = true;
        return application;
    }

    public int getAppPosition() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.appPosition;
        $jacocoInit[2] = true;
        return i;
    }
}
