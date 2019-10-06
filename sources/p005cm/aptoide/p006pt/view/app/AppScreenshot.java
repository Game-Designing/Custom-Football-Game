package p005cm.aptoide.p006pt.view.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.AppScreenshot */
public class AppScreenshot {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int height;
    private final String orientation;
    private final String url;
    private final int width;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8133896475107886006L, "cm/aptoide/pt/view/app/AppScreenshot", 5);
        $jacocoData = probes;
        return probes;
    }

    public AppScreenshot(int height2, int width2, String orientation2, String url2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.height = height2;
        this.width = width2;
        this.orientation = orientation2;
        this.url = url2;
        $jacocoInit[0] = true;
    }

    public int getHeight() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.height;
        $jacocoInit[1] = true;
        return i;
    }

    public int getWidth() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.width;
        $jacocoInit[2] = true;
        return i;
    }

    public String getOrientation() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.orientation;
        $jacocoInit[3] = true;
        return str;
    }

    public String getUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.url;
        $jacocoInit[4] = true;
        return str;
    }
}
