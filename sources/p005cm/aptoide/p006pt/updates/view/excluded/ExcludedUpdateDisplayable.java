package p005cm.aptoide.p006pt.updates.view.excluded;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;

/* renamed from: cm.aptoide.pt.updates.view.excluded.ExcludedUpdateDisplayable */
public class ExcludedUpdateDisplayable extends DisplayablePojo<Update> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private boolean selected;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(906827977096214109L, "cm/aptoide/pt/updates/view/excluded/ExcludedUpdateDisplayable", 6);
        $jacocoData = probes;
        return probes;
    }

    public ExcludedUpdateDisplayable() {
        $jacocoInit()[0] = true;
    }

    public ExcludedUpdateDisplayable(Update pojo) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, false);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.row_excluded_update;
    }

    public boolean isSelected() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.selected;
        $jacocoInit[4] = true;
        return z;
    }

    public void setSelected(boolean selected2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.selected = selected2;
        $jacocoInit[5] = true;
    }
}
