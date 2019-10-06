package p005cm.aptoide.p006pt;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.AptoideShortcutManager */
public class AptoideShortcutManager {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8248711430482022469L, "cm/aptoide/pt/AptoideShortcutManager", 2);
        $jacocoData = probes;
        return probes;
    }

    public AptoideShortcutManager() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldCreateShortcut() {
        $jacocoInit()[1] = true;
        return true;
    }
}
