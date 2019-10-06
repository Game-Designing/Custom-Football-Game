package p005cm.aptoide.p006pt.autoupdate;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateService$loadAutoUpdateModel$5 */
/* compiled from: AutoUpdateService.kt */
final class AutoUpdateService$loadAutoUpdateModel$5<T, R> implements C0132p<Throwable, AutoUpdateModel> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ AutoUpdateService this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5926052838713702994L, "cm/aptoide/pt/autoupdate/AutoUpdateService$loadAutoUpdateModel$5", 3);
        $jacocoData = probes;
        return probes;
    }

    AutoUpdateService$loadAutoUpdateModel$5(AutoUpdateService autoUpdateService) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = autoUpdateService;
        $jacocoInit[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateModel call = call((Throwable) obj);
        $jacocoInit[0] = true;
        return call;
    }

    public final AutoUpdateModel call(Throwable it) {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateModel access$createErrorAutoUpdateModel = AutoUpdateService.access$createErrorAutoUpdateModel(this.this$0, it);
        $jacocoInit[1] = true;
        return access$createErrorAutoUpdateModel;
    }
}
