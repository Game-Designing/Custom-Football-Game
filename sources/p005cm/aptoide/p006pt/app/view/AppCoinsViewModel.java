package p005cm.aptoide.p006pt.app.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.AppCoinsAdvertisingModel;

/* renamed from: cm.aptoide.pt.app.view.AppCoinsViewModel */
public class AppCoinsViewModel {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppCoinsAdvertisingModel advertisingModel;
    private final boolean hasBilling;
    private final boolean loading;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6009992132133259003L, "cm/aptoide/pt/app/view/AppCoinsViewModel", 6);
        $jacocoData = probes;
        return probes;
    }

    public AppCoinsViewModel(boolean loading2, boolean hasBilling2, AppCoinsAdvertisingModel advertisingModel2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = loading2;
        this.hasBilling = hasBilling2;
        this.advertisingModel = advertisingModel2;
        $jacocoInit[0] = true;
    }

    public AppCoinsViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        this.loading = false;
        this.hasBilling = false;
        $jacocoInit[1] = true;
        this.advertisingModel = new AppCoinsAdvertisingModel();
        $jacocoInit[2] = true;
    }

    public boolean isLoading() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.loading;
        $jacocoInit[3] = true;
        return z;
    }

    public boolean hasBilling() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasBilling;
        $jacocoInit[4] = true;
        return z;
    }

    public AppCoinsAdvertisingModel getAdvertisingModel() {
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsAdvertisingModel appCoinsAdvertisingModel = this.advertisingModel;
        $jacocoInit[5] = true;
        return appCoinsAdvertisingModel;
    }
}
