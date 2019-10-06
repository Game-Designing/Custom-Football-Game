package p005cm.aptoide.p006pt.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.GenericResponseV2;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.app.FlagManager */
public class FlagManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final FlagService flagService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7338877517839966739L, "cm/aptoide/pt/app/FlagManager", 2);
        $jacocoData = probes;
        return probes;
    }

    public FlagManager(FlagService flagService2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.flagService = flagService2;
        $jacocoInit[0] = true;
    }

    public Single<GenericResponseV2> flagApk(String storeName, String md5, String flag) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<GenericResponseV2> doApkFlagRequest = this.flagService.doApkFlagRequest(storeName, md5, flag);
        $jacocoInit[1] = true;
        return doApkFlagRequest;
    }
}
