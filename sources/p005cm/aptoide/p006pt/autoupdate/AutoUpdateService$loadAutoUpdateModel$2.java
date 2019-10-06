package p005cm.aptoide.p006pt.autoupdate;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.p027b.C0128a;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateService$loadAutoUpdateModel$2 */
/* compiled from: AutoUpdateService.kt */
final class AutoUpdateService$loadAutoUpdateModel$2 implements C0128a {
    private static transient /* synthetic */ boolean[] $jacocoData;
    final /* synthetic */ AutoUpdateService this$0;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2361464009527131148L, "cm/aptoide/pt/autoupdate/AutoUpdateService$loadAutoUpdateModel$2", 2);
        $jacocoData = probes;
        return probes;
    }

    AutoUpdateService$loadAutoUpdateModel$2(AutoUpdateService autoUpdateService) {
        boolean[] $jacocoInit = $jacocoInit();
        this.this$0 = autoUpdateService;
        $jacocoInit[1] = true;
    }

    public final void call() {
        boolean[] $jacocoInit = $jacocoInit();
        AutoUpdateService.access$setLoading$p(this.this$0, false);
        $jacocoInit[0] = true;
    }
}
