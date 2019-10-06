package p005cm.aptoide.p006pt.view.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.AppVideo */
public class AppVideo {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String thumbnail;
    private final String type;
    private final String url;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-502934484464959921L, "cm/aptoide/pt/view/app/AppVideo", 4);
        $jacocoData = probes;
        return probes;
    }

    public AppVideo(String thumbnail2, String type2, String url2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.thumbnail = thumbnail2;
        this.type = type2;
        this.url = url2;
        $jacocoInit[0] = true;
    }

    public String getThumbnail() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.thumbnail;
        $jacocoInit[1] = true;
        return str;
    }

    public String getType() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.type;
        $jacocoInit[2] = true;
        return str;
    }

    public String getUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.url;
        $jacocoInit[3] = true;
        return str;
    }
}
