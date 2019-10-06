package p005cm.aptoide.p006pt.store.view.featured;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;

/* renamed from: cm.aptoide.pt.store.view.featured.AppBrickDisplayable */
public class AppBrickDisplayable extends DisplayablePojo<App> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private NavigationTracker navigationTracker;
    private String tag;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5888661123711192513L, "cm/aptoide/pt/store/view/featured/AppBrickDisplayable", 6);
        $jacocoData = probes;
        return probes;
    }

    public AppBrickDisplayable() {
        $jacocoInit()[0] = true;
    }

    public AppBrickDisplayable(App pojo, String tag2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        this.tag = tag2;
        this.navigationTracker = navigationTracker2;
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
        return C1375R.layout.brick_app_item;
    }

    public NavigationTracker getNavigationTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[4] = true;
        return navigationTracker2;
    }

    public String getTag() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.tag;
        $jacocoInit[5] = true;
        return str;
    }
}
