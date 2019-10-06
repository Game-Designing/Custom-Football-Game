package p005cm.aptoide.p006pt.autoupdate;

import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateManager$loadAutoUpdateModel$1 */
/* compiled from: AutoUpdateManager.kt */
final class AutoUpdateManager$loadAutoUpdateModel$1<T, R> implements C0132p<T, Single<? extends R>> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ AutoUpdateManager this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6600759479920539258L, "cm/aptoide/pt/autoupdate/AutoUpdateManager$loadAutoUpdateModel$1", 9);
        $jacocoData = probes;
        return probes;
    }

    AutoUpdateManager$loadAutoUpdateModel$1(AutoUpdateManager autoUpdateManager) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = autoUpdateManager;
        $jacocoInit[8] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Single call = call((AutoUpdateModel) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final Single<AutoUpdateModel> call(AutoUpdateModel it) {
        AutoUpdateModel autoUpdateModel = it;
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
        AutoUpdateModel autoUpdateModel2 = it;
        if (it.wasSuccess()) {
            $jacocoInit[2] = true;
        } else {
            Single.m735a(new Throwable(it.getStatus().toString()));
            $jacocoInit[3] = true;
        }
        AutoUpdateManager autoUpdateManager = this.this$0;
        C14281f.m45913a((Object) autoUpdateModel, "it");
        if (!AutoUpdateManager.access$shouldUpdate(autoUpdateManager, autoUpdateModel)) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            autoUpdateModel2 = AutoUpdateModel.copy$default(it, 0, null, null, null, null, true, null, false, 223, null);
            $jacocoInit[6] = true;
        }
        Single<AutoUpdateModel> a = Single.m734a(autoUpdateModel2);
        $jacocoInit[7] = true;
        return a;
    }
}
