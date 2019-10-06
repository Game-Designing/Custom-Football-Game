package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.home.ChipManager;
import p005cm.aptoide.p006pt.home.Home;
import p005cm.aptoide.p006pt.home.HomeAnalytics;
import p005cm.aptoide.p006pt.home.HomeContainerNavigator;
import p005cm.aptoide.p006pt.home.HomeContainerPresenter;
import p005cm.aptoide.p006pt.home.HomeNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesHomeContainerPresenterFactory */
public final class FragmentModule_ProvidesHomeContainerPresenterFactory implements C13181b<HomeContainerPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<ChipManager> chipManagerProvider;
    private final Provider<CrashReport> crashReportProvider;
    private final Provider<HomeAnalytics> homeAnalyticsProvider;
    private final Provider<HomeContainerNavigator> homeContainerNavigatorProvider;
    private final Provider<HomeNavigator> homeNavigatorProvider;
    private final Provider<Home> homeProvider;
    private final FragmentModule module;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4078843102164603781L, "cm/aptoide/pt/view/FragmentModule_ProvidesHomeContainerPresenterFactory", 14);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesHomeContainerPresenterFactory(FragmentModule module2, Provider<CrashReport> crashReportProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<HomeContainerNavigator> homeContainerNavigatorProvider2, Provider<HomeNavigator> homeNavigatorProvider2, Provider<HomeAnalytics> homeAnalyticsProvider2, Provider<Home> homeProvider2, Provider<ChipManager> chipManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.crashReportProvider = crashReportProvider2;
        this.accountManagerProvider = accountManagerProvider2;
        this.homeContainerNavigatorProvider = homeContainerNavigatorProvider2;
        this.homeNavigatorProvider = homeNavigatorProvider2;
        this.homeAnalyticsProvider = homeAnalyticsProvider2;
        this.homeProvider = homeProvider2;
        this.chipManagerProvider = chipManagerProvider2;
        $jacocoInit[0] = true;
    }

    public HomeContainerPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<CrashReport> provider = this.crashReportProvider;
        $jacocoInit[1] = true;
        CrashReport crashReport = (CrashReport) provider.get();
        Provider<AptoideAccountManager> provider2 = this.accountManagerProvider;
        $jacocoInit[2] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider2.get();
        Provider<HomeContainerNavigator> provider3 = this.homeContainerNavigatorProvider;
        $jacocoInit[3] = true;
        HomeContainerNavigator homeContainerNavigator = (HomeContainerNavigator) provider3.get();
        Provider<HomeNavigator> provider4 = this.homeNavigatorProvider;
        $jacocoInit[4] = true;
        HomeNavigator homeNavigator = (HomeNavigator) provider4.get();
        Provider<HomeAnalytics> provider5 = this.homeAnalyticsProvider;
        $jacocoInit[5] = true;
        HomeAnalytics homeAnalytics = (HomeAnalytics) provider5.get();
        Provider<Home> provider6 = this.homeProvider;
        $jacocoInit[6] = true;
        Home home = (Home) provider6.get();
        Provider<ChipManager> provider7 = this.chipManagerProvider;
        $jacocoInit[7] = true;
        ChipManager chipManager = (ChipManager) provider7.get();
        $jacocoInit[8] = true;
        HomeContainerPresenter providesHomeContainerPresenter = fragmentModule.providesHomeContainerPresenter(crashReport, aptoideAccountManager, homeContainerNavigator, homeNavigator, homeAnalytics, home, chipManager);
        $jacocoInit[9] = true;
        C13182c.m43111a(providesHomeContainerPresenter, "Cannot return null from a non-@Nullable @Provides method");
        HomeContainerPresenter homeContainerPresenter = providesHomeContainerPresenter;
        $jacocoInit[10] = true;
        return homeContainerPresenter;
    }

    public static C13181b<HomeContainerPresenter> create(FragmentModule module2, Provider<CrashReport> crashReportProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<HomeContainerNavigator> homeContainerNavigatorProvider2, Provider<HomeNavigator> homeNavigatorProvider2, Provider<HomeAnalytics> homeAnalyticsProvider2, Provider<Home> homeProvider2, Provider<ChipManager> chipManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesHomeContainerPresenterFactory fragmentModule_ProvidesHomeContainerPresenterFactory = new FragmentModule_ProvidesHomeContainerPresenterFactory(module2, crashReportProvider2, accountManagerProvider2, homeContainerNavigatorProvider2, homeNavigatorProvider2, homeAnalyticsProvider2, homeProvider2, chipManagerProvider2);
        $jacocoInit[11] = true;
        return fragmentModule_ProvidesHomeContainerPresenterFactory;
    }

    public static HomeContainerPresenter proxyProvidesHomeContainerPresenter(FragmentModule instance, CrashReport crashReport, AptoideAccountManager accountManager, HomeContainerNavigator homeContainerNavigator, HomeNavigator homeNavigator, HomeAnalytics homeAnalytics, Home home, ChipManager chipManager) {
        boolean[] $jacocoInit = $jacocoInit();
        HomeContainerPresenter providesHomeContainerPresenter = instance.providesHomeContainerPresenter(crashReport, accountManager, homeContainerNavigator, homeNavigator, homeAnalytics, home, chipManager);
        $jacocoInit[12] = true;
        return providesHomeContainerPresenter;
    }
}
