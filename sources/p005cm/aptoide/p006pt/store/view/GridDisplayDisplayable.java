package p005cm.aptoide.p006pt.store.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreDisplays.EventImage;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;

/* renamed from: cm.aptoide.pt.store.view.GridDisplayDisplayable */
public class GridDisplayDisplayable extends DisplayablePojo<EventImage> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private InstalledRepository installedRepository;
    private StoreContext storeContext;
    private String storeName;
    private String storeTheme;
    private String tag;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3074989937036061669L, "cm/aptoide/pt/store/view/GridDisplayDisplayable", 9);
        $jacocoData = probes;
        return probes;
    }

    public GridDisplayDisplayable() {
        $jacocoInit()[0] = true;
    }

    public GridDisplayDisplayable(EventImage pojo, String storeTheme2, String tag2, StoreContext storeContext2, InstalledRepository installedRepository2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        this.storeTheme = storeTheme2;
        this.tag = tag2;
        this.storeContext = storeContext2;
        this.installedRepository = installedRepository2;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 2, true);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.displayable_grid_display;
    }

    public InstalledRepository getInstalledRepository() {
        boolean[] $jacocoInit = $jacocoInit();
        InstalledRepository installedRepository2 = this.installedRepository;
        $jacocoInit[4] = true;
        return installedRepository2;
    }

    public String getStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        $jacocoInit[5] = true;
        return str;
    }

    public String getStoreTheme() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeTheme;
        $jacocoInit[6] = true;
        return str;
    }

    public String getTag() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.tag;
        $jacocoInit[7] = true;
        return str;
    }

    public StoreContext getStoreContext() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreContext storeContext2 = this.storeContext;
        $jacocoInit[8] = true;
        return storeContext2;
    }
}
