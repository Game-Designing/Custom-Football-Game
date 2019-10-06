package p005cm.aptoide.p006pt.editorial;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.editorial.ScrollEvent */
public class ScrollEvent {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Boolean isItemShown;
    private final boolean scrollDown;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1251687331797388100L, "cm/aptoide/pt/editorial/ScrollEvent", 3);
        $jacocoData = probes;
        return probes;
    }

    public ScrollEvent(boolean scrollDown2, Boolean isItemShown2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.scrollDown = scrollDown2;
        this.isItemShown = isItemShown2;
        $jacocoInit[0] = true;
    }

    public boolean isScrollDown() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.scrollDown;
        $jacocoInit[1] = true;
        return z;
    }

    public Boolean getItemShown() {
        boolean[] $jacocoInit = $jacocoInit();
        Boolean bool = this.isItemShown;
        $jacocoInit[2] = true;
        return bool;
    }
}
