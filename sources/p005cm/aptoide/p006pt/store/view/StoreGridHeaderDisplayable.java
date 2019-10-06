package p005cm.aptoide.p006pt.store.view;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.store.view.StoreGridHeaderDisplayable */
public class StoreGridHeaderDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String marketName;
    private final Model model;
    private NavigationTracker navigationTracker;
    private final StoreTabNavigator storeTabNavigator;
    private final WSWidget wsWidget;

    /* renamed from: cm.aptoide.pt.store.view.StoreGridHeaderDisplayable$Model */
    public static class Model {
        private static transient /* synthetic */ boolean[] $jacocoData;
        private boolean moreVisible = true;
        private final StoreContext storeContext;
        private final String storeTheme;
        private final String tag;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-2617748183139084175L, "cm/aptoide/pt/store/view/StoreGridHeaderDisplayable$Model", 6);
            $jacocoData = probes;
            return probes;
        }

        Model(String storeTheme2, String tag2, StoreContext storeContext2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.storeTheme = storeTheme2;
            this.tag = tag2;
            this.storeContext = storeContext2;
            $jacocoInit[0] = true;
        }

        public String getStoreTheme() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.storeTheme;
            $jacocoInit[1] = true;
            return str;
        }

        public String getTag() {
            boolean[] $jacocoInit = $jacocoInit();
            String str = this.tag;
            $jacocoInit[2] = true;
            return str;
        }

        public StoreContext getStoreContext() {
            boolean[] $jacocoInit = $jacocoInit();
            StoreContext storeContext2 = this.storeContext;
            $jacocoInit[3] = true;
            return storeContext2;
        }

        public boolean isMoreVisible() {
            boolean[] $jacocoInit = $jacocoInit();
            boolean z = this.moreVisible;
            $jacocoInit[4] = true;
            return z;
        }

        public void setMoreVisible(boolean moreVisible2) {
            boolean[] $jacocoInit = $jacocoInit();
            this.moreVisible = moreVisible2;
            $jacocoInit[5] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3130029706327408719L, "cm/aptoide/pt/store/view/StoreGridHeaderDisplayable", 11);
        $jacocoData = probes;
        return probes;
    }

    public StoreGridHeaderDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        this(null, null, null, null, null, null, null);
        $jacocoInit[0] = true;
    }

    public StoreGridHeaderDisplayable(String marketName2, WSWidget wsWidget2, String storeTheme, String tag, StoreContext storeContext, StoreTabNavigator storeTabNavigator2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
        this.model = new Model(storeTheme, tag, storeContext);
        this.wsWidget = wsWidget2;
        this.storeTabNavigator = storeTabNavigator2;
        this.navigationTracker = navigationTracker2;
        this.marketName = marketName2;
        $jacocoInit[2] = true;
    }

    public StoreGridHeaderDisplayable(String marketName2, WSWidget wsWidget2, StoreTabNavigator storeTabNavigator2, NavigationTracker navigationTracker2) {
        boolean[] $jacocoInit = $jacocoInit();
        this(marketName2, wsWidget2, null, null, null, storeTabNavigator2, navigationTracker2);
        $jacocoInit[3] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[4] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[5] = true;
        return C1375R.layout.displayable_grid_header;
    }

    public WSWidget getWsWidget() {
        boolean[] $jacocoInit = $jacocoInit();
        WSWidget wSWidget = this.wsWidget;
        $jacocoInit[6] = true;
        return wSWidget;
    }

    public StoreTabNavigator getStoreTabNavigator() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreTabNavigator storeTabNavigator2 = this.storeTabNavigator;
        $jacocoInit[7] = true;
        return storeTabNavigator2;
    }

    public Model getModel() {
        boolean[] $jacocoInit = $jacocoInit();
        Model model2 = this.model;
        $jacocoInit[8] = true;
        return model2;
    }

    public NavigationTracker getNavigationTracker() {
        boolean[] $jacocoInit = $jacocoInit();
        NavigationTracker navigationTracker2 = this.navigationTracker;
        $jacocoInit[9] = true;
        return navigationTracker2;
    }

    public String getMarketName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.marketName;
        $jacocoInit[10] = true;
        return str;
    }
}
