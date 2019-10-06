package p005cm.aptoide.p006pt.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.BundleEvent */
public class BundleEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String action;
    private final String title;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3070279631098786539L, "cm/aptoide/pt/view/BundleEvent", 3);
        $jacocoData = probes;
        return probes;
    }

    public BundleEvent(String title2, String action2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.title = title2;
        this.action = action2;
        $jacocoInit[0] = true;
    }

    public String getTitle() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.title;
        $jacocoInit[1] = true;
        return str;
    }

    public String getAction() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.action;
        $jacocoInit[2] = true;
        return str;
    }
}
