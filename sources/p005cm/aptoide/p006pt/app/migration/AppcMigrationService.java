package p005cm.aptoide.p006pt.app.migration;

import java.util.ArrayList;
import kotlin.p376c.p378b.C14281f;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.AppcMigrationAccessor;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.app.migration.AppcMigrationService */
/* compiled from: AppcMigrationService.kt */
public class AppcMigrationService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppcMigrationAccessor appcMigrationAccessor;
    private final ArrayList<String> migrationCandidates = new ArrayList<>();

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3559342571235026917L, "cm/aptoide/pt/app/migration/AppcMigrationService", 17);
        $jacocoData = probes;
        return probes;
    }

    public AppcMigrationService(AppcMigrationAccessor appcMigrationAccessor2) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(appcMigrationAccessor2, "appcMigrationAccessor");
        $jacocoInit[14] = true;
        this.appcMigrationAccessor = appcMigrationAccessor2;
        $jacocoInit[15] = true;
        $jacocoInit[16] = true;
    }

    public final AppcMigrationAccessor getAppcMigrationAccessor() {
        boolean[] $jacocoInit = $jacocoInit();
        AppcMigrationAccessor appcMigrationAccessor2 = this.appcMigrationAccessor;
        $jacocoInit[13] = true;
        return appcMigrationAccessor2;
    }

    public final void addMigrationCandidate(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(packageName, "packageName");
        $jacocoInit[0] = true;
        if (this.migrationCandidates.contains(packageName)) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            this.migrationCandidates.add(packageName);
            $jacocoInit[3] = true;
        }
        $jacocoInit[4] = true;
    }

    public final void persistCandidate(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(packageName, "packageName");
        $jacocoInit[5] = true;
        if (!this.migrationCandidates.contains(packageName)) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            this.appcMigrationAccessor.insert(packageName);
            $jacocoInit[8] = true;
            this.migrationCandidates.remove(packageName);
            $jacocoInit[9] = true;
        }
        $jacocoInit[10] = true;
    }

    public final C0120S<Boolean> isAppMigrated(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C14281f.m45916b(packageName, "packageName");
        $jacocoInit[11] = true;
        C0120S<Boolean> isAppMigrated = this.appcMigrationAccessor.isAppMigrated(packageName);
        C14281f.m45913a((Object) isAppMigrated, "appcMigrationAccessor.isAppMigrated(packageName)");
        $jacocoInit[12] = true;
        return isAppMigrated;
    }
}
