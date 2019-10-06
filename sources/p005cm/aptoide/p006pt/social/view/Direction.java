package p005cm.aptoide.p006pt.social.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.social.view.Direction */
public class Direction {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int bottom = 8;
    private static final int left = 1;
    private static final int right = 2;
    private static final int top = 4;
    private final int direction;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5235119507703010209L, "cm/aptoide/pt/social/view/Direction", 19);
        $jacocoData = probes;
        return probes;
    }

    public Direction(int dx, int dy) {
        boolean[] $jacocoInit = $jacocoInit();
        int temp = 0;
        if (dx > 0) {
            temp = 0 | 2;
            $jacocoInit[0] = true;
        } else if (dx >= 0) {
            $jacocoInit[1] = true;
        } else {
            temp = 0 | 1;
            $jacocoInit[2] = true;
        }
        if (dy > 0) {
            temp |= 8;
            $jacocoInit[3] = true;
        } else if (dy >= 0) {
            $jacocoInit[4] = true;
        } else {
            temp |= 4;
            $jacocoInit[5] = true;
        }
        this.direction = temp;
        $jacocoInit[6] = true;
    }

    public boolean left() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if ((this.direction & 1) == 1) {
            $jacocoInit[7] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[8] = true;
        }
        $jacocoInit[9] = true;
        return z;
    }

    public boolean right() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if ((this.direction & 2) == 2) {
            $jacocoInit[10] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[11] = true;
        }
        $jacocoInit[12] = true;
        return z;
    }

    public boolean top() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if ((this.direction & 4) == 4) {
            $jacocoInit[13] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[14] = true;
        }
        $jacocoInit[15] = true;
        return z;
    }

    public boolean bottom() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if ((this.direction & 8) == 8) {
            $jacocoInit[16] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[17] = true;
        }
        $jacocoInit[18] = true;
        return z;
    }
}
