package p005cm.aptoide.p006pt.account.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.account.view.ImageInfo */
public class ImageInfo {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final int height;
    private final long size;
    private final int width;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3185389977733817415L, "cm/aptoide/pt/account/view/ImageInfo", 4);
        $jacocoData = probes;
        return probes;
    }

    public ImageInfo(int height2, int width2, long size2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.height = height2;
        this.width = width2;
        this.size = size2;
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

    public long getSize() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.size;
        $jacocoInit[3] = true;
        return j;
    }
}
