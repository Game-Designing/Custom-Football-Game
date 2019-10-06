package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.AnalyticsManager;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.analytics.FirstLaunchAnalytics;
import p005cm.aptoide.p006pt.analytics.view.AnalyticsActivity_MembersInjector;
import p005cm.aptoide.p006pt.navigator.ActivityResultNavigator_MembersInjector;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.view.BackButtonActivity_MembersInjector */
public final class BackButtonActivity_MembersInjector implements C13183b<BackButtonActivity> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<FirstLaunchAnalytics> firstLaunchAnalyticsProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<String> themeProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5736656618815871941L, "cm/aptoide/pt/view/BackButtonActivity_MembersInjector", 13);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((BackButtonActivity) obj);
        $jacocoInit[12] = true;
    }

    public BackButtonActivity_MembersInjector(Provider<AccountNavigator> accountNavigatorProvider2, Provider<String> marketNameProvider2, Provider<String> themeProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<FirstLaunchAnalytics> firstLaunchAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountNavigatorProvider = accountNavigatorProvider2;
        this.marketNameProvider = marketNameProvider2;
        this.themeProvider = themeProvider2;
        this.analyticsManagerProvider = analyticsManagerProvider2;
        this.firstLaunchAnalyticsProvider = firstLaunchAnalyticsProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<BackButtonActivity> create(Provider<AccountNavigator> accountNavigatorProvider2, Provider<String> marketNameProvider2, Provider<String> themeProvider2, Provider<AnalyticsManager> analyticsManagerProvider2, Provider<FirstLaunchAnalytics> firstLaunchAnalyticsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        BackButtonActivity_MembersInjector backButtonActivity_MembersInjector = new BackButtonActivity_MembersInjector(accountNavigatorProvider2, marketNameProvider2, themeProvider2, analyticsManagerProvider2, firstLaunchAnalyticsProvider2);
        $jacocoInit[1] = true;
        return backButtonActivity_MembersInjector;
    }

    public void injectMembers(BackButtonActivity instance) {
        boolean[] $jacocoInit = $jacocoInit();
        Provider<AccountNavigator> provider = this.accountNavigatorProvider;
        $jacocoInit[2] = true;
        AccountNavigator accountNavigator = (AccountNavigator) provider.get();
        $jacocoInit[3] = true;
        ActivityResultNavigator_MembersInjector.injectAccountNavigator(instance, accountNavigator);
        $jacocoInit[4] = true;
        ActivityResultNavigator_MembersInjector.injectMarketName(instance, (String) this.marketNameProvider.get());
        $jacocoInit[5] = true;
        ActivityResultNavigator_MembersInjector.injectTheme(instance, (String) this.themeProvider.get());
        Provider<AnalyticsManager> provider2 = this.analyticsManagerProvider;
        $jacocoInit[6] = true;
        AnalyticsManager analyticsManager = (AnalyticsManager) provider2.get();
        $jacocoInit[7] = true;
        AnalyticsActivity_MembersInjector.injectAnalyticsManager(instance, analyticsManager);
        Provider<FirstLaunchAnalytics> provider3 = this.firstLaunchAnalyticsProvider;
        $jacocoInit[8] = true;
        FirstLaunchAnalytics firstLaunchAnalytics = (FirstLaunchAnalytics) provider3.get();
        $jacocoInit[9] = true;
        AnalyticsActivity_MembersInjector.injectFirstLaunchAnalytics(instance, firstLaunchAnalytics);
        $jacocoInit[10] = true;
        ThemedActivityView_MembersInjector.injectTheme(instance, (String) this.themeProvider.get());
        $jacocoInit[11] = true;
    }
}
