package p005cm.aptoide.p006pt.install;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.Download;

/* renamed from: cm.aptoide.pt.install.PackageInstallerManager */
public class PackageInstallerManager {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6729252611705013641L, "cm/aptoide/pt/install/PackageInstallerManager", 2);
        $jacocoData = probes;
        return probes;
    }

    public PackageInstallerManager() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldSetInstallerPackageName(Download download) {
        $jacocoInit()[1] = true;
        return false;
    }
}
