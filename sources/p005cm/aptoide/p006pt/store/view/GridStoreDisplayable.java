package p005cm.aptoide.p006pt.store.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Type;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.store.StoreAnalytics;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;

/* renamed from: cm.aptoide.pt.store.view.GridStoreDisplayable */
public class GridStoreDisplayable extends DisplayablePojo<Store> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String origin = "";
    private StoreAnalytics storeAnalytics;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7321096686342888418L, "cm/aptoide/pt/store/view/GridStoreDisplayable", 8);
        $jacocoData = probes;
        return probes;
    }

    public GridStoreDisplayable(Store pojo, String origin2, StoreAnalytics storeAnalytics2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        this.origin = origin2;
        this.storeAnalytics = storeAnalytics2;
        $jacocoInit[0] = true;
    }

    public GridStoreDisplayable(Store pojo) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        $jacocoInit[1] = true;
    }

    public GridStoreDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[2] = true;
    }

    public StoreAnalytics getStoreAnalytics() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreAnalytics storeAnalytics2 = this.storeAnalytics;
        $jacocoInit[3] = true;
        return storeAnalytics2;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        int defaultPerLineCount = Type.STORES_GROUP.getDefaultPerLineCount();
        Type type = Type.STORES_GROUP;
        $jacocoInit[4] = true;
        Configs configs = new Configs(this, defaultPerLineCount, type.isFixedPerLineCount());
        $jacocoInit[5] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[6] = true;
        return C1375R.layout.displayable_grid_store;
    }

    public String getOrigin() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.origin;
        $jacocoInit[7] = true;
        return str;
    }
}
