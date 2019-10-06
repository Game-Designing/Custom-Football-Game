package p005cm.aptoide.p006pt.view.recycler.displayable;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.recycler.displayable.SelectableDisplayablePojo */
public abstract class SelectableDisplayablePojo<T> extends DisplayablePojo<T> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private boolean selected;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8526399587419416529L, "cm/aptoide/pt/view/recycler/displayable/SelectableDisplayablePojo", 4);
        $jacocoData = probes;
        return probes;
    }

    public SelectableDisplayablePojo() {
        $jacocoInit()[0] = true;
    }

    public SelectableDisplayablePojo(T pojo) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        $jacocoInit[1] = true;
    }

    public boolean isSelected() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.selected;
        $jacocoInit[2] = true;
        return z;
    }

    public void setSelected(boolean selected2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.selected = selected2;
        $jacocoInit[3] = true;
    }
}
