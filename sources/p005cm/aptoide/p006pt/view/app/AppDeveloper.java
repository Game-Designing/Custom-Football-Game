package p005cm.aptoide.p006pt.view.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.AppDeveloper */
public class AppDeveloper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String email;
    private final String name;
    private final String privacy;
    private final String website;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8874381289604194121L, "cm/aptoide/pt/view/app/AppDeveloper", 5);
        $jacocoData = probes;
        return probes;
    }

    public AppDeveloper(String name2, String email2, String privacy2, String website2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.name = name2;
        this.email = email2;
        this.privacy = privacy2;
        this.website = website2;
        $jacocoInit[0] = true;
    }

    public String getName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[1] = true;
        return str;
    }

    public String getEmail() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.email;
        $jacocoInit[2] = true;
        return str;
    }

    public String getPrivacy() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.privacy;
        $jacocoInit[3] = true;
        return str;
    }

    public String getWebsite() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.website;
        $jacocoInit[4] = true;
        return str;
    }
}
