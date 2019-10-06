package p005cm.aptoide.p006pt.app.migration;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.app.migration.AppcMigrationManager */
public class AppcMigrationManager {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final long BDS_STORE_ID = 1966380;
    private AppcMigrationService appcMigrationService;
    private InstalledRepository repository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5721328105182367996L, "cm/aptoide/pt/app/migration/AppcMigrationManager", 19);
        $jacocoData = probes;
        return probes;
    }

    public AppcMigrationManager(InstalledRepository repository2, AppcMigrationService appcMigrationService2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.repository = repository2;
        this.appcMigrationService = appcMigrationService2;
        $jacocoInit[0] = true;
    }

    public C0120S<Boolean> isMigrationApp(String packageName, String signature, int versionCode, long storeId, boolean hasAppc) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S installed = this.repository.getInstalled(packageName);
        C1740a aVar = new C1740a(signature, versionCode, storeId, hasAppc);
        $jacocoInit[1] = true;
        C0120S<Boolean> j = installed.mo3669j(aVar);
        $jacocoInit[2] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6478a(String signature, int versionCode, long storeId, boolean hasAppc, Installed installed) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (installed == null) {
            $jacocoInit[6] = true;
        } else if (signature == null) {
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[8] = true;
            if (installed.getSignature() == null) {
                $jacocoInit[9] = true;
            } else {
                $jacocoInit[10] = true;
                if (signature.equals(installed.getSignature())) {
                    $jacocoInit[11] = true;
                } else {
                    $jacocoInit[12] = true;
                    if (installed.getVersionCode() > versionCode) {
                        $jacocoInit[13] = true;
                    } else if (storeId != BDS_STORE_ID) {
                        $jacocoInit[14] = true;
                    } else if (!hasAppc) {
                        $jacocoInit[15] = true;
                    } else {
                        $jacocoInit[16] = true;
                        z = true;
                        Boolean valueOf = Boolean.valueOf(z);
                        $jacocoInit[18] = true;
                        return valueOf;
                    }
                }
            }
        }
        z = false;
        $jacocoInit[17] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[18] = true;
        return valueOf2;
    }

    public void addMigrationCandidate(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcMigrationService.addMigrationCandidate(packageName);
        $jacocoInit[3] = true;
    }

    public void persistCandidate(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appcMigrationService.persistCandidate(packageName);
        $jacocoInit[4] = true;
    }

    public C0120S<Boolean> isAppMigrated(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> isAppMigrated = this.appcMigrationService.isAppMigrated(packageName);
        $jacocoInit[5] = true;
        return isAppMigrated;
    }
}
