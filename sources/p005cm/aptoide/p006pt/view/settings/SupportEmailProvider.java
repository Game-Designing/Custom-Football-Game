package p005cm.aptoide.p006pt.view.settings;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.settings.SupportEmailProvider */
public class SupportEmailProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String aptoideEmail;
    private final String email;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7353431622509149410L, "cm/aptoide/pt/view/settings/SupportEmailProvider", 3);
        $jacocoData = probes;
        return probes;
    }

    public SupportEmailProvider(String email2, String aptoideEmail2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.email = email2;
        this.aptoideEmail = aptoideEmail2;
        $jacocoInit[0] = true;
    }

    public boolean isAptoideSupport() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean equals = this.aptoideEmail.equals(this.email);
        $jacocoInit[1] = true;
        return equals;
    }

    public String getEmail() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.email;
        $jacocoInit[2] = true;
        return str;
    }
}
