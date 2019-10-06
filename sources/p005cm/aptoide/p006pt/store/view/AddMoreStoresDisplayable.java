package p005cm.aptoide.p006pt.store.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.store.view.AddMoreStoresDisplayable */
public class AddMoreStoresDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7915084485026448219L, "cm/aptoide/pt/store/view/AddMoreStoresDisplayable", 3);
        $jacocoData = probes;
        return probes;
    }

    public AddMoreStoresDisplayable() {
        $jacocoInit()[0] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[1] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[2] = true;
        return C1375R.layout.add_more_stores_row;
    }
}
