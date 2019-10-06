package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.view.MoreBundleManager;
import p005cm.aptoide.p006pt.app.view.MoreBundlePresenter;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.home.AdMapper;
import p005cm.aptoide.p006pt.home.ChipManager;
import p005cm.aptoide.p006pt.home.HomeAnalytics;
import p005cm.aptoide.p006pt.home.HomeNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesGetStoreWidgetsPresenterFactory */
public final class FragmentModule_ProvidesGetStoreWidgetsPresenterFactory implements C13181b<MoreBundlePresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AdMapper> adMapperProvider;
    private final Provider<BundleEvent> bundleEventProvider;
    private final Provider<ChipManager> chipManagerProvider;
    private final Provider<CrashReport> crashReportProvider;
    private final Provider<HomeAnalytics> homeAnalyticsProvider;
    private final Provider<HomeNavigator> homeNavigatorProvider;
    private final FragmentModule module;
    private final Provider<MoreBundleManager> moreBundleManagerProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(7879374519811742655L, "cm/aptoide/pt/view/FragmentModule_ProvidesGetStoreWidgetsPresenterFactory", 14);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesGetStoreWidgetsPresenterFactory(FragmentModule module2, Provider<MoreBundleManager> moreBundleManagerProvider2, Provider<CrashReport> crashReportProvider2, Provider<HomeNavigator> homeNavigatorProvider2, Provider<AdMapper> adMapperProvider2, Provider<BundleEvent> bundleEventProvider2, Provider<HomeAnalytics> homeAnalyticsProvider2, Provider<ChipManager> chipManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.moreBundleManagerProvider = moreBundleManagerProvider2;
        this.crashReportProvider = crashReportProvider2;
        this.homeNavigatorProvider = homeNavigatorProvider2;
        this.adMapperProvider = adMapperProvider2;
        this.bundleEventProvider = bundleEventProvider2;
        this.homeAnalyticsProvider = homeAnalyticsProvider2;
        this.chipManagerProvider = chipManagerProvider2;
        $jacocoInit[0] = true;
    }

    public MoreBundlePresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<MoreBundleManager> provider = this.moreBundleManagerProvider;
        $jacocoInit[1] = true;
        MoreBundleManager moreBundleManager = (MoreBundleManager) provider.get();
        Provider<CrashReport> provider2 = this.crashReportProvider;
        $jacocoInit[2] = true;
        CrashReport crashReport = (CrashReport) provider2.get();
        Provider<HomeNavigator> provider3 = this.homeNavigatorProvider;
        $jacocoInit[3] = true;
        HomeNavigator homeNavigator = (HomeNavigator) provider3.get();
        Provider<AdMapper> provider4 = this.adMapperProvider;
        $jacocoInit[4] = true;
        AdMapper adMapper = (AdMapper) provider4.get();
        Provider<BundleEvent> provider5 = this.bundleEventProvider;
        $jacocoInit[5] = true;
        BundleEvent bundleEvent = (BundleEvent) provider5.get();
        Provider<HomeAnalytics> provider6 = this.homeAnalyticsProvider;
        $jacocoInit[6] = true;
        HomeAnalytics homeAnalytics = (HomeAnalytics) provider6.get();
        Provider<ChipManager> provider7 = this.chipManagerProvider;
        $jacocoInit[7] = true;
        ChipManager chipManager = (ChipManager) provider7.get();
        $jacocoInit[8] = true;
        MoreBundlePresenter providesGetStoreWidgetsPresenter = fragmentModule.providesGetStoreWidgetsPresenter(moreBundleManager, crashReport, homeNavigator, adMapper, bundleEvent, homeAnalytics, chipManager);
        $jacocoInit[9] = true;
        C13182c.m43111a(providesGetStoreWidgetsPresenter, "Cannot return null from a non-@Nullable @Provides method");
        MoreBundlePresenter moreBundlePresenter = providesGetStoreWidgetsPresenter;
        $jacocoInit[10] = true;
        return moreBundlePresenter;
    }

    public static C13181b<MoreBundlePresenter> create(FragmentModule module2, Provider<MoreBundleManager> moreBundleManagerProvider2, Provider<CrashReport> crashReportProvider2, Provider<HomeNavigator> homeNavigatorProvider2, Provider<AdMapper> adMapperProvider2, Provider<BundleEvent> bundleEventProvider2, Provider<HomeAnalytics> homeAnalyticsProvider2, Provider<ChipManager> chipManagerProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesGetStoreWidgetsPresenterFactory fragmentModule_ProvidesGetStoreWidgetsPresenterFactory = new FragmentModule_ProvidesGetStoreWidgetsPresenterFactory(module2, moreBundleManagerProvider2, crashReportProvider2, homeNavigatorProvider2, adMapperProvider2, bundleEventProvider2, homeAnalyticsProvider2, chipManagerProvider2);
        $jacocoInit[11] = true;
        return fragmentModule_ProvidesGetStoreWidgetsPresenterFactory;
    }

    public static MoreBundlePresenter proxyProvidesGetStoreWidgetsPresenter(FragmentModule instance, MoreBundleManager moreBundleManager, CrashReport crashReport, HomeNavigator homeNavigator, AdMapper adMapper, BundleEvent bundleEvent, HomeAnalytics homeAnalytics, ChipManager chipManager) {
        boolean[] $jacocoInit = $jacocoInit();
        MoreBundlePresenter providesGetStoreWidgetsPresenter = instance.providesGetStoreWidgetsPresenter(moreBundleManager, crashReport, homeNavigator, adMapper, bundleEvent, homeAnalytics, chipManager);
        $jacocoInit[12] = true;
        return providesGetStoreWidgetsPresenter;
    }
}
