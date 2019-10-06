package p005cm.aptoide.p006pt.app.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.app.view.AppBoughClickEvent */
public class AppBoughClickEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private long appId;
    private String path;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(793516254266499607L, "cm/aptoide/pt/app/view/AppBoughClickEvent", 3);
        $jacocoData = probes;
        return probes;
    }

    public AppBoughClickEvent(String path2, long appId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.path = path2;
        this.appId = appId2;
        $jacocoInit[0] = true;
    }

    public String getPath() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.path;
        $jacocoInit[1] = true;
        return str;
    }

    public long getAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.appId;
        $jacocoInit[2] = true;
        return j;
    }
}
