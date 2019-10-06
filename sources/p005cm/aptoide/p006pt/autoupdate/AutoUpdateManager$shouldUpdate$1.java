package p005cm.aptoide.p006pt.autoupdate;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.autoupdate.AutoUpdateManager$shouldUpdate$1 */
/* compiled from: AutoUpdateManager.kt */
final class AutoUpdateManager$shouldUpdate$1<T, R> implements C0132p<T, R> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    public static final AutoUpdateManager$shouldUpdate$1 INSTANCE = new AutoUpdateManager$shouldUpdate$1();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8268198298458312822L, "cm/aptoide/pt/autoupdate/AutoUpdateManager$shouldUpdate$1", 4);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[3] = true;
    }

    AutoUpdateManager$shouldUpdate$1() {
        $jacocoInit()[2] = true;
    }

    public /* bridge */ /* synthetic */ Object call(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean valueOf = Boolean.valueOf(call((AutoUpdateModel) obj));
        $jacocoInit[0] = true;
        return valueOf;
    }

    public final boolean call(AutoUpdateModel it) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean shouldUpdate = it.getShouldUpdate();
        $jacocoInit[1] = true;
        return shouldUpdate;
    }
}
