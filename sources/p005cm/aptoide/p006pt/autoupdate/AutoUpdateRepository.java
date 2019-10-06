package p005cm.aptoide.p006pt.autoupdate;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;
import p026rx.p027b.C0129b;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateRepository */
/* compiled from: AutoUpdateRepository.kt */
public final class AutoUpdateRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AutoUpdateModel autoUpdateModel;
    private final AutoUpdateService autoUpdateService;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-487069287679623219L, "cm/aptoide/pt/autoupdate/AutoUpdateRepository", 15);
        $jacocoData = probes;
        return probes;
    }

    public AutoUpdateRepository(AutoUpdateService autoUpdateService2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(autoUpdateService2, "autoUpdateService");
        $jacocoInit[9] = true;
        this.autoUpdateService = autoUpdateService2;
        $jacocoInit[10] = true;
    }

    public static final /* synthetic */ AutoUpdateModel access$getAutoUpdateModel$p(AutoUpdateRepository $this) {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateModel autoUpdateModel2 = $this.autoUpdateModel;
        if (autoUpdateModel2 != null) {
            $jacocoInit[11] = true;
            $jacocoInit[13] = true;
            return autoUpdateModel2;
        }
        C14281f.m45917b("autoUpdateModel");
        throw null;
    }

    public static final /* synthetic */ void access$setAutoUpdateModel$p(AutoUpdateRepository $this, AutoUpdateModel autoUpdateModel2) {
        boolean[] $jacocoInit = $jacocoInit();
        $this.autoUpdateModel = autoUpdateModel2;
        $jacocoInit[14] = true;
    }

    public final Single<AutoUpdateModel> loadFreshAutoUpdateModel() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<AutoUpdateModel> loadAndSaveAutoUpdateModel = loadAndSaveAutoUpdateModel();
        $jacocoInit[0] = true;
        return loadAndSaveAutoUpdateModel;
    }

    public final Single<AutoUpdateModel> loadAutoUpdateModel() {
        Single<AutoUpdateModel> single;
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateModel autoUpdateModel2 = this.autoUpdateModel;
        if (autoUpdateModel2 != null) {
            $jacocoInit[1] = true;
            if (autoUpdateModel2 != null) {
                $jacocoInit[2] = true;
                single = Single.m734a(autoUpdateModel2);
                C14281f.m45913a((Object) single, "Single.just(autoUpdateModel)");
                $jacocoInit[4] = true;
            } else {
                C14281f.m45917b("autoUpdateModel");
                throw null;
            }
        } else {
            single = loadAndSaveAutoUpdateModel();
            $jacocoInit[5] = true;
        }
        $jacocoInit[6] = true;
        return single;
    }

    private final Single<AutoUpdateModel> loadAndSaveAutoUpdateModel() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAutoUpdateModel = this.autoUpdateService.loadAutoUpdateModel();
        $jacocoInit[7] = true;
        Single<AutoUpdateModel> b = loadAutoUpdateModel.mo3695b((C0129b<? super T>) new AutoUpdateRepository$loadAndSaveAutoUpdateModel$1<Object>(this));
        C14281f.m45913a((Object) b, "autoUpdateService.loadAu… { autoUpdateModel = it }");
        $jacocoInit[8] = true;
        return b;
    }
}
