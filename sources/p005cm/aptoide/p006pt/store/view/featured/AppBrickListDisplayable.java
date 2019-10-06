package p005cm.aptoide.p006pt.store.view.featured;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;

/* renamed from: cm.aptoide.pt.store.view.featured.AppBrickListDisplayable */
public class AppBrickListDisplayable extends DisplayablePojo<App> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private NavigationTracker navigationTracker;
    private StoreContext storeContext;
    private String tag;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7631804817371614683L, "cm/aptoide/pt/store/view/featured/AppBrickListDisplayable", 7);
        $jacocoData = probes;
        return probes;
    }

    public AppBrickListDisplayable() {
        $jacocoInit()[0] = true;
    }

    public AppBrickListDisplayable(App pojo, String tag2, NavigationTracker navigationTracker2, StoreContext storeContext2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        this.tag = tag2;
        this.navigationTracker = navigationTracker2;
        this.storeContext = storeContext2;
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
        return C1375R.layout.brick_app_item_list;
    }

    public NavigationTracker getNavigationTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[4] = true;
        return navigationTracker2;
    }

    public StoreContext getStoreContext() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreContext storeContext2 = this.storeContext;
        $jacocoInit[5] = true;
        return storeContext2;
    }

    public String getTag() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.tag;
        $jacocoInit[6] = true;
        return str;
    }
}
