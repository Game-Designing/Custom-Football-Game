package p005cm.aptoide.p006pt.app.view.donations;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.view.donations.Donation */
public class Donation {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private float appc;
    private String domain;
    private String owner;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8658430950572728943L, "cm/aptoide/pt/app/view/donations/Donation", 4);
        $jacocoData = probes;
        return probes;
    }

    public Donation(String domain2, String owner2, float appc2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.domain = domain2;
        this.owner = owner2;
        this.appc = appc2;
        $jacocoInit[0] = true;
    }

    public float getAppc() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.appc;
        $jacocoInit[1] = true;
        return f;
    }

    public String getOwner() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.owner;
        $jacocoInit[2] = true;
        return str;
    }

    public String getDomain() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.domain;
        $jacocoInit[3] = true;
        return str;
    }
}
