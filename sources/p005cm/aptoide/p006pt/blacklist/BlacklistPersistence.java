package p005cm.aptoide.p006pt.blacklist;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.blacklist.BlacklistPersistence */
public class BlacklistPersistence {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private SharedPreferences sharedPreferences;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1182285860146167891L, "cm/aptoide/pt/blacklist/BlacklistPersistence", 13);
        $jacocoData = probes;
        return probes;
    }

    public BlacklistPersistence(SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[0] = true;
    }

    public boolean isBlacklisted(String id, int maxPossibleImpressions) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.sharedPreferences.getInt(id, maxPossibleImpressions) == 0) {
            $jacocoInit[1] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[2] = true;
        }
        $jacocoInit[3] = true;
        return z;
    }

    public void addImpression(String id, int maxPossibleImpressions) {
        boolean[] $jacocoInit = $jacocoInit();
        int actualImpressions = this.sharedPreferences.getInt(id, maxPossibleImpressions);
        if (actualImpressions <= 0) {
            $jacocoInit[4] = true;
        } else {
            int actualImpressions2 = actualImpressions - 1;
            $jacocoInit[5] = true;
            Editor edit = this.sharedPreferences.edit();
            $jacocoInit[6] = true;
            Editor putInt = edit.putInt(id, actualImpressions2);
            $jacocoInit[7] = true;
            putInt.apply();
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
    }

    public void blacklist(String id) {
        boolean[] $jacocoInit = $jacocoInit();
        Editor edit = this.sharedPreferences.edit();
        $jacocoInit[10] = true;
        Editor putInt = edit.putInt(id, 0);
        $jacocoInit[11] = true;
        putInt.apply();
        $jacocoInit[12] = true;
    }
}
