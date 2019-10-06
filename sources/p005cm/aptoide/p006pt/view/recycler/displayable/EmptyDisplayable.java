package p005cm.aptoide.p006pt.view.recycler.displayable;

import android.content.res.Resources;
import android.view.WindowManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.view.recycler.displayable.EmptyDisplayable */
public class EmptyDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private int spanSize = 1;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-9094424606710660989L, "cm/aptoide/pt/view/recycler/displayable/EmptyDisplayable", 6);
        $jacocoData = probes;
        return probes;
    }

    public EmptyDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    public EmptyDisplayable(int spanSize2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.spanSize = spanSize2;
        $jacocoInit[1] = true;
    }

    public int getDefaultPerLineCount() {
        $jacocoInit()[2] = true;
        return 1;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[3] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[4] = true;
        return C1375R.layout.displayable_empty;
    }

    public int getSpanSize(WindowManager windowManager, Resources resources) {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.spanSize;
        $jacocoInit[5] = true;
        return i;
    }
}
