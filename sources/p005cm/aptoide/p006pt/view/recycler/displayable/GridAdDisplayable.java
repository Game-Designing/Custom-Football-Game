package p005cm.aptoide.p006pt.view.recycler.displayable;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.view.recycler.displayable.GridAdDisplayable */
public class GridAdDisplayable extends DisplayablePojo<MinimalAd> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private NavigationTracker navigationTracker;
    private String tag;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7950771526460265588L, "cm/aptoide/pt/view/recycler/displayable/GridAdDisplayable", 6);
        $jacocoData = probes;
        return probes;
    }

    public GridAdDisplayable() {
        $jacocoInit()[0] = true;
    }

    public GridAdDisplayable(MinimalAd minimalAd, String tag2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(minimalAd);
        this.tag = tag2;
        this.navigationTracker = navigationTracker2;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 3, false);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.displayable_grid_ad;
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
