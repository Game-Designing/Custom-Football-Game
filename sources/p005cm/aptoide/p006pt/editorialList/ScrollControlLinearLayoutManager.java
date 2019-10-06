package p005cm.aptoide.p006pt.editorialList;

import android.content.Context;
import android.support.p001v7.widget.LinearLayoutManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.editorialList.ScrollControlLinearLayoutManager */
public class ScrollControlLinearLayoutManager extends LinearLayoutManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private boolean isScrollEnabled = true;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3766325075678098120L, "cm/aptoide/pt/editorialList/ScrollControlLinearLayoutManager", 7);
        $jacocoData = probes;
        return probes;
    }

    public ScrollControlLinearLayoutManager(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context);
        $jacocoInit[0] = true;
    }

    public void setScrollEnabled(boolean flag) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isScrollEnabled = flag;
        $jacocoInit[1] = true;
    }

    public boolean canScrollVertically() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.isScrollEnabled) {
            $jacocoInit[2] = true;
        } else if (!super.canScrollVertically()) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            z = true;
            $jacocoInit[6] = true;
            return z;
        }
        z = false;
        $jacocoInit[5] = true;
        $jacocoInit[6] = true;
        return z;
    }
}
