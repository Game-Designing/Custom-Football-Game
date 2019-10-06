package p005cm.aptoide.p006pt.home;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.app.AppNavigator;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;

/* renamed from: cm.aptoide.pt.home.GridAppCoinsRewardAppsDisplayable */
public class GridAppCoinsRewardAppsDisplayable extends DisplayablePojo<RewardApp> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AnalyticsManager analyticsManager;
    private AppNavigator appNavigator;
    private NavigationTracker navigationTracker;
    private String tag;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5371782243237759891L, "cm/aptoide/pt/home/GridAppCoinsRewardAppsDisplayable", 10);
        $jacocoData = probes;
        return probes;
    }

    public GridAppCoinsRewardAppsDisplayable() {
        $jacocoInit()[0] = true;
    }

    public GridAppCoinsRewardAppsDisplayable(RewardApp app, String tag2, NavigationTracker navigationTracker2, AppNavigator appNavigator2, AnalyticsManager analyticsManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(app);
        this.tag = tag2;
        this.navigationTracker = navigationTracker2;
        this.appNavigator = appNavigator2;
        this.analyticsManager = analyticsManager2;
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
        return C1375R.layout.displayable_appcoins_reward_apps;
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

    public void openAppView() {
        boolean[] $jacocoInit = $jacocoInit();
        this.analyticsManager.logEvent(((RewardApp) getPojo()).getClickUrl());
        $jacocoInit[6] = true;
        AppNavigator appNavigator2 = this.appNavigator;
        long appId = ((RewardApp) getPojo()).getAppId();
        String packageName = ((RewardApp) getPojo()).getPackageName();
        String str = this.tag;
        $jacocoInit[7] = true;
        String downloadUrl = ((RewardApp) getPojo()).getDownloadUrl();
        float reward = ((RewardApp) getPojo()).getReward();
        $jacocoInit[8] = true;
        appNavigator2.navigateWithDownloadUrlAndReward(appId, packageName, str, downloadUrl, reward);
        $jacocoInit[9] = true;
    }
}
