package p005cm.aptoide.p006pt.promotions;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.promotions.ClaimDialogResultWrapper */
public class ClaimDialogResultWrapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String packageName;
    private boolean status;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2793391693571580543L, "cm/aptoide/pt/promotions/ClaimDialogResultWrapper", 7);
        $jacocoData = probes;
        return probes;
    }

    public ClaimDialogResultWrapper(String packageName2, boolean status2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.packageName = packageName2;
        this.status = status2;
        $jacocoInit[0] = true;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[1] = true;
        return str;
    }

    public boolean isOk() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.status) {
            $jacocoInit[2] = true;
        } else if (this.packageName.equals("")) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            z = true;
            $jacocoInit[6] = true;
            return z;
        }
        z = false;
        $jacocoInit[5] = true;
        $jacocoInit[6] = true;
        return z;
    }
}
