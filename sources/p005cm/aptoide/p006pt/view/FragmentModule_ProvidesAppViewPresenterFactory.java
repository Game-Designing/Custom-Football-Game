package p005cm.aptoide.p006pt.view;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.account.view.AccountNavigator;
import p005cm.aptoide.p006pt.app.AppViewAnalytics;
import p005cm.aptoide.p006pt.app.AppViewManager;
import p005cm.aptoide.p006pt.app.CampaignAnalytics;
import p005cm.aptoide.p006pt.app.view.AppViewNavigator;
import p005cm.aptoide.p006pt.app.view.AppViewPresenter;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.promotions.PromotionsNavigator;
import p318e.p319a.C13181b;
import p318e.p319a.C13182c;

/* renamed from: cm.aptoide.pt.view.FragmentModule_ProvidesAppViewPresenterFactory */
public final class FragmentModule_ProvidesAppViewPresenterFactory implements C13181b<AppViewPresenter> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<AppViewAnalytics> analyticsProvider;
    private final Provider<AppViewManager> appViewManagerProvider;
    private final Provider<AppViewNavigator> appViewNavigatorProvider;
    private final Provider<CampaignAnalytics> campaignAnalyticsProvider;
    private final Provider<CrashReport> crashReportProvider;
    private final FragmentModule module;
    private final Provider<PromotionsNavigator> promotionsNavigatorProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2703014798821279201L, "cm/aptoide/pt/view/FragmentModule_ProvidesAppViewPresenterFactory", 15);
        $jacocoData = probes;
        return probes;
    }

    public FragmentModule_ProvidesAppViewPresenterFactory(FragmentModule module2, Provider<AccountNavigator> accountNavigatorProvider2, Provider<AppViewAnalytics> analyticsProvider2, Provider<CampaignAnalytics> campaignAnalyticsProvider2, Provider<AppViewNavigator> appViewNavigatorProvider2, Provider<AppViewManager> appViewManagerProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<CrashReport> crashReportProvider2, Provider<PromotionsNavigator> promotionsNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.module = module2;
        this.accountNavigatorProvider = accountNavigatorProvider2;
        this.analyticsProvider = analyticsProvider2;
        this.campaignAnalyticsProvider = campaignAnalyticsProvider2;
        this.appViewNavigatorProvider = appViewNavigatorProvider2;
        this.appViewManagerProvider = appViewManagerProvider2;
        this.accountManagerProvider = accountManagerProvider2;
        this.crashReportProvider = crashReportProvider2;
        this.promotionsNavigatorProvider = promotionsNavigatorProvider2;
        $jacocoInit[0] = true;
    }

    public AppViewPresenter get() {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule fragmentModule = this.module;
        Provider<AccountNavigator> provider = this.accountNavigatorProvider;
        $jacocoInit[1] = true;
        AccountNavigator accountNavigator = (AccountNavigator) provider.get();
        Provider<AppViewAnalytics> provider2 = this.analyticsProvider;
        $jacocoInit[2] = true;
        AppViewAnalytics appViewAnalytics = (AppViewAnalytics) provider2.get();
        Provider<CampaignAnalytics> provider3 = this.campaignAnalyticsProvider;
        $jacocoInit[3] = true;
        CampaignAnalytics campaignAnalytics = (CampaignAnalytics) provider3.get();
        Provider<AppViewNavigator> provider4 = this.appViewNavigatorProvider;
        $jacocoInit[4] = true;
        AppViewNavigator appViewNavigator = (AppViewNavigator) provider4.get();
        Provider<AppViewManager> provider5 = this.appViewManagerProvider;
        $jacocoInit[5] = true;
        AppViewManager appViewManager = (AppViewManager) provider5.get();
        Provider<AptoideAccountManager> provider6 = this.accountManagerProvider;
        $jacocoInit[6] = true;
        AptoideAccountManager aptoideAccountManager = (AptoideAccountManager) provider6.get();
        Provider<CrashReport> provider7 = this.crashReportProvider;
        $jacocoInit[7] = true;
        CrashReport crashReport = (CrashReport) provider7.get();
        Provider<PromotionsNavigator> provider8 = this.promotionsNavigatorProvider;
        $jacocoInit[8] = true;
        PromotionsNavigator promotionsNavigator = (PromotionsNavigator) provider8.get();
        $jacocoInit[9] = true;
        AppViewPresenter providesAppViewPresenter = fragmentModule.providesAppViewPresenter(accountNavigator, appViewAnalytics, campaignAnalytics, appViewNavigator, appViewManager, aptoideAccountManager, crashReport, promotionsNavigator);
        $jacocoInit[10] = true;
        C13182c.m43111a(providesAppViewPresenter, "Cannot return null from a non-@Nullable @Provides method");
        AppViewPresenter appViewPresenter = providesAppViewPresenter;
        $jacocoInit[11] = true;
        return appViewPresenter;
    }

    public static C13181b<AppViewPresenter> create(FragmentModule module2, Provider<AccountNavigator> accountNavigatorProvider2, Provider<AppViewAnalytics> analyticsProvider2, Provider<CampaignAnalytics> campaignAnalyticsProvider2, Provider<AppViewNavigator> appViewNavigatorProvider2, Provider<AppViewManager> appViewManagerProvider2, Provider<AptoideAccountManager> accountManagerProvider2, Provider<CrashReport> crashReportProvider2, Provider<PromotionsNavigator> promotionsNavigatorProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentModule_ProvidesAppViewPresenterFactory fragmentModule_ProvidesAppViewPresenterFactory = new FragmentModule_ProvidesAppViewPresenterFactory(module2, accountNavigatorProvider2, analyticsProvider2, campaignAnalyticsProvider2, appViewNavigatorProvider2, appViewManagerProvider2, accountManagerProvider2, crashReportProvider2, promotionsNavigatorProvider2);
        $jacocoInit[12] = true;
        return fragmentModule_ProvidesAppViewPresenterFactory;
    }

    public static AppViewPresenter proxyProvidesAppViewPresenter(FragmentModule instance, AccountNavigator accountNavigator, AppViewAnalytics analytics, CampaignAnalytics campaignAnalytics, AppViewNavigator appViewNavigator, AppViewManager appViewManager, AptoideAccountManager accountManager, CrashReport crashReport, PromotionsNavigator promotionsNavigator) {
        boolean[] $jacocoInit = $jacocoInit();
        AppViewPresenter providesAppViewPresenter = instance.providesAppViewPresenter(accountNavigator, analytics, campaignAnalytics, appViewNavigator, appViewManager, accountManager, crashReport, promotionsNavigator);
        $jacocoInit[13] = true;
        return providesAppViewPresenter;
    }
}
