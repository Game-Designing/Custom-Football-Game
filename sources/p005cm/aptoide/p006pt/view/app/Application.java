package p005cm.aptoide.p006pt.view.app;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.app.Application */
public class Application {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final long appId;
    private final int downloads;
    private final boolean hasBilling;
    private final String icon;
    private final String name;
    private final String packageName;
    private final float rating;
    private final String tag;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6018191322923587210L, "cm/aptoide/pt/view/app/Application", 10);
        $jacocoData = probes;
        return probes;
    }

    public Application(String name2, String icon2, float rating2, int downloads2, String packageName2, long appId2, String tag2, boolean hasBilling2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.name = name2;
        this.icon = icon2;
        this.rating = rating2;
        this.downloads = downloads2;
        this.appId = appId2;
        this.packageName = packageName2;
        this.tag = tag2;
        this.hasBilling = hasBilling2;
        $jacocoInit[0] = true;
    }

    public Application() {
        boolean[] $jacocoInit = $jacocoInit();
        this.name = null;
        this.icon = null;
        this.rating = -1.0f;
        this.downloads = -1;
        this.appId = -1;
        this.packageName = null;
        this.tag = "";
        this.hasBilling = false;
        $jacocoInit[1] = true;
    }

    public long getAppId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.appId;
        $jacocoInit[2] = true;
        return j;
    }

    public String getPackageName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.packageName;
        $jacocoInit[3] = true;
        return str;
    }

    public String getIcon() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.icon;
        $jacocoInit[4] = true;
        return str;
    }

    public float getRating() {
        boolean[] $jacocoInit = $jacocoInit();
        float f = this.rating;
        $jacocoInit[5] = true;
        return f;
    }

    public int getDownloads() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.downloads;
        $jacocoInit[6] = true;
        return i;
    }

    public String getName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.name;
        $jacocoInit[7] = true;
        return str;
    }

    public String getTag() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.tag;
        $jacocoInit[8] = true;
        return str;
    }

    public boolean hasAppcBilling() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.hasBilling;
        $jacocoInit[9] = true;
        return z;
    }
}
