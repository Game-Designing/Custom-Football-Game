package p005cm.aptoide.p006pt.view.recycler.displayable;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.view.recycler.displayable.FooterRowDisplayable */
public class FooterRowDisplayable extends DisplayablePojo<String> {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3948580969658443178L, "cm/aptoide/pt/view/recycler/displayable/FooterRowDisplayable", 4);
        $jacocoData = probes;
        return probes;
    }

    public FooterRowDisplayable() {
        $jacocoInit()[0] = true;
    }

    public FooterRowDisplayable(String pojo) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.displayable_grid_footer_text;
    }
}
