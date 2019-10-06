package p005cm.aptoide.p006pt.app.view.displayable;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;

/* renamed from: cm.aptoide.pt.app.view.displayable.OtherVersionDisplayable */
public class OtherVersionDisplayable extends DisplayablePojo<App> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private StoreContext storeContext;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(266193627125568181L, "cm/aptoide/pt/app/view/displayable/OtherVersionDisplayable", 5);
        $jacocoData = probes;
        return probes;
    }

    public OtherVersionDisplayable() {
        $jacocoInit()[0] = true;
    }

    public OtherVersionDisplayable(App pojo, StoreContext storeContext2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        this.storeContext = storeContext2;
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
        return C1375R.layout.other_version_row;
    }

    public StoreContext getStoreContext() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreContext storeContext2 = this.storeContext;
        $jacocoInit[4] = true;
        return storeContext2;
    }
}
