package p005cm.aptoide.p006pt.app.view.donations.model;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.view.donations.model.DonationsDialogResult */
public class DonationsDialogResult {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String nickname;
    private String packageName;
    private float value;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6142127670914463367L, "cm/aptoide/pt/app/view/donations/model/DonationsDialogResult", 4);
        $jacocoData = probes;
        return probes;
    }

    public DonationsDialogResult(String packageName2, String nickname2, float value2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.packageName = packageName2;
        this.nickname = nickname2;
        this.value = value2;
        $jacocoInit[0] = true;
    }

    public float getValue() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.value;
        $jacocoInit[1] = true;
        return f;
    }

    public String getNickname() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.nickname;
        $jacocoInit[2] = true;
        return str;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[3] = true;
        return str;
    }
}
