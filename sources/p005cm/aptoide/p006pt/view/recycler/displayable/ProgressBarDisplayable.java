package p005cm.aptoide.p006pt.view.recycler.displayable;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.view.recycler.displayable.ProgressBarDisplayable */
public class ProgressBarDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4249819689955304718L, "cm/aptoide/pt/view/recycler/displayable/ProgressBarDisplayable", 3);
        $jacocoData = probes;
        return probes;
    }

    public ProgressBarDisplayable() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, false);
        $jacocoInit[1] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[2] = true;
        return C1375R.layout.row_progress_bar;
    }
}
