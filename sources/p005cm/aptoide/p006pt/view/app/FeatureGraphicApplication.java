package p005cm.aptoide.p006pt.view.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.FeatureGraphicApplication */
public class FeatureGraphicApplication extends Application {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String featureGraphic;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1009541175555590347L, "cm/aptoide/pt/view/app/FeatureGraphicApplication", 2);
        $jacocoData = probes;
        return probes;
    }

    public FeatureGraphicApplication(String name, String icon, float rating, int downloads, String packageName, long appId, String featureGraphic2, String tag, boolean hasBilling, boolean hasAdvertising) {
        boolean[] $jacocoInit = $jacocoInit();
        super(name, icon, rating, downloads, packageName, appId, tag, hasBilling);
        this.featureGraphic = featureGraphic2;
        $jacocoInit[0] = true;
    }

    public String getFeatureGraphic() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.featureGraphic;
        $jacocoInit[1] = true;
        return str;
    }
}
